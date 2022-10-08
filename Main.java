package Database_Proj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {


    static String HOST_NAME = "127.0.0.1";
    static String SCHEMA = "";
    static String USER = "linkenn";
    static String PASS = "Klin3284";



    private static MySQL mySQL = new MySQL();

    public static void main(String[] args) {

        mySQL.connect(HOST_NAME, SCHEMA, USER, PASS, "serverTimezone=UTC");

        DDL.createDatabase(mySQL);

        DML.populateDatabase(mySQL);


        /*
        mySQL.execute("INSERT INTO grocer VALUES (0, 'Aldi'), (1, 'Whole Foods'), (2, "
            + "'Star Market');");
        // Insert User Manually
        String insert_user = "INSERT INTO `user` "
            + "VALUES (1, 'alice', 'Female', 1, '1', '1', '1', 1);";
        mySQL.execute(insert_user);
        // mySQL.execute("INSERT INTO grocer VALUES (0, 'Aldi'), (1, 'Whole Foods'), (2,
        // 'Star Market');");
        // very important!!!!!
         */
        mySQL.displayUser();
        mySQL.close();
    }
}




/*

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

 */
// USER INFO
        /*
        User johnDoe = new User(1, "John Doe", Sex.MALE, 20, "1111111111", "johndoe@gmail.com", "1 Huntington Ave Boston, MA 02115", 1);
        User georgeMadden = new User(2, "George Madden", Sex.MALE, 20, "2222222222", "georgemadden@gmail.com", "2 Huntington Ave Boston, MA 02115", 1);
        User louisSaint = new User(3, "Louis Saint", Sex.OTHER, 20, "3333333333", "louissaint@gmail.com", "3 Huntington Ave Boston, MA 02115", 1);
        User maryJay = new User(4, "Mary Jay", Sex.FEMALE, 20, "4444444444", "maryjay@gmail.com", "4 Huntington Ave Boston, MA 02115", 1);
        User bobSmith = new User(5, "Bob Smith", Sex.MALE, 20, "5555555555", "bobsmith@gmail.com", "5 Huntington Ave Boston, MA 02115", 0);
        User jennyLi = new User(6, "Jenny Li", Sex.FEMALE, 20, "6666666666", "jennyli@gmail.com", "6 Huntington Ave Boston, MA 02115", 0);
        User silviaMunn = new User(7, "Silvia Munn", Sex.FEMALE, 20, "7777777777", "silviamunn@gmail.com", "7 Huntington Ave Boston, MA 02115", 0);
        User howardPotts = new User(8, "Howard Potts", Sex.OTHER, 20, "8888888888", "howardpotts@gmail.com", "8 Huntington Ave Boston, MA 02115", 2);
        User annMarie = new User(9, "Ann Marie", Sex.MALE, 20, "9999999999", "annmarie@gmail.com", "9 Huntington Ave Boston, MA 02115", 2);

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(johnDoe);
        userList.add(georgeMadden);
        userList.add(louisSaint);
        userList.add(maryJay);
        userList.add(bobSmith);
        userList.add(jennyLi);
        userList.add(silviaMunn);
        userList.add(howardPotts);
        userList.add(annMarie);


        // GROCER INFO
        Grocer aldi = new Grocer(0, "Aldi");
        Grocer wholeFoods = new Grocer(1, "Whole Foods");
        Grocer starMarket = new Grocer(2, "Star Market");

        ArrayList<Grocer> grocerList = new ArrayList<Grocer>();
        grocerList.add(aldi);
        grocerList.add(wholeFoods);
        grocerList.add(starMarket);

    // PROFILE INFO

    Profile p1 = new Profile(1, Cuisine.CHINESE, true, 60, Skill.ADVANCED, Restriction.DAIRY);
    Profile p2 = new Profile(2, Cuisine.ENGLISH, false, 45, Skill.BEGINNER, null);
    Profile p3 = new Profile(3, Cuisine.INDIAN, true, 30, Skill.BEGINNER, null);
    Profile p4 = new Profile(4, Cuisine.KOREAN, true, 60, Skill.INTERMEDIATE, Restriction.GLUTEN);
    Profile p5 = new Profile(5, Cuisine.MEXICAN, true, 120, Skill.PROFESSIONAL, null);


    ArrayList<Profile> profileList = new ArrayList<Profile>();
        profileList.add(p1);
            profileList.add(p2);
            profileList.add(p3);
            profileList.add(p4);
            profileList.add(p5);


            // RECIPE INFO
            Recipe sugarCookies = new Recipe(1, "Sugar Cookies", Skill.BEGINNER, 25, Restriction.GLUTEN);
            Recipe beefWellington = new Recipe(2, "Beef Wellington", Skill.PROFESSIONAL, 45, Restriction.MEAT);
            Recipe chickenAlfredo = new Recipe(3, "Chicken Alfredo", Skill.INTERMEDIATE, 20, Restriction.MEAT);
            Recipe dumplings = new Recipe(4, "Dumplings", Skill.ADVANCED, 30, Restriction.MEAT);
            Recipe curry = new Recipe(5, "Curry", Skill.INTERMEDIATE, 60, null);

            ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    recipeList.add(sugarCookies);
    recipeList.add(beefWellington);
    recipeList.add(chickenAlfredo);
    recipeList.add(dumplings);
    recipeList.add(curry);


    // SHARING INFO
    Sharing s1 = new Sharing(1, "New Recipe", "Try this recipe!", 1, 1, 2);
    Sharing s2 = new Sharing(2, "Great Recipe", "Yum! This is sooo delicious", 2, 5, 6);
    Sharing s3 = new Sharing(3, "Alfredo", "I think I am lactose intolerant", 3, 7, 9);
    Sharing s4 = new Sharing(4, null, "This recipe is soo simple. Try it sometime", 4, 6, 3);

    ArrayList<Sharing> sharingList = new ArrayList<Sharing>();
    sharingList.add(s1);
    sharingList.add(s2);
    sharingList.add(s3);
    sharingList.add(s4);


    // COMMENT INFO
    Comment c1 = new Comment(1, 4, "Is there a good substitute for vanilla extract?", 1, 2);
    Comment c2 = new Comment(2, 5, "This recipe is so simple and tastes amazing!!", 3, 4);
    Comment c3 = new Comment(3, 3, "It's a little too soupy for my taste but still tastes good", 5, 1);
    Comment c4 = new Comment(4, 5, "My children loved the dumplings I made them, thanks for the great recipe!", 4, 6);
    Comment c5 = new Comment(5, 4, "Could use a litte more flour, cookies came out a bit wet and mushy", 1, 7);

    ArrayList<Comment> commentList = new ArrayList<Comment>();
    commentList.add(c1);
    commentList.add(c2);
    commentList.add(c3);
    commentList.add(c4);
    commentList.add(c5);


    // ITEM INFO
    Item spaghetti = new Item(1, "Spaghetti", 450);
    Item sugar = new Item(2, "Sugar", 500);
    Item chickenBreast = new Item(3, "Chicken Breast", 450);
    Item garlic = new Item(4, "Garlic", 100);
    Item filetMignon = new Item(5, "Filet Mignon", 450);
    Item mushroom = new Item(6, "Mushroom", 225);
    Item pastry = new Item(7, "Pastry", 225);
    Item flour = new Item(8, "Flour", 2250);
    Item egg = new Item(9, "Egg", 300);
    Item milk = new Item(10, "Milk", 900);
    Item groundPork = new Item(11, "Ground Pork", 450);
    Item greenOnion = new Item(12, "Green Onion", 125);
    Item curryPowder = new Item(13, "Curry Powder", 100);
    Item beefStock = new Item(14, "Beef Stock", 450);

    ArrayList<Item> itemList = new ArrayList<Item>();
    itemList.add(spaghetti);
    itemList.add(sugar);
    itemList.add(chickenBreast);
    itemList.add(garlic);
    itemList.add(filetMignon);
    itemList.add(mushroom);
    itemList.add(pastry);
    itemList.add(flour);
    itemList.add(egg);
    itemList.add(milk);
    itemList.add(groundPork);
    itemList.add(greenOnion);
    itemList.add(curryPowder);
    itemList.add(beefStock);


    // COLLECTION INFO
    Collection col1 = new Collection(2,3);
    Collection col2 = new Collection(2,4);
    Collection col3 = new Collection(1,5);
    Collection col4 = new Collection(3,5);
    Collection col5 = new Collection(5,7);

    ArrayList<Collection> collectionList = new ArrayList<Collection>();
    collectionList.add(col1);
    collectionList.add(col2);
    collectionList.add(col3);
    collectionList.add(col4);
    collectionList.add(col5);


    // INGREDIENT INFO
    Ingredient cookie1 = new Ingredient(2, 1, 30);
    Ingredient cookie2 = new Ingredient(8, 1, 100);
    Ingredient cookie3 = new Ingredient(9, 1, 50);
    Ingredient cookie4 = new Ingredient(10, 1, 20);

    Ingredient beef1 = new Ingredient(4, 2, 75);
    Ingredient beef2 = new Ingredient(5, 2, 900);
    Ingredient beef3 = new Ingredient(6,2, 225);
    Ingredient beef4 = new Ingredient(10, 2, 50);
    Ingredient beef5 = new Ingredient(14, 2, 100);

    Ingredient alfredo1 = new Ingredient(1, 3, 100);
    Ingredient alfredo2 = new Ingredient(3, 3, 120);
    Ingredient alfredo3 = new Ingredient(4, 3, 20);
    Ingredient alfredo4 = new Ingredient(6, 3, 50);

    Ingredient dumplings1 = new Ingredient(4, 4, 20);
    Ingredient dumplings2 = new Ingredient(7, 4, 550);
    Ingredient dumplings3 = new Ingredient(9, 4, 50);
    Ingredient dumplings4 = new Ingredient(11, 4, 800);
    Ingredient dumplings5 = new Ingredient(12, 4, 250);

    Ingredient curry1 = new Ingredient(3, 5, 450);
    Ingredient curry2 = new Ingredient(4, 5, 20);
    Ingredient curry3 = new Ingredient(12, 5, 100);
    Ingredient curry4 = new Ingredient(13, 5, 50);

    ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
    ingredientList.add(cookie1);
    ingredientList.add(cookie2);
    ingredientList.add(cookie3);
    ingredientList.add(cookie4);
    ingredientList.add(beef1);
    ingredientList.add(beef2);
    ingredientList.add(beef3);
    ingredientList.add(beef4);
    ingredientList.add(beef5);
    ingredientList.add(alfredo1);
    ingredientList.add(alfredo2);
    ingredientList.add(alfredo3);
    ingredientList.add(alfredo4);
    ingredientList.add(dumplings1);
    ingredientList.add(dumplings2);
    ingredientList.add(dumplings3);
    ingredientList.add(dumplings4);
    ingredientList.add(dumplings5);
    ingredientList.add(curry1);
    ingredientList.add(curry2);
    ingredientList.add(curry3);
    ingredientList.add(curry4);



    // STOCK INFO

    Stock stock1 = new Stock(1, 0, 1.19);
    Stock stock2 = new Stock(1, 1, 1.79);
    Stock stock3 = new Stock(1, 2, 1.19);
    Stock stock4 = new Stock(2, 0, 8.99);
    Stock stock5 = new Stock(2, 1, 10.49);
    Stock stock6 = new Stock(2, 2, 9.99);
    Stock stock7 = new Stock(3, 0, 4.29);
    Stock stock8 = new Stock(3, 1, 5.49);
    Stock stock9 = new Stock(3, 2, 4.29);
    Stock stock10 = new Stock(4, 0, 0.69);
    Stock stock11 = new Stock(4, 1, 1.59);
    Stock stock12 = new Stock(4, 2, 0.79);
    Stock stock13 = new Stock(5, 0, 18.49);
    Stock stock14 = new Stock(5, 1, 27.29);
    Stock stock15 = new Stock(5, 2, 24.79);
    Stock stock16 = new Stock(6, 0, 3.49);
    Stock stock17 = new Stock(6, 1, 4.29);
    Stock stock18 = new Stock(6, 2, 3.29);
    Stock stock19 = new Stock(7, 0, 4.49);
    Stock stock20 = new Stock(7, 1, 4.29);
    Stock stock21 = new Stock(7, 2, 4.79);
    Stock stock22 = new Stock(8, 0, 2.99);
    Stock stock23 = new Stock(8, 1, 3.99);
    Stock stock24 = new Stock(8, 2, 3.79);
    Stock stock25 = new Stock(9, 0, 1.49);
    Stock stock26 = new Stock(9, 1, 1.49);
    Stock stock27 = new Stock(9, 2, 1.99);
    Stock stock28 = new Stock(10, 0, 4.99);
    Stock stock29 = new Stock(10, 1, 4.99);
    Stock stock30 = new Stock(10, 2, 4.79);
    Stock stock31 = new Stock(11, 0, 5.49);
    Stock stock32 = new Stock(11, 1, 6.99);
    Stock stock33 = new Stock(11, 2, 5.99);
    Stock stock34 = new Stock(12, 0, 2.49);
    Stock stock35 = new Stock(12, 1, 2.49);
    Stock stock36 = new Stock(12, 2, 2.79);
    Stock stock37 = new Stock(13, 0, 1.49);
    Stock stock38 = new Stock(13, 1, 1.29);
    Stock stock39 = new Stock(13, 2, 1.79);
    Stock stock40 = new Stock(14, 0, 3.49);
    Stock stock41 = new Stock(14, 1, 4.29);
    Stock stock42 = new Stock(14, 2, 3.79);

    ArrayList<Stock> stockList = new ArrayList<>(Arrays.asList(
    stock1, stock2, stock3, stock4, stock5, stock6, stock7, stock8, stock9, stock10,
    stock11, stock12, stock13, stock14, stock15, stock16, stock17, stock18, stock19,
    stock20, stock21, stock22, stock23, stock24, stock25, stock26, stock27, stock28,
    stock29, stock30, stock31, stock32, stock33, stock34, stock35, stock36, stock37,
    stock38, stock39, stock40, stock41, stock42
    ));


    // ANYRES INFO

    AnyRes anyres1 = new AnyRes(1, 1);
    AnyRes anyres2 = new AnyRes(2, 2);
    AnyRes anyres3 = new AnyRes(3, 3);
    AnyRes anyres4 = new AnyRes(4, 4);
    AnyRes anyres5 = new AnyRes(5, 5);

    ArrayList<AnyRes> anyResList = new ArrayList<>(Arrays.asList(
    anyres1, anyres2, anyres3, anyres4, anyres5
    ));

    // FILTER INFO

    Filter filter1 = new Filter(1, 4);
    Filter filter2 = new Filter(1, 5);
    Filter filter3 = new Filter(3, 5);
    Filter filter4 = new Filter(2, 1);
    Filter filter5 = new Filter(5, 2);

    ArrayList<Filter> filterList = new ArrayList<>(Arrays.asList(
    filter1, filter2, filter3, filter4, filter5
    ));
 */