package com.pipi.worktest;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.pipi.worktest.ChangeCode.copyFile;

public class ReadFile {

    public static void main(String[] args) throws Exception {
//        createSQL();
        String fileName = "D:\\code\\idea\\sanss\\msp\\current\\msp\\oamweb\\OAM版本升级记录说明.txt";

        copyFile(fileName,"a.txt");
    }





}
