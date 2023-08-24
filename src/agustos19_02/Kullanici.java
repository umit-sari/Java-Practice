package agustos19_02;

public class Kullanici {
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

    private String kartNo;
    private int sifre;
    private double bakiye;

    public Kullanici(String kartNo,int sifre,double bakiye){
        this.kartNo=kartNo;
        this.sifre=sifre;
        this.bakiye=bakiye;
    }
    public Kullanici(){

    }
    public String getKartNo() {
        return kartNo;
    }

    public void setKartNo(String kartNo) {
        this.kartNo = kartNo;
    }
    public int getSifre() {
        return sifre;
    }
    public void setSifre(int sifre) {
        this.sifre = sifre;
    }
    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }
}
