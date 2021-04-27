package ve.com.proitc.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

interface DateParser {

  String DATE_PATTERN = "yyyy-MM-dd";
  DateTimeFormatter formatter = java.time.format.DateTimeFormatter
      .ofPattern(DATE_PATTERN);

  Optional<LocalDate> tryParse(String date);
}
