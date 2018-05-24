package armorhin.ept003.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by mrdoc on 24.05.2018.
 */

@Entity(tableName = "answer",
        foreignKeys = @ForeignKey(entity = Question.class,
                parentColumns = "id", childColumns = "question_id", onDelete = CASCADE))
public class Answer {

    @PrimaryKey
    private int id;

    @ColumnInfo
    private String text;

    @ColumnInfo
    private boolean right;

    @ColumnInfo(name = "question_id")
    private int questionId;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
