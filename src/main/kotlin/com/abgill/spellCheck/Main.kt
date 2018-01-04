package com.abgill.spellCheck

fun main(args: Array<String>){
    val spellCheck : SpellCheck = EdtDistChecker(args[1])

    println(spellCheck.getSuggestions(args[0]))
}