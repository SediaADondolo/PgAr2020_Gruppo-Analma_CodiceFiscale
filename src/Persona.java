
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
	
		public int valoreCodiceControllo (String s) //Con questo metodo calcolo il valore che verrà associato alla lettera finale di controllo del codice fiscale
	{
		int valore = 0;
		
		for (int i=0; i<s.length(); i = i+2)
		{
			valore = valore + valoreCifreDispari(s.charAt(i));
		}
		for (int i=1; i<s.length(); i = i+2)
		{
			valore = valore + valoreCifrePari(s.charAt(i));
		}	
		return valore;
	}
		
		public int valoreCifreDispari (char carattereTest) //Questo metodo serve per calcolare il valore di ogni cifra in posizione dispari del codice fiscale, secondo una tabella predefinita
	{
		
		String str1 = "BAKPLCQDREVOSFTGUHMINJWZYX"; 		//  Faccio in modo che il valore che assume un determinato carattere, sia corrispondente alla sua posizione all'interno di questa stringa
		String str2 = "10   2 3 4   5 6 7 8 9";
		for(int i = 0; i<str1.length(); i++)
		{
			if(str1.charAt(i) == carattereTest)
				return i;
		}
		for(int i = 0; i<str2.length(); i++)    // Se entra in questo for vuol dire che il carattere non era una lettera ma una cifra
		{
			if(str2.charAt(i) == carattereTest)
				return i;
		}
		
		return 0;
	}
				
		public int valoreCifrePari (char carattereTest) // Stesso discorso per il metodo valoreCifreDispari().
	{
		
		String str3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String str4 = "0123456789";
		for(int i = 0; i<str3.length(); i++)
		{
			if(str3.charAt(i) == carattereTest)
				return i;
		}
		for(int i = 0; i<str4.length(); i++)
		{
			if(str4.charAt(i) == carattereTest)
				return i;
		}
		
		return 0;
	}
	
		public char codiceControllo (int valore)  // Questo metodo restituisce il carattere che si riferisce al valore in input
		{
			int resto = valore % 26;
			String str5 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			for(int i = 0; i<str5.length();)
			{
				return str5.charAt(resto);
			}
			return ' ';
		}
	
}




