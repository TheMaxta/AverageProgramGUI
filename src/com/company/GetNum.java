package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GetNum extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    private JTextField counterBox;
    public int num;

    public GetNum(){
        setTitle("How many scores?");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        createContents();
        setVisible(true);
    }


    public void createContents(){
        Listener listener = new Listener();
        JLabel titleLable = new JLabel("How many scores would you like to compute? ");
        counterBox = new JTextField(4);
        JButton btn = new JButton("Next");
        add(titleLable);
        add(counterBox);
        add(btn);
        counterBox.addActionListener(listener);
        btn.addActionListener(listener);
    }

    public class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e){

            try
            {
                num = Integer.parseInt(counterBox.getText());
            }
            catch (NumberFormatException nfe){
                num = -1;   //indicates invalid num
            }

            if (num > 0){
                setVisible(false);
                TestScoreButton window = new TestScoreButton(num);
            }

    } //end action perf
    }   //end listener

}
