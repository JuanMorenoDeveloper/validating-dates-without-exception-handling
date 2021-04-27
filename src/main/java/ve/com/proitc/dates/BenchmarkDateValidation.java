package ve.com.proitc.dates;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.time.LocalDate;
import java.util.Optional;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.Throughput)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 2, time = 500, timeUnit = MILLISECONDS)
@Measurement(iterations = 2, time = 500, timeUnit = MILLISECONDS)
@State(Scope.Benchmark)
public class BenchmarkDateValidation {

  private static DateParser commonsDateValidator = new CommonsDateParser();
  private static DateParser exceptionDateValidator = new ExceptionDateParser();

  @Param({"2020-02-20", "2020-X2-20"})
  public String date;

  @Benchmark
  public Optional<LocalDate> tryParseDateWithApacheCommons() {
    return commonsDateValidator.tryParse(date);
  }

  @Benchmark
  public Optional<LocalDate> tryParseDateWithException() {
    return exceptionDateValidator.tryParse(date);
  }

//  @Benchmark
//  public Optional<LocalDate> validDateWithApacheCommons() {
//    return commonsDateValidator.tryParse("2020-02-20");
//  }
//
//  @Benchmark
//  public Optional<LocalDate> validDateWithException() {
//    return exceptionDateValidator.tryParse("2020-02-20");
//  }
//
//  @Benchmark
//  public Optional<LocalDate> invalidDateWithApacheCommons() {
//    return commonsDateValidator.tryParse("2020-X2-20");
//  }
//
//  @Benchmark
//  public Optional<LocalDate> invalidDateWithException() {
//    return exceptionDateValidator.tryParse("2020-X2-20");
//  }
}
