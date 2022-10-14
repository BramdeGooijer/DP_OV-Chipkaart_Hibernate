package Interfaces.Product;

import Domein.OVChipkaart;
import Domein.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAOHibernate implements ProductDAO {
    private Session session;
    private Transaction tx;

    public ProductDAOHibernate(Session session, Transaction tx) {
        this.session = session;
        this.tx = tx;
    }

    @Override
    public boolean save(Product product) {
        try {
            session.save(product);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        try {
            session.update(product);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        try {
            session.delete(product);
            tx.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart) {
        try {
            return session.createQuery("from product", Product.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Product> findAll() {
        try {
            return session.createQuery("from product", Product.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
