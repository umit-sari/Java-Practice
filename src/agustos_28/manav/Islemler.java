package agustos_28.manav;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Islemler {
    /*
    -ürün listeleme
    -alışveriş
    -sepeti görüntüleme
    -ödeme
    -ürün ekleme
     */
    static Map<Integer, Urun> urunler = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    ArrayList<String> sepet = new ArrayList<>();
    double tutar;
    int yeniUrun = 106; // listedeki urun kodu 105 te bittigi icin
    // yeni eklenecek urun 106 dan basliyor.

    void urunListeleme() {
        System.out.println("*****ÜRÜNLER*****");
        for (int i = 1; i <= urunler.size(); i++) {
            System.out.println((i+100) +
                    ". ÜRÜN= " + urunler.get(i+100).getUrunAdi() +
                    " FİYATI= " + urunler.get(i+100).getUrunFiyati());
            // urun kodu 101 den basladıgı ıcın i+100 yaptık
        }
    }

    void alisveris() {
        try {
            System.out.print("ÜRÜN KODUNU GİRİNİZ: ");
            int urunKodu = scan.nextInt();
            System.out.println("ÜRÜN MİKTARINI GİRİNİZ: ");
            double miktar = scan.nextDouble();
            tutar += miktar * urunler.get(urunKodu).getUrunFiyati();
            String sepetUrunu = urunKodu + " KODLU " + urunler.get(urunKodu).getUrunAdi() + " ÜRÜNÜNDEN " + miktar + " KG ALINDI";
            sepet.add(sepetUrunu);
            sepetListeleme();
        } catch (NullPointerException e) {
            System.out.println("ÜRÜN KODUNU YANLIŞ GİRDİNİZ...");
            alisveris();
        }

    }

    void sepetListeleme() {
        for (String each : sepet) {
            System.out.println(each);
        }
    }

    void odeme() {
        System.out.println("ÖDENECEK TUTAR= " + tutar);
        double nakit = 0;
        do {
            System.out.print("NAKİT MİKTARI GİRİNİZ= ");
            nakit += scan.nextDouble();

            if (nakit < tutar) {
                System.out.println("GİRİLEN MİKTAR YETERSİZ\n" +
                        (tutar - nakit) + " TL DAHA ÖDEME YAPMALISINIZ....");
            }
        } while (nakit < tutar);

        double paraUstu = nakit - tutar;
        if (paraUstu > 0) {
            System.out.println("PARA ÜSTÜ= " + paraUstu + "\n" + "YİNE BEKLERİZ....");
            System.exit(0);
        } else {
            System.out.println("YİNE BEKLERİZ....");
            System.exit(0);
        }
    }

    void urunEkleme() {
        System.out.print("ÜRÜN ADINI GİRİNİZ: ");
        String urunAdi = scan.nextLine();
        System.out.print("ÜRÜN FİYATI GİRİNİZ: ");
        double urunFiyati = scan.nextDouble();
        Urun urun = new Urun(urunAdi, urunFiyati);
        urunler.put(yeniUrun++, urun);
    }
}