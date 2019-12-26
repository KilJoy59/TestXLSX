package main.entity;

import javax.persistence.*;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "registration_account_number")
    private String registrationAccountNumber;

    @Column(name = "organization_name")
    private String organizationName;

    public Bank() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationAccountNumber() {
        return registrationAccountNumber;
    }

    public void setRegistrationAccountNumber(String registrationAccountNumber) {
        this.registrationAccountNumber = registrationAccountNumber;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
