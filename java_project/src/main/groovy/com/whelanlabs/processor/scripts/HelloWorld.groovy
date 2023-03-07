package com.whelanlabs.processor.scripts;

import com.whelanlabs.processor.type.Planet;

public class HelloWorld implements Planet {

   public String sayHello(Object[] args) {
      return "hello world";
   }
   
}
