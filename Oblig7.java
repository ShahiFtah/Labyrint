import java.util.Scanner;

public class Oblig7 {
    public static void main(String[] args){
        if (args.length != 1){
            System.out.println("Mangler filnavn som parameter!!");
            return;
        }

        String filnavn = args[0]; //tar inn filnavn
        Labyrint labyrint = new Labyrint(filnavn); //kaller på filnavn med objektet Labyrint i kontruktøren som kaller på metoden inne i labyrinten som leser of lager rutene. her vil labyrint printes etter at rutene er laget

        System.out.println("Slik ser labyrinten ut:");
        System.out.println(labyrint); //printer også ut labyrint

        Scanner scanner = new Scanner(System.in);

        boolean avslutt = false;
        
        while(!avslutt){
            System.out.println("Skriv inn koordinater <rad> <kolonne> ('-1 -1' for å avslutte)");
            
            int rad = scanner.nextInt();
            int kolonne = scanner.nextInt();
            //Over skriver jeg to variabler som tar imot rader og kolonner, der brukerne kan skrive det på samme linje med mellomrom, for her tar første verdi som rad og andre som kolonne
            
            if (rad == -1 || kolonne == -1) {
                avslutt = true;
                break;
            }
            //hvis rad eller kolonne eller begge to er -1 stopper while-løkka og programmet avsluttes
            Rute[][] ruter = labyrint.hentLabyrint(); //henter labyrint 

            System.out.println("Åpninger:");
            
            if (rad < 0 || rad >= ruter.length || kolonne < 0 || kolonne >= ruter[0].length) {
                System.out.println("Ugyldige koordinater.");
                continue;
            } //hvis koorinatene som brukeren gir er utenfor koordinatene senter vi en melding

            Rute startRute = ruter[rad][kolonne];
            if (startRute instanceof SortRute) {
                System.out.println("Kan ikke starte i sort rute.");
                continue;
            }//hvis koorinatene som er valg er av en sort rute, vil vi sende en beskjed

            
            labyrint.finnUtveiFra(rad, kolonne); //ellers kaller den på metoden med rad og kolonne fra brukeren

        }
        System.out.println("Programmet avsluttes.");
        scanner.close();
    }
}