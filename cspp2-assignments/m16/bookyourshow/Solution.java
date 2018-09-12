import java.util.Scanner;
/**.
 * Class for patron.
 */
final class Patron {
    /**.
     * { item_description }
     */
    private String name, phoneno;
    /**.
     * Constructs the object.
     *
     * @param      nme    The nme
     * @param      phono  The phono
     */
    protected Patron(final String nme, final String phono) {
        this.name = nme;
        this.phoneno = phono;
    }
    /**.
     * { function_description }
     *
     * @param      nme  The name
     *
     * @return     { description_of_the_return_value }
     */
    public String Set_Name(final String nme) {
        return nme;
    }
    /**.
     * { function_description }
     *
     * @param      phono  The phoneno
     *
     * @return     { description_of_the_return_value }
     */
    public String Set_Phoneno(final String phono) {
        return phono;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return name;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getphoneno() {
        return phoneno;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getname() + "," + this.getphoneno();
    }
}
/**.
 * Class for show.
 */
final class Show {
    /**.
     * { var_description }
     */
    private String movename;
    /**.
     * { var_description }
     */
    private String datetime;
    /**.
     * { var_description }
     */
    private String[] seats;
    /**.
     * Constructs the object.
     *
     * @param      mvnme   The mvnme
     * @param      dtetme  The dtetme
     * @param      seat    The seat
     */
    protected Show(final String mvnme, final String dtetme, final String[] seat) {
        this.movename = mvnme;
        this.datetime = dtetme;
        this.seats = seat;
    }
    /**.
     * { function_description }
     *
     * @param      mvnme  The mvnme
     *
     * @return     { description_of_the_return_value }
     */
    public String Set_Movie(final String mvnme) {
        return mvnme;
    }
    /**.
     * { function_description }
     *
     * @param      dtetme  The dtetme
     *
     * @return     { description_of_the_return_value }
     */
    public String Set_Date_Time(final String dtetme) {
        return dtetme;
    }
    /**.
     * { function_description }
     *
     * @param      seat  The seat
     *
     * @return     { description_of_the_return_value }
     */
    public String[] Set_Seat(final String[] seat) {
        return seat;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getmovie() {
        return this.movename;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getdatetime() {
        return this.datetime;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String[] getseat() {
        return this.seats;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getmovie() + "," + this.getdatetime();
    }
}
/**.
 * Class for book your show.
 */
final class BookYourShow {
    /**.
     * { var_description }
     */
    private List<Show> shows;
    /**.
     * { var_description }
     */
    private List<String> tickets;
    /**.
     * Constructs the object.
     */
    protected BookYourShow() {
        shows = new List<Show>();
        tickets = new List<String>();
    }
    /**.
     * Adds a show.
     *
     * @param      s     { parameter_description }
     */
    public void addAShow(final Show s) {
        shows.add(s);
    }
    /**.
     * Gets a show.
     *
     * @param      movename  The movename
     * @param      datetime  The datetime
     *
     * @return     A show.
     */
    public Show getAShow(final String movename,
     final String datetime) {
        for (int i = 0; i < shows.size(); i++) {
            Show show = shows.get(i);
            if (show.getmovie().equals(movename)
             && show.getdatetime().equals(datetime)) {
                return show;
            }
        }
        return null;
    }
    /**.
     * { function_description }
     *
     * @param      movename  The movename
     * @param      datetime  The datetime
     * @param      p         { parameter_description }
     * @param      seats     The seats
     */
    public void bookAShow(final String movename,
     final String datetime, final Patron p, final String[] seats) {
        Show show = getAShow(movename, datetime);
        if (show == null) {
            System.out.println("No show");
        } else {
            String[] showseats = show.getseat();
            for (int i = 0; i < showseats.length; i++) {
                for (int j = 0; j < seats.length; j++) {
                    if (seats[j].equals(showseats[i])) {
                        showseats[i] = "N/A";
                    }
                }
            }
            StringBuffer s = new StringBuffer();
            s.append(p.getphoneno() + " ");
            s.append(movename + " ");
            s.append(datetime);
            tickets.add(s.toString());
        }
    }
    /**.
     * { function_description }
     *
     * @param      movename  The movename
     * @param      datetime  The datetime
     * @param      mobile    The mobile
     */
    public void printTicket(final String movename,
     final String datetime, final String mobile) {
        String ticket = mobile + " " + movename + " " + datetime;
        // for (int i = 0;i < tickets.size(); i++) {
        if (tickets.contains(ticket)) {
                System.out.println(ticket);
        } else {
            System.out.println("Invalid");
        }
    }
    /**.
     * Shows all.
     */
    public void showAll() {
        for (int i = 0; i < shows.size(); i++) {
            StringBuffer sb = new StringBuffer();
            Show show = shows.get(i);
            sb.append(show + ",[");
            String[] seats = show.getseat();
            for (int j = 0; j < seats.length - 1; j++) {
                sb.append(seats[j] + ",");
            }
            sb.append(seats[seats.length - 1] + "]");
            System.out.println(sb.toString());
        }
    }
}
/**.
 * { item_description }
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}
