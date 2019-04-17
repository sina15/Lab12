import java.util.HashMap;
import java.util.List;

public class QuizService {



       private Quiz quiz;
       private int index;
       private  boolean endGame;


       private static QuizService quizServiceInstance=null;



       private QuizService(){

           quiz = new Quiz();
           endGame = false;
           index =0;


       }

       public  boolean getEndGame(){
           return endGame;
       }

    public static QuizService getQuizServiceInstance() {

           if(quizServiceInstance==null){
               quizServiceInstance = new QuizService();
           }
        return quizServiceInstance;
    }



    public String ChooseQuestion() {

        if (index == quiz.getQuestions().length - 1){
            endGame = true;

        }


        else
            index += 1;

        return quiz.getQuestions()[index];

    }

    public String ChooseQuestion(int ind){

           return quiz.getQuestions()[ind];
    }



    public boolean checkAnswer( Integer ans){

        if(quiz.getAnswers()[index]==ans){
            return true;
        }else{
            return false;
        }

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

