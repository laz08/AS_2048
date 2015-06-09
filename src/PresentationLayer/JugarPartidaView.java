package PresentationLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JugarPartidaView extends JFrame{
    private Autenticacio autenticacioView;
    private MenuPrincipal menuPrincipal;
    public JugarPartidaView(JugarPartidaController jpc){
        /*setTitle("Joc 2048");
        setBackground(Color.darkGray);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        */
        //prepareAut();
        //prepareMenuPrincipal();
        autenticacioView = new Autenticacio(jpc);
        menuPrincipal = new MenuPrincipal(jpc);
    }

    public void prepareAut() {
        System.out.println("Entro aquí");
        autenticacioView.main(this);
    }

    public void prepareMenuPrincipal(){
        menuPrincipal.main(this);
    }
}
