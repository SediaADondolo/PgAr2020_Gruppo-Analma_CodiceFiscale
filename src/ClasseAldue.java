import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

<<<<<<< HEAD

    public class ClasseAldue{
=======
public class Utility {

    String[] nomi = new String[]{"maestro"};
    String[] cognomi = new String[]{"IL"};
    String[] sesso = new String[]{"Mai abbastanza"};
    String[] data_nascita = new String[]{"1478-56-89"};
    String[] comune_nascita = new String[]{"sto cazzo"};

>>>>>>> fd29d327d977ac80184192332e11c065931bb617

    int q = 1000; //numero codici fiscali
    int a = 1000; //numero invalidi
    int f = 1000; //numero spaiati

    XMLInputFactory xmlif = null;
    XMLStreamReader xmlr = null;

    XMLOutputFactory xmlof;
    XMLStreamWriter xmlw = null;

    ArrayList<String> totale = new ArrayList<>();
    ArrayList<String> invalidi = new ArrayList<>();
    ArrayList<String> spaiati = new ArrayList<>();

    public Utility() {
    }

<<<<<<< HEAD
        private ArrayList<String> totale = new ArrayList<>();
        private      	ArrayList<String> invalidi = new ArrayList<>();
        private   		ArrayList<String> spaiati = new ArrayList<>();
        private   		ArrayList<String> utilizzati = new ArrayList<>();
        
        public ArrayList<String> getTotale() {
			return totale;
		}

		public void setTotale(ArrayList<String> totale) {
			this.totale = totale;
		}

        public ArrayList<String> getInvalidi() {
			return invalidi;
		}

		public void setInvalidi(ArrayList<String> invalidi) {
			this.invalidi = invalidi;
		}

		public ArrayList<String> getSpaiati() {
			return spaiati;
		}

		public void setSpaiati(ArrayList<String> spaiati) {
			this.spaiati = spaiati;
		}

		public ClasseAldue() {
=======
    //Inizializza Lettore
    public void initReader(String nome_file){

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(new FileInputStream(nome_file));
>>>>>>> fd29d327d977ac80184192332e11c065931bb617
        }
        catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
        }
    }

    //Inizializza Scrittura
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

<<<<<<< HEAD
        //Crea Arraylist con tutti i codici fiscali del file codiciFiscali.xml
        public void createTotal(){
        	
            try{
                while(xmlr.hasNext()){
=======
    //Crea Arraylist con tutti i codici fiscali del file codiciFiscali.xml
    public void createTotal(){

        try{
            while(xmlr.hasNext()){
>>>>>>> fd29d327d977ac80184192332e11c065931bb617

                if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) { // content allâ€™interno di un elemento: stampa il testo
                    if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                        totale.add(xmlr.getText());
                }
                xmlr.next();
            }
        } catch (Exception e){
            System.out.println("Errore nella lettura:");
        }
    }

<<<<<<< HEAD
        //Controlla se esiste un accoppiamento tra i codici generati e quelli presenti in codiciFiscali.xml
        public String sexTogheter(String utili){

				            for (int j = 0; j < totale.size(); j++) {
				
				                if(totale.get(j).equals(utili))
				                	utilizzati.add(totale.get(j));
				                    return utili;
				                					                	
				                }
               //dobbiamo aggiungere a spaiati se nella lista totale non c'è corrispondenza con quelli generati da noi				            
            return "ASSENTE";
               
        }
        public ArrayList spaiati()
        {
        	for (int i = 0; i<totale.size(); i++)
        	{
        		
        	}
        	return spaiati;
        }
        //Controlla se i codici in codiciFiscali.xml sono validi
        public void controlValid(){

            for (int i = 0; i< totale.size(); i++) {

                if(totale.get(i).substring(0, 6).matches("[A-Z]{6}")== false){
                    invalidi.add(totale.get(i));
                    totale.remove(totale.get(i));}

                else   if(totale.get(i).substring(6,8).matches("[0-9]{2}")== false){
                    invalidi.add(totale.get(i));
                    totale.remove(totale.get(i));}

                else  if(totale.get(i).substring(8,9).matches("[A-EHLMPRST]")== false){
                    invalidi.add(totale.get(i));
                    totale.remove(totale.get(i));}

                //giorno
                else  if(totale.get(i).substring(9,11).matches("(0[0-9]|[1-2][0-9]|3[01])|(4[1-9]|[56][0-9]|7[01])")== false){
                    invalidi.add(totale.get(i));
                    totale.remove(totale.get(i));}
                
                
                //luogo
                else    if(totale.get(i).substring(11,15).matches("[A-MZ][1-9]\\d{2}|[A-M]0(?:[1-9]\\d|0[1-9])")== false){
                    invalidi.add(totale.get(i));
                    totale.remove(totale.get(i));}


                else    if(totale.get(i).substring(15,16).matches("[A-Z]")== false){
                        invalidi.add(totale.get(i));
                        totale.remove(totale.get(i));}
            }
=======
    //Controlla se i codici in codiciFiscali.xml sono validi
    public void controlValid(){

        for (String c: totale) {

            if(!c.substring(0, 6).matches("[A-Z]{6}")){
                invalidi.add(c);
                totale.remove(c);}

            if(!c.substring(6,8).matches("[0-9]{2}")){
                invalidi.add(c);
                totale.remove(c);}

            if(!c.substring(8).matches("[A-EHLMPRST]")){
                invalidi.add(c);
                totale.remove(c);}

            //giorno
            if(!c.substring(9,11).matches("(0[1-9]3[01])|(4[1-9]7[01])")){
                invalidi.add(c);
                totale.remove(c);}

            //luogo
>>>>>>> fd29d327d977ac80184192332e11c065931bb617

            if(c.substring(11,15).matches("[A-MZ][1-9]\\d{2}|[A-M]0(?:[1-9]\\d|0[1-9])")){
                invalidi.add(c);
                totale.remove(c);}

            if(!c.substring(16).matches("[A-Z]")){
                invalidi.add(c);
                totale.remove(c);}
        }
    }

    //Controlla se esiste un accoppiamento tra i codici generati e quelli presenti in codiciFiscali.xml
    public String sexTogheter(String utili){

        for (int j = 0; j < 1000; j++) {

            if(totale.get(j).equals(utili))
                return utili;
        }

        spaiati.add(utili);
        return "ASSENTE";
    }

    //Scrive il file Output.xml
    public void createOutput(){
        try{
            assert xmlw != null;

            xmlw.writeCharacters("\n");
            xmlw.writeStartElement("Output");
            xmlw.writeCharacters("\n");
            //Inserire nel ciclo for i limite desiderato

            xmlw.writeStartElement("persone");
            xmlw.writeAttribute("numero", Integer.toString(q));
            for (int i = 0; i < 1; i++) {

                xmlw.writeCharacters("\n\t");
                xmlw.writeStartElement("persona");
                xmlw.writeAttribute("id", Integer.toString(i));

                xmlw.writeCharacters("\n\t\t");
                xmlw.writeStartElement("Nome");
                xmlw.writeCharacters(nomi[i]);
                xmlw.writeEndElement();

                xmlw.writeCharacters("\n\t\t");
                xmlw.writeStartElement("Cognome");
                xmlw.writeCharacters(cognomi[i]);
                xmlw.writeEndElement();

                xmlw.writeCharacters("\n\t\t");
                xmlw.writeStartElement("Sesso");
                xmlw.writeCharacters(sesso[i]);
                xmlw.writeEndElement();

                xmlw.writeCharacters("\n\t\t");
                xmlw.writeStartElement("comune_nascita");
                xmlw.writeCharacters(comune_nascita[i]);
                xmlw.writeEndElement();

                xmlw.writeCharacters("\n\t\t");
                xmlw.writeStartElement("data_nascita");
                xmlw.writeCharacters(data_nascita[i]);
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
            xmlw.writeAttribute("numero", Integer.toString(a)); //Attributo invalidi

            for (int i = 0; i < 1; i++) {
                xmlw.writeCharacters("\n\t\t");
                xmlw.writeStartElement("codice");
                xmlw.writeCharacters(spaiati.get(i));
                xmlw.writeEndElement();
            }
            xmlw.writeCharacters("\n\t");
            xmlw.writeEndElement(); //Chiudo invalidi

            xmlw.writeCharacters("\n\t");
            xmlw.writeStartElement("spaiati"); //Apro invalidi
            xmlw.writeAttribute("numero", Integer.toString(f)); //Attirbuto invalidi

            for (int i = 0; i < 1; i++) {
                xmlw.writeCharacters("\n\t\t");
                xmlw.writeStartElement("codice");
                xmlw.writeCharacters(invalidi.get(i));
                xmlw.writeEndElement();
            }
            xmlw.writeCharacters("\n\t");
            xmlw.writeEndElement(); //Chiudo invalidi
            xmlw.writeCharacters("\n\t");
            xmlw.writeEndElement(); //Chiudo codici

            xmlw.writeCharacters("\n");
            xmlw.writeEndElement(); //Chiudo output
            xmlw.writeEndDocument();

        }catch(Exception e){
            System.out.println("Errore di scrittura");


        }
    }
}



<<<<<<< HEAD

=======
>>>>>>> fd29d327d977ac80184192332e11c065931bb617
