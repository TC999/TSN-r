package com.mbridge.msdk.videocommon.b;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Reward.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private String f40945a;

    /* renamed from: b  reason: collision with root package name */
    private int f40946b;

    public d(String str, int i4) {
        this.f40945a = str;
        this.f40946b = i4;
    }

    private static d c() {
        return new d("Virtual Item", 1);
    }

    public final String a() {
        return this.f40945a;
    }

    public final int b() {
        return this.f40946b;
    }

    public final String toString() {
        return "Reward{name='" + this.f40945a + "', amount=" + this.f40946b + '}';
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[Catch: Exception -> 0x002f, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:3:0x0001, B:5:0x000f, B:12:0x002a, B:8:0x0017, B:10:0x001d), top: B:17:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.mbridge.msdk.videocommon.b.d b(java.lang.String r3) {
        /*
            r0 = 0
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch: java.lang.Exception -> L2f
            com.mbridge.msdk.videocommon.d.a r1 = r1.b()     // Catch: java.lang.Exception -> L2f
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L2f
            if (r2 == 0) goto L15
            com.mbridge.msdk.videocommon.b.d r3 = c()     // Catch: java.lang.Exception -> L2f
        L13:
            r0 = r3
            goto L28
        L15:
            if (r1 == 0) goto L28
            java.util.Map r2 = r1.j()     // Catch: java.lang.Exception -> L2f
            if (r2 == 0) goto L28
            java.util.Map r1 = r1.j()     // Catch: java.lang.Exception -> L2f
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Exception -> L2f
            com.mbridge.msdk.videocommon.b.d r3 = (com.mbridge.msdk.videocommon.b.d) r3     // Catch: java.lang.Exception -> L2f
            goto L13
        L28:
            if (r0 != 0) goto L33
            com.mbridge.msdk.videocommon.b.d r0 = c()     // Catch: java.lang.Exception -> L2f
            goto L33
        L2f:
            r3 = move-exception
            r3.printStackTrace()
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.b.d.b(java.lang.String):com.mbridge.msdk.videocommon.b.d");
    }

    public final void a(String str) {
        this.f40945a = str;
    }

    public final void a(int i4) {
        this.f40946b = i4;
    }

    public static Map<String, d> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                hashMap.put(optJSONObject.optString("id"), new d(optJSONObject.optString("name"), optJSONObject.optInt(RewardPlus.AMOUNT)));
            }
            return hashMap;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("name");
                int optInt = jSONObject.optInt(RewardPlus.AMOUNT);
                jSONObject.optString("id");
                return new d(optString, optInt);
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
