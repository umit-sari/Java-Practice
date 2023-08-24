package agustos19_02;

import javax.swing.*;
import java.util.Scanner;

public class Menu extends Methodlar {
 Scanner scan=new Scanner(System.in);
 void giris(){
     System.out.println("YENİ KULLANICI OLUŞTURMAK İÇİN '1' \n" +
     "SİSTEME GİRİŞ İÇİN '2' YE BASINIZ...");

     int secim=scan.nextInt();
     switch (secim){
         case 1:
             kullaniciOlustur();
             giris();
         case 2:
             if (kullaniciGirisi())
                 menu();
             else{
                 System.out.println("HATALI GİRİŞ YAPTINIZ...");
                 giris();
             }
         default:
             System.out.println("HATALI GİRİŞ YAPTINIZ...");
             giris();
        }
    }

 private void menu(){
     //Menu listesinde Bakiye sorgula, para yatirma, para çekme,
     // para gönderme, sifre değiştirme ve cikis islemleri olacaktır.

     System.out.print("YAPMAK İSTEDİĞİNİZ İŞLEMİ SEÇİNİZ\n" +
             "1. BAKİYE SORGULAMA\n" +
             "2. PARA YATIRMA\n" +
             "3. PARA ÇEKME\n" +
             "4. PARA GÖNDERME\n" +
             "5. ŞİFRE DEĞİŞTİRME\n" +
             "6. ÇIKIŞ\n" +
             "SEÇİMİNİZ: ");

     int secim=scan.nextInt();
     switch (secim){
         case 1:
             bakiyeSorgula();
             menu();
         case 2:
             paraYatirma();
             menu();
         case 3:
             paraCekme();
             menu();
         case 4:
             paraGonderme();
             menu();
         case 5:
             sifreDegistir();

         case 6:
             System.out.println("SİSTEMDEN ÇIKILIYOR....");
             System.exit(0);
         default: {
             System.out.println("HATALI GİRİŞ YAPTINIZ...");
             menu();
         }
       }
     }
}
