package armorhin.ept003.activity;

import android.arch.lifecycle.Observer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import armorhin.ept003.R;
import armorhin.ept003.dao.QuestionDao;
import armorhin.ept003.db.AppDatabase;
import armorhin.ept003.entity.Answer;
import armorhin.ept003.entity.Question;
import armorhin.ept003.helper.RoomHelper;

public class PracticeActivity extends AppCompatActivity {

    AppDatabase db;
    QuestionDao questionDao;
    TextView txtPractice;
    Button answer1;
    Button answer2;
    Button answer3;

    List<Answer> answersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        txtPractice = findViewById(R.id.txtPractice);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        setRandomQuestionAndAnswers();
    }

    public void onAnswerClick(View view) {
        int answer = -1;
        switch (view.getId()) {
            case R.id.answer1:
                answer = 0;
                break;
            case R.id.answer2:
                answer = 1;
                break;
            case R.id.answer3:
                answer = 2;
                break;
        }

        if (answer == -1)
            return;

        setButtonsEnabled(false);
        if (answersList.get(answer).isRight()) {
            ((Button) view).setTextColor(getResources().getColor(R.color.colorGreen));
        } else {
            ((Button) view).setTextColor(getResources().getColor(R.color.colorRed));
        }

        new Handler().postDelayed(() -> {
            clearButtonsState();
            setRandomQuestionAndAnswers();
        }, 500);
    }

    private void clearButtonsState() {
        answer1.setTextColor(getResources().getColor(android.R.color.primary_text_light));
        answer2.setTextColor(getResources().getColor(android.R.color.primary_text_light));
        answer3.setTextColor(getResources().getColor(android.R.color.primary_text_light));
        setButtonsEnabled(true);
    }

    private void setButtonsEnabled(boolean flag) {
        answer1.setEnabled(flag);
        answer2.setEnabled(flag);
        answer3.setEnabled(flag);
    }


    private void setRandomQuestionAndAnswers() {
        db = RoomHelper.getAppDatabase(getApplicationContext());
        questionDao = db.getQuestionDao();
        questionDao.getAllQuestion().observe(this, questions -> {
            if (questions == null)
                return;
            Random random = new Random();
            int questionPosition = random.nextInt(questions.size());
            Question question = questions.get(questionPosition);
            txtPractice.setText(question.getText());

            setAnswers(question);
        });
    }

    private void setAnswers(Question question) {
        questionDao.getAnswersForQuestion(question.getId()).observe(this, answers -> {
            if (answers == null)
                return;
            Collections.shuffle(answers);
            answer1.setText(answers.get(0).getText());
            answer2.setText(answers.get(1).getText());
            answer3.setText(answers.get(2).getText());
            answersList = answers;
        });
    }


}
