package agustos_28.manav;

    /*
* manav alisveris programi yaziniz.

   1. Adim : urun listesinden urun sectir ve kac kilo oldugunu sor.
   2. Adim : Baska bir urun almak isteyip istemedigini sor.
             istemiyorsa toplam miktari goster, istiyorsa tekrar urun sectir.
             Bu islemi alisverisi bitirmek isteyene kadar tekrarla.
   3. Adim : Musteri her urun sectiginde, aldigi urunun fiyatini toplam fiyata ekle.
   4. Adim : Alisveris bitince toplam odemesi gereken tutari goster
 */
    public class Urun {
    private String urunAdi;
    private double urunFiyati;

        public Urun() {
        }

        public Urun(String urunAdi, double urunFiyati) {
            this.urunAdi = urunAdi;
            this.urunFiyati = urunFiyati;
        }

        public String getUrunAdi() {
            return urunAdi;
        }

        public double getUrunFiyati() {
            return urunFiyati;
        }
    }
