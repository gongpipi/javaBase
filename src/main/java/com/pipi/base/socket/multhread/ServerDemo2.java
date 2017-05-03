package com.pipi.base.socket.multhread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pipi on 2017/5/3.
 */
public class ServerDemo2 {

    public static void main(String args []){

        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(5433);
            System.out.println("Server listen to 5433");

        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        while (true){
            try {
                // 获取一个socket 对象
                Socket socket = serverSocket.accept();
                // 新起一个线程 处理接收到的数据
                new ServerThread(socket).start();
            }catch (IOException e){

            }

        }


    }
}
