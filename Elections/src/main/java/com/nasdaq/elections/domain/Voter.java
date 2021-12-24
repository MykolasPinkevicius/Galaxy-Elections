package com.nasdaq.elections.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Voter")
public class Voter {

    @Id
    @NotNull(message = "Galaxy citizen identification code must be present")
    private Long voterId;
    @NotNull(message = "Ballot must be present")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Ballot ballot;

    public Long getVoterId() {

        return voterId;
    }

    public void setVoterId(Long voterId) {

        this.voterId = voterId;
    }

    public Ballot getBallot() {

        return ballot;
    }

    public void setBallot(Ballot ballot) {

        this.ballot = ballot;
    }
}
