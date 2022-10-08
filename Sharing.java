package Database_Proj;

public class Sharing {
    int id;
    String subject;
    String text;
    int recipe;
    int user_id;
    int user_id1;

    public Sharing(int id, String subject, String text, int recipe, int user_id, int user_id1) {
        this.id = id;
        this.subject = subject;
        this.text = text;
        this.recipe = recipe;
        this.user_id = user_id;
        this.user_id1 = user_id1;
    }

    public Sharing(int id, String text, int recipe, int user_id, int user_id1) {
        this.id = id;
        this.text = text;
        this.recipe = recipe;
        this.user_id = user_id;
        this.user_id1 = user_id1;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public int getRecipe() {
        return recipe;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getUser_id1() {
        return user_id1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_id1(int user_id1) {
        this.user_id1 = user_id1;
    }
}
