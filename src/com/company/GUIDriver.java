package com.company;

import javax.swing.*;

public class GUIDriver {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                int num;
               // TestScoreButton scores = new TestScoreButton();
                //scores.setVisible(true);
                GetNum getnum = new GetNum();

            }
        });


    }
}
