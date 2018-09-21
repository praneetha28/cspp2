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
public final class Solution {
	/**.
	 * Constructs the object.
	 */
	private Solution() {
		/**.
		 * { item_description }
		 */
	}
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
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
			int[][] matrix = new int[l][l];
			for(int i = 0;i < l; i++) {
				for (int j = 0; j < l; j++) {
					if (i < j) {
						matrix[i][j] = plg.bagOfWords(plg.toString(
							listFiles[i]), plg.toString(listFiles[j]));
					} else {
						matrix[i][j] = matrix[j][i];
					}
				}
			}
			plg.print(matrix, listFiles);
		} catch (Exception e) {
			System.out.println("empty directory");
		}
	}
}