package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UnitIDDao.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class r extends a<com.mbridge.msdk.foundation.entity.j> {

    /* renamed from: a  reason: collision with root package name */
    private static r f39198a;

    private r(h hVar) {
        super(hVar);
    }

    public static r a(h hVar) {
        if (f39198a == null) {
            synchronized (r.class) {
                if (f39198a == null) {
                    f39198a = new r(hVar);
                }
            }
        }
        return f39198a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.mbridge.msdk.foundation.entity.k>] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final synchronized List<com.mbridge.msdk.foundation.entity.k> a(int i4) {
        ArrayList arrayList;
        ArrayList arrayList2;
        arrayList = 0;
        try {
            try {
                Cursor rawQuery = getReadableDatabase().rawQuery("select * from unit_id WHERE ad_type = " + i4, null);
                if (rawQuery != null) {
                    try {
                        try {
                            if (rawQuery.getCount() > 0) {
                                arrayList2 = new ArrayList(rawQuery.getCount());
                                while (rawQuery.moveToNext()) {
                                    try {
                                        arrayList2.add(new com.mbridge.msdk.foundation.entity.k(rawQuery.getString(rawQuery.getColumnIndex("placement_id")), rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID)), i4));
                                    } catch (Exception e4) {
                                        e = e4;
                                        arrayList = rawQuery;
                                        e.printStackTrace();
                                        if (arrayList != null) {
                                            try {
                                                arrayList.close();
                                            } catch (Exception unused) {
                                            }
                                        }
                                        arrayList = arrayList2;
                                        return arrayList;
                                    }
                                }
                                arrayList = arrayList2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            arrayList2 = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        arrayList = rawQuery;
                        if (arrayList != null) {
                            try {
                                arrayList.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception unused3) {
                    }
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

    public final synchronized void a(String str) {
        if (getWritableDatabase() != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(MBridgeConstans.PROPERTIES_UNIT_ID, "unitId = ?", new String[]{str + ""});
        }
    }

    public final synchronized void a(String str, String str2, int i4) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("placement_id", str);
        contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str2);
        contentValues.put("ad_type", Integer.valueOf(i4));
        getWritableDatabase().insert(MBridgeConstans.PROPERTIES_UNIT_ID, null, contentValues);
    }
}
