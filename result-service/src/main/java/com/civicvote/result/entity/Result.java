package com.civicvote.result.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "results",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "unique_election_candidate",
            columnNames = {"electionId", "candidateId"}
        )
    }
)
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long electionId;

    @Column(nullable = false)
    private Long candidateId;

    @Column(nullable = false)
    private Long voteCount;

    public Result() {
    }

    public Result(Long electionId, Long candidateId, Long voteCount) {
        this.electionId = electionId;
        this.candidateId = candidateId;
        this.voteCount = voteCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getElectionId() {
        return electionId;
    }

    public void setElectionId(Long electionId) {
        this.electionId = electionId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }
}