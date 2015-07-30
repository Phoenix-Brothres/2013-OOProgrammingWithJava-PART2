public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
    
    public int hashCode() {
        if (this.latinName == null) {
            return 7;
        }

        return this.ringingYear + this.latinName.hashCode();
    }
    
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Bird compared = (Bird) o;
        
        
        return (this.latinName.equals(compared.latinName)) && (this.ringingYear == compared.ringingYear);
    }
}


