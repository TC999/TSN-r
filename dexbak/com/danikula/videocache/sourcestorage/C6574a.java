package com.danikula.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.C6567n;
import com.danikula.videocache.C6573s;

/* compiled from: DatabaseSourceInfoStorage.java */
/* renamed from: com.danikula.videocache.sourcestorage.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
class C6574a extends SQLiteOpenHelper implements InterfaceC6576c {

    /* renamed from: a */
    private static final String f23151a = "SourceInfo";

    /* renamed from: b */
    private static final String f23152b = "_id";

    /* renamed from: c */
    private static final String f23153c = "url";

    /* renamed from: e */
    private static final String f23155e = "mime";

    /* renamed from: g */
    private static final String f23157g = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";

    /* renamed from: d */
    private static final String f23154d = "length";

    /* renamed from: f */
    private static final String[] f23156f = {"_id", "url", f23154d, "mime"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6574a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        C6567n.m35858d(context);
    }

    /* renamed from: b */
    private ContentValues m35832b(C6573s c6573s) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", c6573s.f23148a);
        contentValues.put(f23154d, Long.valueOf(c6573s.f23149b));
        contentValues.put("mime", c6573s.f23150c);
        return contentValues;
    }

    /* renamed from: c */
    private C6573s m35831c(Cursor cursor) {
        return new C6573s(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(f23154d)), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.danikula.videocache.sourcestorage.InterfaceC6576c
    /* renamed from: a */
    public void mo35830a(String str, C6573s c6573s) {
        C6567n.m35861a(str, c6573s);
        boolean z = get(str) != null;
        ContentValues m35832b = m35832b(c6573s);
        if (z) {
            getWritableDatabase().update(f23151a, m35832b, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(f23151a, null, m35832b);
        }
    }

    @Override // com.danikula.videocache.sourcestorage.InterfaceC6576c
    public C6573s get(String str) {
        Throwable th;
        Cursor cursor;
        C6567n.m35858d(str);
        C6573s c6573s = null;
        try {
            cursor = getReadableDatabase().query(f23151a, f23156f, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        c6573s = m35831c(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return c6573s;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C6567n.m35858d(sQLiteDatabase);
        sQLiteDatabase.execSQL(f23157g);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.danikula.videocache.sourcestorage.InterfaceC6576c
    public void release() {
        close();
    }
}
