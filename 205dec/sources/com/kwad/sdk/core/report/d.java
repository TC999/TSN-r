package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class d implements l<e> {
    private static boolean axx;
    protected c axy;

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.axy = cVar;
    }

    private synchronized void c(e eVar) {
        if (axx) {
            String tag = getTag();
            Log.d(tag, "deleteAction action = " + eVar);
        }
        try {
            this.axy.getReadableDatabase().delete(EG(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }

    protected abstract String EG();

    protected abstract String EH();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> EI() {
        try {
            String EH = EH();
            r0 = TextUtils.isEmpty(EH) ? null : this.axy.getReadableDatabase().rawQuery(EH, null);
            if (r0 != null) {
                ArrayList arrayList = new ArrayList();
                while (r0.moveToNext()) {
                    try {
                        arrayList.add(g(r0));
                    } catch (Exception e4) {
                        com.kwad.sdk.core.e.c.printStackTrace(e4);
                    }
                }
                if (axx) {
                    String tag = getTag();
                    Log.d(tag, "read size= " + arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String tag2 = getTag();
                        Log.d(tag2, "read action=" + ((e) it.next()));
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(r0);
                return arrayList;
            }
        } catch (Exception e5) {
            com.kwad.sdk.core.e.c.printStackTrace(e5);
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(r0);
        return new ArrayList();
    }

    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b */
    public final synchronized void j(e eVar) {
        if (axx) {
            String tag = getTag();
            Log.d(tag, "write = " + eVar);
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
            try {
                this.axy.getReadableDatabase().insert(EG(), null, contentValues);
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        } catch (Exception e5) {
            com.kwad.sdk.core.e.c.printStackTrace(e5);
        }
    }

    protected abstract e g(@NonNull Cursor cursor);

    protected abstract String getTag();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j4;
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.axy.getReadableDatabase();
            cursor = readableDatabase.rawQuery("select count(*) from " + EG(), null);
            cursor.moveToFirst();
            j4 = cursor.getLong(0);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            j4 = 0;
        }
        return j4;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void x(List<e> list) {
        if (axx) {
            String tag = getTag();
            Log.d(tag, "delete size= " + list.size());
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.axy.getReadableDatabase();
            sQLiteDatabase.beginTransaction();
            for (e eVar : list) {
                c(eVar);
            }
            sQLiteDatabase.setTransactionSuccessful();
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        } catch (Exception e5) {
            com.kwad.sdk.core.e.c.printStackTrace(e5);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e6) {
                    com.kwad.sdk.core.e.c.printStackTrace(e6);
                }
            }
        }
    }
}
