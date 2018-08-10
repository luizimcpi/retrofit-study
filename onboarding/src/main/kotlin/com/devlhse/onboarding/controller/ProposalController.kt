package com.devlhse.onboarding.controller

import com.devlhse.onboarding.model.Proposal
import com.devlhse.onboarding.service.ProposalService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("proposal")
open class ProposalController (val proposalService: ProposalService) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    open fun createProposal(@RequestBody proposal: Proposal): ResponseEntity<Any> {
        val proposalResponse = proposalService.saveProposal(proposal)
        return ResponseEntity.status(HttpStatus.CREATED).body(proposalResponse)
    }

    @GetMapping(path = ["/{id}"])
    open fun getProposal(@PathVariable id: String): ResponseEntity<Any> {
        println("CLIENT IS CALLING THIS ENDPOINT...")
        val proposalResponse = proposalService.findProposalById(id)
        return ResponseEntity.status(HttpStatus.OK).body(proposalResponse)
    }

}