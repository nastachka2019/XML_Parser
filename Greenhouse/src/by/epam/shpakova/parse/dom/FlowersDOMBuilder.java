package by.epam.shpakova.parse.dom;

import by.epam.shpakova.entity.Plant;
import by.epam.shpakova.parse.FlowersBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FlowersDOMBuilder extends FlowersBuilder {
    private Set<Plant> flowers;
    private DocumentBuilder documentBuilder;

    public FlowersDOMBuilder() throws ParserConfigurationException {
        this.flowers = new HashSet<>();
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();      // создание DOM-анализатора(JSDK)
        documentBuilder = dbf.newDocumentBuilder();
    }

    @Override
    public Set<Plant> getFlowers() {
        return flowers;
    }

    @Override
    public void buildSetPlants(String filename) throws  IOException, SAXException {
        Document document = documentBuilder.parse(filename);       // распознавание XML-документа

        Element root = document.getDocumentElement();             // вспомогательный атрибут, который разрешает прямой доступ к дочернему узлу, который является элементом документа
        NodeList nodeList = root.getElementsByTagName("plant");          // // получение списка дочерних элементов <plant>
Plant plant=null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element plantElement = (Element) nodeList.item(i);
          plant = buildPlant(plantElement);
            flowers.add(plant);
        }

    }

    private Plant buildPlant(Element plantElement) {               // заполнение объекта <plant>
        Plant plant = new Plant();

        plant.setId(plantElement.getAttribute("id"));
        plant.setName(plantElement.getAttribute("name"));
        plant.setSoil(plantElement.getAttribute("soil"));
        plant.setSoil(plantElement.getAttribute("multiplying"));
        Element originElement = (Element) plantElement.getElementsByTagName("origin").item(0);
        Element visualParametersElement =(Element) plantElement.getElementsByTagName("visualParameters").item(0);
        Element growingTipsElement = (Element) plantElement.getElementsByTagName("growingTips").item(0);
        plant.getOrigin().setCountry(takeElementText(originElement, "country"));

        plant.getVisualParameters().setStemColor(takeElementText(visualParametersElement, "stemColor"));
        plant.getVisualParameters().setLeafColor(takeElementText(visualParametersElement, "leafColor"));
        plant.getVisualParameters().setAverageSize(Integer.parseInt(takeElementText(visualParametersElement, "averageSize")));

        plant.getGrowingTips().setTemperature(Integer.parseInt(takeElementText(growingTipsElement, "temperature")));
        plant.getGrowingTips().setLight(Boolean.parseBoolean(takeElementText(growingTipsElement, "light")));
        plant.getGrowingTips().setWatering(Integer.parseInt(takeElementText(growingTipsElement, "water")));

        return plant;
    }

    // возвращает дочерний элемент по его имени и родительскому элементу
    private static String takeElementText(Element element,String elementName) {
        NodeList nodeList =element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
    // возвращает текст, содержащийся в элементе
//    private static String getTextElement(Element element,String elementName) {
//        String child = takeElementText(element, elementName);
//        Node node = child.getFirstChild();
//        String value = node.getNodeValue();
//        return value;
//    }
}
