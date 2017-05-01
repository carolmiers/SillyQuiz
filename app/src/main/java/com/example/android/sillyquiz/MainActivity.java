package com.example.android.sillyquiz;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import static android.R.attr.contextClickable;
import static android.R.attr.name;
import static android.R.attr.valueFrom;
import static android.R.attr.y;
import static android.util.Log.v;

public class MainActivity extends AppCompatActivity {
    /** a global variable to keep track of the score
     */

    int yourScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method displays the given score on the screen. It finds the view by the Id and then sends the result
     * to it.
     */
    private void displayMessage(String message) {
        TextView showResults = (TextView) findViewById(R.id.score_display_view);
        showResults.setText(message);
    }
    /** This method is run when the Score onclick is pressed. The method checks the status of the checkboxes
     * This method takes the Name entered and puts it into a variable called namehere then the
     * various question answer boxes.     *
     * @boolean number1a, number1b, number1c, and variables for the other checkboxes and radiobox up to 5.
     * It calls the method to add one point it if it is correct, scoretotal.
     * It displays the result in a toast and also in a TextView score_button.
     */
    public void scoreResult(View view) {
        //** this takes in the name of the player
        EditText orderName = (EditText) findViewById(R.id.name);
        String namehere = orderName.getText().toString();

        //** setting the boolean variable for Question 1
        CheckBox number1a = (CheckBox) findViewById(R.id.coffee_checkbox1a);
        boolean wrong1a = number1a.isChecked();
        Log.v("MainActivity", "this is wrong1a" +  wrong1a +!wrong1a);

        CheckBox number1b = (CheckBox) findViewById(R.id.guitar_checkbox1b);
        boolean correct1b = number1b.isChecked();
        Log.v("MainActivity", "this is correct1b" + correct1b);


        CheckBox number1c = (CheckBox) findViewById(R.id.trombon_checkbox1c);
        boolean correct1c = number1c.isChecked();
        Log.v("MainActivity", "this is correct1c" + correct1c);

       //**Setting the boolean variable for Question 2
        CheckBox number2a = (CheckBox) findViewById(R.id.instrument_checkbox2a);
        boolean correct2a = number2a.isChecked();

        CheckBox number2b = (CheckBox) findViewById(R.id.instrument_checkbox2b);
        boolean wrong2b = number2b.isChecked();

        CheckBox number2c = (CheckBox) findViewById(R.id.instrument_checkbox2c);
        boolean correct2c = number2c.isChecked();

        //**Setting the boolean variable for Question 3
        RadioButton number3a = (RadioButton) findViewById(R.id.radionotmetal_button3a);
        boolean correct3a = number3a.isChecked();

        RadioButton number3b = (RadioButton) findViewById(R.id.radionotmetal_button3b);
        boolean wrong3b = number3b.isChecked();

        RadioButton number3c = (RadioButton) findViewById(R.id.radionotmetal_button3c);
        boolean wrong3c = number3c.isChecked();

        //**Setting the boolean variable for Question 4
        RadioButton number4a = (RadioButton) findViewById(R.id.radiotenor_4a);
        boolean wrong4a = number4a.isChecked();

        RadioButton number4b = (RadioButton) findViewById(R.id.radiotenor_box4b);
        boolean correct4b = number4b.isChecked();

        RadioButton number4c = (RadioButton) findViewById(R.id.radiotenor_box4c);
        boolean wrong4c = number4c.isChecked();

        //**Setting the boolean variable for Question 5
        RadioButton number5a = (RadioButton) findViewById(R.id.radiohotair_box5a);
        boolean wrong5a = number5a.isChecked();
        //Log.v("MainActivity", "This is 5a " + wrong5a);
        RadioButton number5b = (RadioButton) findViewById(R.id.radiohotair_box5b);
        boolean wrong5b = number5b.isChecked();
        //Log.v("MainActivity", "This is 5b" + wrong5b);
        RadioButton number5c = (RadioButton) findViewById(R.id.radiohotair_box5c);
        boolean correct5c = number5c.isChecked();
        //Log.v("MainActivity", "This is 5c" + correct5c);

        /** Create a new object, Toast using the factory method not a constructor, makeText
         *
         /** first update the score by running scoretotal
         */
        scoretotal(wrong1a, correct1b, correct1c,correct2a, wrong2b, correct2c, correct3a, correct4b,correct5c);
        Toast.makeText(this, (namehere + " you have  " + yourScore + " "), Toast.LENGTH_LONG).show();
        displayMessage(showResults(namehere));
        }
        /**
        */
          //** This method scoretotal adds together the correct answers for each questions by taking the true responses
       //**@boolean correct1b and also correct 1c and NOTwrong1a for answer1, @boolean correct2a answer2, @boolean correct3a ans 3, correct4b, correct 5c
           /* boolean correct4b
   */
     private void scoretotal (boolean wrong1a, boolean correct1b, boolean correct1c, boolean correct2a,boolean wrong2b,boolean correct2c, boolean correct3a, boolean correct4b,boolean correct5c){
          if (!wrong1a && correct1b && correct1c){
             yourScore = 1; }
         Log.v("MainActivity","This is the checkbox" + yourScore);
         if (correct2a && !wrong2b && correct2c) {
                 yourScore = yourScore + 1; }
         if (correct3a) {
                 yourScore = yourScore + 1; }
         if (correct4b) {
                 yourScore = yourScore +1; }
         if (correct5c) {
             yourScore = yourScore + 1;
         }   }
    //**
    //
     //This method is called to reset the score to zero
      public void resetGameChoice(View view ) {
        yourScore=0 ;
        showResults("");
        scoreforA();
    }
    /**
     * Displays the given score for a player.
     */
    public void scoreforA() {
        TextView scoreView = (TextView)findViewById(R.id.score_display_view);
        scoreView.setText(String.valueOf(yourScore));
    }
    //** Displays some text about the player .
    public void displaysScore () {
        TextView scoreView = (TextView)findViewById(R.id.score_button);
        scoreView.setText(String.valueOf(yourScore));
    }
    //** This displays the name and score of the player on the screen
    private String showResults(String namehere){
        //**String QuizEnd = "Hello " + namehere ;
        /*QuizEnd = " you have " + yourScore ;
        */ String QuizEnd = namehere + " " + yourScore;
        return(QuizEnd) ;
    }
    //** called when Press Me is pressed!

    public void PressMe(View view) {

        ImageView iconImageView = (ImageView) findViewById(R.id.android_lion_image_view);
        iconImageView.setImageResource(R.drawable.bluewhale);

        TextView orderSummaryTextView = (TextView) findViewById(R.id.status_text_view);
        orderSummaryTextView.setText("A BLUE WHALE!");}


}