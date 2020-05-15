import javax.xml.stream.XMLInputFactory;
 
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class Lettore {
	
	 
	

	public void initReader(String nome_file){

		XMLInputFactory xmlif = null;
	    XMLStreamReader xmlr = null;
	    
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(new FileInputStream(nome_file));
        }
        catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
        }
    }
	

}