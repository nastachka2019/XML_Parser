package by.epam.shpakova.parse.sax;

import by.epam.shpakova.entity.Plant;
import by.epam.shpakova.exception.FlowersSAXBuilderException;
import by.epam.shpakova.parse.FlowersBuilder;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

import java.util.Set;

public class FlowersSAXBuilder extends FlowersBuilder {

    private Set<Plant> flowers;
    private PlantHandler plantHandler;
    private XMLReader reader;

    public FlowersSAXBuilder() throws FlowersSAXBuilderException {             //создание SAX-анализатора
        plantHandler = new PlantHandler();
        try{
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(plantHandler);
        } catch (SAXException e) {
            throw new FlowersSAXBuilderException("The SAX parser is not initialized", e);
        }
    }


    @Override
    public Set<Plant> getFlowers() {
        return flowers;
    }

    @Override
    public void buildSetPlants(String fileName)  throws FlowersSAXBuilderException {
        try{
        reader.parse(fileName);
        } catch (SAXException e) {
            throw new FlowersSAXBuilderException("Error SAX parser: ", e);
        } catch (IOException e) {
            throw new FlowersSAXBuilderException("Error I/О with SAX parser: ", e);
        }
        flowers = plantHandler.getFlowers();
    }
}