import java.util.HashMap;
import java.util.List;

public class Quiz {

    private  String[] Questions = {
            "3,1,4,1,5", //pi
            "1,1,2,3,5",//fibonacci
            "1,4,9,16,25",//square
            "2,3,5,7,11",//primes
            "1,2,4,8,16"//powers of 2

    };

    private  int[] answers = {9,8,36,13,32};

    private String activeQuest;


    Quiz(){


    }



    public  int[] getAnswers() {
        return answers;
    }

    public  String[] getQuestions() {
        return Questions;
    }

    public String getActiveQuest() {
        return activeQuest;
    }


    public void setActiveQuest(String activeQuest) {
        this.activeQuest = activeQuest;
    }


}
