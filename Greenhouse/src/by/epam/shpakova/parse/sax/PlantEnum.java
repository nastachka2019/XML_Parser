package by.epam.shpakova.parse.sax;

public enum PlantEnum {

    FLOWERS("flowers"),
    PLANT("plant"),
    ID("id"),
    NAME("name"),
    SOIL("soil"),
    MULTIPLYING("multiplying"),
    COUNTRY("country"),
    STEMCOLOR("stemColor"),
    LEAFCOLOR("leafColor"),
    AVERAGESIZE("averageSize"),
    TEMPERATURE("temperature"),
    LIGHT("light"),
    WATERING("watering"),
    GROWINGTIPS("growingTips"),
    VISUALPARAMETERS("visualParameters"),
    ORIGIN("origin"),
    FLOWERING("flowering");


    private String value;

    PlantEnum(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
}
