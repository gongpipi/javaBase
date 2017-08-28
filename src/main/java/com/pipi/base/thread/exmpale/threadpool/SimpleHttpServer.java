package com.pipi.base.thread.exmpale.threadpool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pipi on 2017/8/23.
 */
public class SimpleHttpServer {

    // 处理http的线程池
    static DefaultThreadPool<HttpRequestHandle> threadPool = new DefaultThreadPool<HttpRequestHandle>();

    // port 启动服务的端口
    static int port = 8080;
    // 请求的根路径
    static String basePath;
    static ServerSocket serverSocket;

    // 设置端口
    public void setPort(int port){
        if(port>0  && port <= 65536) {
            SimpleHttpServer.port = port;
        }
    }

    // 设置基本路径
    public void setBasePath(String basePath){
        if(basePath !=null && new File(basePath).exists() && new File(basePath).isDirectory()){
            SimpleHttpServer.basePath = basePath;
        }
    }

    // 启动服务
    public  void start() throws Exception {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            threadPool.excute(new HttpRequestHandle(socket));
        }
        serverSocket.close();
    }

    //
    static class HttpRequestHandle implements Runnable {

        private Socket socket = null;
        private HttpRequestHandle(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;

            PrintWriter out = null;

            try{
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();

                // 由相对路径计算绝对路径
//                String filePath = basePath + header.split(" ") [1];
                String filePath = "F:\\code\\idea\\git\\github\\javabase\\src\\main\\" +
                        "java\\com\\pipi\\base\\thread\\exmpale\\threadpool\\test.html";
                out = new PrintWriter(socket.getOutputStream());

                // 处理html
                br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                out.println("HTTP/1.1 200 OK");
                out.println("Server: pipi");
                out.println("Content-Type: text/html; charset=UTF-8");
                out.println("");
                while ((line = br.readLine()) != null) {
                    out.println(line);
                }
                out.flush();
            } catch (IOException e) {
                out.println("HTTP/1.1 500 OK");
                out.println("");
                out.flush();
            }finally {
                close(br,reader, out, socket);
            }

        }
    }

    private static void close(Closeable... closeables) {
        if(closeables != null) {
            for(Closeable closeable : closeables){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

