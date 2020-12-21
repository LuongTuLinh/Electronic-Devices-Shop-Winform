package electronic_devices_shop.DTO;

public class ProductDTO {
    private static String id;
    private static String name;
    private static String description;
    private static String unit;
    private static String sku;
    private static String price;
    private static String category;
    private static String quantity;

    public ProductDTO() {
    }


    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        ProductDTO.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ProductDTO.name = name;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        ProductDTO.description = description;
    }

    public static String getUnit() {
        return unit;
    }

    public static void setUnit(String unit) {
        ProductDTO.unit = unit;
    }

    public static String getSku() {
        return sku;
    }

    public static void setSku(String sku) {
        ProductDTO.sku = sku;
    }

    public static String getPrice() {
        return price;
    }

    public static void setPrice(String price) {
        ProductDTO.price = price;
    }

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        ProductDTO.category = category;
    }

    public static String getQuantity() {
        return quantity;
    }

    public static void setQuantity(String quantity) {
        ProductDTO.quantity = quantity;
    }
}
