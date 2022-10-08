package Database_Proj;

public class Comment {
    int id;
    int rating;
    String text;
    int recipe_id;
    int user_id;

    public Comment(int id, int rating, String text, int recipe_id, int user_id) {
        this.id = id;
        this.rating = rating;
        this.text = text;
        this.recipe_id = recipe_id;
        this.user_id = user_id;
    }

    public Comment(int id, int rating, int recipe_id, int user_id) {
        this.id = id;
        this.rating = rating;
        this.recipe_id = recipe_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}