package electronic_devices_shop.Handle_API;

import electronic_devices_shop.API.ApiRequester;
import electronic_devices_shop.DTO.GoodsReceivingNote;
import electronic_devices_shop.DTO.OrderDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleApiOrder {
    public static JSONArray GetQuantityLog(String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.fetchAPI(endpoint, token));

            JSONObject data = (JSONObject) myObject.get("data");
            if(Integer.parseInt(data.get("id").toString()) >= 1){
                JSONObject res = (JSONObject) myObject.get("data");
                JSONArray quantityLog = (JSONArray) res.get("orderDetails");
                return quantityLog;
            }else {
                return null;
            }
        } catch (ParseException ex) {
            Logger.getLogger(HandleApiProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void GetGRNId(String endpoint, String token){
        JSONParser parser = new JSONParser();
        JSONObject myObject;
        try {
            myObject = (JSONObject) parser.parse(ApiRequester.fetchAPI(endpoint, token));
            JSONObject data = (JSONObject) myObject.get("data");

            OrderDTO.setId(data.get("id").toString());
            OrderDTO.setStatus(data.get("status").toString());
            OrderDTO.setDescription(data.get("description").toString());
            OrderDTO.setTotalPrice(data.get("totalPrice").toString());
            OrderDTO.setDeliveryAddress(data.get("deliveryAddress").toString());
        } catch (ParseException ex) {
            Logger.getLogger(HandleApiProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
