package electronic_devices_shop.DTO;

public class GoodsReceivingNote {
    private static String id;
    private static String supplierName;
    private static String description;
    private static String totalPrice;

    public GoodsReceivingNote() {
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        GoodsReceivingNote.id = id;
    }

    public static String getSupplierName() {
        return supplierName;
    }

    public static void setSupplierName(String supplierName) {
        GoodsReceivingNote.supplierName = supplierName;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        GoodsReceivingNote.description = description;
    }

    public static String getTotalPrice() {
        return totalPrice;
    }

    public static void setTotalPrice(String totalPrice) {
        GoodsReceivingNote.totalPrice = totalPrice;
    }
}
