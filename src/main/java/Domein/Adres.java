package Domein;

import javax.persistence.*;

@Entity
//@AttributeOverrides({
//        @AttributeOverride(name = "adres_id")
//})
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adres_id;

    private String postcode;

    private String huisnummer;

    private String straat;

    private String woonplaats;

    @OneToOne(cascade = CascadeType.ALL)
//    @Transient
    private Reiziger reiziger;

    public Adres(int adres_id, String postcode, String huisnummer, String straat, String woonplaats, Reiziger reiziger) {
        this.adres_id = adres_id;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.straat = straat;
        this.woonplaats = woonplaats;
        this.reiziger = reiziger;
        this.reiziger.setAdres(this);
    }

    public Adres() {

    }

    public int getAdres_id() {
        return adres_id;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public String toString() {
        return String.format("Adres {#%s %s %s}",this.adres_id, this.postcode, this.huisnummer);
    }
}
