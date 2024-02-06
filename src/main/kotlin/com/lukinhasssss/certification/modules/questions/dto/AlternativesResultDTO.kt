package com.lukinhasssss.certification.modules.questions.dto

import com.lukinhasssss.certification.modules.questions.entities.AlternativesEntity
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import java.util.UUID

data class AlternativesResultDTO(

    val id: UUID,
    val description: String
) {

    companion object {
        fun with(alternatives: AlternativesEntity) = with(alternatives) {
            AlternativesResultDTO(id = id, description = description)
        }
    }
}
