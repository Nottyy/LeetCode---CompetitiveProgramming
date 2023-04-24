import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(String.join(" ", letterCombinations("23")));
    }

    public static List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        if (digits.isEmpty()){
            return result;
        }

        HashMap<Integer, String> dict = new HashMap<Integer, String>();
        dict.put(2 , "abc");
        dict.put(3 , "def");
        dict.put(4 , "ghi");
        dict.put(5 , "jkl");
        dict.put(6 , "mno");
        dict.put(7 , "pqrs");
        dict.put(8 , "tuv");
        dict.put(9 , "wxyz");

        Backtracking(digits, result, dict, 0, "");

        return result;
    }

    private static void Backtracking(String digits, ArrayList<String> result, HashMap<Integer, String> dict, int index, String cStr) {
        if(cStr.length() >= digits.length()){
            result.add(cStr);
            return;
        }

        var curDigit = Character.getNumericValue(digits.charAt(index));

        for(var c: dict.get(curDigit).toCharArray()){
            Backtracking(digits, result, dict, index + 1, cStr + c);
        }
    }
}