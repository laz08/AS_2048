package DomainLayer.DomainController;


import DomainLayer.DataInterface.CtrlUsuari;
import DomainLayer.DomainModel.Usuariregistrat;
import DomainLayer.Factories.CtrlDataFactoria;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlCULogin {

    private Usuariregistrat usuariR;

    public CtrlCULogin(){

    }

    public void Login(String userN, String passwd) throws Exception{
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlUsuari cu = ctrlDataFactoria.getCtrlUsuari();
        String pwd;
        try {
            usuariR = cu.get(userN);
            pwd = usuariR.getPwd();
            System.out.println(pwd);
            System.out.println(passwd);
        }
        catch(Exception e){
            throw e;
        }
        if (!passwd.equals(pwd)) throw new Exception("Password Incorrecte");
    }
}
