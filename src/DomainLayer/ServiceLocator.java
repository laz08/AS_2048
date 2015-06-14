package DomainLayer;

import ExternalService.SvMissatgeria;

/**
 * Created by Miquel on 13/06/2015.
 */
public class ServiceLocator {
    private static ServiceLocator ourInstance = new ServiceLocator();

    public static ServiceLocator getInstance() {
        return ourInstance;
    }

    private ServiceLocator() {
    }

    public SvMissatgeria fnd(String servei){
        SvMissatgeria ism = new SvMissatgeria();
        if(servei.equals("ServeiMissatgeria")) return ism;
        return null;
    }
}
