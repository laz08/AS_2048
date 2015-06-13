package PresentationLayer;

import javax.swing.*;
import javax.swing.tree.ExpandVetoException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        frame.setContentPane(this.PanelAut);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public Autenticacio(JugarPartidaController jpcn){
        this.jpc = jpcn;

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Avisa al controller que ha d'anar a nova pantalla: Crear nova partida (Mirar cas d'ús)
                //TODO: Fer el login
                String txtUser = textField1.getText();
                String txtPass = passwordField1.getText();
                if(txtUser.isEmpty()){
                    errorTextField.setText("Camp username buit");
                }
                else if(txtPass.isEmpty()){
                    errorTextField.setText("Camp password buit");
                }
                else {
                    try{
                        jpc.ferAutenticacio(textField1.getText(), passwordField1.getText());
                        jpc.mostraMenuPrincipal();
                    }
                    catch (Exception e){
                        errorTextField.setText(e.getMessage());
                    }
                }
            }
        });
        cancelLarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

    }
}
