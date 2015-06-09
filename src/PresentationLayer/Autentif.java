package PresentationLayer;

import javax.swing.*;

/**
 * Created by laura on 09/06/15.
 */
public class Autentif {
    private JButton OKButton;
    private JButton cancelLarButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JPanel PanelAut;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Autentif");
        frame.setContentPane(new Autentif().PanelAut);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setResizable(false);
        //frame.pack();
        frame.setVisible(true);
    }
}
