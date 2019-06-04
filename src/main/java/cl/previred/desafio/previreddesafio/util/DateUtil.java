package cl.previred.desafio.previreddesafio.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateUtil {

    public static List<LocalDate> getDatesBetween(
            LocalDate startDate, LocalDate endDate, List<LocalDate> exceptionDate) {

        long numOfMonthsBetween = numOfMonthsBetween(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfMonthsBetween)
                .mapToObj(i -> startDate.plusMonths(i))
                .filter(i -> !exceptionDate.contains(i))
                .collect(Collectors.toList());
    }

    public static Long numOfMonthsBetween(
            LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.MONTHS.between(startDate, endDate) + 1;
    }
}
