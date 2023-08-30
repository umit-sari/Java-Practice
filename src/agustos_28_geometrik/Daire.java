package agustos_28_geometrik;

public class Daire implements Igeometrik{

    int yaricap;

    public Daire(int yaricap) {
        this.yaricap = yaricap;
    }

    @Override
    public void alan() {
        System.out.println("Dairenin alani : "+3.14*(yaricap*yaricap));

    }

    @Override
    public void cevre() {
        System.out.println("Dairenin cevresi : "+ (2*3.14*yaricap));

    }
}
