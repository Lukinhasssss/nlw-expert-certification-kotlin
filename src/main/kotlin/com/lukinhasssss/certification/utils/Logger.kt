package com.lukinhasssss.certification.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.slf4j.LoggerFactory

object Logger {

    private const val STACK_TRACE_LEVEL = 3
    private val objectMapper = jacksonObjectMapper()

    fun debug(
        logCode: String = "",
        message: String,
        payload: Any? = null
    ) {
        val callerName = Thread.currentThread().stackTrace[STACK_TRACE_LEVEL].className

        val logger = LoggerFactory.getLogger(callerName)

        val finalMessage = getFinalMessage(logCode, message, payload)

        logger.debug(finalMessage)
    }

    fun info(
        logCode: String = "",
        message: String,
        payload: Any? = null
    ) {
        val callerName = Thread.currentThread().stackTrace[STACK_TRACE_LEVEL].className

        val logger = LoggerFactory.getLogger(callerName)

        val finalMessage = getFinalMessage(logCode, message, payload)

        logger.info(finalMessage)
    }

    fun warning(
        logCode: String = "",
        message: String,
        payload: Any? = null
    ) {
        val callerName = Thread.currentThread().stackTrace[STACK_TRACE_LEVEL].className

        val logger = LoggerFactory.getLogger(callerName)

        val finalMessage = getFinalMessage(logCode, message, payload)

        logger.warn(finalMessage)
    }

    fun error(
        logCode: String = "",
        message: String,
        payload: Any? = null
    ) {
        val callerName = Thread.currentThread().stackTrace[STACK_TRACE_LEVEL].className

        val logger = LoggerFactory.getLogger(callerName)

        val finalMessage = getFinalMessage(logCode, message, payload)

        logger.error(finalMessage)
    }

    private fun getFinalMessage(logCode: String, message: String, payload: Any?): String {
        val finalMessage = mapOf(
            "log_code" to logCode,
            "log_message" to message,
            "payload" to payload
        )

        return objectMapper.writeValueAsString(finalMessage)
    }
}
