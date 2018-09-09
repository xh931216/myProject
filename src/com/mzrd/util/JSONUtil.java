package com.mzrd.util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lb
 * @time 2017��9��14�� ����11:46:21
 */
@SuppressWarnings("unchecked")
public class JSONUtil {


    public static<T> T strToObject(String str,Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        T t = null;
        try {
        t = mapper.readValue(str, clazz);
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    //����ת��Ϊ�ַ���
    public static<T> String objectToStr(T t){
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    //����ת��ΪList����
    public  <T> List<T> strToList(String str, Class<T> clazz) {
    	System.out.println(str);
        JSONArray json = JSONArray.fromObject(str);
        JSONObject object = null;
        T t = null;
        List<T> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            object = JSONObject.fromObject(json.get(i));
            t = (T) JSONObject.toBean(object, clazz);
            System.out.println("....."+t.toString());
            list.add(t);
        }
        return list;
    }


    public static void main(String[] args) {

        /*String str = "[{\"name\":\"gg\",\"pass\":\"123\"},{\"name\":\"gg\",\"pass\":\"234\"},{\"name\":\"gg\",\"pass\":\"345\"}]";
        // List<Person> list = JSONUtil.strToList(str,Person.class);

        List<Person> list = strToList(str, Person.class);
        for (Person ps : list) {
            System.out.println(ps.getName() + ":" + ps.getPass());
        }*/
    }

}
