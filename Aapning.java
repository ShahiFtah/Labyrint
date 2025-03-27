

public class Aapning extends HvitRute{

    public Aapning(int rad, int kol, Labyrint labyrint) {
        super(rad, kol, labyrint);
    }//Skriver konstruktøren slik at jeg kan bruke variablene

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public void finn(Rute fra) {
    System.out.println("Fant utvei til åpning på (" + rad + ", " + kol + ")");
    }
    //Siden dette er en extend av HvitRute betyr det at denne finn-metoden skal levere åpninger dersom denne koden blir kalt

}