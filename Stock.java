package Database_Proj;

public class Stock {
    int item_id;
    int grocer_id;
    double cost;

    public Stock(int item_id, int grocer_id, double cost) {
        this.item_id = item_id;
        this.grocer_id = grocer_id;
        this.cost = cost;
    }

    public int getItem_id() {
        return item_id;
    }
    
    public int getGrocer_id() {
        return grocer_id;
    }

    public double getCost() {
        return cost;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setGrocer_id(int grocer_id) {
        this.grocer_id = grocer_id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
