package electronic_devices_shop.GUI;

import javax.swing.*;

public class Gui_Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Gui_Login login = new Gui_Login();
    }
}
