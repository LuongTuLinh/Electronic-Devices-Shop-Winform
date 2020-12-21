package electronic_devices_shop.DTO;

public class ComboDTO {
    private static String id;
    private static String name;
    private static String discountPercentage;
    private static String price;
    private static String priceSale;

    public ComboDTO() {
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        ComboDTO.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ComboDTO.name = name;
    }

    public static String getDiscountPercentage() {
        return discountPercentage;
    }

    public static void setDiscountPercentage(String discountPercentage) {
        ComboDTO.discountPercentage = discountPercentage;
    }

    public static String getPrice() {
        return price;
    }

    public static void setPrice(String price) {
        ComboDTO.price = price;
    }

    public static String getPriceSale() {
        return priceSale;
    }

    public static void setPriceSale(String priceSale) {
        ComboDTO.priceSale = priceSale;
    }
}
