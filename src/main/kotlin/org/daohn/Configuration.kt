package org.daohn

/**
 * @project MaquinaDeTuring
 * @author daohn on 28/11/2020
 */
data class Configuration(
    var state: MutableList<String>,
    var initialState: String,
    var finalState: String,
    var symbols: MutableList<String>,
    var helpers: MutableList<String>,
    var initialValue: String,
    var nullSymbol: String,
)