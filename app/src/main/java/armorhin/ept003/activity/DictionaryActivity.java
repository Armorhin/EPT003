package armorhin.ept003.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;

import java.io.IOException;

import armorhin.ept003.R;
import armorhin.ept003.helper.DatabaseHelper;

public class DictionaryActivity extends AppCompatActivity {

    SearchView search;
    ListView listDictionary;
    SimpleCursorAdapter scAdapter;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        mDBHelper = new DatabaseHelper(this);

        // обновление базы данных
        try {
            mDBHelper.updateDataBase();
        } catch (IOException e) {
            throw new RuntimeException("Невозможно загрузить базу данных", e);
        }

        mDb = mDBHelper.getWritableDatabase();


        //виджеты в плашке для отдельного элемента списка
        int[] fields = new int[]{R.id.txtWord, R.id.txtTrans};

        // заголовки столбцов результирующей таблицы-выборки из базы данных
        String[] headers = new String[]{"word", "translation"};

        // сделаем выборку данных из базы данных, указав необходимые столбцы и таблицу
        // последний параметр null означает, что мы не делаем фильтрацию, выбирам все строки таблицы БД.
        Cursor c = mDb.rawQuery("SELECT id AS _id, word, translation FROM  words", null);

        // на базе курсора создаем адаптер, используя все заготовленные параметры и данные.
        scAdapter = new SimpleCursorAdapter(this, R.layout.dictionary_list_item, c, headers, fields, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        listDictionary = (ListView) findViewById(R.id.listDictionary);
        listDictionary.setAdapter(scAdapter);

        SearchView searchTxt = findViewById(R.id.searchDictionary);
        searchTxt.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return filter(query);
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return filter(newText);
            }

            boolean filter(String text){


                //виджеты в плашке для отдельного элемента списка
                int[] fields = new int[]{R.id.txtWord, R.id.txtTrans};

                // заголовки столбцов результирующей таблицы-выборки из базы данных
                String[] headers = new String[]{"word", "translation"};

                // сделаем выборку данных из базы данных, указав необходимые столбцы и таблицу
                // последний параметр null означает, что мы не делаем фильтрацию, выбирам все строки таблицы БД.
                Cursor c = mDb.rawQuery("SELECT id AS _id, word, translation FROM words WHERE (word LIKE ?) OR (translation LIKE ?)", new String[]{text+"%" , text+"%" });

                int count = c.getCount();
                // на базе курсора создаем адаптер, используя все заготовленные параметры и данные.
                scAdapter = new SimpleCursorAdapter(DictionaryActivity.this, R.layout.dictionary_list_item, c, headers, fields, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
                listDictionary.setAdapter(scAdapter);


                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Закрываем соединение с базой данных
        mDBHelper.close();
    }



}
