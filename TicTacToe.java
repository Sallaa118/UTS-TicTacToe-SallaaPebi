package TICTACTOE;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlepanel = new JPanel();
    JPanel buttonpanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean  pemainX;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(0, 0,0));
        textfield.setForeground(new Color(255,182,193));
        textfield.setFont(new Font("Bodoni",Font.ITALIC,50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC TAC TOE");
        textfield.setOpaque(true);

        titlepanel.setLayout(new BorderLayout());
        titlepanel.setBounds(10,10,500,75);

        buttonpanel.setLayout(new GridLayout(3, 3));
        buttonpanel.setBackground(new Color(0,0,0));

        for (int i=0; i<9; i++) {
            buttons[i] = new JButton();
            buttonpanel.add(buttons[i]);
            buttons[i].setFont(new Font("Bodoni",Font.ITALIC,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlepanel.add(textfield);
        frame.add(titlepanel, BorderLayout.NORTH);
        frame.add(buttonpanel);

        giliran();

    }

    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<9; i++) {
            if (e.getSource()==buttons[i]) {
                if (pemainX) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 200));
                        buttons[i].setText("X");
                        pemainX = false;
                        textfield.setText("Player O Turn");
                        checkPemenang();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(150, 0, 255));
                        buttons[i].setText("O");
                        pemainX = true;
                        textfield.setText("Player X Turn");
                        checkPemenang();
                    }
                }
            }

        }

    }

    public void giliran() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            pemainX = true;
            textfield.setText("Player X Turn");
        }
        else {
            pemainX = false;
            textfield.setText("Player O Turn");
        }
    }

    public void checkPemenang(){
        //Player X
        if ((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if ((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if ((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if ((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if ((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if ((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if ((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if ((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }
        
        //Player O
        if ((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if ((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if ((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if ((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if ((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if ((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if ((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if ((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player O Win!!!");
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player X Win!!!");
    }
}
