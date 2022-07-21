package com.jh.jpa.shareutil.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jh.jpa.shareutil.entity.vo.config.SpringfoxJsonToGsonAdapter;
import org.apache.commons.lang3.StringUtils;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
public class JsonUtil {

    private static Gson gson;
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final Type MAP_TYPE_TOKEN = new TypeToken<Map<String, Object>>() {
    }.getType();
    public static final Type HASH_MAP_TYPE_TOKEN = new TypeToken<Map<String, List<Object>>>() {
    }.getType();
    public static final Type LIST_HASH_MAP_TYPE_TOKEN = new TypeToken<HashMap<String, List<Object>>>() {
    }.getType();

    // constructor
    public JsonUtil() {}

    // methods
    public static Gson getGson() {return gson;}
    public static void setGson(Gson paramGson) { gson = paramGson; }
    public static String toJson(Object obj) { return gson.toJson(obj); }
    public static <T> T fromJson(String json, Class<T> clazz) { return gson.fromJson(json, clazz); }
    public static <T> T fromJson(String jsonString, Type type) { return gson.fromJson(jsonString, type); }
    public static <T> List<T> fromJsonList(String json, Class<T> type){
        List<T> result = null;
        if(json != null){
            if(StringUtils.isEmpty(json)){
                result = Collections.emptyList();
            }else{
                Collection<T> links = (Collection)gson.fromJson(json, new JsonUtil.ListParameterizedType(type));
                if( links != null && links.isEmpty()){
                    result = new ArrayList(links.size());
                    result.addAll(links);
                }else{
                    result = Collections.emptyList();
                }
            }
        }
        return result;
    }

    static {
        setGson(new GsonBuilder().setDateFormat(DATE_FORMAT)
                                 .registerTypeAdapter(Json.class, new SpringfoxJsonToGsonAdapter())
                                 .create());
    }

    // inner class
    private static class ListParameterizedType implements ParameterizedType{
        private Type type;
        @Override
        public Type getOwnerType() { return null; }
        public ListParameterizedType(Type type){ this.type = type; }
        public Type[] getActualTypeArguments() { return new Type[] {this.type}; }
        public Type getRawType() { return Collection.class; }
    }
}
