package electronic_devices_shop.GUI;


import electronic_devices_shop.DTO.CategoryDTO;
import electronic_devices_shop.DTO.GoodsReceivingNote;
import electronic_devices_shop.DTO.ProductDTO;
import electronic_devices_shop.DTO.UserDTO;
import electronic_devices_shop.Handle_API.HandleApiCategory;
import electronic_devices_shop.Handle_API.HandleApiGoodsDeliveryNote;
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


public class GuiDetailGoodsReceivingNote extends JFrame {

    private static JComboBox<CategoryDTO> comboBoxCategoryTour;
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

    private JLabel labelQuantity;
    private JTextField txtQuantity;
    private JSeparator sptQuantity;

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

    public GuiDetailGoodsReceivingNote(){
        GUI();
    }
    public void GUI(){
        setSize(450, 615);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Detail Goods Receiving Note Is Selected");
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

        lbTitle = new JLabel("Detail Goods Receiving Note");
        lbTitle.setBounds(100,18,245,25);
        lbTitle.setForeground(new Color(80, 80, 80));
        lbTitle.setFont(new Font("Times New Roman",1,18));

        labelId = new JLabel(" Id :",JLabel.CENTER);
        labelId.setFont(new Font("Segoe",Font.BOLD,12));
        labelId.setBounds(30,50,80,30);

        txtId = new JTextField();
        txtId.setBounds(90,48,80,30);
        txtId.setBorder(null);
        txtId.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtId.setText(GoodsReceivingNote.getId());
        txtId.setEditable(false);

        sptId = new JSeparator();
        sptId.setBounds(90,78,80,10);
        sptId.setBackground(new Color(0,0,0));

        /*========================= TEXTFIELD NAME TOUR ========================*/
        labelNameTour = new JLabel("Supplier Name:",JLabel.CENTER);
        labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelNameTour.setBounds(-14,100,120,30);

        txtNameTour = new JTextField();
        txtNameTour.setBounds(90,98,300,30);
        txtNameTour.setBorder(null);
        txtNameTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtNameTour.setText(GoodsReceivingNote.getSupplierName());
        txtNameTour.setEditable(false);

        sptNameTour = new JSeparator();
        sptNameTour.setBounds(90,128,300,30);
        sptNameTour.setBackground(new Color(0,0,0));
        /*=========================END TEXTFIELD NAME TOUR ================*/

        /*========================= TEXTFIELD PRICE TOUR ===================*/
        labelPriceTour = new JLabel("Total Price :",JLabel.CENTER);
        labelPriceTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelPriceTour.setBounds(5,145,80,30);

        txtPriceTour = new JTextField();
        txtPriceTour.setBounds(90,143,90,30);
        //txtPriceTour.setBorder(null);
        txtPriceTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        long price = Long.parseLong(GoodsReceivingNote.getTotalPrice());
        String priceTour = java.text.NumberFormat.getIntegerInstance().format(price);
        txtPriceTour.setText(priceTour);
        txtPriceTour.setEditable(false);

        labelVND = new JLabel(" VND",JLabel.CENTER);
        labelVND.setFont(new Font("Segoe",Font.BOLD,12));
        labelVND.setBounds(180,145,30,30);

        sptPriceTour = new JSeparator();
        sptPriceTour.setBounds(90,173,120,10);
        sptPriceTour.setBackground(new Color(0,0,0));
        /*========================= END TEXTFIELD PRICE TOUR ===================*/

        //=========================COMBOBOX CATEGORY TOUR=========================//

        labelSpecification = new JLabel("Description :",JLabel.CENTER);
        labelSpecification.setFont(new Font("Segoe",Font.BOLD,12));
        labelSpecification.setBounds(5,200,120,30);

        textAreaDescription = new JTextArea(10, 10);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaDescription.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));
        textAreaDescription.setText(GoodsReceivingNote.getDescription());
        textAreaDescription.setEditable(false);

        scrollPaneDescription = new JScrollPane(textAreaDescription);
        scrollPaneDescription.setBounds(45,235,360,100);

        labelQuantityLog = new JLabel("Products Information :",JLabel.CENTER);
        labelQuantityLog.setFont(new Font("Segoe",Font.BOLD,12));
        labelQuantityLog.setBounds(5,340,150,30);

        textAreaQuantityLog = new JTextArea(10, 12);
        textAreaQuantityLog.setLineWrap(true);
        textAreaQuantityLog.setWrapStyleWord(true);
        textAreaQuantityLog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaQuantityLog.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));
        textAreaQuantityLog.setEditable(false);

        scrollPaneQuantityLog = new JScrollPane(textAreaQuantityLog);
        scrollPaneQuantityLog.setBounds(45,375,360,160);

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

//        panelAddNewTour.add(labelUnit);
//        panelAddNewTour.add(txtUnit);
//        panelAddNewTour.add(sptUnit);
//
//        panelAddNewTour.add(labelQuantity);
//        panelAddNewTour.add(txtQuantity);
//        panelAddNewTour.add(sptQuantity);


        panelAddNewTour.add(labelPriceTour);
        panelAddNewTour.add(txtPriceTour);
        panelAddNewTour.add(sptPriceTour);
        panelAddNewTour.add(labelVND);

//        panelAddNewTour.add(labelCategoryTour);
//        panelAddNewTour.add(comboBoxCategoryTour);

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
    public static void loadCategoryTourComboBox(){
        UserDTO user = new UserDTO();
        JSONArray array = new JSONArray(HandleApiCategory.GetAllCategory("categories?Page=1", user.getToken()));
        for(int i = 0; i < array.length(); i++){
            try {
                JSONObject jsonObject = (JSONObject) array.get(i);
                String id = jsonObject.get("id").toString();
                String name = jsonObject.get("name").toString();
                comboBoxCategoryTour.addItem(new CategoryDTO(id, name));
                if(ProductDTO.getCategory().equals(id) == true){
                    comboBoxCategoryTour.setSelectedIndex(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
    public void LoadQuatityLog(){
        textAreaQuantityLog.setText("");
        UserDTO user = new UserDTO();
        JSONArray json = new JSONArray(HandleApiGoodsDeliveryNote.GetQuantityLog("goodsReceivingNotes/"+GoodsReceivingNote.getId(), user.getToken()));
        String data = "";
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
