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


fun main() {
    val inputString = "Hello, World!"
    val uppercaseString = inputString.toUpperCase()
    println("Original string: $inputString")
    println("Uppercase string: $uppercaseString")
}
