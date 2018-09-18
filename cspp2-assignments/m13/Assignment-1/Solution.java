import java.io.BufferedInputStream;
/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
 */
import java.util.Arrays;
/**.
 * Class for set.
 * @author :
 */
class Set {
    /**.
     * { var_description }
     */
	protected int[] set;
    /**.
     * { var_description }
     */
	protected int size;
    /**.
     * Constructs the object.
     */
	public Set() {
        set = new int[10];
        size = 0;
    }
    /**.
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    public Set(final int capacity) {
        size = 0;
        set = new int[capacity];
    }
    /**.
     * { function_description }
     */
    private void resize() {
        set = Arrays.copyOf(set, size * 2);
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        for (int each : set) {
            if (each == item) {
                return true;
            }
        }
        return false;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + set[i] + ", ";
        }
        str = str + set[i] + "}";
        return str;
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == set.length) {
            resize();
        } else {
            if (!this.contains(item)) {
                set[size++] = item;
            }
        }
    }
    /**.
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == set[i]) {
                return i;
            }
        }
        return -1;
    }
    /**.
     * { function_description }
     *
     * @param      newArray  The new array
     */
    public void add(final int[] newArray) {
        for (int element : newArray) {
            add(element);
        }
    }
    /**.
     * { function_description }
     *
     * @param      set1  The set 1
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(final Set set1) {
        Set intersect = new Set();
        for (int e : set) {
            for (int x :set1.set) {
                if (e == x) {
                	intersect.add(e);
                }
            }
        }
        return intersect;
    }
    /**.
     * { function_description }
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        if (index < 0 && index >= size) {
            return -1;
        } else {
            return set[index];
        }
    }
    /**.
     * { function_description }
     *
     * @param      array  The array
     *
     * @return     { description_of_the_return_value }
     */
    public Set retainAll(final int[] array) {
        Set res = new Set();
        for (int item : array) {
            res.add(item);
        }
        return intersection(res);
    }
    public int[][] cartesianProduct(final Set set2) {
        int [][] result = new int[this.size() * set2.size()][2];
        int k = 0;
        if (this.size() == 0 || set2.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < set2.size(); j++) {
                result[k][0] = this.get(i);
                result[k][1] = set2.get(j);
                k++;
            }
        }
        return result;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                }
                else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
