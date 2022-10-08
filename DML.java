package Database_Proj;

import java.util.ArrayList;
import java.util.Arrays;

public class DML {

    public static void insertGrocers(MySQL mySQL) {
        Grocer aldi = new Grocer(0, "Aldi");
        Grocer wholeFoods = new Grocer(1, "Whole Foods");
        Grocer starMarket = new Grocer(2, "Star Market");

        ArrayList<Grocer> grocerList = new ArrayList<Grocer>();
        grocerList.add(aldi);
        grocerList.add(wholeFoods);
        grocerList.add(starMarket);

        for (Grocer grocer : grocerList) {
            mySQL.insertGrocer(grocer);
        }
    }

    public static void insertUsers(MySQL mySQL) {
        User johnDoe = new User(1, "John Doe", Sex.MALE, 20, "1111111111", "johndoe@gmail.com", "1 Huntington Ave Boston, MA 02115", 1);
        User georgeMadden = new User(2, "George Madden", Sex.MALE, 20, "2222222222", "georgemadden@gmail.com", "2 Huntington Ave Boston, MA 02115", 1);
        User louisSaint = new User(3, "Louis Saint", Sex.OTHER, 20, "3333333333", "louissaint@gmail.com", "3 Huntington Ave Boston, MA 02115", 1);
        User maryJay = new User(4, "Mary Jay", Sex.FEMALE, 20, "4444444444", "maryjay@gmail.com", "4 Huntington Ave Boston, MA 02115", 1);
        User bobSmith = new User(5, "Bob Smith", Sex.MALE, 20, "5555555555", "bobsmith@gmail.com", "5 Huntington Ave Boston, MA 02115", 0);
        User jennyLi = new User(6, "Jenny Li", Sex.FEMALE, 20, "6666666666", "jennyli@gmail.com", "6 Huntington Ave Boston, MA 02115", 0);
        User silviaMunn = new User(7, "Silvia Munn", Sex.FEMALE, 20, "7777777777", "silviamunn@gmail.com", "7 Huntington Ave Boston, MA 02115", 0);
        User howardPotts = new User(8, "Howard Potts", Sex.OTHER, 20, "8888888888", "howardpotts@gmail.com", "8 Huntington Ave Boston, MA 02115", 2);
        User annMarie = new User(9, "Ann Marie", Sex.MALE, 20, "9999999999", "annmarie@gmail.com", "9 Huntington Ave Boston, MA 02115", 2);

        ArrayList<User> userList = new ArrayList<User>(Arrays.asList(johnDoe, georgeMadden,
            louisSaint, maryJay, bobSmith, jennyLi, silviaMunn, howardPotts, annMarie));

        for (User user : userList) {
            mySQL.insertUser(user);
        }
    }

    public static void insertRecipes(MySQL mySQL) {
        Recipe sugarCookies = new Recipe(1, "Sugar Cookies", Skill.BEGINNER, 25, Restriction.GLUTEN);
        Recipe beefWellington = new Recipe(2, "Beef Wellington", Skill.PROFESSIONAL, 45, Restriction.MEAT);
        Recipe chickenAlfredo = new Recipe(3, "Chicken Alfredo", Skill.INTERMEDIATE, 20, Restriction.MEAT);
        Recipe dumplings = new Recipe(4, "Dumplings", Skill.ADVANCED, 30, Restriction.MEAT);
        Recipe curry = new Recipe(5, "Curry", Skill.INTERMEDIATE, 60, null);

        ArrayList<Recipe> recipeList = new ArrayList<Recipe>(Arrays.asList(sugarCookies, beefWellington,
            chickenAlfredo, dumplings, curry));

        for (Recipe recipe : recipeList) {
            mySQL.insertRecipe(recipe);
        }
    }

    public static void insertSharings(MySQL mySQL) {
        Sharing s1 = new Sharing(1, "New Recipe", "Try this recipe!", 1, 1, 2);
        Sharing s2 = new Sharing(2, "Great Recipe", "Yum! This is sooo delicious", 2, 5, 6);
        Sharing s3 = new Sharing(3, "Alfredo", "I think I am lactose intolerant", 3, 7, 9);
        Sharing s4 = new Sharing(4, null, "This recipe is soo simple. Try it sometime", 4, 6, 3);

        ArrayList<Sharing> sharingList = new ArrayList<Sharing>(Arrays.asList(s1, s2, s3, s4));

        for (Sharing sharing : sharingList) {
            mySQL.insertSharing(sharing);
        }
    }

