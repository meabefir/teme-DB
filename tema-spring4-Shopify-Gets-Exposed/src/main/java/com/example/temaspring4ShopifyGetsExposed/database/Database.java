package com.example.temaspring4ShopifyGetsExposed.database;

import com.example.temaspring4ShopifyGetsExposed.model.Customer;
import com.example.temaspring4ShopifyGetsExposed.model.Order;
import com.example.temaspring4ShopifyGetsExposed.model.OrderDetails;

import java.sql.*;
import java.util.ArrayList;

public class Database {

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
//        System.out.println("by id");
//        Customer byId = getCustomerById(0);
//        System.out.println(byId);
//
//        System.out.println("all");
//        for (Customer c: getAllCustomers()) {
//            System.out.println(c);
//        }
//
//        System.out.println("update by id");
//        Customer toUpdate = getCustomerById(0);
//        if (toUpdate != null) {
//            Customer updated = (Customer) toUpdate.clone();
//            updated.setUsername("meabefirus");
//            updated.setAddress("hakuna matatata");
//            updateCustomer(toUpdate.getID(), updated);
//        }
//
//        Customer toInsert = new Customer("lucifer", "lucius", "maximus", "07213123123", "hell", "idk", "666", "hellium");
//        insertCustomer(toInsert);
//
//        deleteCustomerByUsername("lucifer");
//
//        Order newOrder = new Order("2022-03-20", "2022-03-22", "shipp", "pasta", 1);
//        OrderDetails newOrderDetails = new OrderDetails(3, 8.2, "pro1");
//        addOrder(0, newOrder, newOrderDetails);
//
//        viewAllOrders(0);
//
//        updateOrderStatus(1, "new status");
//
//        addCommentsToOrder(1, "new very long and boring commenttttttttttttt");
    }

    public static Customer getCustomerById(int id) throws SQLException {
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

    public static Order getOrderById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from orders where id=?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setOrderDate(rs.getString("order_date"));
            order.setShippedDate(rs.getString("shipped_date"));
            order.setStatus(rs.getString("status"));
            order.setComments(rs.getString("commets"));
            order.setCustomerId(rs.getInt("customer_id"));
            return order;
        }
        return null;
    }

    public static ArrayList<Customer> getAllCustomers() throws SQLException {
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

    public static ArrayList<Order> getAllOrders() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from orders;");
        ResultSet rs = ps.executeQuery();
        ArrayList<Order> orders = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setOrderDate(rs.getString("order_date"));
            order.setShippedDate(rs.getString("shipped_date"));
            order.setStatus(rs.getString("status"));
            order.setComments(rs.getString("comments"));
            order.setCustomerId(rs.getInt("customer_id"));
            orders.add(order);
        }
        return orders;
    }

    public static ArrayList<Order> getOrdersWithCustomerId(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from orders where customer_id=?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        ArrayList<Order> orders = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setOrderDate(rs.getString("order_date"));
            order.setShippedDate(rs.getString("shipped_date"));
            order.setStatus(rs.getString("status"));
            order.setComments(rs.getString("comments"));
            order.setCustomerId(rs.getInt("customer_id"));
            orders.add(order);
        }
        return orders;
    }

    public static Customer updateCustomer(Customer newData) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("update customers set username=?, last_name=?," +
                " first_name=?, phone=?, address=?, city=?, postal_code=?, country=? where id=?;", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, newData.getUsername());
        ps.setString(2, newData.getLastName());
        ps.setString(3, newData.getFirstName());
        ps.setString(4, newData.getPhone());
        ps.setString(5, newData.getAddress());
        ps.setString(6, newData.getCity());
        ps.setString(7, newData.getPostalCode());
        ps.setString(8, newData.getCountry());
        ps.setInt(9, newData.getID());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("creating order failed, no rows affected.");
        }
        return getCustomerById(newData.getID());
    }

    public static Order updateOrder(Order newData) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("update orders set order_date=?, shipped_date=?," +
                " status=?, comments=?, customer_id=? where id=?;", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, newData.getOrderDate());
        ps.setString(2, newData.getShippedDate());
        ps.setString(3, newData.getStatus());
        ps.setString(4, newData.getComments());
        ps.setInt(5, newData.getCustomerId());
        ps.setInt(6, newData.getId());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("creating order failed, no rows affected.");
        }
        return getOrderById(newData.getId());
    }

    public static Customer insertCustomer(Customer customer) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into customers (username, last_name, first_name, phone, address, city, postal_code, country)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, customer.getUsername());
        ps.setString(2, customer.getLastName());
        ps.setString(3, customer.getFirstName());
        ps.setString(4, customer.getPhone());
        ps.setString(5, customer.getAddress());
        ps.setString(6, customer.getCity());
        ps.setString(7, customer.getPostalCode());
        ps.setString(8, customer.getCountry());

        int affectedRows = ps.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("creating order failed, no rows affected.");
        }

        Integer newCustomerId = null;
        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                newCustomerId = generatedKeys.getInt(1);
                return getCustomerById(newCustomerId);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
    }

    public static Order insertOrder(Order order) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into orders (order_date, shipped_date, status, comments, customer_id)" +
                " values (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, order.getOrderDate());
        ps.setString(2, order.getShippedDate());
        ps.setString(3, order.getStatus());
        ps.setString(4, order.getComments());
        ps.setInt(5, order.getCustomerId());

        int affectedRows = ps.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("creating order failed, no rows affected.");
        }

        Integer newOrderId = null;
        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                newOrderId = generatedKeys.getInt(1);
                return getOrderById(newOrderId);
            }
            else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }
        }
    }

    public static void deleteCustomerByUsername(String username) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete from customers where username=?;");
        ps.setString(1, username);
        ps.execute();
    }

    public static boolean deleteCustomerById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete from customers where id=?;");
        ps.setInt(1, id);

        int affectedRows = ps.executeUpdate();
        return affectedRows != 0;
    }

    public static boolean deleteOrderById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete from orders where id=?;");
        ps.setInt(1, id);

        int affectedRows = ps.executeUpdate();
        return affectedRows != 0;
    }

    public static void addOrder(int id, Order order, OrderDetails orderDetails) throws SQLException {
//        check if product code exists
        PreparedStatement ps = connection.prepareStatement("select * from products where code=?;");
        ps.setString(1, orderDetails.getProductCode());
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            System.out.println("product with code " + orderDetails.getProductCode() + " does not exist");
            return;
        }
