package com.nasdaq.Elections.domain;

public enum Candidate {
    ADLAI_STEVENSON("Ignorance is stubborn and prejudice is hard, hard work for hard working people"),
    CHARLES_A_TOWNE("Life's book is hard to understand. Why couldst thou not remain at school?"),
    ELLIOT_DANFORTH("Vatican takes your breath away, I build Vatican at home"),
    WILLIAM_SULZER("Let those who have failed take courage. Incarceration reforms"),
    JOSEPH_C_SIBLEY("It was at once recognized that he was a reasoner, a wit, a man of affairs," +
            " an orator, and best of all, a strong, courageous man with a big heart and helpful impulses...."),
    ROBERT_E_PATTISON("And so the lion fell in love with the lamb. Meat and leather reform"),
    THEODORE_ROOSEVELT("Do what you can, with what you have, where you are," +
            " continuous improvements"),
    WILLIAM_MCKINLEY( "In the time of darkest defeat, victory may be nearest, War is the key");

    Candidate(String agenda) {
        this.agenda = agenda;
    }

    private final String agenda;

    public String getAgenda() {
        return agenda;
    }
}
