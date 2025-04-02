package String;

public class CommonSuffix {
    public static void main(String[] args) {
        String[] strs = {"walking", "barking", "talking"};
        System.out.println(findLongestCommonSuffix(strs));
    }

    private static String findLongestCommonSuffix(String[] strs){
        //TODO: To find the longest common suffix shared among all strings in the array.
        String shortest = strs[0];
        for(String str : strs){
            if(str.length() < shortest.length()){
                shortest = str;
            }
        }
        int endPoint = shortest.length();
        for (int i = 0; i <endPoint ; i++) {
            char charToCheck = shortest.charAt(endPoint - 1 - i);
            for(String str : strs){
                if(str.charAt(endPoint - 1 - i) != charToCheck){
                    return shortest.substring(i, endPoint);
                }
            }
        }
        return shortest;
    }
}
