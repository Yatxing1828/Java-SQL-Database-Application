package Database_Proj;

public class Grocer {
    int id;
    String name;

    public Grocer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void getId(int id) {
        this.id = id;
    }

    public void getName(String name) {
        this.name = name;
    }
}
