package com.mzrd.util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.StaffAccountInfo;
 
public class PdfUtils {
	// 利用模板生成pdf
	public static  boolean fillTemplate(Map<String,String> data,HttpServletRequest request) {
		// 指定解析器
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        
        // 模板路径  
       // String templatePath = request.getSession().getServletContext()  
       // .getRealPath("/") + "upload/"test.pdf";
        String templatePath = "E:/eclipseWeb/mzrdProject/WebContent/assets/pdf/test.pdf";
         // 生成的新文件路径  
        String newPDFPath = "d:/pdf/"+data.get("desiredId")+".pdf" ;
		PdfReader reader;
		FileOutputStream out;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try {
			BaseFont bf = BaseFont.createFont("c://windows//fonts//simsun.ttc,1" , BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		
			File file = new File("d:\\pdf"); 
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
			System.out.println(1);
			return false;
		} catch (DocumentException e) {
			System.out.println(2);
			return false;
		}
		return true;
 
	}
 
	 public static boolean savePdf(DesiredInfo di,StaffAccountInfo si,List<DesiredDetailsInfo> ddi,HttpServletRequest request) {
		 Map<String, String> o = new HashMap<>();
		 o.put("supplier", di.getSupplier());
		 o.put("desiredId", di.getDesiredId()+"");
		 o.put("srname", di.getSupplyRankInfo().getSrname());
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 o.put("newDate", sdf.format(new Date()));
		 o.put("date", sdf.format(di.getDate()));
		 o.put("overDate", sdf.format(di.getOverDate()));
		 o.put("remark", di.getRemark());
		 o.put("sname", si.getSname());
		 o.put("phone", si.getPhone());
		 for(int i=0;i<ddi.size();i++){
			 o.put("fill_"+(i*3+1), ddi.get(i).getGuige());
			 o.put("fill_"+(i*3+2), ddi.get(i).getNumber()+"");
			 o.put("fill_"+(i*3+3), ddi.get(i).getUnit());
		 }
        return fillTemplate(o,request);
    }
}