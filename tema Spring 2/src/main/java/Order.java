public class Order implements Cloneable {
    private int id;
    private String orderDate;
    private String shippedDate;
    private String status;
    private String comments;
    private int customerId;

    @Override
    public Object clone()throws CloneNotSupportedException{
        return (Order)super.clone();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate='" + orderDate + '\'' +
                ", shippedDate='" + shippedDate + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", customerId=" + customerId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Order() {
    }

    public Order(int id, String orderDate, String shippedDate, String status, String comments, int customerId) {
        this.id = id;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerId = customerId;
    }

    public Order(String orderDate, String shippedDate, String status, String comments, int customerId) {
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerId = customerId;
    }
}
