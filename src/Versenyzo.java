import java.sql.Time;
import java.util.Objects;

public class Versenyzo implements Statisztika{
    private String rajtszam;
    private String kategoria;
    private String nev;
    private String egyesulet;
    private Time ido;

    public Versenyzo() {
    }

    public Versenyzo(String rajtszam, String kategoria, String nev, String egyesulet, Time ido) {
        this.rajtszam = rajtszam;
        this.kategoria = kategoria;
        this.nev = nev;
        this.egyesulet = egyesulet;
        this.ido = ido;
    }

    public Versenyzo(String csvSor) {
        String[] ertekek = csvSor.split(";");

        this.rajtszam = ertekek[0];
        this.kategoria = ertekek[1];
        this.nev=ertekek[2];
        this.egyesulet=ertekek[3];
        this.ido=Time.valueOf(ertekek[4]);
    }

    public String getRajtszam() {
        return rajtszam;
    }

    public void setRajtszam(String rajtszam) {
        this.rajtszam = rajtszam;
    }
    @Override
    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEgyesulet() {
        return egyesulet;
    }

    public void setEgyesulet(String egyesulet) {
        this.egyesulet = egyesulet;
    }

    public Time getIdo() {
        return ido;
    }

    public void setIdo(Time ido) {
        this.ido = ido;
    }
}
