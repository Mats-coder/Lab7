import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalCR extends JFrame {
    private LCRGame lcr;
    public int currentPlayer;

    public GraphicalCR(LCRGame lcr){
        JFrame frame = new JFrame("LCRGame");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JPanel mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel);

        JPanel playersPanel = new JPanel();
        mainPanel.add(playersPanel);
        playersPanel.setLayout(new FlowLayout());
        JLabel player1 = new JLabel(lcr.players[0].name+" ("+lcr.players[0].chips+" chips)");
        JLabel player2 = new JLabel(lcr.players[1].name+" ("+lcr.players[1].chips+" chips)");
        JLabel player3 = new JLabel(lcr.players[2].name+" ("+lcr.players[2].chips+" chips)");
        playersPanel.add(player1);
        playersPanel.add(player2);
        playersPanel.add(player3);

        JPanel dicePanel = new JPanel();
        mainPanel.add(dicePanel);
        for (int d = 0; d < lcr.previousChips; d++){
            JLabel dice = new JLabel(lcr.dice[d].thisSideUp);
            dicePanel.add(dice,d);
        }

        /*
        JLabel dice1 = new JLabel(lcr.dice[0].thisSideUp);
        JLabel dice2 = new JLabel(lcr.dice[1].thisSideUp);
        JLabel dice3 = new JLabel(lcr.dice[2].thisSideUp);
        dicePanel.add(dice1);
        dicePanel.add(dice2);
        dicePanel.add(dice3);*/


        JPanel buttonsPanel = new JPanel();
        mainPanel.add(buttonsPanel);
        JButton nextRound = new JButton("Next Button");
        JButton exit = new JButton("Exit");
        buttonsPanel.add(nextRound);
        buttonsPanel.add(exit);
        nextRound.setActionCommand("r");
        exit.setActionCommand("q");
        nextRound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentPlayer == 0){
                    lcr.playTurn(currentPlayer);
                    player1.setText(lcr.players[0].name+" ("+lcr.players[0].chips+" chips)");
                    player2.setText(lcr.players[1].name+" ("+lcr.players[1].chips+" chips)");
                    player3.setText(lcr.players[2].name+" ("+lcr.players[2].chips+" chips)");
                    for (int d = 0; d < lcr.previousChips&& d < 3; d++){
                        JLabel dice = new JLabel(lcr.dice[d].thisSideUp);
                        dicePanel.remove(d);
                        dicePanel.add(dice,d);
                    }
                    currentPlayer +=1;

                }else if(currentPlayer == 1){
                    lcr.playTurn(currentPlayer);
                    player1.setText(lcr.players[0].name+" ("+lcr.players[0].chips+" chips)");
                    player2.setText(lcr.players[1].name+" ("+lcr.players[1].chips+" chips)");
                    player3.setText(lcr.players[2].name+" ("+lcr.players[2].chips+" chips)");
                    for (int d = 0; d < lcr.previousChips&& d < 3; d++){
                        JLabel dice = new JLabel(lcr.dice[d].thisSideUp);
                        dicePanel.remove(d);
                        dicePanel.add(dice,d);
                    }
                    currentPlayer+=1;
                } else {
                    lcr.playTurn(currentPlayer);
                    player1.setText(lcr.players[0].name+" ("+lcr.players[0].chips+" chips)");
                    player2.setText(lcr.players[1].name+" ("+lcr.players[1].chips+" chips)");
                    player3.setText(lcr.players[2].name+" ("+lcr.players[2].chips+" chips)");
                    for (int d = 0; d < lcr.previousChips&& d < 3; d++){
                        JLabel dice = new JLabel(lcr.dice[d].thisSideUp);
                        dicePanel.remove(d);
                        dicePanel.add(dice,d);
                    }
                    currentPlayer=0;
                }
                }

        });


    }


}
