import java.util.Scanner

enum class Inventory(val price: Float) {
    APPLE(2.50f),
    ORANGE(3.00f),
    BANANA(0.99f),
    ONION(0.49f),
}



fun main() {
    val scnr = Scanner(System.`in`)
    println("Welcome to Evan's Market!\n")


    var cart_total: Float = 0f
    while(true) {
        printPrices()
        println("Cart total is ${String.format("%.2f", cart_total)}")
        println("\n- add {name} {quantity}\n- checkout")
        var input: String = scnr.next()
        when(input) {
            "checkout" -> {
                println("Thank you for shopping at Evan's Market, your total was ${cart_total}")
                return
            }
            "add" -> {
                input = scnr.next()
                try {
                    cart_total += Inventory.valueOf(input.uppercase()).price;
                } catch (e: IllegalArgumentException) {
                    println("That is not an item in the inventory, try again.")
                }
            }
        }
    }
}

fun printPrices() {
    println("\n\tItem prices:")
    for (item in Inventory.values()) {
        println("\t${item.name}: ${String.format("%.2f", item.price)}")
    }
}
