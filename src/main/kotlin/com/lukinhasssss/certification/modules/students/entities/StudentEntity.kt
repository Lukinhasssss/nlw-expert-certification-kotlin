package com.lukinhasssss.certification.modules.students.entities

import java.util.UUID

data class StudentEntity(

    val id: UUID,
    val email: String,
    val certificationStudentEntity: List<CertificationStudentEntity>
)