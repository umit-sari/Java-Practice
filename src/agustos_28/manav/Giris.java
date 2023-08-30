package agustos_28.manav;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Giris extends Islemler {
    /*
    -ürün listeleme
    -alışveriş
    -sepeti görüntüleme
    -ödeme
    -ürün ekleme
     */
    Scanner scan=new Scanner(System.in);
    void menu(){
        System.out.print("YAPMAK İSTEDİĞİNİZ İŞLEMİ SEÇİNİZ\n" +
                "1. ÜRÜN LİSTELEME\n" +
                "2. ALIŞVERİŞ\n" +
                "3. SEPETİ GÖRÜNTÜLE\n" +
                "4. ÖDEME\n" +
                "5. ÜRÜN EKLEME\n" +
                "ÇIKIŞ İÇİN Q BASINIZ....\n" +
                "SEÇİMİNİZ:");
        try{
            int secim=scan.nextInt();
            switch (secim){
                case 1:
                    urunListeleme();
                    menu();
                case 2:
                    alisveris();
                    menu();
                case 3:
                    sepetListeleme();
                    menu();
                case 4:
                    odeme();
                    menu();
                case 5:
                    urunEkleme();
                    menu();
                default:
                    System.out.println("HATALI GİRİŞ YAPRINIZ....");
                    menu();
            }

        }catch (InputMismatchException e){
            if (scan.next().equalsIgnoreCase("q")){
                System.out.println("YİNE BEKLERİZ....");
                System.exit(0);
            }else {
                System.out.println("HATALI GİRİŞ YAPTINIZ...");
                menu();
            }
        }


    }
}