/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
 */
import java.io.File;
/**.
 * { item_description }
 */
import java.util.ArrayList;
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }

    public static double lcs(String s1, String s2) {
        String str = LongestCommonSubstring.lcs(s1, s2);
        int len = str.length() * 2;
        int l1 = s1.length();
        int l2 = s2.length();
        int length = l1 + l2;
        return  ((double)len / length) * 100;
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**.
         * { var_description }
         */
        Plagiarism plg = new Plagiarism();
        Scanner scan = new Scanner(System.in);
        try {
            String line = scan.next();
            File file = new File(line);
            File[] listFiles = file.listFiles();
            int l = listFiles.length;
            double[][] matrix = new double[l][l];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    if(i == j) {
                        matrix[i][j] = 100;
                    }
                    if (i < j) {
                        matrix[i][j] = plg.bagOfWords(plg.toString(
                            listFiles[i]), plg.toString(listFiles[j]));
                        // matrix[i][j] = lcs(plg.toString(
                        //         listFiles[i]), plg.toString(listFiles[j]));
                    } else {
                        matrix[i][j] = matrix[j][i];
                    }
                }
            }
            // // ArrayList<Integer> result = new ArrayList<Integer>();
            // for (int i = 0; i < l - 1; i++) {
            //     System.out.println(plg.longestSubstring(plg.toString(listFiles[i]), plg.toString(listFiles[i + 1])));
            //     // result.add(plg.longestSubstring(plg.toString(listFiles[i]), plg.toString(listFiles[i + 1])));
            // }
            // // for(Integer i : result) {
            // //     System.out.println(i);
            // // }
            plg.print(matrix, listFiles);
        } catch (Exception e) {
            System.out.println("empty directory");
        }
    }
}
