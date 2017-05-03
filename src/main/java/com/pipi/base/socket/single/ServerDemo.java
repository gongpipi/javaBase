package com.pipi.base.socket.single;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pipi on 2017/5/2.
 */
public class ServerDemo {

    public static void main(String args[]) {
        ServerSocket socket = null;
        String hello = "From server : hello world";


        try {
            // 1. 建立一个 ServerSocket
            int port = 5432;
            socket = new ServerSocket(port);
            System.out.println("server listen in : " + port);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (true) {
            try {
                // 2.获得一个通信对象  Socket 对象 在 while 内部的原因是因为要接收多个客户端请求
                Socket cs = socket.accept();
                // 3.获得一个输入流
                InputStream in = cs.getInputStream();
                DataInputStream inputStream = new DataInputStream(in);

                // 5.获得一个输出流
                OutputStream out = cs.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(out);

                // 4.从客户端读取
                String cmd = inputStream.readUTF();

                if (cmd == "exit") {
                    break;
                }
                // 6.输出到客户端
                dataOutputStream.writeUTF(hello + " your name is " + cmd);

                // 关闭连接
                in.close();
                out.close();
                cs.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
