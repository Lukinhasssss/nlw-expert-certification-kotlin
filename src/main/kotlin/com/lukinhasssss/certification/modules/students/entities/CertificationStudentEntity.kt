package com.lukinhasssss.certification.modules.students.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "certifications")
class CertificationStudentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,

    @Column(name = "technology", length = 100)
    val technology: String,

    @Column(name = "grate", length = 100)
    val grate: Int,

    @Column(name = "student_id")
    val studentID: UUID,

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    val studentEntity: StudentEntity,

    @OneToMany
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    val answersCertificationEntity: List<AnswersCertificationEntity>,

    @CreationTimestamp
    val createdAt: LocalDateTime
)
