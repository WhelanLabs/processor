package com.whelanlabs.processor;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

/**
 * Hello world!
 *
 * see: https://www.baeldung.com/groovy-java-applications see:
 * https://docs.groovy-lang.org/latest/html/documentation/guide-integrating.html
 */
public class App {

	private final GroovyClassLoader loader;

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	private Double addWithGroovyClassLoader(int x, int y)
			throws IllegalAccessException, InstantiationException, IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> calcClass = loader.parseClass(new File("src/main/groovy/com/baeldung/", "CalcMath.groovy"));
		GroovyObject calc = (GroovyObject) calcClass.getDeclaredConstructor().newInstance();
		return (Double) calc.invokeMethod("calcSum", new Object[] { x, y });
	}

	public App() {
		loader = new GroovyClassLoader(this.getClass().getClassLoader());
	}
}
