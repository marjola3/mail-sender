package com.mp.email.gui.accounts_table.view;

import com.mp.email.gui.accounts_table.model.AccountsTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

@Component
public class TablePanel extends JPanel {

    @Autowired
    private AccountsTableModel accountsTableModel;

    private JTable table;

    public void init() {
        table = createTable();

        JScrollPane scrollPane = new JScrollPane(table);
        Dimension dimension = new Dimension(560, 430);
        scrollPane.setSize(dimension);
        scrollPane.setPreferredSize(dimension);
        scrollPane.setMinimumSize(dimension);


        add(scrollPane);
    }

    private JTable createTable() {
        JTable table = new JTable(accountsTableModel);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(4);
        column.setCellRenderer(table.getDefaultRenderer(Boolean.class));

        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(3).setPreferredWidth(150);

        return table;
    }


    public AccountsTableModel getAccountsTableModel() {
        return accountsTableModel;
    }

    public JTable getTable() {
        return table;
    }
}
