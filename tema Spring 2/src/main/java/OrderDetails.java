public class OrderDetails implements Cloneable {
    private int quantity;
    private double priceEach;
    private String productCode;

    @Override
    public Object clone()throws CloneNotSupportedException{
        return (OrderDetails)super.clone();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "quantity=" + quantity +
                ", priceEach=" + priceEach +
                ", productCode='" + productCode + '\'' +
                '}';
    }

    public OrderDetails() {
    }

    public OrderDetails(int quantity, double priceEach, String productCode) {
        this.quantity = quantity;
        this.priceEach = priceEach;
        this.productCode = productCode;
    }
}
