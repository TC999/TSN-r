package com.bytedance.sdk.openadsdk.tools;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import cn.jpush.android.api.InAppSlotParams;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.ls;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static String f36301c = "SettingRitRepertoryImpl";
    private static long sr;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f36302w;
    private static Map<Integer, String> xv;

    public static boolean c() {
        return f36302w;
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = f36301c;
            a.w(str2, "delete -- key:" + str);
            return;
        }
        com.bytedance.sdk.openadsdk.core.multipro.c.c.delete(ls.getContext(), "setting_rit", "rit=?", new String[]{str});
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (0 == 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.Integer, java.lang.String> sr() {
        /*
            java.lang.String r0 = "value"
            java.lang.String r1 = "_id"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.ls.getContext()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            java.lang.String r5 = "setting_global_info"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            r7 = 0
            r6[r7] = r1     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            r7 = 1
            r6[r7] = r0     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r3 = com.bytedance.sdk.openadsdk.core.multipro.c.c.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            if (r3 != 0) goto L2a
            if (r3 == 0) goto L29
            r3.close()
        L29:
            return r2
        L2a:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L53
            if (r4 == 0) goto L56
            int r4 = r3.getColumnIndex(r1)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4c
            int r4 = r3.getInt(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4c
            int r5 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4c
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4c
            if (r5 != 0) goto L48
            java.lang.String r5 = ""
        L48:
            r2.put(r4, r5)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4c
            goto L2a
        L4c:
            r0 = move-exception
            if (r3 == 0) goto L52
            r3.close()
        L52:
            throw r0
        L53:
            if (r3 == 0) goto L59
        L56:
            r3.close()
        L59:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.w.sr():java.util.Map");
    }

    public static void w() {
        f36302w = true;
    }

    public static String xv() {
        return "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT)";
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (r10.getCount() > 0) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean xv(java.lang.String r10) {
        /*
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.ls.getContext()
            r8 = 1
            java.lang.String[] r4 = new java.lang.String[r8]
            r9 = 0
            r4[r9] = r10
            java.lang.String r1 = "setting_rit"
            r2 = 0
            java.lang.String r3 = "rit=?"
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = com.bytedance.sdk.openadsdk.core.multipro.c.c.query(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r10 == 0) goto L24
            int r0 = r10.getCount()     // Catch: java.lang.Throwable -> L1f
            if (r0 <= 0) goto L24
            goto L25
        L1f:
            r0 = move-exception
            r10.close()
            throw r0
        L24:
            r8 = 0
        L25:
            if (r10 == 0) goto L2a
            r10.close()
        L2a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.w.xv(java.lang.String):boolean");
    }

    public static String c(int i4, String str) {
        if (xv == null || System.currentTimeMillis() - sr > 2000) {
            sr = System.currentTimeMillis();
            xv = sr();
        }
        Map<Integer, String> map = xv;
        if (map == null || map.containsKey(Integer.valueOf(i4))) {
            try {
                String xv2 = com.bytedance.sdk.component.utils.c.xv(map.get(Integer.valueOf(i4)));
                return "null".equals(xv2) ? "" : xv2;
            } catch (Exception unused) {
                return str;
            }
        }
        return str;
    }

    public static JSONObject w(String str) throws JSONException {
        int columnIndex;
        if (!c()) {
            return null;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.c.c.query(ls.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (query == null || query.getCount() <= 0) {
            if (query != null) {
                query.close();
            }
            return null;
        }
        try {
            try {
                String string = (!query.moveToNext() || (columnIndex = query.getColumnIndex("config")) < 0) ? "" : query.getString(columnIndex);
                if (!TextUtils.isEmpty(string)) {
                    return new JSONObject(com.bytedance.sdk.component.utils.c.xv(string));
                }
            } finally {
                try {
                    query.close();
                } finally {
                    try {
                        query.close();
                    } catch (Throwable unused) {
                    }
                }
            }
            query.close();
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void xv(int i4, String str) {
        if (c()) {
            String str2 = f36301c;
            a.w(str2, "insertOrUpdateGlobalInfo -- key:" + i4 + "; value:" + str);
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            Cursor query = com.bytedance.sdk.openadsdk.core.multipro.c.c.query(ls.getContext(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i4)}, null, null, null);
            boolean z3 = query != null && query.getCount() > 0;
            if (query != null) {
                try {
                    query.close();
                } catch (Exception unused) {
                }
            }
            String w3 = com.bytedance.sdk.component.utils.c.w(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(i4));
            contentValues.put("value", w3);
            if (z3) {
                com.bytedance.sdk.openadsdk.core.multipro.c.c.update(ls.getContext(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i4)});
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.c.c.insert(ls.getContext(), "setting_global_info", contentValues);
            }
        }
    }

    public static Map<String, String> c(String str) throws JSONException {
        HashMap hashMap;
        JSONObject w3 = w(str);
        HashMap hashMap2 = null;
        if (w3 == null) {
            return null;
        }
        String optString = w3.optString("ext");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            hashMap = new HashMap();
        } catch (Exception unused) {
        }
        try {
            JSONObject optJSONObject = new JSONObject(optString).optJSONObject("headers");
            if (optJSONObject == null) {
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
            return hashMap;
        } catch (Exception unused2) {
            hashMap2 = hashMap;
            return hashMap2;
        }
    }

    public static void w(int i4, String str) {
        if (c()) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            try {
                String w3 = com.bytedance.sdk.component.utils.c.w(str);
                com.bytedance.sdk.openadsdk.core.multipro.c.c.c(ls.getContext(), "INSERT OR REPLACE INTO setting_base_info (_id, value) VALUES (" + i4 + ", '" + w3 + "')");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void c(JSONObject jSONObject, String str) throws JSONException {
        JSONObject w3 = w(str);
        if (w3 == null) {
            return;
        }
        String optString = w3.optString("aid");
        String optString2 = w3.optString(BidResponsedEx.KEY_CID);
        String optString3 = w3.optString("ext");
        if (!TextUtils.isEmpty(optString)) {
            jSONObject.put("ad_id", optString);
        }
        if (!TextUtils.isEmpty(optString2)) {
            jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, optString2);
        }
        if (TextUtils.isEmpty(optString3)) {
            return;
        }
        jSONObject.put("ext", optString3);
    }

    public static void c(String str, JSONObject jSONObject) {
        if (c()) {
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                Cursor query = com.bytedance.sdk.openadsdk.core.multipro.c.c.query(ls.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
                boolean z3 = query != null && query.getCount() > 0;
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable unused) {
                    }
                }
                JSONObject c4 = com.bytedance.sdk.component.utils.c.c(jSONObject);
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", str);
                contentValues.put("value", c4.toString());
                if (z3) {
                    com.bytedance.sdk.openadsdk.core.multipro.c.c.update(ls.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
                    return;
                } else {
                    com.bytedance.sdk.openadsdk.core.multipro.c.c.insert(ls.getContext(), "setting_rit", contentValues);
                    return;
                }
            }
            String str2 = f36301c;
            a.w(str2, "insert -- key:" + str + "; value:" + jSONObject);
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (c()) {
            String f4 = wVar.f();
            if (xv(f4)) {
                a.w(f36301c, "updateSlot start");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("img_width", wVar.ev());
                    jSONObject.put("img_height", wVar.gd());
                    jSONObject.put("express_width", wVar.p());
                    jSONObject.put("express_height", wVar.k());
                    jSONObject.put("ad_count", wVar.t());
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", f4);
                contentValues.put(InAppSlotParams.SLOT_KEY.SLOT, com.bytedance.sdk.component.utils.c.w(jSONObject.toString()));
                com.bytedance.sdk.openadsdk.core.multipro.c.c.update(ls.getContext(), "setting_rit", contentValues, "rit=?", new String[]{f4});
            }
        }
    }
}
