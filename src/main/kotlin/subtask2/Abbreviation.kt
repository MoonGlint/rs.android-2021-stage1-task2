package subtask2

import java.util.regex.Pattern

class Abbreviation {

    fun abbreviationFromA(a: String?, b: String): String {
        val bArray = b.split("").toTypedArray()
        var bpattern = "\\w*"
        for (i in bArray.indices) {
            bpattern = bpattern + "(" + bArray[i] + "|" + bArray[i].toLowerCase() + ")" + "\\w*"
        }

        val pattern = Pattern.compile(bpattern)
        val matcher = pattern.matcher(a)
        return if (matcher.matches()) {
            "YES"
        } else "NO"
    }
}