package fr.enzosandre;

import fr.enzosandre.Expressions;
import fr.enzosandre.MomentDeLaJournée;
import fr.enzosandre.LangueFrançaise;
import fr.enzosandre.LangueInterface;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MomentsTest {

    static Stream<Arguments> casTestMatin() {
        return Stream.of(
                Arguments.of(MomentDeLaJournée.Matin, LocalTime.of(6, 0, 0)),
                Arguments.of(MomentDeLaJournée.Matin, LocalTime.of(7, 0, 0)),
                Arguments.of(MomentDeLaJournée.Matin, LocalTime.of(8, 0, 0)),
                Arguments.of(MomentDeLaJournée.Matin, LocalTime.of(9, 0, 0)),
                Arguments.of(MomentDeLaJournée.Matin, LocalTime.of(9, 0, 0)),
                Arguments.of(MomentDeLaJournée.Matin, LocalTime.of(10, 0, 0)),
                Arguments.of(MomentDeLaJournée.Matin, LocalTime.of(11, 0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("casTestMatin")
    public void testMatin(String momentAttendu, LocalTime lt) {
        // ETANT DONNE la <langue>
        // QUAND on félicite
        var momentObtenues = MomentDeLaJournée.getMoment(lt);

        // ALORS on obtient <félicitationsAttendues>
        assertEquals(momentObtenues, momentAttendu);
    }

    static Stream<Arguments> casTestApresMidi() {
        return Stream.of(
                Arguments.of(MomentDeLaJournée.AprèsMidi, LocalTime.of(12, 0, 0)),
                Arguments.of(MomentDeLaJournée.AprèsMidi, LocalTime.of(13, 0, 0)),
                Arguments.of(MomentDeLaJournée.AprèsMidi, LocalTime.of(14, 0, 0)),
                Arguments.of(MomentDeLaJournée.AprèsMidi, LocalTime.of(15, 0, 0)),
                Arguments.of(MomentDeLaJournée.AprèsMidi, LocalTime.of(16, 0, 0)),
                Arguments.of(MomentDeLaJournée.AprèsMidi, LocalTime.of(17, 0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("casTestApresMidi")
    public void testApresMidi(String momentAttendu, LocalTime lt) {
        // ETANT DONNE la <langue>
        // QUAND on félicite
        var momentObtenues = MomentDeLaJournée.getMoment(lt);

        // ALORS on obtient <félicitationsAttendues>
        assertEquals(momentObtenues, momentAttendu);
    }

    static Stream<Arguments> casTestSoir() {
        return Stream.of(
                Arguments.of(MomentDeLaJournée.Soir, LocalTime.of(18, 0, 0)),
                Arguments.of(MomentDeLaJournée.Soir, LocalTime.of(19, 0, 0)),
                Arguments.of(MomentDeLaJournée.Soir, LocalTime.of(20, 0, 0)),
                Arguments.of(MomentDeLaJournée.Soir, LocalTime.of(21, 0, 0)),
                Arguments.of(MomentDeLaJournée.Soir, LocalTime.of(22, 0, 0)),
                Arguments.of(MomentDeLaJournée.Soir, LocalTime.of(23, 0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("casTestSoir")
    public void testSoir(String momentAttendu, LocalTime lt) {
        // ETANT DONNE la <langue>
        // QUAND on félicite
        var momentObtenues = MomentDeLaJournée.getMoment(lt);

        // ALORS on obtient <félicitationsAttendues>
        assertEquals(momentObtenues, momentAttendu);
    }

    static Stream<Arguments> casTestNuit() {
        return Stream.of(
                Arguments.of(MomentDeLaJournée.Nuit, LocalTime.of(0, 0, 0)),
                Arguments.of(MomentDeLaJournée.Nuit, LocalTime.of(1, 0, 0)),
                Arguments.of(MomentDeLaJournée.Nuit, LocalTime.of(2, 0, 0)),
                Arguments.of(MomentDeLaJournée.Nuit, LocalTime.of(3, 0, 0)),
                Arguments.of(MomentDeLaJournée.Nuit, LocalTime.of(4, 0, 0)),
                Arguments.of(MomentDeLaJournée.Nuit, LocalTime.of(5, 0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("casTestNuit")
    public void testNuit(String momentAttendu, LocalTime lt) {
        // ETANT DONNE la <langue>
        // QUAND on félicite
        var momentObtenues = MomentDeLaJournée.getMoment(lt);

        // ALORS on obtient <félicitationsAttendues>
        assertEquals(momentObtenues, momentAttendu);
    }

}
