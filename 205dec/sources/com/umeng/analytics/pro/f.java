package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMDBCreater.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private static Context f52962b;

    /* renamed from: a  reason: collision with root package name */
    private String f52963a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMDBCreater.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final f f52964a = new f(f.f52962b, h.b(f.f52962b), e.f52896b, null, 2);

        private a() {
        }
    }

    public static f a(Context context) {
        if (f52962b == null) {
            f52962b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f52964a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f52963a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f52963a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!h.a(sQLiteDatabase, "__sd", "__av")) {
            h.a(sQLiteDatabase, "__sd", "__sp", "TEXT");
            h.a(sQLiteDatabase, "__sd", "__pp", "TEXT");
            h.a(sQLiteDatabase, "__sd", "__av", "TEXT");
            h.a(sQLiteDatabase, "__sd", "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, "__et", "__av")) {
            h.a(sQLiteDatabase, "__et", "__av", "TEXT");
            h.a(sQLiteDatabase, "__et", "__vc", "TEXT");
        }
        if (h.a(sQLiteDatabase, "__er", "__av")) {
            return;
        }
        h.a(sQLiteDatabase, "__er", "__av", "TEXT");
        h.a(sQLiteDatabase, "__er", "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "__sd");
        a(sQLiteDatabase, "__et");
        a(sQLiteDatabase, "__er");
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f52962b);
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
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        if (i5 <= i4 || i4 != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                e(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            f(sQLiteDatabase);
        }
    }

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i4) {
        this(new c(context, str), str2, cursorFactory, i4);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f52963a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i4) {
        super(context, TextUtils.isEmpty(str) ? e.f52896b : str, cursorFactory, i4);
        this.f52963a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a("__sd", writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a("__is", writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a("__et", writableDatabase)) {
                b(writableDatabase);
            }
            if (h.a("__er", writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f52963a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
