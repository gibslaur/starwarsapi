public class Planet {

    private String name;
    private int diameter;
    private String climate;
    private String gravity;
    private String population;

    public Planet(String name, int diameter, String climate, String gravity,
                  String population) {
        this.name = name;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "name= " + name + ", " +
                "diameter= " + diameter + ", " +
                "climate= " + climate + ", " +
                "gravity= " + gravity + ", " +
                "population= " + population;
    }

}
