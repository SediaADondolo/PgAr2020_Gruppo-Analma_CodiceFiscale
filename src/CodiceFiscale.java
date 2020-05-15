
import java.util.*;


public class CodiceFiscale {

	
		// metodo per calcolare le tre lettere corrispondenti al cognome
		public String surname(String cognome2) {  
			List<Character> surn=new ArrayList<Character>(); 
		for(int i=0;i<cognome2.length();i++) {
			if ((cognome2.charAt(i)!= 'A')&&
					(cognome2.charAt(i)!= 'E')&&
						(cognome2.charAt(i)!= 'I')&&
							(cognome2.charAt(i)!= 'O')&&
								(cognome2.charAt(i)!= 'U'))
													 surn.add(cognome2.charAt(i));
											}
		if(surn.size()<3) {
			for(int i=0;i<cognome2.length();i++) {
				if ((cognome2.charAt(i)== 'A')||
						(cognome2.charAt(i)== 'E')||
							(cognome2.charAt(i)== 'I')||
								(cognome2.charAt(i)== 'O')||
									(cognome2.charAt(i)== 'U'))
										surn.add(cognome2.charAt(i));
												}
						    }
		if(cognome2.length()<3) {
			for(int i=0;i<cognome2.length();i++) {
				surn.add(cognome2.charAt(i));
												}
				surn.add(2,'X');
								}
		
		if(surn.size()>3) {
			surn=surn.subList(0, 3);
						  }
		
		StringBuilder sb=new StringBuilder();
		for(Character s:surn) {
			sb.append(s);
							   }
			String s = new StringBuilder().append(sb).toString();
			return s;
											   }

		// metodo per calcolare le tre lettere corrispondenti al nome
		public String name(String nome) {  
			List<Character> name=new ArrayList<Character>(); 
		for(int i=0;i<nome.length();i++) {
			if ((nome.charAt(i)!= 'A')&&
					(nome.charAt(i)!= 'E')&&
						(nome.charAt(i)!= 'I')&&
							(nome.charAt(i)!= 'O')&&
								(nome.charAt(i)!= 'U'))
									name.add(nome.charAt(i));
										  }
		if(name.size()>3) {
			name.remove(1);
						   }
		
		if(name.size()<3) {
			for(int i=0;i<nome.length();i++) {
				if ((nome.charAt(i)== 'A')||
						(nome.charAt(i)== 'E')||
							(nome.charAt(i)== 'I')||
								(nome.charAt(i)== 'O')||
									(nome.charAt(i)== 'U'))
										name.add(nome.charAt(i));
											   }
						    }
		if(nome.length()<3) {
			for(int i=0;i<nome.length();i++) {
				name.add(nome.charAt(i));
											  }
				name.add(2,'X');
							}
		if(name.size()>3) {
			name=name.subList(0, 3);
						  }
		StringBuilder sb=new StringBuilder();
			for(Character s:name) {
				sb.append(s);
							       }
			String s = new StringBuilder().append(sb).toString();
			return s;
											   }
			
		// metodo che ritorna l'anno di nascita 
		public String annoNascita (String dataNascita) { //"1998-01-08"
			String anno=dataNascita.substring(2, 4);
			return anno;
		}
			
		// metodo che ritorna il mese di nascita 
		public String meseNascita(String dataNascita) {
			String mese=dataNascita.substring(5, 7);
			String lettera= "";
			
			switch(mese) {
			
				case "01":	
					lettera="A";
					break;
				case "02":
					lettera="B";
					break;
				case "03": 
					lettera="C";
					break;
				case "04":	
					lettera="D";
					break;
				case "05":
					lettera="E";
					break;
				case "06": 
					lettera="H";
					break;
				case "07":	
					lettera="L";
					break;
				case "08":
					lettera="M";
					break;
				case "09": 
					lettera="P";
					break;
				case "10":	
					lettera="R";
					break;
				case "11":
					lettera="S";
					break;
				case "12": 
					lettera="T";
					break;
							}
			return lettera; 
			}
		
		// metodo che ritorna il giorno di nascita 
		public String giornoNascita(String dataNascita,String sex) {
	
		String giorno=dataNascita.substring(8, 10);
		int giornoNum = Integer.parseInt(giorno);
		
		if(sex.equalsIgnoreCase("F")){
			giornoNum=giornoNum+40;
									  }
		String def=String.valueOf(giornoNum);
			if(giornoNum<10)
			{
				return "0" + def;
			}
		
		return def;
															}
	
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
		
		public String creaCodiceFiscale (Persona ex)
		{	
			InputOutput lett = new InputOutput();
			String cognome = surname(ex.getCognome());
			String nome = name(ex.getNome());
			String anno = annoNascita(ex.getDataNascita());
			String mese = meseNascita(ex.getDataNascita());
			String giorno = giornoNascita(ex.getDataNascita(), ex.getSesso());
			String comune = lett.CodiceComune(ex.getComuneNascita());
			String totale = cognome + nome + anno + mese + giorno + comune;
			int k = valoreCodiceControllo(totale);
			char m = codiceControllo(k);
			String codiceFiscale = totale + m;
			return codiceFiscale;
		}

		// Ritorna "assente" se non c'è l'accoppiamento (sexTogheter) altrimenti ritorna il codice stesso
		public String sexTogheter(String utili, ArrayList<String> tot){        	
			
            for (int j = 0; j < tot.size(); j++) {

                if(tot.get(j).equals(utili)) {
                	tot.remove(tot.get(j));
                    return utili;
                }	                	
                }	            
return "ASSENTE";

}
		
		// Controlla la validità dei codici all'interno del file "CodiciFiscali.xml"
		public void controlValid(ArrayList<String> tot, ArrayList<String> inv){

				for (int i = 0; i< tot.size(); i++) {
				
				CodiceFiscale controllo = new CodiceFiscale();
				int valoreCode = controllo.valoreCodiceControllo(tot.get(i));
				char control = controllo.codiceControllo(valoreCode);
				String codeControl = "" + control;
				
				//controllo nome e cognome
				if(tot.get(i).substring(0, 6).matches("[A-Z]{6}")== false){
				 inv.add(tot.get(i));
				 tot.remove(tot.get(i));}

				// controllo anno
				else   if(tot.get(i).substring(6,8).matches("[0-9]{2}")== false){
				 inv.add(tot.get(i));
				 tot.remove(tot.get(i));}
				
				//controllo mese
				else  if(tot.get(i).substring(8,9).matches("[A-EHLMPRST]")== false){
				 inv.add(tot.get(i));
				 tot.remove(tot.get(i));}
				
				// controllo giorno + sesso
				else  if(tot.get(i).substring(9,11).matches("(0[0-9]|[1-2][0-9]|3[01])|(4[1-9]|[56][0-9]|7[01])")== false){
				 inv.add(tot.get(i));
				 tot.remove(tot.get(i));}
				
				
				//controllo luogo
				else    if(tot.get(i).substring(11,15).matches("[A-MZ][1-9]\\d{2}|[A-M]0(?:[1-9]\\d|0[1-9])")== false){
				 inv.add(tot.get(i));
				 tot.remove(tot.get(i));}
				
				// controlli codice di controllo
				else    if(tot.get(i).substring(15,16).matches("[A-Z]")== false){
				 inv.add(tot.get(i));
				 tot.remove(tot.get(i));}
				      
				else 	if(tot.get(i).substring(15,16) == codeControl)  //Utilizzo il metodo già creato in CodiceFiscale per verificare il controllo dell'ultimo carattere
						{
				 inv.add(tot.get(i));
				 tot.remove(tot.get(i));}
						}
				
				}

		
}
