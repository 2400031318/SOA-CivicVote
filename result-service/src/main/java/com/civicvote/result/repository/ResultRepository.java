package com.civicvote.result.repository;

import com.civicvote.result.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {

    Optional<Result> findByElectionIdAndCandidateId(
            Long electionId,
            Long candidateId
    );

    List<Result> findByElectionId(Long electionId);
}