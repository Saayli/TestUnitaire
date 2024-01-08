package fr.enzosandre.test.utilities;

import fr.enzosandre.LangueInterface;

public class LangueFake implements LangueInterface {
    private String félicitations;
    private String salutations;
    private String aurevoir;

    public LangueFake(){
        var comportementParDéfaut = new LangueStub();
        this.félicitations = comportementParDéfaut.Féliciter();
        this.salutations = comportementParDéfaut.Saluer();
        this.aurevoir = comportementParDéfaut.AuRevoir();
    }


    @Override
    public String Féliciter() {
        return this.félicitations;
    }

    @Override
    public String Saluer() {
        return this.salutations;
    }

    @Override
    public String AuRevoir() {
        return this.aurevoir;
    }

    public void FéliciterAvec(String félicitations) {
        this.félicitations = félicitations;
    }
}
