package DomainLayer;

import java.io.IOException;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlCULogin {

    private UsuariRegistrat usuariR;

    public CtrlCULogin(){

    }

    public void Login(String userN, String passwd) throws IOException{
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlUsuari cu = ctrlDataFactoria.getCtrlUsuari();
        usuariR = cu.getUsuari(userN);
        String pwd = usuariR.getPwd();
        if (!passwd.equals(pwd)) throw new IOException("Password Incorrecte");
    }
}
