import utils.YarrowRandom;

import java.security.NoSuchAlgorithmException;

import static java.lang.String.format;
import static test.LengthSeriesTest.performLengthSeriesTest;
import static test.MaxSeriesTest.performMaxSeriesTest;
import static test.MonobiticTest.performMonobiticTest;
import static test.PokkerTest.performPokkerTest;

public class Main {

    private static final int KEY_LENGTH = 20_000;

    public static void main(String[] args) throws NoSuchAlgorithmException {
        byte[] key = generateKey(KEY_LENGTH);
        boolean result = test(key);
        String resultMassage = result
                ? format("%s bits are fairly random", KEY_LENGTH)
                : format("%s,000 bits are not fairly random", KEY_LENGTH);

        System.out.println(resultMassage);
    }

    private static byte[] generateKey(int keyLength) throws NoSuchAlgorithmException {
        YarrowRandom random = new YarrowRandom();
        return random.nextBytes(keyLength);
    }

    private static boolean test(byte[] key) {
        boolean monobiticTestResult = performMonobiticTest(key);
        boolean maxSeriesTestResult = performMaxSeriesTest(key);
        boolean lengthSeriesTestResult = performLengthSeriesTest(key);
        boolean pokkerTestResult = performPokkerTest(key);

        return monobiticTestResult
                && maxSeriesTestResult
                && pokkerTestResult
                && lengthSeriesTestResult;
    }
}
