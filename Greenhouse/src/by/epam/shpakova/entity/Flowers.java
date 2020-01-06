package by.epam.shpakova.entity;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flowers {
    private List<Plant> plantList;

    public Flowers() {
        plantList = new ArrayList<>();
    }

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
    }

    public void add(Plant plant) {
        plantList.add(plant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Flowers flowers = (Flowers) o;
        return (plantList == flowers.plantList || (plantList != null && plantList.equals(flowers.getPlantList())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((plantList == null) ? 0 : plantList.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Flowers : " +
                "plantList=" + plantList;
    }
}
