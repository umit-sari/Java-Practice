package temmuz25;
import java.util.Scanner;

public class Q2 {
    /*
       2. SORU
    Kullanıcı tarafından girilen metni "Sezar Şifreleme Yöntemi" ne göre şifreleyiniz.
    Sezar Şifreleme: Sezar şifrelemesi, ilk kez Romalı lider Jül Sezar tarafından kullanılmış olan şifreleme tekniğidir.
    Bu şifreleme en basit ve en bilinen şifreleme tekniklerinden biridir.
    Düz metindeki her harfin, alfabeden belirli bir sayı ileride konumlu olan bir harfle değiştirildiği bir şifreleme türüdür.
    //hello ----> ıfmmp --->1 birim kaydırılmış hali
     */
    public static void main(String[] args) {
        System.out.print("Şifrelenecek metni giriniz: ");
        Scanner scan = new Scanner(System.in);
        String metin = scan.nextLine().toUpperCase();
        System.out.print("Kaydırma miktarını giriniz: ");
        int kaydirma = scan.nextInt();
        sifreleme(metin, kaydirma);
    }

    public static void sifreleme(String metin, int kaydirma) {
        String sifrelenmisMetin = "";// ZEYNEP--- 3
        String alfabe = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < metin.length(); i++) {
            char karater = metin.charAt(i);
            int karakterIndex = alfabe.indexOf(karater);
            int yeniIndex = (karakterIndex + kaydirma) % alfabe.length();
            //(26       +    3) % 26 =  3
            //karakterIndexin ve kaydırma miktarını ekledikten sonra alfabe uzunluğunu geçmemesi için alfabe
            //uzunluğuna modu alınarak alfabe değerleri içinde yeniIndex değeri elde edilmiş oldu
            sifrelenmisMetin += alfabe.charAt(yeniIndex);
        }
        System.out.println("Şifrelenmiş metin: " + sifrelenmisMetin);
    }
}