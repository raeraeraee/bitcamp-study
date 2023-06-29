package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0622x {


  public static void main(String[] args) throws Exception {


    File dir = new File(".");
    File[] files = dir.listFiles(new FileFilter()
      @Override
     (File file)////메소드 파라미터 File : 파라미터타입  file : 파라미터
        return (file.isFile() && file.getName().endsWith(".java"));///// 바디
      }

  for(

  File file:files)
  {
    System.out.printf("%s %12d %s\n", file.isDirectory() ? "d" : "-", file.length(),
        file.getName());
  }

}

}


