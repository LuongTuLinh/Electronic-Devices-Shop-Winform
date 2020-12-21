package electronic_devices_shop.GUI;


import electronic_devices_shop.DTO.CategoryDTO;
import electronic_devices_shop.DTO.UserDTO;
import electronic_devices_shop.Handle_API.HandleApiCategory;
import electronic_devices_shop.Handle_API.HandleApiProduct;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import static electronic_devices_shop.GUI.GuiTableListProducts.LoadDataTable;


public class GuiAddNewProduct extends JFrame {

    private static JComboBox<CategoryDTO> comboBoxCategoryTour;
    private JPanel panelAddNewTour;

    private JSeparator sptAboveLeftInHeader;
    private JSeparator sptUnderLeftInHeader;
    private JSeparator sptAboveRightInHeader;
    private JSeparator sptUnderRightInHeader;
    private JLabel lbTitle;

    private JLabel labelNameTour;
    private JTextField txtNameTour;
    private JSeparator sptNameTour;

    private JLabel labelUnit;
    private JTextField txtUnit;
    private JSeparator sptUnit;

    private JLabel labelSku;
    private JTextField txtSku;
    private JSeparator sptSku;

    private JLabel labelVND;

    private JLabel labelPriceTour;
    private JTextField txtPriceTour;
    private JSeparator sptPriceTour;

    private JLabel labelSpecification;
    private JTextArea textAreaDescription;
    private JScrollPane scrollPaneDescription;

    private JLabel labelCategoryTour;
//    private static JComboBox<Tour_Category_DTO> comboBoxCategoryTour;

    private JButton buttonSaveNewTour;
    private JButton buttonClearField;

