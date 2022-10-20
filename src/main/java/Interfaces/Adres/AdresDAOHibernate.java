package Interfaces.Adres;

import Domein.Adres;
import Domein.Reiziger;
import Interfaces.Product.ProductDAO;
import Interfaces.Reiziger.ReizigerDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdresDAOHibernate implements AdresDAO {
    private Session session;
    private Transaction tx;

    public AdresDAOHibernate(Session session, Transaction tx) {
        this.session = session;
        this.tx = tx;
    }

    @Override
    public boolean save(Adres adres) {
        try {
            session.save(adres);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Adres adres) {
        try {
            session.update(adres);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Adres adres) {
        try {
            session.delete(adres);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        try {
            return session.get(Adres.class, reiziger.getReiziger_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Adres> findAll() {
        try {
            return session.createQuery("FROM adres ", Adres.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
