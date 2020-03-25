package old;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static class ThreadHandler implements Runnable {

        private Socket incoming;

        public ThreadHandler(Socket incoming) {
            this.incoming = incoming;
        }

        @Override
        public void run() {
            try (
                    InputStream inputStream = incoming.getInputStream();
                    OutputStream outputStream = incoming.getOutputStream();) {
                try (Scanner in = new Scanner(inputStream, "UTF-8")) {

                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
                    out.println();
                    out.println("Privet :)");
                    out.println("type 'Close' to end session");
                    out.println();

//                    Scanner scanner = new Scanner(System.in);

                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
//                        System.out.println(line);
                        out.println("Echo: " + line);
//                        String ans = scanner.nextLine();
//                        out.println(ans);
                        if (line.trim().equals("Close")) done = true;
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//
//        try (ServerSocket serverSocket = new ServerSocket(8000)) {
//
//            int i = 1;
//
//            while (true) {
//                Socket incoming = serverSocket.accept();
//                System.out.println("WASAp. We've got " + i + " user(s) there!");
//                Runnable r = new ThreadHandler(incoming);
//                Thread t = new Thread(r);
//                t.start();
//                i++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
