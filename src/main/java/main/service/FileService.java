package main.service;

import main.entity.Bank;
import main.entity.Bill;
import main.entity.CompositeKeyForReport;
import main.entity.Report;
import main.util.FileUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class FileService {
    @Autowired
    BankService bankService;

    @Autowired
    BillService billService;

    @Autowired
    ReportService reportService;

    private List<File> unzipFiles = new ArrayList<>();

    public void unZip(MultipartFile zipFile) throws IOException {
        File newFile = FileUtil.convert(zipFile);
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(newFile))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                File unZippedFile = new File(zipEntry.getName());
                unzipFiles.add(unZippedFile);
                FileOutputStream fileOutputStream = new FileOutputStream(unZippedFile.getAbsolutePath());
                int len;
                byte[] content = new byte[1024];
                while ((len = zipInputStream.read(content)) > 0) {
                    fileOutputStream.write(content, 0, len);
                }
                fileOutputStream.close();
            }
            zipInputStream.closeEntry();
        }
    }

    public List<File> getUnzipFiles() {
        return unzipFiles;
    }

    public void parseXLSX(File file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file.getAbsolutePath()));
        XSSFSheet list = workbook.getSheetAt(0);
        Iterator<Row> iterator = list.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (row.getRowNum()!= 0) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            break;
                        case Cell.CELL_TYPE_STRING:
                            break;
                    }
                }
                    if (file.getName().equals(FileUtil.getBILL())) {
                        Bill bill = new Bill();
                        bill.setSecondAccountNumber(row.getCell(0).getStringCellValue());
                        bill.setAccountName(row.getCell(1).getStringCellValue());
                        billService.save(bill);
                    }

                    if (file.getName().equals(FileUtil.getBANK())) {
                        Bank bank = new Bank();
                        bank.setRegistrationAccountNumber(row.getCell(0).getStringCellValue());
                        bank.setOrganizationName(row.getCell(1).getStringCellValue());
                        bankService.save(bank);
                    }

                    if (file.getName().equals(FileUtil.getREPORT())) {
                        Report report = new Report();
                        Bank bank = new Bank();
                        bank.setRegistrationAccountNumber( row.getCell(0).getStringCellValue());
                        Bill bill = new Bill();
                        bill.setSecondAccountNumber( row.getCell(1).getStringCellValue());
                        CompositeKeyForReport key = new CompositeKeyForReport();
                        key.setBill(bill);
                        key.setBank(bank);
                        report.setCompositeKeyForReport(key);
                        report.setIncomingBalancesRubles(row.getCell(2).getStringCellValue());
                        report.setIncomingBalancesForeignCurrency(row.getCell(3).getStringCellValue());
                        report.setIncomingBalancesTotal(row.getCell(4).getStringCellValue());
                        report.setDebitTurnoverForReportingPeriodRubles(row.getCell(5).getStringCellValue());
                        report.setDebitTurnoverForReportingPeriodForeignCurrency(row.getCell(6).getStringCellValue());
                        report.setDebitTurnoverForReportingPeriodTotal(row.getCell(7).getStringCellValue());
                        report.setCreditTurnoverForReportingPeriodRubles(row.getCell(8).getStringCellValue());
                        report.setCreditTurnoverForReportingPeriodForeignCurrency(row.getCell(9).getStringCellValue());
                        report.setCreditTurnoverForReportingPeriodTotal(row.getCell(10).getStringCellValue());
                        report.setOutgoingBalancesRubles(row.getCell(11).getStringCellValue());
                        report.setOutgoingBalancesForeignCurrency(row.getCell(12).getStringCellValue());
                        report.setOutgoingBalancesTotal(row.getCell(13).getStringCellValue());
                        reportService.save(report);

                    }
            }

        }

    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }

}
