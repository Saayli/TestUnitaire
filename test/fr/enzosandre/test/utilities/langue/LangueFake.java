package fr.enzosandre.test.utilities.langue;

import fr.enzosandre.LangueInterface;
import fr.enzosandre.MomentDeLaJournée;

import java.util.Dictionary;
import java.util.Hashtable;

public class LangueFake implements LangueInterface {
    private String félicitations;
    private final LangueStub comportementParDéfaut = new LangueStub();
    private final Dictionary<MomentDeLaJournée, String> salutations = new Hashtable<>();

    public LangueFake(){
        this.félicitations = this.comportementParDéfaut.Féliciter();
    }

    @Override
    public String Féliciter() {
        return this.félicitations;
    }

    @Override
    public String Saluer(MomentDeLaJournée moment) {
        var valeur = this.salutations.get(moment);
        if(valeur != null) return valeur;

        return this.comportementParDéfaut.Saluer(moment);
    }

    @Override
    public String AuRevoir(MomentDeLaJournée moment) {
        return null;
    }

    public void FéliciterAvec(String félicitations) {
        this.félicitations = félicitations;
    }

    public void SaluerAvecLe(MomentDeLaJournée momentDeLaJournée, String salutations) {
        this.salutations.put(momentDeLaJournée, salutations);
    }
}