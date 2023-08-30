package agustos_28_geometrik;

public class Dikdortgen implements Igeometrik{

    int kisaKenar,uzunKenar;

    public Dikdortgen(int kisaKenar, int uzunKenar) {
        this.kisaKenar = kisaKenar;
        this.uzunKenar = uzunKenar;
    }

    @Override
    public void alan() {
        System.out.println("Dikdortgenin alani: "+ kisaKenar*uzunKenar);

    }

    @Override
    public void cevre() {
        System.out.println("Dikdortgenin cevresi : "+2*(kisaKenar+uzunKenar));

    }
}
