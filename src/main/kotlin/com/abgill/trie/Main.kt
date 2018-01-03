package com.abgill.trie

import com.abgill.spellCheck.EdtDistChecker
import com.abgill.spellCheck.SpellCheck

fun main(args: Array<String>){
    val trie :ITrie = Trie()

    val spellCheck : SpellCheck = EdtDistChecker("words.txt")

    spellCheck.getSuggestions("wordz")


    trie.add("abcde")
}