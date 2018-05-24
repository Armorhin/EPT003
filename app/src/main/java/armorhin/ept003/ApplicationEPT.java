package armorhin.ept003;

import android.app.Application;

import java.io.IOException;

import static armorhin.ept003.helper.RoomHelper.copyDBFile;
import static armorhin.ept003.helper.RoomHelper.dbExists;

/**
 * Created by mrdoc on 24.05.2018.
 */

public class ApplicationEPT extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (!dbExists(this)) {
            try {
                copyDBFile(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
