import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Result;
import javax.xml.transform.sax.SAXResult;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            // Paso 1: Configurar FOP
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

            // Paso 2: Crear el archivo de salida
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("output.pdf")));

            // Paso 3: Crear el objeto Fop
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

            // Paso 4: Procesamiento de transformación
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(new File("input.xml")));
            Result res = new SAXResult(fop.getDefaultHandler());

            // Paso 5: Transformar el XML a PDF
            transformer.transform(new StreamSource(new File("input.xml")), res);

            System.out.println("¡PDF creado con éxito!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
