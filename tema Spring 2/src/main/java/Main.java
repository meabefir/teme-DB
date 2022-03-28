import java.sql.*;
import java.util.ArrayList;

public class Main {

    static Connection connection = null;
    static String databaseName = "plswork";
    static String url = "jdbc:mysql://localhost:3306/" + databaseName;

    static String username = "root";
    static String password = "root";

    static {
        try {
            connection = DriverManager.getConnection(url,
                    username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, CloneNotSupportedException {
        System.out.println("by id");
        Customer byId = getById(0);
        System.out.println(byId);

        System.out.println("all");
        for (Customer c: getAll()) {
            System.out.println(c);
        }

        System.out.println("update by id");
        Customer toUpdate = getById(0);
        if (toUpdate != null) {
            Customer updated = (Customer) toUpdate.clone();
            updated.setUsername("meabefirus");
            updated.setAddress("hakuna matatata");
            update(toUpdate.getID(), updated);
        }

        Customer toInsert = new Customer(2, "lucifer", "lucius", "maximus", "07213123123", "hell", "idk", "666", "hellium");
        insert(toInsert);

        delete(2);
    }

    public static Customer getById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from customers where id=?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Customer customer = new Customer();
            customer.setID(rs.getInt("id"));
            customer.setUsername(rs.getString("username"));
            customer.setLastName(rs.getString("last_name"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setPhone(rs.getString("phone"));
            customer.setAddress(rs.getString("address"));
            customer.setCity(rs.getString("city"));
            customer.setPostalCode(rs.getString("postal_code"));
            customer.setCountry(rs.getString("country"));
            return customer;
        }
        return null;
    }

    public static ArrayList<Customer> getAll() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from customers;");
        ResultSet rs = ps.executeQuery();
        ArrayList<Customer> customers = new ArrayList<>();
        while (rs.next()) {
            System.out.println(rs.getString("username"));
            Customer customer = new Customer();
            customer.setID(rs.getInt("id"));
            customer.setUsername(rs.getString("username"));
            customer.setLastName(rs.getString("last_name"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setPhone(rs.getString("phone"));
            customer.setAddress(rs.getString("address"));
            customer.setCity(rs.getString("city"));
            customer.setPostalCode(rs.getString("postal_code"));
            customer.setCountry(rs.getString("country"));
            customers.add(customer);
        }
        return customers;
    }

    public static void update(int id, Customer newData) throws SQLException {
        Customer toModify = getById(id);
        if (toModify == null) return;

        PreparedStatement ps = connection.prepareStatement("update customers set id=?, username=?, last_name=?," +
                " first_name=?, phone=?, address=?, city=?, postal_code=?, country=? where id=?;");
        ps.setInt(1, newData.getID());
        ps.setString(2, newData.getUsername());
        ps.setString(3, newData.getLastName());
        ps.setString(4, newData.getFirstName());
        ps.setString(5, newData.getPhone());
        ps.setString(6, newData.getAddress());
        ps.setString(7, newData.getCity());
        ps.setString(8, newData.getPostalCode());
        ps.setString(9, newData.getCountry());
        ps.setInt(10, id);

        ps.execute();
    }

    public static void insert(Customer customer) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into customers values (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        ps.setInt(1, customer.getID());
        ps.setString(2, customer.getUsername());
        ps.setString(3, customer.getLastName());
        ps.setString(4, customer.getFirstName());
        ps.setString(5, customer.getPhone());
        ps.setString(6, customer.getAddress());
        ps.setString(7, customer.getCity());
        ps.setString(8, customer.getPostalCode());
        ps.setString(9, customer.getCountry());
        ps.execute();
    }

    public static void delete(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete from customers where id=?;");
        ps.setInt(1, id);
        ps.execute();
    }
}

