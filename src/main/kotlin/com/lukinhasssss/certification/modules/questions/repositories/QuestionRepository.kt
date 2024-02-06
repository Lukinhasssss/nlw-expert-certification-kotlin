package com.lukinhasssss.certification.modules.questions.repositories

import com.lukinhasssss.certification.modules.questions.entities.QuestionEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface QuestionRepository : JpaRepository<QuestionEntity, UUID> {

    fun findByTechnology(technology: String): List<QuestionEntity>
}
