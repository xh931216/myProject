package com.mzrd.util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mzrd.pojo.DesiredInfo;
 
public class PdfUtils {
	// 利用模板生成pdf
	public static void fillTemplate(Map<String,String> data,String id) {
		// 指定解析器
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        
        // 模板路径  
        String templatePath = "E:/eclipseWeb/mzrdProject/WebContent/assets/pdf/test.pdf";
        // 生成的新文件路径  
        String newPDFPath = "d:/pdf/"+id+".pdf";
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
		} catch (DocumentException e) {
			System.out.println(2);
		}
 
	}
 
	 public static void savePdf(DesiredInfo di,String sname,String srname) {
		 Map<String, String> o = new HashMap<>();
		 o.put("supplier", di.getSupplier());
		 o.put("guige", di.getGuige());
		 o.put("sname", srname);
		 o.put("number", di.getNumber()+"");
		 o.put("number", di.getNumber()+"");
		 o.put("unit", di.getUnit());
		 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		 o.put("overDate", sdf1.format(di.getOverDate()));
		 o.put("desiredId", di.getDesiredId()+"");
		 o.put("srname", sname);
        fillTemplate(o,sdf.format(new Date()));
    }
}