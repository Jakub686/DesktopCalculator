package calculator;

import javax.swing.*;

public class Calculator extends JFrame {

    private static String input="";

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 400);
        initComp();
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComp() {
        JTextField equationTextField = new JTextField();
        equationTextField.setName("EquationTextField");
        equationTextField.setBounds(40, 20, 230, 40);
        add(equationTextField);

        JButton solveButton = new JButton("=");
        solveButton.setName("=");
        solveButton.setBounds(100, 200, 100, 40);
        add(solveButton);

        JButton sevenButton = new JButton("7");
        sevenButton.setName("7");
        sevenButton.setBounds(40, 80, 50, 40);
        add(sevenButton);

        JButton eightButton = new JButton("8");
        eightButton.setName("8");
        eightButton.setBounds(100, 80, 50, 40);
        add(eightButton);

        JButton nineButton = new JButton("9");
        nineButton.setName("9");
        nineButton.setBounds(160, 80, 50, 40);
        add(nineButton);

        JButton divisionButton = new JButton("/");
        divisionButton.setName("/");
        divisionButton.setBounds(220, 80, 50, 40);
        add(divisionButton);

        sevenButton.addActionListener(e -> {
            equationTextField.setText("7"+input);
            input = equationTextField.getText();
        });

        eightButton.addActionListener(e -> {
            equationTextField.setText("8"+input);
            input = equationTextField.getText();
        });

        solveButton.addActionListener(e -> {
            String[] args = equationTextField.getText().split("\\+");
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            equationTextField.setText(equationTextField.getText() + "=" + (a + b));
        });
    }
}