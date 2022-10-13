package Interfaces.Adres;

import Domein.Adres;
import Domein.Reiziger;
import Interfaces.Product.ProductDAO;
import Interfaces.Reiziger.ReizigerDAO;
import org.hibernate.Session;

import java.util.List;

public class AdresDAOHibernate implements AdresDAO {
    private Session session;

    public AdresDAOHibernate(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Adres adres) {
        try {
            session.save(adres);
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
        return null;
    }
}
