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
        //panelAutentif.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelAutentif.setBorder(BorderFactory.createMatteBorder(80, 80,80, 80, Color.lightGray));

        //TextFields
        JTextField userN = new JTextField();
        JTextField pwd = new JTextField();

        //JLabels
        JLabel userNText = new JLabel();
        JLabel pwdText = new JLabel();

        //Buttons
        JButton OK = new JButton();
        JButton cancellar = new JButton();

        //Add them to the panel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
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

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = 1;
        panelAutentif.add(userN, c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = 1;
        panelAutentif.add(pwd, c);

        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = 1;
        panelAutentif.add(OK, c);

        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = 1;
        panelAutentif.add(cancellar, c);

        userNText.setText("Username:");
        pwdText.setText("Password:");
        OK.setText("OK");
        OK.setBounds(10, 10, 10, 10);
        cancellar.setText("Cancel·lar");
        panelAutentif.setBackground(Color.lightGray);
        panelAutentif.setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {

    }

}
