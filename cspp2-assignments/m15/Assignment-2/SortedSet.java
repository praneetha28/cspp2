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
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    SetEmptyException(final String s) {
        super(s);
    }
}
/**.
 * Exception for signaling invalid sub set selection errors.
 */
class InvalidSubSetSelectionException extends Exception {
    InvalidSubSetSelectionException(final String s) {
        super(s);
    }
}
/**.
 * Class for sorted set.
 */
public class SortedSet extends Set {
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public int last() throws SetEmptyException {
        if (size() == 0) {
            throw new SetEmptyException("Set Empty Exception");
        } else {
            return get(size() - 1);
        }
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            int index = getIndex(item);
            add(index, item);
        }
    }
    /**.
     * Gets the index.
     *
     * @param      item  The item
     *
     * @return     The index.
     */
    public int getIndex(final int item) {
        for (int i = 0; i < size(); i++) {
            if (item <= this.get(i)) {
                return i;
            }
        }
        return size();
    }
    /**.
     * { function_description }
     *
     * @param      fromele                          The fromele
     * @param      toele                            The toele
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     InvalidSubSetSelectionException  { exception_description }
     */
    public int[] subSet(final int fromele, final int toele)
                            throws InvalidSubSetSelectionException {
        if (fromele > toele) {
            throw new InvalidSubSetSelectionException("Invalid Arguments to Subset Exception");
        } else {
            int fromindex = getIndex(fromele);
            int toindex = getIndex(toele);
            int[] subset = new int[toindex - fromindex];
            int k = 0;
            for (int i = fromindex; i < toindex; i++) {
                subset[k++] = this.get(i);
            }
            return subset;
        }
    }
    /**.
     * { function_description }
     *
     * @param      toele                            The toele
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException                { exception_description }
     * @throws     InvalidSubSetSelectionException  { exception_description }
     */
    public int[] headset(final int toele) throws SetEmptyException,
                             InvalidSubSetSelectionException {
        if (toele <= this.get(0)) {
            throw new SetEmptyException("Set Empty Exception");
        } else {
            return subSet(get(0), toele);
        }
    }
    /**.
     * { function_description }
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
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
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
                try {
                    String[] arrstring = tokens[1].split(",");
                    int[] subarray = s.subSet(Integer.parseInt(arrstring[0]),
                                Integer.parseInt(arrstring[1]));
                    Set subset = new Set();
                    subset.add(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                } catch (InvalidSubSetSelectionException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "headSet":
                try {
                    int[] headarray = s.headset(Integer.parseInt(tokens[1]));
                    Set headset = new Set();
                    headset.add(headarray);
                    if (headset != null) {
                        System.out.println(headset);
                    }
                } catch (SetEmptyException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidSubSetSelectionException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "last":
                try {
                    System.out.println(s.last());
                } catch (SetEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "intersection":
                    s = new SortedSet();
                    SortedSet t = new SortedSet();
                    intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    t.add(intArray);
                    System.out.println(s.intersection(t));
                    break;
                case "retainAll":
                    s = new SortedSet();
                    intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    System.out.println(s.retainAll(intArray));
                    break;
                case "cartesianProduct":
                    s = new SortedSet();
                    t = new SortedSet();
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
