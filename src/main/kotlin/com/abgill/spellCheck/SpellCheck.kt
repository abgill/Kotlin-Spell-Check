package com.abgill.spellCheck


interface SpellCheck {
    fun getSuggestions(word: String) : Set<Word>
}