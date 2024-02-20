package dev.Innocent.AuthenticationSystem.Utils;

import java.util.Random;

public class AppUtils {

    public static String generateOtp(){
        StringBuilder otp = new StringBuilder();
        Random random = new Random();
        int count = 0;
        while(count < 4){
            otp.append(random.nextInt(10));
            ++count;
        }
        return otp.toString();
    }
}
