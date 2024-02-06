package com.lukinhasssss.certification.modules.students.controller

import com.lukinhasssss.certification.modules.students.dto.VerifyHasCertificationDTO
import com.lukinhasssss.certification.modules.students.useCases.VerifyIfHasCertificationUseCase
import com.lukinhasssss.certification.utils.Logger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/students"])
class StudentController(
    private val verifyIfHasCertificationUseCase: VerifyIfHasCertificationUseCase
) {

    companion object {
        private const val VERIFY_IF_HAS_CERTIFICATION = "/verifyIfHasCertification"
    }

    @PostMapping(value = [VERIFY_IF_HAS_CERTIFICATION])
    fun verifyIfHasCertification(
        @RequestBody verifyHasCertification: VerifyHasCertificationDTO
    ) {
        startLog(resourceName = VERIFY_IF_HAS_CERTIFICATION, input = verifyHasCertification)

        verifyIfHasCertificationUseCase.execute(verifyHasCertification)

        endLog(resourceName = VERIFY_IF_HAS_CERTIFICATION)
    }

    private fun startLog(resourceName: String, input: Any? = null) =
        Logger.info(
            logCode = "CONTROLLER",
            message = "Start flow for $resourceName route",
            payload = input
        )

    private fun endLog(resourceName: String, output: Any? = null) =
        Logger.info(
            logCode = "CONTROLLER",
            message = "End flow for $resourceName route",
            payload = output
        )
}
