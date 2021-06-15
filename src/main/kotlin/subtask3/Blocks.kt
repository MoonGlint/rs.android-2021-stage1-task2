package subtask3

import kotlin.reflect.KClass

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        when (blockB) {
            Int::class -> {
                var s = 0
                for (i in blockA) {
                    if (i is Int) {
                        s += i
                    }
                }
                return s
            }
            String::class -> {
                var s = ""
                for (i in blockA) {
                    if (i is String) {
                        s += i
                    }
                }
                return s
            }
            LocalDate::class -> {
                val s = arrayListOf<LocalDate>()
                for (i in blockA) {
                    if (i is LocalDate) {
                        s.add(i)
                    }
                }
                return s[s.size - 1].plusDays(1).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            }
            else -> {
                return ""
            }
        }
    }
}