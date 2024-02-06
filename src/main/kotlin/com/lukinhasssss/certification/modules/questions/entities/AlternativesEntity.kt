package com.lukinhasssss.certification.modules.questions.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "alternatives")
class AlternativesEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,

    @Column(name = "description")
    val description: String,

    @Column(name = "is_correct")
    val isCorrect: Boolean,

    @CreationTimestamp
    val createdAt: LocalDateTime? = null
)
