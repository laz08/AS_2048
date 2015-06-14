package DomainLayer;

import ExternalService.SvMissatgeria;

/**
 * Created by Miquel on 13/06/2015.
 */
public class AdapMissatgeria implements IAdapMissatgeria {
    public void enviarCorreu(String missatge,String destinatari){
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        SvMissatgeria ism = serviceLocator.fnd("ServeiMissatgeria");
        ism.enviarCorreu(missatge,destinatari);
    }
}
