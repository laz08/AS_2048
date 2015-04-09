package practicaAS;

import java.util.ArrayList;
import java.util.Random;

/*
@Entity
@Table(name="PARTIDA")
*/
public class Partida {
	//@Id 
	private int id_partida;
	private int puntuacio;
	private boolean estaAcabada;
	private boolean estaGuanyada;
	private String username;
	private ArrayList<Casella> caselles;
	
	
	public Partida(int id, String jug){
		id_partida = id+1;
		puntuacio = 0;
		estaAcabada = false;
		estaGuanyada = false;
		username = jug;
		caselles = new ArrayList<Casella>();
		
		//Inicialitzem les caselles
		for(int i = 0; i < 16; ++i){
			Casella c = new Casella(i/4, i%4);
			caselles.add(i, c);
		}
		
	}
	public int getIdPartida(){
		return id_partida;
	}
	
	public String getUsername(){
		return username;
	}
	public int getPuntuacio(){
		return puntuacio;
	}
	public void setPuntuacio(int p){
		puntuacio = p;
	}
	
	public boolean esGuanyada(){
		return estaGuanyada;
	}
	public void setEstaGuanyada(boolean g){
		estaGuanyada = g;
	}

	public void setEstaAcabada(boolean a){
		estaAcabada = a;
	}
	public boolean esAcabada(){
		return estaAcabada;
	}
	
	
}
