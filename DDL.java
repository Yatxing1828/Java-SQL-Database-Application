package Database_Proj;

public class DDL {

    static String DROP_DATABASE = "DROP DATABASE IF EXISTS project;";
    static String CREATE_DATABASE = "CREATE DATABASE project;";
    static String USE_DATABASE = "use project;";

    static String DROP_USER_TABLE = "DROP TABLE IF EXISTS `user`;";
    static String DROP_GROCER_TABLE = "DROP TABLE IF EXISTS grocer;";
    static String DROP_PROFILE_TABLE = "DROP TABLE IF EXISTS profile;";
    static String DROP_RECIPE_TABLE = "DROP TABLE IF EXISTS recipe;";
    static String DROP_SHARING_TABLE = "DROP TABLE IF EXISTS sharing;";
    static String DROP_COMMENT_TABLE = "DROP TABLE IF EXISTS comment;";
    static String DROP_ITEM_TABLE = "DROP TABLE IF EXISTS item;";
    static String DROP_COLLECTION_TABLE = "DROP TABLE IF EXISTS collection;";
    static String DROP_INGREDIENT_TABLE = "DROP TABLE IF EXISTS ingredient;";
    static String DROP_STOCK_TABLE = "DROP TABLE IF EXISTS stock;";
    static String DROP_ANYRES_TABLE = "DROP TABLE IF EXISTS any_res;";
    static String DROP_FILTER_TABLE = "DROP TABLE IF EXISTS filter;";

