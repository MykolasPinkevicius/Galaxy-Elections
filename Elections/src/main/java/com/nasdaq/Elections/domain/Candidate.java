package com.nasdaq.Elections.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Candidate {
    ADLAI_STEVENSON("Adlai Stevenson", 1, "Ignorance is stubborn and prejudice is hard, hard work for hard working " +
            "people"),
    CHARLES_A_TOWNE("Carles A. Towne", 2, "Life's book is hard to understand. Why couldst thou not remain at school? " +
            "School reform"),
    ELLIOT_DANFORTH("Elliot Fanforth", 3, "Vatican takes your breath away, I build Vatican at home"),
    WILLIAM_SULZER("William Sulzer", 4, "Let those who have failed take courage. Incarceration reforms"),
    JOSEPH_C_SIBLEY("Joseph C. Sibley", 5, "It was at once recognized that he was a reasoner, a wit, a man of affairs," +
            " an orator, and best of all, a strong, courageous man with a big heart and helpful impulses...."),
    ROBERT_E_PATTISON("Robert E. Pattison", 6, "And so the lion fell in love with the lamb. Meat and leather reform"),
    THEODORE_ROOSEVELT("Theodore Roosevelt", 7, "Do what you can, with what you have, where you are," +
            " continuous improvements"),
    WILLIAM_MCKINLEY("William McKinley", 8, "In the time of darkest defeat, victory may be nearest, War is the key");

    private final String name;
    private final int ballotNumber;
    private final String agenda;

    Candidate(String name, int ballotNumber, String agenda) {
        this.name = name;
        this.agenda = agenda;
        this.ballotNumber = ballotNumber;
    }

    public String getName() {
        return name;
    }

    public int getBallotNumber() {
        return ballotNumber;
    }

    public String getAgenda() {
        return agenda;
    }
}
