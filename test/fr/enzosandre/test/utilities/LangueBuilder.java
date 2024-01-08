package fr.enzosandre.test.utilities;

import fr.enzosandre.LangueInterface;

public class LangueBuilder {
    public static LangueInterface Default() {
        return new LangueBuilder().Build();
    }

    public LangueBuilder AyantPourFélicitations(String félicitations){

    }

    public LangueInterface Build(){
        return new LangueStub();
    }
}
