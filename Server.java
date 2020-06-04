package java_0604;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static int PORT = 9999;

    private static ExecutorService POOL = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        // 启动了服务端程序
        // 网络传输数据,使用端口号来定位程序,指定端口号
        ServerSocket server = new ServerSocket(PORT);
        // 阻塞等待客户端连接,有新的连接来,往下执行
        Socket client = server.accept();
        POOL.submit(new ServerTask(client));
    }

    private static class ServerTask implements Runnable {
    private Socket client;
    public ServerTask(Socket client) {
        this.client = client;
    }
        @Override
        public void run() {
            // 处理 client 中的输入输出流,也就是发送/读取网络数据包
            try {
                InputStream is = client.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                OutputStream os = client.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("接收客户端数据: " + line);
                    pw.println("响应: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
