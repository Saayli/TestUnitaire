package fr.enzosandre;

public class LangueFrançaise implements LangueInterface {
    @Override
    public String Féliciter() {
        return Expressions.BienDit;
    }

    @Override
    public String Saluer(MomentDeLaJournée momentDeLaJournée) {
        return Expressions.Bonjour(momentDeLaJournée);
    }

    @Override
    public String AuRevoir(MomentDeLaJournée moment) {
        return Expressions.AuRevoir(moment);
    }

    @Override
    public String toString() {
        return "Langue Française";
    }
}
