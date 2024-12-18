package com.example.kotlin_classes.abschluss_abgabe

enum class Genre(val description: String) {
    FICTION("Fictional stories and novels"),
    NON_FICTION("Informative non-fiction books"),
    SCIENCE("Scientific and academic material"),
    HISTORY("Books about historical events and figures"),
    CHILDREN("Books suitable for children");

    fun printDescription() {
        println("$name: $description")
    }
}
