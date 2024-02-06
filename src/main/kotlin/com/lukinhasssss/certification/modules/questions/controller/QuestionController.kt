package com.lukinhasssss.certification.modules.questions.controller

import com.lukinhasssss.certification.modules.questions.dto.QuestionResultDTO
import com.lukinhasssss.certification.modules.questions.repositories.QuestionRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/questions"])
class QuestionController(
    private val questionRepository: QuestionRepository
) {

    @GetMapping(value = ["/technologies/{technology}"])
    fun findByTechnology(@PathVariable technology: String): List<QuestionResultDTO> =
        questionRepository.findByTechnology(technology).map {
            QuestionResultDTO.with(it)
        }
}
