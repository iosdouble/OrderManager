package com.nh.haiyan.ordermanager.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname JsonUtil
 * @Description TODO
 * @Date 2019/8/26 10:01 AM
 * @Created by nihui
 */
public class JsonUtil {

    public static <T> String toJson(T t)  {
        if (t ==null){
            return null;
        }else {
            ObjectMapper mapper = new ObjectMapper();
            String json = null;


            try{
                json = mapper.writeValueAsString(t);
                return json;
            }catch (JsonProcessingException e){
                e.printStackTrace();
                throw new RuntimeException("toJson格式转换错误",e);
            }
        }
    }



    public static <T> String toJsonAndLongToString(T t)  {
        if (t==null){
            return null;
        }else {
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule simpleModule = new SimpleModule();
            simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
            simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
            mapper.registerModule(simpleModule);
            String json = null;
            try{
                json = mapper.writeValueAsString(t);
                return json;
            }catch (JsonProcessingException e){
                e.printStackTrace();
                throw new RuntimeException("toJsonAndLongToString转换错误",e);
            }
        }
    }


    public static <T> T toObject(String json,String path,Class<T> clazz)  {
        if (StringUtils.isBlank(json)){
            return null;
        }else {
            ObjectMapper mapper = new ObjectMapper();
            T t = null;
            if (StringUtils.isBlank(path)){
                try {
                    t = mapper.readValue(json,clazz);
                    return t;
                }catch (IOException e){
                    e.printStackTrace();
                    throw new RuntimeException("toObject格式转换错误",e);
                }
            }else {
                try{
                    JsonNode jsonRoot = mapper.readTree(json);
                    JsonNode jsonNode = jsonRoot.at(path);
                    if (jsonNode.isMissingNode()){
                        return t;
                    }else {
                        t = mapper.readValue(jsonNode.toString(),clazz);
                        return t;
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    throw new RuntimeException("toObject格式转换错误",e);
                }
            }
        }
    }


    public static <T> T toObject(String json,Class<T> clazz) {
        return StringUtils.isBlank(json)?null:toObject(json,(String)null,clazz);
    }


    public static <T> List<T> toObjectList(String json, Class<T> clazz){
        if (StringUtils.isBlank(json)){
            return null;
        }else {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,new Class[]{clazz});

            try{
                List<T> list = mapper.readValue(json,javaType);
                return list;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("toObjectList转换错误",e);
            }
        }
    }


    public static <T> List<T> toObjectList(String json,String path,Class<T> clazz){
        if (StringUtils.isBlank(json)){
            return null;
        }else {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            if (StringUtils.isBlank(path)){
                JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,new Class[]{clazz});

                try{
                    List<T> tList = mapper.readValue(json,javaType);
                    return tList;
                }catch (IOException e){
                    e.printStackTrace();
                    throw new RuntimeException("toObjectList转换错误",e);
                }
            }else {
                try{
                    JsonNode jsonRoot = mapper.readTree(json);
                    JsonNode jsonNode = jsonRoot.at(path);
                    if (jsonNode.isMissingNode()) {
                        return null;
                    }else {
                        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,new Class[]{clazz});
                        List<T> tList = mapper.readValue(jsonNode.toString(),javaType);
                        return tList;
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    throw new RuntimeException("toObjectList转换错误",e);
                }
            }
        }
    }


    public static <T,V> Map<T,V> toObjectMap(String json, Class<T> keyClazz, Class<V> valueClass){
        if (StringUtils.isBlank(json)){
            return null;
        }else {
            ObjectMapper mapper =new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(Map.class,new Class[]{keyClazz,valueClass});

            try{
                Map<T,V> map = mapper.readValue(json,javaType);
                return map;
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("toObjectMap转换错误---->"+json,e);
            }

        }
    }


    public static <T,V>  TreeMap<T,V> toObjectTreeMap(String json,Class<T> keyClass,Class<V> valueClass){
        if (StringUtils.isBlank(json)){
            return null;
        }else {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(TreeMap.class,new Class[]{keyClass,valueClass});

            try{
                TreeMap<T,V> map = mapper.readValue(json,javaType);
                return map;
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("toObjectTreeMap转换错误",e);
            }
        }
    }

    public static <T> T toObjectT(String json,Class<T> keyClazz,Class... valueClazz){
        if (StringUtils.isBlank(json)){
            return null;
        }else {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(keyClazz,valueClazz);

            try{
                T t = mapper.readValue(json,javaType);
                return t;
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("toObjectT转换错误",e);
            }
        }
    }


    public static String addJsonStrNode(String json,Map<String,Object> nodes){
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> jsonMap = null;
        String jsonResult = null;

        try{
            jsonMap = toObjectMap(json,String.class,Object.class);
            jsonMap.putAll(nodes);
            jsonResult = mapper.writeValueAsString(jsonMap);
            return jsonResult;
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("addJsonStrNode转换错误",e);
        }
    }

    public static String mergeToStr(String... jsons){
        if (jsons==null){
            return null;
        }else{
            Map<String,Object> jsonMapResutl = Maps.newHashMap();

            for (int i = 0; i < jsons.length; ++i) {
                if (StringUtils.isNoneBlank(new CharSequence[]{jsons[i]})){
                    Map<String,Object> jsonMap = toObjectMap(jsons[i],String.class,Object.class);
                    if (jsonMap!=null){
                        jsonMapResutl.putAll(jsonMap);
                    }
                }
            }

            String result = toJson(jsonMapResutl);
            return result;
        }
    }
}
