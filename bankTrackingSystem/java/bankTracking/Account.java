package bankTracking;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToMany
    private List<Customer> customers = new ArrayList<>();
    private Integer balance;
    private String bankName;

    public Account(Integer balance, String bankName) {
        this.balance = balance;
        this.bankName = bankName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void showBalance() {
        System.out.println(this.balance);
    }

    public void showBankName() {
        System.out.println(this.bankName);
    }



    public void print() {
        System.out.println("Account{" +
                "id=" + id +
                ", bank=" + bankName +
                ", balance=" + balance +
                '}');
    }
}
