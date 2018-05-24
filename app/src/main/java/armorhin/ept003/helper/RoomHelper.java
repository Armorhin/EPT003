package armorhin.ept003.helper;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import armorhin.ept003.db.AppDatabase;

/**
 * Created by mrdoc on 24.05.2018.
 */

public class RoomHelper {
    static final String DB_NAME = "database.db";
    static AppDatabase appDatabase;

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
        }
        return appDatabase;
    }

    public static void copyDBFile(Context context) throws IOException {
        InputStream mInput = context.getAssets().open(DB_NAME);
        //InputStream mInput = mContext.getResources().openRawResource(R.raw.info);
        OutputStream mOutput = new FileOutputStream(context.getDatabasePath(DB_NAME));
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public static boolean dbExists(Context context) {
        return context.getDatabasePath(DB_NAME).exists();
    }
}
