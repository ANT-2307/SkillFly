package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PrenotazioneAereo;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import connettore.GestoreConnessione;


@WebServlet("/Avvio")
public class Avvio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected PrenotazioneAereo prenotazione = new PrenotazioneAereo();
	protected PrenotazioneAereo prenotazioneRitorno = new PrenotazioneAereo();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean esito = false;
		CrudService crud = new CrudService();
		String scelta = request.getParameter("scelta");
			if (scelta == null) {
				response.sendRedirect("home.html");
			}
			else {
				int choice = Integer.parseInt(scelta);
				switch(choice) {
				case 1:
					response.sendRedirect("homeForm.html");
					break;
				case 2:
					 List<PrenotazioneAereo> prenotazioni = crud.leggi();
					 request.getSession().setAttribute("prenotazioni", prenotazioni);
					 request.getRequestDispatcher("homeTabella.html").forward(request, response);
					 break;
				case 3:
					 esito = crud.rimuovi(Integer.parseInt(request.getParameter("id")));
					 response.sendRedirect("Avvio?scelta=4");
					 if(esito == true) {
						 System.out.println("operazione andata a buon fine");
					 }
					 else if(esito == false) {
						 System.out.println("operazione fallita");
					 }	
					 break;
			case 4:
				 prenotazioni = crud.leggi();
				 request.getSession().setAttribute("prenotazioni", prenotazioni);
				 request.getRequestDispatcher("tabella.jsp").forward(request, response);
				 break;
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean esito = false;
		GestoreConnessione gc = GestoreConnessione.getInstance();
		CrudService crud = new CrudService();
		String operazione = request.getParameter("operazione");
		
		switch(operazione) {
		case "preritorno":
		prenotazione.setNomeCliente(request.getParameter("nomeCliente"));
		prenotazione.setCognomeCliente(request.getParameter("cognomeCliente"));
		prenotazione.setCfCliente(request.getParameter("CfCliente"));
		prenotazione.setCompagniaAerea(request.getParameter("CompagniaAerea"));
		prenotazione.setnAdulti(Integer.parseInt(request.getParameter("nAdulti")));
		prenotazione.setnBambini(Integer.parseInt(request.getParameter("nBambini")));		
		prenotazione.setDataPartenza(Date.valueOf(request.getParameter("dataPartenza")));
		prenotazione.setDataArrivo(Date.valueOf(request.getParameter("dataArrivo")));
		prenotazione.setPartenza(request.getParameter("Partenza"));
		prenotazione.setDestinazione(request.getParameter("Destinazione"));
		prenotazione.setImportoPagato(Double.parseDouble(request.getParameter("ImportoPagato")));
		prenotazione.setBagaglio(Boolean.parseBoolean(request.getParameter("Bagaglio")));
		
		esito = crud.inserisci(prenotazione);
		System.out.println(esito);
		response.sendRedirect("richiestaRitorno.html");
		break;
		
		case "duplicazione":
			prenotazioneRitorno.setNomeCliente(prenotazione.getNomeCliente());
			prenotazioneRitorno.setCognomeCliente(prenotazione.getCognomeCliente());
			prenotazioneRitorno.setCfCliente(prenotazione.getCfCliente());
			prenotazioneRitorno.setCompagniaAerea(prenotazione.getCompagniaAerea());
			prenotazioneRitorno.setnAdulti(prenotazione.getnAdulti());
			prenotazioneRitorno.setnBambini(prenotazione.getnBambini());
			prenotazioneRitorno.setPartenza(prenotazione.getDestinazione());
			prenotazioneRitorno.setDestinazione(prenotazione.getPartenza());
			prenotazioneRitorno.setBagaglio(prenotazione.getBagaglio());
			
			response.sendRedirect("formRitorno.html");
			break;
			
		case "post-ritorno":
			prenotazioneRitorno.setDataPartenza(Date.valueOf(request.getParameter("dataPartenza")));
			prenotazioneRitorno.setDataArrivo(Date.valueOf(request.getParameter("dataRitorno")));
			prenotazioneRitorno.setImportoPagato(Double.parseDouble(request.getParameter("ImportoPagato")));
			
			esito = crud.inserisci(prenotazioneRitorno);
			response.sendRedirect("avvisoInserimento.html");
			break;
		}
		
		if (esito == false) {
			System.out.println("operazione non riuscita");
		}
		else {
			System.out.println("operazione andata a buon fine");
		}
	}

}
