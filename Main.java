import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.MimeConstants;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Result;
import javax.xml.transform.sax.SAXResult;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {

    private static final String INPUT_XML_FILE = "input.xml";
    private static final String OUTPUT_PDF_FILE = "output.pdf";

    public static void main(String[] args) {
        try {

            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}