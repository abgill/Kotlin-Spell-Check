package com.abgill.trie

interface ITrie {
    fun add(word: String): Boolean
    fun find(word: String): Int
}