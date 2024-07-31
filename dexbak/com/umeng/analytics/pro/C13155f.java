package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.UMDBConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UMDBCreater.java */
/* renamed from: com.umeng.analytics.pro.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13155f extends SQLiteOpenHelper {

    /* renamed from: b */
    private static Context f38241b;

    /* renamed from: a */
    private String f38242a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMDBCreater.java */
    /* renamed from: com.umeng.analytics.pro.f$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13157a {

        /* renamed from: a */
        private static final C13155f f38243a = new C13155f(C13155f.f38241b, UMDBUtils.m14349b(C13155f.f38241b), UMDBConfig.f38175b, null, 2);

        private C13157a() {
        }
    }

    /* renamed from: a */
    public static C13155f m14369a(Context context) {
        if (f38241b == null) {
            f38241b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C13157a.f38243a;
    }

    /* renamed from: c */
    private void m14364c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f38242a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: d */
    private void m14363d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f38242a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: e */
    private void m14362e(SQLiteDatabase sQLiteDatabase) {
        if (!UMDBUtils.m14354a(sQLiteDatabase, UMDBConfig.C13152d.f38216a, "__av")) {
            UMDBUtils.m14353a(sQLiteDatabase, UMDBConfig.C13152d.f38216a, "__sp", "TEXT");
            UMDBUtils.m14353a(sQLiteDatabase, UMDBConfig.C13152d.f38216a, "__pp", "TEXT");
            UMDBUtils.m14353a(sQLiteDatabase, UMDBConfig.C13152d.f38216a, "__av", "TEXT");
            UMDBUtils.m14353a(sQLiteDatabase, UMDBConfig.C13152d.f38216a, "__vc", "TEXT");
        }
        if (!UMDBUtils.m14354a(sQLiteDatabase, UMDBConfig.C13146b.f38190a, "__av")) {
            UMDBUtils.m14353a(sQLiteDatabase, UMDBConfig.C13146b.f38190a, "__av", "TEXT");
            UMDBUtils.m14353a(sQLiteDatabase, UMDBConfig.C13146b.f38190a, "__vc", "TEXT");
        }
        if (UMDBUtils.m14354a(sQLiteDatabase, UMDBConfig.C13143a.f38179a, "__av")) {
            return;
        }
        UMDBUtils.m14353a(sQLiteDatabase, UMDBConfig.C13143a.f38179a, "__av", "TEXT");
        UMDBUtils.m14353a(sQLiteDatabase, UMDBConfig.C13143a.f38179a, "__vc", "TEXT");
    }

    /* renamed from: f */
    private void m14361f(SQLiteDatabase sQLiteDatabase) {
        m14367a(sQLiteDatabase, UMDBConfig.C13152d.f38216a);
        m14367a(sQLiteDatabase, UMDBConfig.C13146b.f38190a);
        m14367a(sQLiteDatabase, UMDBConfig.C13143a.f38179a);
        m14370a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                m14364c(sQLiteDatabase);
                m14363d(sQLiteDatabase);
                m14365b(sQLiteDatabase);
                m14368a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                UMDBUtils.m14355a(f38241b);
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i || i != 1) {
            return;
        }
        try {
            try {
                m14362e(sQLiteDatabase);
            } catch (Exception unused) {
                m14362e(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            m14361f(sQLiteDatabase);
        }
    }

    private C13155f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new UMDBCreater(context, str), str2, cursorFactory, i);
    }

    /* renamed from: b */
    private void m14365b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f38242a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private C13155f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? UMDBConfig.f38175b : str, cursorFactory, i);
        this.f38242a = null;
        m14370a();
    }

    /* renamed from: a */
    public void m14370a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!UMDBUtils.m14351a(UMDBConfig.C13152d.f38216a, writableDatabase)) {
                m14364c(writableDatabase);
            }
            if (!UMDBUtils.m14351a(UMDBConfig.C13149c.f38203a, writableDatabase)) {
                m14363d(writableDatabase);
            }
            if (!UMDBUtils.m14351a(UMDBConfig.C13146b.f38190a, writableDatabase)) {
                m14365b(writableDatabase);
            }
            if (UMDBUtils.m14351a(UMDBConfig.C13143a.f38179a, writableDatabase)) {
                return;
            }
            m14368a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m14368a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f38242a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: a */
    private void m14367a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
