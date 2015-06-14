package ExternalService;

/**
 * Created by Miquel on 13/06/2015.
 */
public class SvMissatgeria {
    public SvMissatgeria(){}
    public void enviarCorreu(String missatge,String destinatari){
        String compte = "";
        String password = "";
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
    }
}
