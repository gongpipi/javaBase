package com.pipi.worktest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Files;

public class ChangeCode {

    public static String src="";

    public static String des="";

    public static void main(String[] args) throws Exception {

        File root = new File("D:\\code\\idea\\sanss\\msp\\current\\msp\\oamweb");

        src = "oamweb";
        des = "oamweb_new";
//        mkDirs(root);
        createFiles(root);

    }



    static void mkDirs(File root) throws Exception{
        if(root.isDirectory()){
            if(isExcptDir(root.getName())){
                return;
            }
            String resourse = root.getPath();
            String destination =  resourse.replace(src,des);
            File dir = new File(destination);
            if(!dir.exists()){
                dir.mkdirs();
            }
            File [] dirs = root.listFiles();

            for (int i=0;i<dirs.length;i++) {
                mkDirs(dirs[i]);
            }


        }
    };

    static void createFiles(File root) throws Exception{
        if(root.isDirectory()){

            if(isExcptDir(root.getName())){
                return;
            }

            // 复制目录
            String resourse = root.getPath();
            String destination =  resourse.replace(src,des);
            File dir = new File(destination);
            dir.mkdirs();

            // 复制子目录
            File[] files = root.listFiles();
            for (int i=0;i<files.length;i++){
                createFiles(files[i]);
            }
        }else{
            String resourse = root.getPath();

            String destination =  resourse.replace(src,des);
            copyFile(resourse,destination);
        }
    }



    public static void nioCopyFile(String resource, String destination)
            throws IOException {
        Charset charset = Charset.forName("UTF-8");//Java.nio.charset.Charset处理了字符转换问题。它通过构造CharsetEncoder和CharsetDecoder将字符序列转换成字节和逆转换。
        CharsetDecoder decoder = charset.newDecoder();

        FileInputStream fis = new FileInputStream(resource);

        File newFile = new File(destination);
        if(!newFile.exists()){
//            mkDirs(newFile.getParent().);
            newFile.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(destination,true);
        FileChannel readChannel = fis.getChannel(); // 读文件通道
        FileChannel writeChannel = fos.getChannel(); // 写文件通道
        ByteBuffer buffer = ByteBuffer.allocate(4096); // 读入数据缓存
        CharBuffer cb = CharBuffer.allocate(4096);
        while (true) {
            buffer.clear();
            int len = readChannel.read(buffer); // 读入数据
            if (len == -1) {
                break; // 读取完毕
            }
            buffer.flip();
            decoder.decode(buffer, cb, false);
            writeChannel.write(buffer); // 写入文件
        }
        readChannel.close();
        writeChannel.close();
    }

    static boolean isExcptDir(String dirName){
        String [] excpt={"lib",".idea","lib",".settings","build","classes","Templates","WebContent"};

        for(int i=0;i<excpt.length;i++){
            if(dirName.equals(excpt[i])){
                return true;
            }
        }
        return false;
    }

    public static void copyFile(String fileName,String destinationFileName) throws Exception {
        File file = new File(fileName);
        BufferedReader reader = null;

        File destFile = new File(destinationFileName);
        if(!destFile.exists()){
            destFile.createNewFile();
        }
        BufferedWriter bw=null;

        StringBuilder sb = new StringBuilder();

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("GBK")));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFile), Charset.forName("UTF-8")));

            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString+"\r\n");
            }
            // 写入文件
            bw.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();

            bw.flush();
            bw.close();
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
