package calculator;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame {

    private JTextField equationTextField;

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null);
        setVisible(true);
    }

    private void initComponents() {
        this.equationTextField = new JTextField();
        this.equationTextField.setFont(new Font("Default", Font.PLAIN, 28));
        this.equationTextField.setName("EquationTextField");
        this.equationTextField.setBounds(20, 20, 260, 50);
        add(this.equationTextField);

        JButton seven = addButton("7", "Seven", 20, 90, 50, 50);
        JButton eight = addButton("8", "Eight", 90, 90, 50, 50);
        JButton nine = addButton("9", "Nine", 160, 90, 50, 50);
        JButton divide = addButton("/", "Divide", 230, 90, 50, 50);
        JButton four = addButton("4", "Four", 20, 160, 50, 50);
        JButton five = addButton("5", "Five", 90, 160, 50, 50);
        JButton six = addButton("6", "Six", 160, 160, 50, 50);
        JButton multiply = addButton("x", "Multiply", 230, 160, 50, 50);
        JButton one = addButton("1", "One", 20, 230, 50, 50);
        JButton two = addButton("2", "Two", 90, 230, 50, 50);
        JButton three = addButton("3", "Three", 160, 230, 50, 50);
        JButton add = addButton("+", "Add", 230, 230, 50, 50);
        JButton zero = addButton("0", "Zero", 20, 300, 120, 50);
        JButton equals = addButton("=", "Equals", 160, 300, 50, 50);
        JButton subtract = addButton("-", "Subtract", 230, 300, 50, 50);
    }

    private JButton addButton(String text, String name, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setName(name);
        button.setBounds(x, y, width, height);
        add(button);


        if ("=".equals(text)) {
            button.addActionListener(e -> {
                Pattern pattern = Pattern.compile("^(\\d+)(\\+|\\-|x|\\/)(\\d+)$");
                Matcher matcher = pattern.matcher(this.equationTextField.getText());
                if (matcher.find()) {
                    int result = 0;
                    switch (matcher.group(2)) {
                        case "+":
                            result = Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(3));
                            break;
                        case "-":
                            result = Integer.parseInt(matcher.group(1)) - Integer.parseInt(matcher.group(3));
                            break;
                        case "x":
                            result = Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(3));
                            break;
                        case "/":
                            result = Integer.parseInt(matcher.group(1)) / Integer.parseInt(matcher.group(3));
                            break;
                    }
                    this.equationTextField.setText(this.equationTextField.getText() + "=" + result);
                }
            });
        } else {
            button.addActionListener(e -> this.equationTextField.setText(this.equationTextField.getText() + text));
        }

        return button;
    }
}