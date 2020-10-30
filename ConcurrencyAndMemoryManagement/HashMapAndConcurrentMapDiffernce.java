import java.util.*;
class HashMapAndConcurrentMapDiffernce {
    static HashMap<Integer,String> l=new HashMap<Integer,String>(); 
    public static void main(String[] args)throws InterruptedException  {
        Runnable runnable1=()->{
            try
            { 
                Thread.sleep(2000); 
                // Child thread trying to add 
                // new element in the object 
                l.put(103,"D"); 
            } 
            catch(InterruptedException e) 
            { 
                System.out.println("Child Thread going to add element"); 
            } 
        };
        l.put(100,"A"); 
        l.put(101,"B"); 
        l.put(102,"C"); 
        Thread t2=new Thread(); 
        t2.start(); 
          
        for (Object o : l.entrySet())  
        { 
            Object s=o; 
            System.out.println(s); 
            Thread.sleep(1000); 
        } 
        System.out.println(l); 
    } 
    }