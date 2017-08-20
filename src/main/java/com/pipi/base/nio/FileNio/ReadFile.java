package com.pipi.base.nio.FileNio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by pipi on 2017/8/10.
 */
public class ReadFile {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("F:\\code\\idea\\git\\github\\javabase\\src\\main\\java" +
                "\\com\\pipi\\base\\nio\\FileNio\\Test.md");

        FileChannel channel = inputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        channel.close();
        byteBuffer.flip();//读写转换
    }
}
