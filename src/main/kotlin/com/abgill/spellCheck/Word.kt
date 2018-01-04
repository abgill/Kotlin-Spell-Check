package com.abgill.spellCheck

data class Word(val word: String,val count:Int) : Comparable<Word>{
    override fun compareTo(other: Word): Int {
        return if(count.compareTo(other.count) != 0){
            other.count.compareTo(count);
        }else{
            word.compareTo(other.word)
        }
    }

    override fun toString() : String{
        return "$word, $count"
    }
}