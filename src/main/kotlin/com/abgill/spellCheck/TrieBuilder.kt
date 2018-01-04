package com.abgill.spellCheck

import com.abgill.spellCheck.trie.ITrie
import com.abgill.spellCheck.trie.Trie
import java.io.File

/*
Reads in dictionary file.
TODO: Improve parsing
 */

class TrieBuilder(private val filePath: String){

    fun buildTrie(): ITrie{

        val trie: ITrie = Trie()

        val regex = Regex("[A-Za-z]")

        File(filePath).forEachLine { word ->
            for(letter in word){
                if(areLetters(word)){
                    trie.add(word)
                }
            }


        }

        return trie
    }

    private fun areLetters(word: String): Boolean{
        val chars = word.toCharArray()

        return chars.any {symbol -> Character.isLetter(symbol) }
    }
}