package com.example.kotlin_classes.classes.sealed_class

sealed class OrderStatus

object Pending : OrderStatus()
data class Processing(val estimatedProcessingTime: Int) : OrderStatus()
data class Shipped(val trackingNumber: String, val shippedDate: String) : OrderStatus()
data class Delivered(val deliveryDate: String, val recipient: String) : OrderStatus()
data class Cancelled(val reason: String) : OrderStatus()

fun printOrderStatus(status: OrderStatus) {
    when (status) {
        is Pending -> println("Die Bestellung wartet auf Bearbeitung.\n")
        is Processing -> println("Die Bestellung wird bearbeitet. Verbleibende Bearbeitungszeit: ${status.estimatedProcessingTime} Stunden.\n")
        is Shipped -> println("Die Bestellung wurde versendet. Sendungsnummer: ${status.trackingNumber}. Versanddatum: ${status.shippedDate}.\n")
        is Delivered -> println("Die Bestellung wurde zugestellt an ${status.recipient} am ${status.deliveryDate}.\n")
        is Cancelled -> println("Die Bestellung wurde storniert. Grund: ${status.reason}.\n")
    }
}

data class Order(val orderId: String, var status: OrderStatus) {

    fun updateStatus(newStatus: OrderStatus) {
        status = newStatus
    }

    fun estimateDeliveryTime(): Int {
        return when (status) {
            is Pending -> 7
            is Processing -> 7
            is Shipped -> 5
            is Delivered -> 0
            is Cancelled -> -1
        }
    }
}


fun main() {

    val order1 = Order("ORD123", Pending)
    printOrderStatus(order1.status)

    order1.updateStatus(Processing(estimatedProcessingTime = 4))
    printOrderStatus(order1.status)

    order1.updateStatus(Shipped(trackingNumber = "TRACK12345", shippedDate = "2024-11-15"))
    printOrderStatus(order1.status)

    order1.updateStatus(Delivered(deliveryDate = "2024-11-20", recipient = "John Doe"))
    printOrderStatus(order1.status)

    println("Voraussichtliche Lieferzeit in Tagen: ${order1.estimateDeliveryTime()}")

    val order2 = Order("ORD124", Pending)
    printOrderStatus(order2.status)

    order2.updateStatus(Cancelled(reason = "Customer request"))
    printOrderStatus(order2.status)

    println("Voraussichtliche Lieferzeit in Tagen: ${order2.estimateDeliveryTime()}")
}
