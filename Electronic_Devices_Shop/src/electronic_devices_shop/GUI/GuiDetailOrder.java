package electronic_devices_shop.GUI;


import electronic_devices_shop.DTO.CategoryDTO;
import electronic_devices_shop.DTO.OrderDTO;
import electronic_devices_shop.DTO.ProductDTO;
import electronic_devices_shop.DTO.UserDTO;
import electronic_devices_shop.Handle_API.HandleApiCategory;
import electronic_devices_shop.Handle_API.HandleApiOrder;
import electronic_devices_shop.Handle_API.HandleApiProduct;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GuiDetailOrder extends JFrame {

    private JPanel panelAddNewTour;

    private JSeparator sptAboveLeftInHeader;
    private JSeparator sptUnderLeftInHeader;
    private JSeparator sptAboveRightInHeader;
    private JSeparator sptUnderRightInHeader;
    private JLabel lbTitle;

    private JLabel labelId;
    private JTextField txtId;
    private JSeparator sptId;

    private JLabel labelNameTour;
    private JTextField txtNameTour;
    private JSeparator sptNameTour;

    private JLabel labelUnit;
    private JTextField txtUnit;
    private JSeparator sptUnit;


    private JLabel labelVND;

    private JLabel labelPriceTour;
    private JTextField txtPriceTour;
    private JSeparator sptPriceTour;

    private JLabel labelSpecification;
    private JTextArea textAreaDescription;
    private JScrollPane scrollPaneDescription;

    private JLabel labelQuantityLog;
    private JTextArea textAreaQuantityLog;
    private JScrollPane scrollPaneQuantityLog;

    private JLabel labelCategoryTour;
//    private static JComboBox<Tour_Category_DTO> comboBoxCategoryTour;

    private JButton buttonSaveNewTour;
    private JButton buttonClearField;

    public GuiDetailOrder(){
        GUI();
    }
    public void GUI(){
        setSize(450, 615);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Detail Order Is Selected");
        /************************************ PANEL ADD NEW TOUR **************************************/
        panelAddNewTour = new JPanel();
        panelAddNewTour.setLayout(null);
        panelAddNewTour.setBackground(Color.white);
        panelAddNewTour.setBounds(0,1, 450, 614);

        sptAboveLeftInHeader = new JSeparator();
        sptAboveLeftInHeader.setBounds(10,12,120,10);
        sptAboveLeftInHeader.setBackground(new Color(23, 23, 23));

        sptUnderLeftInHeader = new JSeparator();
        sptUnderLeftInHeader.setBounds(10,27,80,10);
        sptUnderLeftInHeader.setBackground(new Color(23, 23, 23));

        sptAboveRightInHeader = new JSeparator();
        sptAboveRightInHeader.setBounds(310,12,120,10);
        sptAboveRightInHeader.setBackground(new Color(23, 23, 23));

        sptUnderRightInHeader = new JSeparator();
        sptUnderRightInHeader.setBounds(350,27,80,10);
        sptUnderRightInHeader.setBackground(new Color(23, 23, 23));

        lbTitle = new JLabel("Detail Order");
        lbTitle.setBounds(160,18,150,25);
        lbTitle.setForeground(new Color(80, 80, 80));
        lbTitle.setFont(new Font("Times New Roman",1,19));

        labelId = new JLabel(" Id :",JLabel.CENTER);
        labelId.setFont(new Font("Segoe",Font.BOLD,12));
        labelId.setBounds(5,50,80,30);

        txtId = new JTextField();
        txtId.setBounds(90,48,80,30);
        txtId.setBorder(null);
        txtId.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtId.setText(OrderDTO.getId());
        txtId.setEditable(false);

        sptId = new JSeparator();
        sptId.setBounds(90,78,80,10);
        sptId.setBackground(new Color(0,0,0));

        /*========================= TEXTFIELD NAME TOUR ========================*/
        String trangthai ="";
        String status = OrderDTO.getStatus();
        if(status.equals("1")){
            trangthai = "New";
        }
        if(status.equals("2")){
            trangthai = "Processing";
        }
        if(status.equals("3")){
            trangthai = "Exported";
        }
        if(status.equals("4")){
            trangthai = "Done";
        }
        if(status.equals("5")){
            trangthai = "Cancelled";
        }
        labelNameTour = new JLabel(" Status :",JLabel.CENTER);
        labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelNameTour.setBounds(5,100,80,30);

        txtNameTour = new JTextField();
        txtNameTour.setBounds(90,98,300,30);
        txtNameTour.setBorder(null);
        txtNameTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtNameTour.setText(trangthai);
        txtNameTour.setEditable(false);

        sptNameTour = new JSeparator();
        sptNameTour.setBounds(90,128,300,30);
        sptNameTour.setBackground(new Color(0,0,0));
        /*=========================END TEXTFIELD NAME TOUR ================*/

        /*========================= TEXTFIELD PRICE TOUR ===================*/
        labelPriceTour = new JLabel("Total Price :",JLabel.CENTER);
        labelPriceTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelPriceTour.setBounds(-2,150,110,30);

        txtPriceTour = new JTextField();
        txtPriceTour.setBounds(90,148,90,30);
        //txtPriceTour.setBorder(null);
        txtPriceTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        long price = Long.parseLong(OrderDTO.getTotalPrice());
        String priceTour = java.text.NumberFormat.getIntegerInstance().format(price);
        txtPriceTour.setText(priceTour);
        txtPriceTour.setEditable(false);

        labelVND = new JLabel(" VND",JLabel.CENTER);
        labelVND.setFont(new Font("Segoe",Font.BOLD,12));
        labelVND.setBounds(180,150,30,30);

        sptPriceTour = new JSeparator();
        sptPriceTour.setBounds(90,178,120,10);
        sptPriceTour.setBackground(new Color(0,0,0));
        /*========================= END TEXTFIELD PRICE TOUR ===================*/

        //=========================COMBOBOX CATEGORY TOUR=========================//

        //=====================END COMBOBOX CATEGORY TOUR=====================//

        labelUnit = new JLabel("delivery Address :",JLabel.CENTER);
        labelUnit.setFont(new Font("Segoe",Font.BOLD,12));
        labelUnit.setBounds(-7,220,120,30);

        txtUnit = new JTextField();
        txtUnit.setBounds(95,218,295,30);
        txtUnit.setBorder(null);
        txtUnit.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtUnit.setText(OrderDTO.getDeliveryAddress());
        txtUnit.setEditable(false);

        sptUnit = new JSeparator();
        sptUnit.setBounds(95,248,295,10);
        sptUnit.setBackground(new Color(0,0,0));

        labelSpecification = new JLabel("Description :",JLabel.CENTER);
        labelSpecification.setFont(new Font("Segoe",Font.BOLD,12));
        labelSpecification.setBounds(5,280,120,30);

        textAreaDescription = new JTextArea(10, 10);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaDescription.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));
        textAreaDescription.setText(OrderDTO.getDescription());
        textAreaDescription.setEditable(false);

        scrollPaneDescription = new JScrollPane(textAreaDescription);
        scrollPaneDescription.setBounds(45,315,360,100);

        labelQuantityLog = new JLabel("Quantity Log :",JLabel.CENTER);
        labelQuantityLog.setFont(new Font("Segoe",Font.BOLD,12));
        labelQuantityLog.setBounds(5,420,120,30);

        textAreaQuantityLog = new JTextArea(10, 10);
        textAreaQuantityLog.setLineWrap(true);
        textAreaQuantityLog.setWrapStyleWord(true);
        textAreaQuantityLog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaQuantityLog.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));
        textAreaQuantityLog.setEditable(false);

        scrollPaneQuantityLog = new JScrollPane(textAreaQuantityLog);
        scrollPaneQuantityLog.setBounds(45,450,360,100);

        LoadQuatityLog();

        /*****************ADD ELEMENT FOR PANEL ADD NEW TOUR*****************************/
        panelAddNewTour.add(sptAboveLeftInHeader);
        panelAddNewTour.add(sptUnderLeftInHeader);
        panelAddNewTour.add(sptAboveRightInHeader);
        panelAddNewTour.add(sptUnderRightInHeader);
        panelAddNewTour.add(lbTitle);

        panelAddNewTour.add(labelId);
        panelAddNewTour.add(txtId);
        panelAddNewTour.add(sptId);

        panelAddNewTour.add(labelNameTour);
        panelAddNewTour.add(txtNameTour);
        panelAddNewTour.add(sptNameTour);

        panelAddNewTour.add(labelUnit);
        panelAddNewTour.add(txtUnit);
        panelAddNewTour.add(sptUnit);


        panelAddNewTour.add(labelPriceTour);
        panelAddNewTour.add(txtPriceTour);
        panelAddNewTour.add(sptPriceTour);
        panelAddNewTour.add(labelVND);

        panelAddNewTour.add(labelSpecification);
        panelAddNewTour.add(scrollPaneDescription);

        panelAddNewTour.add(labelQuantityLog);
        panelAddNewTour.add(scrollPaneQuantityLog);

        /*******************END ADD ELEMENT FOR PANEL ADD NEW TOUR**************************/
        /*********************************END PANEL ADD NEW TOUR*****************************************/
        add(panelAddNewTour);
        setVisible(true);

        /********************************* HANDLE BUTTON ADD NEW TOUR *****************************************/

        /*********************************END HANDLE BUTTON ADD NEW TOUR *****************************************/
    }
    public void LoadQuatityLog(){
        textAreaQuantityLog.setText("");
        UserDTO user = new UserDTO();
        JSONArray json = new JSONArray(HandleApiOrder.GetQuantityLog("orders/"+OrderDTO.getId(), user.getToken()));
        String data = "";
        System.out.println(json);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);

                String id = jsonObj.get("id").toString();
                String quantity = jsonObj.get("quantity").toString();
                String unitPrice = jsonObj.get("unitPrice").toString();
                String totalPrice = jsonObj.get("totalPrice").toString();

                JSONParser parser = new JSONParser();
                org.json.simple.JSONObject myObject;
                myObject = (org.json.simple.JSONObject) parser.parse(jsonObj.get("product").toString());
                String name = myObject.get("name").toString();

                data += "("+(i+1)+") "+name+" | quantity: "+quantity+" | uniPrice: "+unitPrice+" | totalPrice:"+totalPrice+"\n";


            } catch (JSONException | ParseException ex) {
                Logger.getLogger(GuiDetailProduct.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        textAreaQuantityLog.setText(data);
    }
}
