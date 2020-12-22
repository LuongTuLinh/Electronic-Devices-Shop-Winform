/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronic_devices_shop.GUI;

import electronic_devices_shop.DTO.CategoryDTO;
import electronic_devices_shop.DTO.UserDTO;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

import electronic_devices_shop.Handle_API.HandleApiCategory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author DELL
 */
public class GuiTableCategory extends JPanel{
    CategoryDTO categoryDTO;
    private JTabbedPane tabbedPane;
    /*************************DECLARE OF TABBED PANEL*********************************/

    /*---------------DECLARE PANEL CATEGORY TOUR--------------------*/
    private JPanel panelCategoryTour;
    private JPanel panelFieldCategory;
    private JPanel panelTableCategory;

    private JLabel labelNameCategory;
    private JTextField txtNameCategory;
    private JSeparator sptNameCategory;

    private JButton buttonAddCategory;
    private JButton buttonClearFieldCategory;

    private JButton buttonSaveCategory;
    private JButton buttonCancelCategory;

    public JTable tableCategoryTour;
    public DefaultTableModel modelTableCategoryTour;
    private JScrollPane scrollPaneCategory;

    private JLabel labelSearchCategory;
    private JTextField txtSearchCategory;
    private JLabel labelIconSearchCategory;
    private JLabel labelIconRefreshCategory;

    private JButton buttonEditCategory;
    private JButton buttonDeleteCategory;
    /*--------------END DECLARE PANEL CATEGORY TOUR-----------------------*/
    /************************END DECLARE OF TABBED PANEL******************************/

    public GuiTableCategory(){
        init();
    }
    public void init(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);
        /*========================================= TABBED PANEL ====================================================*/
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(5, 5, 980, 580);
        tabbedPane.setBackground(new Color(0,77,64));
        tabbedPane.setForeground(Color.white);

        /*========================PANEL CATEGORY TOUR====================================*/
        panelCategoryTour = new JPanel();
        panelCategoryTour.setLayout(null);
        panelCategoryTour.setBounds(5,5,970,570);
        panelCategoryTour.setBackground(Color.white);
        /*===================PANEL FIELD CATEGORY TOUR========================*/
        panelFieldCategory = new JPanel();
        panelFieldCategory.setLayout(null);
        panelFieldCategory.setBackground(Color.white);
        panelFieldCategory.setBounds(0,0,400,580);
        //**************TEXTFIELD NAME CATEGORY*******************//
        labelNameCategory = new JLabel("Name Category :",JLabel.CENTER);
        labelNameCategory.setFont(new Font("Segoe",Font.BOLD,12));
        labelNameCategory.setBounds(35,160,120,30);

        txtNameCategory = new JTextField();
        txtNameCategory.setBounds(148,158,200,30);
        txtNameCategory.setBorder(null);
        txtNameCategory.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

        sptNameCategory = new JSeparator();
        sptNameCategory.setBounds(148,188,200,10);
        sptNameCategory.setBackground(new Color(0,0,0));
        //**************END TEXTFIELD NAME CATEGORY*******************//


        buttonAddCategory = new JButton("Add Category");
        buttonAddCategory.setBackground(new Color(255, 255, 255));
        buttonAddCategory.setFont(new Font("Segoe",Font.BOLD,13));
        buttonAddCategory.setForeground(Color.BLACK);
        buttonAddCategory.setBounds(50,305,150,30);
        buttonAddCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonClearFieldCategory = new JButton("Refresh");
        buttonClearFieldCategory.setBackground(new Color(255, 255, 255));
        buttonClearFieldCategory.setFont(new Font("Segoe",Font.BOLD,13));
        buttonClearFieldCategory.setForeground(Color.BLACK);
        buttonClearFieldCategory.setBounds(250,305,105,30);
        buttonClearFieldCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonSaveCategory = new JButton("Save");
        buttonSaveCategory.setBackground(new Color(255, 255, 255));
        buttonSaveCategory.setFont(new Font("Segoe",Font.BOLD,13));
        buttonSaveCategory.setForeground(Color.BLACK);
        buttonSaveCategory.setBounds(50,305,105,30);
        buttonSaveCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonCancelCategory = new JButton("Cancel");
        buttonCancelCategory.setBackground(new Color(255, 255, 255));
        buttonCancelCategory.setFont(new Font("Segoe",Font.BOLD,13));
        buttonCancelCategory.setForeground(Color.BLACK);
        buttonCancelCategory.setBounds(250,305,105,30);
        buttonCancelCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));
        /**************ADD ELEMENT FOR PANEL FIELD CATEGORY TOUR*********************/
        panelFieldCategory.add(labelNameCategory);
        panelFieldCategory.add(txtNameCategory);
        panelFieldCategory.add(sptNameCategory);

        panelFieldCategory.add(buttonAddCategory);
        panelFieldCategory.add(buttonClearFieldCategory);

        panelFieldCategory.add(buttonSaveCategory);
        panelFieldCategory.add(buttonCancelCategory);
        buttonSaveCategory.setVisible(false);
        buttonCancelCategory.setVisible(false);
        /**************END ADD ELEMENT FOR PANEL FIELD CATEGORY TOUR*******************/
        /*===================END PANEL FIELD CATEGORY TOUR========================*/

        /*===================PANEL TABLE CATEGORY TOUR========================*/
        panelTableCategory = new JPanel();
        panelTableCategory.setLayout(null);
        panelTableCategory.setBounds(400,0,580,570);
        panelTableCategory.setBackground(Color.white);

        labelSearchCategory = new JLabel("Search:");
        labelSearchCategory.setBounds(80,21,80,25);

        txtSearchCategory = new JTextField();
        txtSearchCategory.setBounds(145,21,250,25);

        labelIconSearchCategory = new JLabel();
        labelIconSearchCategory.setBounds(410,20,25,25);
        labelIconSearchCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //labelIconSearchCategory.setIcon(new ImageIcon(getClass().getResource("/image/icons8_search_property_25px.png")));

        labelIconRefreshCategory = new JLabel();
        labelIconRefreshCategory.setBounds(443,20,25,25);
        labelIconRefreshCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //labelIconRefreshCategory.setIcon(new ImageIcon(getClass().getResource("/image/icons8_repeat_25px_1.png")));

        Vector<String> columnName = new Vector<>();
        columnName.add("Category Id");
        columnName.add("Name Category");
        modelTableCategoryTour = new DefaultTableModel(columnName, 0);

        tableCategoryTour = new JTable(modelTableCategoryTour);
        LoadDataTableCategory();

        tableCategoryTour.setRowHeight(25);
        tableCategoryTour.setSelectionBackground(new java.awt.Color(246, 44, 91, 180));
        tableCategoryTour.getTableHeader().setReorderingAllowed(false);
        tableCategoryTour.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
        tableCategoryTour.getTableHeader().setOpaque(false);
        tableCategoryTour.getTableHeader().setBackground(new Color(0, 0, 0));
        tableCategoryTour.getTableHeader().setForeground(new Color(255,255,255));
        tableCategoryTour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableCategoryTour.setDefaultEditor(Object.class, null);