    public static void insertComments(MySQL mySQL) {
        Comment c1 = new Comment(1, 4, "Is there a good substitute for vanilla extract?", 1, 2);
        Comment c2 = new Comment(2, 5, "This recipe is so simple and tastes amazing!!", 3, 4);
        Comment c3 = new Comment(3, 3, "It's a little too soupy for my taste but still tastes good", 5, 1);
        Comment c4 = new Comment(4, 5, "My children loved the dumplings I made them, thanks for the great recipe!", 4, 6);
        Comment c5 = new Comment(5, 4, "Could use a litte more flour, cookies came out a bit wet and mushy", 1, 7);

        ArrayList<Comment> commentList = new ArrayList<Comment>(Arrays.asList(c1, c2, c3, c4, c5));

        for (Comment comment : commentList) {
            mySQL.insertComment(comment);
        }
    }

    public static void insertItems(MySQL mySQL) {
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

        ArrayList<Item> itemList = new ArrayList<Item>(Arrays.asList(spaghetti, sugar, chickenBreast,
            garlic, filetMignon, mushroom, pastry, flour, egg, milk, groundPork, greenOnion, curryPowder, beefStock));

        for (Item item : itemList) {
            mySQL.insertItem(item);
        }
    }

    public static void insertProfiles(MySQL mySQL) {
        Profile p1 = new Profile(1, Cuisine.CHINESE, true, 60, Skill.ADVANCED, Restriction.DAIRY);
        Profile p2 = new Profile(2, Cuisine.ENGLISH, false, 45, Skill.BEGINNER, null);
        Profile p3 = new Profile(3, Cuisine.INDIAN, true, 30, Skill.BEGINNER, null);
        Profile p4 = new Profile(4, Cuisine.KOREAN, true, 60, Skill.INTERMEDIATE, Restriction.GLUTEN);
        Profile p5 = new Profile(5, Cuisine.MEXICAN, true, 120, Skill.PROFESSIONAL, null);

        ArrayList<Profile> profileList = new ArrayList<Profile>(Arrays.asList(p1, p2, p3, p4, p5));

        for (Profile profile : profileList) {
            mySQL.insertProfile(profile);
        }
    }

    public static void insertCollections(MySQL mySQL) {
        Collection col1 = new Collection(2,3);
        Collection col2 = new Collection(2,4);
        Collection col3 = new Collection(1,5);
        Collection col4 = new Collection(3,5);
        Collection col5 = new Collection(5,7);

        ArrayList<Collection> collectionList = new ArrayList<Collection>(Arrays.asList(col1, col2, col3, col4,
            col5));

        for (Collection collection : collectionList) {
            mySQL.insertCollection(collection);
        }
    }

    public static void insertAnyRes(MySQL mySQL) {
        AnyRes anyres1 = new AnyRes(1, 1);
        AnyRes anyres2 = new AnyRes(2, 2);
        AnyRes anyres3 = new AnyRes(3, 3);
        AnyRes anyres4 = new AnyRes(4, 4);
        AnyRes anyres5 = new AnyRes(5, 5);

        ArrayList<AnyRes> anyResList = new ArrayList<>(Arrays.asList(
            anyres1, anyres2, anyres3, anyres4, anyres5
        ));

        for (AnyRes anyRes : anyResList) {
            mySQL.insertAnyRes(anyRes);
        }
    }

    public static void insertStocks(MySQL mySQL) {
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

        for (Stock stock : stockList) {
            mySQL.insertStock(stock);
        }
    }

    public static void insertIngredients(MySQL mySQL) {
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

        for (Ingredient ingredient : ingredientList) {
            mySQL.insertIngredient(ingredient);
        }
    }

    public static void insertFilters(MySQL mySQL) {
        Filter filter1 = new Filter(1, 4);
        Filter filter2 = new Filter(1, 5);
        Filter filter3 = new Filter(3, 5);
        Filter filter4 = new Filter(2, 1);
        Filter filter5 = new Filter(5, 2);

        ArrayList<Filter> filterList = new ArrayList<>(Arrays.asList(
            filter1, filter2, filter3, filter4, filter5
        ));

        for (Filter filter : filterList) {
            mySQL.insertFilter(filter);
        }
    }


    public static void populateDatabase(MySQL mySQL) {
        insertGrocers(mySQL);
        insertUsers(mySQL);
        insertRecipes(mySQL);
        insertSharings(mySQL);
        insertComments(mySQL);
        insertItems(mySQL);
        insertProfiles(mySQL);
        insertCollections(mySQL);
        insertAnyRes(mySQL);
        insertStocks(mySQL);
        insertIngredients(mySQL);
        insertFilters(mySQL);
    }


}
