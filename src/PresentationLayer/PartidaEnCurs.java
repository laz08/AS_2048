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

    private void preparePartida(int puntActual, int millorPunt, ArrayList<Partida.StructCasella> caselles){
        //TODO: posar caselles com toca, preparePartida ha de rebre dades
        this.puntActual.setText(Integer.toString(puntActual));
        this.puntMillor.setText(Integer.toString(millorPunt));

        //Fem taulell
        taulell.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        taulell.setLayout(new GridLayout(4, 4));
        for(int i = 0; i < caselles.size(); ++i){
            JLabel casella = new JLabel(Integer.toString(caselles.get(i).getNumero()));
            casella.setHorizontalAlignment(JLabel.CENTER);
            casella.setFont(new Font(casella.getFont().getName(), Font.BOLD, 25));
            casella.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            //casella.setBackground(Color.blue);
            casella.setOpaque(true);
            taulell.add(casella);
        }

    }

    public void actualitzaPartida(){
        //TODO: ActualitzaPartida reb dades per la capçalera
    }
    public void main(JFrame frame, int puntActual, int millorPunt, ArrayList<Partida.StructCasella> caselles) {
        frame.setTitle("2048");
        frame.setContentPane(this.PanelPartCurs);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        preparePartida(puntActual, millorPunt, caselles);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
