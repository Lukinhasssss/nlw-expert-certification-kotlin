package com.lukinhasssss.certification.seed

import com.lukinhasssss.certification.utils.Logger
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import javax.sql.DataSource

class CreateSeed(dataSource: DataSource) {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val dataSource = DriverManagerDataSource()

            dataSource.setDriverClassName("org.postgresql.Driver")
            dataSource.url = "jdbc:postgresql://localhost:5432/certification"
            dataSource.username = "admin"
            dataSource.password = "admin"

            val createSeed = CreateSeed(dataSource)
            createSeed.run()
        }
    }

    private val jdbcTemplate = JdbcTemplate(dataSource)

    fun run() = executeSqlFile("src/main/resources/create.sql")

    private fun executeSqlFile(filePath: String) {
        try {
            Logger.info(logCode = "SEED", message = "Start of database seed")

            val sqlScript = String(Files.readAllBytes(Paths.get(filePath)))

            jdbcTemplate.execute(sqlScript)

            Logger.info(logCode = "SEED", message = "End of database seed")
        } catch (e: IOException) {
            Logger.error(logCode = "SEED", message = "Error in database seed", payload = e)
        }
    }
}