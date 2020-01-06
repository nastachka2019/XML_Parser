package by.epam.shpakova.validator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;


public class XMLValidatorTest {
    XMLValidator xmlValidator;
    boolean actual;

    @BeforeMethod
    public void setUp() throws IOException, SAXException {
        xmlValidator = new XMLValidator();


    }

    @AfterMethod
    public void tearDown() {
        xmlValidator = null;
    }


    @Test
    public void fileIsCorrect() throws IOException, SAXException {
        boolean actual = xmlValidator.validFile("data/flowers.xml");
        Assert.assertTrue(actual);
    }

    @Test
    public void fileIsNotCorrect() throws IOException, SAXException {
        boolean actual = xmlValidator.validFile("data/flowers_incorrect.xml");
        Assert.assertTrue(actual);
    }
}
