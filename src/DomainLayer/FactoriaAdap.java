package DomainLayer;

/**
 * Created by Miquel on 13/06/2015.
 */
public class FactoriaAdap {
    private IAdapMissatgeria am;
    private static FactoriaAdap ourInstance = new FactoriaAdap();

    public static FactoriaAdap getInstance() {
        return ourInstance;
    }

    private FactoriaAdap() {
    }

    public IAdapMissatgeria getAdMissatgeria() {
        if(am == null)
            am = new AdapMissatgeria();
        return am;
    }
}
