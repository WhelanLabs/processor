package com.whelanlabs.processor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

   private static Logger logger = LogManager.getLogger(AppTest.class);
   
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      logger.debug("begin AppTest.setUpBeforeClass()");
   }

   @AfterClass
   public static void tearDownAfterClass() throws Exception {
   }

   @Test
   public void sayHello_usingHelloWorld_success() throws Exception {
      App app = new App();
      String result = (String) app.sayHello("HelloWorld.groovy");
      assert ("hello world".equals(result)) : "result = " + result;
   }
   
   @Test
   public void sayHello_usingHelloMars_success() throws Exception {
      App app = new App();
      String result = (String) app.sayHello("HelloMars.groovy");
      assert ("hello Mars".equals(result)) : "result = " + result;
   }
   
   /* TODO: make this so that it requires that all classes are 
    * explicitly loaded, not using the parent classpath.
    */
   @Test
   public void sayHello_usingHelloMars2_success() throws Exception {
      App app = new App();
      //String result1 = (String) app.sayHello("HelloWorld.groovy");
      String result2 = (String) app.sayHello("HelloMars2.groovy");
      assert ("hello world from Mars!".equals(result2)) : "result = " + result2;
   }
}
