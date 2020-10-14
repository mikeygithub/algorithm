package io;

import java.io.File;

public class IODEMO {

    public static void listAllFiles(File dir){
        if (dir == null || !dir.exists())return;
        if (dir.isFile()){
            System.out.println(dir.getName());
            return;
        }
        for (File file :dir.listFiles()) {
            listAllFiles(file);
        }
    }

    public static void main(String[] args) {

        listAllFiles(new File("./"));

    }

}
