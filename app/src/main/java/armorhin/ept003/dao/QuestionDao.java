package armorhin.ept003.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import armorhin.ept003.entity.Answer;
import armorhin.ept003.entity.Question;

/**
 * Created by mrdoc on 24.05.2018.
 */

@Dao
public interface QuestionDao {

    @Insert
    void insert(Question question);

    @Update
    void update(Question question);

    @Delete
    void delete(Question question);

    @Query("SELECT * FROM answer WHERE question_id=:questionId")
    LiveData<List<Answer>> getAnswersForQuestion(final int questionId);

    @Query("SELECT * FROM question")
    LiveData<List<Question>> getAllQuestion();

    @Query("SELECT * FROM question WHERE module=:module")
    LiveData<List<Question>> getQuestionsByModule(final int module);

}
