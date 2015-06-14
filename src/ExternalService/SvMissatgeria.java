package ExternalService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Miquel on 13/06/2015.
 */
public class SvMissatgeria {
    private Properties p;
    public SvMissatgeria(){}
    public void enviarCorreu(String missatge,String destinatari){
        final String compte = "as2048grup10@gmail.com";
        final String password = "linuxrulez";
        String assumpte = "Partida jugada al joc 2048";
        String contingut = "La puntuació obtinguda en la partida ";
        boolean trobat = false;
        String id = "";
        String puntuacio = "";
        for (int i = 0; i < missatge.length(); i++){
            char c = missatge.charAt(i);
            if(trobat){
                puntuacio = puntuacio + c;
            }
            else{
                id = id + c;
            }
            if(c == ' ') {
                trobat = true;
            }
        }

        contingut = contingut + id + "ha estat de " + puntuacio;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(compte, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(compte));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatari));
            message.setSubject(assumpte);
            message.setText(contingut);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
