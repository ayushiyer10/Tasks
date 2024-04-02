fun main() {

val brands = arrayOf("Gucci", "Versace", "Nike", "Puma", "Adidas")

for (brand in brands) {
    println(brand)
}

if ("Crocs" in brands) {
    println(brands[2])
} 
else {
    println("It does not exist")
}
println(brands.contentDeepToString())
}

//String to upper case
fun main() {
    val string = "Hello, World!"
    val result = inputString.toUpperCase()
    println("Original string: $inputString")
    println("Uppercase string: $uppercaseString")
}


//Alternate characters in uppercase in string
fun main() {
    val string = "hello, world!"
    val result = StringBuilder()

    for ((index, char) in inputString.withIndex()) {
        result.append(if (index % 2 == 0) char.toUpperCase() else char)
    }

    println("Original string: $inputString")
    println("Alternate characters uppercase: $result")
}

