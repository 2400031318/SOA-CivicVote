package com.civicvote.election.controller;

import com.civicvote.election.entity.Election;
import com.civicvote.election.repository.ElectionRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elections")
public class ElectionController {

    private final ElectionRepository electionRepository;

    public ElectionController(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    @PostMapping
    public ResponseEntity<Election> createElection(
            @RequestBody Election election) {

        Election savedElection = electionRepository.save(election);

        return ResponseEntity.ok(savedElection);
    }

    @GetMapping
    public ResponseEntity<List<Election>> getAllElections() {

        return ResponseEntity.ok(electionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Election> getElectionById(
            @PathVariable Long id) {

        return electionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}