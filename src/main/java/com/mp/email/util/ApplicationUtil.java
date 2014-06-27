package com.mp.email.util;

import javax.swing.*;

/**
 * Author: Mariola
 */
public class ApplicationUtil {

    public static void changeLookAndFeelToSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
