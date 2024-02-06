package com.lukinhasssss.certification.modules.students.repositories

import com.lukinhasssss.certification.modules.students.entities.CertificationStudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface CertificationStudentRepository : JpaRepository<CertificationStudentEntity, UUID> {

    @Query(value = "SELECT c FROM certifications c INNER JOIN c.studentEntity std WHERE std.email = :email AND c.technology = :technology")
    fun findByStudentEmailAndTechnology(email: String, technology: String): List<CertificationStudentEntity>
}
