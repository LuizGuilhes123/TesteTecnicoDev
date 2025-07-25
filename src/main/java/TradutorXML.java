import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TradutorXML {

    private static final Map<String, String> dicionarioInglesPortugues = new HashMap<>();

    static {
        dicionarioInglesPortugues.put("Log on to Nasajon BI", "Acessar o Nasajon BI");
        dicionarioInglesPortugues.put("User Name", "Nome de Usuário");
        dicionarioInglesPortugues.put("Password", "Senha");
        dicionarioInglesPortugues.put("Reset your password", "Redefinir sua senha");
    }

    public static void main(String[] args) {
        File xmlOriginal = new File("C:\\Users\\Guilherme\\Downloads\\ProjetosPessoais\\TesteEmprego\\src\\main\\java\\entrada.xml");
        File xmlTraduzido = new File("saida.xml");

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlOriginal);

            NodeList strings = doc.getElementsByTagName("string");

            for (int i = 0; i < strings.getLength(); i++) {
                Element stringElement = (Element) strings.item(i);
                String textoOriginal = stringElement.getTextContent().trim();

                if (dicionarioInglesPortugues.containsKey(textoOriginal)) {
                    String textoTraduzido = dicionarioInglesPortugues.get(textoOriginal);
                    stringElement.setTextContent(textoTraduzido);
                }
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(xmlTraduzido));

            System.out.println("Arquivo traduzido com sucesso: " + xmlTraduzido.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
