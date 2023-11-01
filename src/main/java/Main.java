import utils.YarrowRandom;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        YarrowRandom random = new YarrowRandom();
        byte[] bytes = random.nextBytes(2_500);

        System.out.println(Arrays.toString(bytes));
    }
}
