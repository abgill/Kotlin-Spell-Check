package com.abgill.spellCheck

import java.util.*


/*
There is probably a better way to handle the loops
 */
class EdtDistChecker : SpellCheck{
    override fun getSuggestions(word: String): List<String> {
        val suggestionSet: TreeSet<String> = TreeSet()

        buildSuggestionList(word,suggestionSet)
        

        return LinkedList<String>()
    }

    private fun buildSuggestionList(word: String, suggestionSet: TreeSet<String>){
        addSwapDist(word, suggestionSet)
        insDist(word, suggestionSet)
        modDist(word, suggestionSet)
        delDist(word, suggestionSet)

        addSwapDist(word, suggestionSet)
        insDist(word, suggestionSet)
        modDist(word, suggestionSet)
        delDist(word, suggestionSet)
    }

    private fun addSwapDist(word: String, suggestionSet: TreeSet<String>){
        val wordArr = word.toCharArray()

        //Todo: find way to do this with less copying
        wordArr.forEachIndexed({i, _ ->
            wordArr.forEachIndexed({j, _ ->
                val wordArrCopy = wordArr.copyOf()
                val charHolder = wordArr[i]

                wordArrCopy[i] = wordArrCopy[j]
                wordArrCopy[j] = charHolder

                suggestionSet.add(String(wordArrCopy))
            })


        })
    }

    private fun insDist (word: String, suggestionSet: TreeSet<String>){

        for(i in 0..25){
            word.forEachIndexed({idx, _ ->
                val builder = StringBuilder(word)
                builder.insert(idx, (i + 'a'.toInt()).toChar())

                suggestionSet.add(builder.toString())
            })

            //adding each letter onto end

            val builder = StringBuilder(word)
            builder.insert(builder.length , (i + 'a'.toInt()).toChar())

            suggestionSet.add(builder.toString())
        }
    }

    private fun modDist(word: String, suggestionSet: TreeSet<String>){
        word.forEachIndexed({idx, _ ->
            for(i in 0..25){
                val builder = StringBuilder(word)
                builder.setCharAt(idx, (i + 'a'.toInt()).toChar())

                suggestionSet.add(builder.toString())
            }
        })
    }

    private fun delDist(word: String, suggestionSet: TreeSet<String>){
        word.forEachIndexed({idx, _ ->
            val builder = StringBuilder(word)
            builder.deleteCharAt(idx)

            suggestionSet.add(builder.toString())
        })
    }

}