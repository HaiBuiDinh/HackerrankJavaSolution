package Java.JavaSingletonPattern;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{
    private Singleton() {
    }
    private static Singleton INSTANCE;
    public String str;
    public static Singleton getSingleInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }
}