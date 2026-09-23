package com.civicvote.voting.repository;

import com.civicvote.voting.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByVoterIdAndElectionId(Long voterId, Long electionId);

    Optional<Vote> findByVoterIdAndElectionId(Long voterId, Long electionId);

    long countByElectionIdAndCandidateId(Long electionId, Long candidateId);
}