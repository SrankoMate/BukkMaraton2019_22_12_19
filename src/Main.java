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
        }catch(IOException r){
            r.printStackTrace();
        }
    }
}