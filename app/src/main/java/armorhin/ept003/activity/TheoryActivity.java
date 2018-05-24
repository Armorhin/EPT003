package armorhin.ept003.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import armorhin.ept003.R;

public class TheoryActivity extends AppCompatActivity {

    WebView webTheory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        webTheory = findViewById(R.id.webTheory);

        int theory = getIntent().getIntExtra("id",-1);
        initView(theory);
    }

    private void initView(int theory) {
        webTheory.loadUrl("file:///android_asset/theory/" + theory + ".html");
    }
}
