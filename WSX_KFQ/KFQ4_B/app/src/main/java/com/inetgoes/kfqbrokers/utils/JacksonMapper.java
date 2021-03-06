package com.inetgoes.kfqbrokers.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * jackson解析封装
 * Created by czz on 2015/11/4.
 */
public class JacksonMapper {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static JacksonMapper jacksonMapper = null;

    private JacksonMapper() {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    public static JacksonMapper getInstance() {
        if (jacksonMapper == null) {
            synchronized (JacksonMapper.class) {
                if (jacksonMapper == null) {
                    jacksonMapper = new JacksonMapper();
                }
            }
        }
        return jacksonMapper;
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    /**
     * 解析单一的值
     *
     * @param json
     * @param fileName
     * @return
     */
    public String onlyTNode(String json, String fileName) {
        try {
            JsonNode jsonNode = mapper.readTree(json);
            return jsonNode.get(fileName).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 以键值对Map集合解析
     *
     * @param json
     * @return
     */
    public Map<String, String> mapFromJson(String json) {
        try {
            Map<String, String> map = mapper.readValue(json, Map.class);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 以键值对Map集合解析
     *
     * @param json
     * @return
     */
    public Map<String, Object> mapObjFromJson(String json) {
        try {
            Map<String, Object> map = mapper.readValue(json, Map.class);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 以对象解析
     *
     * @param json
     * @param c
     * @param <T>
     * @return
     */
    public <T> T fromJson(String json, Collection<T> c) {
        try {
            return (T) mapper.readValue(json, c.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> collectionfromJson(String json,Class<T> itemclass){

        try {
            JavaType javaType=mapper.getTypeFactory().constructParametricType(List.class, itemclass);
            return  (List<T>)mapper.readValue(json,javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取泛型的Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}
