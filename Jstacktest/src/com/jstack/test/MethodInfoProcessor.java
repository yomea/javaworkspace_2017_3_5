package com.jstack.test;

import java.util.HashMap;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes({ "com.jstack.test.MethodInfo" })
public class MethodInfoProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
		HashMap<String, String> map = new HashMap<String, String>();
		for (javax.lang.model.element.TypeElement typeElement : annotations) {
			for (Element element : env.getElementsAnnotatedWith(typeElement)) {
				MethodInfo methodInfo = element.getAnnotation(MethodInfo.class);
				map.put(element.getEnclosingElement().toString(), methodInfo.author());
			}
		}
		return false;
	}
}