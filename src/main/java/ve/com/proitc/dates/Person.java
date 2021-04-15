package ve.com.proitc.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

record Person(String birthdayString) {

  private static final String BIRTHDAY_PATTERN = "yyyy-MM-dd";

  Person {
    if (!isValid(birthdayString)) {
      throw new IllegalArgumentException("Invalid date format");
    }
  }

  boolean isValid(String birthday) {
    try {
      LocalDate.parse(birthdayString, DateTimeFormatter.ofPattern(BIRTHDAY_PATTERN));
    } catch (DateTimeParseException e) {
      return false;
    }
    return true;
  }

  LocalDate birthDay() {
    return LocalDate.parse(birthdayString, DateTimeFormatter.ofPattern(BIRTHDAY_PATTERN));
  }
}
