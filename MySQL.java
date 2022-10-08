package Database_Proj;

import com.google.protobuf.Any;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MySQL {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    Connection connection = null;
    PreparedStatement statement = null;

    Integer status = -1;

    // Connects to DB
    public void connect(String host, String schema, String user, String pass, String config) {
        String DB_URL = "jdbc:mysql://" + host + "/" + schema + "?" + config;
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, user, pass);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // closes connection and prepared statement
    public void close() {
        try {
            if (connection != null) {
                connection.close();
                connection = null; // don't forget to set it back to null or you can't do multiple operations
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // execute a general statement
    public void execute(String sql_statement) {
        try {
            statement = connection.prepareStatement(sql_statement);
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final String INSERT_GROCER = "INSERT INTO grocer VALUES (?, ?);";

    public final String INSERT_USER = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    public final String INSERT_RECIPE = "INSERT INTO recipe VALUES (?, ?, ?, ?, ?);";

    public final String INSERT_SHARING = "INSERT INTO sharing VALUES (?, ?, ?, ?, ?, ?);";

    public final String INSERT_COMMENT = "INSERT INTO comment VALUES (?, ?, ?, ?, ?);";

    public final String INSERT_ITEM = "INSERT INTO item VALUES (?, ?, ?);";

    public final String INSERT_PROFILE = "INSERT INTO profile VALUES (?, ?, ?, ?, ?, ?);";

    public final String INSERT_COLLECTION = "INSERT INTO collection VALUES (?, ?);";

    public final String INSERT_ANY_RES = "INSERT INTO any_res VALUES (?, ?);";

    public final String INSERT_STOCK = "INSERT INTO stock VALUES (?, ?, ?);";

    public final String INSERT_INGREDIENT = "INSERT INTO ingredient VALUES (?, ?, ?);";

    public final String INSERT_FILTER = "INSERT INTO filter VALUES (?, ?);";


    public void insertGrocer(Grocer grocer) {
        try {
            statement = connection.prepareStatement(INSERT_GROCER);
            statement.setInt(1, grocer.getId());
            statement.setString(2, grocer.getName());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User user) {
        try {
            statement = connection.prepareStatement(INSERT_USER);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getSex().name());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getAddress());
            statement.setInt(8, user.getGrocer_id());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRecipe(Recipe recipe) {
        try {
            statement = connection.prepareStatement(INSERT_RECIPE);
            statement.setInt(1, recipe.getId());
            statement.setString(2, recipe.getName());
            statement.setString(3, recipe.getSkill().name());
            statement.setInt(4, recipe.getTime_min());
            if (recipe.getRestriction() == null) {
                statement.setNull(5, 12);
            }
            else {
                statement.setString(5, recipe.getRestriction().name());
            }
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSharing(Sharing sharing) {
        try {
            statement = connection.prepareStatement(INSERT_SHARING);
            statement.setInt(1, sharing.getId());
            statement.setString(2, sharing.getSubject());
            statement.setString(3, sharing.getText());
            statement.setInt(4, sharing.getRecipe());
            statement.setInt(5, sharing.getUser_id());
            statement.setInt(6, sharing.getUser_id1());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertComment(Comment comment) {
        try {
            statement = connection.prepareStatement(INSERT_COMMENT);
            statement.setInt(1, comment.getId());
            statement.setInt(2, comment.getRating());
            statement.setString(3, comment.getText());
            statement.setInt(4, comment.getRecipe_id());
            statement.setInt(5, comment.getUser_id());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertItem(Item item) {
        try {
            statement = connection.prepareStatement(INSERT_ITEM);
            statement.setInt(1, item.getId());
            statement.setString(2, item.getName());
            statement.setInt(3, item.getQuantity());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProfile(Profile profile) {
        try {
            statement = connection.prepareStatement(INSERT_PROFILE);
            statement.setInt(1, profile.getId());
            if (profile.getCuisine() == null) {
                statement.setNull(2, 12);
            }
            else {
                statement.setString(2, profile.getCuisine().name());
            }
            statement.setBoolean(3, profile.getSpicy()); // test null boolean?
            statement.setInt(4, profile.getTime()); // test null int?
            if (profile.getSkill() == null) {
                statement.setNull(5, 12);
            }
            else {
                statement.setString(5, profile.getSkill().name());
            }
            if (profile.getRestriction() == null) {
                statement.setNull(6, 12);
            }
            else {
                statement.setString(6, profile.getRestriction().name());
            }
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCollection(Collection collection) {
        try {
            statement = connection.prepareStatement(INSERT_COLLECTION);
            statement.setInt(1, collection.getRecipe_id());
            statement.setInt(2, collection.getUser_id());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAnyRes(AnyRes anyRes) {
        try {
            statement = connection.prepareStatement(INSERT_ANY_RES);
            statement.setInt(1, anyRes.getUser_id());
            statement.setInt(2, anyRes.getProfile_id());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStock(Stock stock) {
        try {
            statement = connection.prepareStatement(INSERT_STOCK);
            statement.setInt(1, stock.getItem_id());
            statement.setInt(2, stock.getGrocer_id());
            statement.setDouble(3, stock.getCost());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIngredient(Ingredient ingredient) {
        try {
            statement = connection.prepareStatement(INSERT_INGREDIENT);
            statement.setInt(1, ingredient.getItem_id());
            statement.setInt(2, ingredient.getRecipe_id());
            statement.setInt(3, ingredient.getAmt());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertFilter(Filter filter) {
        try {
            statement = connection.prepareStatement(INSERT_FILTER);
            statement.setInt(1, filter.getProfile_id());
            statement.setInt(2, filter.getRecipe_id());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    // public void query(String sql_statement) {
    // try {
    // statement = connection.prepareStatement(sql_statement);
    // ResultSet resultSet = statement.executeQuery();
    // System.out.println(resultSet);

    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // }

    public void displayUser() {
        try {
            statement = connection.prepareStatement(
                "select user_name, user_phone, user_address, grocer_name from user join grocer using(grocer_id)");
            ResultSet resultSet = statement.executeQuery();
            //System.out.println(resultSet);

            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("user_name"));
                System.out.println("Phone: " + resultSet.getString("user_phone"));
                System.out.println("Address: " + resultSet.getString("user_address"));
                System.out.println("Grocer: " + resultSet.getString("grocer_name") + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}