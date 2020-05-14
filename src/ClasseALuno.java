import com.sun.deploy.security.SelectableSecurityManager;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class CodiceFiscale {


                String[] calcolati = new String[]{"MRTZRR43B64D763D", "MSAMDI85M06E221C", "LLLMKM32D06E221C"};

                Utility fiscali = new Utility();

                //Legge codici Fiscali da codiciFiscali.XML

                fiscali.initReader("codiciFiscali.xml");

                fiscali.createTotal();

                fiscali.controlValid();

                // controllo accoppiamenti
                for (int i = 0; i < 1000; i++) {
                        if(fiscali.sexTogheter(calcolati[i]).equals("ASSENTE")) {//Set codice fiscale con "ASSENTE"
                        }
                }

                // Inizializzo e scrivo file output.xml

                fiscali.initWriter("codiciPersone.xml");

                fiscali.createOutput();



}