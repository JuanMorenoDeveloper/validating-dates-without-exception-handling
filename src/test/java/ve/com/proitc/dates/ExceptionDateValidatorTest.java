package ve.com.proitc.dates;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ExceptionDateValidatorTest {

  private static final DateValidator exceptionDateValidator = new ExceptionDateValidator();

  @Test
  void givenValidDate_whenIsValidWithException_thenGetTrue() {
    assertTrue(exceptionDateValidator.isValid("2020-02-20"));
  }

  @Test
  void givenInvalidDate_whenIsValidWithException_thenGetFalse() {
    assertFalse(exceptionDateValidator.isValid("2020-X2-20"));
  }
}