package armorhin.ept003.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mrdoc on 24.05.2018.
 */

@Entity(tableName = "question")
public class Question {

    @PrimaryKey
    private int id;

    @ColumnInfo
    private String text;

    @ColumnInfo
    private int module;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }
}
