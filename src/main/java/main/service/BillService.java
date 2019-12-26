package main.service;

import main.entity.Bill;
import main.repository.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillService {

    @Autowired
    BillsRepository billsRepository;

    @Transactional
    public void save(Bill bill) {
        billsRepository.save(bill);
    }
}
