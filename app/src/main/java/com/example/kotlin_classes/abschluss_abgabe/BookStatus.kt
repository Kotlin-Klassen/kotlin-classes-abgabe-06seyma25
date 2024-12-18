package com.example.kotlin_classes.abschluss_abgabe

sealed class BookStatus {
    object Available : BookStatus() {
        override fun printStatus() = "The book is available."
    }

    data class CheckedOut(val dueDate: String) : BookStatus() {
        override fun printStatus() = "The book is checked out. Due back on $dueDate."
    }

    data class Reserved(val reservedBy: String) : BookStatus() {
        override fun printStatus() = "The book is reserved by $reservedBy."
    }

    abstract fun printStatus(): String
}
