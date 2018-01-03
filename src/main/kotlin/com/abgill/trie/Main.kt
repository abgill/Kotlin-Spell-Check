package com.abgill.trie

import com.abgill.spellCheck.EdtDistChecker
import com.abgill.spellCheck.SpellCheck

fun main(args: Array<String>){
    val trie :ITrie = Trie()

    val spellCheck : SpellCheck = EdtDistChecker()

    spellCheck.getSuggestions("word")


    trie.add("abcde")
}