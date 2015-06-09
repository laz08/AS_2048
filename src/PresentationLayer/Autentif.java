package PresentationLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by laura on 09/06/15.
 */
public class Autentif {
    private JButton OKButton;
    private JButton cancelLarButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JPanel PanelAut;

    public static void main(JFrame frame) {
        frame.setTitle("2048 - Autentificació");
        frame.setContentPane(new Autentif().PanelAut);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public Autentif(){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField1.setText("Hola");
                //Avisa al controller que ha d'anar a nova pantalla: Crear nova partida (Mirar cas d'ús)
            }
        });
        cancelLarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Tancar tot. Finaltza execució
                System.exit(0);
            }
        });
    }
}
