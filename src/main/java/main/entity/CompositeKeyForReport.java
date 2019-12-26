package main.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompositeKeyForReport implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "second_account_number")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Bank bank;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_account_number")
    private Bill bill;

    public CompositeKeyForReport() {
    }

    public CompositeKeyForReport(Bank bank, Bill bill) {
        this.bank = bank;
        this.bill = bill;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeKeyForReport that = (CompositeKeyForReport) o;
        return bank.equals(that.bank) &&
                bill.equals(that.bill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank, bill);
    }
}
