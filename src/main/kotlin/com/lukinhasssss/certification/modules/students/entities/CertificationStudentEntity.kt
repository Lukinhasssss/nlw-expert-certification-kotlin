package com.lukinhasssss.certification.modules.students.entities

import java.util.UUID

data class CertificationStudentEntity(

    val id: UUID,
    val studentId: UUID,
    val technology: String,
    val grate: Int,
    val answersCertificationEntity: List<AnswersCertificationEntity>
)
