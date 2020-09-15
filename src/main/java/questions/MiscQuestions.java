package questions;

public class MiscQuestions {

    public String urlify(String src) {
        return src.trim()
                  .replace(" ", "%20");

    }

    public static void main(String[] args) {
        MiscQuestions questions = new MiscQuestions();
        System.out.println(questions.urlify("My Home Page   "));
    }
}
