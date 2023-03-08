package com.whelanlabs.processor;

import java.io.File;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

/**
 * A POC class to have a per-instance script processer with classloader separation.
 * 
 * see: https://www.baeldung.com/groovy-java-applications 
 * see: https://docs.groovy-lang.org/latest/html/documentation/guide-integrating.html
 */
public class App {

   private final GroovyClassLoader loader;

   public static void main(String[] args) {
      System.out.println("Hello World!");
   }

   public void loadGroovy(String scriptName) throws Exception {
      loader.parseClass(new File("src/main/groovy/com/whelanlabs/processor/scripts/", scriptName));
   }

   public Object sayHello(String scriptName)throws Exception {
      Class<?> calcClass = loader
            .parseClass(new File("src/main/groovy/com/whelanlabs/processor/scripts/", scriptName));
      GroovyObject g = (GroovyObject) calcClass.getDeclaredConstructor().newInstance();
      return (Object) g.invokeMethod("sayHello", new Object[] { 1, "two" });
   }

   public App() {
      loader = new GroovyClassLoader(this.getClass().getClassLoader());
   }
}
