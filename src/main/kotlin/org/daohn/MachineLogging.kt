package org.daohn

class MachineLogging {

    private var showHeader = true

    fun log(currentState: String, currentSymbol: String, analysis: AnalysisReturn) {
        if (this.showHeader) {
            println(
                "${"Current State".padEnd(15)} " +
                        "|${"Next State".padEnd(10)} " +
                        "|${"Current Symbol".padEnd(15)} " +
                        "|${"Next Symbol".padEnd(12)} " +
                        "|${"Movement".padEnd(8)}"
            )
            this.showHeader = false
        }
        println(
            "${currentState.padEnd(15)} " +
                    "| ${analysis.nextState.padEnd(10)}" +
                    "| ${currentSymbol.padEnd(15)}" +
                    "| ${analysis.nextSymbol.padEnd(12)}" +
                    "| ${analysis.movement.toString().padEnd(8)}"
        )
    }

    fun reset() {
        this.showHeader = true
    }
}