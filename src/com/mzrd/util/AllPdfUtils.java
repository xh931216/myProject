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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.QuoteSupplyImageInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.util.JSONUtil;
 
public class AllPdfUtils {
	
	 public static void saveStaffQuotePdf(HttpServletResponse response,List<DesiredDetailsInfo> ddi,
			 DesiredInfo di,StaffAccountInfo si,SupplyAccountInfo supplyInfo,
			 int state,HttpServletRequest request,QuoteSupplyImageInfo qsi) throws IOException, COSVisitorException {
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
		System.out.println("state:"+state);
        if(state == 1 && qsi.getImageUrl()!=null&&qsi.getImageUrl()!=""){
        	map2.put("img", qsi.getImageUrl());
        	Map<String,Object> m=new HashMap();
            m.put("datemap",o);
            m.put("imgmap",map2);
            fillTemplateImage(response,m,o.get("desiredId")+"报价单"+qsi.getQiid(),"staffQuote.pdf",request);
		}else{
			fillTemplate(response,o,o.get("desiredId")+"报价单"+qsi.getQiid(),"staffQuote.pdf",request);
		}
    }

	 public static ResponseEntity<byte[]> outPdf(String[] files,HttpServletRequest request,DesiredInfo di,StaffAccountInfo si,HttpServletResponse response) throws IOException{
		 String fileSaveRootPath=request.getSession().getServletContext().getRealPath("/files");  
		 String newPDFPath1 = si.getId()+"_"+di.getDesiredId()+"_staffQuote.pdf";
		 boolean ok = mergePdfFiles(files, newPDFPath1, request);
		 if(ok==false){
			 System.out.println("合并失败");
			 return null;
		 }
		 String newPDFPath = fileSaveRootPath+"\\"+newPDFPath1 ;
		 File file = new File(newPDFPath);
	        response.setContentType("application/pdf");
	        /* 设置文件头：最后一个参数是设置下载文件名 */
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
			is.close();
			return entity;
	}

    //合并pdf
     public static boolean mergePdfFiles(String[] files, String newfile,HttpServletRequest request){  
    	 String fileSaveRootPath=request.getSession().getServletContext().getRealPath("/files");
    	 newfile = fileSaveRootPath+"\\"+newfile ;
	        boolean retValue = false;  
           Document document = null;  
         try {  
             document = new Document(new PdfReader(fileSaveRootPath+"\\"+files[0]+".pdf" ).getPageSize(1));  
             File file=new File(newfile);
             if(!file.exists()){
            	 try{
            		 file.createNewFile();
            	 }catch(IOException e){
            		 e.printStackTrace();
            	 }
             }
             System.out.println("::"+newfile);
             PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));  
             document.open();  
             for (int i = 0; i < files.length; i++) {  
            	 String newPDFPath = fileSaveRootPath+"\\"+files[i]+".pdf" ;
            	 System.out.println(newPDFPath);
                 PdfReader reader = new PdfReader(newPDFPath);  
                 int n = reader.getNumberOfPages();  
                 for (int j = 1; j <= n; j++) {  
                     document.newPage();  
                     PdfImportedPage page = copy.getImportedPage(reader, j);  
                     copy.addPage(page);  
                }  
             }  
             retValue = true;  
         } catch (Exception e) {  
             e.printStackTrace();  
         } finally {  
            document.close();  
        }  
         return retValue;  
     }  

	 // 利用模板生成pdf
		public static  void fillTemplate(HttpServletResponse response,Map<String,String> data,String fileName,String pdfName,HttpServletRequest request) throws IOException, COSVisitorException {
			// 指定解析器
	       System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
	                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
	        // 模板路径  
	       String templatePath = request.getSession().getServletContext()  
	       .getRealPath("/") + "assets/pdf/"+pdfName;
	        // 生成的新文件路径  
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
				out = new FileOutputStream(newPDFPath);// 输出流
				reader = new PdfReader(templatePath);// 读取pdf模板
				bos = new ByteArrayOutputStream();
				stamper = new PdfStamper(reader, bos);
				AcroFields form = stamper.getAcroFields();
				 form.addSubstitutionFont(bf);
				 for (String key : data.keySet()) {
					 System.out.println(key);
					 form.setField(key,data.get(key).toString());
				 }
				stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
	            stamper.close();
	            Document doc = new Document();
	            Font font = new Font(bf, 32);
	            PdfCopy copy = new PdfCopy(doc, out);
	            doc.open();
	            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
	            copy.addPage(importPage);
	            doc.close();
			} catch (IOException e) {
				System.out.println(1+",,,,");
			} catch (DocumentException e) {
				System.out.println(2);
			}
		}
				// 利用模板生成pdf
				public static  void fillTemplateImage(HttpServletResponse response,Map<String,Object> o,String fileName,String pdfName,HttpServletRequest request) throws IOException {
					// 指定解析器
			        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
			                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
			        // 模板路径  
			        String templatePath = request.getSession().getServletContext()  
			        .getRealPath("/") + "assets/pdf/"+pdfName;
			         // 生成的新文件路径  
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
			            out = new FileOutputStream(newPDFPath);// 输出流
			            reader = new PdfReader(templatePath);// 读取pdf模板  
			            bos = new ByteArrayOutputStream();
			            stamper = new PdfStamper(reader, bos);
			            AcroFields form = stamper.getAcroFields();
			            //文字类的内容处理
			            Map<String,String> datemap = (Map<String,String>)o.get("datemap");
			            form.addSubstitutionFont(bf);
			            for(String key : datemap.keySet()){
			                String value = datemap.get(key);
			                form.setField(key,value);
			            }
			            //图片类的内容处理
			            Map<String,String> imgmap = (Map<String,String>)o.get("imgmap");
			            if(imgmap.get("img")!=null){
			            for(String key : imgmap.keySet()) {
			                String value = imgmap.get(key);
			                String imgpath = value;
			                int pageNo = form.getFieldPositions(key).get(0).page;
			                Rectangle signRect = form.getFieldPositions(key).get(0).position;
			                float x = signRect.getLeft();
			                float y = signRect.getBottom();
			                //根据路径读取图片
			                Image image = Image.getInstance(imgpath);
			                //获取图片页面
			                PdfContentByte under = stamper.getOverContent(pageNo);
			                //图片大小自适应
			                image.scaleToFit(signRect.getWidth(), signRect.getHeight());
			                //添加图片
			                image.setAbsolutePosition(x, y);
			                under.addImage(image);
			            }
			            }
			            stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
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
				}
		
}