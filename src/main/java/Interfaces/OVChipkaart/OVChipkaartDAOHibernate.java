package Interfaces.OVChipkaart;

import Domein.OVChipkaart;
import Domein.Reiziger;
import Interfaces.Reiziger.ReizigerDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO {
    private Session session;
    private Transaction tx;

    public OVChipkaartDAOHibernate(Session session, Transaction tx) {
        this.session = session;
        this.tx = tx;
    }

    @Override
    public boolean save(OVChipkaart ovChipkaart) {
        try {
            session.save(ovChipkaart);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(OVChipkaart ovChipkaart) {
        try {
            session.update(ovChipkaart);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(OVChipkaart ovChipkaart) {
        try {
            session.delete(ovChipkaart);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) {
        try {
            return session.createQuery("from ov_chipkaart", OVChipkaart.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<OVChipkaart> findAll() {
        try {
            return session.createQuery("from ov_chipkaart ", OVChipkaart.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
