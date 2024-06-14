package org.gen.italy;

import java.time.LocalDate;
import java.util.Scanner;

import org.gen.italy.model.MobileApp;
import org.gen.italy.model.Recensione;

public class Main {

	public static void main(String[] args) {

		Scanner sc=new Scanner (System.in);
		
		//si chiede all'utente di inserire nome app, sistemaoperativo, prezzo
		System.out.println("***CREAZIONE NUOVA APP***");
		System.out.print("Inserisci il nome dell'app: ");
		String nomeApp=sc.nextLine();
		System.out.print("Inserisci il sistema operativo: ");
		String sistemaOperativo=sc.nextLine();
		System.out.print("Inserisci il prezzo: ");
		float prezzo=sc.nextFloat();
		sc.nextLine();
		
		//creo oggetto della classe MobileApp passando al costruttore i parametri inseriti dall'utente
		MobileApp app=new MobileApp(nomeApp, sistemaOperativo, prezzo);
	
	
		//menu
		int scelta;
		do {
			System.out.println("\n\nMenu App: ");
			System.out.println("1. Download singolo");
			System.out.println("2. Download multiplo");
			System.out.println("3. Ricevi recensione");
			System.out.println("4. Visualizza recensioni");
			System.out.println("5. Esci");
			System.out.println("Cosa vuoi fare? Inserisci nr. scelta ;)");
			scelta=sc.nextInt();
			sc.nextLine();
			
			switch (scelta) {
			case 1:
				app.download(); //scarica app
				System.out.println("La tua applicazione è stata scaricata correttamente!");
				break;
			case 2:  //download app multipli
				System.out.print("Inserisci il numero di download richiesti: ");
				int numeroDownload = sc.nextInt();
				app.download(numeroDownload);
				break;
				case 3: 
				System.out.print("Inserisci il nome utente: ");
				String nomeUtente=sc.nextLine(); 
				System.out.print("Valuta l'app! Inserisci il numero di stelle da 1 a 5!");
				int numeroStelle=sc.nextInt();
				sc.nextLine();
				System.out.print("Inserisci il testo della recensione: ");
				String testoRecensione=sc.nextLine();
				Recensione recensione = new Recensione(LocalDate.now(), nomeUtente, numeroStelle, testoRecensione);
				app.riceviRecensione(recensione);
				break;
			case 4: 
				System.out.println("Recensioni: ");
				for (Recensione r: app.getElencoRecensioni()) { //foreach
					System.out.println(r.getData() + " - " + r.getNomeUtente() + " - " + r.getNumeroStelle() + " stelle");
					System.out.println(r.getTesto());
				}
				break;
			case 5: 
				System.out.println("Uscita...");
				System.out.println("Alla prossima!!!");
				break; 
				default: 
					System.out.println("Opzione non valida");
			}
			
			//visualizzare dati mobileapp
			if (scelta !=5) {
			System.out.println("\n\nDati MobileApp");
			System.out.println("Valutazione media: " + app.valutazioneMedia());
			System.out.println("Ricavo totale: " + app.getRicavoTotale());
			}
		} while (scelta !=5);
		sc.close();
	}

}
