package com.abgill.trie

import org.junit.Assert.*
import org.junit.Test
import java.io.File


class TrieTest{
    @Test
    fun trieTest1(){

        val trie = buildTrie("wordlist1.txt")

//        File("wordlist1.txt").forEachLine { ln ->
//            trie.add(ln)
//        }

        assertEquals(1, trie.find("a"))
        assertEquals(2, trie.find("b"))
        assertEquals(3, trie.find("c"))
        assertEquals(4, trie.find("d"))

    }

    @Test
    fun trieTest2(){
        val trie = buildTrie("wordlist2.txt")

        assertEquals(1, trie.find("once"))
        assertEquals(2, trie.find("twice"))
        assertEquals(3, trie.find("thrice"))

    }

    private fun buildTrie (fileName: String) : Trie{
        val trie =Trie()

        File(fileName).forEachLine { ln ->
            trie.add(ln)
        }

        return trie
    }

}