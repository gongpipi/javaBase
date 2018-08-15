package com.pipi.worktest;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CanculateConnecttion {

    public static void main(String[] args) throws Exception {
        int i[] ={0};
        Files.lines(Paths.get("D:\\code\\idea\\github\\javabase\\src\\main\\resources\\connect"), StandardCharsets.UTF_8)
                .forEach(line->{
                    i[0]=new Integer(line.replace(" ",""))+i[0];

                        }
                );
        System.out.println(i[0]);

    }
}
