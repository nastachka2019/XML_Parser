package by.epam.shpakova.parse.sax;

import by.epam.shpakova.entity.Plant;
import jdk.internal.org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

import java.net.URLConnection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class PlantHandler extends DefaultHandler {      //приложение, обрабатывающее XMLдокумент
    private Set<Plant> flowers;
    private Plant current = null;
    private PlantEnum currentEnum = null;
    private EnumSet<PlantEnum> allText;

    public PlantHandler() {
        flowers = new HashSet<>();
        allText = EnumSet.range(PlantEnum.COUNTRY, PlantEnum.MULTIPLYING);      //создать подмножество enum,EnumSet - коллекция Set для работы с enum
    }

    public Set<Plant> getFlowers() {
        return flowers;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {   //будет вызван, когда анализатор полностью обработает содержимое открывающего
        if (qName.equals("plant")) {                                                                                //тега, включая его имя и все содержащиеся атрибуты
            current = new Plant();
            current.setId(attrs.getValue(0));
            current.setName(attrs.getValue(1));
        }
        if (!"soil".equals(qName) &&
                !"plant".equals(qName) &&
                !qName.equals("flowers"))
            currentEnum = PlantEnum.valueOf(qName.toUpperCase());
    }


    public void endElement(String uri, String localName, String qName){            //сигнализирует о завершении элемента
        if (qName.equals("plant"))
            flowers.add(current);
        currentEnum = null;
    }


    public void ignorableWhitespace(char[] ch, int start, int length) { //вызывается в том случае, если анализатор встретил символьную информацию внутри
        String s = new String(ch, start, length).trim();                              //  элемента (тело тега);
        if (currentEnum != null) return;
        switch (currentEnum) {
            case COUNTRY:
                current.getOrigin().setCountry(s);
                break;
            case STEMCOLOR:
                current.getVisualParameters().setStemColor(s);
                break;
            case LEAFCOLOR:
                current.getVisualParameters().setLeafColor(s);
                break;
            case AVERAGESIZE:
                current.getVisualParameters().setAverageSize(Integer.parseInt(s));
                break;
            case TEMPERATURE:
                current.getGrowingTips().setTemperature(Integer.parseInt(s));
                break;
            case LIGHT:
                current.getGrowingTips().setLight(Boolean.parseBoolean(s));
                break;
            case WATERING:
                current.getGrowingTips().setWatering(Integer.parseInt(s));
                break;
            case FLOWERING:
                current.getGrowingTips().setFlowering(s);
                break;
        }
    }
}
