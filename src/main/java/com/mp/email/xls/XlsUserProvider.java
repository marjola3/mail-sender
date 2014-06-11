package com.mp.email.xls;


import com.mp.email.model.User;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mp.email.xls.UserColumnNames.*;

public class XlsUserProvider {
    @Value("${emails.excel.fileName}")
    private String usersFileName;

    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();

        File xlsUserFile = getXlsUserFile();
        FileInputStream fis = new FileInputStream(xlsUserFile);

        XSSFWorkbook allSheets = new XSSFWorkbook(fis);
        XSSFSheet sheet = allSheets.getSheetAt(0);

        boolean isFirstLine = true;
        for (Row row : sheet) {
            if(isFirstLine){
                isFirstLine = false;
                continue;
            }
            User user = getUserFromRow(row);
            users.add(user);
        }

        return users;
    }

    private User getUserFromRow(Row row) {
        String name = row.getCell(USER_NAME).getStringCellValue();
        String surname = row.getCell(USER_SURNAME).getStringCellValue();
        String mail = row.getCell(USER_EMAIL).getStringCellValue();

        return new User(name, surname, mail);
    }

    public File getXlsUserFile() {
        File file = new File(usersFileName);

        if (!file.exists()) {
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setFileFilter(new XlsFileFilter());
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            } else {
                System.exit(0);
            }
        }

        return file;
    }

    public void saveAllUser(List<User> users) {
        System.out.println("Zapisuję " + users);
    }
}
