package Interfaces.OVChipkaart;

import Domein.OVChipkaart;
import Domein.Reiziger;

import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO {
    @Override
    public boolean save(OVChipkaart ovChipkaart) {
        return false;
    }

    @Override
    public boolean update(OVChipkaart ovChipkaart) {
        return false;
    }

    @Override
    public boolean delete(OVChipkaart ovChipkaart) {
        return false;
    }

    @Override
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) {
        return null;
    }

    @Override
    public List<OVChipkaart> findAll() {
        return null;
    }
}
