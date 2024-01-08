package fr.enzosandre;

public class VérificationPalindrome {
    private final LangueInterface langue;
    private final MomentDeLaJournée moment;

    public VérificationPalindrome(LangueInterface langue, MomentDeLaJournée moment) {
        this.langue = langue;
        this.moment = moment;
    }

    public String Vérifier(String chaîne) {
        String miroir =  new StringBuilder(chaîne)
                .reverse()
                .toString();

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(this.langue.Saluer());
        resultBuilder.append(System.lineSeparator());
        resultBuilder.append(miroir);
        resultBuilder.append(System.lineSeparator());

        if(miroir.equals(chaîne)) {
            resultBuilder.append(this.langue.Féliciter());
            resultBuilder.append(System.lineSeparator());
        }

        resultBuilder.append(this.langue.AuRevoir());
        return resultBuilder.toString();
    }
}