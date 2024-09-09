package xyz.adscope.ad.tool.persistent.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASNPSqliteOpenHelper extends SQLiteOpenHelper {
    private static final String DATA_BASE_NAME = "asnp_ad.db";
    private static final int DATA_BASE_VERSION = 2;
    private static ASNPSqliteOpenHelper mSQLiteOpenHelper;

    private ASNPSqliteOpenHelper(@Nullable Context context) {
        super(context, DATA_BASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static ASNPSqliteOpenHelper getInstance(Context context) {
        if (context == null) {
            return null;
        }
        if (mSQLiteOpenHelper == null) {
            synchronized (ASNPSqliteOpenHelper.class) {
                if (mSQLiteOpenHelper == null) {
                    mSQLiteOpenHelper = new ASNPSqliteOpenHelper(StubApp.getOrigApplicationContext(context.getApplicationContext()));
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
