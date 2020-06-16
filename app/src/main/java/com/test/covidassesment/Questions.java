package com.test.covidassesment;

public class Questions {




    public String mQuestions[]={

            "Do You Have Any International Travel history?",
            "Do You Have Any Feverish Symptoms?",
            "Do You Have Any Symptoms of Dry Cough?",
            "Do You Have Any Symptoms of Sore Throat?",
            "Do You Have Any Symptoms of Tierdness?",
            "Do You Have Any Symptoms of Cold?",

    };
    private String mchoices[][]={
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"},
            {"Yes","No"},
    };

    private String mcorrectAnswers[]={"Yes","Yes","Yes","Yes","Yes","Yes"}  ;

    public String getQuestions(int a) {
        String question=mQuestions[a];
        return question;
    }
    public String getChoices(int a){
        String choice= mchoices[a][0];
        return choice;
    }
    public String getChoices1(int a){
        String choice= mchoices[a][1];
        return choice;
    }
    public String getCorrectAnswer(int a){
        String answer=mcorrectAnswers[a];
        return answer;
    }
}
