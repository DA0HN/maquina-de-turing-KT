package org.daohn

/**
 * @project MaquinaDeTuring
 * @author daohn on 28/11/2020
 */
data class Rules(
    val currentState: String,
    val currentSymbol: String,
    val nextSymbol: String,
    val nextState: String,
) {
    constructor(data: List<String>) : this(
        currentState = data[0],
        currentSymbol = data[1],
        nextSymbol = data[2],
        nextState = data[3]
    )
}