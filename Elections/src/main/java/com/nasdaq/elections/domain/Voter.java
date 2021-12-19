package com.nasdaq.elections.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Voter")
public class Voter {

    @Id
    @NotNull(message = "Galaxy citizen identification code must be present")
    private Long id;
    @NotNull(message = "Ballot must be present")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Ballot ballot;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Ballot getBallot() {

        return ballot;
    }

    public void setBallot(Ballot ballot) {

        this.ballot = ballot;
    }
}
