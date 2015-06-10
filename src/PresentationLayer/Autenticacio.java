package PresentationLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by laura on 09/06/15.
 */
public class Autenticacio {
    private final JugarPartidaController jpc;

    private JButton OKButton;
    private JButton cancelLarButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JPanel PanelAut;
    private JLabel errorTextField;

    public void main(JFrame frame) {
        frame.setTitle("2048 - Autentificació");
        frame.setContentPane(new Autenticacio(jpc).PanelAut);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public JButton getCancelLarButton(){
        return cancelLarButton;
    }
    public Autenticacio(JugarPartidaController jpcn){
        this.jpc = jpcn;

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Avisa al controller que ha d'anar a nova pantalla: Crear nova partida (Mirar cas d'ús)
            }
        });
        cancelLarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jpc.mostraMenuPrincipal();
            }
        });

    }
}
