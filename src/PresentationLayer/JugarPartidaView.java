package PresentationLayer;

import javax.swing.*;
import java.awt.*;

public class JugarPartidaView extends JFrame{
    private Autentif autentifView;
    public JugarPartidaView(){
        /*setTitle("Joc 2048");
        setBackground(Color.darkGray);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        */
        prepareAut();
    }

    public void prepareAut() {
       autentifView = new Autentif();
        autentifView.main(this);
    }
}
