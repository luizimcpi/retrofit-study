package com.devlhse.onboarding.service

import com.devlhse.onboarding.model.Proposal
import com.devlhse.onboarding.repository.ProposalRepository
import org.joda.time.DateTime
import org.springframework.stereotype.Service
import java.util.*

@Service
open class ProposalService (val proposalRepository: ProposalRepository) {

    open fun saveProposal(proposal: Proposal): Any? {
        proposal.creationDate = DateTime().toDate()
        proposal.dueDate = DateTime().plusDays(30).toDate()
        return proposalRepository.save(proposal)
    }

    open fun findProposalById(id: String): Optional<Proposal> {
        return proposalRepository.findById(id)
    }
}