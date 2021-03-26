import org.sqlite.SQLiteException;

import java.sql.*;


public class Main {
    private  Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Users/alexm/Desktop/ComputerClasses/Comp3700/Assignments/Assignment9/data/Store.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection Successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public String selectExample(String tableName)  {
        String sql = "Select * From ";
        sql = sql + tableName;

        StringBuilder sb = new StringBuilder();
        try (Connection connection = this.connect()){


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ResultSetMetaData md = resultSet.getMetaData();
            int columnCount = md.getColumnCount();

            for (int i=1; i<columnCount; i++) {
                sb.append(md.getColumnName(i) + ", ");
            }
                sb.append("\n");
            // loop through the result set
            while (resultSet.next()) {
               // System.out.println(resultSet.getString("ProductID") + ", " + resultSet.getString("Name"));
                for (int i = 1; i<=columnCount; i++) {
                    sb.append(resultSet.getString(i) + ", ");
                }
                sb.append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }
}
