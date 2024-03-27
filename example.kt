//Ayush Iyer kotlin Task

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    var choice: String
    
    do {
        println("Enter first number:")
        val a = reader.nextInt()

        println("Enter second number:")
        val b = reader.nextInt()

        println("Choose Operator: +  -  *  /")
        val operator = reader.next()

        val result = when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> {
                if (b != 0) a / b
                else "Division by 0 is not allowed"
            }
            else -> "Invalid operator"
        }

        println("First Number: $a")
        println("Second Number: $b")
        println("Result: $result")

        println("Do you wish to continue? (yes/no)")
        choice = reader.next()

    } 
    
    while (choice == "yes")
}























