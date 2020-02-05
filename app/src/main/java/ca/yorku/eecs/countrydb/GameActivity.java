package ca.yorku.eecs.countrydb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity
{
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum;
    public String log;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        game = new Game();
        game.activity = this;
        qNum =1;
        score = 0;
//        question =game.qa();
        ask();
        setContentsOfTextView(R.id.qNum, "Q# "+qNum);
        setContentsOfTextView(R.id.score, "SCORE = "+score);
        setContentsOfTextView(R.id.question, question);





    }

    private void setContentsOfTextView(int id, String newContents)
    {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    public String getAnswer(){
        return answer;
    }

    private void ask(){
        question =game.qa();
    }

    public void onDone(View v){

        EditText answerView = (EditText) findViewById(R.id.answer);
        answer = answerView.getText().toString();
        String s ="";
        if (qNum<10)
        {
            if (game.correct())
            {
                s += "\nQ# " + qNum + " " + question;
                s += "\nYour Answer: " + answer;
                s += "\nCorrect Answer: " + game.an;
                log += s + "\n";
                setContentsOfTextView(R.id.log, log);
                score++;
            } else
            {
                s += "\nQ# " + qNum + " " + question;
                s += "\nYour Answer: " + answer;
                s += "\nCorrect Answer: " + game.an;
                log += s + "\n";
                setContentsOfTextView(R.id.log, log);
            }

                qNum++;


            ask();
        }else if (qNum==10){
            question = "GAME OVER";
            if (game.correct())
            {
                s += "\nQ# " + qNum + " " + question;
                s += "\nYour Answer: " + answer;
                s += "\nCorrect Answer: " + game.an;
                log += s + "\n";
                setContentsOfTextView(R.id.log, log);
                score++;
            } else
            {
                s += "\nQ# " + qNum + " " + question;
                s += "\nYour Answer: " + answer;
                s += "\nCorrect Answer: " + game.an;
                log += s + "\n";
                setContentsOfTextView(R.id.log, log);
            }
        }

        setContentsOfTextView(R.id.score, "SCORE = "+score);

        setContentsOfTextView(R.id.question, question);
        setContentsOfTextView(R.id.qNum, "Q# "+qNum);




    }




}

