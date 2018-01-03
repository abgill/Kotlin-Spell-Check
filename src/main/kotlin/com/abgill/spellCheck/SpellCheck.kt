package com.abgill.spellCheck

interface SpellCheck {
    fun getSuggestions(word: String) : List<String>
}