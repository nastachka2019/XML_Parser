package by.epam.shpakova.entity;

public class VisualParameters {
    private String stemColor;
    private String leafColor;
    private int averageSize;

    public VisualParameters() {
    }

    public VisualParameters(String stemColor, String leafColor, int averageSize) {
        this.stemColor = stemColor;
        this.leafColor = leafColor;
        this.averageSize = averageSize;
    }

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public int getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(int averageSize) {
        this.averageSize = averageSize;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        VisualParameters visualParameters = (VisualParameters) object;
        return averageSize == visualParameters.averageSize && (leafColor == visualParameters.leafColor
                || leafColor != null && leafColor.equals(visualParameters.getLeafColor())) && (stemColor == visualParameters.stemColor
                || (stemColor != null && stemColor.equals(visualParameters.getStemColor())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((stemColor == null ? 0 : stemColor.hashCode()));
        result = prime * result + ((leafColor == null ? 0 : leafColor.hashCode()));
        result = prime * result + averageSize;
        return result;
    }

    @Override
    public String toString() {
        return "VisualParameters: color of stems : " + this.stemColor + " , color of leaves : " +
                this.leafColor + " , the average size of plant : " + this.averageSize + ".";
    }
}
