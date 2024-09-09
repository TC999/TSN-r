package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LoadTimeDao.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class m extends a<com.mbridge.msdk.foundation.entity.j> {

    /* renamed from: a  reason: collision with root package name */
    private static m f39189a;

    private m(h hVar) {
        super(hVar);
    }

    public static m a(h hVar) {
        if (f39189a == null) {
            synchronized (m.class) {
                if (f39189a == null) {
                    f39189a = new m(hVar);
                }
            }
        }
        return f39189a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from load_stat"
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            android.database.Cursor r0 = r3.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            if (r0 == 0) goto L19
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            if (r2 == 0) goto L19
            int r1 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
        L19:
            if (r0 == 0) goto L28
        L1b:
            r0.close()     // Catch: java.lang.Throwable -> L30
            goto L28
        L1f:
            r1 = move-exception
            goto L2a
        L21:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L28
            goto L1b
        L28:
            monitor-exit(r4)
            return r1
        L2a:
            if (r0 == 0) goto L2f
            r0.close()     // Catch: java.lang.Throwable -> L30
        L2f:
            throw r1     // Catch: java.lang.Throwable -> L30
        L30:
            r0 = move-exception
            monitor-exit(r4)
            goto L34
        L33:
            throw r0
        L34:
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.a():int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List<com.mbridge.msdk.foundation.entity.j>] */
    public final synchronized List<com.mbridge.msdk.foundation.entity.j> a(int i4) {
        ArrayList arrayList;
        ArrayList arrayList2;
        arrayList = 0;
        try {
            try {
                Cursor rawQuery = getReadableDatabase().rawQuery("select * from load_stat LIMIT " + i4, null);
                if (rawQuery != null) {
                    try {
                        try {
                            if (rawQuery.getCount() > 0) {
                                arrayList2 = new ArrayList();
                                int i5 = 0;
                                while (rawQuery.moveToNext() && i5 < i4) {
                                    try {
                                        i5++;
                                        int i6 = rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_AD_SOURCE_ID));
                                        String string = rawQuery.getString(rawQuery.getColumnIndex("time"));
                                        int i7 = rawQuery.getInt(rawQuery.getColumnIndex("adNum"));
                                        String string2 = rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID));
                                        int i8 = rawQuery.getInt(rawQuery.getColumnIndex("fb"));
                                        int i9 = rawQuery.getInt(rawQuery.getColumnIndex("timeout"));
                                        int i10 = rawQuery.getInt(rawQuery.getColumnIndex("network_type"));
                                        String string3 = rawQuery.getString(rawQuery.getColumnIndex("network_type_str"));
                                        int i11 = rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_HB));
                                        com.mbridge.msdk.foundation.entity.j jVar = new com.mbridge.msdk.foundation.entity.j(i6, string, i7, string2, i8, i9, i10);
                                        jVar.c(string3);
                                        jVar.a(i11);
                                        arrayList2.add(jVar);
                                        int i12 = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                                        if (getWritableDatabase() != null) {
                                            getWritableDatabase().delete("load_stat", "id = ?", new String[]{i12 + ""});
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        arrayList = rawQuery;
                                        e.printStackTrace();
                                        if (arrayList != null) {
                                            arrayList.close();
                                        }
                                        arrayList = arrayList2;
                                        return arrayList;
                                    }
                                }
                                arrayList = arrayList2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            arrayList = rawQuery;
                            if (arrayList != null) {
                                arrayList.close();
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        arrayList2 = null;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e6) {
                e = e6;
                arrayList2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList;
    }

    public final synchronized void a(com.mbridge.msdk.foundation.entity.j jVar) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", jVar.c());
        contentValues.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, Integer.valueOf(jVar.b()));
        contentValues.put("adNum", Integer.valueOf(jVar.d()));
        contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, jVar.e());
        contentValues.put("fb", Integer.valueOf(jVar.f()));
        contentValues.put(CampaignEx.JSON_KEY_HB, Integer.valueOf(jVar.a()));
        contentValues.put("timeout", Integer.valueOf(jVar.g()));
        contentValues.put("network_type", Integer.valueOf(jVar.h()));
        contentValues.put("network_type_str", jVar.i());
        getWritableDatabase().insert("load_stat", null, contentValues);
    }
}
