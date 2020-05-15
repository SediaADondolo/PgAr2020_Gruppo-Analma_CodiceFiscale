import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	
    	InputOutput scanner = new InputOutput();        
    	Persona[] persone = new Persona [1000];
    	CodiceFiscale code = new CodiceFiscale();
    	ArrayList<String> totale = new ArrayList<>();  
   	 	ArrayList<String> invalidi = new ArrayList<>();
    	
    	for (int m=0; m<persone.length; m++) { //Inizializzo l'array di persona
		  	   persone[m] = new Persona();
		  	}
    	
    	 scanner.initReader("inputPersone.xml"); //leggo e salvo i dati da file
    	 scanner.leggiDati(persone);
    	
         for (int k=0; k<persone.length; k++ )               
            persone[k].setCodiceFiscale(code.creaCodiceFiscale(persone[k])); //genero e salvo i codici fiscali
                          
        scanner.initReader("codiciFiscali.xml"); //leggo e controllo la validità dei codici all'interno del file "codiciFiscali.xml"
        scanner.createTotal(totale);
        code.controlValid(totale, invalidi);
      
        for (int k=0; k<persone.length; k++) // verifica l'accopiamento dei codici generati con il file "codiciFiscali.xml"
         	{        	
        	if(code.sexTogheter(persone[k].getCodiceFiscale(), totale).equals("ASSENTE")) 
        		persone[k].setCodiceFiscale("ASSENTE");     
        	}
    
        scanner.initWriter("codiciPersone.xml");  //Crea output
        scanner.createOutput(persone, invalidi, totale);
       
}
}

