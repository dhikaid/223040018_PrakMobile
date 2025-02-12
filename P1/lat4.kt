fun main() {
 var umur: Int = 25
//  if(umur >= 18){
// 	println("Kamu sudah dewasa")
//  } else {
// 	println("Kamu belum dewasa")
//  }
   when(umur){
	in 0..17 -> println("Kamu belum dewasa")
    else -> println("Kamu sudah dewasa")
   }
}