import java.io.FileInputStream;
import java.util.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;



public class CodiceFiscale {

	
		// Questo metodo ritorna le tre lettere del cognome 
	
		public String surname(String cognome) {  
			List<Character> surn=new ArrayList<Character>(); 
		for(int i=0;i<cognome.length();i++) {
			if ((cognome.charAt(i)!= 'A')&&
					(cognome.charAt(i)!= 'E')&&
						(cognome.charAt(i)!= 'I')&&
							(cognome.charAt(i)!= 'O')&&
								(cognome.charAt(i)!= 'U'))
													 surn.add(cognome.charAt(i)); //aggiunta di tutte le consonanti alla List
											}
		if(surn.size()<3) {														//se ho meno di 3 consonanti aggiungo in coda le vocali
			for(int i=0;i<cognome.length();i++) {
				if ((cognome.charAt(i)== 'A')||
						(cognome.charAt(i)== 'E')||
							(cognome.charAt(i)== 'I')||
								(cognome.charAt(i)== 'O')||
									(cognome.charAt(i)== 'U'))
										surn.add(cognome.charAt(i));
												}
						    }
		if(cognome.length()<3) {												//se il cognome ha meno di 3 lettere aggiungo una X in coda
			for(int i=0;i<cognome.length();i++) {
				surn.add(cognome.charAt(i));
												}
				surn.add(2,'X');
								}
		
		if(surn.size()>3) {														//tengo solo i primi tre caratteri della List
			surn=surn.subList(0, 3);
						  }
		
		StringBuilder sb=new StringBuilder();									//conversione da List a String eliminando parentesi e virgole e compattando
		for(Character s:surn) {
			sb.append(s);
							   }
			String s = new StringBuilder().append(sb).toString();				
			return s;
											   }

		// Questo metodo ritorna le tre lettere del nome
		public String name(String nome) {  
			List<Character> name=new ArrayList<Character>(); 
		for(int i=0;i<nome.length();i++) {
			if ((nome.charAt(i)!= 'A')&&
					(nome.charAt(i)!= 'E')&&
						(nome.charAt(i)!= 'I')&&
							(nome.charAt(i)!= 'O')&&
								(nome.charAt(i)!= 'U'))
									name.add(nome.charAt(i));  //aggiunta di tutte le consonanti alla List
										  }
		if(name.size()>3) {
			name.remove(1);   									//se ho piu di tre consonanti non prendo la seconda
						   }
		
		if(name.size()<3) {  									//se ho meno di 3 consonanti prendo le vocali
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
				name.add(nome.charAt(i));   					//con meno di 3 lettere nel nome aggiungo X in coda
											  }
				name.add(2,'X');
							}
		if(name.size()>3) {
			name=name.subList(0, 3);							//prendo solo le prime tre lettere della List
						  }
		StringBuilder sb=new StringBuilder();					//formatto la List
			for(Character s:name) {
				sb.append(s);
							       }
			String s = new StringBuilder().append(sb).toString();
			return s;
											   }
			
		// Questo metodo ritorna le due cifre dell'anno di nascita 
		public String annoNascita (String dataNascita) { //"1998-01-08"
			String anno=dataNascita.substring(2, 4); 
			return anno;
		}
			
		// Questo metodo ritorna la lettera corrispondente al mese di nascita 
		public String meseNascita(String dataNascita) {
			String mese=dataNascita.substring(5, 7);	//dalla stringa della data prendo solo il mese e associo al numero del mese la lettera corrispondente
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
		
		// Questo metodo ritorna le due cifre del giorno di nascita 
		public String giornoNascita(String dataNascita,String sex) {
	
		String giorno=dataNascita.substring(8, 10);
		int giornoNum = Integer.parseInt(giorno);  // converto la String del giorno in numero per poter sommare in caso il sesso sia f
		
		if(sex.equalsIgnoreCase("F")){
			giornoNum=giornoNum+40;
									  }
		String def=String.valueOf(giornoNum);  //riconverto in formato String
			if(giornoNum<10)
			{
				return "0" + def;   
			}
		
		return def;
															}
		
		//Questo metodo calcola il valore che verrà associato alla lettera finale di controllo del codice fiscale
 		public int valoreCodiceControllo (String s) 
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
		
 		//Questo metodo calcola il valore di ogni cifra in posizione dispari del codice fiscale, secondo una tabella predefinita
		public int valoreCifreDispari (char carattereTest) 
	{
		
		String str1 = "BAKPLCQDREVOSFTGUHMINJWZYX"; 		//Faccio in modo che il valore che assume un determinato carattere, sia corrispondente alla sua posizione all'interno di questa stringa
		String str2 = "10   2 3 4   5 6 7 8 9";
		for(int i = 0; i<str1.length(); i++)
		{
			if(str1.charAt(i) == carattereTest)
				return i;
		}
		for(int i = 0; i<str2.length(); i++)    			//Se entra in questo for vuol dire che il carattere non era una lettera ma una cifra
		{
			if(str2.charAt(i) == carattereTest)
				return i;
		}
		
		return 0;
	}
			
		//Questo metodo calcola il valore di ogni cifra in posizione pari del codice fiscale, secondo una tabella predefinita
		public int valoreCifrePari (char carattereTest) {
		
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
		
		//Questo metodo restituisce il carattere che si riferisce al valore in input
		public char codiceControllo (int valore)  
		{
			int resto = valore % 26;
			String str5 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			for(int i = 0; i<str5.length();)
			{
				return str5.charAt(resto);
			}
			return ' ';
		}
	
		//Questo metodo restituisce il carattere alfanumerico corrispondente al comune di nascita
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
		
		//Questo metodo riunisce tutti i metodi precedenti per calcolare il codice fiscale completo
		public String creaCodiceFiscale (Persona ex)
		{	
			String cognome = surname(ex.getCognome());
			String nome = name(ex.getNome());
			String anno = annoNascita(ex.getDataNascita());
			String mese = meseNascita(ex.getDataNascita());
			String giorno = giornoNascita(ex.getDataNascita(), ex.getSesso());
			String comune = CodiceComune(ex.getComuneNascita());
			String totale = cognome + nome + anno + mese + giorno + comune;
			int k = valoreCodiceControllo(totale);
			char m = codiceControllo(k);
			String codiceFiscale = totale + m;
			return codiceFiscale;
		}

		
		
}
