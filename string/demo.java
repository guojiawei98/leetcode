package string;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class demo {
    public static void main(String[] args) {
//        Random random = new Random();
//        random.setSeed(0);
//        for (int i = 0; i < 5; i++) {
//            System.out.println(random.nextInt(100));
//        }

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(df.format(date));
    }
}
