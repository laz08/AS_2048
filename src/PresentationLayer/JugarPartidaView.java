package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JugarPartidaView extends JFrame implements ActionListener{
    private Autentif autentifView;
    public JugarPartidaView(){
        setTitle("Joc 2048");
        setBackground(Color.darkGray);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        prepareAut();
    }

    public void prepareAut() {
       autentifView = new Autentif();
        autentifView.main(null);
    }

    public void actionPerformed(ActionEvent arg0) {

    }

}
