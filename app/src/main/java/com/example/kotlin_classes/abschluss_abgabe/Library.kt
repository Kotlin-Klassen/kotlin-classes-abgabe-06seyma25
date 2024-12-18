package com.example.kotlin_classes.abschluss_abgabe

class Library {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
        println("Added book: ${book.title} by ${book.author}")
    }

    fun searchBookByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, ignoreCase = true) }
    }

    fun searchBookByAuthor(author: String): List<Book> {
        return books.filter { it.author.contains(author, ignoreCase = true) }
    }

    fun displayBookStatuses() {
        books.forEach {
            println("Title: ${it.title}, Status: ${it.status.printStatus()}")
        }
    }

    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        fun printAddress() {
            println("Library Address: $street, $city, $zipCode")
        }
    }

    inner class LibraryMember(val name: String, val memberID: String) {

        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("$name checked out ${book.title}. Due date: $dueDate")
            } else {
                println("${book.title} is not available for checkout.")
            }
        }

        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("$name reserved ${book.title}.")
            } else {
                println("${book.title} is not available for reservation.")
            }
        }
    }
}
