import java.util.HashMap;
import java.util.List;

public class QuizService {



       private Quiz quiz;
       private int index =0;

       private static QuizService quizServiceInstance=null;



       private QuizService(){

           quiz = new Quiz();
           quiz.setActiveQuest(quiz.getQuestions()[0]);

       }



    public static QuizService getQuizServiceInstance() {

           if(quizServiceInstance==null){
               quizServiceInstance = new QuizService();
           }
        return quizServiceInstance;
    }

    public String ChooseQuestion(){

        if(index==quiz.getQuestions().length-1)
        index =0;

        else
            index+=1;

        String activeQuest = quiz.getQuestions()[index];
        quiz.setActiveQuest(activeQuest);
        return activeQuest;
    }



    public boolean checkAnswer( Integer ans){

        if(quiz.getAnswers()[index]==ans){
            return true;
        }else{
            return false;
        }

    }

}

