package org.gen.italy.model;

import java.util.ArrayList;

public class MobileApp {

	private String nome;
	private String sistemaOperativo;
	private float prezzo;
	private ArrayList<Recensione> elencoRecensioni = new ArrayList<Recensione>();
	private float ricavoTotale;
	
	//metodo costruttore per inizializzare attributi nome, sist.op., prezzo
	public MobileApp (String nome, String sistemaOperativo, float prezzo) {
		setNome(nome);
		setSistemaOperativo(sistemaOperativo);
		setPrezzo(prezzo);
		this.elencoRecensioni = new ArrayList<Recensione>(); //inizializziamo elenco recensioni 
		this.ricavoTotale=0; //valore ricavo totale impostato a 0
	}

	//getter e setter
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome==null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome non può essere vuoto");
		}
		this.nome = nome;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		if (sistemaOperativo==null || sistemaOperativo.isEmpty()) {
			throw new IllegalArgumentException("SistemaOperativo non può essere vuoto");
		}
		this.sistemaOperativo = sistemaOperativo;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		if (prezzo<0) {
			throw new IllegalArgumentException("Il prezzo non può essere uguale a 0");
		}
		this.prezzo = prezzo;
	}

	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}

	public float getRicavoTotale() {
		return ricavoTotale;
	}
	
	//metodo download - che incrementa il ricavoTotale del valore del prezzo
	public void download() {
		ricavoTotale+=prezzo;
	}
	
	public void download(int numeroDownload) { //incrementa il ricavoTotale del valore del prezzo*numeroDownload
		if (numeroDownload<0) {
			throw new IllegalArgumentException("Il numero di download non può essere uguale a zero");
		} ricavoTotale += prezzo*numeroDownload;
	}
	
	//metodo riceviRecensione - x aggiungere recneioni all'elenco
	public void riceviRecensione(Recensione recensione) {
		if (recensione !=null) {
			elencoRecensioni.add(recensione);
		}
	}
	//metodo valutazionemedia per calcolare media
	public float valutazioneMedia() {
		if (elencoRecensioni.isEmpty()) {
			return 0;
		}
		int sommaStelle=0;
		for (Recensione recensione:elencoRecensioni) {
			sommaStelle += recensione.getNumeroStelle();
		}
		return (float) sommaStelle/elencoRecensioni.size();
	}
}
