package fr.enzosandre;

import com.sun.nio.sctp.SendFailedNotification;
import lombok.AllArgsConstructor;

import static fr.enzosandre.MomentDeLaJournée.*;

public class Expressions {
    public static final String BienDit = "Bien dit !";
    public static final String WellSaid = "Well said !";

    public static String AuRevoir(MomentDeLaJournée momentDeLaJournée) {
        return switch (momentDeLaJournée) {
            case Matin -> "Bonne fin de matinée";
            case AprèsMidi -> "Bonne fin de journée";
            case Soir, Nuit -> "Bonne nuit";
            default -> "Au revoir";
        };
    }

    public static String GoodBye(MomentDeLaJournée momentDeLaJournée) {
        return switch (momentDeLaJournée) {
            case Matin -> "Good morning";
            case AprèsMidi -> "Have a nice days";
            case Soir, Nuit -> "Pleasant night";
            default -> "Good bye";
        };
    }

    public static String Bonjour(MomentDeLaJournée momentDeLaJournée) {
        return switch (momentDeLaJournée) {
            case Soir, Nuit -> "Bonsoir";
            default -> "Bonjour";
        };
    }

    public static String Hello(MomentDeLaJournée momentDeLaJournée) {
        return switch (momentDeLaJournée) {
            case Matin -> "Good morning";
            case AprèsMidi -> "Good afternoon";
            case Soir, Nuit -> "Good evening";
            default -> "Hello";
        };
    }

}

