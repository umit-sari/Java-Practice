package agustos14;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
     /*
     2- Registration(Kayıt) isminde bir class oluşturun ve register()(kayıtAl()) isminde bir metod
     ekleyerek Kullanıcıdan user ismini alarak ArrayList e ekleyin ve bu list i
     return edin.
     3- Registration(Kayıt) classı na aynı zamanda kendine verilen
     ArrayListteki userlardan(kullanıcı) her dakikanın ilk 10  saniyesinde kaydolanları
     yazdıran printHappyUsers(sanslıKullanıcı) isminde bir metod daha ekleyiniz.
     */

    static ArrayList<User> kullanicilar=new ArrayList<>(); // bu arratlistin içinde user tipinde veriler tutulacak
    static Scanner scan=new Scanner(System.in);

    static ArrayList<User> register(){
        System.out.println("Lütfen isminizi giriniz: ");
        String name= scan.nextLine();
        LocalDateTime time=LocalDateTime.now();// o andaki sistem tarihini atar
        User kullanici=new User(name,time);// parametreli cons. kullanarak user class ından obje oluşturduk
        kullanicilar.add(kullanici);
        return kullanicilar;

    }
     static void printHappyUsers(ArrayList<User> list) {
         for (User each : list) {
            /*
            Registration(Kayıt) classı na aynı zamanda kendine verilen
     ArrayListteki userlardan(kullanıcı) her dakikanın ilk 10  saniyesinde kaydolanları
     yazdıran printHappyUsers(sanslıKullanıcı) isminde bir metod daha ekleyiniz.
             */
             if (each.registerDate.getSecond() <= 10) {
                 System.out.println(each.name + " tebrikler kazandınız");
             } else {
                 System.out.println(each.name + "bu sefer olmadı başka sefere");
             }
         }
     }
    void kullaniciListesi(ArrayList<User> list) {
        for (User each:list) {
            System.out.println("İsim: "+each.name+"  Kayıt zamanı: "+each.registerDate);
        }
    }
}

