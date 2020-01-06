package by.epam.shpakova.entity;

import java.util.Objects;

public class Plant {
    private String id;
    private String name;
    private String soil;
    private Origin origin;
    private VisualParameters visualParameters;
    private GrowingTips growingTips;
    private String multiplying;
    private String flowering;

    public Plant() {
        this.origin = new Origin();
        this.visualParameters = new VisualParameters();
        this.growingTips = new GrowingTips();
    }

    public Plant(String id, String name, String soil, String multiplying, Origin origin, VisualParameters visualParameters, GrowingTips growingTips) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.growingTips = growingTips;
        this.multiplying = multiplying;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    public String getFlowering() {
        return flowering;
    }

    public void setFlowering(String flowering) {
        this.flowering = flowering;
    }

    @Override
    public String toString() {
        return "Plant :" + '\n' +
                "id=" + id + '\n' +
                "name=" + name + '\n' +
                "soil=" + soil + '\n' +
                "origin=" + origin + '\n' +
                "visualParameters=" + visualParameters + '\n' +
                "growingTips=" + growingTips + '\n' +
                "multiplying=" + multiplying + '\n' +
                "the date of flowering is: " + flowering
                + '\n';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Plant plant = (Plant) object;
        return
                (id == plant.id || (id != null && id.equals(plant.getId()))) && (name == plant.name || (name != null && name.equals(plant.getName()))) &&
                        (soil == plant.soil || (soil != null && soil.equals(plant.getSoil()))) && (multiplying == plant.multiplying
                        || (multiplying != null && multiplying.equals(plant.getMultiplying()))) &&
                        (flowering == plant.flowering || (flowering != null && flowering.equals(plant.getFlowering()))) &&
                        (origin == plant.origin || (origin != null && origin.equals(plant.getOrigin()))) &&
                        (visualParameters == plant.visualParameters || (visualParameters != null && visualParameters.equals(plant.getVisualParameters()))) &&
                        (growingTips == plant.growingTips || (growingTips != null && growingTips.equals(plant.getGrowingTips())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null ? 0 : id.hashCode()));
        result = prime * result + ((name == null ? 0 : name.hashCode()));
        result = prime * result + ((soil == null ? 0 : soil.hashCode()));
        result = prime * result + ((multiplying == null ? 0 : multiplying.hashCode()));
        result = prime * result + ((flowering == null ? 0 : flowering.hashCode()));
        result = prime * result + ((origin == null ? 0 : origin.hashCode()));
        result = prime * result + ((visualParameters == null ? 0 : visualParameters.hashCode()));
        result = prime * result + ((growingTips== null ? 0 : growingTips.hashCode()));
        return result;
    }
}
