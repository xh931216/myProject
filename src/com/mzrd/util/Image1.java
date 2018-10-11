package com.mzrd.util;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

public class Image1 {
	//文件下载
	public String  downloadPicture(String urlList,String name) {
        URL url = null;
        int imageNumber = 0;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
	        String res = sdf.format(new Date());
            String imageName =  "d:/"+name+".jpg";

            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[10240];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context=output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "true";
    }
	//文件上传
	 public String saveFile( MultipartFile uploadFile,HttpServletRequest request) throws IOException {  
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
	        String res = sdf.format(new Date());
	       
	        String filePath = request.getSession().getServletContext()  
                    .getRealPath("/") + "upload/" ; 
	        //原始名称
	        String originalFilename = uploadFile.getOriginalFilename();
	        //新的文件名称
	        String newFileName = res+originalFilename.substring(originalFilename.lastIndexOf("."));
	        //创建年月文件夹
	        Calendar date = Calendar.getInstance();
	        File dateDirs = new File(date.get(Calendar.YEAR)
	            + File.separator + (date.get(Calendar.MONTH)+1));
	        String path =filePath+File.separator+dateDirs+File.separator+newFileName;
	        //新文件
	        File newFile = new File(path);
	        //判断目标文件所在的目录是否存在
	        if(!newFile.getParentFile().exists()) {
	            //如果目标文件所在的目录不存在，则创建父目录
	            newFile.getParentFile().mkdirs();
	        }
	        //将内存中的数据写入磁盘
	        uploadFile.transferTo(newFile);
	        
	        
        	ImgCompress imgCompress =new ImgCompress(path);
        	String newPath = path.substring(0,path.length()-4)+"new"+path.substring(path.length()-4);
        	imgCompress.resizeFix(200, 200,newPath);  
	        
	        //完整的url
	        String fileUrl =  request.getScheme() +"://" + request.getServerName()  
            + ":" +request.getServerPort() +request.getContextPath();
	        	fileUrl +=	"/upload/"+date.get(Calendar.YEAR)+ "/"+(date.get(Calendar.MONTH)+1)+ "/"+ newFileName;
	        return fileUrl;
	}  
}
