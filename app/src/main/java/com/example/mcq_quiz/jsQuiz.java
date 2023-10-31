package com.example.mcq_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class jsQuiz extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView ;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion=5;
    int currentQuestionIndex=10;
    String selectedAnswer="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_quiz);
        totalQuestionsTextView=findViewById(R.id.textView12);
        questionTextView=findViewById(R.id.textView13);
        ansA=findViewById(R.id.button12);
        ansB=findViewById(R.id.button13);
        ansC=findViewById(R.id.button14);
        ansD=findViewById(R.id.button15);
        submitBtn=findViewById(R.id.button16);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total Questions: "+totalQuestion);
        loadNewQuestion();
        ansA.setBackgroundColor(Color.parseColor("#182051"));
        ansB.setBackgroundColor(Color.parseColor("#182051"));
        ansC.setBackgroundColor(Color.parseColor("#182051"));
        ansD.setBackgroundColor(Color.parseColor("#182051"));

    }

    @Override
    public void onClick(View v) {

        ansA.setBackgroundColor(Color.parseColor("#182051"));
        ansB.setBackgroundColor(Color.parseColor("#182051"));
        ansC.setBackgroundColor(Color.parseColor("#182051"));
        ansD.setBackgroundColor(Color.parseColor("#182051"));

        Button clickedButton =(Button) v;
        if(clickedButton.getId()==R.id.button16){
            if(selectedAnswer.equals(QuestionsAnswer.answers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        }else {
            selectedAnswer=clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.parseColor("#7888E2"));

        }
    }

    void loadNewQuestion(){

        if(currentQuestionIndex==15){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionsAnswer.questions[currentQuestionIndex]);
        ansA.setText(QuestionsAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionsAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionsAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionsAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        String passStatus="";
        if(score >= totalQuestion*0.60){
            passStatus="Passed";
        }
        else{
            passStatus="Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+score+" out of "+totalQuestion)
                .setPositiveButton("Restart",((dialog, which) -> restartQuiz()))
                .setCancelable(false)
                .show();
    }
    void restartQuiz(){
        score=0;
        currentQuestionIndex=10;
        loadNewQuestion();
    }}