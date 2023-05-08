import java.time.LocalDate;

class Product {
  private String description;
  private String productID;
  private double price;
  public Product() {}
  public Product(String id, String desc, double price) {
    this.productID = id;
    this.description = desc;
    this.price = price;
  }
  public double calcTotalPrice(int quantity) {
    return this.price * quantity;
  }
  public String toString() {
    return String.format("[%s] %s: $%.2f", productID, description, price);
  }
  public String getDescription() {
    return description;
  }
  public String getProductID() {
    return productID;
  }
  public double getPrice() {
    return price;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setProductID(String productID) {
    this.productID = productID;
  }
  public void setPrice(double price) {
    this.price = price;
  }
}

class Order {
  private int orderID;
  private LocalDate orderDate;
  private OrderDetail[] lineItems;
  private int count;
  public Order(int orderID, LocalDate orderDate) {
    this.orderID = orderID;
    this.orderDate = orderDate;
    this.lineItems = new OrderDetail[20];
    this.count = 0;
  }
  public int getOrderID() {
    return orderID;
  }
  public LocalDate getOrderDate() {
    return orderDate;
  }
  public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
  }
  public OrderDetail[] getLineItems() {
    return lineItems;
  }
  public void addLineItem(Product p, int quantity) {
    lineItems[count++] = new OrderDetail(p, quantity);
  }
  public double calcTotalCharge() {
    double total = 0;
    for (int i = 0; i < count; i++) {
      total += lineItems[i].calcTotalPrice();
    }
    return total;
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Order ").append(orderID).append(" (").append(orderDate).append("):\n");
    for (int i = 0; i < count; i++) {
      sb.append("\t").append(lineItems[i]).append("\n");
    }
    sb.append("Total charge: ").append(calcTotalCharge());
    return sb.toString();
  }
}

class OrderDetail {
  private Product product;
  private int quantity;
  public OrderDetail(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }
  public double calcTotalPrice() {
    return product.calcTotalPrice(quantity);
  }
  public String toString() {
    return String.format("%s x %d = $%.2f", product, quantity, calcTotalPrice());
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}

 class thuchanh3 {
  public static void main(String[] args) {
    Product p1 = new Product("sp4", "Nuoc tuong", 8000);
    Product p2 = new Product("sp1", "Gao", 18000);
    Product p3 = new Product("sp3", "Duong", 10000);
    Product p4 = new Product("sp1", "Gao", 18000);
    Order o1 = new Order(1, LocalDate.now());
    o1.addLineItem(p1, 10);
    o1.addLineItem(p2, 5);
    o1.addLineItem(p3, 1);
    o1.addLineItem(p4, 1);
    System.out.println(o1.toString());
  }
}
