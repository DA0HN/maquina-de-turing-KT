package org.daohn

/**
 * @project MaquinaDeTuring
 * @author daohn on 28/11/2020
 */
data class Rules(
    var currentState: String,
    var currentSymbol: String,
    var nextSymbol: String,
    var nextState: String,
)