package com.lukinhasssss.certification.modules.students.entities

import java.util.UUID

data class AnswersCertificationEntity(

    val id: UUID,
    val certificationID: UUID,
    val studentID: UUID,
    val questionID: UUID,
    val answerID: UUID,
    val isCorrect: Boolean
)
