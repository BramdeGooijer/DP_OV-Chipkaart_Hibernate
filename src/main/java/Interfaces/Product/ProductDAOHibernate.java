package Interfaces.Product;

import Domein.OVChipkaart;
import Domein.Product;

import java.util.List;

public class ProductDAOHibernate implements ProductDAO {
    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean delete(Product product) {
        return false;
    }

    @Override
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
