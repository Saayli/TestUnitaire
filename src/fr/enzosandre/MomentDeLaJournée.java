package fr.enzosandre;

import java.time.LocalTime;
import java.util.Date;

public enum MomentDeLaJournée {
    Matin("Matin"), AprèsMidi("AprèsMidi"), Soir("Soir"), Nuit("Nuit"), Inconnu("Incounu");
    private final String moment;

    MomentDeLaJournée(String moment) {
        this.moment = moment;
    }


    public static MomentDeLaJournée getMoment(LocalTime ts) {
        return switch (ts.getHour()) {
            case 0, 1, 2, 3, 4, 5 -> Nuit;
            case 6, 7, 8, 9, 10, 11 -> Matin;
            case 12,13, 14, 15, 16, 17 -> AprèsMidi;
            case 18, 19, 20, 21, 22, 23 -> Soir;
            default -> Inconnu;
        };
    }
}

//
//public class MomentDeLaJournée {
//
//    public static MomentDeLaJournée Matin = new MomentDeLaJournée("Matin");
//    public static MomentDeLaJournée AprèsMidi = new MomentDeLaJournée("Après-midi");
//    public static MomentDeLaJournée Soir = new MomentDeLaJournée("Soir");
//    public static MomentDeLaJournée Nuit = new MomentDeLaJournée("Nuit");
//    public static MomentDeLaJournée Inconnu = new MomentDeLaJournée("Inconnu");
//
//    private final String representation;
//
//    private MomentDeLaJournée(String label) {
//        this.representation = label;
//    }
//
//    @Override
//    public String toString() {
//        return this.representation;
//    }
//
//}