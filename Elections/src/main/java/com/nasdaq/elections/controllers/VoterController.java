package com.nasdaq.elections.controllers;

import com.nasdaq.elections.domain.Voter;
import com.nasdaq.elections.services.VoterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/voters")
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {

        this.voterService = voterService;
    }

    @Operation(summary = "You need to provide voters Region and ballot")
    @ApiResponse(responseCode = "200", description = "You voted, thank you for participation")
    @ApiResponse(responseCode = "405", description = "You already voted, take a seat and wait for results")
    @PostMapping
    public ResponseEntity<Voter> vote(@Valid @RequestBody Voter voter) {

        return new ResponseEntity<>(voterService.vote(voter), HttpStatus.OK);

    }
}
