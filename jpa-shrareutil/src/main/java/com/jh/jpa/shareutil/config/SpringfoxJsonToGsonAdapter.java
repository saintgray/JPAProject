package com.jh.jpa.shareutil.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
public class SpringfoxJsonToGsonAdapter implements JsonSerializer<Json> {
    public SpringfoxJsonToGsonAdapter() {}
    public JsonElement serialize(Json json, Type typeOfSrc, JsonSerializationContext context){
        return JsonParser.parseString(json.value());
    }
}
