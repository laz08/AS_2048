package PresentationLayer;

import ClassesAuxiliars.StructRanking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Ranking {
    private final JugarPartidaController jpc;

    private JPanel PanelRank;
    private JButton OKButton;
    private JList llistaRank;
    private DefaultListModel llistat;
    private boolean srcIsMainMenu;

    /**
     * Vista encarregada de mostrar el ranking a l'usuari
     * @param jpcn
     */
    public Ranking(JugarPartidaController jpcn) {
        jpc = jpcn;
        llistat = new DefaultListModel();
        llistaRank.setModel(llistat);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(srcIsMainMenu)
                    jpc.mostraMenuPrincipal();
                else
                    jpc.mostraPartidaFinalitzada();
            }
        });
    }

    /**
     * Equival a "showRanking" especificat a la 2a entrega
     * @param frame
     * @param rank
     * @param srcIsMainMenu
     */
    public void main(JFrame frame, ArrayList<StructRanking> rank, boolean srcIsMainMenu) {
        this.srcIsMainMenu = srcIsMainMenu;
        frame.setTitle("2048 - Ranking");
        frame.setContentPane(this.PanelRank);
        afegirLiniesRanking(rank);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void afegirLiniesRanking(ArrayList<StructRanking> rank){
        llistat.clear();
        for(int i = 0; i < rank.size(); ++i){
            llistat.addElement(rank.get(i).nom + ": " + rank.get(i).millorP);
        }
    }

}
