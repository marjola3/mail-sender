package com.mp.email.gui.add_user.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Author: Mariola
 */
@Component
public class AddUserBtnPanel extends JPanel{

    private JButton saveBtn;

    private JButton cancelBtn;

    @Value("${gui.addUser.AddUserBtnPanel.saveBtnText}")
    private String saveBtnText;

    @Value("${gui.addUser.AddUserBtnPanel.cancelBtnText}")
    private String cancelBtnText;

    public void init(){
        saveBtn = new JButton(saveBtnText);
        cancelBtn = new JButton(cancelBtnText);

        add(saveBtn);
        add(cancelBtn);
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }
}
