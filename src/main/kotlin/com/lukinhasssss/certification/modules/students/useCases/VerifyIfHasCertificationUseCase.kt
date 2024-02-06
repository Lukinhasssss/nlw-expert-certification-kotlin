package com.lukinhasssss.certification.modules.students.useCases

import com.lukinhasssss.certification.modules.students.dto.VerifyHasCertificationDTO
import com.lukinhasssss.certification.modules.students.repositories.CertificationStudentRepository
import com.lukinhasssss.certification.utils.Logger
import org.springframework.stereotype.Service

@Service
class VerifyIfHasCertificationUseCase(
    private val certificationStudentRepository: CertificationStudentRepository
) {

    companion object {
        private const val USECASE_LOG_CODE = "USECASE"
        private const val REPOSITORY_LOG_CODE = "REPOSITORY"
    }

    fun execute(input: VerifyHasCertificationDTO): Boolean = with(input) {
        Logger.info(
            logCode = USECASE_LOG_CODE,
            message = "Start of verification if student has certification",
            payload = input
        )

        val result = certificationStudentRepository.findByStudentEmailAndTechnology(email, technology).also {
            Logger.info(
                logCode = REPOSITORY_LOG_CODE,
                message = "Finish search for student certificate by email and technology",
                payload = it
            )
        }

        val output = result.isNotEmpty()

        Logger.info(
            logCode = USECASE_LOG_CODE,
            message = "End of verification if student has certification",
            payload = output
        )

        output
    }
}
