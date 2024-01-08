package fr.enzosandre.test.utilities.moment;

import fr.enzosandre.MomentDeLaJournée;

import java.time.LocalTime;

public class MomentBuilder {
    LocalTime date = LocalTime.now();
    public static MomentDeLaJournée Default() {
        return MomentDeLaJournée.Inconnu;
    }

    public MomentBuilder AyantPourLocalTime (LocalTime date) {
        this.date = date;
        return this;
    }

    public MomentDeLaJournée Build(){
        return MomentDeLaJournée.getMoment(this.date);
    }
}
