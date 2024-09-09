package com.danikula.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.n;
import com.danikula.videocache.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: DatabaseSourceInfoStorage.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
class a extends SQLiteOpenHelper implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36818a = "SourceInfo";

    /* renamed from: b  reason: collision with root package name */
    private static final String f36819b = "_id";

    /* renamed from: c  reason: collision with root package name */
    private static final String f36820c = "url";

    /* renamed from: d  reason: collision with root package name */
    private static final String f36821d = "length";

    /* renamed from: e  reason: collision with root package name */
    private static final String f36822e = "mime";

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f36823f = {"_id", "url", "length", "mime"};

    /* renamed from: g  reason: collision with root package name */
    private static final String f36824g = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        n.d(context);
    }

    private ContentValues b(s sVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sVar.f36815a);
        contentValues.put("length", Long.valueOf(sVar.f36816b));
        contentValues.put("mime", sVar.f36817c);
        return contentValues;
    }

    private s c(Cursor cursor) {
        return new s(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.danikula.videocache.sourcestorage.c
    public void a(String str, s sVar) {
        n.a(str, sVar);
        boolean z3 = get(str) != null;
        ContentValues b4 = b(sVar);
        if (z3) {
            getWritableDatabase().update("SourceInfo", b4, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, b4);
        }
    }

    @Override // com.danikula.videocache.sourcestorage.c
    public s get(String str) {
        Throwable th;
        Cursor cursor;
        n.d(str);
        s sVar = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", f36823f, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        sVar = c(cursor);
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
            return sVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        n.d(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.danikula.videocache.sourcestorage.c
    public void release() {
        close();
    }
}
