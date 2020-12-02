package org.daohn

/**
 * @project MaquinaDeTuring
 * @author daohn on 28/11/2020
 */
data class TuringInstruction(
    val currentState: String,
    val currentSymbol: String,
    val nextSymbol: String,
    val nextState: String,
    val movement: Int
) {
    constructor(data: List<String>) : this(
        currentState = data[0],
        currentSymbol = data[1],
        nextState = data[2],
        nextSymbol = data[3],
        movement = when (data[4]) {
            "+" -> 1
            "-" -> -1
            else -> 0
        }
    )
}

typealias TuringTable = List<TuringInstruction>