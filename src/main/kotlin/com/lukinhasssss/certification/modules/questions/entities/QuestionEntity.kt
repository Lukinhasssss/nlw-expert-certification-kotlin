package com.lukinhasssss.certification.modules.questions.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "questions")
class QuestionEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,

    @Column(name = "technology", length = 50)
    val technology: String,

    @Column(name = "description")
    val description: String,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    val alternatives: List<AlternativesEntity> = emptyList(),

    @CreationTimestamp
    val createdAt: LocalDateTime? = null
)