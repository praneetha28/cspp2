/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for question.
 */
class Question {
    /**.
     * { var_description }
     */
    private String quizname;
    /**.
     * { var_description }
     */
    private String choices;
    /**.
     * { var_description }
     */
    private int crctanswr;
    /**.
     * { var_description }
     */
    private int maxmarks;
    /**.
     * { var_description }
     */
    private int penalty;
    /**.
     * Constructs the object.
     *
     * @param      qname   The qname
     * @param      choice  The choice
     * @param      answer  The answer
     * @param      marks   The marks
     * @param      penlty  The penlty
     */
    Question(final String qname, final String choice,
     final int answer, final int marks, final int penlty) {
        this.quizname = qname;
        this.choices = choice;
        this.crctanswr = answer;
        this.maxmarks = marks;
        this.penalty = penlty;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getquizname() {
        return quizname;
    }
    /**.
     *
     *
     * @return     { description_of_the_return_value }
     */
    public String getchoices() {
        String[] c = choices.split(",");
        return c[0] + "    " + c[1] + "    " + c[2] + "    " + c[3];
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getcrctanswr() {
        return crctanswr;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getmaxmarks() {
        return maxmarks;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getpenalty() {
        return penalty;
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
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s,
     final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        List<Question> question = new List<Question>();
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] array = line.split(":");
            question.add(new Question(array[0], array[1],
             Integer.parseInt(array[2]), Integer.parseInt(array[3]),
              Integer.parseInt(array[4])));
        }
        System.out.println(questionCount + "are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s,
     final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        System.out.println(quiz.getquizname());
        System.out.println(quiz.getchoices());
        for(int i = 0; i < answerCount; i++) {
            String res = s.nextLine();
        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        System.out.println(quiz.getquizname());
        // for(int i = 0; i < quiz.size(); i++) {
        //     if(quiz.get(i).equals(question.getcrctanswr())) {
        //         System.out.println("Correct Answer! - Marks Awarded"
        //          + quiz.getmaxmarks());
        //     }
        // }

    }
}
