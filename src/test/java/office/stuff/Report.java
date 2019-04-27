package office.stuff;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

public class Report {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("/Users/ojitha/workspace/test/test.xml");
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc =  builder.parse(file);
        doc.normalizeDocument();
        NodeList roots = doc.getElementsByTagName("int");
        System.out.println("Length" + roots.getLength());
        NodeList rows = roots.item(0).getChildNodes();
        System.out.println("length: "+ rows.getLength());
        List<List<Integer>> listOfRows = new LinkedList<>();
        for(int i = 0; i < rows.getLength(); i++ ){
            Node node = rows.item(i);
            if (node.hasChildNodes()) {
                NodeList children = node.getChildNodes();
                List<Integer> row = new LinkedList<>();
                for(int j = 0; j < children.getLength(); j++){
                    if (children.item(j).hasChildNodes()) {
                        //System.out.println("#"+i+"."+j+" => " + children.item(j).getNodeValue());
                        row.add(Integer.parseInt(children.item(j).getTextContent().trim()));
                    }
                }
                listOfRows.add(row);
                //System.out.println("" + i + " == > name " + node.getTextContent() + " val: " + node.getNodeValue());
            }


        }
        System.out.println(printTable(listOfRows));
    }

    public static String printTable(List<List<Integer>> rows){
        String result ="";
        String[] rowTitle = {" Features  ", " Scenarios ", "   Steps   "};
        String seperat  =   " -------------------------------------------------------------------";
        String heading  =   "|           | Passed      | Failed      | Total       | % of Passed |";
        MessageFormat line = new MessageFormat("|{0}|{1}|{2}|{3}|{4}%|");
        result +=seperat+"\n";
        result +=heading+"\n";

        for(int i = 0; i < rows.size(); i++){
            List<Integer> row = rows.get(i);
            result +=seperat + "\n";
            Double percentage = (Double.valueOf(row.get(0))/(Double.valueOf(row.get(0))+Double.valueOf(row.get(1))))*100;

            result += line.format(new Object[]{
                     rowTitle[i]
                    ,String.format("%13d",row.get(0))
                    ,String.format("%13d",row.get(1))
                    ,String.format("%13d",row.get(0)+row.get(1))
                    ,String.format("%12d",Math.round(percentage))})+"\n";
        }

        result +=seperat+"\n";
        return result;
    }
}
