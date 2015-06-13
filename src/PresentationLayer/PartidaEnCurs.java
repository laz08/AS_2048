package PresentationLayer;

import DomainLayer.Partida;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by laura on 13/06/15.
 */
public class PartidaEnCurs {
    private final JugarPartidaController jpc;
    private JPanel PanelPartCurs;
    private JPanel taulell;
    private JLabel puntActual;
    private JLabel puntMillor;

    public PartidaEnCurs(JugarPartidaController jpcn) {
        jpc = jpcn;
    }

    public void preparePartida(int puntActual, int millorPunt, ArrayList<Partida.StructCasella> caselles){
        //TODO: posar caselles com toca, preparePartida ha de rebre dades
        this.puntActual.setText(Integer.toString(puntActual));
        this.puntMillor.setText(Integer.toString(millorPunt));

        //Fem taulell
        taulell.removeAll();
        taulell.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        taulell.setLayout(new GridLayout(4, 4));
        for(int i = 0; i < caselles.size(); ++i){
            Color bg = Color.DARK_GRAY;
            JLabel casella = new JLabel();
            int valor = caselles.get(i).getNumero();
            if(valor != 0){
                casella.setText(Integer.toString(valor));
                switch (valor){
                    case 2: bg = new Color(0xeee4da); break;
                    case 4: bg = new Color(0xede0c8); break;
                    case 8: bg = new Color(0xf2b179); break;
                    case 16: bg = new Color(0xf59563); break;
                    case 32: bg = new Color(0xf67c5f); break;
                    case 64: bg = new Color(0xf65e3b); break;
                    case 128: bg = new Color(0xedcf72); break;
                    case 256: bg = new Color(0xedcc61); break;
                    case 512: bg = new Color(0xedc850); break;
                    case 1024: bg = new Color(0xedc53f); break;
                    case 2048: bg = new Color(0xedc22e); break;
                }
                casella.setBackground(bg);
            }
            casella.setHorizontalAlignment(JLabel.CENTER);
            casella.setFont(new Font(casella.getFont().getName(), Font.BOLD, 25));
            casella.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            casella.setOpaque(true);
            taulell.add(casella);
        }

    }
    public void main(JFrame frame) {
        frame.setTitle("2048");
        frame.setContentPane(this.PanelPartCurs);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
