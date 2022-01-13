class Users (var name : String, var dayLimit: Double = 0.0, private var monthLimit : Double = 0.0) {

    fun transferCommission (amount: Double, cardType: String) {
        val toKopeyka: Double = amount*100
        val commission : Double
        when (cardType){
            "VK Pay" ->  {
                println("Коммисия не взымается")
                dayLimit += amount
                monthLimit += amount
            }
            "Mastercard", "Maestro" -> {
                if (dayLimit >= 150000 || monthLimit >= 600000){
                    commission = (toKopeyka*0.006)+2000
                    println("Ваша коммиссия составляет ${commission/100} руб. ${commission%100} коп ")
                }
                else println("Коммисия не взымается")
                dayLimit += amount
                monthLimit += amount
            }
            "Visa", "Мир" -> {
                if (dayLimit >= 150000 || monthLimit >= 600000){
                    commission = if ((toKopeyka*0.0075) > 3500) (toKopeyka*0.0075) else 3500.0
                    println("Ваша коммиссия составляет ${(commission/100).toInt()} руб. ${(commission%100).toInt()} коп ")
                }
                else println("Коммисия не взымается")
                dayLimit += amount
                monthLimit += amount
            }
        }
    }
}