package model;

import java.sql.Date;
import java.util.Objects;

public class PrenotazioneAereo {

	private int id;
	private String nomeCliente;
	private String cfCliente;
	private String cognomeCliente;
	private String compagniaAerea;
	private int nAdulti;
	private int nBambini;
	private Date dataPartenza;
	private Date dataArrivo;
	private String partenza;
	private String destinazione;
	private Double importoPagato;
	private boolean bagaglio;


	public PrenotazioneAereo(){

	}

	public PrenotazioneAereo(String nomeCliente, String cognomeCliente, String cfCliente,
			String compagniaAerea, int nAdulti, int nBambini, Date dataPartenza, Date dataArrivo, String partenza,
			String destinazione, Double importoPagato, boolean bagaglio){
		this.nomeCliente = nomeCliente;
		this.cognomeCliente = cognomeCliente;
		this.cfCliente = cfCliente;
		this.compagniaAerea = compagniaAerea;
		this.nAdulti = nAdulti;
		this.nBambini = nBambini;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.importoPagato = importoPagato;
		this.bagaglio = bagaglio;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCfCliente() {
		return cfCliente;
	}

	public void setCfCliente(String cfCliente) {
		this.cfCliente = cfCliente;
	}

	public String getCognomeCliente() {
		return cognomeCliente;
	}

	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}

	public String getCompagniaAerea() {
		return compagniaAerea;
	}

	public void setCompagniaAerea(String compagniaAerea) {
		this.compagniaAerea = compagniaAerea;
	}

	public int getnAdulti() {
		return nAdulti;
	}

	public void setnAdulti(int nAdulti) {
		this.nAdulti = nAdulti;
	}

	public int getnBambini() {
		return nBambini;
	}

	public void setnBambini(int nBambini) {
		this.nBambini = nBambini;
	}

	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public String getPartenza() {
		return partenza;
	}

	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public Double getImportoPagato() {
		return importoPagato;
	}

	public void setImportoPagato(Double importoPagato) {
		this.importoPagato = importoPagato;
	}

	public boolean getBagaglio() {
		return bagaglio;
	}

	public void setBagaglio(boolean bagaglio) {
		this.bagaglio = bagaglio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bagaglio, cfCliente, cognomeCliente, compagniaAerea, dataArrivo, dataPartenza, destinazione,
				id, importoPagato, nAdulti, nBambini, nomeCliente, partenza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrenotazioneAereo other = (PrenotazioneAereo) obj;
		return bagaglio == other.bagaglio && Objects.equals(cfCliente, other.cfCliente)
				&& Objects.equals(cognomeCliente, other.cognomeCliente)
				&& Objects.equals(compagniaAerea, other.compagniaAerea) && Objects.equals(dataArrivo, other.dataArrivo)
				&& Objects.equals(dataPartenza, other.dataPartenza) && Objects.equals(destinazione, other.destinazione)
				&& id == other.id && Objects.equals(importoPagato, other.importoPagato) && nAdulti == other.nAdulti
				&& nBambini == other.nBambini && Objects.equals(nomeCliente, other.nomeCliente)
				&& Objects.equals(partenza, other.partenza);
	}

	@Override
	public String toString() {
		return "PrenotazioneAereo [id=" + id + ", nomeCliente=" + nomeCliente + ", cfCliente=" + cfCliente
				+ ", cognomeCliente=" + cognomeCliente + ", compagniaAerea=" + compagniaAerea + ", nAdulti=" + nAdulti
				+ ", nBambini=" + nBambini + ", dataPartenza=" + dataPartenza + ", dataArrivo=" + dataArrivo
				+ ", partenza=" + partenza + ", destinazione=" + destinazione + ", importoPagato=" + importoPagato
				+ ", bagaglio=" + bagaglio + "]";
	}


}
