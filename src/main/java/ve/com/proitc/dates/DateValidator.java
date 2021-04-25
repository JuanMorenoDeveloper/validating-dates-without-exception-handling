package ve.com.proitc.dates;

import java.time.format.DateTimeFormatter;

interface DateValidator {

  String DATE_PATTERN = "yyyy-MM-dd";
  DateTimeFormatter formatter = java.time.format.DateTimeFormatter
      .ofPattern(DATE_PATTERN);

  boolean isValid(String date);
}
