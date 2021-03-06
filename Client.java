package java_0604;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    // 本机 ip 属于特殊的 ip 127.0.0.1,也可以写域名.本机域名默认是 localhost
    private static String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        // 创建了基于 TCP 协议的客户端到服务端的连接
        Socket client = new Socket(HOST, Server.PORT);
        InputStream is = client.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = client.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);

        // 从控制台按行接收字符串
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 接收到的控制台字符串,发送到服务端
            String line = scanner.nextLine();
            pw.println(line);
            // 获取服务端响应的一行字符串
            String response = br.readLine();
            System.out.println("服务端响应: " + response);
        }
    }
}
