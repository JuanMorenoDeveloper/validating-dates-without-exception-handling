package ve.com.proitc.dates;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

record ExceptionDateValidator() implements DateValidator {

  @Override
  public boolean isValid(String date) {
    try {
      LocalDate.parse(date, formatter);
    } catch (DateTimeParseException e) {
      return false;
    }
    return true;
  }
}
