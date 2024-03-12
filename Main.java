import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Result;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputXmlFilePath = "input.xml";
        String outputPdfFilePath = "output.pdf";

        try {
            // Paso 1: Configurar FOP
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

            // Paso 2: Crear el archivo de salida
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(outputPdfFilePath)));

            try {
                // Paso 3: Crear el objeto Fop
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

                // Paso 4: Procesar la transformación
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(new File(inputXmlFilePath)));
                Result res = new SAXResult(fop.getDefaultHandler());

                // Paso 5: Transformar el XML a PDF
                transformer.transform(new StreamSource(new File(inputXmlFilePath)), res);

                System.out.println("¡PDF creado con éxito!");
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
