package fr.enzosandre.test.utilities;

import fr.enzosandre.LangueInterface;

public class LangueFake implements LangueInterface {
    private String félicitations;
    private String salutations;

    public LangueFake(){
        var comportementParDéfaut = new LangueStub();
        this.félicitations = comportementParDéfaut.Féliciter();
        this.salutations = comportementParDéfaut.Saluer();
    }


    @Override
    public String Féliciter() {
        return this.félicitations;
    }

    @Override
    public String Saluer() {
        return this.salutations;
    }

    public void FéliciterAvec(String félicitations) {
        this.félicitations = félicitations;
    }
}
