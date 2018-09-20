package com.mzrd.util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.QuoteInfo;
import com.mzrd.pojo.QuoteSupplyImageInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.util.JSONUtil;
 
public class PdfUtils {
	
 
	 public static ResponseEntity<byte[]> savePdf(HttpServletResponse response,DesiredInfo di,StaffAccountInfo si,List<DesiredDetailsInfo> ddi,HttpServletRequest request) throws IOException {
		 Map<String, String> o = new HashMap<>();
		 o.put("supplier", di.getSupplier());
		 o.put("desiredId", di.getDesiredId()+"");
		 o.put("srname", di.getSupplyRankInfo().getSrname());
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 o.put("newDate", sdf.format(new Date()));
		 o.put("date", sdf.format(di.getDate()));
		 o.put("overDate", sdf.format(di.getOverDate()));
		 if(di.getRemark()!=null){
		 o.put("remark", di.getRemark());
		 }
		 if(si.getSname()!=null){
			 o.put("sname", si.getSname());
		 }
		 if(si.getPhone()!=null){
			 o.put("phone", si.getPhone());
		 }
		 for(int i=0;i<ddi.size();i++){
			 o.put("fill_"+(i*5+1), ddi.get(i).getDename());
			 o.put("fill_"+(i*5+2), ddi.get(i).getGuige());
			 o.put("fill_"+(i*5+3), ddi.get(i).getNumber()+"");
			 o.put("fill_"+(i*5+4), ddi.get(i).getUnit());
			 if(ddi.get(i).getBeizhu()!=null ){
				 o.put("fill_"+(i*5+5), ddi.get(i).getBeizhu());
			 }
		 }
        return fillTemplate(response,o,o.get("desiredId")+"ѯ�۵�","desired.pdf",request);
    }
	 public static ResponseEntity<byte[]> saveQuotePdf(HttpServletResponse response,SupplyAccountInfo supplyInfo,DesiredInfo di,StaffAccountInfo si,List<DesiredDetailsInfo> ddi,
			 HttpServletRequest request,String shareItemDatas,String quoteDate) throws IOException {
		 Map<String, String> o = new HashMap<>();
		 o.put("supplier", di.getSupplier());
		 o.put("desiredId", di.getDesiredId()+"");
		 o.put("srname", di.getSupplyRankInfo().getSrname());
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 o.put("newDate", sdf.format(new Date()));
		 o.put("date", sdf.format(di.getDate()));
		 o.put("overDate", sdf.format(di.getOverDate()));
		 if(quoteDate!=null){
			 o.put("quoteDate", quoteDate+"");
		 }
		 if(di.getRemark()!=null){
			 o.put("remark", di.getRemark());
		 }
		 if(si.getSname()!=null){
			 o.put("sname", si.getSname());
		 }
		 if(si.getPhone()!=null){
			 o.put("phone", si.getPhone());
		 }
		 if(supplyInfo.getPhone()!=null){
			 o.put("phone1", supplyInfo.getPhone());
		 }
		 if(supplyInfo.getContact()!=null){
			 o.put("contact", supplyInfo.getContact());
		 }
		 if(supplyInfo.getEmail()!=null){
			 o.put("email", supplyInfo.getEmail());
		 }
		 if(supplyInfo.getAbbreviation()!=null){
			 o.put("abbreviation", supplyInfo.getAbbreviation());
		 }
		 for(int i=0;i<ddi.size();i++){
			 o.put("fill_"+(i*7+1), ddi.get(i).getDename());
			 o.put("fill_"+(i*7+2), ddi.get(i).getGuige());
			 o.put("fill_"+(i*7+3), ddi.get(i).getNumber()+"");
			 o.put("fill_"+(i*7+4), ddi.get(i).getUnit());
			 if(ddi.get(i).getBeizhu()!=null ){
				 o.put("fill_"+(i*7+5), ddi.get(i).getBeizhu());
			 }
		 }

		JSONUtil jsonUtil = new JSONUtil();
		if(shareItemDatas!=null){
		 List<DesiredDetailsInfo> list = jsonUtil.strToList(shareItemDatas,DesiredDetailsInfo.class);
			for (int i=0;i<list.size();i++) {
				if(list.get(i).getPrice()!=null ){
					 o.put("fill_"+(i*7+6), list.get(i).getPrice());
				 }
				
				 if(list.get(i).getRemark()!=null ){
					 o.put("fill_"+(i*7+7), list.get(i).getRemark());
				 }
			}
		}
        return fillTemplate(response,o,o.get("desiredId")+"���۵�","supplyQuote.pdf",request);
    }
	 public static ResponseEntity<byte[]> saveStaffQuotePdf(HttpServletResponse response,List<DesiredDetailsInfo> ddi,
			 DesiredInfo di,StaffAccountInfo si,SupplyAccountInfo supplyInfo,
			 int state,HttpServletRequest request,QuoteSupplyImageInfo qsi) throws IOException {
		 Map<String, String> o = new HashMap<>();
		 o.put("supplier", di.getSupplier());
		 o.put("desiredId", di.getDesiredId()+"");
		 o.put("srname", di.getSupplyRankInfo().getSrname());
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 o.put("newDate", sdf.format(new Date()));
		 o.put("date", sdf.format(di.getDate()));
		 o.put("overDate", sdf.format(di.getOverDate()));
		 if(qsi.getQuoteDate()!=null){
			 o.put("quoteDate", sdf.format(qsi.getQuoteDate()));
		 }
		 if(di.getRemark()!=null){
			 o.put("remark", di.getRemark());
		 }
		 if(si.getSname()!=null){
			 o.put("sname", si.getSname());
		 }
		 if(si.getPhone()!=null){
			 o.put("phone", si.getPhone());
		 }
		 if(supplyInfo.getPhone()!=null){
			 o.put("phone1", supplyInfo.getPhone());
		 }
		 if(supplyInfo.getContact()!=null){
			 o.put("contact", supplyInfo.getContact());
		 }
		 if(supplyInfo.getEmail()!=null){
			 o.put("email", supplyInfo.getEmail());
		 }
		 if(supplyInfo.getAbbreviation()!=null){
			 o.put("abbreviation", supplyInfo.getAbbreviation());
		 }
		 
		 for (int i=0;i<ddi.size();i++) {
			 o.put("fill_"+(i*7+1), ddi.get(i).getDename());
			 o.put("fill_"+(i*7+2), ddi.get(i).getGuige());
			 o.put("fill_"+(i*7+3), ddi.get(i).getNumber()+"");
			 o.put("fill_"+(i*7+4), ddi.get(i).getUnit());
			 if(ddi.get(i).getBeizhu()!=null ){
				 o.put("fill_"+(i*7+5), ddi.get(i).getBeizhu());
			 }
			if(ddi.get(i).getPrice()!=null ){
					o.put("fill_"+(i*7+6), ddi.get(i).getPrice());
			 }
				
			if(ddi.get(i).getRemark()!=null ){
				 o.put("fill_"+(i*7+7), ddi.get(i).getRemark());
			}
		}
		
		
		Map<String,String> map2 = new HashMap();
        if(state == 1){
        	map2.put("img", qsi.getImageUrl());
		}else{
			map2.put("img", "");
		}
       // map2.put("img","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1537035541712&di=f17cfc64333ab901ea6d5546dc4734cc&imgtype=0&src=http%3A%2F%2Fbbs-fd.zol-img.com.cn%2Ft_s800x5000%2Fg5%2FM00%2F0A%2F02%2FChMkJ1mMLu6IR9HQAANvMd4yPB8AAfjtANFIV4AA29J401.jpg");
        Map<String,Object> m=new HashMap();
        m.put("datemap",o);
        m.put("imgmap",map2);
        return fillTemplateImage(response,m,o.get("desiredId"),"staffQuote.pdf",request);
    }

