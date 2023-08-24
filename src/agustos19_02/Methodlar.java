package agustos19_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Methodlar {
    /*
    ATM
    Kullanicidan giriş için kart numarasi ve şifresini isteyin,
    eger herhangi birini yanlis girerse tekrar isteyin.
    Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
    Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,
    Menu listesinde Bakiye sorgula, para yatirma, para çekme, para gönderme,
    sifre değiştirme ve cikis islemleri olacaktır.
    Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
    Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali,
    eger değilse menü ekranina geri donsun.
    Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,
     */

    static ArrayList<Kullanici> kullanicilist=new ArrayList<>();
    Scanner scan=new Scanner(System.in);
    String kartNo;
    int sayac=0;

    boolean kullaniciGirisi(){
         /*
        Kullanicidan giriş için kart numarasi ve şifresini isteyin,
        eger herhangi birini yanlis girerse tekrar isteyin.
        Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
        Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,
         */
        boolean giris=false;
        System.out.print("KART NO GİRİNİZ: ");
        kartNo=scan.nextLine();
        System.out.print("ŞİFRENİZİ GİRİNİZ: ");
        int sifre=scan.nextInt();
        for (Kullanici each:kullanicilist) {
            if (each.getKartNo().equals(kartNo) && each.getSifre()==sifre){
                giris=true;

            }
        }
        scan.nextLine();
        return giris;
    }
    void kullaniciOlustur(){
        System.out.print("KART NO GİRİNİZ");
        String kartNo=scan.nextLine().replace(" ","");
        System.out.println("ŞİFRENİZİ GİRİNİZ: ");
        int sifre=scan.nextInt();
        System.out.println("BAKİYENİZİ GİRİNİZ: ");
        double bakiye=scan.nextDouble();
        scan.nextLine();
        Kullanici kullanici=new Kullanici(kartNo,sifre,bakiye);
        kullanicilist.add(kullanici);
        }
        void bakiyeSorgula() {
            for (Kullanici each : kullanicilist) {
                if (each.getKartNo().equals(kartNo)) {
                    System.out.println(kartNo + " ait bakiye= " + each.getBakiye());
                }
            }
        }
        void paraYatirma () {
                for (Kullanici each:kullanicilist) {
                    if (each.getKartNo().equals(kartNo)){
                        System.out.println("Yatırmak istediğiniz tutarı giriniz: ");
                        double miktar=scan.nextDouble();
                        each.setBakiye(miktar+ each.getBakiye());//sıradaki kullanıcının bakiyesine miktarı
                        // o andaki bakiye ile toplayarak update ettik
                        bakiyeSorgula();

                    }

                }

            }
        void paraCekme(){
                for (Kullanici each:kullanicilist) {
                    if (each.getKartNo().equals(kartNo)){
                //Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
                        System.out.println("Çekmek istediğiniz miktarı giriniz: ");
                        double miktar=scan.nextDouble();
                        if (miktar<= each.getBakiye()){
                            each.setBakiye(each.getBakiye()-miktar);
                            bakiyeSorgula();
                        }else{
                            System.out.println("Yetersiz bakiye");
                            paraCekme();

                        }

                    }

                }
            }
        void paraGonderme() {
                //Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
                //Para gönderme işleminde istenen iban TR ile baslamali ve
                // toplam 26 karakterli olmali, eger değilse menü ekranina geri donsun.
                for (Kullanici each:kullanicilist) {
                    if (each.getKartNo().equals(kartNo)){;
                    scan.nextLine();
                    System.out.print("PARA GÖNDERMEK İSTEDİĞİNİZ IBAN'I GİRİNİZ: ");
                    String iban=scan.nextLine().replace(" ","").toUpperCase();
                    if (iban.startsWith("TR")&& iban.length()==26){
                     System.out.print("GÖNDERMEK İSTEDİĞİNİZ MİKTARI GİRİNİZ: ");
                     double miktar=scan.nextDouble();
                     if (miktar<=each.getBakiye()) {
                         each.setBakiye(each.getBakiye() - miktar);
                         bakiyeSorgula();
                     }
                     }else{
                         System.out.println("HATALI İBAN GİRDİNİZ....");
                         paraGonderme();
                     }
                }

        }

    }
        void sifreDegistir(){
                //Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra,
               // sifre değişiklik işlemini yapmali,
            do {
                sayac++;
                System.out.print("MEVCUT ŞİFRENİZİ GİRİNİZ: ");
                int sifre=scan.nextInt();
                boolean flag=true;
                for (Kullanici each:kullanicilist) {
                    if (each.getKartNo().equals(kartNo)){
                        if (each.getSifre()==sifre){
                            System.out.print("YENİ ŞİFRENİZİ GİRİNİZ : ");
                            sifre=scan.nextInt();
                            each.setSifre(sifre);
                            flag=false;
                        }
                    }

                }
                if (flag){
                    System.out.println("HATALI GİRİŞ YAPTINIZ");
                }else{
                    Menu menu=new Menu ();
                    menu.giris();

                }
            } while (sayac!=3);
                System.out.println("SİSTEMDEN ÇIKILIYOR");
                System.exit(0);
            }

}
