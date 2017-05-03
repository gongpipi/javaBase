package com.pipi.base.socket.multhread;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by pipi on 2017/5/3.
 */
public class ServerThread extends Thread{

    public String serverMsg = "  welcome , i am you";

    private Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {

            // 获得输入流 ，并读取
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            String msg = dis.readUTF();

            System.out.println(msg);
            System.out.println("请回答：");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            // 输出流 ，并输出
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF( " server respone :" +answer);

            in.close();
            out.close();
            socket.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
