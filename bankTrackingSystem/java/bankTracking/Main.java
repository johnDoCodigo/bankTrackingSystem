package bankTracking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bankTrackingSystem");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //create accounts and customers
        Account a1 = new Account(100,"Bank1");
        Account a2 = new Account(200,"Bank2");
        Account a3 = new Account(300,"Bank3");
        Account a4 = new Account(400,"Bank4");

        Customer c1 = new Customer("Joao",20);
        Customer c2 = new Customer("Jon",21);
        Customer c3 = new Customer("Reina",22);
        Customer c4 = new Customer("Marques",23);

        em.getTransaction().commit();

        em.getTransaction().begin();
        //set to eachOther

        a1.setCustomer(c4);
        a2.setCustomer(c3);
        a3.setCustomer(c2);
        a4.setCustomer(c1);
        a1.setCustomer(c1);
        a2.setCustomer(c2);

        c1.setAccount(a4);
        c1.setAccount(a1);
        c2.setAccount(a2);
        c2.setAccount(a3);
        c3.setAccount(a2);
        c4.setAccount(a1);

        //enter both
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(a1);
        em.persist(a2);
        em.persist(a3);
        em.persist(a4);


        em.getTransaction().commit() ;
        //a. listing all the accounts of one customer
        em.getTransaction().begin();
        em.createQuery("SELECT c FROM Customer c " +
                        "WHERE c = :customer", Customer.class)
                .setParameter("customer", c1)
                .getResultList()
                .forEach(c -> c.showAccounts());

        em.getTransaction().commit() ;

        //b. listing all the customers
        em.getTransaction().begin();

        em.createQuery("SELECT c FROM Customer c "
                      , Customer.class)
                .getResultList()
                .forEach(Customer::print);

        em.getTransaction().commit() ;


        //c. retrieve the balance of one particular account
        em.getTransaction().begin();

        em.createQuery("SELECT a FROM Account a " +
                   "WHERE a  = :acc "
                        , Account.class)
                .setParameter("acc",a1)
                .getSingleResult()
                .showBalance();


        em.getTransaction().commit() ;


    }
}