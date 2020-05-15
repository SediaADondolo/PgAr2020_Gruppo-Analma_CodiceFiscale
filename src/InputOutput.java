import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class InputOutput {
	
	XMLInputFactory xmlif = null;
    XMLStreamReader xmlr = null;
    XMLOutputFactory xmlof;
    XMLStreamWriter xmlw = null;
    
		// Il metodo permette di inizializzare il lettore e richiede in input il nome del file che si vuole inizializzare
		public void initReader(String nome_file){

		try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(new FileInputStream(nome_file));
        }
        catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
        }
    }
		
		// Il metodo legge i dati da un file (nel nostro caso "inputPersone.xml") e salva in un array di Persona[] tutti i dati letti.
		public void leggiDati(Persona [] pers)
	{
		int i = -1; // inizializzo i a -1 così quando trova la prima persona, questa avra indice pari a 0, così come il suo id nel file xml
		
		try {
			while(xmlr.hasNext()){				
				switch (xmlr.getEventType()){
			               
					   case XMLStreamConstants.START_ELEMENT:
					           
					                if (xmlr.getLocalName().equals("persona")) // Se il lettore trova un tag di inizio che equivale a "persona" significa che il lettore sta per analizzare i dati di un'altra persona
					                {											// e quindi aumento l'indice di uno
					                	i++;
					                }
					                    
					               else if (xmlr.getLocalName().equals("nome")) // Se il prossimo tag di apertura è "nome" il prossimo carattere deve riferirsi all'attributo nome di Persona.
					                    {
					                    	xmlr.next();
					                    	if(xmlr.getEventType() == XMLStreamConstants.CHARACTERS)  // Qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo setto nell'array in input.
					                    		pers[i].setNome(xmlr.getText());
					                    } 
					                //Svolgo le stesse operazioni per gli altri dati del file "inputPersone.xml"
					                     else if (xmlr.getLocalName().equals("cognome"))
					                	{
					                		xmlr.next();
					                		if(xmlr.getEventType() == XMLStreamConstants.CHARACTERS) 
					                			pers[i].setCognome(xmlr.getText());
					                		}
					                    		
					                    else if (xmlr.getLocalName().equals("sesso"))
					                	{
					                		xmlr.next();
					                		if(xmlr.getEventType() == XMLStreamConstants.CHARACTERS) 
					                			pers[i].setSesso(xmlr.getText());                 		
					                	}
					                    		
					                    else if (xmlr.getLocalName().equals("comune_nascita"))
					                	{
					                		xmlr.next();
					                		if(xmlr.getEventType() == XMLStreamConstants.CHARACTERS) 
					                			pers[i].setComuneNascita(xmlr.getText());
					                		
					                		
					                	}
					                    else if (xmlr.getLocalName().equals("data_nascita"))
					                	{
					                		xmlr.next();
					                		if(xmlr.getEventType() == XMLStreamConstants.CHARACTERS) 
					                			pers[i].setDataNascita(xmlr.getText());
					                		
					                	}
					                    break;
					            }
					            xmlr.next();
							}
		} catch (Exception e){
            System.out.println("Errore nella lettura:");
        }

	}
		
		// Legge dal file (nel nostro caso "codiciFiscali.xml") e salva ciò che trova in un arraylist.
		public void createTotal(ArrayList<String> tot){

			try{
	            while(xmlr.hasNext()){
	
	                if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) { // content allâ€™interno di un elemento: stampa il testo
	                    if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
	                        tot.add(xmlr.getText());
	                }
	                xmlr.next();
	            }
	        } catch (Exception e){
	            System.out.println("Errore nella lettura:");
	        }
		}
		
		// Inizializzo il writer per scrivere l'output
		public void initWriter(String nome_file){

        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(nome_file),"utf-8");
            xmlw.writeStartDocument("utf-8", "1.0");
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del writer:");
            System.out.println(e.getMessage());
        }
    }

		//Crea output
		public void createOutput(Persona[] pers, ArrayList<String> inv, ArrayList<String> tot){
			   
		        try{
		            assert xmlw != null;

		            xmlw.writeCharacters("\n");
		            xmlw.writeStartElement("Output");
		            xmlw.writeCharacters("\n");
		            //Inserire nel ciclo for i limite desiderato

		            xmlw.writeStartElement("persone");
		            xmlw.writeAttribute("numero", Integer.toString(pers.length));
		            for (int i = 0; i < pers.length; i++) {

		                xmlw.writeCharacters("\n\t");
		                xmlw.writeStartElement("persona");
		                xmlw.writeAttribute("id", Integer.toString(i));

		                xmlw.writeCharacters("\n\t\t");
		                xmlw.writeStartElement("Nome");
		                xmlw.writeCharacters(pers[i].getNome());
		                xmlw.writeEndElement();

		                xmlw.writeCharacters("\n\t\t");
		                xmlw.writeStartElement("Cognome");
		                xmlw.writeCharacters(pers[i].getCognome());
		                xmlw.writeEndElement();

		                xmlw.writeCharacters("\n\t\t");
		                xmlw.writeStartElement("Sesso");
		                xmlw.writeCharacters(pers[i].getSesso());
		                xmlw.writeEndElement();

		                xmlw.writeCharacters("\n\t\t");
		                xmlw.writeStartElement("comune_nascita");
		                xmlw.writeCharacters(pers[i].getComuneNascita());
		                xmlw.writeEndElement();

		                xmlw.writeCharacters("\n\t\t");
		                xmlw.writeStartElement("data_nascita");
		                xmlw.writeCharacters(pers[i].getDataNascita());
		                xmlw.writeEndElement();
		                
		                xmlw.writeCharacters("\n\t\t");
		                xmlw.writeStartElement("codice_fiscale");
		                xmlw.writeCharacters("\t");
		                xmlw.writeCharacters(pers[i].getCodiceFiscale());
		                xmlw.writeCharacters("\t");
		                xmlw.writeEndElement();
		                xmlw.writeCharacters("\n\t");
		                xmlw.writeEndElement();

		                
		            }
		            xmlw.writeCharacters("\n");
		            xmlw.writeEndElement(); //Chiude persona

		            xmlw.writeCharacters("\n");
		            xmlw.writeStartElement("codici"); //Apro codici
		            xmlw.writeCharacters("\n\t");

		            xmlw.writeStartElement("invalidi"); //Apro invalidi
		            xmlw.writeAttribute("numero", Integer.toString(inv.size())); //Attributo invalidi

		            for (int i = 0; i < inv.size(); i++) {
		                xmlw.writeCharacters("\n\t\t");
		                xmlw.writeStartElement("codice");
		                xmlw.writeCharacters(inv.get(i));
		                xmlw.writeEndElement();
		            }
		            xmlw.writeCharacters("\n\t");
		            xmlw.writeEndElement(); //Chiudo invalidi

		            xmlw.writeCharacters("\n\t");
		            xmlw.writeStartElement("spaiati"); //Apro spaiati
		            xmlw.writeAttribute("numero", Integer.toString(tot.size())); //Attirbuto spaiati

		            for (int i = 0; i < tot.size(); i++) {
		                xmlw.writeCharacters("\n\t\t");
		                xmlw.writeStartElement("codice");
		                xmlw.writeCharacters(tot.get(i));
		                xmlw.writeEndElement();
		            }
		            xmlw.writeCharacters("\n\t");
		            xmlw.writeEndElement(); //Chiudo spaiati
		            xmlw.writeCharacters("\n\t");
		            xmlw.writeEndElement(); //Chiudo codici

		            xmlw.writeCharacters("\n");
		            xmlw.writeEndElement(); //Chiudo output
		            xmlw.writeEndDocument();
		            
		            xmlw.flush(); // svuota il buffer e procede alla scrittura
		            xmlw.close();

		        }catch(Exception e){
		            System.out.println("Errore di scrittura");


		        }
		    }

		//Legge i file da "comuni.xml" e li ritorna quando viene invocato
		public String CodiceComune (String comune_nascita)
		
		{
		{
			initReader("comuni.xml");
		}
		try{
            while(xmlr.hasNext()){
            	switch (xmlr.getEventType()) 
            	{
            	case XMLStreamConstants.CHARACTERS: //Mi interessa quando nell'xml è presente un "character"
            			if (xmlr.getText().equals(comune_nascita))  //Verifico quando il testo corrisponde al comune di nascita che gli passo come input
            			{           				            			
	            			for(int i = 0; i<4; i++) //faccio un ciclo  for per arrivare al prossimo "character" per prendere il codice corrispondente al comune di nascita trovato sopra
	            			{							// ciclo 4 volte perché ci sono 4 eventi tra il "character" del nome del comune e il suo relativo codice
	            				xmlr.next();			// devo tenere a mente che nell'xml c'è il "character" che permette di andare a capo
	            			}            		
		            			if(xmlr.getEventType() == XMLStreamConstants.CHARACTERS) //verifico che l'evento sia "character"
		            			{
		            				return  xmlr.getText();   // Ritorna il codice
		            			}        			
            			}                     		
            	break;                      	            	
            	}
            	xmlr.next();            	            	
            } 		
           }catch (Exception e){
                    System.out.println("Errore nella lettura:");                  
           }return "NOT_FOUND";
		}
		
}