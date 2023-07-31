package boys.mtv.kotlin.movie.common.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    fun generateTransactionID(): String {
        val sdf = SimpleDateFormat("yyyyMMddHHmmssS")
        val date = sdf.format(Date())
        val lDate = date.toLong()
        val hexDate = java.lang.Long.toHexString(lDate)
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
        val rnd = Random()
        val a = chars[rnd.nextInt(chars.length)]
        val b = chars[rnd.nextInt(chars.length)]
        val c = chars[rnd.nextInt(chars.length)]
        val d = chars[rnd.nextInt(chars.length)]
        val e = chars[rnd.nextInt(chars.length)]
        val f = chars[rnd.nextInt(chars.length)]

        return "$a$b$c$d$$hexDate$e$f"
    }

    fun getDateNow(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = sdf.format(Date())
        return sdf.format(date)
    }

}