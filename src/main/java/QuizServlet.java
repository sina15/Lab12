import com.sun.org.apache.xpath.internal.functions.FuncQname;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="quiz",urlPatterns={"/","/quiz"})

public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        QuizService quizService = QuizService.getQuizServiceInstance();

        HttpSession session = req.getSession();
        if(session.getAttribute("score")==null){
            session.setAttribute("score", "0");
        }
        int score = Integer.parseInt(session.getAttribute("score").toString());




        if(quizService.getEndGame()==true){
//            session.setAttribute("score", 0);
//            quizService.setIndex(0);


            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<div style=\"width: 500px; margin-left: auto;margin-right: auto; border:1px solid blue\">\n" +
                    "    <header>\n" +
                    "\n" +
                    "        <h1>The Number Quiz</h1>\n" +
                    "    </header>\n" +
                    "    <section>\n" +
                    "        <p>Your Current Score is <span>"+score+"</span></p>\n" +
                    "        <div>\n" +
                    "            <p>You have Completed the Number Quiz , with a score "+score+" out of "+quizService.getIndex()+"</p>\n" +
                    "        </div>\n" +
                    "\n" +

                    "    </section>\n" +
                    "</div>");

        }else{

            String question = quizService.ChooseQuestion(0);

            if(req.getParameter("result")!=null ){

                int result = Integer.parseInt(req.getParameter("result"));
                boolean isTrue = quizService.checkAnswer(result);

                if(isTrue){
                    score+=1;
                    session.setAttribute("score", ""+score+"");
                }


                 question= quizService.ChooseQuestion();

            }


            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<div style=\"width: 500px; margin-left: auto;margin-right: auto; border:1px solid blue\">\n" +
                    "    <header>\n" +
                    "\n" +
                    "        <h1>The Number Quiz</h1>\n" +
                    "    </header>\n" +
                    "    <section>\n" +
                    "        <p>Your Current Score is <span>"+score+"</span></p>\n" +
                    "        <p>Guess the next number in the sequence.</p>\n" +
                    "        <div>\n" +
                    "            <p>"+question+"</p>\n" +
                    "        </div>\n" +
                    "\n" +
                    "        <form action=\"quiz\" method=\"post\" style=\"margin-bottom: 30px;\">\n" +
                    "            <label>Your Answer: &nbsp;<input type=\"number\" name=\"result\" required></label><br/><b/>\n" +
                    "            <input type=\"submit\" value=\"Submit\">\n" +
                    "        </form>\n" +
                    "    </section>\n" +
                    "</div>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     doGet(req,resp);

    }
}
