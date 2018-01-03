package com.abgill.trie

import com.abgill.spellCheck.EdtDistChecker
import com.abgill.spellCheck.SpellCheck

fun main(args: Array<String>){
    val spellCheck : SpellCheck = EdtDistChecker(args[1])

    println(spellCheck.getSuggestions(args[0]))
    
}