//                            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//                            rightRenderer.setHorizontalAlignment(JLabel.CENTER);

        /****************SET SIZE COLUMN OF TABLE***********************/
//        tableCategoryTour.getColumnModel().getColumn(0).setPreferredWidth(100);
//        tableCategoryTour.getColumnModel().getColumn(1).setPreferredWidth(460);
        /****************SET SIZE COLUMN OF TABLE***********************/


        tableCategoryTour.setFont(new Font("Times New Roman",Font.PLAIN,15));

        scrollPaneCategory = new JScrollPane(tableCategoryTour);
        scrollPaneCategory.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(19, 113, 106);
            }
        });
        scrollPaneCategory.setBounds(10,60,560,400);


        buttonEditCategory = new JButton("Edit Category");
        buttonEditCategory.setBackground(new Color(255, 255, 255));
        buttonEditCategory.setFont(new Font("Segoe",Font.BOLD,13));
        buttonEditCategory.setForeground(Color.BLACK);
        buttonEditCategory.setBounds(100,485,150,30);
        buttonEditCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonDeleteCategory = new JButton("Delete Category");
        buttonDeleteCategory.setBackground(new Color(253, 253, 253));
        buttonDeleteCategory.setFont(new Font("Segoe",Font.BOLD,13));
        buttonDeleteCategory.setForeground(Color.BLACK);
        buttonDeleteCategory.setBounds(350,485,150,30);
        buttonDeleteCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /**************ADD ELEMENT FOR PANEL TABLE CATEGORY TOUR*******************/
        panelTableCategory.add(scrollPaneCategory);
        panelTableCategory.add(buttonEditCategory);
        panelTableCategory.add(buttonDeleteCategory);
        panelTableCategory.add(labelSearchCategory);
        panelTableCategory.add(txtSearchCategory);
        panelTableCategory.add(labelIconSearchCategory);
        panelTableCategory.add(labelIconRefreshCategory);
        /**************END ADD ELEMENT FOR PANEL TABLE ATTRACTION TOUR*******************/
        /*===================END PANEL TABLE ATTRACTION TOUR========================*/

        /**************ADD PANEL FOR PANEL ATTRACTION TOUR*********************/
        panelCategoryTour.add(panelFieldCategory);
        panelCategoryTour.add(panelTableCategory);
        /**************END ADD PANEL FOR PANEL ATTRACTION TOUR*********************/
        /*========================END PANEL CATEGORY TOUR====================================*/

        /**************ADD PANEL FOR TABBED PANEL*********************/
        tabbedPane.addTab("Category Product", panelCategoryTour);
        /**************END ADD PANEL FOR TABBED PANEL*********************/
        /*======================================== END TABBED PANEL =================================================*/
        add(tabbedPane);


        /*========================HANDLE CLICK BUTTON OF CATEGORY====================================*/
        labelIconRefreshCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoadDataTableCategory();
            }
        });

        labelIconSearchCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nameCategory = txtSearchCategory.getText();
                if(!empty(nameCategory)){
                    nameCategory = encodeValue(nameCategory);
                }
                String parameter = "&Filters[Name]=\""+nameCategory+"\"&FilterConditions[Name]=like";
                LoadDataTableCategoryAfterSearch(parameter);
            }
        });

        buttonClearFieldCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTextFieldCategory();
            }
        });

        buttonAddCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nameCategory = txtNameCategory.getText();
                if(!empty( nameCategory ) ) {

                    UserDTO user = new UserDTO();

                    String parameter = "{\"name\":\""+nameCategory+"\"}";
                    //APIRequester.sendPOST(parameter, "tourCategories", user.getToken());
                    String response = HandleApiCategory.sendPostAddCategory(parameter, "categories", user.getToken());
                    if(response.equals("success")==true){
                        LoadDataTableCategory();
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                        clearTextFieldCategory();
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                }

            }
        });
        buttonDeleteCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableCategoryTour.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn thể loại cần xoá");
                } else {
                    int result = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xoá thể loại này?", "Thông báo",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        UserDTO user = new UserDTO();
                        String tourId = (tableCategoryTour.getModel().getValueAt(row, 0).toString());
                        //APIRequester.sendDelete("","tourCategories/"+tourId, user.getToken());
                        String response = HandleApiCategory.sendDeleteCategory("","categories/"+tourId, user.getToken());
                        if(response.equals("success") == true){
                            LoadDataTableCategory();
                            JOptionPane.showMessageDialog(null, "Xoá thể loại thành công");
                        }
                    }else if (result == JOptionPane.NO_OPTION){

                    }else {

                    }


                }

            }
        });

        buttonEditCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableCategoryTour.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn thể loại cần sửa");
                }else {
                    String tourId = (tableCategoryTour.getModel().getValueAt(row, 0).toString());
                    String name = (tableCategoryTour.getModel().getValueAt(row, 1).toString());
                    buttonAddCategory.setVisible(false);
                    buttonClearFieldCategory.setVisible(false);
                    buttonSaveCategory.setVisible(true);
                    buttonCancelCategory.setVisible(true);
                    txtNameCategory.setText(name);
                     categoryDTO = new CategoryDTO(tourId, name);
                }
            }
        });
        buttonCancelCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTextFieldCategory();
                buttonSaveCategory.setVisible(false);
                buttonCancelCategory.setVisible(false);
                buttonAddCategory.setVisible(true);
                buttonClearFieldCategory.setVisible(true);
            }
        });

        buttonSaveCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = txtNameCategory.getText();
                if(checkDifferent(name, categoryDTO)==false){
                    UserDTO user = new UserDTO();
                    String parameter = "{\"id\":"+categoryDTO.getCategoryId()+",\"name\":\""+name+"\"}";

                    //APIRequester.sendPUT(parameter, "tourCategories/"+category_dto.getCategoryId(), user.getToken());
                    String response = HandleApiCategory.sendPUTEditCategory(parameter, "categories/"+categoryDTO.getCategoryId(), user.getToken());
                    if(response.equals("success")){
                        clearTextFieldCategory();
                        LoadDataTableCategory();
                        buttonSaveCategory.setVisible(false);
                        buttonCancelCategory.setVisible(false);
                        buttonAddCategory.setVisible(true);
                        buttonClearFieldCategory.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Thể loại không có thay đổi");
                }
            }
        });
        /*========================END HANDLE CLICK BUTTON OF CATEGORY====================================*/
    }

    public void LoadDataTableCategory(){
        UserDTO user = new UserDTO();
        JSONArray json = new JSONArray(HandleApiCategory.GetAllCategory("categories?Page=1", user.getToken()));
//        Vector<Vector<String>> dataList = new Vector<>();
        modelTableCategoryTour.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(jsonObj.get("name").toString());

                modelTableCategoryTour.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GuiTableCategory.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        tableCategoryTour.setModel(modelTableCategoryTour);
    }

    public void LoadDataTableCategoryAfterSearch(String parameter){
//        User_DTO user = new User_DTO();
//        JSONArray json = new JSONArray(Handle_API_Tour_Category.Fetch_API_Tour_Category("tourCategories?Page=1&Limit=100"+parameter, user.getToken()));
//        if(json.length() >= 1) {
//            modelTableCategoryTour.setRowCount(0);
//            for (int i = 0; i < json.length(); i++) {
//
//                JSONObject jsonObj;
//                try {
//                    jsonObj = json.getJSONObject(i);
//                    Vector<String> data = new Vector<>();
//
//                    data.add(jsonObj.get("id").toString());
//                    data.add(jsonObj.get("name").toString());
//
//                    modelTableCategoryTour.addRow(data);
//                } catch (JSONException ex) {
//                    Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            tableCategoryTour.setModel(modelTableCategoryTour);
//        }else {
//            JOptionPane.showMessageDialog(null, "Không tìm thấy thể loại cần tìm");
//        }

    }

    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }

    public static boolean checkDifferent(String name, CategoryDTO categoryDTO){
        if(name.equals(categoryDTO.getCategoryName())== true ){
            return true;
        }
        return false;
    }

    public void clearTextFieldCategory(){
        txtNameCategory.setText("");
    }
    public static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
