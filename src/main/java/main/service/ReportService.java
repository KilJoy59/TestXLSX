package main.service;

import main.entity.CompositeKeyForReport;
import main.entity.Report;
import main.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportService {


    public ReportService( ReportRepository reportRepository) {
        this.reportRepository =reportRepository;
    }

    @Autowired
    private ReportRepository reportRepository;

    @Transactional
    public void save(Report report) {
         reportRepository.save(report);
    }
}
