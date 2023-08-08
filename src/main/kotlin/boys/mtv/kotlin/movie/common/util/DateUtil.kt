package boys.mtv.kotlin.movie.common.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    fun getDateNow(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = sdf.format(Date())
        return sdf.format(date)
    }

}