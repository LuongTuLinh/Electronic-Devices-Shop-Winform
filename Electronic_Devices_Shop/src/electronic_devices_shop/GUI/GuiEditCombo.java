package electronic_devices_shop.GUI;


import electronic_devices_shop.DTO.CategoryDTO;
import electronic_devices_shop.DTO.ComboDTO;
import electronic_devices_shop.DTO.SelectedDTO;
import electronic_devices_shop.DTO.UserDTO;
import electronic_devices_shop.Handle_API.HandleApiCategory;
import electronic_devices_shop.Handle_API.HandleApiCombos;
import electronic_devices_shop.Handle_API.HandleApiGoodsDeliveryNote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import static electronic_devices_shop.GUI.GuiAddProductToGoodsDeliveryNotes.*;
import static electronic_devices_shop.GUI.GuiAddProductsToCombo.*;
import static electronic_devices_shop.GUI.GuiTableCombos.LoadDataTableCombos;
import static electronic_devices_shop.GUI.GuiTableGoodsDeliveryNotes.LoadDataTableGDN;


public class GuiEditCombo extends JFrame {

    private JPanel panelAddNewTour;

    private JSeparator sptAboveLeftInHeader;
    private JSeparator sptUnderLeftInHeader;
    private JSeparator sptAboveRightInHeader;
    private JSeparator sptUnderRightInHeader;
    private JLabel lbTitle;

    private JLabel labelNameTour;
    private JTextField txtNameTour;
    private JSeparator sptNameTour;

    private JLabel labeldiscountPercentage;
    private JTextField txtdiscountPercentage;
    private JSeparator sptdiscountPercentage;


    private JButton buttonSaveNewTour;
    private JButton buttonClearField;

    public GuiEditCombo(){
        GUI();
    }
    public void GUI(){
        setSize(450, 345);
        setLocationRelativeTo(null);
        //setLocation(270, 160);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Edit Combo");
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

        lbTitle = new JLabel("Edit Combo");
        lbTitle.setBounds(160,18,180,25);
        lbTitle.setForeground(new Color(80, 80, 80));
        lbTitle.setFont(new Font("Times New Roman",1,19));

        /*========================= TEXTFIELD NAME TOUR ========================*/
        labelNameTour = new JLabel(" Combo Name :",JLabel.CENTER);
        labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelNameTour.setBounds(5,70,100,30);


        txtNameTour = new JTextField();
        txtNameTour.setBounds(110,68,270,30);
        txtNameTour.setBorder(null);
        txtNameTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtNameTour.setText(ComboDTO.getName());

        sptNameTour = new JSeparator();
        sptNameTour.setBounds(110,98,300,10);
        sptNameTour.setBackground(new Color(0,0,0));
        /*=========================END TEXTFIELD NAME TOUR ================*/

        labeldiscountPercentage = new JLabel("Discount Percentage :",JLabel.CENTER);
        labeldiscountPercentage.setFont(new Font("Segoe",Font.BOLD,12));
        labeldiscountPercentage.setBounds(30,130,150,30);

        txtdiscountPercentage = new JTextField();
        txtdiscountPercentage.setBounds(170,128,180,30);
        txtdiscountPercentage.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        txtdiscountPercentage.setText(ComboDTO.getDiscountPercentage());


        sptdiscountPercentage = new JSeparator();
        sptdiscountPercentage.setBounds(170,158,180,10);
        sptdiscountPercentage.setBackground(new Color(0,0,0));

        /*========================= TEXTFIELD PRICE TOUR ===================*/

        buttonSaveNewTour = new JButton(" Save ");
        buttonSaveNewTour.setBackground(new Color(255, 255, 255));
        buttonSaveNewTour.setFont(new Font("Segoe",Font.BOLD,13));
        buttonSaveNewTour.setForeground(Color.BLACK);
        buttonSaveNewTour.setBounds(65,220,100,30);
        buttonSaveNewTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonClearField = new JButton(" Refresh ");
        buttonClearField.setBackground(new Color(255, 255, 255));
        buttonClearField.setFont(new Font("Segoe",Font.BOLD,13));
        buttonClearField.setForeground(Color.BLACK);
        buttonClearField.setBounds(270,220,100,30);
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

        panelAddNewTour.add(labeldiscountPercentage);
        panelAddNewTour.add(txtdiscountPercentage);
        panelAddNewTour.add(sptdiscountPercentage);

//        panelAddNewTour.add(labelSpecification);
//        panelAddNewTour.add(scrollPaneDescription);

        panelAddNewTour.add(buttonClearField);
        panelAddNewTour.add(buttonSaveNewTour);
        /*******************END ADD ELEMENT FOR PANEL ADD NEW TOUR**************************/
        /*********************************END PANEL ADD NEW TOUR*****************************************/
        add(panelAddNewTour);
        setVisible(true);

        txtdiscountPercentage.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String price = txtdiscountPercentage.getText();
                long priceTour = Long.parseLong(price.replace(",",""));
                String priceNewTour = java.text.NumberFormat.getIntegerInstance().format(priceTour);
                txtdiscountPercentage.setText(priceNewTour);
            }
        });

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
                String name = txtNameTour.getText();
                String description = txtdiscountPercentage.getText().replace(",","");
                if(!empty(name)&&!empty(description)){
                    String price_PATTERN = "^[1-9]([0-9])*$";
                    if(Pattern.matches(price_PATTERN, description) == false) {
                        JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng kiểm tra lại Discount Percentage.");
                    } else {
                        if(checkDifferent(name, description)==false){
                            UserDTO user = new UserDTO();
                            String parameter = "{\"id\":"+ComboDTO.getId()+",\"name\":\""+name+"\",\"discountPercentage\":"+description+"}";

                            //APIRequester.sendPUT(parameter, "tourCategories/"+category_dto.getCategoryId(), user.getToken());
                            String response = HandleApiCombos.sendPUTEditCategory(parameter, "combos/"+ComboDTO.getId(), user.getToken());
                            if(response.equals("success")){
                                JOptionPane.showMessageDialog(null, "Sửa thành công");
                                LoadDataTableCombos();
                                dispose();
                            }

                        }else {
                            JOptionPane.showMessageDialog(null, "Combo không có thay đổi");
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
                }
            }
        });

        /*********************************END HANDLE BUTTON ADD NEW TOUR *****************************************/
    }
    public void clearTextField(){
        txtNameTour.setText("");
        txtdiscountPercentage.setText("");
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    public static boolean checkDifferent(String name, String discountPercentage){
        if(name.equals(ComboDTO.getName())== true && discountPercentage.equals(ComboDTO.getDiscountPercentage())){
            return true;
        }
        return false;
    }
}
