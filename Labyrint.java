import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labyrint {
    protected int rader;
    protected int kolonner; 
    protected Rute[][] labyrint;

    public Labyrint(String filnavn){
        //jeg kan bare kalle på metoden uten å lage try/catch for å la metoden se om det er riktig istedetfor i konstruktøren
        try{
            lesFraFil(filnavn); //kaller på metoden under
        } 
        catch(FileNotFoundException e){
            System.err.println("Filen ble ikke funnet.");
        }
        catch (IllegalArgumentException e) {
            System.err.println("Feil filformat.");
        }
    }
    
    private void lesFraFil(String filnavn) throws FileNotFoundException {
        File fil = new File(filnavn);
        Scanner scanner = new Scanner(fil);

        //vi leser størrelsene:
        rader = scanner.nextInt();
        kolonner = scanner.nextInt();
        scanner.nextLine();

        //lager todimensjonale arrayet:
        labyrint = new Rute[rader][kolonner];
        //går gjennom løkken og legger til symbolene fra filen inn til riktig posisjon
        for (int rad = 0; rad < rader; rad++) {
            String linje = scanner.nextLine(); //leser en linje fra scanner
            for (int kol = 0; kol < kolonner; kol++){
                char symbol = linje.charAt(kol);//henter tegnet på posisjon kol i linje, siden i hver posisjon er det en verdi for char, så vi setter inn kol som gir symbolen fra filen i den raden som er gitt

                if (symbol == '#'){
                    labyrint[rad][kol] = new SortRute(rad, kol, this);
                }
                else if ((rad == 0 || rad == rader - 1 || kol == 0 || kol == kolonner - 1) && symbol == '.') {
                    labyrint[rad][kol] = new Aapning(rad, kol, this);
                }
                else if (symbol == '.') {
                    labyrint[rad][kol] = new HvitRute(rad, kol, this);
                }
            }
        }
    
        System.out.println(this);
        //sørge for at naboene blir korrekt satt opp for hver rute i labyrinten
        for (int rad = 0; rad < rader; rad++) {
            for (int kol = 0; kol < kolonner; kol++) {
                Rute rute = labyrint[rad][kol];
                rute.settNaboer(labyrint);
            }
        }

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(); //lager en objekt for å bygge opp tekststrengen
        for (int rad = 0; rad < rader; rad++) {//iterer gjennom radene i labyrinten
            for (int kolonne = 0; kolonne < kolonner; kolonne++) {//iterer gjennom kolonnene i labyrinten 
                sb.append(labyrint[rad][kolonne]); //legger til nåværende rutens objektet til StringBuilder
            }
            sb.append(System.lineSeparator());//legger til en linjeskift slik at ikke alt ligger på én linje
        }
        return sb.toString();//konverterer objektet til en tekststreng og returnerer den. Vi kan også bare skrive return sb
    }
    //

    public Rute[][] hentLabyrint() {
        return labyrint;
    }

    public void finnUtveiFra(int rad, int kol) {
        if (gyldigPosisjon(rad, kol)) {
            Rute startRute = labyrint[rad][kol];
            startRute.finn(null); //kaller på metpden finn som ligger i subklassene til RTute
        } else {
            System.err.println("Ugyldig startposisjon.");
        }
    }//v itrenger egnetlig ikke en sjekk her, for vi har lagt en sjekk inne i Oblig7.java- for her sjekekr den om det er gyldige koordinater før vi sender det til finnUtveiFra. ,en for sikkerhet har vi if/else her også

    private boolean gyldigPosisjon(int rad, int kol) {
        return rad >= 0 && rad < rader && kol >= 0 && kol < kolonner;
    } //en sjekk-metode som sjekker om metoden er innenfor den todimensjonale labyrinten eller ikke: returnerer true eller false

}