//        check if enough stock
        int inStock = rs.getInt("stock");
        if (inStock < orderDetails.getQuantity()) {
            System.out.println("not enough of " + orderDetails.getProductCode() + " in stock!");
            return;
        }
//        update the product
        ps = connection.prepareStatement("update products set stock=? where code=?;");
        ps.setInt(1, rs.getInt("stock") - orderDetails.getQuantity());
        ps.setString(2, orderDetails.getProductCode());
        ps.execute();

//        add order and orderDetails
//        order
        ps = connection.prepareStatement("insert into orders (order_date, shipped_date, status, comments, customer_id)" +
                " values (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, order.getOrderDate());
        ps.setString(2, order.getShippedDate());
        ps.setString(3, order.getStatus());
        ps.setString(4, order.getComments());
        ps.setInt(5, order.getCustomerId());
        int affectedRows = ps.executeUpdate();

//        get order in order to send id to orderDetails
        if (affectedRows == 0) {
            throw new SQLException("creating order failed, no rows affected.");
        }

        Integer newOrderId = null;
        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                newOrderId = generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

//        orderDetails
        ps = connection.prepareStatement("insert into orderdetails (quantity, price_each, order_id, product_code) values (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, orderDetails.getQuantity());
        ps.setDouble(2, orderDetails.getPriceEach());
        ps.setInt(3, newOrderId);
        ps.setString(4, orderDetails.getProductCode());
        affectedRows = ps.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("creating orderDetails failed, no rows affected.");
        }
    }



    public static void viewAllOrders(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from orders where customer_id=?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        System.out.println("all orders of customer with id " + id);
        while (rs.next()) {
            Order thisOrder = new Order();
            thisOrder.setId(rs.getInt("id"));
            thisOrder.setOrderDate(rs.getString("order_date"));
            thisOrder.setShippedDate(rs.getString("shipped_date"));
            thisOrder.setStatus(rs.getString("status"));
            thisOrder.setComments(rs.getString("comments"));
            thisOrder.setCustomerId(rs.getInt("customer_id"));

            System.out.println(thisOrder);
        }
    }

    public static void updateOrderStatus(int id, String newStatus) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("update orders set status=? where id=?;");
        ps.setString(1, newStatus);
        ps.setInt(2, id);
        ps.execute();
    }

    public static void addCommentsToOrder(int id, String newComments) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("update orders set comments=? where id=?;");
        ps.setString(1, newComments);
        ps.setInt(2, id);
        ps.execute();
    }

    public static ArrayList<OrderDetails> getOrderDetailsWithOrderId(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from orderdetails where order_id=?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        ArrayList<OrderDetails> ordersDetails = new ArrayList<>();
        while (rs.next()) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setId(rs.getInt("id"));
            orderDetails.setQuantity(rs.getInt("quantity"));
            orderDetails.setPriceEach(rs.getDouble("price_each"));
            orderDetails.setOrderId(rs.getInt("order_id"));
            orderDetails.setProductCode(rs.getString("product_code"));
            ordersDetails.add(orderDetails);
        }
        return ordersDetails;
    }
}

