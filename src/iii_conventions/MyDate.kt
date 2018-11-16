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

class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {
  override fun iterator(): Iterator<MyDate> = DateIterator(this)
}

class DateIterator(val dateRange: DateRange): Iterator<MyDate> {
  var current: MyDate = dateRange.start

  override fun next(): MyDate {
    val result = current
    current = current.nextDay()
    return result
  }

  override fun hasNext(): Boolean = current <= dateRange.endInclusive
}

operator fun DateRange.contains(d: MyDate): Boolean {
  val overStart = d.compareTo(start)
  val underEnd = d.compareTo(endInclusive)
  return overStart >= 0 && underEnd <= 0
}
