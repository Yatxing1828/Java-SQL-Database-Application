package Database_Proj;

public class Ingredient {
  int amt;
  int item_id;
  int recipe_id;

  public Ingredient(int item_id, int recipe_id, int amt) {
    this.amt = amt;
    this.item_id = item_id;
    this.recipe_id = recipe_id;
  }

  public int getAmt() {
    return amt;
  }

  public void setAmount(int amt) {
    this.amt = amt;
  }

  public int getItem_id() {
    return item_id;
  }

  public void setItem_id(int item_id) {
    this.item_id = item_id;
  }

  public int getRecipe_id() {
    return recipe_id;
  }

  public void setRecipe_id(int recipe_id) {
    this.recipe_id = recipe_id;
  }
}
