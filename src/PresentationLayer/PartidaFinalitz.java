package PresentationLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by laura on 13/06/15.
 */
public class PartidaFinalitz {
    private final JugarPartidaController jpc;

    private JButton tornarAJugarButton;
    private JButton mostrarRankingButton;
    private JButton sortirButton;
    private JLabel puntsPartida;
    private JPanel PanelFin;
    private JLabel error;
    private JLabel estat;


    public void main(JFrame frame, boolean guanyada) {
        frame.setTitle("2048 - Fi Partida");
        if(guanyada)
            estat.setText("Has guanyat!");
        else
            estat.setText("Has perdut!");
        frame.setContentPane(this.PanelFin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public PartidaFinalitz(JugarPartidaController jpcn) {
        jpc = jpcn;
        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        tornarAJugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jpc.iniPartida();
            }
        });

        mostrarRankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jpc.mostraRanking();
            }
        });
    }


}
