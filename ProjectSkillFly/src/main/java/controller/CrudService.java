package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connettore.GestoreConnessione;
import model.PrenotazioneAereo;

public class CrudService implements ICrudService{

	@Override
	public boolean inserisci(PrenotazioneAereo prenotazione) {
		Connection conn = GestoreConnessione.getInstance().apriConnessione();
		if (conn != null) {
			System.out.println("Database raggiunto");
		}
		else if (conn == null) {
			System.out.println("database non raggiunto");
		}
		String sql = "insert into prenotazioni (nomeCliente, cognomeCliente, cfCliente, compagniaAerea, nAdulti, nBambini, dataPartenza, dataArrivo, partenza, destinazione, importoPagato, bagaglio) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, prenotazione.getNomeCliente());
			ps.setString(2, prenotazione.getCognomeCliente());
			ps.setString(3, prenotazione.getCfCliente());
			ps.setString(4, prenotazione.getCompagniaAerea());
			ps.setInt(5, prenotazione.getnAdulti());
			ps.setInt(6, prenotazione.getnBambini());
			ps.setDate(7, prenotazione.getDataPartenza());
			ps.setDate(8, prenotazione.getDataArrivo());
			ps.setString(9, prenotazione.getPartenza());
			ps.setString(10, prenotazione.getDestinazione());
			ps.setDouble(11, prenotazione.getImportoPagato());
			ps.setBoolean(12, prenotazione.getBagaglio());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<PrenotazioneAereo> leggi() {
		Connection conn = GestoreConnessione.getInstance().apriConnessione();
		if (conn != null) {
			System.out.println("Database raggiunto");
		}
		else if (conn == null) {
			System.out.println("database non raggiunto");
		}
		List<PrenotazioneAereo> prenotazioni = new ArrayList<PrenotazioneAereo>();
		PrenotazioneAereo prenotazione = null;
		String sql = "select * from prenotazioni";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				prenotazione = new PrenotazioneAereo();
				prenotazione.setId(rs.getInt("id"));
				prenotazione.setNomeCliente(rs.getString("nomeCliente"));
				prenotazione.setCognomeCliente(rs.getString("cognomeCliente"));
				prenotazione.setCfCliente(rs.getString("cfCliente"));
				prenotazione.setCompagniaAerea(rs.getString("compagniaAerea"));
				prenotazione.setnAdulti(rs.getInt("nAdulti"));
				prenotazione.setnBambini(rs.getInt("nBambini"));
				prenotazione.setDataPartenza(rs.getDate("dataPartenza"));
				prenotazione.setDataArrivo(rs.getDate("dataArrivo"));
				prenotazione.setPartenza(rs.getString("partenza"));
				prenotazione.setDestinazione(rs.getString("destinazione"));
				prenotazione.setImportoPagato(rs.getDouble("importoPagato"));
				prenotazione.setBagaglio(rs.getBoolean("bagaglio"));
				prenotazioni.add(prenotazione);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				ps.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return prenotazioni;

	}

	@Override
	public boolean rimuovi(int id) {
		Connection conn = GestoreConnessione.getInstance().apriConnessione();
		if (conn != null) {
			System.out.println("Database raggiunto");
		}
		else if (conn == null) {
			System.out.println("database non raggiunto");
		}
		String sql = "delete from prenotazioni where id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		}catch(SQLException e) {
			return false;
		}
	}

}
