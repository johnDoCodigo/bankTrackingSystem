package bankTracking;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name="Customer")
public class Customer extends Person {


    @ManyToMany(mappedBy = "customers")
    private List<Account> accounts = new ArrayList<>();

    public Customer(){
        super();
    }

    public Customer(String name, int age) {
        super(name, age);
    }

    public void setAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public void showAccounts () {
        getAccounts().forEach(c-> System.out.println(c.getBankName().concat(" With ") + c.getBalance() + " $"));
    }

    public void print() {
        System.out.println("Customer{" +
                "id= " + getPersonId() +
                ", name = " +getName() +
                ", age = " + getAge() + " }"
                );
    }

}
