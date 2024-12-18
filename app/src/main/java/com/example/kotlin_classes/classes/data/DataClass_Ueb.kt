package com.example.kotlin_classes.classes.data

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
     *    Implementiere eine Rabattfunktion applyDiscount(discount).
     *    Diese Methode soll einen Rabatt auf den Preis anwenden und eine neue Instanz des Produkts mit einem reduzierten Preis zurückgeben.
     *    Verwende hierfür die copy() Methode.
     */
    fun applyDiscount(discount: Double): Product {
        val discountedPrice = price * (1 - discount)
        return this.copy(price = discountedPrice)
    }
}

/**
 *    Erstelle eine weitere Data-Class: Order(orderNumber, products, customer).
 *    Dazu eine Methode welche die Gesamtsumme der Bestellung berechnen soll, indem sie die Preise aller Product-Objekte in der products-Liste summiert.
 */
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
     */
    fun filterInStockProducts(): Order {
        val inStockProducts = products.filter { it.inStock }
        return this.copy(products = inStockProducts)
    }
}

fun main() {
    /**
     * Erstelle einige Beispielprodukte, um die Funktionen zu testen.
     */
    val product1 = Product("Laptop", "Elektronik", 999.99, true)
    val product2 = Product("Kaffeemaschine", "Haushaltsgeräte", 79.99, false)
    val product3 = Product("Smartphone", "Elektronik", 499.99, true)

    // Test der applyDiscount-Funktion
    val discountedProduct1 = product1.applyDiscount(0.5)
    println("Rabattierter Laptop: $discountedProduct1\n")

    // Erstelle eine Bestellung mit den Produkten
    val order = Order(orderNumber = 12345, products = listOf(product1, product2, product3), customer = "Alice")

    // Test der calculateTotal-Funktion
    println("Gesamtsumme der Bestellung: ${order.calculateTotal()}\n")

    // Test der filterInStockProducts-Funktion
    val inStockOrder = order.filterInStockProducts()
    println("Bestellung mit vorrätigen Produkten: $inStockOrder\n")
}
