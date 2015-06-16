package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    private final JugarPartidaController jpc;
    private JPanel panel1;
    private JButton jugarPartidaButton;
    private JButton mostrarRankingButton;
    private JLabel error;

    public void main(JFrame frame) {
        frame.setTitle("2048 - Menu Principal");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public MenuPrincipal(final JugarPartidaController jpcn) {
        jpc = jpcn;
        error.setForeground(Color.red);
        jugarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jpc.iniPartida();
            }
        });
        mostrarRankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    jpc.mostraRanking(true);
                }
                catch (Exception e){
                    error.setText(e.getMessage());
                }
            }
        });
    }
}
