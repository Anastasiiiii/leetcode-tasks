package String;

public class toInteger {
    public static void main(String[] args) {
        String s = "1337c0d3";
        System.out.println(myAtoi(s));
    }

    private static int myAtoi(String s) {
      int i = 0, sign = 1;
      long result = 0;
      int n = s.length();

      // Space = 32 (Unicode)
        while (i < n && (int)s.charAt(i) == 32){
            i++;
        }

        if(i < n){
            int ch = (int)s.charAt(i);
            if(ch == 45){
                sign = -1;
                i++;
            } else if (ch == 43) {
                i++;
            }
        }

        while (i < n && (int)s.charAt(i) == 48){
            i++;
        }

        //Numbers Unicode(48 - 57)
        while (i < n){
            int ch = (int)s.charAt(i);
            if(ch >= 48 && ch <= 57){
                result = result * 10 + (ch - 48);

                if(sign == 1 && result > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }

                if(sign == -1 && -result < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }

                i++;
            } else {
                break;
            }
        }
        return (int)(sign * result);
    }
}
