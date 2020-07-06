package java_0706;

import java.util.*;

/*
1. 将输入的字符串转化为字符数组。对字符数组中的每一个字符进行校验。
2. 对于每个字符的校验
	a. 取得其二进制序列
	b. 计算其二进制中1的个数
	c. 1的个数为奇数个，高位设置为0；1的个数为偶数个，高位设置为1
*/
public class OddCheck {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            jiCheck(str.toCharArray());
        }
    }
    public static void jiCheck(char[] arrs){
        int[] result = new int[8];    // 保存二进制序列
        for(int i = 0; i < arrs.length; i++){
            int one = 0x01;
            int count = 0;    // 保留二进制序列中1的个数
            // 得到其二进制序列
            int index = 7;
            while(index > 0){
                result[index] = ((arrs[i]& one) == 0) ? 0 : 1;
                if(result[index] == 1)
                    count++;
                one <<= 1;
                index--;
            }
            // 偶数个1，高位为1；奇数个1，高位为0
            result[0] = (count % 2 == 1) ? 0 : 1;
            // 输出
            for(int k = 0; k < 8; k++){
                System.out.print(result[k]);
            }
            System.out.println();
        }
    }
}
