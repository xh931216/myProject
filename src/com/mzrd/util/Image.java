package com.mzrd.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Image {
	//文件保存到服务器上
	 public String saveFile( MultipartFile uploadFile) throws IOException {  
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
	        String res = sdf.format(new Date());
	        //uploads文件夹位置
	        String rootPath ="E:/eclipseWeb/mzrdProject/WebContent/assets/";
	        //原始名称
	        String originalFilename = uploadFile.getOriginalFilename();
	        //新的文件名称
	        String newFileName = res+originalFilename.substring(originalFilename.lastIndexOf("."));
	        //创建年月文件夹
	        Calendar date = Calendar.getInstance();
	        File dateDirs = new File(date.get(Calendar.YEAR)
	            + File.separator + (date.get(Calendar.MONTH)+1));
	        //新文件
	        File newFile = new File(rootPath+File.separator+dateDirs+File.separator+newFileName);
	        //判断目标文件所在的目录是否存在
	        if(!newFile.getParentFile().exists()) {
	            //如果目标文件所在的目录不存在，则创建父目录
	            newFile.getParentFile().mkdirs();
	        }
	        //将内存中的数据写入磁盘
	        uploadFile.transferTo(newFile);
	        //完整的url
	        String fileUrl =  rootPath+date.get(Calendar.YEAR)+ "/"+(date.get(Calendar.MONTH)+1)+ "/"+ newFileName;
	        return fileUrl;
	}  
}
