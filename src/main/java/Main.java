

import Domein.Adres;
import Domein.Reiziger;
import Interfaces.Adres.AdresDAO;
import Interfaces.Adres.AdresDAOHibernate;
import Interfaces.Reiziger.ReizigerDAO;
import Interfaces.Reiziger.ReizigerDAOHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Testklasse - deze klasse test alle andere klassen in deze package.
 *
 * System.out.println() is alleen in deze klasse toegestaan (behalve voor exceptions).
 *
 * @author tijmen.muller@hu.nl
 */
public class Main {
    // Creëer een factory voor Hibernate sessions.
    private static final SessionFactory factory;

    static {
        try {
            // Create a Hibernate session factory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retouneer een Hibernate session.
     *
     * @return Hibernate session
     * @throws HibernateException
     */
    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
//        testFetchAll();
        testDAOHibernate();
    }

    /**
     * P6. Haal alle (geannoteerde) entiteiten uit de database.
     */
    private static void testFetchAll() {
        Session session = getSession();
        try {
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                Query query = session.createQuery("from " + entityType.getName());

                System.out.println("[Test] Alle objecten van type " + entityType.getName() + " uit database:");
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    private static void testDAOHibernate() {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        AdresDAOHibernate adao = new AdresDAOHibernate(session, tx);
        ReizigerDAOHibernate rdao = new ReizigerDAOHibernate(session, tx);

//        maak reiziger en adres
        Reiziger reiziger = new Reiziger(200, "b", "de", "Gooijer", Date.valueOf("2001-01-01"));
        Adres adres = new Adres(200, "1218GZ", "5", "Vuurlvindermeent", "Hilversum", reiziger);

//        reiziger in database
        rdao.save(reiziger);
//        rdao.update(reiziger);
//        rdao.delete(reiziger);

//        adres in database
        adao.save(adres);
//        adao.update(adres);
//        adao.delete(adres);

//


//        close the session
        session.close();
    }
}