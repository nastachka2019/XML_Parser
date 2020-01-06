package by.epam.shpakova.parse.stax;

import by.epam.shpakova.entity.GrowingTips;
import by.epam.shpakova.entity.Origin;
import by.epam.shpakova.entity.Plant;
import by.epam.shpakova.entity.VisualParameters;
import by.epam.shpakova.parse.FlowersBuilder;
import by.epam.shpakova.parse.sax.PlantEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class FlowersStAXBuilder extends FlowersBuilder {

    private Set<Plant> flowers;
    private XMLInputFactory inputFactory;           //для  создания XML-документа

    public FlowersStAXBuilder() {
        flowers = new HashSet<>();
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<Plant> getFlowers() {
        return flowers;
    }

    @Override
    public void buildSetPlants(String fileName) throws XMLStreamException, FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(new File(fileName));  // создание входного потока данных из xml-файла
        XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
        String name;

        while (reader.hasNext()) {
            int type = reader.next();

            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();

                if (PlantEnum.valueOf(name.toUpperCase()) == PlantEnum.PLANT) {
                    Plant plant = buildPlant(reader);
                    flowers.add(plant);
                }
            }
        }
    }

    private Plant buildPlant(XMLStreamReader reader) throws XMLStreamException {
        Plant plant = new Plant();

        plant.setId(reader.getAttributeValue(null, PlantEnum.ID.getValue()));   //возвращает значение атрибута по его имени
        plant.setName(reader.getAttributeValue(null, PlantEnum.NAME.getValue()));
        plant.setSoil(reader.getAttributeValue(null, PlantEnum.SOIL.getValue()));
        if (reader.getAttributeValue(null, PlantEnum.MULTIPLYING.getValue()) != null) {
            plant.setMultiplying(reader.getAttributeValue(null, PlantEnum.MULTIPLYING.getValue()));
        }

        String name;
        while (reader.hasNext()) {          // определение типа "прочтённого" элемента (тега)
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PlantEnum.valueOf(name.toUpperCase())) {
                        case ORIGIN:
                            plant.setOrigin(getXMlOrigin(reader));
                            break;
                        case VISUALPARAMETERS:
                            plant.setVisualParameters(getXMlVisual(reader));
                            break;
                        case GROWINGTIPS:
                            plant.setGrowingTips(getXMlGrowingTips(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PlantEnum.valueOf(name.toUpperCase()) == PlantEnum.PLANT) {
                        return plant;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in Plant");
    }


    private Origin getXMlOrigin(XMLStreamReader reader) throws XMLStreamException {
        Origin origin = new Origin();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PlantEnum.valueOf(name.toUpperCase())) {
                        case COUNTRY:
                            origin.setCountry(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PlantEnum.valueOf(name.toUpperCase()) == PlantEnum.ORIGIN) {
                        return origin;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in  Origin");
    }

    private VisualParameters getXMlVisual(XMLStreamReader reader) throws XMLStreamException {
        VisualParameters visual = new VisualParameters();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PlantEnum.valueOf(name.toUpperCase())) {
                        case STEMCOLOR:
                            visual.setStemColor(getXMLText(reader));
                            break;
                        case LEAFCOLOR:
                            visual.setLeafColor(getXMLText(reader));
                            break;
                        case AVERAGESIZE:
                            visual.setAverageSize(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PlantEnum.valueOf(name.toUpperCase()) == PlantEnum.VISUALPARAMETERS) {
                        return visual;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in  VisualParameters");
    }

    private GrowingTips getXMlGrowingTips(XMLStreamReader reader) throws XMLStreamException {
        GrowingTips growingTips = new GrowingTips();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PlantEnum.valueOf(name.toUpperCase())) {
                        case TEMPERATURE:
                            growingTips.setTemperature(Integer.parseInt(getXMLText(reader)));
                            break;  //не считали 3 элемента
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PlantEnum.valueOf(name.toUpperCase()) == PlantEnum.GROWINGTIPS) {
                        return growingTips;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in  GrowingTips");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException { // Для чтения  XML надо получить ссылку на XMLStreamReader
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
