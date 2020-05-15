

// Creazione della classe persona che utilizziamo per salvare tutti i dati contenuti nel file "inputPersone.xml"
public class Persona {
	// costruttore della classe persona
	public Persona(String nome, String cognome, String sesso, String comuneNascita, String dataNascita,
			String codiceFiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.comuneNascita = comuneNascita;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
	}
	
	
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", comuneNascita="
				+ comuneNascita + ", dataNascita=" + dataNascita + ", codiceFiscale=" + codiceFiscale + "]";
	}


	public Persona() {
		super();
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
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getComuneNascita() {
		return comuneNascita;
	}
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	String nome;
	String cognome;
	String sesso;
	String comuneNascita;
	String dataNascita;
	String codiceFiscale;
	
}