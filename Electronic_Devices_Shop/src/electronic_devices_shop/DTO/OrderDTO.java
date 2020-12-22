package electronic_devices_shop.DTO;

public class OrderDTO {
    private static String id;
    private static String status;
    private static String description;
    private static String deliveryAddress;
    private static String totalPrice;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        OrderDTO.id = id;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        OrderDTO.status = status;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        OrderDTO.description = description;
    }

    public static String getDeliveryAddress() {
        return deliveryAddress;
    }

    public static void setDeliveryAddress(String deliveryAddress) {
        OrderDTO.deliveryAddress = deliveryAddress;
    }

    public static String getTotalPrice() {
        return totalPrice;
    }

    public static void setTotalPrice(String totalPrice) {
        OrderDTO.totalPrice = totalPrice;
    }
}
