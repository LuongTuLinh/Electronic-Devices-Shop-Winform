package electronic_devices_shop.GUI;

import electronic_devices_shop.DTO.SelectedDTO;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class GuiUpdateAddProductsToCombo {

    public static JFrame myFrame;

    private JPanel panelListCostType;

    private JLabel labelTitle;

    public static ArrayList<SelectedDTO> nameProductsArrayList = new ArrayList<>();
    public static ArrayList<SelectedDTO> idProductsArrayList = new ArrayList<>();

    public static HashMap<String, String> dataListCostType ;
    public static DefaultListModel<String> modelListCostType;
    public JList<String> listCostType;
    private JScrollPane scrollPaneAllCostType;
    private JButton btnAddCostTypeToGroup;

    private JLabel labelPriceCostType;
    private JTextField txtPriceCostType;
    private JSeparator sptPriceCostType;

    private JLabel labelDescriptionCostType;
    private JTextArea textAreaDescription;
    private JScrollPane scrollPaneCostType;

    public GuiUpdateAddProductsToCombo(){
        GUI();
    }
    public void GUI(){
        myFrame = new JFrame();
        myFrame.setSize(450, 580);
        //setLocationRelativeTo(null);
        myFrame.setLocation(705, 70);
        myFrame.setLayout(null);
        myFrame.getContentPane().setBackground(Color.BLACK);
        myFrame.setTitle("Add Products To Combo");

        panelListCostType =new JPanel();
        panelListCostType.setLayout(null);
        panelListCostType.setBackground(Color.white);
        panelListCostType.setBounds(0,1, 450, 549);

        labelTitle = new JLabel("- - Thêm Sản Phẩm Vào Combo - - ",JLabel.CENTER);
        labelTitle.setFont(new Font("Segoe",Font.BOLD,14));
        labelTitle.setBounds(0,10,450,30);

        scrollPaneAllCostType = new JScrollPane();

        scrollPaneAllCostType.setBounds(20, 50, 415, 180);
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
        labelPriceCostType.setBounds(30,280,120,30);

        txtPriceCostType = new JTextField();
        txtPriceCostType.setBounds(135,278,180,30);
        txtPriceCostType.setFont(new Font(Font.SERIF, Font.PLAIN, 15));


        sptPriceCostType = new JSeparator();
        sptPriceCostType.setBounds(135,308,180,10);
        sptPriceCostType.setBackground(new Color(0,0,0));


        //**************TEXTFIELD TEXTFIELD DESCRIPTION COST TYPE *******************//
        labelDescriptionCostType = new JLabel("Thông Tin :",JLabel.CENTER);
        labelDescriptionCostType.setFont(new Font("Segoe",Font.BOLD,12));
        labelDescriptionCostType.setBounds(5,375,120,30);

        textAreaDescription = new JTextArea(10, 10);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaDescription.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));
        textAreaDescription.setEditable(false);

        scrollPaneCostType = new JScrollPane(textAreaDescription);
        scrollPaneCostType.setBounds(40,400,370,125);
        //**************END TEXTFIELD TEXTFIELD DESCRIPTION COST TYPE*******************//



        btnAddCostTypeToGroup = new JButton("Lưu");
        btnAddCostTypeToGroup.setBackground(new Color(6, 32, 160));
        btnAddCostTypeToGroup.setFont(new Font("Segoe",Font.BOLD,13));
        btnAddCostTypeToGroup.setForeground(Color.WHITE);
        btnAddCostTypeToGroup.setBounds(170,345,115,30);
        btnAddCostTypeToGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelListCostType.add(labelTitle);
        panelListCostType.add(btnAddCostTypeToGroup);
        panelListCostType.add(scrollPaneAllCostType);

        panelListCostType.add(labelPriceCostType);
        panelListCostType.add(txtPriceCostType);
        panelListCostType.add(sptPriceCostType);

        panelListCostType.add(labelDescriptionCostType);
        panelListCostType.add(scrollPaneCostType);

        myFrame.add(panelListCostType);
        myFrame.setVisible(true);


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
                String quantity = txtPriceCostType.getText().replace(",","");
                String price_PATTERN = "^[1-9]([0-9])*$";
                if(Pattern.matches(price_PATTERN, quantity) == false) {
                    JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng kiểm tra lại quantity.");
                } else {
                    txtPriceCostType.setText("");
                    String name = listCostType.getSelectedValue();
                    SelectedDTO selectedDTO = new SelectedDTO(name, quantity);
                    nameProductsArrayList.add(selectedDTO);
                    setTextAreaDescription();

                    String idCostType ="";
                    for(Object x : dataListCostType.keySet()){
                        if(listCostType.getSelectedValue().equals(x)){
                            idCostType = dataListCostType.get(x);
                        }
                    }
                    SelectedDTO selectedId = new SelectedDTO(idCostType, quantity);
                    idProductsArrayList.add(selectedId);

                }
            }
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
    public void setTextAreaDescription(){
        textAreaDescription.setText("");
        int i = 1;
        String text = "";
        for (SelectedDTO selectedDTO : nameProductsArrayList){
            text +="("+i+") : "+ selectedDTO.getName()+" | quantity = "+selectedDTO.getQuantity()+"\n";
            i++;
        }
        textAreaDescription.setText(text);
    }
    public static void disConnectJFrameCombo(){
        myFrame.setVisible(false);
        myFrame.dispose();
    }
}