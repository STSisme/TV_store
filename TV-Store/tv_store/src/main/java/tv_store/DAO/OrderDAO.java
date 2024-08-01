package tv_store.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tv_store.model.Order;
import tv_store.utils.DatabaseUtil;

public class OrderDAO {
	private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";

    public static List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date orderDate = resultSet.getDate("order_date");
                String shippingInformation = resultSet.getString("shipping_information");
                String orderStatus = resultSet.getString("order_status");
                
                Order order = new Order(id, orderDate, shippingInformation, orderStatus);
                orders.add(order);
            }
            
            DatabaseUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

}
