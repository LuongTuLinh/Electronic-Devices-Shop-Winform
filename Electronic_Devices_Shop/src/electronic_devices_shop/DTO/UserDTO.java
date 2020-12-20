package electronic_devices_shop.DTO;

public class UserDTO {
    private static String email;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String token;
    private static String phoneNumber;

    public UserDTO() {
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserDTO.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserDTO.password = password;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        UserDTO.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        UserDTO.lastName = lastName;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        UserDTO.token = token;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        UserDTO.phoneNumber = phoneNumber;
    }
}
