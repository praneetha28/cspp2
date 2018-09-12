import java.io.BufferedInputStream;
/**.
 * { item_description }
 */
import java.util.Scanner;
/** .
 *  { item_description }
 */
import java.util.Arrays;
/**.
 * Class for patron.
 */
class Patron {
    /**.
     * { item_description }
     */
    private String name, phoneno;
    public Patron(String nme, String phono) {
        this.name = nme;
        this.phoneno = phono;
    }
    public String Setname(String name) {
        return this.name = name;
    }
    public String Setphoneno(String phoneno) {
        return this.phoneno = phoneno;
    }
    public String getname() {
        return name;
    }
    public String getphoneno() {
        return phoneno;
    }
    public String toString() {
        return this.getname() + "," + this.getphoneno();
    }
}
/**.
 * Class for show.
 */
class Show {
    private String movename;
    private String datetime;
    private String[] seats;
    public Show(final String mvnme, final String dtetme, final String[] seat) {
        this.movename = mvnme;
        this.datetime = dtetme;
        this.seats = seat;
    }
    public String Setmovie(String mvnme) {
        return this.movename = mvnme;
    }
    public String Setdatetime(String dtetme) {
        return this.datetime = dtetme;
    }
    public String[] Setseat(final String[] seat) {
        return this.seats = seat;
    }
    public String getmovie() {
        return this.movename;
    }
    public String getdatetime() {
        return this.datetime;
    }
    public String[] getseat() {
        return this.seats;
    }
    public String toString() {
        return this.getmovie() + "," + this.getdatetime();
    }
}
class BookYourShow {
    private List<Show> shows;
    private List<String> tickets;
    public BookYourShow() {
        shows = new List<Show>();
        tickets = new List<String>();
    }
    public void addAShow(Show s) {
        shows.add(s);
    }
    public Show getAShow(final String movename, final String datetime) {
        for (int i = 0; i < shows.size(); i++) {
            Show show = shows.get(i);
            if(show.getmovie().equals(movename) && show.getdatetime().equals(datetime)) {
                return show;
            }
        }
        return null;
    }
    public void bookAShow(final String movename, final String datetime, final Patron p, final String[] seats) {
        Show show = getAShow(movename, datetime);
        if(show == null) {
            System.out.println("No show");
        } else {
            String[] showseats = show.getseat();
            for(int i = 0; i < showseats.length; i++) {
                for(int j = 0; j < seats.length; j++) {
                    if(seats[j].equals(showseats[i])) {
                        showseats[i] = null;
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
    public void printTicket(final String movename, final String datetime, final String mobile) {
        String ticket = mobile + " " + movename + " " + datetime;
        // for (int i = 0;i < tickets.size(); i++) {
        if (tickets.contains(ticket)) {
                System.out.println(ticket);
        } else {
            System.out.println("Invalid");
        }
    }
    public void showAll() {
        // for( int i = 0; i<shows.size(); i++) {
        //     System.out.println(shows.get(i).toString() + "," + shows.getseat().replace(" "," ").toString());
        // }
    }
}

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
