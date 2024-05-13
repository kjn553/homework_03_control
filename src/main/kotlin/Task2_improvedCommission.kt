package ru.netology

fun main() {
    val cardType1 = "MASTERCARD"
    val cardType2 = "VISA"
    val cardType3 = "MIR"
    val cardType4 = "MAESTRO"
    val previousTransfersThisMonth = 200_000.0
    val transferAmount = 100_000.0
    println(calculateCommission(cardType1, previousTransfersThisMonth, transferAmount))
    println(calculateCommission(cardType2, previousTransfersThisMonth, transferAmount))
    println(calculateCommission(cardType3, previousTransfersThisMonth, transferAmount))
    println(calculateCommission(cardType4, previousTransfersThisMonth, transferAmount))
}
fun calculateCommission(cardType: String, previousTransfersThisMonth: Double = 0.0, transferAmount: Double = 0.0): String {
    val dailyLimit = 150_000.0
    val monthlyLimit = 600_000.0
    var result = ""
    when {
        transferAmount > dailyLimit || previousTransfersThisMonth + transferAmount > monthlyLimit -> {
            result = "${cardType}: Превышен лимит переводов. Транзакция заблокирована."
        }
        cardType == "MASTERCARD" -> {
            val monthlyLimitNoCommission = 75000.0
            if (previousTransfersThisMonth + transferAmount <= monthlyLimitNoCommission) {
                result = "${cardType}: 0 рублей."
            } else {
                val exceededAmount = (previousTransfersThisMonth + transferAmount) - monthlyLimitNoCommission
                result = "${cardType}: ${transferAmount * 0.006 + 20} рублей."
            }
        }
        cardType == "VISA" -> {
            val minCommission = 35.0
            val commission = transferAmount * 0.0075
            if (commission < minCommission) {
                result = "$minCommission рублей."
            } else {
                result = "${cardType}: $commission рублей."
            }
        }
        cardType == "MIR" -> {
            result = "${cardType}: 0 рублей."
        }
        else -> {
            result = "Ошибка: неверный тип карты."
        }
    }
    return result
}