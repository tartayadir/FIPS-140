package utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.MessageDigest;

public class YarrowRandom {

    private final byte[] state;

    public YarrowRandom() throws NoSuchAlgorithmException {
        int stateSize = 32;
        state = new byte[stateSize];

        SecureRandom secureRandom = new SecureRandom();

        byte[] entropy = secureRandom.generateSeed(stateSize);
        System.arraycopy(entropy, 0, state, 0, entropy.length);

        updateState();
    }

    public byte[] nextBytes(int n) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[n];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = nextByte();
        }

        updateState();

        return bytes;
    }

    public byte nextByte() throws NoSuchAlgorithmException {
        byte bit = (byte) (state[0] & 1);
        updateState();

        return bit;
    }

    private void updateState() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(state);

        System.arraycopy(hash, 0, state, 0, hash.length);
    }
}


