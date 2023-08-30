package agustos_28_geometrik;

public class Runner {
    public static void main(String[] args) {

        Dikdortgen dikdortgen = new Dikdortgen(3, 5);
        dikdortgen.cevre();
        dikdortgen.alan();

        Daire daire = new Daire(3);
        daire.alan();
        daire.cevre();
    }


}
