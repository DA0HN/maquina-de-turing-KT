package org.daohn

data class AnalysisReturn(
    var movement: Int = 1,
    var nextState: String,
    var nextSymbol: String,
    var isValid: Boolean,
)