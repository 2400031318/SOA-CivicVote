package com.civicvote.voting.controller;

import com.civicvote.voting.entity.Vote;
import com.civicvote.voting.repository.VoteRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/votes")
public class VotingController {

    private final VoteRepository voteRepository;

    public VotingController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @PostMapping
    public ResponseEntity<?> castVote(
            @RequestParam Long electionId,
            @RequestParam Long candidateId,
            Authentication authentication) {

        Long voterId = 1L;

        if (voteRepository.existsByVoterIdAndElectionId(
                voterId, electionId)) {

            return ResponseEntity.badRequest()
                    .body("Voter has already voted in this election");
        }

        Vote vote = new Vote(
                voterId,
                electionId,
                candidateId,
                LocalDateTime.now()
        );

        return ResponseEntity.ok(voteRepository.save(vote));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getVoteCount(
            @RequestParam Long electionId,
            @RequestParam Long candidateId) {

        return ResponseEntity.ok(
                voteRepository.countByElectionIdAndCandidateId(
                        electionId, candidateId
                )
        );
    }
}