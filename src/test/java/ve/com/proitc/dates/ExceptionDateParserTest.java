package ve.com.proitc.dates;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ExceptionDateParserTest {

  private static final DateParser exceptionDateValidator = new ExceptionDateParser();

  @Test
  void givenValidDate_whenIsValidWithException_thenGetTrue() {
    assertEquals(Optional.of(LocalDate.parse("2020-02-20")),
        exceptionDateValidator.tryParse("2020-02-20"));
  }

  @Test
  void givenInvalidDate_whenIsValidWithException_thenGetFalse() {
    assertEquals(Optional.empty(), exceptionDateValidator.tryParse("2020-X2-20"));
  }

  @Test
  void givenNullDate_whenIsValidWithException_thenGetFalse() {
    assertThrows(NullPointerException.class,
        () -> exceptionDateValidator.tryParse(null));
  }
}