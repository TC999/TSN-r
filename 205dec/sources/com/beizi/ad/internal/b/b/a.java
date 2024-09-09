package com.beizi.ad.internal.b.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.beizi.ad.internal.b.k;
import com.beizi.ad.internal.b.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DatabaseSourceInfoStorage.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class a extends SQLiteOpenHelper implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f13684a = {"_id", "url", "length", "mime"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        k.a(context);
    }

    @Override // com.beizi.ad.internal.b.b.c
    public p a(String str) {
        Throwable th;
        Cursor cursor;
        k.a(str);
        p pVar = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", f13684a, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        pVar = a(cursor);
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
            return pVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        k.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.beizi.ad.internal.b.b.c
    public void a(String str, p pVar) {
        k.a(str, pVar);
        boolean z3 = a(str) != null;
        ContentValues a4 = a(pVar);
        if (z3) {
            getWritableDatabase().update("SourceInfo", a4, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a4);
        }
    }

    private p a(Cursor cursor) {
        return new p(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getInt(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    private ContentValues a(p pVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", pVar.f13738a);
        contentValues.put("length", Integer.valueOf(pVar.f13739b));
        contentValues.put("mime", pVar.f13740c);
        return contentValues;
    }
}
