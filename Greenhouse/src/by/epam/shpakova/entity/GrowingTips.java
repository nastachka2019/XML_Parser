package by.epam.shpakova.entity;

public class GrowingTips {
    private int temperature;
    private boolean light;
    private int watering;
    private String flowering;                          //дата цветения

    public GrowingTips() {
    }

    public GrowingTips(int temperature, boolean light, int watering, String flowering) {
        this.temperature = temperature;
        this.light = light;
        this.watering = watering;
        this.flowering = flowering;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    public String getFlowering() {
        return flowering;
    }

    public void setFlowering(String flowering) {
        this.flowering = flowering;
    }

    @Override
    public String toString() {
        return "GrowingTips :" +
                "temperature=" + temperature +
                ", light=" + light +
                ", water=" + watering +
                ", the date of flowering is " + flowering;

    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        GrowingTips growingTips = (GrowingTips) object;
        return temperature == growingTips.temperature &&
                light == growingTips.light &&
                (watering == growingTips.watering ||
                        (flowering != null && flowering.equals(growingTips.getFlowering()))) && (flowering == growingTips.flowering ||
                (flowering != null && flowering.equals(growingTips.getFlowering())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + temperature;
        result = prime * result + watering;
        result = prime * result + ((light) ? 1 : 0);
        result = prime * result + ((flowering == null ? 0 : flowering.hashCode()));
        return result;
    }
}
