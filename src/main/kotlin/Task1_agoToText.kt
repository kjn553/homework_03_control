package ru.netology

fun main() {
    println(agoToText(90001))
}

val personName  = "Вася"
fun agoToText(seconds: Int): String {
    return when {
        seconds < 60 -> "$personName был(а) в сети только что"
        seconds < 60 * 60 -> "$personName был(а) в сети ${minuteForm(seconds / 60)} назад"
        seconds < 24 * 60 * 60 -> "$personName был(а) в сети ${seconds / 3600} ${hourForm(seconds / 3600)} назад"
        seconds < 2 * 24 * 60 * 60 -> "$personName был(а) в сети вчера"
        seconds < 3 * 24 * 60 * 60 -> "$personName был(а) в сети позавчера"
        else -> "$personName был(а) в сети давно"
    }
}
fun minuteForm(minutes: Int): String {
    return when (minutes) {
        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
        else -> "минут"
    }
}
fun hourForm(hours: Int): String {
    return when (hours) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}


