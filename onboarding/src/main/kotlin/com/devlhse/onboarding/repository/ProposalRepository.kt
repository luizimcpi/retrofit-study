package com.devlhse.onboarding.repository

import com.devlhse.onboarding.model.Proposal
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProposalRepository : MongoRepository<Proposal, String>
