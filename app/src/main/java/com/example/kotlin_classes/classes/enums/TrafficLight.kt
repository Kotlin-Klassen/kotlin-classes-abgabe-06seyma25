package com.example.kotlin_classes.classes.enums

/**
 * 1.)-> Erstellt eine Enum Class namens TrafficLight mit den Werten RED, YELLOW und GREEN.
<<<<<<< HEAD
 * 2.)-> Fügt jeder Farbe eine Beschreibung hinzu, z.B. "Stop" für RED, "Ready" für YELLOW und "Go" für GREEN.
 * 3.)-> Implementiert eine Funktion in der Enum Class, die die Beschreibung der jeweiligen Farbe ausgibt.
=======
 *
 * 2.)-> Fügt jeder Farbe eine Beschreibung hinzu, z.B. "Stop" für RED, "Ready" für YELLOW und "Go" für GREEN.
 *
 * 3.)-> Implementiert eine Funktion in der Enum Class, die die Beschreibung der jeweiligen Farbe ausgibt.
 *
>>>>>>> 5652139a5732a137b8252e927fe34a68b13ff83f
 * 4.)-> Verwendet das when-Statement, um eine Logik zu schreiben, die auf Basis der Ampelfarbe eine Ausgabe erzeugt.
 */

enum class TrafficLight(val description: String) {
    RED("Stop"),
    YELLOW("Ready"),
    GREEN("Go");

    /**
     * Gibt die Beschreibung der jeweiligen Farbe aus.
     */
    fun printDescription() {
        println("The light is $name: $description")
    }
}

fun handleTrafficLight(light: TrafficLight) {
    when (light) {
        TrafficLight.RED -> println("The light is RED: Please stop and wait.")
        TrafficLight.YELLOW -> println("The light is YELLOW: Get ready, but do not move yet.")
        TrafficLight.GREEN -> println("The light is GREEN: You may proceed safely.")
    }
}

fun main() {
    // Testen der Enum-Werte und der Funktion printDescription
    TrafficLight.values().forEach {
        it.printDescription()
    }

    // Aufruf der Funktion, um Logik je nach Ampelfarbe zu testen
    val currentLight = TrafficLight.RED

    // Aufruf der Funktion, um Logik je nach Ampelfarbe zu testen
    handleTrafficLight(currentLight)  // Ausgabe: The light is RED: Please stop and wait.
}