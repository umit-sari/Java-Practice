package agustos07;

import java.util.Scanner;

public class KahveOtomat {
    /*
    1. Şart
   3 çeşit kahvemiz olsun.
  Sistem şu soruyu sorsun: "Hangi Kahveyi istersiniz?"
  Bu soru ile birlikte kullanıcı kahve bilgilerini görsün.
   Örn:
  Hangi Kahveyi İstersiniz?
  1.Türk kahvesi
  2.Filtre Kahve
  3.Americano
     */
    static String kahveCesidi = "", sut = "", seker = "", kahveBoyutu = "";
    static int sekerMiktari;
    static Scanner scan = new Scanner(System.in);

    static void menu() {
        System.out.println("*******GAHVECİYE HOŞGELDİNİZ*******");
        do {
            System.out.print("******MENU******\n" +
                    "Türk Kahvesi\n" +
                    "Filtre Kahve\n" +
                    "Americano\n" +
                    "SEÇİM:");
            kahveCesidi = scan.nextLine();
            if (!kahveCesidi.equalsIgnoreCase("türk kahvesi") &&
                    !kahveCesidi.equalsIgnoreCase("filtre kahve") &&
                    !kahveCesidi.equalsIgnoreCase("americano"))
                System.out.println("BU ÜRÜN MENUDE YOK.....");

        } while (!kahveCesidi.equalsIgnoreCase("türk kahvesi") &&
                !kahveCesidi.equalsIgnoreCase("filtre kahve") &&
                !kahveCesidi.equalsIgnoreCase("americano"));
    }

    /*
    2.Şart
  Kahve seçildikten sonra sistem kullanıcıya "Süt eklemek istemisiniz?(Evet veya Hayır olarak cevaplayınız)
     */
    static void sutEkleme() {
        System.out.println("Süt eklemek istemisiniz?(Evet veya Hayır olarak cevaplayınız)");
        sut = scan.next();
        if (sut.equalsIgnoreCase("evet"))
            System.out.println("Süt ekleniyor.....");
        else
            System.out.println("Süt eklenmiyor....");
    }

    /*
    3. Şart
  Süt tercihi yapıldıktan sonra sistem kullanıcıya "Şeker ister misiniz ? (Evet veya hayır cevabını veriniz)
  sorusunu sorsun.
     */
    static void sekerEkleme() {
        System.out.println("Şeker ister misiniz ? (Evet veya hayır cevabını veriniz)");
        seker = scan.next();
        if (seker.equalsIgnoreCase("evet")) {
            System.out.print("Kaç şeker istersiniz: ");
            sekerMiktari = scan.nextInt();
            System.out.println(sekerMiktari + " adet şeker ekleniyor....");
        } else
            System.out.println("Şeker eklenmiyor....");
    }

    /*
    4. Şart
  Şeker tercihini yaptıktan sonra sistem kullanıcıya kahvenin "Hangi boyutta olsun? (Büyük boy - orta boy - küçük boy olarak giriniz.)
  sorusunu sorsun.
     */
    static void boyutSorgula() {
        do {
            System.out.println("Hangi boyutta olsun? (Büyük boy - orta boy - küçük boy olarak giriniz.)");
            scan.nextLine();
            kahveBoyutu = scan.nextLine();
            if (!kahveBoyutu.equalsIgnoreCase("büyük boy") &&
                    !kahveBoyutu.equalsIgnoreCase("orta boy") &&
                    !kahveBoyutu.equalsIgnoreCase("kücük boy"))
                System.out.println("Hatalı giriş yaptınız....");

        } while (!kahveBoyutu.equalsIgnoreCase("büyük boy") &&
                !kahveBoyutu.equalsIgnoreCase("orta boy") &&
                !kahveBoyutu.equalsIgnoreCase("kücük boy"));

    }
    /*
    Sonuç
    Siparişlerimizi verdik. Son hali görmek istiyoruz.
                    konsola şunu yazdırın örnek :

        Türk Kahvesi orta boy hazırdır. Afiyet olsun !!!
     */
    static void sonuc(){
        if (sut.equalsIgnoreCase("evet"))
            sut="sütlü";
        else
            sut="sütsüz";

        if (seker.equalsIgnoreCase("evet"))
            seker=sekerMiktari+" sekerli";
        else
            seker="şekersiz";
        System.out.println(sut+" "+seker+" "+kahveBoyutu+" "+kahveCesidi+" HAZIRDIR. AFİYET OLSUN!!!");
    }

    public static void main(String[] args) {
        menu();
        sutEkleme();
        sekerEkleme();
        boyutSorgula();
        sonuc();
    }
}