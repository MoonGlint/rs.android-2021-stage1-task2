package subtask3

import kotlin.reflect.KClass
import java.time.format.DateTimeFormatter
import java.time.LocalDate


class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {

        when (blockB) {
            //for Int obj
            Int::class -> {
                var sum = 0
                for (i in blockA) {
                    if (i is Int) {
                        sum += i
                    }
                }
                return sum
            }
            //for String obj
            String::class -> {
                var concat = ""
                for (i in blockA) {
                    if (i is String) {
                        concat += i
                    }
                }
                return concat
            }
            // for LocalDate obj
            LocalDate::class -> {
                val dateArray = arrayListOf<LocalDate>()
                for (i in blockA) {
                    if (i is LocalDate) {
                        dateArray.add(i)
                    }
                }
                return dateArray[dateArray.size - 1].plusDays(1).
                format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            }
            //remaining cases
            else -> {
                return ""
            }
        }
    }
}