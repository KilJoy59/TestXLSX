package main.repository;

import main.entity.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface BillsRepository extends CrudRepository<Bill,Long> {
}
