package Database_Proj;

public class Filter {
  int profile_id;
  int recipe_id;

  public Filter(int profile_id, int recipe_id) {
    this.profile_id = profile_id;
    this.recipe_id = recipe_id;
  }

  public int getProfile_id() {
    return profile_id;
  }

  public void setProfile_id(int profile_id) {
    this.profile_id = profile_id;
  }

  public int getRecipe_id() {
    return recipe_id;
  }

  public void setRecipe_id(int recipe_id) {
    this.recipe_id = recipe_id;
  }
}
