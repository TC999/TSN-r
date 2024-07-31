package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.msdk.adapter.util.Logger;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    /* renamed from: a */
    private void m59392a(SQLiteDatabase sQLiteDatabase) {
        Logger.m37562d("DBHelper", "initDB........");
        sQLiteDatabase.execSQL(AdEventRepertoryImpl.m59421c());
        sQLiteDatabase.execSQL(AdEventRepertoryImpl.m59425b());
        sQLiteDatabase.execSQL(AdIntervalPacingRepertoryImpl.m59410a());
        sQLiteDatabase.execSQL(AdIntervalFreqctlRepertoryImpl.m59419a());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            m59392a(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            Logger.m37562d("DBHelper", "onUpgrade....数据库版本升级.....");
            if (i == 1) {
                Logger.m37562d("DBHelper", "onUpgrade.....执行表创建.....");
            } else if (i == 2) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
            }
            if (i2 != 2) {
                return;
            }
            Logger.m37562d("DBHelper", "onUpgrade.....执行表pacing & freqctl创建.....");
            sQLiteDatabase.execSQL(AdIntervalPacingRepertoryImpl.m59410a());
            sQLiteDatabase.execSQL(AdIntervalFreqctlRepertoryImpl.m59419a());
        } catch (Throwable unused) {
        }
    }
}
