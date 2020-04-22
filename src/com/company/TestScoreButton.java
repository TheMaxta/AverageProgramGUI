package com.company;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class TestScoreButton extends JFrame {

    private static final int WIDTH = 550;
    private static final int HEIGHT = 500;
    private JTextField xBox;        //Holds user entry
    private JTextField averageBox;       //holds average
    private JTextField iBox;        //holds total number of inputted scores
    ArrayList<JLabel> testLabels = new ArrayList<JLabel>();
    ArrayList<JTextField> inputBoxes = new ArrayList<JTextField>();

    public int total = 0;
    public int i = 0;
    public int numberOfScores;
    //CONSTRUCTOR
    public TestScoreButton(int num){
        numberOfScores = num;
        setTitle("Test Score Calculator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);


    }   //end constructor

    public void setNum(int number){
        i = number;
    }

    private void createContents(){


        JLabel iLabel = new JLabel("Total number of tests:");

        JPanel windowPanel = new JPanel(new BorderLayout(0, 10));
        windowPanel.setBorder(new EmptyBorder(10,10,10,10));

        //container for all components
        JPanel centerPanel;
        if (numberOfScores < 15) {
            centerPanel = new JPanel(new GridLayout(15, 1));
        }
        else if (numberOfScores > 15 && i < 40){
            centerPanel = new JPanel(new GridLayout(40, 1));
            setSize(WIDTH, HEIGHT+250);
        }
        else{
            centerPanel = new JPanel(new GridLayout(60, 1));
            setSize(WIDTH,HEIGHT+500);
        }

        //panel for button center alignment
        JPanel southPanel = new JPanel(new FlowLayout());


        JLabel averageLabel = new JLabel("average!: ");
        //button to signal the calculation of all input fields
        JButton btn = new JButton("Calculate Average");


        Listener listener = new Listener();


        btn.setFont(new Font("Serif", Font.BOLD, 16));
        iLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        averageLabel.setFont(new Font("Serif", Font.PLAIN, 14));


        iBox = new JTextField(2);
        xBox = new JTextField(2);
        averageBox = new JTextField(10);

        iBox.setEditable(false);
        averageBox.setEditable(false);


        //construct our box with labels for instructions, and textfields for user input
        centerPanel.add(iLabel);
        centerPanel.add(iBox);
        iBox.setText((String.valueOf(numberOfScores)));


            //create a new JLabel for each j, create a new jBox for each j, create a bew button for each j
        for (int j = 0; j < numberOfScores; j++) {
            //labels
            testLabels.add(new JLabel("Test #1"));
            testLabels.get(j).setText("Test #"+(j+1));

            //input boxes
            inputBoxes.add(new JTextField(4));

        }

        for (int j = 0; j < numberOfScores; j++) {
            centerPanel.add(testLabels.get(j));
            centerPanel.add(inputBoxes.get(j));
            inputBoxes.get(j).addActionListener(listener);

        }

        windowPanel.add(centerPanel, BorderLayout.CENTER);
        southPanel.add(btn);
        southPanel.add(averageLabel);
        southPanel.add(averageBox);
        windowPanel.add(southPanel, BorderLayout.SOUTH);
        add(windowPanel);
        //add panels



        xBox.addActionListener(listener);   //We need a listener for the TextField
        btn.addActionListener(listener);        //We also need a listener for a button press


    }   //end createContents()

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            total = 0;

            int xf;

            try{
                //total += Integer.parseInt(xBox.getText());   //convert from string to int with parseInt() method


                for (JTextField j : inputBoxes) {
                    total += Integer.parseInt(j.getText());
                }


            }
            catch (NumberFormatException nfe){
                total = -1; // indicates an invalid x val
            }


            //HERE'S where we do the factorial
            if ( total < 0 ){
                averageBox.setText("Undefined.");
            }
            else {
                xf = total / numberOfScores;
                averageBox.setText(Integer.toString(xf));
            } // end parent else

        }
    }

}

