package armorhin.ept003;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class VerbActivity extends AppCompatActivity {

        ListView listVerb;
        SimpleCursorAdapter scAdapter;
        Cursor c;


         @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_verb);

            listVerb = (ListView) findViewById(R.id.listVerb);


        }
    }