	// ����ģ������pdf
		public static  ResponseEntity<byte[]> fillTemplate(HttpServletResponse response,Map<String,String> data,String fileName,String pdfName,HttpServletRequest request) throws IOException {
			// ָ��������
	       System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
	                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
	        // ģ��·��  
	       String templatePath = request.getSession().getServletContext()  
	       .getRealPath("/") + "assets/pdf/"+pdfName;
	        // ���ɵ����ļ�·��  
	        String fileSaveRootPath=request.getSession().getServletContext().getRealPath("/files");
	           
	        String newPDFPath = fileSaveRootPath+"\\"+fileName+".pdf" ;
	     
			PdfReader reader;
			FileOutputStream out;
			ByteArrayOutputStream bos;
			PdfStamper stamper;
			try {
				BaseFont bf = BaseFont.createFont("c://windows//fonts//simsun.ttc,1" , BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			
				File file = new File(fileSaveRootPath); 
				if(!file.exists()){  
				    file.mkdirs();  
				} 
				out = new FileOutputStream(newPDFPath);// �����
				reader = new PdfReader(templatePath);// ��ȡpdfģ��
				bos = new ByteArrayOutputStream();
				stamper = new PdfStamper(reader, bos);
				AcroFields form = stamper.getAcroFields();
				 form.addSubstitutionFont(bf);
				 for (String key : data.keySet()) {
					 //System.out.println(key);
					 form.setField(key,data.get(key).toString());
				 }
				stamper.setFormFlattening(true);// ���Ϊfalse�����ɵ�PDF�ļ����Ա༭�����Ϊtrue�����ɵ�PDF�ļ������Ա༭
	            stamper.close();
	            Document doc = new Document();
	            Font font = new Font(bf, 32);
	            PdfCopy copy = new PdfCopy(doc, out);
	            doc.open();
	            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
	            copy.addPage(importPage);
	            doc.close();
			} catch (IOException e) {
				System.out.println(1);
			} catch (DocumentException e) {
				System.out.println(2);
			}
			 File file = new File(newPDFPath);

	        InputStream ins = null;
			try {
				ins = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        /* �����ļ�ContentType���ͣ��������ã����Զ��ж������ļ����� */
			
	        response.setContentType("application/pdf");
	        /* �����ļ�ͷ�����һ�����������������ļ��� */
	        byte[] body = null;
	        InputStream is = new FileInputStream(file);
	        body = new byte[is.available()];
	        is.read(body);
	        HttpHeaders headers = new HttpHeaders();
	       // headers.setContentDispositionFormData("attachment", downloadFielName)
	        String downloadFielName = new String(file.getName().getBytes("UTF-8"),"iso-8859-1");
	        headers.add("Content-Disposition", "attchement;filename=" + downloadFielName);
	        HttpStatus statusCode = HttpStatus.OK;
	        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
			return entity;
		}
		// ����ģ������pdf
		public static  ResponseEntity<byte[]> fillTemplateImage(HttpServletResponse response,Map<String,Object> o,String fileName,String pdfName,HttpServletRequest request) throws IOException {
			// ָ��������
	        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
	                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
	        // ģ��·��  
	        String templatePath = request.getSession().getServletContext()  
	        .getRealPath("/") + "assets/pdf/"+pdfName;
	         // ���ɵ����ļ�·��  
	        String fileSaveRootPath=request.getSession().getServletContext().getRealPath("/files");
           
	        String newPDFPath = fileSaveRootPath+"\\"+fileName+".pdf" ;
	        PdfReader reader;
	        FileOutputStream out;
	        ByteArrayOutputStream bos;
	        PdfStamper stamper;
	        try {
	            BaseFont bf = BaseFont.createFont("c://windows//fonts//simsun.ttc,1" , BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	            File file = new File(fileSaveRootPath); 
				if(!file.exists()){  
				    file.mkdirs();  
				} 
	            Font FontChinese = new Font(bf, 5, Font.NORMAL);
	            out = new FileOutputStream(newPDFPath);// �����
	            reader = new PdfReader(templatePath);// ��ȡpdfģ��  
	            bos = new ByteArrayOutputStream();
	            stamper = new PdfStamper(reader, bos);
	            AcroFields form = stamper.getAcroFields();
	            //����������ݴ���
	            Map<String,String> datemap = (Map<String,String>)o.get("datemap");
	            form.addSubstitutionFont(bf);
	            for(String key : datemap.keySet()){
	                String value = datemap.get(key);
	                form.setField(key,value);
	            }
	            //ͼƬ������ݴ���
	            Map<String,String> imgmap = (Map<String,String>)o.get("imgmap");
	            for(String key : imgmap.keySet()) {
	                String value = imgmap.get(key);
	                String imgpath = value;
	                int pageNo = form.getFieldPositions(key).get(0).page;
	                Rectangle signRect = form.getFieldPositions(key).get(0).position;
	                float x = signRect.getLeft();
	                float y = signRect.getBottom();
	                //����·����ȡͼƬ
	                Image image = Image.getInstance(imgpath);
	                //��ȡͼƬҳ��
	                PdfContentByte under = stamper.getOverContent(pageNo);
	                //ͼƬ��С����Ӧ
	                image.scaleToFit(signRect.getWidth(), signRect.getHeight());
	                //���ͼƬ
	                image.setAbsolutePosition(x, y);
	                under.addImage(image);
	            }
	            stamper.setFormFlattening(true);// ���Ϊfalse�����ɵ�PDF�ļ����Ա༭�����Ϊtrue�����ɵ�PDF�ļ������Ա༭
	            stamper.close();
	            Document doc = new Document();
	            Font font = new Font(bf, 32);
	            PdfCopy copy = new PdfCopy(doc, out);
	            doc.open();
	            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
	            copy.addPage(importPage);
	            doc.close();

	        } catch (IOException e) {
	            System.out.println(e);
	        } catch (DocumentException e) {
	            System.out.println(e);
	        }
	        File file = new File(newPDFPath);

	        InputStream ins = null;
			try {
				ins = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        /* �����ļ�ContentType���ͣ��������ã����Զ��ж������ļ����� */
			
	        response.setContentType("application/pdf");
	        /* �����ļ�ͷ�����һ�����������������ļ��� */
	        byte[] body = null;
	        InputStream is = new FileInputStream(file);
	        body = new byte[is.available()];
	        is.read(body);
	        HttpHeaders headers = new HttpHeaders();
	       // headers.setContentDispositionFormData("attachment", downloadFielName)
	        String downloadFielName = new String(file.getName().getBytes("UTF-8"),"iso-8859-1");
	        headers.add("Content-Disposition", "attchement;filename=" + downloadFielName);
	        HttpStatus statusCode = HttpStatus.OK;
	        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
			return entity;
	 
		}
}