package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class x extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f51330a = "bugly_db";

    /* renamed from: b  reason: collision with root package name */
    public static int f51331b = 16;

    /* renamed from: c  reason: collision with root package name */
    protected Context f51332c;

    /* renamed from: d  reason: collision with root package name */
    private List<o> f51333d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Context context, List<o> list) {
        super(context, f51330a + "_", (SQLiteDatabase.CursorFactory) null, f51331b);
        aa.a(context).getClass();
        this.f51332c = context;
        this.f51333d = list;
    }

    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i4 = 0; i4 < 3; i4++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(strArr[i4])), new String[0]);
            }
        } catch (Throwable th) {
            if (!al.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i4 = 0;
        while (sQLiteDatabase == null && i4 < 5) {
            i4++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                al.d("[Database] Try to get db(count: %d).", Integer.valueOf(i4));
                if (i4 == 5) {
                    al.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i4 = 0;
        while (sQLiteDatabase == null && i4 < 5) {
            i4++;
            sQLiteDatabase = super.getWritableDatabase();
        }
        if (sQLiteDatabase == null) {
            al.d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_ui ( _id INTEGER PRIMARY KEY , _tm int , _ut int , _tp int , _dt blob , _pc text ) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_lr ( _id INTEGER PRIMARY KEY , _tp int , _tm int , _pc text , _th text , _dt blob ) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_pf ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_cr ( _id INTEGER PRIMARY KEY , _tm int , _s1 text , _up int , _me int , _uc int , _dt blob ) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS dl_1002 (_id integer primary key autoincrement, _dUrl varchar(100), _sFile varchar(100), _sLen INTEGER, _tLen INTEGER, _MD5 varchar(100), _DLTIME INTEGER)");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ge_1002 (_id integer primary key autoincrement, _time INTEGER, _datas blob)");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS st_1002 ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_sla ( _id TEXT NOT NULL , _tm INTEGER NOT NULL , _dt TEXT NOT NULL , PRIMARY KEY(_id) ) ");
            String sb2 = sb.toString();
            al.c(sb2, new Object[0]);
            sQLiteDatabase.execSQL(sb2, new String[0]);
            List<o> list = this.f51333d;
            if (list == null) {
                return;
            }
            for (o oVar : list) {
                oVar.onDbCreate(sQLiteDatabase);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        if (ab.c() >= 11) {
            al.d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i4), Integer.valueOf(i5));
            List<o> list = this.f51333d;
            if (list != null) {
                for (o oVar : list) {
                    oVar.onDbDowngrade(sQLiteDatabase, i4, i5);
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            al.d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f51332c.getDatabasePath(f51330a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        al.d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i4), Integer.valueOf(i5));
        List<o> list = this.f51333d;
        if (list != null) {
            for (o oVar : list) {
                oVar.onDbUpgrade(sQLiteDatabase, i4, i5);
            }
        }
        if (a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
            return;
        }
        al.d("[Database] Failed to drop, delete db.", new Object[0]);
        File databasePath = this.f51332c.getDatabasePath(f51330a);
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }
}
