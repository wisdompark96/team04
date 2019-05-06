package buv.co.kr.ui.login.data

import io.reactivex.Single
import yapp14th.co.kr.myplant.ui.main.tab1_home.CalendarMonth
import yapp14th.co.kr.myplant.utils.getCurrentYear
import yapp14th.co.kr.myplant.utils.getMockDayEmotions
import java.util.*

// 더미 데이터를 받아온다
class HomeMockSource : HomeDataSource {
    override fun getYears(year: Int): Single<List<Int>> {
        var yearList = mutableListOf<Int>()
        var calendar = Calendar.getInstance()
        var currentYear = calendar.get(Calendar.YEAR)

        for (i in 2019..currentYear) {
            yearList.add(i)
        }

        return Single.create<List<Int>> {
            it.onSuccess(yearList)
        }
    }

    override fun getCalendars(year: Int): Single<List<Pair<Int, Int>>> {
        return Single.create<List<Pair<Int, Int>>> {
            it.onSuccess(
                    listOf(
                            Pair(year, 1),
                            Pair(year, 2),
                            Pair(year, 3),
                            Pair(year, 4),
                            Pair(year, 5),
                            Pair(year, 6),
                            Pair(year, 7),
                            Pair(year, 8),
                            Pair(year, 9),
                            Pair(year, 10),
                            Pair(year, 11),
                            Pair(year, 12)))
        }
    }

    override fun getYearEmotions(year: Int): Single<List<CalendarMonth>> {
        return Single.create<List<CalendarMonth>> {
            val emotionsList = mutableListOf<CalendarMonth>()
            for (month in 1..12) {
                emotionsList.add(CalendarMonth(
                        year = getCurrentYear().toShort(),
                        month = month.toShort(),
                        dayList = getMockDayEmotions(year, month)
                ))
            }

            it.onSuccess(emotionsList)
        }
    }
}