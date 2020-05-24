package exper2;

import java.util.Scanner;

/**
 * @Author: www.littlecontrol.cn
 * @Date: 2020/5/22 上午 06:46
 */
public class EchoClient2 {
    public static void main(String[] args) {
        System.out.println("与服务器的建立连接成功");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("echo" + str);
        str = scanner.nextLine();
        System.out.println("echo" + str);
        System.out.println("");
    }
}
