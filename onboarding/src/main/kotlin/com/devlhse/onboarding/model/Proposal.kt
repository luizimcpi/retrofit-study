package com.devlhse.onboarding.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Proposal(@Id var id: String = UUID.randomUUID().toString(), val documentNumber: String, var creationDate: Date?, var dueDate: Date?)