package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.x */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12922x extends SQLiteOpenHelper {

    /* renamed from: a */
    public static String f36964a = "bugly_db";

    /* renamed from: b */
    public static int f36965b = 16;

    /* renamed from: c */
    protected Context f36966c;

    /* renamed from: d */
    private List<AbstractC12903o> f36967d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12922x(Context context, List<AbstractC12903o> list) {
        super(context, f36964a + "_", (SQLiteDatabase.CursorFactory) null, f36965b);
        C12786aa.m16009a(context).getClass();
        this.f36966c = context;
        this.f36967d = list;
    }

    /* renamed from: a */
    private synchronized boolean m15480a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i = 0; i < 3; i++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(strArr[i])), new String[0]);
            }
        } catch (Throwable th) {
            if (!C12820al.m15875b(th)) {
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
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                C12820al.m15873d("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    C12820al.m15872e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            sQLiteDatabase = super.getWritableDatabase();
        }
        if (sQLiteDatabase == null) {
            C12820al.m15873d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_ui ( _id INTEGER PRIMARY KEY , _tm int , _ut int , _tp int , _dt blob , _pc text ) ");
            C12820al.m15874c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_lr ( _id INTEGER PRIMARY KEY , _tp int , _tm int , _pc text , _th text , _dt blob ) ");
            C12820al.m15874c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_pf ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            C12820al.m15874c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_cr ( _id INTEGER PRIMARY KEY , _tm int , _s1 text , _up int , _me int , _uc int , _dt blob ) ");
            C12820al.m15874c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS dl_1002 (_id integer primary key autoincrement, _dUrl varchar(100), _sFile varchar(100), _sLen INTEGER, _tLen INTEGER, _MD5 varchar(100), _DLTIME INTEGER)");
            C12820al.m15874c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ge_1002 (_id integer primary key autoincrement, _time INTEGER, _datas blob)");
            C12820al.m15874c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS st_1002 ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            C12820al.m15874c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_sla ( _id TEXT NOT NULL , _tm INTEGER NOT NULL , _dt TEXT NOT NULL , PRIMARY KEY(_id) ) ");
            String sb2 = sb.toString();
            C12820al.m15874c(sb2, new Object[0]);
            sQLiteDatabase.execSQL(sb2, new String[0]);
            List<AbstractC12903o> list = this.f36967d;
            if (list == null) {
                return;
            }
            for (AbstractC12903o abstractC12903o : list) {
                abstractC12903o.onDbCreate(sQLiteDatabase);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (C12787ab.m15969c() >= 11) {
            C12820al.m15873d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i), Integer.valueOf(i2));
            List<AbstractC12903o> list = this.f36967d;
            if (list != null) {
                for (AbstractC12903o abstractC12903o : list) {
                    abstractC12903o.onDbDowngrade(sQLiteDatabase, i, i2);
                }
            }
            if (m15480a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            C12820al.m15873d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f36966c.getDatabasePath(f36964a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C12820al.m15873d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i), Integer.valueOf(i2));
        List<AbstractC12903o> list = this.f36967d;
        if (list != null) {
            for (AbstractC12903o abstractC12903o : list) {
                abstractC12903o.onDbUpgrade(sQLiteDatabase, i, i2);
            }
        }
        if (m15480a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
            return;
        }
        C12820al.m15873d("[Database] Failed to drop, delete db.", new Object[0]);
        File databasePath = this.f36966c.getDatabasePath(f36964a);
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }
}
