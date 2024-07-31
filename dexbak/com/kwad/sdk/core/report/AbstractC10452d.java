package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.sdk.core.report.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10452d implements InterfaceC10462l<AbstractC10453e> {
    private static boolean axx;
    protected C10451c axy;

    public AbstractC10452d(C10451c c10451c) {
        m26039a(c10451c);
    }

    /* renamed from: a */
    private void m26039a(C10451c c10451c) {
        this.axy = c10451c;
    }

    /* renamed from: c */
    private synchronized void m26037c(AbstractC10453e abstractC10453e) {
        if (axx) {
            String tag = getTag();
            Log.d(tag, "deleteAction action = " + abstractC10453e);
        }
        try {
            this.axy.getReadableDatabase().delete(mo25065EG(), "actionId=?", new String[]{abstractC10453e.actionId});
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    /* renamed from: EG */
    protected abstract String mo25065EG();

    /* renamed from: EH */
    protected abstract String mo25064EH();

    @Override // com.kwad.sdk.core.report.InterfaceC10462l
    /* renamed from: EI */
    public final synchronized List<AbstractC10453e> mo26020EI() {
        try {
            String mo25064EH = mo25064EH();
            r0 = TextUtils.isEmpty(mo25064EH) ? null : this.axy.getReadableDatabase().rawQuery(mo25064EH, null);
            if (r0 != null) {
                ArrayList arrayList = new ArrayList();
                while (r0.moveToNext()) {
                    try {
                        arrayList.add(mo25062g(r0));
                    } catch (Exception e) {
                        C10331c.printStackTrace(e);
                    }
                }
                if (axx) {
                    String tag = getTag();
                    Log.d(tag, "read size= " + arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String tag2 = getTag();
                        Log.d(tag2, "read action=" + ((AbstractC10453e) it.next()));
                    }
                }
                C10738b.closeQuietly(r0);
                return arrayList;
            }
        } catch (Exception e2) {
            C10331c.printStackTrace(e2);
        }
        C10738b.closeQuietly(r0);
        return new ArrayList();
    }

    @Override // com.kwad.sdk.core.report.InterfaceC10462l
    /* renamed from: b */
    public final synchronized void mo26018j(AbstractC10453e abstractC10453e) {
        if (axx) {
            String tag = getTag();
            Log.d(tag, "write = " + abstractC10453e);
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", abstractC10453e.actionId);
            contentValues.put("aLog", abstractC10453e.toJson().toString());
            try {
                this.axy.getReadableDatabase().insert(mo25065EG(), null, contentValues);
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        } catch (Exception e2) {
            C10331c.printStackTrace(e2);
        }
    }

    /* renamed from: g */
    protected abstract AbstractC10453e mo25062g(@NonNull Cursor cursor);

    protected abstract String getTag();

    @Override // com.kwad.sdk.core.report.InterfaceC10462l
    public final synchronized long size() {
        long j;
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.axy.getReadableDatabase();
            cursor = readableDatabase.rawQuery("select count(*) from " + mo25065EG(), null);
            cursor.moveToFirst();
            j = cursor.getLong(0);
            C10738b.closeQuietly(cursor);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            C10738b.closeQuietly(cursor);
            j = 0;
        }
        return j;
    }

    @Override // com.kwad.sdk.core.report.InterfaceC10462l
    /* renamed from: x */
    public final synchronized void mo26017x(List<AbstractC10453e> list) {
        if (axx) {
            String tag = getTag();
            Log.d(tag, "delete size= " + list.size());
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.axy.getReadableDatabase();
            sQLiteDatabase.beginTransaction();
            for (AbstractC10453e abstractC10453e : list) {
                m26037c(abstractC10453e);
            }
            sQLiteDatabase.setTransactionSuccessful();
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        } catch (Exception e2) {
            C10331c.printStackTrace(e2);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    C10331c.printStackTrace(e3);
                }
            }
        }
    }
}
