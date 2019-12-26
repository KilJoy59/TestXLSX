package main.entity;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "second_account_number")
    private String secondAccountNumber;

    @Column(name = "account_name")
    private String accountName;

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecondAccountNumber() {
        return secondAccountNumber;
    }

    public void setSecondAccountNumber(String secondAccountNumber) {
        this.secondAccountNumber = secondAccountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
