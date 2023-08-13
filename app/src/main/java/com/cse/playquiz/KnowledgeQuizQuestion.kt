package com.cse.playquiz

data class KnowledgeQuizQuestion (
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
