import javax.xml.stream.XMLInputFactory;
 
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) {

        XMLInputFactory xmlif = null;
        XMLStreamReader lettore = null;
      
        Persona[] persone = new Persona [1000]; 
        int i = -1;
        try {
            xmlif = XMLInputFactory.newInstance();
            lettore = xmlif.createXMLStreamReader(new FileInputStream("inputPersone.xml"));
         ;
            }
        catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:" + e.getMessage());
        }
        
        for (int m=0; m<persone.length; m++) {
        	   persone[m] = new Persona();
        	
        	}

        try{
            while(lettore.hasNext()){

                switch (lettore.getEventType()){

                   
                    case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
               
                        if (lettore.getLocalName().equals("persona"))
                    	{
                    		i++;
                    	}
                        
                        else if (lettore.getLocalName().equals("nome"))
                        	{
                        		lettore.next();
                        		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" � 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo copio in un array di nomi.
                        			persone[i].setNome(lettore.getText());
                        	}
                         else if (lettore.getLocalName().equals("cognome"))
                    	{
                    		lettore.next();
                    		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" � 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo copio in un array di nomi.
                    			persone[i].setCognome(lettore.getText());
                    		}
                        		
                        else if (lettore.getLocalName().equals("sesso"))
                    	{
                    		lettore.next();
                    		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" � 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo copio in un array di nomi.
                    			persone[i].setSesso(lettore.getText());                 		
                    	}
                        		
                        else if (lettore.getLocalName().equals("comune_nascita"))
                    	{
                    		lettore.next();
                    		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" � 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo copio in un array di nomi.
                    			persone[i].setComuneNascita(lettore.getText());
                    		
                    		
                    	}
                        else if (lettore.getLocalName().equals("data_nascita"))
                    	{
                    		lettore.next();
                    		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" � 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo assegno alla persona[i].
                    			persone[i].setDataNascita(lettore.getText());
                    		
                    	}
                        break;
                }
                lettore.next();
            }
            CodiceFiscale prova = new CodiceFiscale();
         for (int k=0; k<persone.length; k++ )
           {
             
             System.out.println(prova.creaCodiceSenzaControllo(persone[k]));
            System.out.println(persone[k].toString());
           }
         
        
        }catch (Exception e){
            System.out.println("Errore nella lettura:");
        }
     
       /*
        int m = text.valoreCodiceControllo("MRNLRT97L14D940");
        System.out.println(text.codiceControllo(m));*/
        
      
}
}