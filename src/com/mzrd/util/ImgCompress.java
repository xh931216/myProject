package com.mzrd.util;

import java.io.*;  
import java.util.Date;  
import java.awt.*;  
import java.awt.image.*;  
import javax.imageio.ImageIO;  
import com.sun.image.codec.jpeg.*;  
/** 
 * ͼƬѹ������ 
 * @author ����ǿ 
 */  
public class ImgCompress {  
    private Image img;  
    private int width;  
    private int height;  
    @SuppressWarnings("deprecation")  
    public static void main(String[] args) throws Exception {  
        System.out.println("��ʼ��" + new Date().toLocaleString());  
        ImgCompress imgCom = new ImgCompress("http://47.92.90.250:8080/mzrdProject/upload/2018/10/20181007153015220.jpg");  
        //ͼƬ·��
        String psth = null;
        imgCom.resizeFix(200, 200,psth);  
        System.out.println("������" + new Date().toLocaleString());  
    }  
    public static void getImgCompress(String path,String newPath) throws IOException{
    	 ImgCompress imgCom = new ImgCompress(path);  
         //ͼƬ·��
         imgCom.resizeFix(200, 200,newPath);  
    }
    /** 
     * ���캯�� 
     */  
    public ImgCompress(String fileName) throws IOException {  
        File file = new File(fileName);// �����ļ�  
        img = ImageIO.read(file);      // ����Image����  
        width = img.getWidth(null);    // �õ�Դͼ��  
        height = img.getHeight(null);  // �õ�Դͼ��  
    }  
    /** 
     * ���տ�Ȼ��Ǹ߶Ƚ���ѹ�� 
     * @param w int ����� 
     * @param h int ���߶� 
     */  
    public void resizeFix(int w, int h,String path) throws IOException {  
        if (width / height > w / h) {  
            resizeByWidth(w,path);  
        } else {  
            resizeByHeight(h,path);  
        }  
    }  
    /** 
     * �Կ��Ϊ��׼���ȱ�������ͼƬ 
     * @param w int �¿�� 
     */  
    public void resizeByWidth(int w,String path) throws IOException {  
        int h = (int) (height * w / width);  
        resize(w, h,path);  
    }  
    /** 
     * �Ը߶�Ϊ��׼���ȱ�������ͼƬ 
     * @param h int �¸߶� 
     */  
    public void resizeByHeight(int h,String path) throws IOException {  
        int w = (int) (width * h / height);  
        resize(w, h,path);  
    }  
    /** 
     * ǿ��ѹ��/�Ŵ�ͼƬ���̶��Ĵ�С 
     * @param w int �¿�� 
     * @param h int �¸߶� 
     */  
    public void resize(int w, int h,String path) throws IOException {  
        // SCALE_SMOOTH �������㷨 ��������ͼƬ��ƽ���ȵ� ���ȼ����ٶȸ� ���ɵ�ͼƬ�����ȽϺ� ���ٶ���  
        BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );   
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // ������С���ͼ  
        File destFile = new File(path);  
        FileOutputStream out = new FileOutputStream(destFile); // ������ļ���  
        // ��������ʵ��bmp��png��gifתjpg  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
        encoder.encode(image); // JPEG����  
        out.close();  
    }  
}  