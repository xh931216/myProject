package com.mzrd.util;
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
  
public class SHAUtil {  
      
    public byte[] eccrypt1(String info) throws NoSuchAlgorithmException{  
        MessageDigest md5 = MessageDigest.getInstance("SHA");  
        byte[] srcBytes = info.getBytes();  
        //使用srcBytes更新摘要  
        md5.update(srcBytes);  
        //完成哈希计算，得到result  
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
     * 对字符串md5加密(大写+数字)
     *
     * @param str 传入要加密的字符串
     * @return  MD5加密后的字符串
     */
    public String getPassword(String s){
    	 char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    	 try {           
    		 byte[] btInput = s.getBytes();            
    		 // 获得MD5摘要算法的 MessageDigest 对象            
    		 MessageDigest mdInst = MessageDigest.getInstance("MD5");            
    		 // 使用指定的字节更新摘要            
    		 mdInst.update(btInput);            
    		 // 获得密文           
    		 byte[] md = mdInst.digest();            
    		 // 把密文转换成十六进制的字符串形式            
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
