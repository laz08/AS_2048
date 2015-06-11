package DomainLayer;

/**
 * Created by Miquel on 11/06/2015.
 */
public class CtrlDataFactoria {
    private static CtrlDataFactoria ourInstance = new CtrlDataFactoria();

    public static CtrlDataFactoria getInstance() {
        return ourInstance;
    }

    private CtrlDataFactoria() {
    }

    public CtrlUsuari getCtrlUsuari(){
        CtrlUsuari ctrlUsuari = new CtrlUsuari();
        return ctrlUsuari;

    }
}
