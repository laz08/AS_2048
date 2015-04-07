package practicaAS;
/*
@Entity
@Table(name="CASELLA")
*/
public class Casella {
	//@Id 
	private int numeroFila;
	//@Id 
	private int numeroColumna;
	private int numero;
	
	public Casella(int numFila, int numCol){
		numeroFila = numFila;
		numeroColumna = numCol;
		numero = 0;
	}
	
	public int getFila(){
		return numeroFila;
	}
	public int getColumna(){
		return numeroColumna;
	}
	public void setPuntuacio(int num){
		numero = num;
	}
	public int getPuntuacio(){
		return numero;
	}
	public void setNumero(int num){
		numero = num;
	}
	
}
