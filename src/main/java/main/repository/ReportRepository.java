package main.repository;

import main.entity.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ReportRepository extends CrudRepository<Report,Long> {
}
