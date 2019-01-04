package com.example.android.grammerquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * function submitOrder is called  when  submit  button is clicked
     */
    public void submitOrder(View view) {

        /**checks wheteher or not yesI is selected*/
        CheckBox yesICheckBox = (CheckBox) findViewById(R.id.Yes_IAM_checkbox);
        boolean hasYesICheck = yesICheckBox.isChecked();
        /**checks whether or not yesWecheckBox is selected*/
        CheckBox yesWeCheckBox = (CheckBox) findViewById(R.id.Yes_WE_ARE_checkbox);
        boolean hasYesWe = yesWeCheckBox.isChecked();
        /**checks whether noCheckBox is selected or not */
        CheckBox noCheckBox = (CheckBox) findViewById(R.id.NO_checkbox);
        boolean hasNoCheckBox = noCheckBox.isChecked();

        /**call function to evaluate degree of question 1*/
        int question1Degree = chooseQuestion1(hasYesICheck, hasYesWe, hasNoCheckBox);

        /**checks whether or not playing_radio is choosen*/
        RadioButton playing_radio = (RadioButton) findViewById(R.id.playing_radio);
        boolean has_playing_radio = playing_radio.isChecked();

        /**checks whether or not play_radio is choosen*/
        RadioButton play_radio = (RadioButton) findViewById(R.id.play_radio);
        boolean has_play_radio = play_radio.isChecked();

        /**checks whether or not am_playing is choosen */
        RadioButton am_playing_radio = (RadioButton) findViewById(R.id.am_playing_radio);
        boolean has_am_playing_radio = am_playing_radio.isChecked();

        /**checks wheteher or not am_play is choosen */
        RadioButton am_play_radio = (RadioButton) findViewById(R.id.am_play_radio);
        boolean has_am_play_radio = am_play_radio.isChecked();

        /**calls function to evaluate question2 degree*/
        int question2Degree = chooseQuestion2(has_playing_radio, has_play_radio, has_am_playing_radio, has_am_play_radio);

        /**checks whether or not try_radio is choosen*/
        RadioButton try_radio = (RadioButton) findViewById(R.id.try_radio);
        boolean has_try_radio = try_radio.isChecked();

        /**checks whether or not tries_radio is choosen*/
        RadioButton tries_radio = (RadioButton) findViewById(R.id.tries_radio);
        boolean has_tries_radio = tries_radio.isChecked();

        /**checks whether or not tried_radio is choosen*/
        RadioButton tried_radio = (RadioButton) findViewById(R.id.tried_radio);
        boolean has_tried_radio = tried_radio.isChecked();

        /** checks whether or not is_trying is choosen*/
        RadioButton is_trying_radio = (RadioButton) findViewById(R.id.is_trying_radio);
        boolean has_is_trying_radio = is_trying_radio.isChecked();

        /** call function for choose of question3 */
        int question3Degree = chooseQuestion3(has_try_radio, has_tries_radio, has_tried_radio, has_is_trying_radio);

        /** checks whether or not be_radio is choosen or not */
        RadioButton be_radio = (RadioButton) findViewById(R.id.be_radio);
        boolean has_be_radio = be_radio.isChecked();

        /**checks whether is_radio is choosen or not**/
        RadioButton is_radio = (RadioButton) findViewById(R.id.is_radio);
        boolean has_is_radio = is_radio.isChecked();

        /**checks whether has_radio is choosen or not*/
        RadioButton has_radio = (RadioButton) findViewById(R.id.has_radio);
        boolean has1_radio = has_radio.isChecked();

        /**checks wheteher have_radio is choosen or not*/
        RadioButton have_radio = (RadioButton) findViewById(R.id.have_radio);
        boolean has_have_radio = have_radio.isChecked();

        /** call function to evaluate question4 degree*/
        int question4Degree = chooseQuestion4(has_be_radio, has_is_radio, has1_radio, has_have_radio);

        /**editText for name **/
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        /** edittext for question5 free text response*/
        EditText question5Field = (EditText) findViewById(R.id.answer_field);
        String answer = question5Field.getText().toString();

        /**question5 degree evaluation*/
        int question5Degree = chooseQuestion5(answer);

        /**calculates degree for question5 */
        int totalDegrees = question1Degree + question2Degree + question3Degree + question4Degree + question5Degree;
        Toast.makeText(this, "the total degree for :" + name + " is" + totalDegrees, Toast.LENGTH_SHORT).show();


    }

    /**
     * question1 evaluation Function
     *
     * @param yesI
     * @param YesWe
     * @param No
     * @return degree of question if true
     */
    public int chooseQuestion1(boolean yesI, boolean YesWe, boolean No) {
        int count1= 0;
        if ((yesI) && (YesWe) && (No)) {
            count1 = 1;
        } else {
            count1 = 0;
            Toast.makeText(this, "you choose a wrong answer please try again", Toast.LENGTH_SHORT).show();
        }
        return count1;
    }

    /**
     * function evaluation for question2 degree
     *
     * @param playing    whether or not is choosen
     * @param play       whether or not is choosen
     * @param am_play    whether or not is choosen
     * @param am_playing whether or not is choosen
     * @return degree of question2
     */

    public int chooseQuestion2(boolean playing, boolean play, boolean am_playing, boolean am_play) {
        int count2 = 0;
        if (play) {
            count2 = 1;
        } else {
            count2 = 0;
            Toast.makeText(this, "you choose a wrong answer", Toast.LENGTH_SHORT).show();
        }
        return count2;
    }

    /**
     * function evaluation for question 3
     *
     * @param tryRadio
     * @param triesRadio
     * @param triedRadio
     * @param is_trying_radio
     * @return degree of question3
     */
    public int chooseQuestion3(boolean tryRadio, boolean triesRadio, boolean triedRadio, boolean is_trying_radio) {
        int count3= 0;
        if (is_trying_radio) {
            count3 = 1;
        } else {
            count3 = 0;
            Toast.makeText(this, "you choose a wrong answer", Toast.LENGTH_SHORT).show();
        }
        return count3;
    }

    /**
     * function evaluation for question 4
     *
     * @param be
     * @param is
     * @param has
     * @param have
     * @return question4 degree
     */
    public int chooseQuestion4(boolean be, boolean is, boolean has, boolean have) {
        int count4 = 0;
        if (is) {
            count4 = 1;
        } else {
            count4 = 0;
            Toast.makeText(this, "you choose a wrong answer", Toast.LENGTH_SHORT).show();
        }
        return count4;
    }

    /**
     * function evaluation for question 5
     *
     * @param answer
     * @return degree of question 5
     */
    public int chooseQuestion5(String answer) {
        int count5 = 0;
        if (answer == "Where Do You Live?") {
            count5 = 1;
        } else {
            count5 = 0;
        }
        return count5;
    }
}
