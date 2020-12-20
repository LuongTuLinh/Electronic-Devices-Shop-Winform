package electronic_devices_shop.GUI;

import electronic_devices_shop.DTO.UserDTO;
import electronic_devices_shop.Handle_API.HandleApiProduct;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class GuiAddProductToGoodsDeliveryNotes extends JFrame {

    private JPanel panelListCostType;

    private JLabel labelTitle;

    public static HashMap<String, String> dataListCostType ;
    public static DefaultListModel<String> modelListCostType;
    public JList<String> listCostType;
    private JScrollPane scrollPaneAllCostType;
    private JButton btnAddCostTypeToGroup;

    private JLabel labelPriceCostType;
    private JTextField txtPriceCostType;
    private JSeparator sptPriceCostType;

    private JLabel labelUniPrice;
    private JTextField txtUniPrice;
    private JSeparator sptUniPrice;


    public GuiAddProductToGoodsDeliveryNotes(){
        GUI();
    }
    public void GUI(){
        setSize(450, 520);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Add Product To Goods Delivery Note");

        panelListCostType =new JPanel();
        panelListCostType.setLayout(null);
        panelListCostType.setBackground(Color.white);
        panelListCostType.setBounds(0,1, 450, 549);

        labelTitle = new JLabel("- - - DANH SÁCH SẢN PHẨM - - - ",JLabel.CENTER);
        labelTitle.setFont(new Font("Segoe",Font.BOLD,14));
        labelTitle.setBounds(0,10,450,30);

        scrollPaneAllCostType = new JScrollPane();

        scrollPaneAllCostType.setBounds(20, 50, 400, 230);
        scrollPaneAllCostType.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(19, 113, 106);
            }
        });

        ListCostTypeGroup();
        listCostType.setSelectedIndex(0);
        listCostType.setVisibleRowCount(10);
        listCostType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listCostType.setFixedCellHeight(30);
        listCostType.setFixedCellWidth(350);
        listCostType.setBorder(new EmptyBorder(10,10, 10, 10));


        scrollPaneAllCostType.setViewportView(listCostType);


        //**************TEXTFIELD PRICE COST TYPE*******************//
        labelPriceCostType = new JLabel("Quantity :",JLabel.CENTER);
        labelPriceCostType.setFont(new Font("Segoe",Font.BOLD,12));
        labelPriceCostType.setBounds(30,300,120,30);

        txtPriceCostType = new JTextField();
        txtPriceCostType.setBounds(135,298,180,30);
        txtPriceCostType.setFont(new Font(Font.SERIF, Font.PLAIN, 15));


        sptPriceCostType = new JSeparator();
        sptPriceCostType.setBounds(135,328,180,10);
        sptPriceCostType.setBackground(new Color(0,0,0));

        labelUniPrice = new JLabel("uni Price :",JLabel.CENTER);
        labelUniPrice.setFont(new Font("Segoe",Font.BOLD,12));
        labelUniPrice.setBounds(30,350,120,30);

        txtUniPrice = new JTextField();
        txtUniPrice.setBounds(135,348,180,30);
        txtUniPrice.setFont(new Font(Font.SERIF, Font.PLAIN, 15));


        sptUniPrice = new JSeparator();
        sptUniPrice.setBounds(135,378,180,10);
        sptUniPrice.setBackground(new Color(0,0,0));
        //**************END TEXTFIELD PRICE COST TYPE*******************//



        btnAddCostTypeToGroup = new JButton("Lưu");
        btnAddCostTypeToGroup.setBackground(new Color(6, 32, 160));
        btnAddCostTypeToGroup.setFont(new Font("Segoe",Font.BOLD,13));
        btnAddCostTypeToGroup.setForeground(Color.WHITE);
        btnAddCostTypeToGroup.setBounds(170,445,115,30);
        btnAddCostTypeToGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelListCostType.add(labelTitle);
        panelListCostType.add(btnAddCostTypeToGroup);
        panelListCostType.add(scrollPaneAllCostType);

        panelListCostType.add(labelPriceCostType);
        panelListCostType.add(txtPriceCostType);
        panelListCostType.add(sptPriceCostType);

        panelListCostType.add(labelUniPrice);
        panelListCostType.add(txtUniPrice);
        panelListCostType.add(sptUniPrice);

        add(panelListCostType);
        setVisible(true);


        txtPriceCostType.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String price = txtPriceCostType.getText();
                long priceTour = Long.parseLong(price.replace(",",""));
                String priceNewTour = java.text.NumberFormat.getIntegerInstance().format(priceTour);
                txtPriceCostType.setText(priceNewTour);
            }
        });

        btnAddCostTypeToGroup.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,"Chua lam dc do api thi phai :v");
            }
//            UserDTO user_dto = new UserDTO();
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//                if(listCostType.getSelectedValuesList().isEmpty()){
//                    JOptionPane.showMessageDialog(null,"Vui lòng chọn chi phí");
//                }
//                else {
//                    String idCostType ="";
//                    for(Object x : dataListCostType.keySet()){
//                        if(listCostType.getSelectedValue().equals(x)){
//                            idCostType = dataListCostType.get(x);
//                        }
//                    }
//                    String price = txtPriceCostType.getText().replace(",","");
//                    String note = textAreaDescription.getText();
//                    String price_PATTERN = "^[1-9]([0-9])*$";
//                    if(Pattern.matches(price_PATTERN, price) == false) {
//                        JOptionPane.showMessageDialog(null, "Lỗi! Giá chi phí không hợp lệ, và giá tour phải lớn hơn 0.");
//                    }else {
//                        String parameter="{\"id\":0,\"groupId\":"+id+",\"costTypeId\":"+idCostType+",\"price\":"+price+",\"note\":\""+note+"\"}";
//
//                        String response = Handle_API_Cost_Type.sendPost_Add_Cost_Type(parameter, "groupCosts", user_dto.getToken());
//                        if(response.equals("success") == true){
//                            JOptionPane.showMessageDialog(null, "Thêm thành công");
//                            dispose();
//                            LoadDataTableCostTypeInGroup(id);
//                        }
//                    }
//
//                }
//
//            }
        });
    }
    public static HashMap<String, String> hashMapCostTypeInGroup(){
        UserDTO user = new UserDTO();
        dataListCostType = new HashMap<String, String>();
        JSONArray result = new JSONArray(HandleApiProduct.GetAllProducts("products?Page=1", user.getToken()));
        for(int i = 0; i < result.length(); i++){
            JSONObject jsonObj;
            try {
                jsonObj = result.getJSONObject(i);
                String name = jsonObj.get("name").toString();
                String id = jsonObj.get("id").toString();

                dataListCostType.put(name,id);

            } catch (JSONException ex) {
                Logger.getLogger(GuiAddProductToGoodsDeliveryNotes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dataListCostType;

    }
    public void ListCostTypeGroup(){
        hashMapCostTypeInGroup();
        modelListCostType = new  DefaultListModel<String>();
        listCostType = new JList<String>(modelListCostType);
        for(Object object : dataListCostType.keySet()){
            modelListCostType.addElement(String.valueOf(object));
        }
        listCostType.setModel(modelListCostType);
        listCostType.setFont(new Font("Arial",Font.ITALIC,14));


    }
}