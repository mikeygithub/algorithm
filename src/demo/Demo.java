package demo;

import org.junit.Assert;
import sun.misc.Unsafe;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertTrue;

public class Demo {

    public void display(){
        System.out.println("display");
    }

    public void show(String content){
        System.out.println(content);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        File file = new File("/home/mikey/Downloads/photowall/img");

        System.out.println("[");
        for(File f : file.listFiles()){

            System.out.println("{ image: \"img/"+f.getName()+"\"},");

        }
        System.out.println("]");


        System.out.println(file.listFiles().length);
    }
}
