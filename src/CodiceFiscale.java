import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class CodiceFiscale {

    public static void main(String[] args) {

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(new FileInputStream("inputPersone.xml"));
        }
        catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
        }

        try{
            while(xmlr.hasNext()){

                switch (xmlr.getEventType()){

                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start read document: " + "inputPerrsone.xml");
                        break;

                    case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                        System.out.println("Tag " + xmlr.getLocalName());
                        for (int i = 0; i < xmlr.getAttributeCount(); i++)
                            System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
                        break;

                    case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                        System.out.println("END-Tag " + xmlr.getLocalName());
                        break;

                    case XMLStreamConstants.COMMENT:
                        System.out.println("// commento " + xmlr.getText());
                        break;// commento: ne stampa il contenuto

                    case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                        if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                            System.out.println("-> " + xmlr.getText());
                        break;

                }
                xmlr.next();
            }
        } catch (Exception e){
            System.out.println("Errore nella lettura:");
        }
    }
}