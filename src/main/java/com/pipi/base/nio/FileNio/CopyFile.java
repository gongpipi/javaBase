package com.pipi.base.nio.FileNio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by pipi on 2017/8/10.
 */
public class CopyFile {
    public static void main(String[] args) throws IOException{
        String resourse = "src\\main\\java" +
                "\\com\\pipi\\base\\nio\\FileNio\\Test.md";
        String destination = "src\\main\\java" +
                "\\com\\pipi\\base\\nio\\FileNio\\out.txt";
        nioCopyFile(resourse,destination);
    }

    public static void nioCopyFile(String resource, String destination)
            throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination,true);
        FileChannel readChannel = fis.getChannel(); // 读文件通道
        FileChannel writeChannel = fos.getChannel(); // 写文件通道
        ByteBuffer buffer = ByteBuffer.allocate(1024); // 读入数据缓存
        while (true) {
            buffer.clear();
            int len = readChannel.read(buffer); // 读入数据
            if (len == -1) {
                break; // 读取完毕
            }
            buffer.flip();
            writeChannel.write(buffer); // 写入文件
        }
        readChannel.close();
        writeChannel.close();
    }
}
