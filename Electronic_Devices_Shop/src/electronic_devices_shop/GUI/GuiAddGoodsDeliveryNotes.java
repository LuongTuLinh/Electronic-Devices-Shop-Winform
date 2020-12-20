package electronic_devices_shop.GUI;


import electronic_devices_shop.DTO.CategoryDTO;
import electronic_devices_shop.DTO.UserDTO;
import electronic_devices_shop.Handle_API.HandleApiCategory;
import electronic_devices_shop.Handle_API.HandleApiProduct;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import static electronic_devices_shop.GUI.Gui_Table_List_Products.LoadDataTable;


public class GuiAddGoodsDeliveryNotes extends JFrame {

    private JPanel panelAddNewTour;

    private JSeparator sptAboveLeftInHeader;
    private JSeparator sptUnderLeftInHeader;
    private JSeparator sptAboveRightInHeader;
    private JSeparator sptUnderRightInHeader;
    private JLabel lbTitle;

    private JLabel labelNameTour;
    private JTextField txtNameTour;
    private JSeparator sptNameTour;





    private JLabel labelSpecification;
    private JTextArea textAreaDescription;
    private JScrollPane scrollPaneDescription;

//    private static JComboBox<Tour_Category_DTO> comboBoxCategoryTour;

    private JButton buttonSaveNewTour;
    private JButton buttonClearField;

    public GuiAddGoodsDeliveryNotes(){
        GUI();
    }
    public void GUI(){
        setSize(450, 345);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Add Goods Delivery Notes");
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

        lbTitle = new JLabel("Add Goods Delivery Notes");
        lbTitle.setBounds(110,18,220,25);
        lbTitle.setForeground(new Color(80, 80, 80));
        lbTitle.setFont(new Font("Times New Roman",1,18));

        /*========================= TEXTFIELD NAME TOUR ========================*/
        labelNameTour = new JLabel(" Supplier Name :",JLabel.CENTER);
        labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
        labelNameTour.setBounds(5,50,100,30);

        txtNameTour = new JTextField();
        txtNameTour.setBounds(120,48,270,30);
        txtNameTour.setBorder(null);
        txtNameTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

        sptNameTour = new JSeparator();
        sptNameTour.setBounds(115,78,300,10);
        sptNameTour.setBackground(new Color(0,0,0));
        /*=========================END TEXTFIELD NAME TOUR ================*/

        /*========================= TEXTFIELD PRICE TOUR ===================*/

        labelSpecification = new JLabel("Description :",JLabel.CENTER);
        labelSpecification.setFont(new Font("Segoe",Font.BOLD,12));
        labelSpecification.setBounds(5,100,120,30);

        textAreaDescription = new JTextArea(10, 10);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaDescription.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));

        scrollPaneDescription = new JScrollPane(textAreaDescription);
        scrollPaneDescription.setBounds(45,135,360,100);

        buttonSaveNewTour = new JButton(" Add New ");
        buttonSaveNewTour.setBackground(new Color(255, 255, 255));
        buttonSaveNewTour.setFont(new Font("Segoe",Font.BOLD,13));
        buttonSaveNewTour.setForeground(Color.BLACK);
        buttonSaveNewTour.setBounds(65,250,100,30);
        buttonSaveNewTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonClearField = new JButton(" Refresh ");
        buttonClearField.setBackground(new Color(255, 255, 255));
        buttonClearField.setFont(new Font("Segoe",Font.BOLD,13));
        buttonClearField.setForeground(Color.BLACK);
        buttonClearField.setBounds(270,250,100,30);
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
                GuiAddProductToGoodsDeliveryNotes addProductToGoodsDeliveryNotes = new GuiAddProductToGoodsDeliveryNotes();
                dispose();
            }
        });

        /*********************************END HANDLE BUTTON ADD NEW TOUR *****************************************/
    }
    public void clearTextField(){
        txtNameTour.setText("");
        textAreaDescription.setText("");
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
}
