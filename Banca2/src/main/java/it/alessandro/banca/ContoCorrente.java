package it.alessandro.banca;

public class ContoCorrente {
	protected String numeroContoCorrente;
	protected double saldo;
	
	
	public ContoCorrente(String numeroContoCorrente, double saldo) {
		this.numeroContoCorrente=numeroContoCorrente;
		this.saldo=saldo;
	
	}


	public String getNumeroContoCorrente() {
		return numeroContoCorrente;
	}


	public void setNumeroContoCorrente(String numeroContoCorrente) {
		this.numeroContoCorrente = numeroContoCorrente;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "numero conto= " + numeroContoCorrente + "saldo= " + saldo;
	}
}
