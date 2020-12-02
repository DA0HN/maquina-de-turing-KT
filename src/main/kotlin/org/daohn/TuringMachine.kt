package org.daohn

/**
 * @project MaquinaDeTuring
 * @author daohn on 30/11/2020
 */
class TuringMachine(
    private val configuration: Configuration,
    private val turingTable: TuringTable,
    private val logger: MachineLogging,
) {

    private lateinit var currentState: String

    fun putOnTape(instructions: String): Boolean {
        this.currentState = configuration.initialState
        val expr = (instructions + configuration.nullSymbol)
            .map { ch -> ch.toString() }
            .toMutableList()
        return analyzeExpression(expr)
    }

    private fun analyzeExpression(expr: MutableList<String>): Boolean {
        var position = 0

        while (currentState != configuration.finalState && position < expr.size) {

            val analysis = analyzeState(expr[position])

            logger.log(currentState, expr[position], analysis)

            if (analysis.isValid) {
                expr[position] = analysis.nextSymbol
                this.currentState = analysis.nextState
            }
            position += analysis.movement
        }

        logger.reset()

        return currentState == configuration.finalState
    }

    private fun analyzeState(currentSymbol: String): AnalysisReturn {
        if (currentSymbol !in configuration.symbols
            && currentSymbol !in configuration.helpers
            && currentSymbol != configuration.initialValue
            && currentSymbol != configuration.nullSymbol
        ) throw IllegalArgumentException(
            "Expressão inválida o caractere $currentSymbol não foi reconhecido"
        )

        for (rule in turingTable) {
            if (rule.currentState == currentState && rule.currentSymbol == currentSymbol) {
                return AnalysisReturn(
                    rule.movement,
                    rule.nextState,
                    rule.nextSymbol,
                    isValid = true
                )
            }
        }
        return AnalysisReturn(
            nextState = currentState,
            nextSymbol = currentSymbol,
            isValid = false
        )
    }
}