    static String USER_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`user` (" +
        "`user_id` INT NOT NULL," +
        "`user_name` VARCHAR(45) NOT NULL," +
        "`user_sex` ENUM('Male', 'Female', 'Other') NOT NULL," +
        "`user_age` INT NOT NULL," +
        "`user_phone` VARCHAR(10) NOT NULL," +
        "`user_email` VARCHAR(100) NOT NULL," +
        "`user_address` VARCHAR(100) NOT NULL," +
        "`grocer_id` INT NOT NULL," +
        "PRIMARY KEY (`user_id`, `grocer_id`)," +
        "CONSTRAINT `user_grocer_id_fk1`" +
        "FOREIGN KEY (`grocer_id`)" +
        "REFERENCES `project`.`grocer` (`grocer_id`));";

    static String GROCER_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`grocer` (" +
        "`grocer_id` INT NOT NULL," +
        "`grocer_name` VARCHAR(45) NOT NULL," +
        "PRIMARY KEY (`grocer_id`));";

    static String PROFILE_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`profile` (" +
        "`profile_id` INT NOT NULL," +
        "`profile_cuisine` ENUM('English', 'French', 'Spanish', 'Mexican', 'Chinese', 'Japanese', 'Korean', 'Indian', 'Italian') NULL,"
        +
        "`profile_spicy` BIT(1) NULL," +
        "`profile_time` INT NULL," +
        "`profile_skill` ENUM('Beginner', 'Intermediate', 'Advanced', 'Professional') NULL," +
        "`profile_res` ENUM('Dairy', 'Nuts', 'Gluten', 'Meat') NULL," +
        "PRIMARY KEY (`profile_id`));";

    static String RECIPE_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`recipe` (" +
        "`recipe_id` INT NOT NULL," +
        "`recipe_name` VARCHAR(45) NOT NULL," +
        "`recipe_skill` ENUM('Beginner', 'Intermediate', 'Advanced', 'Professional') NOT NULL," +
        "`recipe_time_min` INT NOT NULL," +
        "`recipe_res` ENUM('Dairy', 'Nuts', 'Gluten', 'Meat') NULL," +
        "PRIMARY KEY (`recipe_id`));";

    static String SHARING_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`sharing` (" +
        "`sharing_id` INT NOT NULL," +
        "`sharing_subject` VARCHAR(255) NULL," +
        "`sharing_text` VARCHAR(999) NOT NULL," +
        "`sharing_recipe` INT NOT NULL," +
        "`user_id1` INT NOT NULL," +
        "`user_id2` INT NOT NULL," +
        "PRIMARY KEY (`sharing_id`, `sharing_recipe`, `user_id1`, `user_id2`)," +
        "CONSTRAINT `sharing_recipe_id_fk1`" +
        "FOREIGN KEY(`sharing_recipe`)" +
        "REFERENCES `project`.`recipe` (`recipe_id`)," +
        "CONSTRAINT `sharing_user_id_fk1`" +
        "FOREIGN KEY (`user_id1`)" +
        "REFERENCES `project`.`user` (`user_id`)," +
        "CONSTRAINT `sharing_user_id_fk2`" +
        "FOREIGN KEY (`user_id2`)" +
        "REFERENCES `project`.`user` (`user_id`));";

    static String COMMENT_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`comment` (" +
        "`comment_id` INT NOT NULL," +
        "`comment_rating` INT NOT NULL," +
        "`comment_text` VARCHAR(200) NULL," +
        "`recipe_recipe_id` INT NOT NULL," +
        "`user_user_id` INT NOT NULL," +
        "PRIMARY KEY (`comment_id`, `recipe_recipe_id`, `user_user_id`)," +
        "CONSTRAINT `comment_recipe_id_fk1`" +
        "FOREIGN KEY (`recipe_recipe_id`)" +
        "REFERENCES `project`.`recipe` (`recipe_id`)," +
        "CONSTRAINT `comment_user_id_fk1`" +
        "FOREIGN KEY (`user_user_id`)" +
        "REFERENCES `project`.`user` (`user_id`));";

    static String ITEM_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`item` (" +
        "`item_id` INT NOT NULL," +
        "`item_name` VARCHAR(45) NOT NULL," +
        "`item_quantity` INT NOT NULL," +
        "PRIMARY KEY (`item_id`));";

    static String COLLECTION_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`collection` (" +
        "`recipe_id` INT NOT NULL," +
        "`user_id` INT NOT NULL," +
        "PRIMARY KEY (`recipe_id`, `user_id`)," +
        "CONSTRAINT `recipe_has_user_recipe_id_fk`" +
        "FOREIGN KEY (`recipe_id`)" +
        "REFERENCES `project`.`recipe` (`recipe_id`)," +
        "CONSTRAINT `recipe_has_user_user_id_fk1`" +
        "FOREIGN KEY (`user_id`)" +
        "REFERENCES `project`.`user` (`user_id`));";

    static String INGREDIENT_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`ingredient` (" +
        "`item_id` INT NOT NULL," +
        "`recipe_id` INT NOT NULL," +
        "`ingredient_amt` INT NOT NULL," +
        "PRIMARY KEY (`item_id`, `recipe_id`)," +
        "CONSTRAINT `ingredient_has_recipe_ingredient_id_fk1`" +
        "FOREIGN KEY (`item_id`)" +
        "REFERENCES `project`.`item` (`item_id`)," +
        "CONSTRAINT `ingredient_has_recipe_recipe_id_fk1`" +
        "FOREIGN KEY (`recipe_id`)" +
        "REFERENCES `project`.`recipe` (`recipe_id`));";

    static String STOCK_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`stock` (" +
        "`item_id` INT NOT NULL," +
        "`grocer_id` INT NOT NULL," +
        "`stock_cost` DECIMAL(10,2) NOT NULL," +
        "PRIMARY KEY (`item_id`, `grocer_id`)," +
        "CONSTRAINT `ingredient_has_grocer_ingredient_id_fk1`" +
        "FOREIGN KEY (`item_id`)" +
        "REFERENCES `project`.`item` (`item_id`)," +
        "CONSTRAINT `ingredient_has_grocer_grocer_id_fk1`" +
        "FOREIGN KEY (`grocer_id`)" +
        "REFERENCES `project`.`grocer` (`grocer_id`));";

    static String ANYRES_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`any_res` (" +
        "`user_id` INT NOT NULL," +
        "`profile_id` INT NOT NULL," +
        "PRIMARY KEY (`user_id`, `profile_id`)," +
        "CONSTRAINT `user_has_profile_user_id_fk1`" +
        "FOREIGN KEY (`user_id`)" +
        "REFERENCES `project`.`user` (`user_id`)," +
        "CONSTRAINT `user_has_profile_profile_id_fk1`" +
        "FOREIGN KEY (`profile_id`)" +
        "REFERENCES `project`.`profile` (`profile_id`));";

    static String FILTER_TABLE = "CREATE TABLE IF NOT EXISTS `project`.`filter` (" +
        "`profile_id` INT NOT NULL," +
        "`recipe_id` INT NOT NULL," +
        "PRIMARY KEY (`profile_id`, `recipe_id`)," +
        "CONSTRAINT `profile_has_recipe_profile_id_fk1`" +
        "FOREIGN KEY (`profile_id`)" +
        "REFERENCES `project`.`profile` (`profile_id`)," +
        "CONSTRAINT `profile_has_recipe_recipe_id_fk1`" +
        "FOREIGN KEY (`recipe_id`)" +
        "REFERENCES `project`.`recipe` (`recipe_id`));";

    public static void createDatabase(MySQL mySQL) {

        mySQL.execute(DROP_DATABASE);
        mySQL.execute(CREATE_DATABASE);

        // Drop/create database
        mySQL.execute(USE_DATABASE);

        // Set up tables
        mySQL.execute(DROP_SHARING_TABLE);
        mySQL.execute(DROP_STOCK_TABLE);
        mySQL.execute(DROP_ANYRES_TABLE);
        mySQL.execute(DROP_INGREDIENT_TABLE);
        mySQL.execute(DROP_FILTER_TABLE);
        mySQL.execute(DROP_COLLECTION_TABLE);
        mySQL.execute(DROP_COMMENT_TABLE);
        mySQL.execute(DROP_USER_TABLE);
        mySQL.execute(DROP_GROCER_TABLE);
        mySQL.execute(DROP_PROFILE_TABLE);
        mySQL.execute(DROP_RECIPE_TABLE);
        mySQL.execute(DROP_ITEM_TABLE);

        mySQL.execute(GROCER_TABLE);
        mySQL.execute(USER_TABLE);
        mySQL.execute(PROFILE_TABLE);
        mySQL.execute(RECIPE_TABLE);
        mySQL.execute(SHARING_TABLE);
        mySQL.execute(COMMENT_TABLE);
        mySQL.execute(ITEM_TABLE);
        mySQL.execute(COLLECTION_TABLE);
        mySQL.execute(INGREDIENT_TABLE);
        mySQL.execute(STOCK_TABLE);
        mySQL.execute(ANYRES_TABLE);
        mySQL.execute(FILTER_TABLE);
    }


}
