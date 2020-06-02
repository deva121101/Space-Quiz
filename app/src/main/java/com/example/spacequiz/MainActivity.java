package com.example.spacequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;

    RadioGroup radioGroup;
    RadioButton radioButtonSelected;

    CheckBox checkBoxOption1, checkBoxOption2, checkBoxOption3, checkBoxOption4;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitQuiz(View v) {
        calculateScore();
        if (score >= 3) {
            Toast.makeText(getApplicationContext(), " You passed the Quiz with score " + score, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), " You failed with score " + score, Toast.LENGTH_SHORT).show();
        }
        score = 0;
    }

    /**
     * This method uses logic to calculate the total score by checking answers of each question individually
     */
    private void calculateScore() {
        int radioid;
        radioGroup = findViewById(R.id.radio_group_question1);      //Gets the text from the selected radio button and checks it to increase the score
        radioid = radioGroup.getCheckedRadioButtonId();
        if (radioid != -1) {                                        //Prevents crashing by executing the following code only is an answer is selected for q1
            radioButtonSelected = findViewById(radioid);
            if (radioButtonSelected.getText().toString().equals("Black Hole")) score++;
        }

        radioGroup = findViewById(R.id.radio_group_question2);               //Gets the text from the selected radio button and checks it to increase the score
        radioid = radioGroup.getCheckedRadioButtonId();
        if (radioid != -1)                                                    //Prevents crashing by executing the following code only is an answer is selected for q1
        {
            radioButtonSelected = findViewById(radioid);
            if (radioButtonSelected.getText().toString().equals("2019")) score++;
        }


        checkBoxOption1 = findViewById(R.id.checkbox1q3);                       //Increases score if and only if checkbox 2 and 4 are checked. Also makes sure that 1 and 3 are not checked
        checkBoxOption2 = findViewById(R.id.checkbox2q3);
        checkBoxOption3 = findViewById(R.id.checkbox3q3);
        checkBoxOption4 = findViewById(R.id.checkbox4q3);
        if (checkBoxOption2.isChecked() && checkBoxOption4.isChecked() && (!checkBoxOption1.isChecked()) && (!checkBoxOption3.isChecked()))
            score++;

        editText = findViewById(R.id.name);
        if (editText.getText().toString().equals("NEIL ARMSTRONG"))
            score++;    //Checks if the entered string is correct
    }

}
