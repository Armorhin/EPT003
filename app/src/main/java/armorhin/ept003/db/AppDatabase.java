package armorhin.ept003.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import armorhin.ept003.dao.AnswerDao;
import armorhin.ept003.dao.QuestionDao;
import armorhin.ept003.entity.Answer;
import armorhin.ept003.entity.Question;

/**
 * Created by mrdoc on 24.05.2018.
 */


@Database(entities = {Answer.class, Question.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AnswerDao getAnswerDao();

    public abstract QuestionDao getQuestionDao();
}
