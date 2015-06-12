package DomainLayer;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlDataFactoria {
    private static CtrlDataFactoria ourInstance = new CtrlDataFactoria();
    private CtrlUsuari ctrlUsuari;

    public static CtrlDataFactoria getInstance() {
        return ourInstance;
    }

    private CtrlDataFactoria() {
    }

    public CtrlUsuari getCtrlUsuari(){
        if(ctrlUsuari == null) //Si encara no l'hem instanciat
            ctrlUsuari = new CtrlUsuari();
        return ctrlUsuari;

    }
}