    public GuiAddNewProduct(){
        GUI();
    }
    public void GUI(){
        setSize(450, 545);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Add Product New");
        /************************************ PANEL ADD NEW TOUR **************************************/
        panelAddNewTour = new JPanel();
        panelAddNewTour.setLayout(null);
        panelAddNewTour.setBackground(Color.white);
        panelAddNewTour.setBounds(0,1, 450, 499);

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

        lbTitle = new JLabel("Add New Product");
        lbTitle.setBounds(160,18,150,25);
        lbTitle.setForeground(new Color(80, 80, 80));
        lbTitle.setFont(new Font("Times New Roman",1,19));

        /*========================= TEXTFIELD NAME TOUR ========================*/
        labelNameTour = new JLabel(" Name :",JLabel.CENTER);
        labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelNameTour.setBounds(5,50,80,30);

        txtNameTour = new JTextField();
        txtNameTour.setBounds(90,48,300,30);
        txtNameTour.setBorder(null);
        txtNameTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

        sptNameTour = new JSeparator();
        sptNameTour.setBounds(90,78,300,10);
        sptNameTour.setBackground(new Color(0,0,0));
        /*=========================END TEXTFIELD NAME TOUR ================*/

        /*========================= TEXTFIELD PRICE TOUR ===================*/
        labelPriceTour = new JLabel("Price :",JLabel.CENTER);
        labelPriceTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelPriceTour.setBounds(5,100,80,30);

        txtPriceTour = new JTextField();
        txtPriceTour.setBounds(90,98,90,30);
        //txtPriceTour.setBorder(null);
        txtPriceTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

        labelVND = new JLabel(" VND",JLabel.CENTER);
        labelVND.setFont(new Font("Segoe",Font.BOLD,12));
        labelVND.setBounds(180,100,30,30);

        sptPriceTour = new JSeparator();
        sptPriceTour.setBounds(90,128,120,10);
        sptPriceTour.setBackground(new Color(0,0,0));
        /*========================= END TEXTFIELD PRICE TOUR ===================*/

        //=========================COMBOBOX CATEGORY TOUR=========================//
        labelCategoryTour = new JLabel("Category:",JLabel.CENTER);
        labelCategoryTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelCategoryTour.setBounds(5,156,80,30);

        comboBoxCategoryTour = new JComboBox<>();
        loadCategoryTourComboBox();

        comboBoxCategoryTour.setBounds(90,150,150,30);
        comboBoxCategoryTour.setFont(new Font("Segoe",Font.BOLD,13));
        //=====================END COMBOBOX CATEGORY TOUR=====================//

        labelUnit = new JLabel(" Unit :",JLabel.CENTER);
        labelUnit.setFont(new Font("Segoe",Font.BOLD,12));
        labelUnit.setBounds(9,192,80,30);

        txtUnit = new JTextField();
        txtUnit.setBounds(90,188,300,30);
        txtUnit.setBorder(null);
        txtUnit.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

        sptUnit = new JSeparator();
        sptUnit.setBounds(90,218,300,10);
        sptUnit.setBackground(new Color(0,0,0));

        labelSku = new JLabel(" Sku :",JLabel.CENTER);
        labelSku.setFont(new Font("Segoe",Font.BOLD,12));
        labelSku.setBounds(9,250,80,30);

        txtSku = new JTextField();
        txtSku.setBounds(90,248,300,30);
        txtSku.setBorder(null);
        txtSku.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

        sptSku = new JSeparator();
        sptSku.setBounds(90,278,300,10);
        sptSku.setBackground(new Color(0,0,0));

        labelSpecification = new JLabel("Description :",JLabel.CENTER);
        labelSpecification.setFont(new Font("Segoe",Font.BOLD,12));
        labelSpecification.setBounds(5,300,120,30);

        textAreaDescription = new JTextArea(10, 10);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaDescription.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));

        scrollPaneDescription = new JScrollPane(textAreaDescription);
        scrollPaneDescription.setBounds(45,335,360,100);

        buttonSaveNewTour = new JButton(" Add New ");
        buttonSaveNewTour.setBackground(new Color(255, 255, 255));
        buttonSaveNewTour.setFont(new Font("Segoe",Font.BOLD,13));
        buttonSaveNewTour.setForeground(Color.BLACK);
        buttonSaveNewTour.setBounds(65,450,100,30);
        buttonSaveNewTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonClearField = new JButton(" Refresh ");
        buttonClearField.setBackground(new Color(255, 255, 255));
        buttonClearField.setFont(new Font("Segoe",Font.BOLD,13));
        buttonClearField.setForeground(Color.BLACK);
        buttonClearField.setBounds(270,450,100,30);
        buttonClearField.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /*****************ADD ELEMENT FOR PANEL ADD NEW TOUR*****************************/
        panelAddNewTour.add(sptAboveLeftInHeader);
        panelAddNewTour.add(sptUnderLeftInHeader);
        panelAddNewTour.add(sptAboveRightInHeader);
        panelAddNewTour.add(sptUnderRightInHeader);
        panelAddNewTour.add(lbTitle);

        panelAddNewTour.add(labelNameTour);
        panelAddNewTour.add(txtNameTour);
        panelAddNewTour.add(sptNameTour);

        panelAddNewTour.add(labelUnit);
        panelAddNewTour.add(txtUnit);
        panelAddNewTour.add(sptUnit);

        panelAddNewTour.add(labelSku);
        panelAddNewTour.add(txtSku);
        panelAddNewTour.add(sptSku);

        panelAddNewTour.add(labelPriceTour);
        panelAddNewTour.add(txtPriceTour);
        panelAddNewTour.add(sptPriceTour);
        panelAddNewTour.add(labelVND);

        panelAddNewTour.add(labelCategoryTour);
        panelAddNewTour.add(comboBoxCategoryTour);

        panelAddNewTour.add(labelSpecification);
        panelAddNewTour.add(scrollPaneDescription);

        panelAddNewTour.add(buttonClearField);
        panelAddNewTour.add(buttonSaveNewTour);
        /*******************END ADD ELEMENT FOR PANEL ADD NEW TOUR**************************/
        /*********************************END PANEL ADD NEW TOUR*****************************************/
        add(panelAddNewTour);
        setVisible(true);

        /********************************* HANDLE BUTTON ADD NEW TOUR *****************************************/
        buttonClearField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTextField();
            }
        });

        buttonSaveNewTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserDTO user = new UserDTO();
                CategoryDTO category_dto = (CategoryDTO) (comboBoxCategoryTour.getSelectedItem());
                String categoryId = category_dto.getCategoryId();
                String nameTour = txtNameTour.getText();
                String priceTour = txtPriceTour.getText().replace(",","");
                String unit = txtUnit.getText();
                String sku = txtSku.getText();
                String specification = textAreaDescription.getText();
                String price_PATTERN = "^[1-9]([0-9])*$";
                if( !empty( nameTour ) && !empty( priceTour ) && !empty( specification ) ) {
                    if(Pattern.matches(price_PATTERN, priceTour)==false){
                        JOptionPane.showMessageDialog(null, "Lỗi! Giá  không hợp lệ, và giá phải lớn hơn 0. ");
                    } else {
                        String parameter = "{\"name\":\""+nameTour+"\",\"description\":\""+specification+"\",\"unit\":\""+unit+"\",\"sku\":\""+sku+"\",\"price\":"+priceTour+",\"categoryId\":"+categoryId+"}";
                        System.out.println(parameter);
                        String response = HandleApiProduct.sendPostAddNewProducts(parameter, "products", user.getToken());
                        if(response.equals("success")==true){
                            JOptionPane.showMessageDialog(null, "Thêm thành công");
                            LoadDataTable();
                            dispose();
                        }else {
                            JOptionPane.showMessageDialog(null, "Thêm thất bại, vui lòng thử lại");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                }
            }
        });

        txtPriceTour.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String price = txtPriceTour.getText();
                long priceTour = Long.parseLong(price.replace(",",""));
                String priceNewTour = java.text.NumberFormat.getIntegerInstance().format(priceTour);
                txtPriceTour.setText(priceNewTour);
            }
        });
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
    public void clearTextField(){
        txtNameTour.setText("");
        txtPriceTour.setText("");
        textAreaDescription.setText("");
        txtSku.setText("");
        txtUnit.setText("");
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
}
