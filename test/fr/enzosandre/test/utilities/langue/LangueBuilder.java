package fr.enzosandre.test.utilities.langue;

import fr.enzosandre.LangueInterface;

public class LangueBuilder {
    public static LangueInterface Default() {
        return new LangueBuilder().Build();
    }

    public LangueBuilder AyantPourFélicitations(String félicitations){
        return this;
    }

    public LangueInterface Build(){
        return new LangueStub();
    }
}
