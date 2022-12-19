import com.sun.jdi.IntegerValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader beolv = new BufferedReader(new FileReader("bukkm2019.txt"));
            List<Versenyzo> versenyzok = new ArrayList<>();
            beolv.readLine();
            String sor;
            while((sor = beolv.readLine())!=null){
                Versenyzo versenyzo = new Versenyzo(sor);
                versenyzok.add(versenyzo);
            }
            System.out.println("4. feladat");
            int nt = 691-versenyzok.size();
            double arany = (nt/(double)691)*100;
            System.out.print("A versenyzők ");
            System.out.format("%.2f",arany);
            System.out.println("%-a NEM teljesítette a versenyt.");

            double arany2 = (versenyzok.size()/(double)691)*100;
            System.out.print("A versenyzők ");
            System.out.format("%.2f",arany2);
            System.out.println("%-a teljesítette a versenyt.");

            System.out.println("5. feladat");
            int szamlalo = 0;
            for(Versenyzo item: versenyzok){
                Versenytav versenytav = new Versenytav(item.getRajtszam());
                if(versenytav.getTav().equals("Rövid")&&item.getKategoria().charAt(item.getKategoria().length()-1)!='f'){
                    szamlalo++;
                }
            }
            System.out.println("A női versenyzők száma a rövidtávú versenyen: "+szamlalo);

            System.out.println("6. feladat");
            for(Versenyzo item: versenyzok){
                if(item.getIdo().after(new Time(6,00,00)))
                {
                    System.out.println("Van olyan eset, amikor több mint 6 órán volt a pályán egy versenyző.");
                    break;
                }
            }
            System.out.println("7. feladat");
            Time min = new Time(23,59,59);
            for(Versenyzo item:versenyzok){
                Versenytav versenytav = new Versenytav(item.getRajtszam());
                if(item.getIdo().before(min)&&versenytav.getTav().equals("Rövid")&&item.getKategoria().equals("ff"))
                {
                    min = item.getIdo();
                }
            }
            for(Versenyzo item:versenyzok){
                if(min.equals(item.getIdo()))
                {
                    System.out.println("A rövidtávú verseny felnőtt férfi kategóriájának győztese: ");
                    System.out.println(item.getRajtszam()+" "+item.getKategoria()+" "+item.getNev()+" "+item.getEgyesulet()+" "+item.getIdo());
                }
            }
            System.out.println("8. feladat");
            List<Statisztika> statisztikak = new ArrayList<>();
            statisztikak.addAll(versenyzok);
            Map<String,Integer> darabszamok = kategoriankentiOsszesites(statisztikak);
            for(String kategoria:darabszamok.keySet()){
                System.out.println(kategoria+" : "+darabszamok.get(kategoria));
            }
        }catch(IOException r){
            r.printStackTrace();
        }
    }
    private static Map<String, Integer> kategoriankentiOsszesites(Collection<Statisztika> statisztikak){
        Map<String,Integer> darabszamok = new TreeMap<>();
        for(Statisztika statisztika : statisztikak)
        {
            int darabszam = darabszamok.getOrDefault(statisztika.getKategoria(),0);
            darabszam++;
            darabszamok.put(statisztika.getKategoria(),darabszam);
        }
        return darabszamok;
    }
}