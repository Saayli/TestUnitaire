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
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.Inconnu, Expressions.Bonjour),
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.Matin, Expressions.Bonjour),
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.AprèsMidi, Expressions.Bonjour),
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.Soir, Expressions.Bonsoir),
                Arguments.of(new LangueFrançaise(), MomentDeLaJournée.Nuit, Expressions.Bonsoir),
                Arguments.of(new LangueAnglaise(), MomentDeLaJournée.Matin, Expressions.Hello)
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