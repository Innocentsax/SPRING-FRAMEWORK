package dev.Innocent.udoBank.utils;

import java.time.Year;

public class AccountUtils {
    public static String generateAccountNumber(){
        /**
         * 2024 + randomSixDigits
         */
        Year currentYear = Year.now();
        int min = 100000;
        int max = 999999;

        // Generate a random number between Min and Max
        int randNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);

        // convert the current year and randomNumber to String, then concatenate them together
        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);
        StringBuilder accountNumber = new StringBuilder();
        return accountNumber.append(year).append(randomNumber).toString();
    }

}
