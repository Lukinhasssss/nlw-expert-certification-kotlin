package com.lukinhasssss.certification.modules.questions.dto

import com.lukinhasssss.certification.modules.questions.entities.QuestionEntity
import java.util.UUID

data class QuestionResultDTO(

    val id: UUID,
    val technology: String,
    val description: String,

    val alternatives: List<AlternativesResultDTO>
) {

    companion object {
        fun with(questionEntity: QuestionEntity) = with(questionEntity) {
            QuestionResultDTO(
                id = id,
                technology = technology,
                description = description,
                alternatives = alternatives.map { AlternativesResultDTO.with(it) }
            )
        }
    }
}
