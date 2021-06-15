package subtask1

import java.time.DateTimeException
import java.time.LocalDate

//class DateFormatter {

    /*
Задача:
        Реализуйте метод, который по числу, месяцу и году определяет день недели и возвращает его в правильном падеже.

        Пример:

        - Входные данные: 17 11 2020
        - Выходная строка: 17 ноября, вторник
</br></br>

        - Входные данные: 18 3 2019
        - Выходная строка: 18 марта, понедельник
</br></br>

        - Входные данные: 29 2 2017
        - Выходная строка: Такого дня не существует
</br></br>
*/
   /* fun toTextDay(day: String, month: String, year: String): String {
        throw NotImplementedError("Not implemented")
    }*/
//}


class DateFormatter {
    fun toTextDay(day: String, month: String, year: String): String {
        val result: String
        val monthName = arrayOf(
            "января", "февраля", "марта",
            "апреля", "мая", "июня", "июля", "августа",
            "сентября", "октября", "ноября", "декабря"
        )
        val intDay = day.toInt()
        val intMonth = month.toInt()
        val intYear = year.toInt()
        try {
            LocalDate.of(intYear, intMonth, intDay)
        } catch (dtException: DateTimeException) {
            return "Такого дня не существует"
        }
        result =
            day + " " + monthName[intMonth - 1] + ", " + zellerFormula(intDay, intMonth, intYear)
        return result
    }

    fun zellerFormula(day: Int, month: Int, year: Int): String {
        var month = month
        var year = year
        val cent: Int
        val dayofweek = arrayOf(
            "воскресенье", "понедельник", "вторник", "среда",
            "четверг", "пятница", "суббота"
        )
        /* adjust months so February is the last one */month -= 2
        if (month < 1) {
            month += 12
            --year
        }
        /* split by century */cent = year / 100
        year %= 100
        return dayofweek[((26 * month - 2) / 10 + day + year
                + year / 4 + cent / 4 + 5 * cent) % 7]
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(DateFormatter().toTextDay("17", "11", "2020"))
            println(DateFormatter().toTextDay("18", "3", "2019"))
            println(DateFormatter().toTextDay("29", "2", "2017"))
        }
    }
}

