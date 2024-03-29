//Salary Calculator where weekly hours is 40. This program shows the gross and net salary calculated according to work hours, overtime hours and rate per hour. 

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    
    println("Enter number of hours worked : ")
    val hours = reader.nextInt()
    
    println("Enter hourly rate : ")
    val rate = reader.nextDouble()
    
    val weekly = hours * rate

    val oth = hours - 40   //overtime hours
    val otp = oth + (oth / 2)   //overtime pay
    val ots = otp * oth   //overtime salaray
    println("Overtime Salary : $ots")
    
    val gross = ots + weekly

    if (hours <= 40) {
        println("Weekly and Gross salary are : $weekly $gross")
    }

    else {
         println("Weekly and Gross salary are : $weekly $gross")
    }

} 

