package Tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


public class TestPrep {
    public static void main(String[] args) {
        Integer x = 100;
        add5(x);
        System.out.println(x);
    }

    private static void add5(Integer x){
        x += 5;
    }
}
