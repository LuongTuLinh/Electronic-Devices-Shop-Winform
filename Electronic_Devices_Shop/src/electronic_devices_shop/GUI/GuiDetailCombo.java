package electronic_devices_shop.GUI;


import electronic_devices_shop.DTO.*;
import electronic_devices_shop.Handle_API.HandleApiCategory;
import electronic_devices_shop.Handle_API.HandleApiCombos;
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


public class GuiDetailCombo extends JFrame {

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


    private JLabel labelVND;

    private JLabel labelPriceTour;
    private JTextField txtPriceTour;
    private JSeparator sptPriceTour;

    private JLabel labelSaleVND;

    private JLabel labelPriceSale;
    private JTextField txtPriceSale;
    private JSeparator sptPriceSale;

    private JLabel labeldiscountPercent;
    private JTextField txtdiscountPercent;
    private JSeparator sptdiscountPercent;


    private JLabel labelQuantityLog;
    private JTextArea textAreaQuantityLog;
    private JScrollPane scrollPaneQuantityLog;

    public GuiDetailCombo(){
        GUI();
    }
    public void GUI(){
        setSize(450, 615);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Detail Combo Is Selected");
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

        lbTitle = new JLabel("Detail Combo");
        lbTitle.setBounds(160,18,160,25);
        lbTitle.setForeground(new Color(80, 80, 80));
        lbTitle.setFont(new Font("Times New Roman",1,19));

        labelId = new JLabel(" Id :",JLabel.CENTER);
        labelId.setFont(new Font("Segoe",Font.BOLD,12));
        labelId.setBounds(30,50,80,30);

        txtId = new JTextField();
        txtId.setBounds(90,48,80,30);
        txtId.setBorder(null);
        txtId.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtId.setText(ComboDTO.getId());
        txtId.setEditable(false);

        sptId = new JSeparator();
        sptId.setBounds(90,78,80,10);
        sptId.setBackground(new Color(0,0,0));

        /*========================= TEXTFIELD NAME TOUR ========================*/
        labelNameTour = new JLabel("Combo Name:",JLabel.CENTER);
        labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelNameTour.setBounds(-14,100,120,30);

        txtNameTour = new JTextField();
        txtNameTour.setBounds(90,98,300,30);
        txtNameTour.setBorder(null);
        txtNameTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtNameTour.setText(ComboDTO.getName());
        txtNameTour.setEditable(false);

        sptNameTour = new JSeparator();
        sptNameTour.setBounds(90,128,300,30);
        sptNameTour.setBackground(new Color(0,0,0));
        /*=========================END TEXTFIELD NAME TOUR ================*/

        /*========================= TEXTFIELD PRICE TOUR ===================*/
        labelPriceTour = new JLabel(" Price :",JLabel.CENTER);
        labelPriceTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelPriceTour.setBounds(5,145,80,30);

        txtPriceTour = new JTextField();
        txtPriceTour.setBounds(90,143,90,30);
        //txtPriceTour.setBorder(null);
        txtPriceTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        long price = Long.parseLong(ComboDTO.getPrice());
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

        /*========================= TEXTFIELD PRICE TOUR ===================*/
        labelPriceSale = new JLabel(" Price For Sale :",JLabel.CENTER);
        labelPriceSale.setFont(new Font("Segoe",Font.BOLD,12));
        labelPriceSale.setBounds(-25,200,160,30);

        txtPriceSale = new JTextField();
        txtPriceSale.setBounds(100,198,90,30);
        //txtPriceTour.setBorder(null);
        txtPriceSale.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        long priceSale = Long.parseLong(ComboDTO.getPriceSale());
        String priceS = java.text.NumberFormat.getIntegerInstance().format(priceSale);
        txtPriceSale.setText(priceS);
        txtPriceSale.setEditable(false);

        labelSaleVND = new JLabel(" VND",JLabel.CENTER);
        labelSaleVND.setFont(new Font("Segoe",Font.BOLD,12));
        labelSaleVND.setBounds(190,200,30,30);

        sptPriceSale = new JSeparator();
        sptPriceSale.setBounds(100,228,120,10);
        sptPriceSale.setBackground(new Color(0,0,0));

        labeldiscountPercent = new JLabel(" discount Percent :",JLabel.CENTER);
        labeldiscountPercent.setFont(new Font("Segoe",Font.BOLD,12));
        labeldiscountPercent.setBounds(0,260,150,30);

        txtdiscountPercent = new JTextField();
        txtdiscountPercent.setBounds(135,258,80,30);
        txtdiscountPercent.setBorder(null);
        txtdiscountPercent.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtdiscountPercent.setText(ComboDTO.getDiscountPercentage());
        txtdiscountPercent.setEditable(false);

        sptdiscountPercent = new JSeparator();
        sptdiscountPercent.setBounds(135,288,80,10);
        sptdiscountPercent.setBackground(new Color(0,0,0));

        //=========================COMBOBOX CATEGORY TOUR=========================//


        labelQuantityLog = new JLabel("Products Information of Combo :",JLabel.CENTER);
        labelQuantityLog.setFont(new Font("Segoe",Font.BOLD,12));
        labelQuantityLog.setBounds(5,340,220,30);

        textAreaQuantityLog = new JTextArea(10, 12);
        textAreaQuantityLog.setLineWrap(true);
        textAreaQuantityLog.setWrapStyleWord(true);
        textAreaQuantityLog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaQuantityLog.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));
        textAreaQuantityLog.setEditable(false);

        scrollPaneQuantityLog = new JScrollPane(textAreaQuantityLog);
        scrollPaneQuantityLog.setBounds(45,375,360,160);

        LoadCombo();

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


        panelAddNewTour.add(labelPriceTour);
        panelAddNewTour.add(txtPriceTour);
        panelAddNewTour.add(sptPriceTour);
        panelAddNewTour.add(labelVND);

        panelAddNewTour.add(labelPriceSale);
        panelAddNewTour.add(txtPriceSale);
        panelAddNewTour.add(sptPriceSale);
        panelAddNewTour.add(labelSaleVND);

        panelAddNewTour.add(labeldiscountPercent);
        panelAddNewTour.add(txtdiscountPercent);
        panelAddNewTour.add(sptdiscountPercent);

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
    public void LoadCombo(){
        textAreaQuantityLog.setText("");
        UserDTO user = new UserDTO();
        JSONArray json = new JSONArray(HandleApiCombos.GetQuantityLog("combos/"+ ComboDTO.getId(), user.getToken()));
        String data = "";
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);

                String id = jsonObj.get("id").toString();
                String quantity = jsonObj.get("quantity").toString();

                JSONParser parser = new JSONParser();
                org.json.simple.JSONObject myObject;
                myObject = (org.json.simple.JSONObject) parser.parse(jsonObj.get("product").toString());
                String name = myObject.get("name").toString();
                String price = myObject.get("price").toString();

                data += "("+(i+1)+") "+name+" | quantity: "+quantity+" | price of one product: "+price+"\n";

            } catch (JSONException | ParseException ex) {
                Logger.getLogger(GuiDetailProduct.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        textAreaQuantityLog.setText(data);
    }
}
