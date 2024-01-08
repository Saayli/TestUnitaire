package fr.enzosandre;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguesTest {

    static Stream<Arguments> casTestFélicitations(){
        return Stream.of(
                Arguments.of(new LangueFrançaise(), Expressions.BienDit),
                Arguments.of(new LangueAnglaise(), Expressions.WellSaid)
        );
    }

    @ParameterizedTest
    @MethodSource("casTestFélicitations")
    public void testFélicitations(LangueInterface langue, String félicitationsAttendues){
        // ETANT DONNE la <langue>
        // QUAND on félicite
        var félicitationsObtenues = langue.Féliciter();

        // ALORS on obtient <félicitationsAttendues>
        assertEquals(félicitationsAttendues, félicitationsObtenues);
    }

    static Stream<Arguments> casTestBonjour(){
        return Stream.of(
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.Inconnu, "Bonjour"),
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.Matin, "Bonjour"),
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.AprèsMidi, "Bonjour"),
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.Soir, "Bonsoir"),
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.Nuit, "Bonsoir"),
                Arguments.of(new LangueAnglaise(), MomentDeLaJournée.Matin, "Good morning"),
                Arguments.of(new LangueAnglaise(), MomentDeLaJournée.Inconnu, "Hello"),
                Arguments.of(new LangueAnglaise(), MomentDeLaJournée.AprèsMidi, "Good afternoon"),
                Arguments.of(new LangueAnglaise(), MomentDeLaJournée.Soir, "Good evening"),
                Arguments.of(new LangueAnglaise(), MomentDeLaJournée.Nuit, "Good evening")
        );
    }

    @ParameterizedTest
    @MethodSource("casTestBonjour")
    public void testBonjour(LangueInterface langue, MomentDeLaJournée moment, String salutation){
        // ETANT DONNE la <langue>
        // ET le <momentDeLaJournée>
        // QUAND on salue
        var résultat = langue.Saluer(moment);

        // ALORS on obtient <salutations>
        assertEquals(résultat, salutation);
    }
}