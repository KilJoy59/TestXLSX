package main.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    private static final String BILL = "NAMES.xlsx";
    private static final String BANK = "092018N1.xlsx";
    private static final String REPORT = "092018B1.xlsx";

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(StringUtils.cleanPath(file.getOriginalFilename()));
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public static String getBILL() {
        return BILL;
    }

    public static String getBANK() {
        return BANK;
    }

    public static String getREPORT() {
        return REPORT;
    }

}
