import utils.YarrowRandom;

import java.security.NoSuchAlgorithmException;

import static test.MonobiticTest.performMonobiticTest;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        YarrowRandom random = new YarrowRandom();
        int KEY_LENGTH = 20_000;
        byte[] key = random.nextBytes(KEY_LENGTH);

        boolean monobiticTestResult = performMonobiticTest(key);
        boolean result = monobiticTestResult;

        System.out.println(result);
    }
}
