package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.ApkDisplayInfo;
import com.mbridge.msdk.out.Campaign;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* compiled from: CampaignDao.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f extends a<Campaign> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39159a = "com.mbridge.msdk.foundation.db.f";

    /* renamed from: b  reason: collision with root package name */
    private static f f39160b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39161c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39162d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39163e;

    /* renamed from: f  reason: collision with root package name */
    private final String f39164f;

    /* renamed from: g  reason: collision with root package name */
    private final String f39165g;

    /* renamed from: h  reason: collision with root package name */
    private final String f39166h;

    /* renamed from: i  reason: collision with root package name */
    private final String f39167i;

    /* renamed from: j  reason: collision with root package name */
    private final String f39168j;

    /* renamed from: k  reason: collision with root package name */
    private final String f39169k;

    /* renamed from: l  reason: collision with root package name */
    private final String f39170l;

    /* renamed from: m  reason: collision with root package name */
    private final String f39171m;

    /* renamed from: n  reason: collision with root package name */
    private final String f39172n;

    /* renamed from: o  reason: collision with root package name */
    private final String f39173o;

    /* renamed from: p  reason: collision with root package name */
    private final String f39174p;

    /* renamed from: q  reason: collision with root package name */
    private final String f39175q;

    /* renamed from: r  reason: collision with root package name */
    private final String f39176r;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(h hVar) {
        super(hVar);
        this.f39161c = "rid";
        this.f39162d = BidResponsedEx.KEY_CID;
        this.f39163e = CampaignEx.JSON_KEY_PLCT;
        this.f39164f = CampaignEx.JSON_KEY_PLCTB;
        this.f39165g = CampaignEx.JSON_KEY_TIMESTAMP;
        this.f39166h = "ridCount";
        this.f39167i = " WHERE ";
        this.f39168j = " AND ";
        this.f39169k = "SELECT ";
        this.f39170l = "*";
        this.f39171m = " FROM ";
        this.f39172n = " AND readyState = '0'";
        this.f39173o = " AND is_bid_campaign = 1";
        this.f39174p = " order by ts ASC";
        this.f39175q = " group by request_id";
        this.f39176r = " group by bid_token";
    }

    public static f a(h hVar) {
        if (f39160b == null) {
            synchronized (f.class) {
                if (f39160b == null) {
                    f39160b = new f(hVar);
                }
            }
        }
        return f39160b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x069c, code lost:
        if (r10 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x069e, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x06b2, code lost:
        if (r10 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x06b6, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x06ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> h(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 1731
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.h(java.lang.String):java.util.List");
    }

    public final synchronized void b(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", (Integer) 0);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid = '" + str + "' AND id = '" + campaignEx.getId() + "' AND " + ConstantAd.KEY_CACHE_AD + " = '" + campaignEx.getRequestId() + "'", null);
                        }
                    } catch (Exception e4) {
                        x.d("CampaignDao", e4.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void c(String str) {
        String str2;
        try {
            str2 = "unitid = " + str;
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", str2, null);
    }

    public final synchronized void d(String str) {
        String str2;
        try {
            str2 = "unitid = " + str + " AND short_ctime<" + (System.currentTimeMillis() - 604800000);
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", str2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0270, code lost:
        if (r11 == null) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String e(java.lang.String r37) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.e(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x011f, code lost:
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0121, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0134, code lost:
        if (0 == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0137, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.mbridge.msdk.foundation.entity.c> f(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.f(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x010c, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x010e, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0121, code lost:
        if (0 == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0124, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.entity.c> g(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.g(java.lang.String):java.util.concurrent.ConcurrentHashMap");
    }

    public final synchronized void a(String str, int i4, int i5) {
        String str2;
        try {
            str2 = "unitid = " + str + " AND level = " + i4 + " AND adSource = " + i5;
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", str2, null);
    }

    public final int c(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = "unitid = '" + str2 + "' AND " + ConstantAd.KEY_CACHE_AD + " = '" + str + "' AND is_bid_campaign = 1";
        } else {
            str3 = "unitid = '" + str2 + "' AND is_bid_campaign = 1";
        }
        String str4 = str3 + " AND readyState = '0'";
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            return getWritableDatabase().update("campaign", contentValues, str4, null);
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.mbridge.msdk.foundation.entity.CampaignEx] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final CampaignEx d(String str, String str2) {
        CampaignEx campaignEx;
        CampaignEx campaignEx2 = null;
        campaignEx2 = 0;
        campaignEx2 = 0;
        campaignEx2 = null;
        campaignEx2 = 0;
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM campaign where unitid ='" + str2 + "' and id = '" + str + "'", null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0) {
                            while (rawQuery.moveToNext()) {
                                campaignEx2 = a(rawQuery);
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        CampaignEx campaignEx3 = campaignEx2;
                        cursor = rawQuery;
                        campaignEx = campaignEx3;
                        x.d("CampaignDao", e.getLocalizedMessage());
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception unused) {
                            }
                        }
                        campaignEx2 = campaignEx;
                        return campaignEx2;
                    } catch (Throwable th) {
                        th = th;
                        campaignEx2 = rawQuery;
                        if (campaignEx2 != null) {
                            try {
                                campaignEx2.close();
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
            } catch (Exception e5) {
                e = e5;
                campaignEx = null;
            }
            return campaignEx2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized List<CampaignEx> b(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM campaign WHERE unitid = '" + str + "' AND readyState = 2", null);
            if (rawQuery == null || rawQuery.getCount() <= 0) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList.add(a(rawQuery));
            }
            rawQuery.close();
            return arrayList;
        } catch (Exception unused) {
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final synchronized void a(String str, int i4, int i5, boolean z3) {
        String sb;
        try {
            String str2 = "unitid = " + str + " AND level = " + i4 + " AND adSource = " + i5;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(" AND is_bid_campaign = ");
            sb2.append(z3 ? 1 : 0);
            sb = sb2.toString();
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", sb, null);
    }

    public final synchronized void a(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("readyState", (Integer) 2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("id = '" + campaignEx.getId() + "' AND unitid = " + str + " AND " + ConstantAd.KEY_CACHE_AD + " = '" + campaignEx.getRequestId() + "'");
                    sb.append(" AND is_bid_campaign = ");
                    sb.append(campaignEx.isBidCampaign() ? 1 : 0);
                    String sb2 = sb.toString();
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, sb2, null);
                        }
                    } catch (SQLException e4) {
                        x.d("CampaignDao", e4.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void b(String str, String str2) {
        try {
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (getWritableDatabase() == null) {
            return;
        }
        String str3 = "id = '" + str + "' AND " + ConstantAd.KEY_CACHE_AD + " = '" + str2 + "'";
        ContentValues contentValues = new ContentValues();
        contentValues.put("readyState", (Integer) 2);
        getWritableDatabase().update("campaign", contentValues, str3, null);
    }

    public final synchronized void a(String str, List<CampaignEx> list, boolean z3) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        if (campaignEx.getLoadTimeoutState() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unitid");
                            sb.append(" = '");
                            sb.append(str);
                            sb.append("' AND ");
                            sb.append("id");
                            sb.append(" = '");
                            sb.append(campaignEx.getId());
                            sb.append("' AND ");
                            sb.append(ConstantAd.KEY_CACHE_AD);
                            sb.append(" = '");
                            sb.append(campaignEx.getRequestId());
                            sb.append("'");
                            if (z3) {
                                sb.append(" AND is_bid_campaign = 1");
                            } else {
                                sb.append(" AND is_bid_campaign = 0");
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("readyState", (Integer) 2);
                            SQLiteDatabase writableDatabase = getWritableDatabase();
                            if (writableDatabase != null) {
                                writableDatabase.update("campaign", contentValues, sb.toString(), null);
                            }
                        }
                    } catch (SQLException e4) {
                        x.d("CampaignDao", e4.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void b(long j4, String str) {
        try {
            String str2 = "ts<" + (System.currentTimeMillis() - j4) + " and unitid=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, strArr);
            }
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
    }

    public final synchronized void f(String str, String str2) {
        try {
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String str3 = "unitid = '" + str + "' AND bid_token = '" + str2 + "' AND bid_token IS NOT NULL";
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update("campaign", contentValues, str3, null);
        }
    }

    public final synchronized void b(final List<CampaignEx> list, final String str) {
        if (list != null) {
            if (list.size() != 0) {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.db.f.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        for (CampaignEx campaignEx : list) {
                            f.this.a(campaignEx, str, 0);
                        }
                    }
                }).start();
            }
        }
    }

    public final synchronized List<CampaignEx> b(String str, int i4, int i5, int i6) {
        String str2;
        String str3;
        str2 = " WHERE unitid = '" + str + "' AND level = " + i5 + " AND adSource = " + i6;
        str3 = "";
        if (i4 > 0) {
            str3 = " LIMIT " + i4;
        }
        return h("SELECT * FROM campaign" + str2 + str3);
    }

    public final synchronized void a(String str, List<CampaignEx> list, String str2, int i4) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && !TextUtils.isEmpty(str2)) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                for (CampaignEx campaignEx : list) {
                    if (campaignEx != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(str2, Integer.valueOf(i4));
                        writableDatabase.update("campaign", contentValues, "unitid = '" + str + "' AND id = '" + campaignEx.getId() + "' AND " + ConstantAd.KEY_CACHE_AD + " = '" + campaignEx.getRequestId() + "'", null);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final synchronized void e(String str, String str2) {
        try {
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = "unitid = '" + str + "'";
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + " AND bid_token != '" + str2 + "'";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("readyState", (Integer) 2);
        getWritableDatabase().update("campaign", contentValues, (str3 + " AND is_bid_campaign = 1") + " AND bid_token IS NOT NULL", null);
    }

    public final List<CampaignEx> b(String str, int i4, boolean z3) {
        ArrayList arrayList;
        String str2;
        Cursor cursor = null;
        r0 = null;
        ArrayList arrayList2 = null;
        cursor = null;
        try {
            try {
                if (z3) {
                    str2 = "placement_id = " + str + " AND ad_type = " + i4;
                } else {
                    str2 = "ad_type = " + i4;
                }
                Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM campaign WHERE " + str2, null);
                if (rawQuery != null) {
                    try {
                        try {
                            if (rawQuery.getCount() > 0) {
                                arrayList = new ArrayList();
                                while (rawQuery.moveToNext()) {
                                    try {
                                        arrayList.add(a(rawQuery));
                                    } catch (Exception e4) {
                                        cursor = rawQuery;
                                        e = e4;
                                        x.d("CampaignDao", e.getLocalizedMessage());
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                            }
                                        }
                                        return arrayList;
                                    }
                                }
                                arrayList2 = arrayList;
                            }
                        } catch (Exception e5) {
                            cursor = rawQuery;
                            e = e5;
                            arrayList = null;
                        }
                    } catch (Throwable th) {
                        cursor = rawQuery;
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                        return arrayList2;
                    } catch (Exception unused3) {
                        return arrayList2;
                    }
                }
                return arrayList2;
            } catch (Exception e6) {
                e = e6;
                arrayList = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list, List<CampaignEx> list2, boolean z3) {
        if (getWritableDatabase() == null) {
            return;
        }
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (CampaignEx campaignEx : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("readyState", (Integer) 0);
                            String str2 = "unitid = '" + str + "' AND id = '" + campaignEx.getId() + "' AND " + ConstantAd.KEY_CACHE_AD + " = '" + campaignEx.getRequestId() + "'";
                            getWritableDatabase().update("campaign", contentValues, z3 ? str2 + " AND is_bid_campaign = 1" : str2 + " AND is_bid_campaign = 0", null);
                        } catch (Exception e4) {
                            x.d("CampaignDao", e4.getLocalizedMessage());
                        }
                    }
                }
            } catch (Exception e5) {
                x.d("CampaignDao", e5.getLocalizedMessage());
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (CampaignEx campaignEx2 : list2) {
                try {
                    if (campaignEx2.getLoadTimeoutState() == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unitid");
                        sb.append(" = '");
                        sb.append(str);
                        sb.append("' AND ");
                        sb.append("id");
                        sb.append(" = '");
                        sb.append(campaignEx2.getId());
                        sb.append("' AND ");
                        sb.append(ConstantAd.KEY_CACHE_AD);
                        sb.append(" = '");
                        sb.append(campaignEx2.getRequestId());
                        sb.append("'");
                        if (z3) {
                            sb.append(" AND is_bid_campaign = 1");
                        } else {
                            sb.append(" AND is_bid_campaign = 0");
                        }
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("readyState", (Integer) 2);
                        getWritableDatabase().update("campaign", contentValues2, sb.toString(), null);
                    }
                } catch (SQLException e6) {
                    x.d("CampaignDao", e6.getLocalizedMessage());
                }
            }
        }
    }

    public final synchronized void a(String str, String str2) {
        String str3;
        try {
            str3 = "id = '" + str + "' AND unitid = " + str2;
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", str3, null);
    }

    public final synchronized void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("campaign", "unitid = '" + str + "' AND readyState = 2", null);
            }
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
    }

    public final synchronized void a(List<CampaignEx> list, String str) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", (Integer) 2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid = '" + str + "' AND id = '" + campaignEx.getId() + "' AND " + ConstantAd.KEY_CACHE_AD + " = '" + campaignEx.getRequestId() + "'", null);
                        }
                    } catch (SQLException e4) {
                        x.d("CampaignDao", e4.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, String str2, boolean z3, String str3) {
        String sb;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("id = '");
            sb2.append(str);
            sb2.append("' AND ");
            sb2.append("unitid");
            sb2.append(" = ");
            sb2.append(str2);
            sb2.append(" AND ");
            sb2.append("is_bid_campaign");
            sb2.append(" = ");
            sb2.append(z3 ? "1" : "0");
            sb2.append(" AND ");
            sb2.append(ConstantAd.KEY_CACHE_AD);
            sb2.append(" = '");
            sb2.append(str3);
            sb2.append("'");
            sb = sb2.toString();
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("readyState", (Integer) 2);
        getWritableDatabase().update("campaign", contentValues, sb, null);
    }

    public final synchronized void a(String str, String str2, int i4, int i5, boolean z3) {
        String str3;
        try {
            String str4 = "id = '" + str + "' AND unitid = " + str2 + " AND level = " + i4 + " AND adSource = " + i5;
            if (z3) {
                str3 = str4 + " AND is_bid_campaign = 1";
            } else {
                str3 = str4 + " AND is_bid_campaign = 0";
            }
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", str3, null);
    }

    public final synchronized void a(String str, int i4, boolean z3) {
        String str2;
        try {
            if (z3) {
                str2 = "placement_id = " + str + " AND ad_type = " + i4;
            } else {
                str2 = "ad_type = " + i4;
            }
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", str2, null);
    }

    public final synchronized void a(String str, ContentValues contentValues) {
        try {
            getWritableDatabase().update("campaign", contentValues, "id = ?", new String[]{str});
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
    }

    public final synchronized void a() {
        try {
            String str = "ts<" + (System.currentTimeMillis() - 3600000) + " AND ts>0";
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str, null);
            }
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
        }
    }

    public final synchronized void a(long j4, String str) {
        long currentTimeMillis;
        try {
            String str2 = "(plctb>0 and (plctb* 1000+ts)<" + System.currentTimeMillis() + ") or (" + CampaignEx.JSON_KEY_PLCTB + "<=0 and ts<" + (currentTimeMillis - j4) + ") and unitid=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, strArr);
            }
        } catch (Exception e4) {
            x.d(f39159a, e4.getMessage());
        }
    }

    public final synchronized void a(List<CampaignEx> list, String str, String str2, int i4) {
        if (list != null) {
            if (list.size() != 0) {
                if (getWritableDatabase() == null) {
                    return;
                }
                for (CampaignEx campaignEx : list) {
                    a(campaignEx, str, str2, i4);
                }
            }
        }
    }

    private synchronized long a(CampaignEx campaignEx, String str, String str2, int i4) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str3 : campaignEx.getPv_urls()) {
                    jSONArray.put(str3);
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("id", campaignEx.getId());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            contentValues.put("placement_id", str);
            contentValues.put("unitid", str2);
            contentValues.put(CampaignEx.JSON_KEY_NUMBER_RATING, Integer.valueOf(campaignEx.getNumberRating()));
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put("package_name", campaignEx.getPackageName());
            contentValues.put("app_name", campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("cpti", Integer.valueOf(campaignEx.getPreClickInterval()));
            contentValues.put("preclick", Boolean.valueOf(campaignEx.isPreClick()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put("html_url", campaignEx.getHtmlUrl());
            contentValues.put("end_screen_url", campaignEx.getEndScreenUrl());
            contentValues.put("reward_amount", Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put("reward_name", campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put(DomainCampaignEx.JSON_KEY_ADV_ID, campaignEx.getAdvId());
            contentValues.put(DomainCampaignEx.JSON_KEY_TTC_CT2, Integer.valueOf(campaignEx.getTtc_ct2() * 1000));
            contentValues.put(DomainCampaignEx.JSON_KEY_TTC_TYPE, Integer.valueOf(campaignEx.getTtc_type()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(DomainCampaignEx.LOOPBACK, campaignEx.getLoopbackString());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().a());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(DomainCampaignEx.KEY_GH_ID, campaignEx.getGhId());
            contentValues.put(DomainCampaignEx.KEY_GH_PATH, campaignEx.getGhPath());
            contentValues.put(DomainCampaignEx.KEY_BIND_ID, campaignEx.getBindId());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.c());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.b()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.a()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put("bid_token", campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            if (campaignEx.getRewardPlus() != null && campaignEx.getRewardPlus().toJsonObject() != null) {
                contentValues.put(CampaignEx.JSON_KEY_REWARD_PLUS, campaignEx.getRewardPlus().toJsonObject().toString());
            }
            if (campaignEx.getApkDisplayInfo() != null && campaignEx.getApkDisplayInfo().toJson() != null) {
                contentValues.put(DomainCampaignEx.JSON_KEY_APK_INFO, campaignEx.getApkDisplayInfo().toJson().toString());
            }
            contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
            contentValues.put(CampaignUnit.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put(ConstantAd.KEY_CACHE_AD, campaignEx.getRequestId());
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put(DomainCampaignEx.JSON_KEY_APK_ALT, Integer.valueOf(campaignEx.getApkAlt()));
            contentValues.put(DomainCampaignEx.JSON_KEY_ATAT_TYPE, Integer.valueOf(campaignEx.getAtatType()));
            contentValues.put(DomainCampaignEx.JSON_KEY_NTBARPASBL, Integer.valueOf(campaignEx.getNtbarpasbl()));
            contentValues.put(DomainCampaignEx.JSON_KEY_NTBARPT, Integer.valueOf(campaignEx.getNtbarpt()));
            contentValues.put(DomainCampaignEx.JSON_KEY_AKDLUI, campaignEx.getAkdlui());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
            contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
            return getWritableDatabase().insert("campaign", null, contentValues);
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
            return -1L;
        }
    }

    public final synchronized long a(CampaignEx campaignEx, String str, int i4) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str2 : campaignEx.getPv_urls()) {
                    jSONArray.put(str2);
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("unitid", str);
            contentValues.put(CampaignEx.JSON_KEY_NUMBER_RATING, Integer.valueOf(campaignEx.getNumberRating()));
            contentValues.put(ConstantAd.KEY_CACHE_AD, campaignEx.getRequestId());
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put("package_name", campaignEx.getPackageName());
            contentValues.put("app_name", campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("cpti", Integer.valueOf(campaignEx.getPreClickInterval()));
            contentValues.put("preclick", Boolean.valueOf(campaignEx.isPreClick()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put("html_url", campaignEx.getHtmlUrl());
            contentValues.put("end_screen_url", campaignEx.getEndScreenUrl());
            contentValues.put("reward_amount", Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put("reward_name", campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put(DomainCampaignEx.JSON_KEY_ADV_ID, campaignEx.getAdvId());
            contentValues.put(DomainCampaignEx.JSON_KEY_TTC_CT2, Integer.valueOf(campaignEx.getTtc_ct2() * 1000));
            contentValues.put(DomainCampaignEx.JSON_KEY_TTC_TYPE, Integer.valueOf(campaignEx.getTtc_type()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(DomainCampaignEx.LOOPBACK, campaignEx.getLoopbackString());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().a());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(DomainCampaignEx.KEY_GH_ID, campaignEx.getGhId());
            contentValues.put(DomainCampaignEx.KEY_GH_PATH, campaignEx.getGhPath());
            contentValues.put(DomainCampaignEx.KEY_BIND_ID, campaignEx.getBindId());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.c());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.b()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.a()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put("bid_token", campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            if (campaignEx.getRewardPlus() != null && campaignEx.getRewardPlus().toJsonObject() != null) {
                contentValues.put(CampaignEx.JSON_KEY_REWARD_PLUS, campaignEx.getRewardPlus().toJsonObject().toString());
            }
            if (campaignEx.getApkDisplayInfo() != null && campaignEx.getApkDisplayInfo().toJson() != null) {
                contentValues.put(DomainCampaignEx.JSON_KEY_APK_INFO, campaignEx.getApkDisplayInfo().toJson().toString());
            }
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
            contentValues.put(CampaignUnit.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put("placement_id", campaignEx.getPlacementId());
            contentValues.put(DomainCampaignEx.JSON_KEY_APK_ALT, Integer.valueOf(campaignEx.getApkAlt()));
            contentValues.put(DomainCampaignEx.JSON_KEY_ATAT_TYPE, Integer.valueOf(campaignEx.getAtatType()));
            contentValues.put(DomainCampaignEx.JSON_KEY_NTBARPASBL, Integer.valueOf(campaignEx.getNtbarpasbl()));
            contentValues.put(DomainCampaignEx.JSON_KEY_NTBARPT, Integer.valueOf(campaignEx.getNtbarpt()));
            contentValues.put(DomainCampaignEx.JSON_KEY_AKDLUI, campaignEx.getAkdlui());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
            contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
            if (a(campaignEx.getId(), campaignEx.getTab(), str, i4, campaignEx.getType(), campaignEx.isBidCampaign())) {
                String str3 = campaignEx.isBidCampaign() ? "unitid = " + str + " AND is_bid_campaign = 1" : "id = " + campaignEx.getId() + " AND unitid = " + str + " AND is_bid_campaign = 0";
                return getWritableDatabase().update("campaign", contentValues, str3, null);
            }
            return getWritableDatabase().insert("campaign", null, contentValues);
        } catch (Exception e4) {
            x.d("CampaignDao", e4.getLocalizedMessage());
            return -1L;
        }
    }

    public final synchronized int a(String str, long j4) {
        try {
            com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null) {
                b4 = com.mbridge.msdk.c.b.a().b();
            }
            long W = b4.W() * 1000;
            a(W, str);
            List<CampaignEx> a4 = a(str, 0, 0, 1, false);
            if (a4 != null && !a4.isEmpty()) {
                for (CampaignEx campaignEx : a4) {
                    if (!campaignEx.isSpareOffer(j4, W)) {
                        return 0;
                    }
                }
                return 1;
            }
            return -1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public final synchronized boolean a(String str, int i4, String str2, int i5, int i6, boolean z3) {
        String str3;
        if (z3) {
            str3 = "SELECT id FROM campaign WHERE unitid = " + str2 + " AND is_bid_campaign = 1";
        } else {
            str3 = "SELECT id FROM campaign WHERE id='" + str + "' AND tab=" + i4 + " AND unitid = '" + str2 + "' AND level = " + i5 + " AND adSource = " + i6 + " AND is_bid_campaign = 0";
        }
        Cursor rawQuery = getReadableDatabase().rawQuery(str3, null);
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
            return true;
        }
        if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public final List<CampaignEx> a(String str, int i4, int i5, int i6) {
        String str2;
        String str3 = " WHERE unitid = '" + str + "' AND level = " + i5 + " AND adSource = " + i6;
        if (i4 > 0) {
            str2 = " LIMIT " + i4;
        } else {
            str2 = "";
        }
        return h("SELECT * FROM campaign" + str3 + str2);
    }

    public final synchronized List<CampaignEx> a(String str, int i4, int i5, int i6, boolean z3) {
        String str2;
        String str3;
        String str4 = " WHERE unitid = '" + str + "' AND level = " + i5 + " AND adSource = " + i6;
        if (z3) {
            str2 = str4 + " AND is_bid_campaign = 1";
        } else {
            str2 = str4 + " AND is_bid_campaign = 0";
        }
        str3 = "";
        if (i4 > 0) {
            str3 = " LIMIT " + i4;
        }
        return h("SELECT * FROM campaign" + str2 + str3);
    }

    public final synchronized List<CampaignEx> a(String str, int i4, int i5, int i6, String str2) {
        String str3;
        String str4;
        str3 = ((" WHERE unitid = '" + str + "' AND level = " + i5 + " AND adSource = " + i6) + " AND is_bid_campaign = 1") + " AND readyState = '0'";
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + " AND request_id = '" + str2 + "'";
        }
        str4 = "";
        if (i4 > 0) {
            str4 = " LIMIT " + i4;
        }
        return h("SELECT * FROM campaign" + (str3 + " order by ts ASC") + str4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x076f, code lost:
        if (r9 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0771, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x078d, code lost:
        if (r9 == 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0790, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0794 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> a(java.lang.String r9, int r10) {
        /*
            Method dump skipped, instructions count: 1946
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.a(java.lang.String, int):java.util.List");
    }

    private CampaignEx a(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        try {
            String string = cursor.getString(cursor.getColumnIndex("pv_urls"));
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    arrayList.add(jSONArray.getString(i4));
                }
                campaignEx.setPv_urls(arrayList);
            }
        } catch (JSONException unused) {
        }
        campaignEx.setId(cursor.getString(cursor.getColumnIndex("id")));
        campaignEx.setTab(cursor.getInt(cursor.getColumnIndex("tab")));
        campaignEx.setPackageName(cursor.getString(cursor.getColumnIndex("package_name")));
        campaignEx.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
        campaignEx.setAppDesc(cursor.getString(cursor.getColumnIndex("app_desc")));
        campaignEx.setSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
        campaignEx.setImageSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
        campaignEx.setIconUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_ICON_URL)));
        campaignEx.setImageUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
        campaignEx.setImpressionURL(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
        campaignEx.setNoticeUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
        campaignEx.setClickURL(cursor.getString(cursor.getColumnIndex(DownloadModel.DOWNLOAD_URL)));
        campaignEx.setWtick(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
        campaignEx.setDeepLinkUrl(cursor.getString(cursor.getColumnIndex("deeplink_url")));
        campaignEx.setUserActivation(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_USER_ACTIVATION))));
        campaignEx.setOnlyImpressionURL(cursor.getString(cursor.getColumnIndex("only_impression")));
        campaignEx.setPreClick(cursor.getInt(cursor.getColumnIndex("preclick")) == 1);
        campaignEx.setTemplate(cursor.getInt(cursor.getColumnIndex("template")));
        campaignEx.setLandingType(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
        campaignEx.setLinkType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
        campaignEx.setClick_mode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
        campaignEx.setRating(Double.parseDouble(cursor.getString(cursor.getColumnIndex("star"))));
        campaignEx.setNumberRating(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
        campaignEx.setClickInterval(cursor.getInt(cursor.getColumnIndex("cti")));
        campaignEx.setPreClickInterval(cursor.getInt(cursor.getColumnIndex("cpti")));
        campaignEx.setTimestamp(cursor.getLong(cursor.getColumnIndex("ts")));
        campaignEx.setCacheLevel(cursor.getInt(cursor.getColumnIndex("level")));
        campaignEx.setAdCall(cursor.getString(cursor.getColumnIndex("ad_call")));
        campaignEx.setFcb(cursor.getInt(cursor.getColumnIndex("fc_b")));
        campaignEx.setAd_url_list(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
        campaignEx.setVideoLength(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
        campaignEx.setVideoSize(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
        campaignEx.setVideoResolution(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
        campaignEx.setEndcard_click_result(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
        campaignEx.setVideoUrlEncode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_URL)));
        campaignEx.setWatchMile(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
        campaignEx.setVideoCompleteTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
        campaignEx.setTImp(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
        campaignEx.setBty(cursor.getInt(cursor.getColumnIndex("bty")));
        campaignEx.setAdvImp(cursor.getString(cursor.getColumnIndex("advImp")));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setOfferType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex("html_url")));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex("html_url")));
        campaignEx.setEndScreenUrl(cursor.getString(cursor.getColumnIndex("end_screen_url")));
        campaignEx.setRewardName(cursor.getString(cursor.getColumnIndex("reward_name")));
        campaignEx.setRewardAmount(cursor.getInt(cursor.getColumnIndex("reward_amount")));
        campaignEx.setRewardPlayStatus(cursor.getInt(cursor.getColumnIndex("reward_play_status")));
        campaignEx.setAdvId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.JSON_KEY_ADV_ID)));
        campaignEx.setTtc_ct2(cursor.getInt(cursor.getColumnIndex(DomainCampaignEx.JSON_KEY_TTC_CT2)));
        campaignEx.setTtc_type(cursor.getInt(cursor.getColumnIndex(DomainCampaignEx.JSON_KEY_TTC_TYPE)));
        campaignEx.setRetarget_offer(cursor.getInt(cursor.getColumnIndex("retarget")));
        campaignEx.setCampaignUnitId(cursor.getString(cursor.getColumnIndex("unitid")));
        campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(cursor.getString(cursor.getColumnIndex("native_ad_tracking"))));
        campaignEx.setNativeVideoTrackingString(cursor.getString(cursor.getColumnIndex("native_ad_tracking")));
        campaignEx.setVideo_end_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
        campaignEx.setendcard_url(cursor.getString(cursor.getColumnIndex(CampaignEx.ENDCARD_URL)));
        campaignEx.setPlayable_ads_without_video(cursor.getInt(cursor.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
        campaignEx.setLoopbackString(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.LOOPBACK)));
        campaignEx.setLoopbackMap(DomainCampaignEx.loopbackStrToMap(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.LOOPBACK))));
        campaignEx.setRewardTemplateMode(CampaignEx.c.a(cursor.getString(cursor.getColumnIndex("reward_teamplate"))));
        campaignEx.setVideoMD5Value(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
        campaignEx.setGifUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
        campaignEx.setNvT2(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
        campaignEx.setClickTimeOutInterval(cursor.getInt(cursor.getColumnIndex("c_coi")));
        campaignEx.setcUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
        campaignEx.setImpUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
        campaignEx.setJmPd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_JM_PD)));
        campaignEx.setIsDeleted(cursor.getInt(cursor.getColumnIndex("is_deleted")));
        campaignEx.setIsClick(cursor.getInt(cursor.getColumnIndex("is_click")));
        campaignEx.setIsAddSuccesful(cursor.getInt(cursor.getColumnIndex("is_add_sucesful")));
        campaignEx.setIsDownLoadZip(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_IS_DOWNLOAD)));
        campaignEx.setInteractiveCache(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_CACHE)));
        campaignEx.setKeyIaOri(cursor.getInt(cursor.getColumnIndex("ia_ori")));
        campaignEx.setAdType(cursor.getInt(cursor.getColumnIndex("ad_type")));
        campaignEx.setIa_ext1(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT1)));
        campaignEx.setIa_ext2(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT2)));
        campaignEx.setKeyIaRst(cursor.getInt(cursor.getColumnIndex("ia_rst")));
        campaignEx.setKeyIaUrl(cursor.getString(cursor.getColumnIndex("ia_url")));
        campaignEx.setKeyIaIcon(cursor.getString(cursor.getColumnIndex("ia_icon")));
        campaignEx.setFac(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FAC)));
        campaignEx.setTpOffer(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_TP_OFFER)));
        campaignEx.setGhId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_ID)));
        campaignEx.setGhPath(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_PATH)));
        campaignEx.setBindId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_BIND_ID)));
        campaignEx.setOc_time(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TIME)));
        campaignEx.setOc_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TYPE)));
        campaignEx.setT_list(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_T_LIST)));
        String string2 = cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ADCHOICE));
        if (!TextUtils.isEmpty(string2)) {
            campaignEx.setAdchoice(CampaignEx.a.a(string2));
        }
        campaignEx.setAdchoiceSizeHeight(cursor.getInt(cursor.getColumnIndex("adchoice_size_height")));
        campaignEx.setAdchoiceSizeWidth(cursor.getInt(cursor.getColumnIndex("adchoice_size_width")));
        campaignEx.setPlct(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT)));
        campaignEx.setPlctb(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB)));
        campaignEx.setAdZip(cursor.getString(cursor.getColumnIndex("ad_zip")));
        campaignEx.setAdHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_HTML)));
        campaignEx.setBannerUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_URL)));
        campaignEx.setBannerHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_HTML)));
        campaignEx.setCreativeId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_CREATIVE_ID)));
        campaignEx.setIsBidCampaign(cursor.getInt(cursor.getColumnIndex("is_bid_campaign")) == 1);
        campaignEx.setBidToken(cursor.getString(cursor.getColumnIndex("bid_token")));
        campaignEx.setMraid(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MRAID)));
        campaignEx.setIsMraid(cursor.getInt(cursor.getColumnIndex("is_mraid_campaign")) == 1);
        campaignEx.setOmid(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_OMID)));
        campaignEx.setReady_rate(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_READY_RATE)));
        campaignEx.setExt_data(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_EXT_DATA)));
        campaignEx.setNscpt(cursor.getInt(cursor.getColumnIndex(CampaignUnit.JSON_KEY_NSCPT)));
        campaignEx.setMof_template_url(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL)));
        campaignEx.setMof_tplid(cursor.getInt(cursor.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TPLID)));
        campaignEx.setReq_ext_data(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_REQ_EXT_DATA)));
        campaignEx.setReadyState(cursor.getInt(cursor.getColumnIndex("readyState")));
        campaignEx.setLoadTimeoutState(cursor.getInt(cursor.getColumnIndex("load_timeout")));
        campaignEx.setPlacementId(cursor.getString(cursor.getColumnIndex("placement_id")));
        campaignEx.setApkAlt(cursor.getInt(cursor.getColumnIndex(DomainCampaignEx.JSON_KEY_APK_ALT)));
        campaignEx.setAkdlui(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.JSON_KEY_AKDLUI)));
        campaignEx.setNtbarpasbl(cursor.getInt(cursor.getColumnIndex(DomainCampaignEx.JSON_KEY_NTBARPASBL)));
        campaignEx.setNtbarpt(cursor.getInt(cursor.getColumnIndex(DomainCampaignEx.JSON_KEY_NTBARPT)));
        campaignEx.setAtatType(cursor.getInt(cursor.getColumnIndex(DomainCampaignEx.JSON_KEY_ATAT_TYPE)));
        campaignEx.setRewardPlus(RewardPlus.parseByString(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_PLUS))));
        campaignEx.setApkDisplayInfo(ApkDisplayInfo.parseByString(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.JSON_KEY_APK_INFO))));
        campaignEx.setFlb(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
        campaignEx.setFlbSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
        campaignEx.setCbd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
        campaignEx.setVst(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
        campaignEx.setAdSpaceT(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
        campaignEx.setVcn(cursor.getInt(cursor.getColumnIndex("vcn")));
        campaignEx.setTokenRule(cursor.getInt(cursor.getColumnIndex("token_r")));
        campaignEx.setEncryptPrice(cursor.getString(cursor.getColumnIndex("encrypt_p")));
        campaignEx.setVideoCheckType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
        campaignEx.setVideoCtnType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
        campaignEx.setRsIgnoreCheckRuleByString(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
        return campaignEx;
    }
}
