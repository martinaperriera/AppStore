package org.gen.italy.model;

import java.time.LocalDate;

public class Recensione {

	private LocalDate data; 
	private String nomeUtente;
	private int numeroStelle;
	private String testo;
	
	//costruttore per inizializzare attributi recensione e per utilizzare metodo setNumeroStelle (per assicurare la validità)
	public Recensione (LocalDate data, String nomeUtente, int numeroStelle, String testo) {
		this.data=data;
		this.nomeUtente=nomeUtente;
		setNumeroStelle(numeroStelle);
		this.testo=testo;
	}

	//getter + setter
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public int getNumeroStelle() {
		return numeroStelle;
	}

	//validazione 
	public void setNumeroStelle(int numeroStelle) {
		if (numeroStelle<1 || numeroStelle>5) {
	        throw new IllegalArgumentException("Il numero di stelle deve essere compreso tra 1 e 5.");
		}
		this.numeroStelle = numeroStelle;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	
}
