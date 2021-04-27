package ve.com.proitc.dates;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

class ExceptionDateParser implements DateParser {

  @Override
  public Optional<LocalDate> tryParse(String date) {
    var parseDate = Optional.<LocalDate>empty();
    try {
      parseDate = Optional.of(LocalDate.parse(date, formatter));
    } catch (DateTimeParseException ignored) {
    }
    return parseDate;
  }
}
