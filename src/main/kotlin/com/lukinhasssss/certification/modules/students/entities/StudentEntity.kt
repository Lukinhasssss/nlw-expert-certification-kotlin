package com.lukinhasssss.certification.modules.students.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "students")
class StudentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,

    @Column(name = "email", unique = true, nullable = false)
    val email: String,

    @OneToMany(mappedBy = "studentEntity")
    val certificationStudentEntity: List<CertificationStudentEntity>,

    @CreationTimestamp
    val createdAt: LocalDateTime
)
