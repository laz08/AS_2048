package PresentationLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by laura on 13/06/15.
 */
public class Ranking {
    private final JugarPartidaController jpc;

    private JPanel PanelRank;
    private JButton OKButton;
    private JList list1;

    public void main(JFrame frame) {
        frame.setTitle("Ranking");
        frame.setContentPane(this.PanelRank);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public Ranking(JugarPartidaController jpcn) {
        jpc = jpcn;
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jpc.mostraPartidaFinalitzada();
            }
        });

    }

}
