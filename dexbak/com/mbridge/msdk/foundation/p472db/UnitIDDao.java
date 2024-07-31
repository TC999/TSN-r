package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.LoadTime;
import com.mbridge.msdk.foundation.entity.LoopEntity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.db.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class UnitIDDao extends BaseDao<LoadTime> {

    /* renamed from: a */
    private static UnitIDDao f30371a;

    private UnitIDDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static UnitIDDao m22667a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30371a == null) {
            synchronized (UnitIDDao.class) {
                if (f30371a == null) {
                    f30371a = new UnitIDDao(commonAbsDBHelper);
                }
            }
        }
        return f30371a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.mbridge.msdk.foundation.entity.k>] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* renamed from: a */
    public final synchronized List<LoopEntity> m22668a(int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        arrayList = 0;
        try {
            try {
                Cursor rawQuery = getReadableDatabase().rawQuery("select * from unit_id WHERE ad_type = " + i, null);
                if (rawQuery != null) {
                    try {
                        try {
                            if (rawQuery.getCount() > 0) {
                                arrayList2 = new ArrayList(rawQuery.getCount());
                                while (rawQuery.moveToNext()) {
                                    try {
                                        arrayList2.add(new LoopEntity(rawQuery.getString(rawQuery.getColumnIndex("placement_id")), rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID)), i));
                                    } catch (Exception e) {
                                        e = e;
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
                        } catch (Exception e2) {
                            e = e2;
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
            } catch (Exception e3) {
                e = e3;
                arrayList2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList;
    }

    /* renamed from: a */
    public final synchronized void m22666a(String str) {
        if (getWritableDatabase() != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(MBridgeConstans.PROPERTIES_UNIT_ID, "unitId = ?", new String[]{str + ""});
        }
    }

    /* renamed from: a */
    public final synchronized void m22665a(String str, String str2, int i) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("placement_id", str);
        contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str2);
        contentValues.put("ad_type", Integer.valueOf(i));
        getWritableDatabase().insert(MBridgeConstans.PROPERTIES_UNIT_ID, null, contentValues);
    }
}
