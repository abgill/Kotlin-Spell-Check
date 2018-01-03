package com.abgill.trie

class Trie : ITrie {
    override fun add(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class TrieNode {
        val children = Array<TrieNode?>(26,{ null})
        var value = 0
    }
}