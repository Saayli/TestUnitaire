package fr.enzosandre;

public class MomentDeLaJournée {
    public static MomentDeLaJournée Matin = new MomentDeLaJournée("Matin");
    public static MomentDeLaJournée Inconnu = new MomentDeLaJournée("Inconnu");

    private final String representation;

    private MomentDeLaJournée(String label){
        this.representation = label;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}
