package controller;

import java.util.List;

import model.PrenotazioneAereo;

public interface ICrudService {
	
	public boolean inserisci(PrenotazioneAereo prenotazione); 

	public List<PrenotazioneAereo> leggi();

	public boolean rimuovi(int id); 
}
