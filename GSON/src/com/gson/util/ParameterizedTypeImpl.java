package com.gson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ParameterizedTypeImpl implements ParameterizedType {
	
	private final Class<?> raw;
    private final Type[] args;
    public ParameterizedTypeImpl(Class<?> raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }
    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }
    @Override
    public Type getRawType() {
        return raw;
    }
    //值外部类的类型
    @Override
	public Type getOwnerType() {
		return null;
	}

}
