package PresentationLayer;


import ClassesAuxiliars.StructRanking;
import DomainLayer.DomainModel.Partida;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class JugarPartidaView extends JFrame implements KeyListener{
    private Autenticacio autenticacioView;
    private MenuPrincipal menuPrincipal;
    private Ranking ranking;
    private PartidaFinalitz partidaFinalitzada;
    private PartidaEnCurs partidaEnCurs;
    private boolean estemAPartidaEnCurs;
    private JugarPartidaController jpc;
;

    /**
     * Finestra (vista) que es transforma segons la pantalla que ha de mostrar.
     * @param jpc
     */
    public JugarPartidaView(JugarPartidaController jpc){
        this.jpc = jpc;
        autenticacioView = new Autenticacio(jpc);
        menuPrincipal = new MenuPrincipal(jpc);
        ranking = new Ranking(jpc);
        partidaFinalitzada = new PartidaFinalitz(jpc);
        partidaEnCurs = new PartidaEnCurs(jpc);
        addKeyListener(this);
        setFocusable(true);
        estemAPartidaEnCurs = false;
    }

    /**
     * Permet transormar-se en la vista d'autenticació
     */
    public void prepareAut() {
        estemAPartidaEnCurs = false;
        autenticacioView.main(this);
    }

    /**
     * Permet transformar-se en la vista de menú principal
     */
    public void prepareMenuPrincipal(){
        estemAPartidaEnCurs = false;
        menuPrincipal.main(this);
    }

    /**
     * Permet transformar-se en la vista que mostra el Ranking
     * @param rank
     * @param srcIsMainMenu
     */
    public void prepareRanking(ArrayList<StructRanking> rank, boolean srcIsMainMenu){
        estemAPartidaEnCurs = false;
        ranking.main(this, rank, srcIsMainMenu);
    }

    /**
     * Permet transformar-se en la vista que es mostra un cop ha finalitzat la partida
     * @param guanyada
     * @param puntActual
     */
    public void prepareAcabaPartida(boolean guanyada,int puntActual){
        estemAPartidaEnCurs = false;
        partidaFinalitzada.main(this, guanyada, puntActual);
    }


    /**
     * Permet crear la vista d'una partida nova
     * @param puntActual
     * @param millorPunt
     * @param caselles
     */
    public void preparePartida(int puntActual, int millorPunt, ArrayList<Partida.StructCasella> caselles){
        estemAPartidaEnCurs = true;
        partidaEnCurs.preparePartida(puntActual, millorPunt, caselles);
        partidaEnCurs.main(this);
    }

    /**
     * Permet actualitzar la vista de la partida en curs (que conté el taulell)
     * @param guanyada
     * @param acabada
     * @param puntActual
     * @param caselles
     */
    public void actualitzaPartida(boolean guanyada,boolean acabada,int puntActual, ArrayList<Partida.StructCasella> caselles){
        if(acabada){
            prepareAcabaPartida(guanyada,puntActual);
        }
        else{
            estemAPartidaEnCurs = true;
            partidaEnCurs.actualitzaPartida(puntActual, caselles);
            partidaEnCurs.main(this);
        }
    }


    //Tecles

    /**
     * Equivaldria a totes les funcions "keyPressedUP, keyPressedDown" etc especificades
     * a la 2a entrega
     * @param event
     */
    @Override
    public void keyPressed(KeyEvent event) {
        if(estemAPartidaEnCurs) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP:
                    // up arrow
                    jpc.ferMoviment("Amunt");
                    break;
                case KeyEvent.VK_DOWN:
                    // down arrow
                    jpc.ferMoviment("Avall");
                    break;
                case KeyEvent.VK_RIGHT:
                    // right arrow
                    jpc.ferMoviment("Dreta");
                    break;
                case KeyEvent.VK_LEFT:
                    // left arrow
                    jpc.ferMoviment("Esquerra");
                    break;
            }
        }
    }

    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }

}
