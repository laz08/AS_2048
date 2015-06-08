package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JugarPartidaView extends JFrame implements ActionListener{

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
        JPanel panelAutentif = new JPanel();
        add(panelAutentif);
        panelAutentif.setLayout(new GridBagLayout());
        panelAutentif.setAlignmentX(Component.LEFT_ALIGNMENT);

        //TextFields
        JTextField userN = new JTextField();
        JTextField pwd = new JTextField();

        //JLabels
        JLabel userNText = new JLabel("Username:");
        userNText.setVisible(true);
        JLabel pwdText = new JLabel("Password:");

        //Buttons
        JButton OK = new JButton();
        JButton cancellar = new JButton();

        //Add them to the panel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = 1;
        panelAutentif.add(userNText, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = 1;
        panelAutentif.add(pwdText, c);

        panelAutentif.setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {

    }

}
