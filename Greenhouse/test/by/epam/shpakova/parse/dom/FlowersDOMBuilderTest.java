package by.epam.shpakova.parse.dom;

import by.epam.shpakova.entity.GrowingTips;
import by.epam.shpakova.entity.Origin;
import by.epam.shpakova.entity.Plant;
import by.epam.shpakova.entity.VisualParameters;
import by.epam.shpakova.exception.FlowersSAXBuilderException;
import by.epam.shpakova.parse.FlowersBuilder;
import by.epam.shpakova.parse.ParseBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static by.epam.shpakova.parse.ParseBuilder.ParserType.DOM;


public class FlowersDOMBuilderTest {
    private Set<Plant> flowers = new HashSet<>();
    ParseBuilder parseBuilder;
    FlowersBuilder flowersBuilder;
    Set<Plant> actual = flowersBuilder.getFlowers();
    @BeforeMethod
    public void setUp() throws SAXException, XMLStreamException, FlowersSAXBuilderException, IOException, ParserConfigurationException {
        parseBuilder = new ParseBuilder();
        flowersBuilder=parseBuilder.parse(DOM);
        flowersBuilder.buildSetPlants("data/flowers_test.xml");

    }

    @AfterMethod
    public void tearDown() {
parseBuilder=null;
flowersBuilder=null;
    }

    @Test
    public void testDOMParser() {

        flowers.add(new Plant("G1", "gerber", "sod_podzolic","stalk", new Origin("Germany"), new VisualParameters("green", "green", 23), new GrowingTips(25, true, 220, "1687-10-30")));
        flowers.add(new Plant("GL1", "gladiolus", "podzolic","leaf", new Origin("China"), new VisualParameters("green", "green", 28), new GrowingTips(20, true, 150, "1452-01-19")));

        Assert.assertEquals(actual, flowers);
    }
}