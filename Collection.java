package Database_Proj;

public class Collection {
  int recipe_id;
  int user_id;

  public Collection(int recipe_id, int user_id) {
    this.recipe_id = recipe_id;
    this.user_id = user_id;
  }


  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getRecipe_id() {
    return recipe_id;
  }

  public void setRecipe_id(int recipe_id) {
    this.recipe_id = recipe_id;
  }

}
