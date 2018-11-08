package iii_conventions

data class MyDate(
  val year: Int,
  val month: Int,
  val dayOfMonth: Int
): Comparable<MyDate> {
  override fun compareTo(other: MyDate): Int {
    var formattedMonth = "$month"
    var formattedDay = "$dayOfMonth"
    var otherFormattedMonth = "${other.month}"
    var otherFormattedDay = "${other.dayOfMonth}"

    if (month < 10) formattedMonth = "0$month"
    if (dayOfMonth < 10) formattedDay = "0$dayOfMonth"
    if (other.month < 10) otherFormattedMonth = "0${other.month}"
    if (other.dayOfMonth < 10) otherFormattedDay = "0${other.dayOfMonth}"

    val thisDate = "$year$formattedMonth$formattedDay".toInt()
    val otherDate = "${other.year}$otherFormattedMonth$otherFormattedDay".toInt()

    if (thisDate == otherDate) return 0
    if (thisDate < otherDate) return -1
    return 1
  }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)

operator fun DateRange.contains(d: MyDate): Boolean {
  val higherThanStart = start.compareTo(d)
  val lowerThanEnd = endInclusive.compareTo(d)
  val validRange = start.compareTo(endInclusive)
  if (validRange == 1 && higherThanStart > -1 && lowerThanEnd < 1) return true
  return false
}
