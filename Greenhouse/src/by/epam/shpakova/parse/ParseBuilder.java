package by.epam.shpakova.parse;

import by.epam.shpakova.exception.FlowersSAXBuilderException;
import by.epam.shpakova.parse.dom.FlowersDOMBuilder;
import by.epam.shpakova.parse.sax.FlowersSAXBuilder;
import by.epam.shpakova.parse.stax.FlowersStAXBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;


public class ParseBuilder {
    public enum ParserType {
        DOM,
        SAX,
        StAX
    }

    public FlowersBuilder parse (ParserType parserType) throws SAXException, ParserConfigurationException, FlowersSAXBuilderException {
        switch (parserType) {
            case DOM:
                return new FlowersDOMBuilder();
            case SAX:
                return new FlowersSAXBuilder();
            case StAX:
                return new FlowersStAXBuilder();
            default:
                throw new IllegalArgumentException("No such parser");
        }
    }
}
