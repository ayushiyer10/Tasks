//basic array program

fun main() {
    var name = arrayOf("Danish", "Maaz", "Ayush", "Shlok","Nitya","Dev")
    println(name[1])

  }

// array program using loop

  fun main() {
    var name = arrayOf("Danish", "Maaz", "Ayush", "Shlok", "Nitya", "Dev")
    
    for (i in name) {
        println(i)
    }
}  

//array program using if/else

fun main() {
    var name = arrayOf("Danish", "Maaz", "Ayush", "Shlok", "Nitya", "Dev")
     
    if("Danish" in name){
        println("Yes! It Exists")
    }
    else{
        println("It does not Exists..")
    }
}
  
  