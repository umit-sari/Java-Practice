package temmuz25;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    /*
  Girilen desimal değeri binary değere çeviren metodu oluşturunuz.
  Örnek: 12 = 1 1 0 0
  12 =desimal sayı, 1 1 0 0 = binary sayı
   12/2 = kalan 0 , 6/2= kalan 0 , 3/2 = kalan 1 ve geriye 1 pay kalıyo yani 1 1 0 0,
   */
    public static void main(String[] args) {
        System.out.print("Desimal değer giriniz: ");
        Scanner scan=new Scanner(System.in);
        int sayi=scan.nextInt();
        System.out.println(sayi+" desimal sayısının binary karşılığı: "+ binaryConvert(sayi));
    }

    public static List<Integer> binaryConvert(int sayi) {
        List<Integer> binary=new ArrayList<>();
        while (sayi>0){
            binary.add(sayi%2);
            sayi/=2;
        }
        List<Integer> tersBinary=new ArrayList<>(); // sonucları ters cevirdik. sonuc 0 0 1 1 di bizden istenen 1 1 0 0 yaptık
        for (int i = binary.size()-1; i >=0 ; i--) {
            tersBinary.add(binary.get(i));

            // Collection.reserve(binary); bu direk listi tersine ceviriyor. IF li satır yerine.
        }
        return tersBinary;
    }
}
