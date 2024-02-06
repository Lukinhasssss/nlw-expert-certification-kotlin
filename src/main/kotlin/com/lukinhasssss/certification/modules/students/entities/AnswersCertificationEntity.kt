package com.lukinhasssss.certification.modules.students.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "answers_certification_students")
class AnswersCertificationEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,

    @Column(name = "certification_id")
    val certificationID: UUID,

    @ManyToOne
    @JoinColumn(name = "certification_id", insertable = false, updatable = false)
    val certificationStudentEntity: CertificationStudentEntity,

    @Column(name = "student_id")
    val studentID: UUID,

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    val studentEntity: StudentEntity,

    @Column(name = "question_id")
    val questionID: UUID,

    @Column(name = "asnwer_id")
    val answerID: UUID,

    @Column(name = "is_correct")
    val isCorrect: Boolean,

    @CreationTimestamp
    val createdAt: LocalDateTime
)
