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

    private fun configurationParameters(reader: BufferedReader, currentLine: Int): Configuration? {
        val lines = reader
            .lines()                                                // Retorna um stream de dados com o conteúdo do arquivo
            .filter { line -> !line.contains("#") }          // Remove os comentários
            .filter { line -> line.isNotBlank() && line.isNotEmpty() }               // Remove linhas em
            // branco
            .limit(7)                                      // Recupera apenas as 7 primeiras linhas
            // Converte para uma Lista de String separada por virgula
            .map { line ->
                line.trim().split(",")
            }
            .toList()                                              // Adiciona as Listas a uma outra lista
        val config = Configuration(lines)
        println(config)
        return config
    }

    private fun transitionRules(reader: BufferedReader, currentLine: Int): Rules? {
        return null
    }

    fun loadConfigurations(path: String): Pair<Configuration?, Rules?> {
        var currentLine = 0
        newBufferedReader(Paths.get(path)).use { reader ->
            val configuration = configurationParameters(reader, currentLine)
            val rules = transitionRules(reader, currentLine)
            return Pair(configuration, rules)
        }
    }
}