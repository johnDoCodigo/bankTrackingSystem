import javax.persistence.*;


@Entity
public class Customer extends Person{
    public Customer(){
        super();
    }

    public Customer(String name, int age) {
        super(name, age);
    }

    //public Accounts

}
