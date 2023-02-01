package com.example.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.entities.Address;
import com.example.entities.Client;
import com.example.entities.Fournisseur;
import com.example.entities.Personne;
import com.example.entities.User;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("cours-hibernate");
        EntityManager entityManager = factory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        
        Address a1 = new Address("rue1", "13000", "Aix");
        Address a2 = new Address("rue2", "83000", "Toulon");
        
        User u1 = new User("Bob", "Doe", 40);
        a1.setUser(u1);
        a2.setUser(u1);
        
        u1.addAddress(a1);
        u1.addAddress(a2);
        //User u2 = new User("Marc", "Marc", 30, a1);
        entityManager.persist(u1);
        //entityManager.persist(u2);
        
        
        
     /*   // ici on enregistre un tuple dans la db
        User u = new User("Bob", "Doe", 40);
        entityManager.persist(u); 
        
        // ici on vas fusionner les entites
        User u2 = new User(1, "Boby", "Dox", 40);
        entityManager.merge(u2);
        
        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("1997-06-11");
        Personne c = new Client("Mansoibou", "Souraya", 25, d1);
        entityManager.persist(c);
        
        
        Personne f = new Fournisseur("Patrik", "Fleury", "Market");
        entityManager.persist(f);
        
        // ici on retourne l utilisateur a l id 1
        int primaryKey = 1;
        User user = entityManager.find(User.class, primaryKey);
        
        System.out.println(user);
        
        // ici, on supprime l utilisateur a l id 1
        // entityManager.remove(user)
        
        // ici on veut une liste
//        Query myQuery = entityManager.createQuery("from User", User.class);
//        List<User> users = myQuery.getResultList();
//        
//        users.forEach((us) ->System.out.println(us));
        
        Query myQuery = entityManager.createQuery("from Personne", Personne.class);
        List<User> personnes = myQuery.getResultList();
        
        personnes.forEach((pepe) ->System.out.println(pepe)); */
        
        
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}
