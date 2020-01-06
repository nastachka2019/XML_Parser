package by.epam.shpakova.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class XMLValidator {

    private static final Logger logger = LogManager.getLogger();

    public boolean validFile(String fileName) throws SAXException, IOException {

        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema"); // Поиск и создание экземпляра фабрики для языка XML Schema

        File schemaLocation = new File("data/flowers_incorrect.xml");  //Компиляция схемы
        Schema schema = factory.newSchema(schemaLocation);  // Схема загружается в объект типа java.io.File,

        Validator validator = schema.newValidator();    //Создание валидатора для схемы

        Source source = new StreamSource("flowers_schema.xsd");    // Разбор проверяемого дока

        try {                                                              // Валидация дока
            validator.validate(source);
            logger.info("File is valid");
            return true;
        } catch (SAXException ex) {
            logger.info("File is not valid because ");
            return false;
        }
    }
}
