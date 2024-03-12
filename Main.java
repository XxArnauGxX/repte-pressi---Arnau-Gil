import org.apache.fop.apps.FopFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

        System.out.println("¡Configuración de Apache FOP completada!");
    }
}
