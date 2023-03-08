package com.whelanlabs.processor.type;

/**
 * The Interface Planet.
 * 
 * This interface is a POC to show Groovy scripts running within the context
 * of an interface defined in the parent classloader.
 */
public interface Planet {

   /**
    * Say hello.
    *
    * @param args the args
    * @return the string
    */
   public String sayHello(Object[] args);
}
