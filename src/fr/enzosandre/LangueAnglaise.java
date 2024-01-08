package fr.enzosandre;

public class LangueAnglaise implements LangueInterface {

    @Override
    public String Féliciter() {
        return Expressions.WellSaid;
    }

    @Override
    public String Saluer(MomentDeLaJournée moment) {
        return Expressions.Hello(moment);
    }

    @Override
    public String AuRevoir(MomentDeLaJournée moment) {
        return Expressions.GoodBye(moment);
    }

    @Override
    public String toString() {
        return "Langue Anglaise";
    }

}