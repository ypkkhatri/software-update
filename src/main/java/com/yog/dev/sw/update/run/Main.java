package com.yog.dev.sw.update.run;

import com.yog.dev.sw.update.ui.JMainDialog;

/**
 *
 * @author Yougeshwar
 */
public class Main {

    public static void main(String[] args) {
//        final String[] args = new String[] {"Test", "49", "http://techmwh.com/updates/obutech/update.xml"};
        if (args == null || args.length < 3) {
            javax.swing.JOptionPane.showMessageDialog(null, "Invalid input length");
            return;
        }
        java.awt.EventQueue.invokeLater(() -> {
            JMainDialog dialog = new JMainDialog(args[0], args[1], args[2]);
            dialog.init();
            dialog.setVisible(true);
        });
    }

}
