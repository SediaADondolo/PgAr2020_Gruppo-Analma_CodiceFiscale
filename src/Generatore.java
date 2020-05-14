import javax.xml.stream.XMLInputFactory;
 
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class Generatore {
	
	
	

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
            	case XMLStreamConstants.CHARACTERS: //Mi interessa quando nell'xml è presente un "character"
            			if (comuni.getText().equals(comune_nascita))  //Verifico quando il testo corrisponde al comune di nascita che gli passo come input
            			{           				            			
	            			for(int i = 0; i<4; i++) //faccio un ciclo  for per arrivare al prossimo "character" per prendere il codice corrispondente al comune di nascita trovato sopra
	            			{							// ciclo 4 volte perché ci sono 4 eventi tra il "character" del nome del comune e il suo relativo codice
	            				comuni.next();			// devo tenere a mente che nell'xml c'è il "character" che permette di andare a capo
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

}



