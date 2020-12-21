package electronic_devices_shop.Handle_API;

import electronic_devices_shop.API.ApiRequester;
import electronic_devices_shop.DTO.ProductDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleApiProduct {
    public static JSONArray GetAllProducts(String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");
            if(Integer.parseInt(data.get("totalItems").toString()) >= 1){
                JSONArray productsRepsonse = (JSONArray) data.get("data");
                return productsRepsonse;
            }else {
                return null;
            }
        } catch (ParseException ex) {
            Logger.getLogger(HandleApiProduct.class.getName()).log(Level.SEVERE, null, ex);
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
                JSONArray quantityLog = (JSONArray) res.get("quantityLogs");
                System.out.println("con cac: "+quantityLog);
                return quantityLog;
            }else {
                return null;
            }
        } catch (ParseException ex) {
            Logger.getLogger(HandleApiProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void GetProductId(String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.fetchAPI(endpoint, token));
            JSONObject data = (JSONObject) myObject.get("data");
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(data.get("id").toString());
            productDTO.setName(data.get("name").toString());
            productDTO.setDescription(data.get("description").toString());
            productDTO.setUnit(data.get("unit").toString());
            productDTO.setPrice(data.get("price").toString());
            productDTO.setCategory(data.get("categoryId").toString());
            productDTO.setQuantity(data.get("quantity").toString());
        } catch (ParseException ex) {
            Logger.getLogger(HandleApiProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String sendPostAddNewProducts(String parameter, String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.sendPOST(parameter, endpoint, token));

            if(myObject.get("ApiErr") == null) {
                JSONObject data = (JSONObject) myObject.get("data");
                return "success";
            } else {
                JOptionPane.showMessageDialog(null,"Lỗi: "+ myObject.get("ApiErr").toString());
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String sendDeleteProduct(String parameter, String endpoint, String token) {
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.sendDelete(parameter,endpoint, token));

            if(myObject.get("ApiErr") == null) {
                JOptionPane.showMessageDialog(null, "Xoá thành công");
                return "success";
            } else {
                String apierror = myObject.get("ApiErr") == null ? "" : myObject.get("ApiErr").toString();

                String error = "Lỗi:"+ apierror+"\n";

                String[] arrayError = error.split("\\.");
                String messError = "";
                for(String s : arrayError){
                    messError+= s +"\n";
                }

                JOptionPane.showMessageDialog(null,messError, "My Message", JOptionPane.ERROR_MESSAGE);
                return "error";
            }
        } catch (ParseException ex) {
            Logger.getLogger(HandleApiProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public static String sendPUTEditProduct(String parameter, String endpoint, String token){
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
