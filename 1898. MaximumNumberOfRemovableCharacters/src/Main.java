public class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        System.out.println(maximumRemovals("abcab", "abc", nums));
    }

    public static int maximumRemovals(String s, String p, int[] removable) {
        var l = 0;
        var r = removable.length - 1;
        var sb = new StringBuilder(s);

        var pChArr = p.toCharArray();

        while(l <= r){
            var mid = l + ((r - l) / 2);
            var sb1 = new StringBuilder(sb);

            for (int i = 0; i <= mid; i++){
                int x = removable[i];
                sb1.setCharAt(x, ' ');
            }


            if (subSeq(pChArr, sb1.toString().toCharArray())){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return l;
    }

    private static boolean subSeq(char[] p, char[] s) {
        int i = 0, j = 0;
        while(i < s.length && j < p.length){
            if(s[i] == p[j]){
                i++;
                j++;
            }
            else i++;
        }

        return j == p.length;
    }
}