package Interfaces.Reiziger;

import Domein.Reiziger;
import Interfaces.Adres.AdresDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO {
    private Session session;
    private Transaction tx;

    public ReizigerDAOHibernate(Session session, Transaction tx) {
        this.session = session;
        this.tx = tx;
    }

    @Override
    public boolean save(Reiziger reiziger) {
        try {
            session.save(reiziger);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Reiziger reiziger) {
        try {
            session.update(reiziger);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        try {
            session.delete(reiziger);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Reiziger findById(int id) {
        try {
            return session.get(Reiziger.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reiziger> findByGbDatum(String datum) {
        try {
            Query query =  session.createQuery("from reiziger where geboortedatum = :datum", Reiziger.class);
            query.setParameter("datum", datum);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reiziger> findAll() {
        try {
            return session.createQuery("FROM reiziger ", Reiziger.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
