package main.repository;

import main.entity.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface BanksRepository extends CrudRepository<Bank,Long> {

}
