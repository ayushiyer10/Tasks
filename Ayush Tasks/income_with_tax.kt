//Salary Calculator where weekly hours is 40. This program shows the gross and net salary calculated according to work hours, overtime hours and rate per hour. 

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    
    println("Enter number of hours worked: ")
    val hours = reader.nextInt()
    
    println("Enter hourly rate: ")
    val rate = reader.nextDouble()
    
    val weekly = hours * rate

    val oth = hours - 40   // Overtime hours
    val otp = oth * rate * 1.5   // Overtime pay
    val ots = otp   // Overtime salary
    println("Overtime Salary: $ots")
    
    val gross = ots + weekly

//calculation of net pay according to gross pay
    val net: Double = when {
        gross <= 300 -> {
            val tax = gross * 0.15
            gross - tax
        }
        gross <= 450 -> {
            val tax = 300 * 0.15 + (gross - 300) * 0.20
            gross - tax
        }
        else -> {
            val tax = 300 * 0.15 + 150 * 0.20 + (gross - 450) * 0.25
            gross - tax
        }
    }

    println("Weekly Salary: $weekly")
    println("Gross Salary: $gross")
    println("Net Pay: $net")
}

