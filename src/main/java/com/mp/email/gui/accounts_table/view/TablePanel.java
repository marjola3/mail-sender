package com.mp.email.gui.accounts_table.view;

import com.mp.email.gui.accounts_table.model.AccountsTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.TableColumn;

@Component
public class TablePanel extends JPanel {

    @Autowired
    private AccountsTableModel accountsTableModel;

    public void init() {
        JTable table = createTable();

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }

    private JTable createTable() {
        JTable table = new JTable(accountsTableModel);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        TableColumn column = table.getColumnModel().getColumn(3);
        column.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        return table;
    }


}
