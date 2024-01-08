package fr.enzosandre.test.utilities.langue;

import fr.enzosandre.LangueInterface;
import fr.enzosandre.MomentDeLaJournée;

public class LangueStub implements LangueInterface {
    @Override
    public String Féliciter() {
        return "";
    }

    @Override
    public String Saluer(MomentDeLaJournée moment) {
        return "";
    }

    @Override
    public String AuRevoir(MomentDeLaJournée moment) {
        return null;
    }

}