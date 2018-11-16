package iii_conventions

data class MyDate(
  val year: Int,
  val month: Int,
  val dayOfMonth: Int
): Comparable<MyDate> {
  override fun compareTo(other: MyDate): Int {
    if (year == other.year) {
      if (month == other.month) {
        if (dayOfMonth == other.dayOfMonth) return 0
        if (dayOfMonth > other.dayOfMonth) return 1
      }
      if (month > other.month) return 1
    }
    if (year > other.year) return 1
    return -1
  }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
  return DateRange(start = this, endInclusive = other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)

operator fun DateRange.contains(d: MyDate): Boolean {
  val overStart = d.compareTo(start)
  val underEnd = d.compareTo(endInclusive)
  return overStart >= 0 && underEnd <= 0
}
