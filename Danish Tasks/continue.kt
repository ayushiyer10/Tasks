//continue using while loop

fun main(){
    var i = 1
while (i < 10) {
  if (i == 5) {
    i++
    continue
  }
  println(i)
  i++
}

}

//continue using for loop 

fun main(){
    for(x in(1..20)){
        if(x==10){
            continue
        }
       println(x)
    } 
}