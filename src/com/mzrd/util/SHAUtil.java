package com.mzrd.util;
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
  
public class SHAUtil {  
      
    public byte[] eccrypt(String info) throws NoSuchAlgorithmException{  
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
   public String getPassword(String pass) throws NoSuchAlgorithmException {  
        byte[] resultBytes = eccrypt(pass); 
        return new String(resultBytes);  
    } 
    public static void main(String[] args) {
    	SHAUtil sa =new SHAUtil();
    	 byte[] resultBytes = null;
		try {
			resultBytes = sa.eccrypt("123");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         System.out.println(new String(resultBytes)); 
	}
}  
