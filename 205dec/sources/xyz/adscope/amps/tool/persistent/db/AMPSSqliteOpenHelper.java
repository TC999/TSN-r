package xyz.adscope.amps.tool.persistent.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSSqliteOpenHelper extends SQLiteOpenHelper {
    private static final String DATA_BASE_NAME = "amps_ad.db";
    private static final int DATA_BASE_VERSION = 1;
    private static AMPSSqliteOpenHelper mSQLiteOpenHelper;

    private AMPSSqliteOpenHelper(@Nullable Context context) {
        super(context, DATA_BASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static AMPSSqliteOpenHelper getInstance(Context context) {
        if (mSQLiteOpenHelper == null) {
            synchronized (AMPSSqliteOpenHelper.class) {
                if (mSQLiteOpenHelper == null) {
                    mSQLiteOpenHelper = new AMPSSqliteOpenHelper(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return mSQLiteOpenHelper;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
    }
}
