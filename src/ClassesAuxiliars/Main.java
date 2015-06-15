package ClassesAuxiliars;

import DomainLayer.DomainModel.Casella;
import DomainLayer.DomainModel.Partida;

import java.util.Scanner;

/**
 * Created by Víctor on 13/06/2015.
 */
public class Main {
    private static int count_o=1;
    private static final int MOVIMENT_AVALL=count_o++;//1
    private static final int MOVIMENT_DRETA=count_o++;//2
    private static final int MOVIMENT_ESQUERRE=count_o++;//3
    private static final int MOVIMENT_AMUNT=count_o++;//4

    private static Scanner sc;

    private static Partida partida;
    //private static Casella casella;

    public static  void main(String[] args) {
        programa();
    }

    private static void programa() {
        partida = new Partida(1);
        sc = new Scanner(System.in);

        System.out.println("BENVINGUT A L'APLICACIÓ");
        System.out.println("Matriu primera:");

        Casella[][] resultat = partida.getCaselles();
        escriureCaselles(resultat);

        int option = menu();

        while (option != 0) {
            if (option == MOVIMENT_AVALL)  movimentAvall();
            if (option == MOVIMENT_DRETA)  movimentDreta();
            if (option == MOVIMENT_ESQUERRE)  movimentEsquerre();
            if (option == MOVIMENT_AMUNT)  movimentAmunt();

            option=menu();
        }
    }


    private static int menu(){
        System.out.println("\n\n**********\nMENÚ PRINCIPAL");
        System.out.println("Selecciona una opció:");
        System.out.println(MOVIMENT_AVALL+") MOVIMENT AVALL");
        System.out.println(MOVIMENT_DRETA+") MOVIMENT DRETA");
        System.out.println(MOVIMENT_ESQUERRE+") MOVIMENT ESQUERRE");
        System.out.println(MOVIMENT_AMUNT+") MOVIMENT AMUNT");

        int option = Integer.parseInt(sc.nextLine());
        System.out.println("Opcio seleccionada "+option);
        return option;
    }



    private static void movimentAvall() {
        partida.ferMoviment("Avall");
        Casella[][] resultat = partida.getCaselles();
        escriureCaselles(resultat);
    }

    private static void movimentDreta() {
        partida.ferMoviment("Dreta");
        Casella[][] resultat = partida.getCaselles();
        escriureCaselles(resultat);
    }

    private static void movimentEsquerre() {
        partida.ferMoviment("Esquerre");
        Casella[][] resultat = partida.getCaselles();
        escriureCaselles(resultat);
    }

    private static void movimentAmunt() {
        partida.ferMoviment("Amunt");
        Casella[][] resultat = partida.getCaselles();
        escriureCaselles(resultat);
    }

    private static void escriureCaselles(Casella[][] caselles) {
        for (int i = 0; i < caselles.length; ++i) {
            for (int j = 0; j < caselles[0].length; ++j) {
                int num = caselles[i][j].getNumero();
                System.out.print(num);
            }
            System.out.println(' ');
        }
    }
}
