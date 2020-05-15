import javax.xml.stream.XMLInputFactory;
 
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class Lettore {

	public XMLInputFactory getXmlif() {
		return xmlif;
	}

	public void setXmlif(XMLInputFactory xmlif) {
		this.xmlif = xmlif;
	}

	public XMLStreamReader getXmlr() {
		return xmlr;
	}

	public void setXmlr(XMLStreamReader xmlr) {
		this.xmlr = xmlr;
	}

	XMLInputFactory xmlif = null;
    XMLStreamReader xmlr = null;
	public Lettore ()
	{
		
	}

	public void initReader(String nome_file){

	    
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(new FileInputStream(nome_file));
        }
        catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
        }
    }
	

}