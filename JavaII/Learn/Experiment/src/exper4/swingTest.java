package exper4;

import javax.swing.*;
import java.awt.*;

/**
 * @author LittleControl
 * @date 2020/5/28 下午 10:19
 * @website www.littlecontrol.cn
 */
public class swingTest extends JFrame {
    swingTest() {
        setSize(400, 200);
        getContentPane().setLayout(new GridLayout(1, 4));
        getContentPane().add(new JButton(
                "<html><p>1<sup>st</sup></p></html>"));
        getContentPane().add(new JButton(
                "<html><p>2<sup>nd</sup></p></html>"));
        getContentPane().add(new JButton(
                "<html><p>3<sup>rd</sup></p></html>"));
        getContentPane().add(new JButton(
                "<html><p>4<sup>th</sup></p></html>"));
    }
    public static void main(String[] args) {
        new swingTest().setVisible(true);
    }
}
