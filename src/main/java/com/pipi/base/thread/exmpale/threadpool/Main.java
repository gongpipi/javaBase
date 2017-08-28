package com.pipi.base.thread.exmpale.threadpool;

/**
 * Created by pipi on 2017/8/23.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer();
        simpleHttpServer.setPort(8081);
        simpleHttpServer.setBasePath("666");
        simpleHttpServer.start();
    }
}
