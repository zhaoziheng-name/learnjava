package java_0702;

import java.util.Scanner;

public class IpWithLong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Long l = scanner.nextLong();
        ipToLong(str);
        longToIP(l);
    }

    private static String longToIP(long longIp) {
        StringBuffer stringBuffer = new StringBuffer("");
        // 直接右移24位
        stringBuffer.append(String.valueOf((longIp >>> 24)));
        stringBuffer.append(".");
        // 将高8位置0，然后右移16位
        stringBuffer.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        stringBuffer.append(".");
        // 将高16位置0，然后右移8位
        stringBuffer.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        stringBuffer.append(".");
        // 将高24位置0
        stringBuffer.append(String.valueOf((longIp & 0x000000FF)));
        return stringBuffer.toString();
    }

    private static long ipToLong(String strIp) {
        String[]ip = strIp.split("\\.");
        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + Long.parseLong(ip[3]);
    }
}
