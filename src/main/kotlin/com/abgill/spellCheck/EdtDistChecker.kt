package com.abgill.spellCheck

import java.util.*


class EdtDistChecker(dictionaryPath: String) : SpellCheck {
    private val dictionary = TrieBuilder(dictionaryPath).buildTrie()

    override fun getSuggestions(word: String): Set<Word> {
        val uncheckedSuggestions: MutableSet<String> = TreeSet()

        if (dictionary.find(word) > 0) {
            return setOf(Word(word, dictionary.find(word)))
        }

        buildSuggestionSet(word, uncheckedSuggestions)

        val suggestionSet: MutableSet<Word> = TreeSet()

        uncheckedSuggestions.forEach { searchTerm ->
            val count = dictionary.find(searchTerm)
            if (count > 0) {
                suggestionSet.add(Word(searchTerm, count))
            }
        }

        if (suggestionSet.size < 1) {
            val suggestionSetCopy = TreeSet<String>(uncheckedSuggestions)

            suggestionSetCopy.forEach { term ->
                buildSuggestionSet(term, uncheckedSuggestions)
            }

            uncheckedSuggestions.forEach { searchTerm ->
                val count = dictionary.find(searchTerm)
                if (count > 0) {
                    suggestionSet.add(Word(searchTerm, count))
                }
            }

        }


        return suggestionSet
    }

    private fun buildSuggestionSet(word: String, suggestionSet: MutableSet<String>) {
        addSwapDist(word, suggestionSet)
        insDist(word, suggestionSet)
        modDist(word, suggestionSet)
        delDist(word, suggestionSet)

    }

    private fun addSwapDist(word: String, suggestionSet: MutableSet<String>) {
        val wordArr = word.toCharArray()

        //Todo: find way to do this with less copying
        wordArr.forEachIndexed({ i, _ ->
            wordArr.forEachIndexed({ j, _ ->
                val wordArrCopy = wordArr.copyOf()
                val charHolder = wordArr[i]

                wordArrCopy[i] = wordArrCopy[j]
                wordArrCopy[j] = charHolder

                suggestionSet.add(String(wordArrCopy))
            })


        })
    }

    private fun insDist(word: String, suggestionSet: MutableSet<String>) {

        for (i in 0..25) {
            word.forEachIndexed({ idx, _ ->
                val builder = StringBuilder(word)
                builder.insert(idx, (i + 'a'.toInt()).toChar())

                suggestionSet.add(builder.toString())
            })

            //adding each letter onto end

            val builder = StringBuilder(word)
            builder.insert(builder.length, (i + 'a'.toInt()).toChar())

            suggestionSet.add(builder.toString())
        }
    }

    private fun modDist(word: String, suggestionSet: MutableSet<String>) {
        word.forEachIndexed({ idx, _ ->
            for (i in 0..25) {
                val builder = StringBuilder(word)
                builder.setCharAt(idx, (i + 'a'.toInt()).toChar())

                suggestionSet.add(builder.toString())
            }
        })
    }

    private fun delDist(word: String, suggestionSet: MutableSet<String>) {
        word.forEachIndexed({ idx, _ ->
            val builder = StringBuilder(word)
            builder.deleteCharAt(idx)

            suggestionSet.add(builder.toString())
        })
    }
}