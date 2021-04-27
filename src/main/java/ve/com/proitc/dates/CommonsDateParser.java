package ve.com.proitc.dates;

import java.time.LocalDate;
import java.util.Optional;
import org.apache.commons.validator.routines.CalendarValidator;

class CommonsDateParser implements DateParser {

  private static final CalendarValidator validator = CalendarValidator.getInstance();


  @Override
  public Optional<LocalDate> tryParse(String date) {
    var parseDate = Optional.<LocalDate>empty();
    if (validator.isValid(date, DATE_PATTERN)) {
      parseDate = Optional.of(LocalDate.parse(date, formatter));
    }
    return parseDate;
  }
}
