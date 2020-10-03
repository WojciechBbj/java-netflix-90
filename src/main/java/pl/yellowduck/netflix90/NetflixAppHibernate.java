package pl.yellowduck.netflix90;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.yellowduck.netflix90.films.Actor;
import pl.yellowduck.netflix90.films.Category;
import pl.yellowduck.netflix90.films.Director;
import pl.yellowduck.netflix90.films.VideoCassette;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static pl.yellowduck.netflix90.common.Gender.FEMALE;
import static pl.yellowduck.netflix90.common.Gender.MALE;

public class NetflixAppHibernate {

//    public static void main(String[] args) {
//        Director tommy = new Director("Tommy", "Wiseau", MALE);
//        Actor tommyActor = new Actor("Tommy", "Wiseau", MALE);
//        Actor julitette = new Actor("Juliette", "Danielle", FEMALE);
//        Actor greg = new Actor("Greg", "Sestero", MALE);
//        Category category = new Category(1, "Drama", "Drama");
//
//        Set<Actor> actors = new HashSet<>();
//        actors.add(tommyActor);
//        actors.add(julitette);
//        actors.add(greg);
//
//        VideoCassette theRoom = new VideoCassette(
//                "VID001",
//                BigDecimal.valueOf(20),
//                "The Room",
//                tommy,
//                //Category.DRAMA,
//                category,
//                actors);
//
//        theRoom.printOut();
//    }

    static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        System.out.println("\n\n--------------------->\n" +
                "Hibernate Session Factory Created");

        createCategories();
    }

    private static void createCategories() {
        //System.out.println(getOpenInfo());
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            // body here
            Category category = new Category("Drama", "Drama");
            session.persist(category);

            category = new Category("Comedy", "Comedy");
            session.persist(category);

            category = new Category("Thriller", "Thriller");
            session.persist(category);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null && !tx.getRollbackOnly()) {
                tx.rollback();
            }
            throw ex;
        }
        //System.out.println(getCloseInfo());
    }

}
