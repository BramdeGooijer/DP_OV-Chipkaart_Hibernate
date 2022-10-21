package Domein;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_nummer;

    private String naam;

    private String beschrijving;

    private int prijs;

    @ManyToMany(mappedBy = "alleProducten")
    private List<OVChipkaart> allOVChipkaarten = new ArrayList<>();

    public Product(int product_nummer, String naam, String beschrijving, int prijs) {
        this.product_nummer = product_nummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public Product() {

    }

    public void addOVChipkaart(OVChipkaart ovChipkaart) {
        allOVChipkaarten.add(ovChipkaart);
    }

    public void removeOVChipkaart(OVChipkaart ovChipkaart) {
        allOVChipkaarten.remove(ovChipkaart);
    }

    public int getProduct_nummer() {
        return product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public List<OVChipkaart> getAllOVChipkaarten() {
        return allOVChipkaarten;
    }

    @Override
    public String toString() {
        return String.format("Product {%s, %s, %s, %s}", this.product_nummer, this.naam, this.beschrijving, this.prijs);
    }
}
