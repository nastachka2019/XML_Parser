package by.epam.shpakova.parse;

import by.epam.shpakova.entity.Plant;
import by.epam.shpakova.exception.FlowersSAXBuilderException;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

import java.util.HashSet;
import java.util.Set;

public abstract class FlowersBuilder {
    private Set<Plant> flowers;

    protected FlowersBuilder() {
        this.flowers = new HashSet<>();
    }

    public Set<Plant> getFlowers() {
        return flowers;
    }

    public abstract void buildSetPlants(String fileName) throws IOException, XMLStreamException, SAXException, FlowersSAXBuilderException;
}
