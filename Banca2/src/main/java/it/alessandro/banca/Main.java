package it.alessandro.banca;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numeroCorrentisti = 1;
		Banca banca = new Banca();
			int scelta=0;
			boolean correntistiIns=false;
			while(scelta!=7) {
			System.out.println("*****************************************");
			System.out.println("*Selezionare opzione:                   *");
			System.out.println("*1-Inserisci utente                     *");
			System.out.println("*2-Modifica dati utenti                 *");
			System.out.println("*3-Ordina/stampa correntisti per cognome*");
			System.out.println("*4-Prelievo                             *");
			System.out.println("*5-Versamento                           *");
			System.out.println("*6-Ricerca e stampa dei conti correnti  *");
			System.out.println("*7-Esci                                 *");
			System.out.println("*****************************************");
			scelta=Integer.parseInt(input.nextLine());
			
			switch (scelta) {
			case 1://Inserimento (Fare i controlli e suddividere arraylist)
				banca.Caricamento();
				break;			
			case 2://Modifica dati
			    banca.ModificaDati();
			    break;
			case 3://Ordina per cognome
				banca.OrdinaPerCognome();
				break;
			case 4: //Prelievo
				banca.Prelievo();
				break;
			case 5: //Versamento
				banca.Versamento();
				break;
			case 6:	//Stampa conti correnti associati al correntista selezionato	
				banca.Stampa();
				break;
			case 7:
				System.out.println("Arrivederci");
				break;
			default:
				System.out.println("Scelta non valida");
				break;
			}
			}
	}

}
