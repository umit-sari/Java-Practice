package temmuz31;

import java.util.Scanner;

public class Atm {
    /*
    ATM
Kullanicidan giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,

Menu listesinde Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis islemleri olacaktır.

Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,

Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina geri donsun.

Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,
     */

    static String kartNo = "123456";
    static String sifre = "1234";
    static Scanner scan = new Scanner(System.in);
    static double bakiye = 50000;

    public static void main(String[] args) {
        giris();
    }

    public static void giris() {
        /*
        Kullanicidan giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,
         */
        System.out.print("KART NUMARASI GIRINIZ:  ");
        String kKartNo = scan.nextLine().replace(" ", "");
        System.out.print("SIFRENIZI GIRINIZ:  ");
        String kSifre = scan.next();
        if (kKartNo.equals(kartNo) && kSifre.equals(sifre)) {
            menu();
        } else {
            System.out.println("HATALI GIRIS YAPTINIZ...");
            giris();
        }
        //kullanıcı 3 defadan fazla giriş yaparsa sistemden çıkış yapılsın!!!!!!!!!!!!!!!!

    }

    public static void menu() {
        //Menu listesinde Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis islemleri olacaktır.
        System.out.print("*****NUTELLA BANK*****\n" +
                "1. BAKIYE SORGULAMA\n" +
                "2. PARA YATIRMA\n" +
                "3. PARA CEKME\n" +
                "4. PARA GONDERME\n" +
                "5. SIFRE DEGISTIRME\n" +
                "6. CIKIS\n" +
                "SECIM:  ");
        int secim = scan.nextInt();
        switch (secim) {
            case 1: {
                bakiyeSorgula();
            }
            case 2: {
                System.out.print("YATIRMAK ISTEDIGINIZ MIKTARI GIRINIZ: ");
                double miktar = scan.nextDouble();
                paraYatirma(miktar);
            }
            case 3: {
                System.out.print("CEKMEK ISTEDIGINIZ MIKTARI GIRINIZ: ");
                //double miktar = scan.nextDouble();
                paraCekme(scan.nextDouble());
            }
            case 4: {
                paraGonderme();
            }
            case 5: {
                sifreDegistirme();
            }
            case 6: {
                System.out.println("BIZI SECTIGINIZ ICIN TESEKKURLER...");
                System.exit(0);
            }
            default: {
                System.out.println("YANLIS GIRIS YAPTINIZ...");
                menu();
            }
        }
    }

    public static void sifreDegistirme() {
        //Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,
        System.out.print("MEVCUT SIFREYI GIRINIZ: ");
        String kSifre = scan.next();
        if (kSifre.equals(sifre)) {
            System.out.print("YENI SIFRE GIRINIZ: ");
            sifre = scan.next();
            giris();
        } else {
            System.out.println("SENDE KIMSIN !!!!!");
            sifreDegistirme();
        }
    }
    //kullanıcıya 3 hak verelim. doğru şifre giremezse sistemden çıkş yapsın

    public static void paraGonderme() {
        /*
        Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,

        Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina geri donsun.
         */
        scan.nextLine();// dummy
        System.out.print("PARA GONDERILECEK IBANI GIRINIZ: ");
        String iban = scan.nextLine().toUpperCase().replace(" ", "");
        if (iban.startsWith("TR") && iban.length() == 26) {
            System.out.print("GONDERILECEK MIKTAR GIRINIZ: ");
            double miktar = scan.nextDouble();
            if (miktar <= bakiye) {
                bakiye -= miktar;// bakiye=bakiye-miktar;
                bakiyeSorgula();
            } else {
                System.out.println("BAKIYENIZ YETERSIZ...");
                menu();
            }
        } else {
            System.out.println("HATALI IBAN GIRDINIZ...");
            menu();
        }
    }

    public static void paraCekme(double miktar) {
        //Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
        if (miktar <= bakiye) {
            bakiye -= miktar;// bakiye=bakiye-miktar;
            bakiyeSorgula();
        } else {
            System.out.print("BAKIYEDEN BUYUK MIKTAR CEKEMEZSINIZ....\n" +
                    "MIKTAR GIRINIZ: ");
            double yeniMiktar = scan.nextDouble();
            paraCekme(yeniMiktar);
        }

    }

    public static void paraYatirma(double miktar) {
        bakiye += miktar;//bakiye=bakiye+miktar;
        bakiyeSorgula();
    }

    public static void bakiyeSorgula() {
        System.out.println("BAKIYE: " + bakiye + " $");
        menu();
    }
}