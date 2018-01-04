package com.abgill.spellCheck.trie

interface ITrie {
    fun add(word: String): Boolean
    fun find(word: String): Int
}