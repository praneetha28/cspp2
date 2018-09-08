import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
    //your code goes here...
    //Good luck :-)
	private int[] set;
	private int size;
	public Set() {
        set = new int[10];
        size = 0;
    }
    public Set(final int capacity) {
        size = 0;
        set = new int[capacity];
    }
    private void resize() {
        set = Arrays.copyOf(set, size * 2);
    }
    public int size() {
        return size;
    }
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == set[i]) {
                return true;
            }
        }
        return false;
    }
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
    public void add(final int item) {
        if (size == set.length) {
            resize();
        }
        set[size++] = item;
    }
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == set[i]) {
                return i;
            }
        }
        return -1;
    }
    public void add(final int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            int index = indexOf(set[i]);
            while (index != -1) {
                add(newArray[i]);
                index = indexOf(set[i]);
            }
        }
    }
    public Set intersection(final Set set1) {
        Set intersect = new Set();
        for (int i = 0; i< set.length; i++) {
            if (set1.contains(set[i])) {
                intersect.add(set[i]);
            }
        }
        return intersect;
    }
    public int get(final int index) {
        if (index < 0 && index >= size) {
            return -1;
        } else {
            return set[index];
        }
    }
    public Set retainAll(final int[] array) {
        Set res = new Set();
        for (int i = 0;i < array.length; i++) {
            if(this.contains(array[i])) {
                res.add(this.get(i));
            }
        }
        return res;
    }
    // public int[][] cartesianProduct(final Set set2) {
    //     int[][] cart = new int[this.size][set2.size];
    //     if (this.size() == 0 || set2.size() == 0) {
    //         System.out.println("null");
    //         return null;
    //     }
    //     for(int i = 0;i < set.length; i++) {
    //         for(int j = 0;j < set2.size(); i++ ) {
    //             cart[i][j] = "[" + set[i] + ", ]";
    //         }
    //     }
    //     return cart;
    // }
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
                // case "cartesianProduct":
                // s = new Set();
                // t = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // t.add(intArray);
                // System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                // break;
                // default:
                // break;
            }
        }
    }
}
