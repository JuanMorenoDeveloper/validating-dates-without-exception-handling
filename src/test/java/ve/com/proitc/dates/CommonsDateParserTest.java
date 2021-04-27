package ve.com.proitc.dates;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class CommonsDateParserTest {

  private static final DateParser commonsDateValidator = new CommonsDateParser();

  @Test
  void givenValidDate_whenIsValidWithApacheCommons_thenGetTrue() {
    assertEquals(Optional.of(LocalDate.parse("2020-02-20")),
        commonsDateValidator.tryParse("2020-02-20"));
  }

  @Test
  void givenInvalidDate_whenIsValidWithApacheCommons_thenGetFalse() {
    assertEquals(Optional.empty(), commonsDateValidator.tryParse("2020-X2-20"));
  }

  @Test
  void givenNullDate_whenIsValidWithApacheCommons_thenGetFalse() {
    assertEquals(Optional.empty(), commonsDateValidator.tryParse(null));
  }
}