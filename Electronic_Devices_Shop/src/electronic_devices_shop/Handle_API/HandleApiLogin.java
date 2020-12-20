package electronic_devices_shop.Handle_API;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import electronic_devices_shop.API.ApiRequester;
import electronic_devices_shop.DTO.UserDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;

/**
 *
 * @author DELL
 */
public class HandleApiLogin {
    UserDTO user = new UserDTO();
    public Object Login(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.sendPOST(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                JSONObject data = (JSONObject) myObject.get("data");

                JSONObject userRepsonse = (JSONObject) data.get("userResponse");
//                UserDTO user = new UserDTO();
                user.setToken(data.get("token").toString());
                user.setEmail(userRepsonse.get("email").toString());
                user.setLastName(userRepsonse.get("lastName").toString());
                user.setFirstName(userRepsonse.get("firstName").toString());
                user.setPhoneNumber(userRepsonse.get("phoneNumber").toString());
                return "success";
            } else {
                JOptionPane.showMessageDialog(null,"Lỗi: "+ myObject.get("ApiErr").toString());
                return "error";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

