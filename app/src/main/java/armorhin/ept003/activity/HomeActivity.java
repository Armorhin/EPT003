package armorhin.ept003.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import armorhin.ept003.R;

/**
 * Created by mrdoc on 08.05.2018.
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.theoryBtn:
                Intent iTheory = new Intent(HomeActivity.this, TheoryThemeActivity.class);
                startActivity(iTheory);

                break;
            case R.id.practiceBtn:
                Intent iPractice = new Intent(HomeActivity.this, PracticeActivity.class);
                startActivity(iPractice);

                break;
            case R.id.dictionaryBtn:
                Intent iDictionary = new Intent(HomeActivity.this, DictionaryActivity.class);
                startActivity(iDictionary);

                break;
            case R.id.verbBtn:
                Intent iVerb = new Intent(HomeActivity.this, VerbActivity.class);
                startActivity(iVerb);

                break;
        }
    }
}

//todo theory
//todo ekran tem
//todo ekran s teoriei
//todo zadaniya
//todo tasks

//todo SQL words
//todo SQL task
//todo SQL theory