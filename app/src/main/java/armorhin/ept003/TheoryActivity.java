package armorhin.ept003;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TheoryActivity extends AppCompatActivity {

    public int theory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                theory = 1;
                Intent iTheory1 = new Intent(TheoryActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory1);

                break;
            case R.id.button2:
                theory = 2;
                Intent iTheory2 = new Intent(TheoryActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory2);

                break;
            case R.id.button3:
                theory = 3;
                Intent iTheory3 = new Intent(TheoryActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory3);

                break;
            case R.id.button4:
                theory = 4;
                Intent iTheory4 = new Intent(TheoryActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory4);

                break;

            case R.id.button5:
                theory = 5;
                Intent iTheory5 = new Intent(TheoryActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory5);

                break;

            case R.id.button6:
                theory = 6;
                Intent iTheory6 = new Intent(TheoryActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory6);

                break;

            case R.id.button7:
                theory = 7;
                Intent iTheory7 = new Intent(TheoryActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory7);

                break;

            case R.id.button8:
                theory = 8;
                Intent iTheory8 = new Intent(TheoryActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory8);

                break;

            case R.id.button9:
                theory = 9;
                Intent iTheory9 = new Intent(TheoryActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory9);

                break;
            }
        }
    }
