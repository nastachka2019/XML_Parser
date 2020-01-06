package by.epam.shpakova.entity;

public class Origin {
    private String country;

    public Origin() {
    }

    public Origin(String country) {
        this.country = country;

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object object) {
        if (object ==this) {
            return true;
        }
        if (object==null || object.getClass()!=this.getClass()){
            return false;
        }
       Origin origin = (Origin) object;
        return country == origin.country || (country!=null && country.equals(origin.getCountry())) ;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null ? 0 : country.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        return "Country of plant origin is " + this.country;
    }
}
