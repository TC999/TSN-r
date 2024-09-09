package com.kwad.sdk.core.videocache.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.videocache.n;
import com.kwad.sdk.utils.ap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class a extends SQLiteOpenHelper implements c {
    private static final String[] aCD = {"_id", "url", "length", "mime"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        ap.checkNotNull(context);
    }

    private static n i(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        ap.f(str, nVar);
        boolean z3 = eJ(str) != null;
        ContentValues a4 = a(nVar);
        if (z3) {
            getWritableDatabase().update("SourceInfo", a4, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a4);
        }
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eJ(String str) {
        Throwable th;
        Cursor cursor;
        ap.gH(str);
        n nVar = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", aCD, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        nVar = i(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return nVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ap.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    private static ContentValues a(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.url);
        contentValues.put("length", Long.valueOf(nVar.aCx));
        contentValues.put("mime", nVar.aCy);
        return contentValues;
    }
}
