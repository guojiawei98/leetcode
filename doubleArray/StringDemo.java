package doubleArray;

import java.util.HashSet;
import java.util.Set;

public class StringDemo {
    public static void main(String[] args) {
        String a = "I love Zhengzhou and I love JAVA ";
        String[] str = a.split(" ");
        System.out.println("Word Number:"+str.length);

        Set<String> disNumber = new HashSet<>();
        for (String s: str) {
            disNumber.add(s);
        }
        System.out.println("Distinct word number:"+disNumber.size());
    }
}
