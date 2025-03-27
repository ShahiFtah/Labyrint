public abstract class Rute {
    protected int rad;
    protected int kol;
    protected Labyrint labyrint;
    protected Rute nord;
    protected Rute sør;
    protected Rute vest;
    protected Rute øst;

    public Rute(int rad, int kol, Labyrint labyrint){
        this.rad = rad;
        this.kol = kol;
        this.labyrint = labyrint;
    }///tar inn parameterene 

    public abstract void finn(Rute fra); //lager en signatur slik at subklassene må ha metoden
    
    public void settNaboer(Rute[][] labyrint) {
        if (gyldigPosisjon(rad - 1, kol)) {
            nord = labyrint[rad - 1][kol];
        }
        if (gyldigPosisjon(rad + 1, kol)) {
            sør = labyrint[rad + 1][kol];
        }
        if (gyldigPosisjon(rad, kol - 1)) {
            vest = labyrint[rad][kol - 1];
        }
        if (gyldigPosisjon(rad, kol + 1)) {
            øst = labyrint[rad][kol + 1];
        }
    }
//metoden over tar inn todimansjonal aray av ruter labyrint og oppdaterer naboene til den ruten de er på

    private boolean gyldigPosisjon(int rad, int kolonne) {
        return rad >= 0 && rad < labyrint.rader && kolonne >= 0 && kolonne < labyrint.kolonner;
    }

}