package fr.enzosandre.test.utilities;

import fr.enzosandre.LangueInterface;
import fr.enzosandre.MomentDeLaJournée;
import fr.enzosandre.VérificationPalindrome;

import java.util.function.Function;

public class VérificationPalindromeBuilder {
    private LangueInterface langue = LangueBuilder.Default();
    private MomentDeLaJournée moment = MomentDeLaJournée.Inconnu;

    public static VérificationPalindrome Default() {
        return new VérificationPalindromeBuilder().Build();
    }

    public VérificationPalindromeBuilder AyantPourLangue(LangueInterface langue){
        this.langue = langue;
        return this;
    }

    public VérificationPalindromeBuilder AyantPourLangue(Function<LangueBuilder, LangueBuilder> configuration) {
        var langueBuilder = new LangueBuilder();
        langueBuilder = configuration.apply(langueBuilder);
        this.langue = langueBuilder.Build();

        return this;
    }

    public VérificationPalindrome Build() {
        return new VérificationPalindrome(this.langue, this.moment);
    }

    public VérificationPalindromeBuilder AyantPourMomentDeLaJournée(MomentDeLaJournée momentDeLaJournée) {
        this.moment = momentDeLaJournée;
        return this;
    }
}
