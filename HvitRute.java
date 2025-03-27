public class HvitRute extends Rute{

    public HvitRute(int rad, int kol, Labyrint labyrint) {
        super(rad, kol, labyrint);
    }
    //henter alle verdiene ved hjelp av super

    @Override
    public String toString() {
        return ".";
    } 

    @Override
    public void finn(Rute fra) {
        if (fra != nord) {
            nord.finn(this);
        }
        if (fra != sør) {
            sør.finn(this);
        }
        if (fra != vest) {
            vest.finn(this);
        }
        if (fra != øst) {
            øst.finn(this);
        }
    }
    //Denne metoden utforsker mulige veier fra den nåværende ruten ved å kalle på finn på hver av sine naboruter, unntatt ruten den kom fra
    //if setningene sjekker om fra ikke er naboruten til nord/sør/øst/vest. Hvis fra nord ikke er naboruten i nord, betyr dette at vi ikke kom fra nord, som betyr at vi kan gå den retningen. 
}