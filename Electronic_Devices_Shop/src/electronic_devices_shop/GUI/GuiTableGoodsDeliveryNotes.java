/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronic_devices_shop.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class GuiTableGoodsDeliveryNotes extends JPanel{
    /*************DECLARE JPANEL********************/
    private JPanel panelHeader;
    private JPanel panelContent;
    private JPanel panelButtonHandleTour;

    /*************END DECLARE JPANEL********************/

    /*************DECLARE ELEMENT JPANEL HEADER********************/
    private JLabel labelSearch;
    private JTextField txtSearch;
    private JComboBox<String> comboBoxStatusTour;
    private DefaultListCellRenderer listRenderer;
    private JButton buttonSearchTour;

    /*************END DECLARE ELEMENT JPANEL HEADER********************/

    /*************DECLARE ELEMENT JPANEL PANEL BUTTON HANDLE TOUR********************/
    private JButton btnEditTour;
    private JButton btnDeleteTour;
    private JButton btnAddTour;
    private JButton btnSaveTour;
    /*************END DECLARE ELEMENT JPANEL PANEL BUTTON HANDLE TOUR********************/

    /*************DECLARE ELEMENT JPANEL CONTENT********************/
    public static JTable tableTour;
    public static DefaultTableModel modelTableTour;
    private JScrollPane scrollPane;
    /*************DECLARE ELEMENT JPANEL CONTENT********************/
    public GuiTableGoodsDeliveryNotes(){
        init();
    }
    public void init(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);

        /*------------------------PANEL HEADER INCLUDE BUTTON AND SEARCH-----------------------------*/
        panelHeader = new JPanel();
        panelHeader.setLayout(null);
        panelHeader.setBounds(5, 10, 980, 70);
        panelHeader.setBackground(Color.white);
        Border blackline = BorderFactory.createTitledBorder("Tìm kiếm");
        panelHeader.setBorder(blackline);

        labelSearch = new JLabel("Tìm kiếm:");
        labelSearch.setBounds(30,19,80,25);

        txtSearch = new JTextField();
        txtSearch.setBounds(95,19,250,25);

//                lbIconSearch = new JLabel();
//                lbIconSearch.setBounds(360,18,25,25);
//                lbIconSearch.setIcon(new ImageIcon(getClass().getResource("/image/icons8_Search_in_Browser_25px.png")));

        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items

        buttonSearchTour = new JButton("Tìm kiếm");
        buttonSearchTour.setBackground(new Color(32, 171, 214));
        buttonSearchTour.setFont(new Font("Segoe",Font.BOLD,13));
        buttonSearchTour.setForeground(Color.WHITE);
        buttonSearchTour.setBounds(810,16,130,30);
        buttonSearchTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /****************ADD ELEMENT FOR PANEL HEADER***********************/
        panelHeader.add(labelSearch);
        panelHeader.add(txtSearch);
        //panelHeader.add(lbIconSearch);
//        panelHeader.add(comboBoxStatusTour);
        panelHeader.add(buttonSearchTour);
        /***************END ADD ELEMENT FOR PANEL HEADER**********************/

        /*------------------------END PANEL HEADER INCLUDE BUTTON AND SEARCH-----------------------------*/

        /*------------------------PANEL BUTTON HANDLE TOUR(ADD, EDIT, DELETE, SAVE)-----------------------------*/
        panelButtonHandleTour = new JPanel();
        panelButtonHandleTour.setLayout(null);
        panelButtonHandleTour.setBounds(0, 520, 990, 70);
        panelButtonHandleTour.setBackground(Color.white);
//        Border borderPanelButton = BorderFactory.createTitledBorder("Xử lý sản phẩm");
//        panelButtonHandleTour.setBorder(borderPanelButton);


        btnAddTour = new JButton("Add Goods Delivery ");
        btnAddTour.setBackground(new Color(255, 255, 255));
        btnAddTour.setFont(new Font("Segoe",Font.BOLD,13));
        btnAddTour.setForeground(Color.BLACK);
        btnAddTour.setBounds(100,20,170,30);
        btnAddTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnEditTour = new JButton("Edit Goods Delivery ");
        btnEditTour.setBackground(new Color(255, 255, 255));
        btnEditTour.setFont(new Font("Segoe",Font.BOLD,13));
        btnEditTour.setForeground(Color.BLACK);
        btnEditTour.setBounds(300,20,170,30);
        btnEditTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnDeleteTour = new JButton("Delete Goods Delivery ");
        btnDeleteTour.setBackground(new Color(255, 255, 255));
        btnDeleteTour.setFont(new Font("Segoe",Font.BOLD,13));
        btnDeleteTour.setForeground(Color.BLACK);
        btnDeleteTour.setBounds(500,20,180,30);
        btnDeleteTour.setCursor(new Cursor(Cursor.HAND_CURSOR));


        btnSaveTour = new JButton("Detail Goods Delivery ");
        btnSaveTour.setBackground(new Color(255, 255, 255));
        btnSaveTour.setFont(new Font("Segoe",Font.BOLD,13));
        btnSaveTour.setForeground(Color.BLACK);
        btnSaveTour.setBounds(720,20,175,30);
        btnSaveTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        /****************ADD ELEMENT FOR PANEL BUTTON HANDLE TOUR***********************/
        panelButtonHandleTour.add(btnEditTour);
        panelButtonHandleTour.add(btnDeleteTour);
        panelButtonHandleTour.add(btnAddTour);
        panelButtonHandleTour.add(btnSaveTour);
        /****************END ADD ELEMENT FOR PANEL BUTTON HANDLE TOUR***********************/
        /*------------------------END PANEL BUTTON HANDLE TOUR(ADD, EDIT, DELETE, SAVE)-----------------------------*/

        /*------------------------PANEL CONTENT INCLUDE TABLE TOURS MANAGEMENT-----------------------------*/
        panelContent = new JPanel();
        panelContent.setLayout(null);
        panelContent.setBackground(Color.white);
        panelContent.setBounds(0, 120, 990, 420);

        Vector<String> columnNames = new Vector<>();
        columnNames.add("Id");
        columnNames.add("Name");
        columnNames.add("Description");
        columnNames.add("Total Price");
        columnNames.add("Status");
        String data[][] = { { "101", "adda asdf sdfa", "adf adf daf", "afdf adf", "131314" }};
        String column[] = { " Id", " Name", " Description", " Status", "Total Price" };


        //modelTableTour = new DefaultTableModel(columnNames, 0);
        tableTour = new JTable(data, column);



        tableTour.setRowHeight(25);
        tableTour.setSelectionBackground(new java.awt.Color(232, 50, 129, 180));
        tableTour.getTableHeader().setReorderingAllowed(false);
        tableTour.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
        tableTour.getTableHeader().setOpaque(false);
        tableTour.getTableHeader().setBackground(new Color(0,0,0));
        tableTour.getTableHeader().setForeground(new Color(255,255,255));
        tableTour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableTour.setDefaultEditor(Object.class, null);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer rightRendererPrice = new DefaultTableCellRenderer();
        rightRendererPrice.setHorizontalAlignment(JLabel.CENTER);

        /****************SET SIZE COLUMN OF TABLE***********************/
//        tableTour.getColumnModel().getColumn(0).setPreferredWidth(100);
//        tableTour.getColumnModel().getColumn(1).setPreferredWidth(550);
//        tableTour.getColumnModel().getColumn(2).setPreferredWidth(130);
//        tableTour.getColumnModel().getColumn(3).setPreferredWidth(80);
//        tableTour.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
//        tableTour.getColumnModel().getColumn(4).setPreferredWidth(95);
//        tableTour.getColumnModel().getColumn(4).setCellRenderer(rightRendererPrice);
        /****************SET SIZE COLUMN OF TABLE***********************/

        tableTour.setFont(new Font("Times New Roman",Font.PLAIN,15));

        scrollPane = new JScrollPane(tableTour);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(19, 113, 106);
            }
        });
        scrollPane.setBounds(20,0,955,400);

        /****************ADD ELEMENT FOR PANEL CONTENT**************************/
        panelContent.add(scrollPane);
        /***************END ADD ELEMENT FOR PANEL CONTENT*************************/
        /*------------------------END PANEL CONTENT INCLUDE TABLE TOURS MANAGEMENT-----------------------------*/

        /*******************ADD ELEMENT FOR PANEL MAIN***********************/
        add(panelHeader);
        add(panelContent);
        add(panelButtonHandleTour);

        /******************END ADD ELEMENT FOR PANEL MAIN************************/

        /*------------------------HANDLE EVENT ONCLICK MOUSE BUTTON-----------------------------*/


        btnEditTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int row = tableTour.getSelectedRow();

                if(row == -1)
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn Tour cần xem");
                }
                else
                {

                }
            }
        });

        btnSaveTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableTour.getSelectedRow();

                if(row == -1)
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn Tour cần xem");
                }
                else
                {

                }
            }
        });

        btnAddTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GuiAddGoodsDeliveryNotes addGoodsDeliveryNotes = new GuiAddGoodsDeliveryNotes();
            }
        });

        btnDeleteTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableTour.getSelectedRow();

                if(row == -1)
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn Tour cần xoá");
                }
                else
                {
                    int result = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xoá tour này?", "Thông báo",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){

                    }else if (result == JOptionPane.NO_OPTION){

                    }else {

                    }

                }
            }
        });
        /*------------------------END HANDLE EVENT ONCLICK MOUSE BUTTON-----------------------------*/
    }

}
