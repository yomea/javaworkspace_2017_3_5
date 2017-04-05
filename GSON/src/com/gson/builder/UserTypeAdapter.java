package com.gson.builder;

import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class UserTypeAdapter extends TypeAdapter<GirlFriend> {
	 
    @Override
    public void write(JsonWriter out, GirlFriend girl) throws IOException {
        out.beginObject();
        out.name("name").value(girl.getName());
        out.name("age").value(girl.getAge());
        out.endObject();
    }
 
    @Override
    public GirlFriend read(JsonReader in) throws IOException {
    	GirlFriend girl = new GirlFriend();
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "name":
                	girl.setName(in.nextString());
                    break;
                case "age":
                	girl.setAge(in.nextInt());
                    break;
            }
        }
        in.endObject();
        return girl;
    }
    
    public static void main(String[] args) {
    	//使用自己实现的json转换，这样做，那些个注解就无效了
    	Gson gson = new GsonBuilder().registerTypeAdapter(GirlFriend.class, new UserTypeAdapter()).setPrettyPrinting().create();
    	String str = gson.toJson(new GirlFriend());
    	System.out.println(str);
    	
    	
    	Gson gson2 = new GsonBuilder()
    	        .registerTypeAdapter(Integer.class, new JsonDeserializer<Integer>() {
    	            @Override
    	            public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    	                try {
    	                    return json.getAsInt();
    	                } catch (NumberFormatException e) {
    	                    return -1;
    	                }
    	            }
    	        })
    	        .create();
    	System.out.println(gson2.toJson(100)); //结果：100
    	System.out.println(gson2.fromJson("\"\"", Integer.class)); //结果-1
    	
    	
    	
    	JsonSerializer<Number> numberJsonSerializer = new JsonSerializer<Number>() {
    	    @Override
    	    public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {
    	        return new JsonPrimitive(String.valueOf(src));
    	    }
    	};
    	Gson gson3 = new GsonBuilder()
    	        .registerTypeAdapter(Integer.class, numberJsonSerializer)
    	        .registerTypeAdapter(Long.class, numberJsonSerializer)
    	        .registerTypeAdapter(Float.class, numberJsonSerializer)
    	        .registerTypeAdapter(Double.class, numberJsonSerializer)
    	        .create();
    	System.out.println(gson.toJson(100.0f));//结果："100.0"
    	
    }

}
