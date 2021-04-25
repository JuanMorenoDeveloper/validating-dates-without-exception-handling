package ve.com.proitc.dates;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CommonsDateValidatorTest {
  private static final DateValidator commonsDateValidator = new CommonsDateValidator();

  @Test
  void givenValidDate_whenIsValidWithApacheCommons_thenGetTrue() {
    assertTrue(commonsDateValidator.isValid("2020-02-20"));
  }

  @Test
  void givenInvalidDate_whenIsValidWithApacheCommons_thenGetFalse() {
   assertFalse(commonsDateValidator.isValid("2020-X2-20"));
  }
}