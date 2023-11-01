package test;

public class MonobiticTest {

    private static int MIN_BOUND = 9_654;
    private static int MAX_BOUND = 10_365;

    private MonobiticTest(){}

    public static boolean performMonobiticTest(byte[] key) {
        int zeroCounter = 0;
        int oneCounter = 0;

        for (byte b: key){
            if (b == 0){
                zeroCounter++;
            }
            if (b == 1){
                oneCounter++;
            }
        }

        return (zeroCounter >= MIN_BOUND && zeroCounter <= MAX_BOUND)
                && (oneCounter >= MIN_BOUND && oneCounter <= MAX_BOUND);
    }
}
