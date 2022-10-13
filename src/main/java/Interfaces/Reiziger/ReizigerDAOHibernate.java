package Interfaces.Reiziger;

import Domein.Reiziger;

import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO {
    @Override
    public boolean save(Reiziger reiziger) {
        return false;
    }

    @Override
    public boolean update(Reiziger reiziger) {
        return false;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        return false;
    }

    @Override
    public Reiziger findById(int id) {
        return null;
    }

    @Override
    public List<Reiziger> findByGbDatum(String datum) {
        return null;
    }

    @Override
    public List<Reiziger> findAll() {
        return null;
    }
}
