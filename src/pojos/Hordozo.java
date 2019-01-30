package pojos;
// Generated Dec 30, 2018 10:19:38 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Hordozo generated by hbm2java
 */
@Entity
@Table(name = "hordozo",
         catalog = "kanga_adatbazis"
)
public class Hordozo implements java.io.Serializable {

    private int id;
    private Tag tag;
    private String nev;
    private String gyarto;
    private String tipus;
    private String meret;
    private String megjegyzes;
    private String kolcsonzesiHatarido;
    private String kep;

    public Hordozo() {
    }

    public Hordozo(int id, Tag tag, String nev, String gyarto, String tipus) {
        this.id = id;
        this.tag = tag;
        this.nev = nev;
        this.gyarto = gyarto;
        this.tipus = tipus;
    }

    public Hordozo(int id, Tag tag, String nev, String gyarto, String tipus, String meret, String megjegyzes, String kolcsonzesiHatarido, String kep) {
        this.id = id;
        this.tag = tag;
        this.nev = nev;
        this.gyarto = gyarto;
        this.tipus = tipus;
        this.meret = meret;
        this.megjegyzes = megjegyzes;
        this.kolcsonzesiHatarido = kolcsonzesiHatarido;
        this.kep = kep;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id", nullable = false)
    public Tag getTag() {
        return this.tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Column(name = "nev", nullable = false, length = 45)
    public String getNev() {
        return this.nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    @Column(name = "gyarto", nullable = false, length = 45)
    public String getGyarto() {
        return this.gyarto;
    }

    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    @Column(name = "tipus", nullable = false, length = 45)
    public String getTipus() {
        return this.tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    @Column(name = "meret", length = 45)
    public String getMeret() {
        return this.meret;
    }

    public void setMeret(String meret) {
        this.meret = meret;
    }

    @Column(name = "megjegyzes", length = 100)
    public String getMegjegyzes() {
        return this.megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }

    @Column(name = "kolcsonzesi_hatarido", length = 45)
    public String getKolcsonzesiHatarido() {
        return this.kolcsonzesiHatarido;
    }

    public void setKolcsonzesiHatarido(String kolcsonzesiHatarido) {
        this.kolcsonzesiHatarido = kolcsonzesiHatarido;
    }

    @Column(name = "kep", length = 45)
    public String getKep() {
        return kep;
    }

    public void setKep(String kep) {
        this.kep = kep;
    }

    @Override
    public String toString() {
        if(tag.getId()==0){
        return gyarto+" "+nev+" (bent)";
    } else{
        return  gyarto+" "+nev+" (kölcsönző: "+tag.getNev()+")";
        }
    
    }

}