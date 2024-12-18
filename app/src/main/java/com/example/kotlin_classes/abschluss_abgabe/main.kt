package com.example.kotlin_classes.abschluss_abgabe


fun main() {

    val library = Library()
    val libraryAddress = Library.LibraryAddress("Main Street 123", "Booktown", "23456")
    libraryAddress.printAddress()

    println()

    val book1 = Book("The Great Gatsby", "F. Scott Fitzgerald", Genre.FICTION, BookStatus.Available)
    val book2 = Book("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE, BookStatus.Available)
    val book3 = Book("The Catcher in the Rye", "J.D. Salinger", Genre.FICTION, BookStatus.Available)
    val book4 = Book("Sapiens", "Yuval Noah Harari", Genre.NON_FICTION, BookStatus.Available)
    val book5 = Book("History of the World", "John Hirst", Genre.HISTORY, BookStatus.Available)
    val book6 = Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", Genre.CHILDREN, BookStatus.Available)

    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)
    library.addBook(book4)
    library.addBook(book5)
    library.addBook(book6)

    println()

    val member = library.LibraryMember("Lars", "MEM001")

    println()

    member.checkoutBook(book1, "2025-04-24")
    member.reserveBook(book2)

    println()

    library.displayBookStatuses()

    println()

    println("\nSuche nach 'Great':")
    val searchResults = library.searchBookByTitle("Great")
    searchResults.forEach { println("Gefunden: ${it.title} von ${it.author}") }

    println()

    println("\nSuche nach 'Stephen':")
    val authorSearchResults = library.searchBookByAuthor("Stephen")
    authorSearchResults.forEach { println("Gefunden: ${it.title} von ${it.author}") }
}
