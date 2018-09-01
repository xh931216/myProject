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
	//�ļ����浽��������
	 public String saveFile( MultipartFile uploadFile) throws IOException {  
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
	        String res = sdf.format(new Date());
	        //uploads�ļ���λ��
	        String rootPath ="E:/eclipseWeb/mzrdProject/WebContent/assets/";
	        //ԭʼ����
	        String originalFilename = uploadFile.getOriginalFilename();
	        //�µ��ļ�����
	        String newFileName = res+originalFilename.substring(originalFilename.lastIndexOf("."));
	        //���������ļ���
	        Calendar date = Calendar.getInstance();
	        File dateDirs = new File(date.get(Calendar.YEAR)
	            + File.separator + (date.get(Calendar.MONTH)+1));
	        //���ļ�
	        File newFile = new File(rootPath+File.separator+dateDirs+File.separator+newFileName);
	        //�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����
	        if(!newFile.getParentFile().exists()) {
	            //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼
	            newFile.getParentFile().mkdirs();
	        }
	        //���ڴ��е�����д�����
	        uploadFile.transferTo(newFile);
	        //������url
	        String fileUrl =  rootPath+date.get(Calendar.YEAR)+ "/"+(date.get(Calendar.MONTH)+1)+ "/"+ newFileName;
	        return fileUrl;
	}  
}
