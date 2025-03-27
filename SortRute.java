public class SortRute extends Rute {

    public SortRute(int rad, int kol, Labyrint labyrint) {
        super(rad, kol, labyrint);
    }

    @Override
    public void finn(Rute fra) {
        // Sorte ruter har ingen vei videre
    }

    @Override
    public String toString() {
        return "#";
    }


}