import javax.xml.stream.XMLInputFactory;
 
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) {
    	
    	Lettore scanner = new Lettore();
    	XMLInputFactory xmlif = scanner.getXmlif();
        XMLStreamReader lettore= scanner.getXmlr();
        Persona[] persone = new Persona [1000]; 
    
        int i = -1;
        scanner.initReader("inputPersone.xml");
        
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
                        		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" è 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo copio in un array di nomi.
                        			persone[i].setNome(lettore.getText());
                        	}
                         else if (lettore.getLocalName().equals("cognome"))
                    	{
                    		lettore.next();
                    		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" è 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo copio in un array di nomi.
                    			persone[i].setCognome(lettore.getText());
                    		}
                        		
                        else if (lettore.getLocalName().equals("sesso"))
                    	{
                    		lettore.next();
                    		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" è 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo copio in un array di nomi.
                    			persone[i].setSesso(lettore.getText());                 		
                    	}
                        		
                        else if (lettore.getLocalName().equals("comune_nascita"))
                    	{
                    		lettore.next();
                    		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" è 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo copio in un array di nomi.
                    			persone[i].setComuneNascita(lettore.getText());
                    		
                    		
                    	}
                        else if (lettore.getLocalName().equals("data_nascita"))
                    	{
                    		lettore.next();
                    		if(lettore.getEventType() == XMLStreamConstants.CHARACTERS) // Ho trovato che il valore della costante "CHARACTERS" è 4: qui verifico che dopo il tag d'apertura nome, ci sia un carattere, e lo assegno alla persona[i].
                    			persone[i].setDataNascita(lettore.getText());
                    		
                    	}
                        break;
                }
                lettore.next();
            }
          CodiceFiscale prova1 = new CodiceFiscale();
         // System.out.println(prova1.surname("MLT"));
         for (int k=0; k<persone.length; k++ )
           {
            String code = prova1.creaCodiceFiscale(persone[k]);
            persone[k].setCodiceFiscale(code);
           }
         
        
        }catch (Exception e){
            System.out.println("Errore nella lettura:");
        }
     
        ClasseAldue prova = new ClasseAldue();
        prova.initReader("codiciFiscali.xml");
        prova.createTotal();
        prova.controlValid();
        System.out.println(prova.getInvalidi());
        System.out.println(prova.getSpaiati());
        System.out.println(prova.getTotale());
        System.out.println(prova.getInvalidi().size());
        System.out.println(prova.getTotale().size());
        
        for (int k=0; k<persone.length; k++)
        {
        	
        	if(prova.sexTogheter(persone[k].getCodiceFiscale()).equals("ASSENTE")) 
        		persone[k].setCodiceFiscale("ASSENTE");
     
        	//System.out.println(persone[k].toString());
        	}
        System.out.println(prova.getSpaiati());
        System.out.println(prova.getSpaiati().size());
        System.out.println(prova.getTotale().size());
}
}

