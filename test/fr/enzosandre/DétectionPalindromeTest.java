package fr.enzosandre;

import fr.enzosandre.test.utilities.*;
import fr.enzosandre.test.utilities.langue.LangueSpy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DétectionPalindromeTest {
    @ParameterizedTest
    @ValueSource(strings = {"test", "epsi"})
    @DisplayName("La chaîne entrée est renvoyée à l'envers")
    public void testMiroir(String chaîne) {
        // ETANT DONNE une chaîne n'étant pas un palindrome
        // QUAND on vérifie si c'est un palindrome
        String résultat = VérificationPalindromeBuilder.Default().Vérifier(chaîne);

        // ALORS on obtient son miroir
        String inversion = new StringBuilder(chaîne)
                .reverse()
                .toString();

        assertTrue(résultat.contains(inversion));
    }

    @Test
    @DisplayName("Si la chaîne est un palindrome, on félicite")
    public void testPalindrome(){
        // ETANT DONNE un palindrome
        String palindrome = "radar";

        var félicitations = "Félicitations";
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(
                        langue -> langue.AyantPourFélicitations(félicitations)
                )
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat = vérificateur.Vérifier(palindrome);

        // ALORS la chaîne est répétée, suivie de félicitations dans cette langue
        String attendu = palindrome + System.lineSeparator() + félicitations;
        assertTrue(résultat.contains(attendu));
    }

    @Test
    @DisplayName("Si pas un palindrome, on ne félicite pas")
    public void testSansPalindromePasDeFélicitations(){
        // ETANT DONNE un non-palindrome
        String palindrome = "test";
        var langueSpy = new LangueSpy();
        var vérificateur = new VérificationPalindromeBuilder()
                .AyantPourLangue(langueSpy)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        vérificateur.Vérifier(palindrome);

        // ALORS le résultat ne comporte pas de félicitations
        assertFalse(langueSpy.FéliciterAÉtéInvoqué());
    }

    static Stream<Arguments> casTestBonjour() {
        return Stream.of(
                Arguments.of("test", new LangueFrançaise(), MomentDeLaJournée.Matin, "Bonjour"),
                Arguments.of("radar", new LangueFrançaise(), MomentDeLaJournée.Matin, "Bonjour"),
                Arguments.of("test", new LangueAnglaise(), MomentDeLaJournée.Matin, "Good morning"),
                Arguments.of("radar", new LangueAnglaise(), MomentDeLaJournée.Matin, "Good morning")
        );
    }

    @ParameterizedTest
    @MethodSource("casTestBonjour")
    @DisplayName("Avant toute chose, on salue")
    public void testBonjour(String chaîne, LangueInterface langue, MomentDeLaJournée momentDeLaJournée, String salutations){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant une <langue>
        // ET que nous sommes le <momentDeLaJournée>
        var vérification = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourMomentDeLaJournée(momentDeLaJournée)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat =  vérification.Vérifier(chaîne);

        // ALORS toute réponse est précédée de <salutations>
        // dans cette <langue> à ce moment de la journée
        String[] lines = résultat.split(System.lineSeparator());
        assertEquals(salutations, lines[0]);
    }
    static Stream<Arguments> casTestBonjourSelonHeure() {
        return Stream.of(
                Arguments.of("test", new LangueFrançaise(), LocalTime.of(8, 0, 0), "Bonjour"),
                Arguments.of("radar", new LangueFrançaise(), LocalTime.of(4,0,0), "Bonjour"),
                Arguments.of("test", new LangueAnglaise(), LocalTime.of(12,0,0), "Good morning"),
                Arguments.of("test", new LangueAnglaise(), LocalTime.of(19,0,0), "Good morning")
        );
    }

    @ParameterizedTest
    @MethodSource("casTestBonjourSelonHeure")
    @DisplayName("Avant toute chose, on salue selon l'heure")
    public void testBonjourSelonHeure(String chaîne, LangueInterface langue, LocalTime momentDeLaJournée, String salutations){
        // ETANT DONNE une chaîne
        // ET un utilisateur parlant une <langue>
        // ET que nous sommes le <momentDeLaJournée>
        var vérification = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourMoment(momentDeLaJournée)
                .Build();

        // QUAND on vérifie si c'est un palindrome
        String résultat =  vérification.Vérifier(chaîne);

        // ALORS toute réponse est précédée de <salutations>
        // dans cette <langue> à ce moment de la journée
        String[] lines = résultat.split(System.lineSeparator());
        assertEquals(salutations, lines[0]);
    }

    static Stream<Arguments> casTestAurevoir() {
        return Stream.of(
                Arguments.of("test", new LangueFrançaise(), MomentDeLaJournée.Matin, "Bonjour"),
                Arguments.of("radar", new LangueFrançaise(), MomentDeLaJournée.Matin, "Bonjour"),
                Arguments.of("test", new LangueAnglaise(), MomentDeLaJournée.Matin, "Good morning"),
                Arguments.of("radar", new LangueAnglaise(), MomentDeLaJournée.Matin, "Good morning")
        );
    }

    @ParameterizedTest
    @MethodSource("casTestAurevoir")
    @DisplayName("Après avoir répondu, on s'acquitte")
    public void testAuRevoir(String chaîne, LangueInterface langue, MomentDeLaJournée momentDeLaJournée, String expression){
        var vérification = new VérificationPalindromeBuilder()
                .AyantPourLangue(langue)
                .AyantPourMomentDeLaJournée(momentDeLaJournée)
                .Build();

        String résultat =  vérification.Vérifier(chaîne);

        String[] lines = résultat.split(System.lineSeparator());
        assertEquals(expression, lines[0]);
    }


}
