//Written by: Joseph Melia
//Due Date: 9/16/2019
//Class: BCS 421
//HW assignment #2

package com.example.bcs421_hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView gpaText; //View to display GPA after calculated
    EditText class1, class2, class3, class4, class5; //user input
    Button myBtn;
    ConstraintLayout backGrnd;//to change background color

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gpaText = findViewById(R.id.textView7);
        class1 = findViewById(R.id.editText7);
        class2 = findViewById(R.id.editText4);
        class3 = findViewById(R.id.editText5);
        class4 = findViewById(R.id.editText6);
        class5 = findViewById(R.id.editText);
        myBtn = findViewById(R.id.button);
        backGrnd = findViewById(R.id.container);

        //text listeners for each editText view, changes button back to Compute GPA if text input
        class1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myBtn.setText(getString(R.string.findGPA));
                backGrnd.setBackgroundColor(Color.WHITE);
                /*if (Integer.parseInt(class1.getText().toString()) > 100) {
                    class1.setBackgroundColor(Color.RED);
                }else {
                    class1.setBackgroundColor(Color.TRANSPARENT);
                }*/

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        class2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myBtn.setText(getString(R.string.findGPA));
                backGrnd.setBackgroundColor(Color.WHITE);
                /*if (Integer.parseInt(class2.getText().toString()) > 100) {
                    class2.setBackgroundColor(Color.RED);
                }else {
                    class2.setBackgroundColor(Color.TRANSPARENT);
                }*/

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        class3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myBtn.setText(getString(R.string.findGPA));
                backGrnd.setBackgroundColor(Color.WHITE);
                /*if (Integer.parseInt(class3.getText().toString()) > 100) {
                    class3.setBackgroundColor(Color.RED);
                }else {
                    class3.setBackgroundColor(Color.TRANSPARENT);
                }*/

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        class4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myBtn.setText(getString(R.string.findGPA));
                backGrnd.setBackgroundColor(Color.WHITE);
                /*if (Integer.parseInt(class4.getText().toString()) > 100) {
                    class4.setBackgroundColor(Color.RED);
                }else {
                    class4.setBackgroundColor(Color.TRANSPARENT);
                }*/

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        class5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myBtn.setText(getString(R.string.findGPA));
                backGrnd.setBackgroundColor(Color.WHITE);
               /* if (Integer.parseInt(class5.getText().toString()) > 100) {
                    class5.setBackgroundColor(Color.RED);
                } else {
                    class5.setBackgroundColor(Color.TRANSPARENT);
                }*/

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void calcGpa(View view) {
        String btn = myBtn.getText().toString();//red what button text is for clear or calculate

        if (btn.matches("Compute GPA")) {
            String c1 = class1.getText().toString();
            String c2 = class2.getText().toString();
            String c3 = class3.getText().toString();
            String c4 = class4.getText().toString();
            String c5 = class5.getText().toString();

            if (c1.matches("") || c2.matches("") || c3.matches("") || c4.matches("") || c5.matches("")) {
                Toast.makeText(this, "You did not enter all of your grades", Toast.LENGTH_SHORT).show();//not accept empty fields

            } else if (Integer.parseInt(c1) > 100 || Integer.parseInt(c2) > 100 || Integer.parseInt(c3) > 100 || Integer.parseInt(c4) > 100 || Integer.parseInt(c5) > 100) {
                Toast.makeText(this, "Your grades cannot be higher than 100", Toast.LENGTH_SHORT).show();//not accept invalid input above 100
            } else {

                float gpa = (Float.parseFloat(c1) + Float.parseFloat(c2) + Float.parseFloat(c3) + Float.parseFloat(c4) + Float.parseFloat(c5)) / 5;

                gpaText.setText(String.format("%s%s", getString(R.string.gpaIs), gpa));

                if (gpa >= 80) {
                    backGrnd.setBackgroundColor(Color.GREEN);
                } else if (gpa < 80 && gpa > 60) {
                    backGrnd.setBackgroundColor(Color.YELLOW);
                } else {
                    backGrnd.setBackgroundColor(Color.RED);
                }

                myBtn.setText(getString(R.string.clr));

            }
        } else if (btn.matches("Clear")) { //clear editTextFields
            class1.setText("");
            class2.setText("");
            class3.setText("");
            class4.setText("");
            class5.setText("");
            backGrnd.setBackgroundColor(Color.WHITE);
        }
    }
}

