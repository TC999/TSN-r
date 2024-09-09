package xyz.adscope.common.db.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DatabaseHelper extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static DatabaseHelper f64589a;

    public DatabaseHelper(@Nullable Context context) {
        super(context, "common_base.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (f64589a == null) {
            synchronized (DatabaseHelper.class) {
                if (f64589a == null) {
                    f64589a = new DatabaseHelper(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return f64589a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
    }
}
