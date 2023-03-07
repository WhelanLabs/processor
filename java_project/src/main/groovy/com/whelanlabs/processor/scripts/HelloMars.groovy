package com.whelanlabs.processor.scripts

import com.whelanlabs.processor.type.Planet;

class HelloMars implements Planet {
   
   public String sayHello(Object[] args) {
      return "hello Mars";
   }
   
}
