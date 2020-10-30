package utilities;

import java.util.Random;

public class emailGenerator {

    private static final String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String RandomString(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append(Alphabet.charAt(random.nextInt(Alphabet.length())));

        }
        return builder.toString();
    }

}

