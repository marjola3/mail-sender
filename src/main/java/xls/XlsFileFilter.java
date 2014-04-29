package xls;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class XlsFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return f.isDirectory() ||
               f.getName().endsWith(".xls") ||
               f.getName().endsWith(".xlsx");
    }

    @Override
    public String getDescription() {
        return "Pliki xlsx, xls";
    }
}
