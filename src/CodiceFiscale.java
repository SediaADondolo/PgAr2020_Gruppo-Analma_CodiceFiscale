import java.io.FileInputStream;
import java.util.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class CodiceFiscale {

	StringBuffer CodiceFiscale;
	
		// metodo per calcolare le tre lettere corrispondenti al cognome
		public StringBuilder surname(String cognome) {  
			List<Character> surn=new ArrayList<Character>(); 
		for(int i=0;i<cognome.length();i++) {
			if ((cognome.charAt(i)!= 'A')&&
					(cognome.charAt(i)!= 'E')&&
						(cognome.charAt(i)!= 'I')&&
							(cognome.charAt(i)!= 'O')&&
								(cognome.charAt(i)!= 'U'))
													 surn.add(cognome.charAt(i));
											}
		if(surn.size()<3) {
			for(int i=0;i<cognome.length();i++) {
				if ((cognome.charAt(i)== 'A')||
						(cognome.charAt(i)== 'E')||
							(cognome.charAt(i)== 'I')||
								(cognome.charAt(i)== 'O')||
									(cognome.charAt(i)== 'U'))
										surn.add(cognome.charAt(i));
												}
						    }
		if(cognome.length()<3) {
			for(int i=0;i<cognome.length();i++) {
				surn.add(cognome.charAt(i));
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
			
			return sb;
											   }

		// metodo per calcolare le tre lettere corrispondenti al nome
		public StringBuilder name(String nome) {  
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
		return sb;
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
	
		return def;
															}
	
 		public int valoreCodiceControllo (String s) //Con questo metodo calcolo il valore che verr� associato alla lettera finale di controllo del codice fiscale
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
	
		public String CodiceComune (String comune_nascita)
		 {
			 XMLInputFactory xmcomlif = null;
			 	XMLStreamReader comuni = null;
			{
			 
			    try {
			        xmcomlif = XMLInputFactory.newInstance();
			        comuni = xmcomlif.createXMLStreamReader(new FileInputStream("comuni.xml"));
			        }
			    catch (Exception e) {
			        System.out.println("Errore nell'inizializzazione del reader:");
			    	}
			}
			 
				try{
		            while(comuni.hasNext()){
		            	switch (comuni.getEventType()) 
		            	{
		            	case XMLStreamConstants.CHARACTERS: //Mi interessa quando nell'xml � presente un "character"
		            			if (comuni.getText().equals(comune_nascita))  //Verifico quando il testo corrisponde al comune di nascita che gli passo come input
		            			{           				            			
			            			for(int i = 0; i<4; i++) //faccio un ciclo  for per arrivare al prossimo "character" per prendere il codice corrispondente al comune di nascita trovato sopra
			            			{							// ciclo 4 volte perch� ci sono 4 eventi tra il "character" del nome del comune e il suo relativo codice
			            				comuni.next();			// devo tenere a mente che nell'xml c'� il "character" che permette di andare a capo
			            			}            		
				            			if(comuni.getEventType() == XMLStreamConstants.CHARACTERS) //verifico che l'evento sia "character"
				            			{
				            				return  comuni.getText();   // Ritorna il codice
				            			}        			
		            			}                     		
		            	break;                      	            	
		            	}
		            	comuni.next();            	            	
		            } 		
		           }catch (Exception e){
		                    System.out.println("Errore nella lettura:");                  
		           }return "NOT_FOUND";
				  
				}
		
		public StringBuilder creaCodiceSenzaControllo (Persona ex)
		{	
			StringBuilder cognome = surname(ex.getCognome());
			StringBuilder nome = name(ex.getNome());
			String anno = annoNascita(ex.getDataNascita());
			String mese = meseNascita(ex.getDataNascita());
			String giorno = giornoNascita(ex.getDataNascita(), ex.getSesso());
			String comune = CodiceComune(ex.getComuneNascita());
			String totale = anno + mese + giorno + comune;
			return cognome.append(nome.append(totale));
		}

}
