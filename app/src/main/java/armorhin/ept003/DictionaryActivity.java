package armorhin.ept003;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.IOException;

public class DictionaryActivity extends AppCompatActivity {

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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Закрываем соединение с базой данных
        mDBHelper.close();
    }
}
