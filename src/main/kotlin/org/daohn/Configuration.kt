package org.daohn

/**
 * @project MaquinaDeTuring
 * @author daohn on 28/11/2020
 */
data class Configuration(
    val state: List<String>,
    val initialState: String,
    val finalState: String,
    val symbols: List<String>,
    val initialValue: String,
    val nullSymbol: String,
    val helpers: List<String>,
) {
    constructor(data: List<List<String>>) : this(
        state = data[0],
        initialState = data[1].first(),
        finalState = data[2].first(),
        symbols = data[3],
        initialValue = data[4].first(),
        nullSymbol = data[5].first(),
        helpers = data[6]
    )
}