package main.service;

import main.entity.Bank;
import main.repository.BanksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    BanksRepository banksRepository;

    @Transactional
    public void save(Bank bank) {
        banksRepository.save(bank);
    }
}
