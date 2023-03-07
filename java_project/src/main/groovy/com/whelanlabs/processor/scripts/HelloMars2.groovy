package com.whelanlabs.processor.scripts;

import com.whelanlabs.processor.type.Planet;

class HelloMars2 implements Planet {
   
   public String sayHello(Object[] args) {
      HelloWorld earth = new HelloWorld();
      String result = earth.sayHello(args)
      return result + " from Mars!";
   }
   
}
