package electronic_devices_shop.Handle_API;

import electronic_devices_shop.API.ApiRequester;
import electronic_devices_shop.DTO.ComboDTO;
import electronic_devices_shop.DTO.GoodsReceivingNote;
import electronic_devices_shop.DTO.SelectedDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleApiCombos {
    public static JSONArray GetAllGoodsDeliveryNotes(String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");
            if(Integer.parseInt(data.get("totalItems").toString()) >= 1){
                JSONArray repsonse = (JSONArray) data.get("data");
                return repsonse;
            }else {
                return null;
            }
        } catch (ParseException ex) {
            Logger.getLogger(HandleApiProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public static Object AddNewGoodsReceivingNotes(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.sendPOST(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                JSONObject data = (JSONObject) myObject.get("data");

                JSONObject userRepsonse = (JSONObject) data.get("userResponse");
//                UserDTO user = new UserDTO();
                SelectedDTO.setIdGDN(data.get("id").toString());

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
    public static String sendPostAddNewGoodsReceivingNotes(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.sendPOST(parameter, endpoint, token));

            if(myObject.get("DiscountPercentage") == null) {
                //JSONObject data = (JSONObject) myObject.get("data");
                return "success";
            } else {
                JOptionPane.showMessageDialog(null,"Lỗi: "+ myObject.get("DiscountPercentage").toString());
                return "error";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void GetComboId(String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.fetchAPI(endpoint, token));
            JSONObject data = (JSONObject) myObject.get("data");
            ComboDTO comboDTO = new ComboDTO();
            ComboDTO.setId(data.get("id").toString());
            ComboDTO.setName(data.get("name").toString());
            ComboDTO.setDiscountPercentage(data.get("discountPercent").toString());
            ComboDTO.setPrice(data.get("price").toString());
            ComboDTO.setPriceSale(data.get("priceForSale").toString());

        } catch (ParseException ex) {
            Logger.getLogger(HandleApiProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String sendPUTEditCategory(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.sendPUT(parameter, endpoint, token));

            if(myObject.get("DiscountPercentage") == null) {
                return "success";
            } else {
                JOptionPane.showMessageDialog(null,"Lỗi: "+ myObject.get("DiscountPercentage").toString());
                return "error";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static JSONArray GetQuantityLog(String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");
            if(Integer.parseInt(data.get("id").toString()) >= 1){
                JSONObject res = (JSONObject) myObject.get("data");
                JSONArray quantityLog = (JSONArray) res.get("comboDetails");

                return quantityLog;
            }else {
                return null;
            }
        } catch (ParseException ex) {
            Logger.getLogger(HandleApiProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
