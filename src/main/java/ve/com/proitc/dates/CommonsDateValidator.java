package ve.com.proitc.dates;

import org.apache.commons.validator.routines.CalendarValidator;

record CommonsDateValidator() implements DateValidator {

  private static final CalendarValidator validator = CalendarValidator.getInstance();

  @Override
  public boolean isValid(String date) {
    return validator.isValid(date, DATE_PATTERN);
  }
}
