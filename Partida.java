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
	private boolean[] modificats;
	
	
	public Partida(int id, String jug){
		id_partida = id+1;
		puntuacio = 0;
		estaAcabada = false;
		estaGuanyada = false;
		username = jug;
		caselles = new ArrayList<Casella>();
		modificats = new boolean[16];
		
		//Inicialitzem les caselles
		for(int i = 0; i < 16; ++i){
			Casella c = new Casella(i/4, i%4);
			caselles.add(i, c);
		}
		
	}
	public boolean esGuanyada(){
		return estaGuanyada;
	}
	public boolean esPerduda(){
		return !(estaAcabada && estaGuanyada);
	}
	public boolean esAcabada(){
		return estaAcabada;
	}
	
	
}
