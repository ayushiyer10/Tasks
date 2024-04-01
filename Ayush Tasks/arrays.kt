fun main() {

val brands = arrayOf("Gucci", "Versace", "Nike", "Puma", "Adidas")

for (brand in brands) {
    println(brand)
}

if ("Crocs" in brands) {
    println(brands[2])
} else {
    println("It does not exist")
}
}
