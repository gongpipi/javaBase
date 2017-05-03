package com.pipi.base.socket.multhread;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Created by pipi on 2017/5/3.
 */
public class ClientDemo2 {
    public static void main(String args[]) {
        String serverHost = "127.0.0.1";
        int port = 5433;

        int clientID = new Random(100).nextInt();

        int retryTime = 0;

        while (true) {

            try {
                retryTime++;
                if(retryTime>10){
                    exit(0);
                }
                // 1.建立一个通信的sokect 每次循环都新建一个socket，可以多次和服务器交互
                Socket s = new Socket(serverHost, port);

                OutputStream os = null;
                DataOutputStream dos = null;

                InputStream is = null;
                DataInputStream dis = null;

                // 2.获得输出流
                os = s.getOutputStream();
                dos = new DataOutputStream(os);

                // 5.获得输入流
                is = s.getInputStream();
                dis = new DataInputStream(is);
                // 3.从控制台读取数据
                System.out.println("请输入：");
                Scanner sc = new Scanner(System.in);


                String inMsg = sc.nextLine();
                if (inMsg == "exit") {
                    break;
                }
                // 4.向服务器发送数据
                dos.writeUTF("Client " + clientID + "来电：" + inMsg);

                // 6.读取数据
                String msg = dis.readUTF();
                // 7.输出数据
                System.out.println(msg);

                // 8.关闭连接
                os.close();
                is.close();
                s.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
