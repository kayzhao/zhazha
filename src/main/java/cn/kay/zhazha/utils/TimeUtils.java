package cn.kay.zhazha.utils;

import java.util.Calendar;

/**
 * @program: zhazha-tool
 * @package: cn.kay.zhazha.utils
 * @author: kayzhao
 * @create: 2018/8/28
 */
public class TimeUtils {

    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

}
