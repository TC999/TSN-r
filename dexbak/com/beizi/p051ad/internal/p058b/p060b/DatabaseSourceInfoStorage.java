package com.beizi.p051ad.internal.p058b.p060b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.beizi.p051ad.internal.p058b.Preconditions;
import com.beizi.p051ad.internal.p058b.SourceInfo;
import com.umeng.analytics.pro.C13131bm;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* renamed from: com.beizi.ad.internal.b.b.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class DatabaseSourceInfoStorage extends SQLiteOpenHelper implements SourceInfoStorage {

    /* renamed from: a */
    private static final String[] f10007a = {C13131bm.f37927d, "url", "length", IMediaFormat.KEY_MIME};

    /* JADX INFO: Access modifiers changed from: package-private */
    public DatabaseSourceInfoStorage(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        Preconditions.m49572a(context);
    }

    @Override // com.beizi.p051ad.internal.p058b.p060b.SourceInfoStorage
    /* renamed from: a */
    public SourceInfo mo49625a(String str) {
        Throwable th;
        Cursor cursor;
        Preconditions.m49572a(str);
        SourceInfo sourceInfo = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", f10007a, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        sourceInfo = m49627a(cursor);
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
            return sourceInfo;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Preconditions.m49572a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.beizi.p051ad.internal.p058b.p060b.SourceInfoStorage
    /* renamed from: a */
    public void mo49624a(String str, SourceInfo sourceInfo) {
        Preconditions.m49568a(str, sourceInfo);
        boolean z = mo49625a(str) != null;
        ContentValues m49626a = m49626a(sourceInfo);
        if (z) {
            getWritableDatabase().update("SourceInfo", m49626a, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, m49626a);
        }
    }

    /* renamed from: a */
    private SourceInfo m49627a(Cursor cursor) {
        return new SourceInfo(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getInt(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(IMediaFormat.KEY_MIME)));
    }

    /* renamed from: a */
    private ContentValues m49626a(SourceInfo sourceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sourceInfo.f10061a);
        contentValues.put("length", Integer.valueOf(sourceInfo.f10062b));
        contentValues.put(IMediaFormat.KEY_MIME, sourceInfo.f10063c);
        return contentValues;
    }
}
