package tv_store.model;

import java.util.Date;

public class Order {
	private int id;
    private Date orderDate;
    private String shippingInformation;
    private String orderStatus;

    public Order() {
    }

    public Order(int id, Date orderDate, String shippingInformation, String orderStatus) {
        this.id = id;
        this.orderDate = orderDate;
        this.shippingInformation = shippingInformation;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(String shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", shippingInformation='" + shippingInformation + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
