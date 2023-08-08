package FilmTercihi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilmTahmin {


        //                  "JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"
        //         //     TASK :
        //        //      yukarıdaki film listinde bulunan filmlerden herhangi birisini kullanıcının film ismini  görmeden
        //        //      filmin index nosuna göre sectiriniz
        //        //      seçilen filmin  ismini filmin harf saysının 2 katı kadar hak tanıyarak tahmin etmesini
        //        //      sağlayan method create ediniz...
        //        //      Ahanda TRICK...
        //        //      kullanıcının sectiği filmin harf sayısını  console yazdırınız.
        //        //      kullanıcının sectiği film için tahmin hakkını  console yazdırınız.
        //        //      kullanıcının her tahmininde kalan hak sayısını console yazdırınız.
        //        //      kullanıcının her tahmininde doğru ve yanlış tahmin  sayısını console yazdırınız.
        //        //      kullanıcının kaybedip veya kazandığını ve tahmin etmesi gereken filmin ismini  console yazdırınız.

    // listemizi bir array liste kaydedelim
    static List<String> filmerListesi = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Film tahmin oyunumuza hoş geldiniz");
        System.out.println("lütfen 1 ile "+filmerListesi.size() +" arasında bir sayi giriniz");
        int secilenFilmIndex = scan.nextInt();

        filmMethodu(filmerListesi,secilenFilmIndex-1);

    }

    public static void filmMethodu(List<String> filmerListesi, int index) {

        String secilenFilm = filmerListesi.get(index);  // kullanıcı bir girdiyse index sıfır seciliyor

        StringBuilder tahminEdilecekFilm = new StringBuilder(secilenFilm.replaceAll("\\w","-"));
        //System.out.println(secilenFilm);
        System.out.println(tahminEdilecekFilm);
        //        //      kullanıcının sectiği filmin harf sayısını  console yazdırınız.
        //        //      kullanıcının sectiği film için tahmin hakkını  console yazdırınız.
        System.out.println(secilenFilm.length()+" hafrli bir film sectiniz.");
        System.out.println("Tahmin hakkınız : " + secilenFilm.length()*2);


        char harf = ' ';
        int tahminSayisi = 0;
        int dogruTahminSayisi = 0;

        do {
            System.out.println("Yanlis Tahmin Sayisi : " +(tahminSayisi-dogruTahminSayisi)+"/"+(secilenFilm.length()*2));   //   5 / 10
            System.out.println("Lütfen bir harf giriniz");
            harf = scan.next().toUpperCase().charAt(0);  // ahmet  -->> AHMET -->> 'A'

            if (!tahminEdilecekFilm.toString().contains(""+harf)){
                tahminSayisi++;
            }

            for (int i = 0; i <tahminEdilecekFilm.length() ; i++) {

                if (secilenFilm.charAt(i)==harf){
                    if (!tahminEdilecekFilm.toString().contains(""+harf)){
                        dogruTahminSayisi++;
                    }


                    tahminEdilecekFilm.setCharAt(i,harf);
                }


            }

            if (tahminEdilecekFilm.toString().equalsIgnoreCase(secilenFilm)){
                System.out.println("tebrikler kazandınız");
                System.out.println("dogru tahmin ettiniz filim : "+ secilenFilm);
                break;
            }

            System.out.println(tahminEdilecekFilm);  // ------
        }while ((tahminSayisi-dogruTahminSayisi)<secilenFilm.length()*2);

        if ((tahminSayisi-dogruTahminSayisi)==2*secilenFilm.length()){
            System.out.println("yanlış tahmin sayısı : " +(tahminSayisi-dogruTahminSayisi));
            System.out.println("Game Over");
            System.out.println("tahmin etmeye çalıştıgınız film : " + secilenFilm);
        }


    }


}