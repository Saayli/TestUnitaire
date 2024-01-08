package fr.enzosandre.test.utilities;

import fr.enzosandre.LangueInterface;
import fr.enzosandre.MomentDeLaJournée;

import java.util.Dictionary;
import java.util.Optional;

public class LangueBuilder {
    private LangueFake langue = new LangueFake();

    public static LangueInterface Default() {
        return new LangueBuilder().Build();
    }

    public LangueBuilder AyantPourFélicitations(String félicitations){
        this.langue.FéliciterAvec(félicitations);
        return this;
    }

    public LangueInterface Build(){
        return this.langue;
    }

    public LangueBuilder AyantPourSalutationsLe(MomentDeLaJournée momentDeLaJournée, String salutations) {
        this.langue.SaluerAvecLe(momentDeLaJournée, salutations);
        return this;
    }
}