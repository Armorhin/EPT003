package armorhin.ept003.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.IOException;

import armorhin.ept003.R;
import armorhin.ept003.helper.DatabaseHelper;


public class VerbActivity extends AppCompatActivity {

    ListView listVerb;
    SimpleCursorAdapter scAdapter;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb);

        mDBHelper = new DatabaseHelper(this);

        // обновление базы данных
        try {
            mDBHelper.updateDataBase();
        } catch (IOException e) {
            throw new RuntimeException("Невозможно загрузить базу данных", e);
        }

        mDb = mDBHelper.getWritableDatabase();


        //виджеты в плашке для отдельного элемента списка
        int[] fields = new int[]{R.id.txtInfinitive, R.id.txtPastSimple, R.id.txtPastParticiple, R.id.txtTranslation};

        // заголовки столбцов результирующей таблицы-выборки из базы данных
        String[] headers = new String[]{"infinitive", "pastsimple", "pastparticiple", "translation"};

        // сделаем выборку данных из базы данных, указав необходимые столбцы и таблицу
        // последний параметр null означает, что мы не делаем фильтрацию, выбирам все строки таблицы БД.
        Cursor c = mDb.rawQuery("SELECT id AS _id, infinitive, pastsimple, pastparticiple, translation FROM verbs", null);

        // на базе курсора создаем адаптер, используя все заготовленные параметры и данные.
        scAdapter = new SimpleCursorAdapter(this, R.layout.verb_list_item, c, headers, fields, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listVerb = (ListView) findViewById(R.id.listVerb);
        listVerb.setAdapter(scAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Закрываем соединение с базой данных
        mDBHelper.close();
    }
}