import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var arr = partition("aabaa");
        for(var el: arr){
            System.out.println(String.join(" ", el));
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            DFS(s, result, new LinkedList<>(), s.substring(0, i), i);
        }
        return result;
    }

    // aabac -> a,a,b,a,c - aa,b,a,c - a,aba,c
    // acba
    private static void DFS(String word, List<List<String>> result,
                            LinkedList<String> curArr, String curStr, int index) {
        if (PalindromeCheck(curStr)) {
            curArr.add(curStr);

            if (index >= word.length()) {
                var res = (LinkedList) curArr.clone();
                result.add(res);
                curArr.removeLast();
                return;
            }
            var length = word.length() - index;

            for (int i = 1; i <= length; i++) {
                DFS(word, result, curArr, word.substring(index, index + i), index + i);

            }
            curArr.removeLast();
        }
    }

    private static boolean PalindromeCheck(String curStr) {
        if (curStr.length() == 1) {
            return true;
        }

        int start = 0;
        int end = curStr.length() - 1;

        while (start <= end) {
            if (curStr.charAt(start) != curStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}