package com.example.kotlin_classes.classes.data

data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val inStock: Boolean
) {

    fun applyDiscount(discount: Double): Product {
        val discountedPrice = price * (1 - discount)
        return this.copy(price = discountedPrice)

    }
}

/**
 *    Erstelle eine weitere Data-Class: Order(orderNumber, products, customer).
 *    Dazu eine Methode welche die Gesamtsumme der Bestellung berechnen soll, indem sie die Preise aller Product-Objekte in der products-Liste summiert.
 */

data class Order(val orderNumber: String, val products: List<Product>, val customer: String) {
    fun calculateTotal(): Double {
        var total = 0.0
        for (product in products) {
            total += product.price
        }
        return total
    }

    fun filterInStockProducts(): Order {
        val inStockProducts = products.filter { it.inStock }
        return this.copy(products = inStockProducts)
    }
}

fun main() {

    val product1 = Product("Laptop", "Elektronik", 999.99, true)
    val product2 = Product("Kaffeemaschine", "Haushaltsgeräte", 79.99, false)
    val product3 = Product("Smartphone", "Elektronik", 499.99, true)

    val discountedProduct1 = product1.applyDiscount(0.5)
    println("Rabattierter Laptop: $discountedProduct1\n")

    val order = Order("12345", listOf(product1, product2, product3), "Alice")
    println("Gesamtsumme der Bestellung: ${order.calculateTotal()}\n")

    val inStockOrder = order.filterInStockProducts()
    println("Bestellung mit vorrätigen Produkten: $inStockOrder\n")
}
