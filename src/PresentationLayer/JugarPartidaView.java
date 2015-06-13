package PresentationLayer;


import DomainLayer.Partida;

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

    public JugarPartidaView(JugarPartidaController jpc){
        autenticacioView = new Autenticacio(jpc);
        menuPrincipal = new MenuPrincipal(jpc);
        ranking = new Ranking(jpc);
        partidaFinalitzada = new PartidaFinalitz(jpc);
        partidaEnCurs = new PartidaEnCurs(jpc);
        addKeyListener(this);
        setFocusable(true);
        estemAPartidaEnCurs = false;
    }

    public void prepareAut() {
        estemAPartidaEnCurs = false;
        autenticacioView.main(this);
    }

    public void prepareMenuPrincipal(){
        estemAPartidaEnCurs = false;
        menuPrincipal.main(this);
    }

    public void prepareRanking(){
        estemAPartidaEnCurs = false;
        ranking.main(this);
    }

    public void prepareAcabaPartida(boolean guanyada){
        estemAPartidaEnCurs = false;
        partidaFinalitzada.main(this, guanyada);
    }

    public void preparePartida(int puntActual, int millorPunt, ArrayList<Partida.StructCasella> caselles){
        estemAPartidaEnCurs = true;
        partidaEnCurs.main(this, puntActual, millorPunt, caselles);
    }


    //Tecles
    @Override
    public void keyPressed(KeyEvent event) {
        if(estemAPartidaEnCurs) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP:
                    // up arrow
                    //TODO: A cada moviment, fer partidaEnCurs.ferMoviment(); etc
                    break;
                case KeyEvent.VK_DOWN:
                    // down arrow
                    break;
                case KeyEvent.VK_RIGHT:
                    // right arrow
                    break;
                case KeyEvent.VK_LEFT:
                    // left arrow
                    break;
            }
        }
    }

    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }


    // GETTERS

    public Autenticacio getAutenticacioView() {
        return autenticacioView;
    }

    public MenuPrincipal getMenuPrincipal() {
        return menuPrincipal;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public PartidaFinalitz getPartidaFinalitzada() {
        return partidaFinalitzada;
    }

    public PartidaEnCurs getPartidaEnCurs() {
        return partidaEnCurs;
    }
}
