package fr.enzosandre.test.utilities.langue;

import fr.enzosandre.LangueInterface;

public class LangueSpy implements LangueInterface {
    private boolean féliciterAÉteInvoqué;

    @Override
    public String Féliciter() {
        this.féliciterAÉteInvoqué = true;
        return "";
    }

    @Override
    public String Saluer() {
        return "";
    }

    @Override
    public String AuRevoir() {
        return "";
    }

    public boolean FéliciterAÉtéInvoqué() {
        return this.féliciterAÉteInvoqué;
    }
}
