package iii_conventions

data class MyDate(
  val year: Int,
  val month: Int,
  val dayOfMonth: Int
): Comparable<MyDate> {
  override fun compareTo(other: MyDate): Int {
    val thisDate = "$year$month$dayOfMonth".toInt()
    val otherDate = "${other.year}${other.month}${other.dayOfMonth}".toInt()

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
