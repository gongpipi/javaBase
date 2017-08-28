package com.pipi.base.thread.exmpale.ifeve;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by pipi on 2017/8/23.
 */
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        try {
            reader.connect(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread printThread = new Thread(new Print(reader));
        printThread.start();

        int intwords = 0;
        try{
            while ((intwords = System.in.read()) !=-1) {
                writer.write(intwords);
            }
        } catch (IOException e) {
           e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    static class Print implements Runnable {

        PipedReader reader = null;

        public Print(PipedReader pipedReader){
            reader = pipedReader;
        }
        @Override
        public void run() {
            int recive = 0;
            try{
                while((recive = reader.read()) != -1){
                    System.out.print((char) recive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
