package utilities;

import io.qameta.allure.Step;

import java.util.Random;

public class emailGenerator {

    private static final String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // The emailUserSize will be the email username, the whole email will be :  username + eMailDomain
        public static String RandomEmail(int emailUserSize) {
        String eMailDomain = "@test.com";
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < emailUserSize; i++) {
            builder.append(Alphabet.charAt(random.nextInt(Alphabet.length())));
        }
        return builder.toString()+eMailDomain ;
    }


}


