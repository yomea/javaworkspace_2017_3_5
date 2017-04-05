package com.gson.builder;

import java.lang.reflect.Modifier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ModifierSample {
    final String finalField = "final";
    static String staticField = "static";
    public String publicField = "public";
    protected String protectedField = "protected";
    String defaultField = "default";
    private String privateField = "private";
    
    
    
    public static void main(String[] args) {
    	ModifierSample ms = new ModifierSample();
    	
    	Gson gson = new GsonBuilder()
    			.excludeFieldsWithModifiers(Modifier.FINAL,Modifier.STATIC)
    			.setPrettyPrinting()
    			.create();
    	
    	String str = gson.toJson(ms);
    	
    	System.out.println(str);
    }
    
}
