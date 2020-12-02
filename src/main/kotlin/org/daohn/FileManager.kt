package org.daohn

import java.io.BufferedReader
import java.nio.file.Files.newBufferedReader
import java.nio.file.Paths
import kotlin.streams.toList

/**
 * @project MaquinaDeTuring
 * @author daohn on 29/11/2020
 */
class FileManager {

    private val numberParameters: Long = 7

    private fun configurationParameters(reader: BufferedReader): Configuration {
        return Configuration(
            reader
                // Retorna um stream de dados com o conteúdo do arquivo
                .lines()
                // Remove os comentários e linhas em branco
                .filter { line -> !line.contains("#") && line.isNotBlank() && line.isNotEmpty() }
                // Recupera apenas as 7 primeiras linhas
                .limit(numberParameters)
                // Converte para uma Lista de String separada por virgula
                .map { line -> line.replace(" ", "").split(",") }
                // Adiciona as Listas a uma outra lista
                .toList()
        )
    }

    private fun transitionRules(reader: BufferedReader): TuringTable {

        return reader
            // Retorna uma stream de dados com o conteúdo do arquivo
            .lines()
            // Remove os comentários e linhas em branco
            .filter { line -> !line.contains("#") && line.isNotBlank() && line.isNotEmpty() }
            // Mapeia a linha atual para uma Lista de String para cada elemento entre a virgula
            .map { line -> line.replace(" ", "").split(",") }
            // Mapeia a lista de String para um objeto Rule
            .map(::TuringInstruction)
            // Converte ao final em uma lista de Rule
            .toList()
    }

    fun loadConfigurations(path: String): Pair<Configuration, TuringTable> {
        newBufferedReader(Paths.get(path)).use { reader ->
            val configuration = configurationParameters(reader)
            val rules = transitionRules(reader)

            return Pair(configuration, rules)
        }
    }
}