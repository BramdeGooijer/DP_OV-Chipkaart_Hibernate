package Domein;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "reiziger")
public class Reiziger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reiziger_id;

    private String voorletters;

    private String tussenvoegsel;

    private String achternaam;

    private Date geboortedatum;

    @OneToOne(
            mappedBy = "reiziger",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Adres adres;

    @OneToMany(mappedBy = "reiziger", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OVChipkaart> alleOVChipkaarten = new ArrayList<>();

    public Reiziger(int reiziger_id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.reiziger_id = reiziger_id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public void addOVChipkaart(OVChipkaart ovChipkaart) {
        alleOVChipkaarten.add(ovChipkaart);
    }

    public Reiziger() {

    }

    public List<OVChipkaart> getAlleOVChipkaarten() {
        return alleOVChipkaarten;
    }

    public int getReiziger_id() {
        return reiziger_id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        String adres = "";
        if (this.adres != null) {
            adres = ", " + this.adres;
        }

        String ovchipkaart = "";
        if (this.alleOVChipkaarten.size() != 0) {
            ovchipkaart = ", " + alleOVChipkaarten;
        }

//        hier komt een if statement om te kijken of er een adres is
        return String.format("Reiziger {#%s %s. %s %s, geb. %s}%s%s", this.getReiziger_id(), this.voorletters, this.tussenvoegsel, this.achternaam, this.geboortedatum, adres, ovchipkaart);
    }
}
