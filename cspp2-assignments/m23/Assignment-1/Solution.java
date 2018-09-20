import java.util.*;
import java.io.File;
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Plagiarism plg = new Plagiarism();
		Scanner scan = new Scanner(System.in);
		String line = scan.next();
		File file = new File(line);
		File[] listFiles = file.listFiles();
		int l = listFiles.length;
		int[][] matrix = new int[l][l];
		try {
			for(int i = 0;i < l; i++) {
				for (int j = 0; j < l; j++) {
					if (i < j) {
						matrix[i][j] = plg.bagOfWords(plg.toString(listFiles[i]), plg.toString(listFiles[j]));
					} else {
						matrix[i][j] = matrix[j][i];
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		plg.print(matrix, listFiles);
	}
}