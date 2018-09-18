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
    public String quizname;
    /**.
     * { var_description }
     */
    public String[] choices;
    /**.
     * { var_description }
     */
    public int crctanswr;
    /**.
     * { var_description }
     */
    public int maxmarks;
    /**.
     * { var_description }
     */
    public int penalty;
    /**.
     * Constructs the object.
     *
     * @param      qname   The qname
     * @param      choice  The choice
     * @param      answer  The answer
     * @param      marks   The marks
     * @param      penlty  The penlty
     */
    Question(final String qname, final String[] choice,
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
    // public String getchoices() {
    //     String[] c = choices.split(",");
    //     int i = 0;
    //     return c[i] + "    " + c[i + 1] + "    " + c[i + 2] + "    " + c[i + 3];
    // }
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
    static List<Question> question = new List<Question>();
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
    public static void loadQuestions (final Scanner s,
     final Quiz quiz, int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        // if ( questionCount == 0){
        // 	System.out.println("Quiz does not have questions");
        // } else {
        // 	System.out.println("Error! Malformed question");
        // }
        int qc = questionCount;
        while (questionCount > 0) {
            String line = s.nextLine();
            String[] array = line.split(":");
            String[] answers = array[1].split(",");
            question.add(new Question(array[0], answers,
             Integer.parseInt(array[2]), Integer.parseInt(array[3]),
              Integer.parseInt(array[4])));
            questionCount--;
        }
        System.out.println(qc + " are added to the quiz");
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
        // for (int i = 0; i < question.size(); i++) {
        //     System.out.println(question.get(i).quizname + "(" + question.get(i).maxmarks + ")");
        //     int j = 0;
        //     for(  j = 0; j < question.get(i).choices.length - 1; j++ ) {
        //     	System.out.print(question.get(i).choices[j] + "    ");
        //     }
        //     System.out.println(question.get(i).choices[j]);
        //     System.out.println();
        // }
        // System.out.println();
        // while(answerCount > 0) {
        // 	String line = s.nextLine();
        // 	String[] key = line.split(" ");

        // }
    }
    /**.
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        // System.out.println(quiz.getquizname());
        // for(int i = 0; i < quiz.size(); i++) {
        //     if(quiz.get(i).equals(question.getcrctanswr())) {
        //         System.out.println("Correct Answer! - Marks Awarded"
        //          + quiz.getmaxmarks());
        //     }
        // }

    }
}
