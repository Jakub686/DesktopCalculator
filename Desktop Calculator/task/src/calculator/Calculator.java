package calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator extends JFrame implements ActionListener {
    // JTextField
    static JTextField t;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // label to display text
    //static JLabel l;

    // default constructor
    public Calculator() {
    }
    public void run(){
        // create a new frame to store text field and button
        f = new JFrame("EquationTextField");

        // create a label to display text
        //l = new JLabel("nothing entered");

        // create a new button
        b = new JButton("Solve");

        // create a object of the text class
        Calculator te = new Calculator();

        // addActionListener to button
        b.addActionListener(te);

        // create a object of JTextField with 16 columns and a given initial text
        t = new JTextField( 16);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
        p.add(t);
        p.add(b);
        //p.add(l);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(600, 600);
        f.show();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Solve")) {

            String input = t.getText();
            // set the text of field to blank
            try {
                t.setText(t.getText()+ "="+mathEvaluation(input));
            } catch (ScriptException scriptException) {
                scriptException.printStackTrace();
            }
        }
    }

    public String mathEvaluation(String input) throws ScriptException, NullPointerException {
        String[]  inputArray = input.split("\\+");
        int operant1 = Integer.parseInt(inputArray[0]);
        int operant2 = Integer.parseInt(inputArray[1]);

        String result = Integer.toString((operant1) + (operant2));
        return result;
    }

}
