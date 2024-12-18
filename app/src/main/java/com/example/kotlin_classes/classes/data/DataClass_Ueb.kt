package com.example.kotlin_classes.classes.data

<<<<<<< HEAD
=======

>>>>>>> 5652139a5732a137b8252e927fe34a68b13ff83f
/**
 *    Erstelle folgende Data-Class:   Product(name, category, price, inStock)
 */
data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val inStock: Boolean
) {
    /**
<<<<<<< HEAD
     *    Implementiere eine Rabattfunktion applyDiscount(discount).
     *    Diese Methode soll einen Rabatt auf den Preis anwenden und eine neue Instanz des Produkts mit einem reduzierten Preis zurückgeben.
     *    Verwende hierfür die copy() Methode.
     */
    fun applyDiscount(discount: Double): Product {
        val discountedPrice = price * (1 - discount)
        return this.copy(price = discountedPrice)
=======
     *    Implementiere eine Rabattfunktion applyDiscount(discount). 
     *    Diese Methode soll einen Rabatt auf den Preis anwenden und eine neue Instanz des Produkts mit einem reduzierten Preis zurückgeben. 
     *    Verwende hierfür die copy() Methode.​
     */
    fun applyDiscount(discount: Double): Product {
        return this.copy(price = price * (1 - discount))
>>>>>>> 5652139a5732a137b8252e927fe34a68b13ff83f
    }
}

/**
 *    Erstelle eine weitere Data-Class: Order(orderNumber, products, customer).
 *    Dazu eine Methode welche die Gesamtsumme der Bestellung berechnen soll, indem sie die Preise aller Product-Objekte in der products-Liste summiert.
 */
<<<<<<< HEAD
data class Order(
    val orderNumber: Int,
    val products: List<Product> = listOf(),
    val customer: String
) {
    /**
     * Berechnet die Gesamtsumme der Produkte in der Bestellung.
     * @return Die Gesamtsumme der Bestellung.
     */
    fun calculateTotal(): Double {
        return products.sumOf { it.price }
    }

    /**
     * Filtert die Produkte in der Bestellung, sodass nur die vorrätigen Produkte enthalten sind.
     * @return Eine neue Order-Instanz, die nur die vorrätigen Produkte enthält.
=======
data class Order(val orderNumber: String, val products: List<Product>, val customer: String) {
    fun calculateTotal(): Double {
        var total = 0.0
        for (product in products) {
            total += product.price
        }
        return total
    }
    /**
     * Alternativ
        fun calculateTotal(): Double {
            return products.sumOf { it.price }
        }
     */


     
    /**
     *    Füge der Order-Klasse eine Methode filterInStockProducts():Order hinzu, die eine neue Bestellung nur mit den Produkten erstellt, die auf Lager sind.
     *    Verwende auch hier die copy()-Funktion von data-Klassen, um eine abgewandelte Kopie der Bestellung zu erstellen​
>>>>>>> 5652139a5732a137b8252e927fe34a68b13ff83f
     */
    fun filterInStockProducts(): Order {
        val inStockProducts = products.filter { it.inStock }
        return this.copy(products = inStockProducts)
    }
<<<<<<< HEAD
=======

>>>>>>> 5652139a5732a137b8252e927fe34a68b13ff83f
}

fun main() {
    /**
<<<<<<< HEAD
     * Erstelle einige Beispielprodukte, um die Funktionen zu testen.
=======
     * Hier werden 3 Product-Klassen angelegt mit welchen die Funktionen getestet werden
>>>>>>> 5652139a5732a137b8252e927fe34a68b13ff83f
     */
    val product1 = Product("Laptop", "Elektronik", 999.99, true)
    val product2 = Product("Kaffeemaschine", "Haushaltsgeräte", 79.99, false)
    val product3 = Product("Smartphone", "Elektronik", 499.99, true)

<<<<<<< HEAD
    // Test der applyDiscount-Funktion
    val discountedProduct1 = product1.applyDiscount(0.5)
    println("Rabattierter Laptop: $discountedProduct1\n")

    // Erstelle eine Bestellung mit den Produkten
    val order = Order(orderNumber = 12345, products = listOf(product1, product2, product3), customer = "Alice")

    // Test der calculateTotal-Funktion
    println("Gesamtsumme der Bestellung: ${order.calculateTotal()}\n")

    // Test der filterInStockProducts-Funktion
=======
    val discountedProduct1 = product1.applyDiscount(0.5)
    println("Rabattierter Laptop: $discountedProduct1\n")

    val order = Order("12345", listOf(product1, product2, product3), "Alice")
    println("Gesamtsumme der Bestellung: ${order.calculateTotal()}\n")

>>>>>>> 5652139a5732a137b8252e927fe34a68b13ff83f
    val inStockOrder = order.filterInStockProducts()
    println("Bestellung mit vorrätigen Produkten: $inStockOrder\n")
}
