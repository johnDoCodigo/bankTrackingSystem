
import javax.persistence.*;

@Entity
@Table (name="accounts")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer balance;
    private String accountName;
    private String accountType;

    //private Date account_Date_Initiation;

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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Accounts(Integer id, Integer balance, String accountName, String accountType) {
        this.id = id;
        this.balance = balance;
        this.accountName = accountName;
        this.accountType = accountType;
    }
}
