package com.abgill.trie

class Trie : ITrie {

    private val rootNode = TrieNode()

    override fun add(word :String): Boolean {
        var current : TrieNode = rootNode
        val wordArr = word.toLowerCase().toCharArray()

        wordArr.forEach {letter ->
            current.add(letter)
            current = current.getChild(letter)!!
        }

        current.value++

        return true
    }

    override fun find(word: String): Int {
        var current = rootNode
        val wordArr = word.toCharArray()

        wordArr.forEach { letter ->
            if(current.getChild(letter) == null){
                return -1
            }

            current = current.getChild(letter)!!
        }

        return current.value
    }

    class TrieNode {
        val children = Array<TrieNode?>(26,{ null})

        var value = 0

        fun add(letter : Char){
            val idx = letter.toInt() - 'a'.toInt()

            if(children[idx] == null){
                children[idx] = TrieNode()
            }
        }

        fun getChild(letter: Char): TrieNode?{
            val idx = letter.toInt() - 'a'.toInt()

            return children[idx]
        }
    }
}