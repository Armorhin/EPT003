package armorhin.ept003.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import armorhin.ept003.R;

public class TheoryThemeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_theme);
    }

    public void onClick(View view) {
        Intent intent = new Intent(TheoryThemeActivity.this, TheoryActivity.class);
        switch (view.getId()) {
            case R.id.button1:
                intent.putExtra("id", 1);
                break;
            case R.id.button2:
                intent.putExtra("id", 2);
                break;
            case R.id.button3:
                intent.putExtra("id", 3);
                break;
            case R.id.button4:
                intent.putExtra("id", 4);
                break;

            case R.id.button5:
                intent.putExtra("id", 5);
                break;

            case R.id.button6:
                intent.putExtra("id", 6);
                break;

            case R.id.button7:
                intent.putExtra("id", 7);
                break;

            case R.id.button8:
                intent.putExtra("id", 8);
                break;

            case R.id.button9:
                intent.putExtra("id", 9);
                break;
        }
        startActivity(intent);
    }
}
