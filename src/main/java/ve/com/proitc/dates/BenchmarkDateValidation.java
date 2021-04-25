package ve.com.proitc.dates;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

@BenchmarkMode(Mode.Throughput)
public class BenchmarkDateValidation {

  private static DateValidator commonsDateValidator = new CommonsDateValidator();
  private static DateValidator exceptionDateValidator = new ExceptionDateValidator();

  @Benchmark
  public boolean validDateWithApacheCommons() {
    return commonsDateValidator.isValid("2020-02-20");
  }

  @Benchmark
  public boolean validDateWithException() {
    return exceptionDateValidator.isValid("2020-02-20");
  }

  @Benchmark
  public boolean invalidDateWithApacheCommons() {
    return commonsDateValidator.isValid("2020-X2-20");
  }

  @Benchmark
  public boolean invalidDateWithException() {
    return exceptionDateValidator.isValid("2020-X2-20");
  }
}
