package com.mp.email.gui.accounts_table.view;

import com.mp.email.gui.accounts_table.model.AccountsTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class AccountsPanel extends JPanel {

    @Autowired
    private AccountsTableModel accountsTableModel;

    public void init() {

        JTable table = new JTable(accountsTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }


}
