package Interfaces.Reiziger;

import Domein.Reiziger;

import java.util.List;

public interface ReizigerDAO {
    public boolean save(Reiziger reiziger);
    public boolean update(Reiziger reiziger);
    public boolean delete(Reiziger reiziger);
    public Reiziger findById(int id);
    public List<Reiziger> findByGbDatum(String datum);
    public List<Reiziger> findAll();
}
