package com.example.android.sillyquiz;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * a global variable to keep track of the score
     */
    int yourScore = 0;
    private RadioGroup radioGroup;
    TextView showResults;
    CheckBox number1a;
    CheckBox number1b;
    CheckBox number1c;
    EditText orderName;
    CheckBox number2a;
    CheckBox number2b;
    CheckBox number2c;
    RadioButton number3a;
    RadioButton number3b;
    RadioButton number3c;
    RadioButton number5a;
    RadioButton number5b;
    RadioButton number5c;
    RadioButton number6a;
    RadioButton number6b;
    RadioButton number6c;
    Button mButton;
    EditText mEdit;
    String entry;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showResults = (TextView) findViewById(R.id.score_display_view);
        number1a = (CheckBox) findViewById(R.id.coffee_checkbox1a);
        number1b = (CheckBox) findViewById(R.id.guitar_checkbox1b);
        number1c = (CheckBox) findViewById(R.id.trombon_checkbox1c);
        orderName = (EditText) findViewById(R.id.name);
        number2a = (CheckBox) findViewById(R.id.instrument_checkbox2a);
        number2b = (CheckBox) findViewById(R.id.instrument_checkbox2b);
        number2c = (CheckBox) findViewById(R.id.instrument_checkbox2c);
        number3a = (RadioButton) findViewById(R.id.radionotmetal_button3a);
        number3b = (RadioButton) findViewById(R.id.radionotmetal_button3b);
        number3c = (RadioButton) findViewById(R.id.radionotmetal_button3c);
        number5a = (RadioButton) findViewById(R.id.radiotenor_5a);
        number5b = (RadioButton) findViewById(R.id.radiotenor_box5b);
        number5c = (RadioButton) findViewById(R.id.radiotenor_box5c);
        number6a = (RadioButton) findViewById(R.id.radiohotair_box6a);
        number6b = (RadioButton) findViewById(R.id.radiohotair_box6b);
        number6c = (RadioButton) findViewById(R.id.radiohotair_box6c);

//set up for my Silly Quiz app as an example

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.string) {
                    Toast.makeText(getApplicationContext(), "Try again, wrong answer!",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.brass) {
                    Toast.makeText(getApplicationContext(), "Yes!, that's right",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No, try again",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up the EntryText onClick button to read the answer to question.
        mButton = (Button)findViewById(R.id.entryQButton);
        mEdit   = (EditText)findViewById(R.id.entryAnswer);

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {  entry = mEdit.getText().toString();
                        Log.v("EditText", entry);

                    }
                });

    }
    //** This method checks the TextEntry input to see if it is the right answer, and if so, adds one.
    public int entryFour(String entry, int score){

        if (entry.equals("four") || entry.equals("Four") || entry.equals("FOUR")){
            score = score + 1;}
        return score;
            }

    /**
     * This method displays the given score on the screen. It finds the view by the Id and then sends the result
     * to it.
     */
    private void displayMessage(String message) {
        showResults.setText(message);
    }

    /**
     * This method is run when the Score onclick is pressed. The method checks the status of the checkboxes
     * This method takes the Name entered and puts it into a variable called namehere then the
     * various question answer boxes.     *
     */
    public void scoreResult(View view) {
        //** this takes in the name of the player

        String namehere = orderName.getText().toString();
         /* @boolean number1a, number1b, number1c, and variables for the other checkboxes and radiobox up to 5.
          * It calls the method to add one point it if it is correct, scoretotal.
          * It displays the result in a toast and also in a TextView score_button.
        //** setting the boolean variable for Question 1
        */

        boolean wrong1a = number1a.isChecked();

        boolean correct1b = number1b.isChecked();

        boolean correct1c = number1c.isChecked();

        //**Setting the boolean variable for Question 2

        boolean correct2a = number2a.isChecked();

        boolean wrong2b = number2b.isChecked();

        boolean correct2c = number2c.isChecked();

        //**Setting the boolean variable for Question 3

        boolean correct3a = number3a.isChecked();

       //** boolean wrong3b = number3b.isChecked();

        //**boolean wrong3c = number3c.isChecked();

        //**Setting the boolean variable for Question 5

        //**boolean wrong5a = number5a.isChecked();

        boolean correct5b = number5b.isChecked();
        //**boolean wrong5c = number5c.isChecked();

        //**Setting the boolean variable for Question 5

        //**boolean wrong6a = number6a.isChecked();


        //**boolean wrong6b = number6b.isChecked();

        boolean correct6c = number6c.isChecked();

        /** Create a new object, Toast using the factory method not a constructor, makeText
         /** first update the score by running scoretotal
         */
        scoretotal(wrong1a, correct1b, correct1c, correct2a, wrong2b, correct2c, correct3a, correct5b, correct6c, score);
        Toast.makeText(this, (namehere + " you have  " + yourScore + " "), Toast.LENGTH_LONG).show();
        displayMessage(showResults(namehere));
        yourScore = 0;
    }

    /**
     * //** This method scoretotal adds together the correct answers for each questions by taking the true responses
     * //**@boolean correct1b and also correct 1c and NOTwrong1a for answer1, @boolean correct2a answer2, @boolean correct3a ans 3, correct4b, correct 5c
     * /* boolean correct4b
     */

    private void scoretotal(boolean wrong1a, boolean correct1b, boolean correct1c, boolean correct2a, boolean wrong2b, boolean correct2c, boolean correct3a, boolean correct5b, boolean correct6c, int score) {
        if (!wrong1a && correct1b && correct1c) {
            yourScore = 1;
        }
        if (correct2a && !wrong2b && correct2c) {
            yourScore = yourScore + 1;
        }
        if (correct3a) {
            yourScore = yourScore + 1;
        }
        if (correct5b) {
            yourScore = yourScore + 1;
        }
        if (correct6c) {
            yourScore = yourScore + 1;
        }
            yourScore = entryFour(entry,score) + yourScore;
           }
    //**
    //This method is called to reset the score to zero
    public void resetGameChoice(View view) {
        yourScore = 0;
        showResults("");
        scoreResult();
    }
    /**
     * Displays the total score for the answers.
     */
    public void scoreResult() {
        TextView scoreView = (TextView) findViewById(R.id.score_display_view);
        scoreView.setText(String.valueOf(yourScore));
    }

    //** Displays some text about the player .
    public void displaysScore() {
        TextView scoreView = (TextView) findViewById(R.id.score_button);
        scoreView.setText(String.valueOf(yourScore));
    }

    //** This displays the name and score of the player on the screen
    private String showResults(String namehere) {
        String QuizEnd = namehere + " " + yourScore;
        return (QuizEnd);
    }

    //** called when Press Me is pressed!
    public void PressMe(View view) {
        ImageView iconImageView = (ImageView) findViewById(R.id.android_lion_image_view);
        iconImageView.setImageResource(R.drawable.bluewhale);

        TextView orderSummaryTextView = (TextView) findViewById(R.id.status_text_view);
        orderSummaryTextView.setText("A BLUE WHALE!");
    }
}