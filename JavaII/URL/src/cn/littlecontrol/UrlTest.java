package cn.littlecontrol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @Author LittleControl
 * @Website www.littlecontrol.cn
 * @Date 2020-03-06 上午 08:27:38
 */
public class UrlTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream(), "utf-8")
            );
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
