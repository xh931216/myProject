package com.mzrd.util;
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
  
public class SHAUtil {  
      
    public byte[] eccrypt1(String info) throws NoSuchAlgorithmException{  
        MessageDigest md5 = MessageDigest.getInstance("SHA");  
        byte[] srcBytes = info.getBytes();  
        //ʹ��srcBytes����ժҪ  
        md5.update(srcBytes);  
        //��ɹ�ϣ���㣬�õ�result  
        byte[] resultBytes = md5.digest();  
        return resultBytes;  
    }  
  
    /** 
     * @param args 
     * @throws NoSuchAlgorithmException  
     */  
   public String getPassword1(String pass) throws NoSuchAlgorithmException {  
        byte[] resultBytes = eccrypt1(pass); 
        return new String(resultBytes);  
    } 
    public static void main(String[] args) {
    	SHAUtil sa =new SHAUtil();
    	 byte[] resultBytes = null;
		try {
			resultBytes = sa.eccrypt1("123");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         System.out.println(new String(resultBytes)); 
	}
    public String getPasswordOne() throws NoSuchAlgorithmException{
    	return getPassword("123456");
    }
    /**
     * ���ַ���md5����(��д+����)
     *
     * @param str ����Ҫ���ܵ��ַ���
     * @return  MD5���ܺ���ַ���
     */
    public String getPassword(String s){
    	 char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    	 try {           
    		 byte[] btInput = s.getBytes();            
    		 // ���MD5ժҪ�㷨�� MessageDigest ����            
    		 MessageDigest mdInst = MessageDigest.getInstance("MD5");            
    		 // ʹ��ָ�����ֽڸ���ժҪ            
    		 mdInst.update(btInput);            
    		 // �������           
    		 byte[] md = mdInst.digest();            
    		 // ������ת����ʮ�����Ƶ��ַ�����ʽ            
    		 int j = md.length;            
    		 char str[] = new char[j * 2];            
    		 int k = 0;            
    		 for (int i = 0; i < j; i++) {               
    			 byte byte0 = md[i];                
    			 str[k++] = hexDigits[byte0 >>> 4 & 0xf];                
    			 str[k++] = hexDigits[byte0 & 0xf];            
    		 }            
    		 return new String(str);        
    	} catch (Exception e) {           
    		e.printStackTrace();           
    		return null;       
    	} 
    }
}  
