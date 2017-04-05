package com.gson;

import java.io.IOException;
import java.io.StringReader;

import com.google.gson.stream.JsonReader;

public class NoAutoTranserform {
	
	public static void main(String[] args) throws Exception {
		
		String json = "{\"id\":12,\"name\":\"youth\",\"passoword\":\"123\"}";
		
		User user = new User();
		
		JsonReader reader = new JsonReader(new StringReader(json));
		
		reader.beginObject();
		
		while(reader.hasNext()) {
			String s = reader.nextName();
		    switch (s) {
		        case "name":
		        	user.setUsername(reader.nextString());
		            break;
		        case "passoword":
		        	user.setPassword(reader.nextString());
		            break;
		        case "id":
		        	user.setId(reader.nextInt());
		            break;
			}
			
		}
		reader.endObject();
		System.out.println(user);
		reader.close();
	}

}
