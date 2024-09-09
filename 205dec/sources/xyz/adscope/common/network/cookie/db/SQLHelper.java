package xyz.adscope.common.network.cookie.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
final class SQLHelper extends SQLiteOpenHelper implements Field {
    public SQLHelper(Context context) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()), "_kalle_cookies_db.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("CREATE TABLE COOKIES_TABLE(_ID INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT, NAME TEXT, VALUE TEXT, COMMENT TEXT, COMMENT_URL TEXT, DISCARD TEXT, DOMAIN TEXT, EXPIRY INTEGER, PATH TEXT, PORT_LIST TEXT, SECURE TEXT, VERSION INTEGER)");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX COOKIE_UNIQUE_INDEX ON COOKIES_TABLE(\"NAME\", \"DOMAIN\", \"PATH\")");
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        if (i5 != i4) {
            sQLiteDatabase.beginTransaction();
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS COOKIES_TABLE");
                sQLiteDatabase.execSQL("CREATE TABLE COOKIES_TABLE(_ID INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT, NAME TEXT, VALUE TEXT, COMMENT TEXT, COMMENT_URL TEXT, DISCARD TEXT, DOMAIN TEXT, EXPIRY INTEGER, PATH TEXT, PORT_LIST TEXT, SECURE TEXT, VERSION INTEGER)");
                sQLiteDatabase.execSQL("CREATE UNIQUE INDEX COOKIE_UNIQUE_INDEX ON COOKIES_TABLE(\"NAME\", \"DOMAIN\", \"PATH\")");
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }
}
