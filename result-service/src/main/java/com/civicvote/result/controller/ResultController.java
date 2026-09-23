package com.civicvote.result.controller;

import com.civicvote.result.entity.Result;
import com.civicvote.result.repository.ResultRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultRepository resultRepository;

    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @PostMapping
    public ResponseEntity<Result> saveResult(
            @RequestBody Result result) {

        Result savedResult = resultRepository.save(result);

        return ResponseEntity.ok(savedResult);
    }

    @GetMapping("/{electionId}")
    public ResponseEntity<List<Result>> getElectionResults(
            @PathVariable Long electionId) {

        return ResponseEntity.ok(
                resultRepository.findByElectionId(electionId)
        );
    }

    @GetMapping("/{electionId}/{candidateId}")
    public ResponseEntity<Result> getCandidateResult(
            @PathVariable Long electionId,
            @PathVariable Long candidateId) {

        return resultRepository
                .findByElectionIdAndCandidateId(
                        electionId,
                        candidateId
                )
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}