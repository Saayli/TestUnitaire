package fr.enzosandre.test.utilities;

import fr.enzosandre.LangueInterface;
import fr.enzosandre.MomentDeLaJournée;

public class LangueSpy implements LangueInterface {
    private boolean féliciterAÉteInvoqué;

    @Override
    public String Féliciter() {
        this.féliciterAÉteInvoqué = true;
        return "";
    }

    @Override
    public String Saluer(MomentDeLaJournée moment) {
        return "";
    }

    public boolean FéliciterAÉtéInvoqué() {
        return this.féliciterAÉteInvoqué;
    }
}