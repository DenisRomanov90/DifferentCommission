class Users (var name : String, var dayLimit: Double = 0.0, private var monthLimit : Double = 0.0) {

    fun transferCommission (amount: Double, cardType: String) : Int{
        val kopeyka = amount*100
        var commission = 0.0
        if (dayLimit<150000 && monthLimit<600000){
            when (cardType){
                "Mastercard", "Maestro" -> {
                    commission = ((kopeyka*0.006)+2000)
                    dayLimit += amount
                    monthLimit += amount
                }
                "Visa", "Мир" -> {
                    commission = if (kopeyka*0.0075 > 3500) (kopeyka*0.0075) else 3500.0
                    dayLimit += amount
                    monthLimit += amount
                }
                else -> {
                    commission = 0.0
                    dayLimit += amount
                    monthLimit += amount
                }
            }
        }
        else println("Лимит привышен")
        return commission.toInt()
    }

    fun printCommission (com : Int){

        when (com){
            0 -> println("Перевод выполнен коммиссия не взымается")

            else -> println("Перевод выполнен, ваша коммиссия составила ${(com/100)} руб. ${com%100} коп.")
        }
    }
}
