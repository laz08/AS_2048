package PresentationLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    private final JugarPartidaController jpc;
    private JPanel panel1;
    private JButton autenticarButton;
    private JButton jugarPartidaButton;
    private JButton surtButton;

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
        surtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        autenticarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jpc.mostraAutenticacio();
            }
        });

        jugarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jpc.iniPartida();
            }
        });

    }
}
