package com.mp.email.xls;


import com.mp.email.log.AutowiredLogger;
import com.mp.email.model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.*;
import java.io.*;
import java.util.*;

import static com.mp.email.xls.UserColumnNames.*;

public class XlsUserProvider {

    @AutowiredLogger
    private Logger logger;

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

    public void saveAllUser(List<User> users) throws Exception {
        logger.info("Saving users");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        int rowNum = 0;

        Row row = sheet.createRow(rowNum++);

        Cell userNameCell = row.createCell(USER_NAME);
        Cell userSurnameCell = row.createCell(USER_SURNAME);
        Cell userEmailCell = row.createCell(USER_EMAIL);

        userNameCell.setCellValue("Imię");
        userSurnameCell.setCellValue("Nazwisko");
        userEmailCell.setCellValue("Email");

        for (User user : users) {
            row = sheet.createRow(rowNum++);

            userNameCell = row.createCell(USER_NAME);
            userSurnameCell = row.createCell(USER_SURNAME);
            userEmailCell = row.createCell(USER_EMAIL);

            userNameCell.setCellValue(user.getName());
            userSurnameCell.setCellValue(user.getSurname());
            userEmailCell.setCellValue(user.getEmail());

        }

        FileOutputStream out = new FileOutputStream(new File(usersFileName));
        workbook.write(out);
        out.close();
        logger.info("Users have been saved");

    }
}
