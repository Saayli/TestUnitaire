package fr.enzosandre;

import java.sql.Timestamp;
import java.time.LocalTime;

public class VérificationPalindrome {
    private final LangueInterface langue;
    private final MomentDeLaJournée moment;

    public VérificationPalindrome(LangueInterface langue, LocalTime lt) {
        this.langue = langue;
        this.moment = MomentDeLaJournée.getMoment(lt);
    }

    public VérificationPalindrome(LangueInterface langue, MomentDeLaJournée momentDeLaJournée) {
        this.langue = langue;
        this.moment = momentDeLaJournée;
    }

    public String Vérifier(String chaîne) {
        String miroir =  new StringBuilder(chaîne)
                .reverse()
                .toString();

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(this.langue.Saluer(moment));
        resultBuilder.append(System.lineSeparator());
        resultBuilder.append(miroir);
        resultBuilder.append(System.lineSeparator());

        if(miroir.equals(chaîne)) {
            resultBuilder.append(this.langue.Féliciter());
            resultBuilder.append(System.lineSeparator());
        }

        resultBuilder.append(this.langue.AuRevoir(moment));
        return resultBuilder.toString();
    }
}