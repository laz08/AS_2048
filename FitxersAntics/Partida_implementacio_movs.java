package DomainLayer;

import java.util.ArrayList;
import java.util.Random;

/*
@Entity
@Table(name="PARTIDA")
*/
public class Partida2 {
	//@Id 
	private int id_partida;
	private int puntuacio;
	private boolean estaAcabada;
	private boolean estaGuanyada;
	private String username;
	private ArrayList<Casella> caselles;
	private boolean[] modificats;
	
	
	public Partida2(int id, String jug){
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
		
		escullCasellaAleatoriaAssignaValor();
		//Escollim aleatòriament dues caselles
		/*
		 * int i1, i2, j1, j2;
		 * i1 = Random()%4;
		 * i2 = Random()%4;
		 * j1 = Random()%4;
		 * j2 = Random()%4;
		 */
		
		//DUMMY
		Casella c = caselles.get(5);
		c.setNumero(2);
		c = caselles.get(1);
		c.setNumero(4);
		c = caselles.get(13);
		c.setNumero(2);
		
	}
	/**
	 * 
	 * @param tipusMov
	 * tipusMov pot prendre valors de:
	 * 		-Amunt
	 * 		-Avall
	 * 		-Esquerra
	 * 		-Dreta
	 */
	public void ferMoviment(String tipusMov){
		//Inicialitzem moviments a fals per a cada moviment
		modificats = new boolean[16];
		switch(tipusMov){
		case "Amunt":
			movAmunt();
			break;
		case "Avall":
			movAvall();
			break;
		case "Esquerra":
			movEsquerra();
			break;
		case "Dreta":
			movDreta();
			break;
		}
		esAcabada(); //Comprovem si acaba
		if(!estaAcabada)
			escullCasellaAleatoriaAssignaValor();
	}
	
	// ### --- MOVIMENTS --- ### //
	private void movAmunt(){
		for(int i = 4; i < 16; ++i){
			Casella c = caselles.get(i);
			//Si té número,el desplacem fins trobar un altre número o la vora
			int puntC = c.getNumero();
			if(puntC != 0){
				//System.out.println("He trobat la casella " + i + " amb puntuacio " + puntC);
				int j = i-4;
				while(j>=0){
					Casella tmp = caselles.get(j);
					int puntTmp = tmp.getNumero();
					if(puntC == puntTmp && !modificats[j]){
						//System.out.println("He trobat la casella " + i + " amb puntuacio " + puntC + " sense modificar");
						tmp.setNumero(puntC + puntTmp);
						c.setNumero(0);
						c = tmp;
						modificats[j] = true;
					}
					else if (puntTmp == 0){
						tmp.setNumero(puntC);
						c.setNumero(0);
						c = tmp;
					}
					j-=4;
				}
			}
		}
	}
	
	private void movAvall(){
		for(int i = 11; i >= 0 ; --i){
			Casella c = caselles.get(i);
			//Si té número,el desplacem fins trobar un altre número o la vora
			int puntC = c.getNumero();
			if(puntC != 0){
				int j = i+4;
				while(j<16){
					Casella tmp = caselles.get(j);
					int puntTmp = tmp.getNumero();
					if(puntC == puntTmp && !modificats[j]){
						tmp.setNumero(puntC + puntTmp);
						c.setNumero(0);
						c = tmp;
						modificats[j] = true;
					}
					else if (j > 12 && puntTmp == 0){
						tmp.setNumero(puntC);
						c.setNumero(0);
						c = tmp;
					}
					j+=4;
				}
			}
		}
	}
	
	private void movEsquerra(){
		//TODO Bug movent cap a esquerra
		for (int i = 1; i < 16; ++i){
			if(i%4 != 0){
				Casella c = caselles.get(i);
				//Si té número,el desplacem fins trobar un altre número o la vora
				int puntC = c.getNumero();
				if(puntC != 0){
					int j = i;
					while(j%4 != 0){
						--j;
						Casella tmp = caselles.get(j);
						int puntTmp = tmp.getNumero();
						if(puntC == puntTmp && !modificats[j]){
							tmp.setNumero(puntC + puntTmp);
							c.setNumero(0);
							c = tmp;
							modificats[j] = true;
						}
						else if (j  >= 0 && puntTmp == 0){
							tmp.setNumero(puntC);
							c.setNumero(0);
							c = tmp;
						}
					}
				}
			}
		}
		
	}
	private void movDreta(){
		
	}
	
	private void comprovaPartidaGuanyada(){
		boolean guanyada = false;
		for(int i = 0; i < 16 && !guanyada; ++i){
			Casella c = caselles.get(i);
			if(c.getNumero() == 2048){
				guanyada = true;
			}
		}
		if(guanyada){
			//TODO Enviar Missatge(idPartida + puntuacio)
			estaAcabada = true;
			estaGuanyada = true;
		}
	}
	private void comprovaPartidaPerduda(){
		boolean perduda = true;
		for(int i = 0; i < 16 && perduda; ++i){
			Casella c = caselles.get(i);
			int punt = c.getNumero();
			if(pucFerMoviment() || punt == 2048) perduda = false;
		}
	}
	private boolean pucFerMoviment(){
		//TODO Polir una mica la comprovació, està "mal" feta (ineficient)
		boolean existeixMovPossible = false;
		int i = 0;
		while (!existeixMovPossible && i < 16){
			Casella c = caselles.get(i);
			int puntC = c.getNumero();
			if(puntC == 0)  existeixMovPossible = true;
			else{
				//Comprovem adjacents
				Casella tmp;
				int pos;
				//Amunt
				pos = i-4;
				if(i >= 0){
					tmp = caselles.get(pos);
					existeixMovPossible = (tmp.getNumero() == puntC);
				}
				//Esquerre
				pos = i-1;
				if(i >= 0){
					tmp = caselles.get(pos);
					existeixMovPossible = (tmp.getNumero() == puntC);
				}
				
				//Dreta
				pos = i+1;
				if(i < 16){
					tmp = caselles.get(pos);
					existeixMovPossible = (tmp.getNumero() == puntC);
				}
				
				//Avall
				pos = i+4;
				if(i < 16){
					tmp = caselles.get(pos);
					existeixMovPossible = (tmp.getNumero() == puntC);
				}
			}
			++i;
		}
		return existeixMovPossible;
	}
	
	public int consultaPuntuacioCasella(int i){
		Casella c = caselles.get(i);
		return c.getNumero();
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
	
	private void escullCasellaAleatoriaAssignaValor(){
		Random r = new Random();
		ArrayList<Casella> casellesBuides = new ArrayList<Casella>();
		for(int i = 0; i < caselles.size(); ++i){
			Casella c = caselles.get(i);
			if(c.getNumero() == 0)
				casellesBuides.add(c);
		}
		if(casellesBuides.size() != 0){;
			int num = r.nextInt(casellesBuides.size()+1);
			System.out.println(num);
			//Assignem valor random a la casella
			int valor = r.nextInt(2);
			valor = (valor+1)*2;
			Casella c2 = caselles.get(num);
			c2.setNumero(valor);
		}
		else estaAcabada = true;
	}
	
}
