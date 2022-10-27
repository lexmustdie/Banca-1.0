package it.alessandro.banca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Banca {

	ArrayList<Correntista> correntista = new ArrayList<Correntista>();
	Scanner input = new Scanner(System.in);
	
	public void Caricamento(){
		
		String nome; 
		String cognome;
		String codiceFiscale;
		
		
		int scelta = 1;
		int numeroCorrentisti = 1;
		boolean doppione = false;
		System.out.println("Quanti correntisti vuoi inserire?");
		numeroCorrentisti=Integer.parseInt(input.nextLine());
		
				if(numeroCorrentisti<=0) 
				{
						while(numeroCorrentisti<=0) {
						System.out.println("Devi inserire almeno un correntista");
						numeroCorrentisti=Integer.parseInt(input.nextLine());
						}
				}
				
		while(numeroCorrentisti>0 && scelta !=3)
		{
		System.out.println("*********************");
		System.out.println("*Cosa vuoi inserire?*");
		System.out.println("*1-Correntista      *");
		System.out.println("*2-Conto            *");
		System.out.println("*3-Esci             *");
		System.out.println("*********************");
		scelta=Integer.parseInt(input.nextLine());
		
		switch(scelta) 
		{
		case 1:
			int i=0;
			int j=0;
			
			
			for (i=0; i<numeroCorrentisti; i++) {
			System.out.println("Inserire nome");
			nome=input.nextLine();
			System.out.println("Inserire cognome");
			cognome=input.nextLine();
			System.out.println("Inserire codice fiscale");
			codiceFiscale=input.nextLine();
			
			
				for (j=0;j<correntista.size();j++) 
				{
					if(correntista.get(j).codiceFiscale.equals(codiceFiscale)) 
						{
						    doppione=true;
							if(doppione==true) 
							{
									System.out.println("Codice fiscale già presente");
									
									i--;
									
							}
							
							
						}
				}
				if(doppione==false) 
					{
						System.out.println("Correntista/i inserito/i correttamente");
						correntista.add(new Correntista(nome, cognome, codiceFiscale));
					}

			}
			
			

			
			
			
			break;
		
		
		case 2:
			String numeroContoCorrente;
			double saldo;
			boolean cfTrovato1=false;
			boolean contoTrovato=false;
			
			
			System.out.println("Inserire codice fiscale");
			String ricercaCodiceFiscale=input.nextLine();
			for(i=0; i<correntista.size();i++) 
			{
				if(correntista.get(i).codiceFiscale.compareTo(ricercaCodiceFiscale)==0) 
				{
					cfTrovato1=true;
					
						System.out.println("Inserire codice conto");
						numeroContoCorrente=input.nextLine();
						
							for(j=0;j<correntista.size();j++)
							{
								for(int x=0; x<correntista.get(j).contoCorrente.size();x++) {
									if(correntista.get(i).contoCorrente.get(j).numeroContoCorrente.equals(numeroContoCorrente))
									{
											contoTrovato=true;
											
											System.out.println("Numero conto già registrato");
									}
								}
							
						}
							if(contoTrovato==false) {
								System.out.println("Inserire saldo iniziale");
								saldo=Double.parseDouble(input.nextLine());
								correntista.get(i).addConto(new ContoCorrente(numeroContoCorrente, saldo));
								System.out.println("Conto inserito correttamente");
									}
						
					
				}	
				
				
			
			}
			if(cfTrovato1==false) {
				System.out.println("Codice fiscale non trovato");
			}
			
			break;
		
		case 3:
			System.out.println("Torno al menù principale");
			
			break;
		
		default:
			System.out.println("Scelta non valida");
			break;
			}
		}
		
		
		
	}
	
	public void ModificaDati() {
		
		int scelta;
		String ricercaNome;
		String ricercaCognome;
		String ricercaCodiceFiscale;
		String nuovoNome;
		String nuovoCognome;
	
		System.out.println("**********************");
		System.out.println("*Ricerca:            *");
		System.out.println("*1-Per nome e cognome*");
		System.out.println("*2-Per codice fiscale*");
		System.out.println("*3-Torna al menu     *");
		System.out.println("**********************");
		scelta=Integer.parseInt(input.nextLine());
		
		while(scelta!=3) {
		switch(scelta) {
		case 1://Ricerca per nome e cognome
			
			System.out.println("Inserire nome");
			ricercaNome=input.nextLine();
			System.out.println("Inserire cognome");
		ricercaCognome=input.nextLine();
		int corrTrovato=0;
		
		for(int i=0; i<correntista.size();i++) {
			if(correntista.get(i).nome.compareTo(ricercaNome)==0 && correntista.get(i).cognome.compareTo(ricercaCognome)==0)
			{
				corrTrovato++;	
				}
			if(corrTrovato==1) {
				System.out.println("Utente trovato: " + correntista.get(i).nome + " " + correntista.get(i).cognome);
				System.out.println("Inserire nuovo nome");
				nuovoNome=input.nextLine();
				System.out.println("Inserire nuovo cognome");
				nuovoCognome=input.nextLine();
				
				correntista.get(i).setNome(nuovoNome);
				correntista.get(i).setCognome(nuovoCognome);
				}			
			if(corrTrovato>1)
			{
				System.out.println("Ci sono più utenti con lo stesso nome e cognome, provare a cercare per codice fiscale");
			}

			if (corrTrovato==0)
			{
				System.out.println("Utente non trovato");
			}
			
		}
		
		
		break;
		
		case 2://Ricerca per codice fiscale
		System.out.println("Inserire codice fiscale");
		ricercaCodiceFiscale=input.nextLine();
		boolean corrTrovato1=false;
		for(int i=0; i<correntista.size();i++) 
		{
			if(correntista.get(i).codiceFiscale.compareTo(ricercaCodiceFiscale)==0) 
			{
				corrTrovato1=true;
				
			}
				
			if(corrTrovato1==true) 
			{
				System.out.println("Utente corrispondente al codice fiscale inserito : " + correntista.get(i).nome + " " + correntista.get(i).cognome);
				System.out.println("Inserire nuovo nome");
				nuovoNome=input.nextLine();
				System.out.println("Inserire nuovo cognome");
				nuovoCognome=input.nextLine();
				
					correntista.get(i).setNome(nuovoNome);
					correntista.get(i).setCognome(nuovoCognome);
				
			}
			if(corrTrovato1==false)
			{
				System.out.println("Utente non trovato");
			}
				
		}
		
		
			
		break;
		
		case 3:
			System.out.println("Torno al menu' principale");
			break;
	default:			
			System.out.println("Opzione non valida");
			break;				
			}
		}
	}
	
	public Correntista OrdinaPerCognome() {
		
		
		correntista.sort((primoCognome, secondoCognome) -> primoCognome.getCognome().compareTo(secondoCognome.getCognome()));
		
		for(Correntista cognomi : correntista) {
			System.out.println(cognomi.getCognome());
		}
		return null;
	
		
	}
	public void Versamento() { 
		int i;
		String RicercaNumeroCC;
		boolean contoTrovato=false;
		boolean cfTrovato1=false;
		double addSaldo;
		System.out.println("Inserire codice fiscale");
		String ricercaCodiceFiscale=input.nextLine();
		
		for(i=0; i<correntista.size();i++) {
			if(correntista.get(i).codiceFiscale.compareTo(ricercaCodiceFiscale)==0) 
			{
				cfTrovato1=true;
				if (cfTrovato1=true) 
				{
					System.out.println("Inserire codice conto");
					RicercaNumeroCC=input.nextLine();
					for(int j=0;j<correntista.get(i).contoCorrente.size();j++) 
					{
						if(correntista.get(i).contoCorrente.get(j).numeroContoCorrente.compareTo(RicercaNumeroCC)==0)
						{
								contoTrovato=true;
								if(contoTrovato==true) 
								{
									System.out.println("Conto trovato, saldo disponibile " + correntista.get(i).contoCorrente.get(j).saldo);
									try {
										System.out.println("Quanto si desidera versare nel conto?");
										addSaldo=Double.parseDouble(input.nextLine());
										if(addSaldo<=0)
										{
											System.out.println("valore non valido");
										}
										if(addSaldo>0)
										{
										correntista.get(i).contoCorrente.get(j).saldo=correntista.get(i).contoCorrente.get(j).saldo+addSaldo;
										System.out.println("Saldo totale attuale associato al conto " + correntista.get(i).contoCorrente.get(j).saldo);
										}
										}
										catch (NumberFormatException ex) {
										System.out.println("Valore non inserito correttamente");
										}
								}
						}
						if(contoTrovato==false)
						{
							System.out.println("Conto non trovato");
						}
					}	
					
					
				}
			}
			if(cfTrovato1==false) {
				System.out.println("Codice fiscale non trovato");
			}
			
		}
		
			
	}
	public void Prelievo() {
		int i;
		String RicercaNumeroCC;

		boolean contoTrovato=false;
		boolean cfTrovato1=false;
		double prelievo;
		System.out.println("Inserire codice fiscale");
		String ricercaCodiceFiscale=input.nextLine();
		
		for(i=0; i<correntista.size();i++) {
			if(correntista.get(i).codiceFiscale.compareTo(ricercaCodiceFiscale)==0) 
			{
				cfTrovato1=true;
				if (cfTrovato1=true) 
				{
					System.out.println("Inserire codice conto");
					RicercaNumeroCC=input.nextLine();
					for(int j=0;j<correntista.get(i).contoCorrente.size();j++) 
					{
						if(correntista.get(i).contoCorrente.get(j).numeroContoCorrente.compareTo(RicercaNumeroCC)==0)
						{
								contoTrovato=true;
								if(contoTrovato==true) 
								{
									System.out.println("Conto trovato, saldo disponibile " + correntista.get(i).contoCorrente.get(j).saldo);
									try {
										System.out.println("Quanto si desidera prelevare dal conto?");
										prelievo=Double.parseDouble(input.nextLine());
										if(correntista.get(i).contoCorrente.get(j).saldo<prelievo) 
										{
											System.out.println("Denaro non disponibile");
										}
										if(correntista.get(i).contoCorrente.get(j).saldo>=prelievo)
										{
										correntista.get(i).contoCorrente.get(j).saldo=correntista.get(i).contoCorrente.get(j).saldo-prelievo;
										System.out.println("Saldo totale attuale associato al conto " + correntista.get(i).contoCorrente.get(j).saldo);
										}
										
										}
										catch (NumberFormatException ex) {
										System.out.println("Valore non inserito correttamente");
										}
								}
						}
						if(contoTrovato==false)
						{
							System.out.println("Conto non trovato");
						}
					}	
					
					
				}
		   }
		   if(cfTrovato1==false) {
			System.out.println("Codice fiscale non trovato");
			}
			
		}
		
			
	}
	
	public void Stampa() {
		System.out.println(correntista);
	}
	
}
