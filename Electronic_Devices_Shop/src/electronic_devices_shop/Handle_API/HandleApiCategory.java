package electronic_devices_shop.Handle_API;

import electronic_devices_shop.API.ApiRequester;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleApiCategory {
    public static JSONArray GetAllCategory(String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");
            if(Integer.parseInt(data.get("totalItems").toString()) >= 1){
                JSONArray tourCategory = (JSONArray) data.get("data");

                return tourCategory;
            }else {
                return null;
            }


        } catch (ParseException ex) {
            Logger.getLogger(HandleApiCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public static String sendDeleteCategory(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.sendDelete(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                System.out.println("TourDetail Delete Success");
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
    public static String sendPostAddCategory(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.sendPOST(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
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
    public static String sendPUTEditCategory(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.sendPUT(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
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
