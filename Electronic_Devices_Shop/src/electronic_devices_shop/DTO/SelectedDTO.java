package electronic_devices_shop.DTO;

public class SelectedDTO {
    private String id;
    private String name;
    private String quantity;
    private String uniPrice;
    private static String idGDN;

    public SelectedDTO() {
    }

    public SelectedDTO(String id, String name, String quantity, String uniPrice) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.uniPrice = uniPrice;
    }

    public SelectedDTO(String name, String quantity, String uniPrice) {
        this.name = name;
        this.quantity = quantity;
        this.uniPrice = uniPrice;
    }

    public SelectedDTO(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUniPrice() {
        return uniPrice;
    }

    public void setUniPrice(String uniPrice) {
        this.uniPrice = uniPrice;
    }

    public static String getIdGDN() {
        return idGDN;
    }

    public static void setIdGDN(String idGDN) {
        SelectedDTO.idGDN = idGDN;
    }
}
