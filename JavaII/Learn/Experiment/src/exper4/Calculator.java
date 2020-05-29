package exper4;
/**
 * @author LittleControl
 * @date 2020/5/25 下午 10:28
 * @website www.littlecontrol.cn
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}

class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("CalculatorFrame");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}

class CalculatorPanel extends JPanel {
    public CalculatorPanel() {
        setLayout(new BorderLayout());
        result = 0;
        lastCommand = "=";
        start = true;
        Font sansBold30 = new Font("SansSerif", Font.BOLD, 30);
        displayButton = new JButton("0");
        displayButton.setFont(sansBold30);
        displayButton.setEnabled(false);
        add(displayButton, BorderLayout.NORTH);
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();
        ActionListener ac = new ACAction();
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        JButton aCButton = new JButton("AC");
        aCButton.setFont(sansBold30);
        aCButton.addActionListener(ac);
        add(aCButton, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
    }

    //添加按钮组件
    private void addButton(String label, ActionListener listener) {
        Font sansBold30 = new Font("SansSerif", Font.BOLD, 30);
        JButton button = new JButton(label);
        button.setFont(sansBold30);
        button.addActionListener(listener);
        panel.add(button);
    }

    //数字按钮监听类
    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            //清空按钮文本
            if (start) {
                displayButton.setText("");
                start = false;
            }
            //输入数字
            displayButton.setText(displayButton.getText() + input);
        }
    }

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) {
                //输入并显示负号
                if (command.equals("-")) {
                    displayButton.setText(command);
                    start = false;
                } else  //记录上一个运算符
                    lastCommand = command;
            } else {
                calculate(Double.parseDouble(displayButton.getText()));   //计算
                lastCommand = command;   //记录当前运算符
                start = true;   //开始标识符置1，重新开始输入
            }

        }
    }

    private class ACAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            result = 0;
            lastCommand = "=";
            displayButton.setText("0");
            start = true;
        }
    }

    public void calculate(double x) {
        if (lastCommand.equals("+"))
            result += x;
        else if (lastCommand.equals("-"))
            result -= x;
        else if (lastCommand.equals("*"))
            result *= x;
        else if (lastCommand.equals("/"))
            result /= x;
        else if (lastCommand.equals("="))
            result = x;
        displayButton.setText("" + result);
    }

    private JButton displayButton;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
}
