import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalCR extends JFrame {
    private LCRGame lcr;

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
            dicePanel.add(dice);
        }

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
                    lcr.playTurn(0);
                }

        });


    }


}
