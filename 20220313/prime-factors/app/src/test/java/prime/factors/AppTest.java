/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package prime.factors;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

// 요구사항
// 숫자가 주어지면, 해당 숫자의 1 을 제외한 소인수를 나열한다.
// 1. 2 미만의 숫자 -> 빈 리스트
// 2. 2 이상의 소수 -> 자기 자신
// 3. 2 이상의 합성수 -> 소인수배열

// 용어
// 소인수 - prime factor

class PrimeFactorsTest {
    private int smallestPrimeFactor(int number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .filter(i -> number % i == 0)
                .findFirst()
                .orElse(number);
    }

    private IntStream primeFactorStream(int number) {
        if (number < 2) {
            return IntStream.empty();
        }

        int smallestPrimeFactor = smallestPrimeFactor(number);
        if (smallestPrimeFactor == number) {
            return IntStream.of(number);
        }

        return IntStream.concat(
                IntStream.of(smallestPrimeFactor),
                primeFactorStream(number / smallestPrimeFactor)
        );
    }

    private int[] primeFactors(int number) {
        return primeFactorStream(number).toArray();
    }

    @Test
    void testLowerThanBoundaryReturnsEmptyList() {
        assertThat(primeFactors(1)).isEqualTo(new int[]{});
        assertThat(primeFactors(0)).isEqualTo(new int[]{});
    }

    @Test
    void testPrimeNumberReturnsItself() {
        assertThat(primeFactors(2)).isEqualTo(new int[]{2});
        assertThat(primeFactors(3)).isEqualTo(new int[]{3});
        assertThat(primeFactors(23)).isEqualTo(new int[]{23});
    }

    @Test
    void testCompositeNumberReturnsPrimes() {
        assertThat(primeFactors(4)).isEqualTo(new int[]{2, 2});
        assertThat(primeFactors(9)).isEqualTo(new int[]{3, 3});
        assertThat(primeFactors(8)).isEqualTo(new int[]{2, 2, 2});
        assertThat(primeFactors(12)).isEqualTo(new int[]{2, 2, 3});
    }
}
