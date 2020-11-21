package com.jeesite.common.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.io.PropertiesUtils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import java.util.Date;

public class JsonMapper extends ObjectMapper{
    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);
    private static JsonMapper mapper;

    public JsonMapper() {
        this(JsonInclude.Include.NON_EMPTY);
        (new Jackson2ObjectMapperBuilder()).configure(this);
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        setTimeZone(TimeZone.getTimeZone(PropertiesUtils.getInstance().getProperty("lang.defaultTimeZone", "GMT+08:00")));
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
                jgen.writeString("");
            }
        });
    }






    public JsonMapper(JsonInclude.Include include) {
        if (include != null) {
            setSerializationInclusion(include);
        }

        enableSimple();

        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // 空值处理为空串
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){
            @Override
            public void serialize(Object value, JsonGenerator jgen,
                                  SerializerProvider provider) throws IOException,
                    JsonProcessingException {
                jgen.writeString("");
            }
        });
        // 进行HTML解码。
        this.registerModule(new SimpleModule().addSerializer(String.class, new JsonSerializer<String>(){
            @Override
            public void serialize(String value, JsonGenerator jgen,
                                  SerializerProvider provider) throws IOException,
                    JsonProcessingException {
                jgen.writeString(StringEscapeUtils.unescapeHtml4(value));
            }
        }));
        this.registerModule(new SimpleModule().addSerializer(Date.class, new JsonSerializer<Date>(){
            @Override
            public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
                    throws IOException, JsonProcessingException {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = formatter.format(value);
                jgen.writeString(formattedDate);
            }
        }));
        setTimeZone(TimeZone.getDefault());
    }


    public String toJsonString(Object object) {
        try {
            return writeValueAsString(object);
        } catch (IOException var3) {
            logger.warn("write to json string error:" + object, var3);
            return null;
        }
    }

    public String toJsonString(Object object, Class<?> jsonView) {
        try {
            return writerWithView(jsonView).writeValueAsString(object);
        } catch (IOException var4) {
            logger.warn("write to json string error:" + object, var4);
            return null;
        }
    }


    public String toJsonpString(String functionName, Object object) { return toJsonString(new JSONPObject(functionName, object)); }


    public <T> T fromJsonString(String jsonString, Class<T> clazz) {
        if (!StringUtils.isEmpty(jsonString) && !"<CLOB>".equals(jsonString)) {
            try {
                return (T)readValue(jsonString, clazz);
            } catch (IOException var4) {
                logger.warn("parse json string error:" + jsonString, var4);
                return null;
            }
        }
        return null;
    }


    public <T> T fromJsonString(String jsonString, JavaType javaType) {
        if (!StringUtils.isEmpty(jsonString) && !"<CLOB>".equals(jsonString)) {
            try {
                return (T)readValue(jsonString, javaType);
            } catch (IOException var4) {
                logger.warn("parse json string error:" + jsonString, var4);
                return null;
            }
        }
        return null;
    }



    public JavaType createCollectionType(Class<?> collectionClass, Class... elementClasses) { return getTypeFactory().constructParametricType(collectionClass, elementClasses); }


    public <T> T update(String jsonString, T object) {
        try {
            return (T)readerForUpdating(object).readValue(jsonString);
        } catch (JsonProcessingException var4) {
            logger.warn("update json string:" + jsonString + " to object:" + object + " error.", var4);
        } catch (Exception var5) {
            logger.warn("update json string:" + jsonString + " to object:" + object + " error.", var5);
        }

        return null;
    }

    public JsonMapper enableEnumUseToString() {
        enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        return this;
    }

    public JsonMapper enableJaxbAnnotation() {
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        registerModule(module);
        return this;
    }


    public ObjectMapper getMapper() { return this; }



    public static JsonMapper getInstance() {
        if (mapper == null){
            mapper = new JsonMapper().enableSimple();
        }
        return mapper;
    }



    public static String toJson(Object object) { return getInstance().toJsonString(object); }



    public static String toJson(Object object, Class<?> jsonView) { return getInstance().toJsonString(object, jsonView); }



    public static String toJsonp(String functionName, Object object) { return getInstance().toJsonpString(functionName, object); }



    public static <T> Object fromJson(String jsonString, Class<?> clazz) { return getInstance().fromJsonString(jsonString, clazz); }


    public static List<Map<String, Object>> fromJsonForMapList(String jsonString) {
        List<Map<String, Object>> result = ListUtils.newArrayList();
        if (StringUtils.startsWith(jsonString, "{")) {
            Map<String, Object> map = (Map)fromJson(jsonString, Map.class);
            if (map != null) {
                result.add(map);
            }
        } else if (StringUtils.startsWith(jsonString, "[")) {
            List<Map<String, Object>> list = (List)fromJson(jsonString, List.class);
            if (list != null) {
                result = list;
            }
        }

        return result;
    }

    public JsonMapper enableSimple() {
        configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return this;
    }
}
