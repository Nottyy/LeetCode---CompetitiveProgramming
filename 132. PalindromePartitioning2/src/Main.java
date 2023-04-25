public class Main {
    public static void main(String[] args) {
        System.out.println(minCut("abababa"));
    }

    public static int minCut = Integer.MAX_VALUE;

    public static int minCut(String s) {
        DFS(s, 0, 0);

        return minCut - 1;
    }

    private static void DFS(String word, int count, int index) {
        if (index >= word.length()){
            if (count < minCut){
                minCut = count;
            }
            return;
        }

        for (int i = 1; i <= word.length() - index; i++){
            var curStr = word.substring(index, index + i);

            if (PalindromeCheck(curStr)){
                count++;
                DFS(word, count, index + i);
                count--;
            }
        }
    }

    private static boolean PalindromeCheck(String curStr) {
        if (curStr.length() == 1){
            return true;
        }

        var start = 0;
        var end = curStr.length() - 1;

        while (start <= end){
            if (curStr.charAt(start) != curStr.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}