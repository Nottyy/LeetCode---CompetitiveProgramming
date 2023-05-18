import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var input = "101023";

        var res = restoreIpAddresses(input);

        for (var s : res) {
            System.out.println(s);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        Backtracking(s, result, 0, new ArrayList<String>());

        return result;
    }

    //   25525511135
    private static void Backtracking(String s, List<String> result, int index, ArrayList<String> curStr) {
        if (curStr.size() >= 4) {
            String curRes = "";
            for (int i = 0; i < curStr.size(); i++) {
                curRes += curStr.get(i);
                if (i != curStr.size() - 1) {
                    curRes += ".";
                }
            }

            result.add(curRes);
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String str;
            if (curStr.size() == 3) {
                str = s.substring(index, s.length());
            } else {
                str = s.substring(index, i);
            }

            if (str.length() > 3 || Integer.parseInt(str) > 255 || (str.startsWith("0") && str.length() > 1)) {
                return;
            } else {
                curStr.add(str);
            }

            Backtracking(s, result, i, curStr);
            if (curStr.size() == 4){
                curStr.remove(curStr.size() - 1);
                return;
            }
            else{
                curStr.remove(curStr.size() - 1);
            }
        }
    }
}