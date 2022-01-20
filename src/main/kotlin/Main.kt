import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val den = Users("Den")
    while(true){
        println("Введите сумму перевода и тип вашей карты(Mastercard, Maestro, Visa, Мир, VK Pay)")
        val summ = scan.next().toDouble()
        val type = scan.next()

        den.printCommission(den.transferCommission(summ, type))
    }
}