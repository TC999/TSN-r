package com.bytedance.pangle.sdk.component.log.impl.cache.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdEventRepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.HighPriorityAdEventRepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.StatsBatchLogEventRepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.StatsLogEventRepoImpl;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.track.TrackRetryRepertoryImpl;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    protected static final String DB_NAME = "ttadlog.db";
    private static final int DB_VERSION = 1;
    private static final String TAG = "DatabaseHelper";
    final Context thisContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.thisContext = context;
    }

    private void clearDB(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> listDBTables = listDBTables(sQLiteDatabase);
        if (listDBTables == null || listDBTables.size() <= 0) {
            return;
        }
        Iterator<String> it = listDBTables.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private void initDB(SQLiteDatabase sQLiteDatabase) {
        LDebug.d("DatabaseHelper", "initDB........");
        sQLiteDatabase.execSQL(AdEventRepoImpl.getCreateSql());
        sQLiteDatabase.execSQL(HighPriorityAdEventRepoImpl.getHighPriorityCreateSql());
        sQLiteDatabase.execSQL(StatsLogEventRepoImpl.getCreateSql());
        sQLiteDatabase.execSQL(StatsBatchLogEventRepoImpl.getBatchCreateSql());
        sQLiteDatabase.execSQL(TrackRetryRepertoryImpl.getCreateSql());
    }

    private ArrayList<String> listDBTables(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                rawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            initDB(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        try {
            LDebug.d("DatabaseHelper", "onUpgrade....Database version upgrade.....old:" + i4 + ",new:" + i5);
            if (i4 > i5) {
                clearDB(sQLiteDatabase);
                initDB(sQLiteDatabase);
                LDebug.d("DatabaseHelper", "onUpgrade...Reverse installation Database reset - create table.....");
            } else {
                initDB(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }
}
