package com.whelanlabs.processor;

import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;
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
   public void sayHelloX2_usingHelloMars2_success() throws Exception {
      App app = new App();
      app.sayHello("HelloWorld.groovy");
      String result2 = (String) app.sayHello("HelloMars2.groovy");
      assert ("hello world from Mars!".equals(result2)) : "result = " + result2;
   }
   
   @Test
   public void sayHello_usingHelloMars2_success() throws Exception {
      App app = new App();
      app.loadGroovy("HelloWorld.groovy");
      String result2 = (String) app.sayHello("HelloMars2.groovy");
      assert ("hello world from Mars!".equals(result2)) : "result = " + result2;
   }
   
   @Test
   public void sayHello_overwriteUsingHelloMars2_success() throws Exception {
      App app = new App();
      app.loadGroovy("HelloWorld.groovy");
      app.sayHello("HelloWorld.groovy");
      String result2 = (String) app.sayHello("HelloMars2.groovy");
      assert ("hello world from Mars!".equals(result2)) : "result = " + result2;
   }
   
   @Test(expected = MultipleCompilationErrorsException.class)
   public void sayHello_helloMars2Missingclass_fail() throws Exception {
      App app = new App();
      String result2 = (String) app.sayHello("HelloMars2.groovy");
      assert ("hello world from Mars!".equals(result2)) : "result = " + result2;
   }
   
   @Test
   public void sayHello_differentApps_differentResults() throws Exception {
      boolean allGood = false;
      App app1 = new App();
      App app2 = new App();
      app1.loadGroovy("HelloWorld.groovy");
      String result1 = (String) app1.sayHello("HelloMars2.groovy");
      assert ("hello world from Mars!".equals(result1)) : "result1 = " + result1;
      try {
         app2.sayHello("HelloMars2.groovy");
      }
      catch (MultipleCompilationErrorsException e) {
         allGood = true;
      }
      if(!allGood) {
         fail("Expected MultipleCompilationErrorsException is missing.");
      }
   }
}
