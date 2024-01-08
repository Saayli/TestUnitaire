package fr.enzosandre.test.utilities;

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

    public boolean FéliciterAÉtéInvoqué() {
        return this.féliciterAÉteInvoqué;
    }
}
