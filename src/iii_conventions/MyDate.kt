package iii_conventions

data class MyDate(
  val year: Int,
  val month: Int,
  val dayOfMonth: Int
): Comparable<MyDate> {
  override fun compareTo(other: MyDate): Int {
    if (this == other) return 0
    if (year > other.year) return 1
      if (month > other.month) return 1
        if (dayOfMonth > other.dayOfMonth) return 1
    return -1
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
