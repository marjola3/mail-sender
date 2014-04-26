package xls;


import model.User;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class XlsUserProvider {
    @Value("${emails.excel.fileName}")
    private String usersFileName;

    public List<User> getAllUsers() {
        File xlsUserFile = getXlsUserFile();
        return null;
    }

    public File getXlsUserFile() {
        File file = new File(usersFileName);

        if(!file.exists()) {
            JFileChooser fileChooser = new JFileChooser(".");
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                System.out.println("Wczytano plik");
            }
        }

        return file;
    }
}
