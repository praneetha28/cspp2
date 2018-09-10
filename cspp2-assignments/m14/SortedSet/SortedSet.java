/**.
 * { item_description }
 */
import java.io.BufferedInputStream;
/**.
 * { item_description }
 */
import java.util.Scanner;
/** . { item_description }
 */
import java.util.Arrays;
/**.
 * List of .
 */
public class SortedSet extends Set{
    public int last() {
        if (size() == 0) {
            System.out.println("Set Empty Exception");
            return -1;
        } else {
            return get(size() - 1);
        }
    }
    public void add(int item) {
        if (!contains(item)) {
            int index = getIndex(item);
            add(index, item);
        }
    }
    public int getIndex(int item) {
        for(int i = 0; i < size(); i++) {
            if (item <= this.get(i)) {
                return i;
            }
        }
        return size();
    }
    public int[] subSet(int fromele , int toele) {
        int fromindex = getIndex(fromele);
        int toindex = getIndex(toele);
        int[] subset = new int[toindex - fromindex];
        int k = 0;
        for (int i = fromindex; i < toindex; i++) {
                subset[k++] = this.get(i);
        }
        return subset;
    }
    public int[] headset(int toele) {
        // int hdset = new int[];
        // int k = 0;
        // for (int i = 0; i < set.size(); i++) {
        //     if (set[i] < toele) {
        //         hdset[k++] = set[i];
        //     }
        // }
        // if (this.get(0) > toele) {
        //     return ;
        // }
        return subSet(get(0), toele);
    }
    // public void add(int[] array) {
    //     for (int element : array) {
    //         add(element);
    //     }
    // }
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
    public static void main(String[] args) {
        SortedSet s = new SortedSet();
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
                System.out.println(s.
                    contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "subSet":
                String[] arrstring = tokens[1].split(",");
                if (Integer.parseInt(arrstring[0])
                      > Integer.parseInt(arrstring[1])) {
                    System.out.println("Invalid Arguments to Subset Exception");
                } else {
                    int[] subarray = s.subSet(Integer.parseInt(arrstring[0]),
                            Integer.parseInt(arrstring[1]));
                    Set subset = new Set();
                    subset.add(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                }
                break;
            case "headSet":
                int[] headarray = s.headset(Integer.parseInt(tokens[1]));
                Set headset = new Set();
                headset.add(headarray);
                if (headset != null) {
                    System.out.println(headset);
                }
                break;
            case "last":
                System.out.println(s.last());
                break;
            default:
                break;
            }
        }
    }
}