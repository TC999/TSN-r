package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.msdk.adapter.util.Logger;

/* compiled from: DatabaseHelper.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class j extends SQLiteOpenHelper {
    public j(Context context, String str, int i4) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i4);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        Logger.d("DBHelper", "initDB........");
        sQLiteDatabase.execSQL(b.c());
        sQLiteDatabase.execSQL(b.b());
        sQLiteDatabase.execSQL(f.a());
        sQLiteDatabase.execSQL(d.a());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            a(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        try {
            Logger.d("DBHelper", "onUpgrade....\u6570\u636e\u5e93\u7248\u672c\u5347\u7ea7.....");
            if (i4 == 1) {
                Logger.d("DBHelper", "onUpgrade.....\u6267\u884c\u8868\u521b\u5efa.....");
            } else if (i4 == 2) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
            }
            if (i5 != 2) {
                return;
            }
            Logger.d("DBHelper", "onUpgrade.....\u6267\u884c\u8868pacing & freqctl\u521b\u5efa.....");
            sQLiteDatabase.execSQL(f.a());
            sQLiteDatabase.execSQL(d.a());
        } catch (Throwable unused) {
        }
    }
}
