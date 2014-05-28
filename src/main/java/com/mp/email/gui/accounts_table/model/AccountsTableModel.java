package com.mp.email.gui.accounts_table.model;


import com.mp.email.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountsTableModel extends AbstractTableModel{
    private List<User> users;

    private String[] columnNames;

    @Value("${accountsFrame.column.name}")
    private String name;

    @Value("${accountsFrame.column.surname}")
    private String surname;

    @Value("${accountsFrame.column.email}")
    private String email;

    @Value("${accountsFrame.column.isSending}")
    private String isSending;

    public void init(){
        users = new ArrayList<User>();
        columnNames = new String[] {name, surname, email, isSending};
    }

    public void addUser(User user) {
        users.add(user);
        fireTableDataChanged();
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return users.get(rowIndex).getName();
            case 1:
                return users.get(rowIndex).getSurname();
            case 2:
                return users.get(rowIndex).getEmail();
            case 3:
                return true;
            default:
                return "";
        }

    }
}
