import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            for(Versenyzo item : versenyzok){
                System.out.println(item.getRajtszam()+" "+item.getKategoria()+" "+item.getNev()+" "+item.getEgyesulet()+" "+item.getIdo());
            }
        }catch(IOException r){
            r.printStackTrace();
        }
    }
}