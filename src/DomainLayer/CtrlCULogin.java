package DomainLayer;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlCULogin {

    public CtrlCULogin(){

    }

    public void Login(String userN, String passwd){
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlUsuari cu = ctrlDataFactoria.getCtrlUsuari();
        UsuariRegistrat u = cu.getUsuari(userN);
        String password = u.getPassword();
        if(passwd.equals(password)) {
            throw new RuntimeException("pwdIncorrecte");
        }
    }
}
