package electronic_devices_shop.GUI;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;


public class Gui_Detail_Product extends JFrame {

    private JPanel panelAddNewTour;

    private JSeparator sptAboveLeftInHeader;
    private JSeparator sptUnderLeftInHeader;
    private JSeparator sptAboveRightInHeader;
    private JSeparator sptUnderRightInHeader;
    private JLabel lbTitle;

    private JLabel labelNameTour;
    private JTextField txtNameTour;
    private JSeparator sptNameTour;
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

    public Gui_Detail_Product(){
        GUI();
    }
    public void GUI(){
        setSize(450, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Detail Product Is Selected");
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

        lbTitle = new JLabel("Detail Product");
        lbTitle.setBounds(160,18,150,25);
        lbTitle.setForeground(new Color(80, 80, 80));
        lbTitle.setFont(new Font("Times New Roman",1,19));

        /*========================= TEXTFIELD NAME TOUR ========================*/


        /*****************ADD ELEMENT FOR PANEL ADD NEW TOUR*****************************/
        panelAddNewTour.add(sptAboveLeftInHeader);
        panelAddNewTour.add(sptUnderLeftInHeader);
        panelAddNewTour.add(sptAboveRightInHeader);
        panelAddNewTour.add(sptUnderRightInHeader);
        panelAddNewTour.add(lbTitle);


        /*******************END ADD ELEMENT FOR PANEL ADD NEW TOUR**************************/
        /*********************************END PANEL ADD NEW TOUR*****************************************/
        add(panelAddNewTour);
        setVisible(true);

        /********************************* HANDLE BUTTON ADD NEW TOUR *****************************************/

        /*********************************END HANDLE BUTTON ADD NEW TOUR *****************************************/
    }
    public static void loadCategoryTourComboBox(){
//        User_DTO user = new User_DTO();
//        JSONArray array = new JSONArray(Handle_API_Tour_Category.Fetch_API_Tour_Category("tourCategories?Page=1&Limit=100", user.getToken()));
//        for(int i = 0; i < array.length(); i++){
//            try {
//                JSONObject jsonObject = (JSONObject) array.get(i);
//                String id = jsonObject.get("id").toString();
//                String name = jsonObject.get("name").toString();
//                comboBoxCategoryTour.addItem(new Tour_Category_DTO(id, name));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }

    }
    public void clearTextField(){
        txtNameTour.setText("");
        txtPriceTour.setText("");
        textAreaDescription.setText("");
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
}
