package com.kwad.sdk.core.videocache.p416d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.videocache.C10582n;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.utils.C11023ap;
import com.umeng.analytics.pro.C13131bm;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* renamed from: com.kwad.sdk.core.videocache.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C10564a extends SQLiteOpenHelper implements InterfaceC10566c {
    private static final String[] aCD = {C13131bm.f37927d, "url", "length", IMediaFormat.KEY_MIME};

    /* JADX INFO: Access modifiers changed from: package-private */
    public C10564a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        C11023ap.checkNotNull(context);
    }

    /* renamed from: i */
    private static C10582n m25462i(Cursor cursor) {
        return new C10582n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(IMediaFormat.KEY_MIME)));
    }

    @Override // com.kwad.sdk.core.videocache.p416d.InterfaceC10566c
    /* renamed from: a */
    public final void mo25461a(String str, C10582n c10582n) {
        C11023ap.m24088f(str, c10582n);
        boolean z = mo25460eJ(str) != null;
        ContentValues m25463a = m25463a(c10582n);
        if (z) {
            getWritableDatabase().update("SourceInfo", m25463a, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, m25463a);
        }
    }

    @Override // com.kwad.sdk.core.videocache.p416d.InterfaceC10566c
    /* renamed from: eJ */
    public final C10582n mo25460eJ(String str) {
        Throwable th;
        Cursor cursor;
        C11023ap.m24086gH(str);
        C10582n c10582n = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", aCD, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        c10582n = m25462i(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C10738b.closeQuietly(cursor);
                    throw th;
                }
            }
            C10738b.closeQuietly(cursor);
            return c10582n;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        C11023ap.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    /* renamed from: a */
    private static ContentValues m25463a(C10582n c10582n) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", c10582n.url);
        contentValues.put("length", Long.valueOf(c10582n.aCx));
        contentValues.put(IMediaFormat.KEY_MIME, c10582n.aCy);
        return contentValues;
    }
}
