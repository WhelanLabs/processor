package com.whelanlabs.processor.scripts;

import com.whelanlabs.processor.type.Planet;
import com.whelanlabs.processor.Parent;


public class HelloWorld extends Parent implements Planet {

   public String sayHello(Object[] args) {
      String ending = getEnding();
      return "hello world" + ending;
   }
   
}
