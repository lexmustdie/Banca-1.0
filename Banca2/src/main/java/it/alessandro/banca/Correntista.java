package it.alessandro.banca;

import java.util.ArrayList;

public class Correntista {
	protected String nome;
	protected String cognome;
	protected String codiceFiscale;
	
	ArrayList<ContoCorrente> contoCorrente= new ArrayList<ContoCorrente>();
	
	
	public Correntista(String nome, String cognome, String codiceFiscale, String numeroContoCorrente, double saldo) {
		this.nome=nome;
		this.cognome=cognome;
		this.codiceFiscale=codiceFiscale;
		this.contoCorrente.add(new ContoCorrente(numeroContoCorrente, saldo));
		
	}
	public Correntista(String nome, String cognome, String codiceFiscale) {
		this.nome=nome;
		this.cognome=cognome;
		this.codiceFiscale=codiceFiscale;
	}
	public void addConto(ContoCorrente conto) {
		this.contoCorrente.add(conto);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public void setCorrentista(Correntista correntista) {
		this.nome=correntista.getNome();
		this.cognome=correntista.getCognome();
		this.codiceFiscale=correntista.getCodiceFiscale();
		
		contoCorrente.clear();
		if(correntista.contoCorrente.size()>1) {
			for(int i=0;i<correntista.contoCorrente.size();i++) {
				this.contoCorrente.add(new ContoCorrente(correntista.contoCorrente.get(i).getNumeroContoCorrente(),correntista.contoCorrente.get(i).getSaldo()));
			}
		
		}
	}
	public String toString() {
		return "Correntista [nome=" + nome + ", cognome=" + cognome + ", codice fiscale=" + codiceFiscale + ", conto corrente=" + contoCorrente + "]";
	}
	
}
