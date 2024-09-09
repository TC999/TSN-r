package cn.jiguang.ac;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import cn.jpush.android.api.InAppSlotParams;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {
    private static JSONObject a(String str, boolean z3) {
        if (z3) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "1_0");
            jSONObject.put("s_type", str);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r8 != r1) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
        if (r1 == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        r5 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = cn.jiguang.ah.c.c(r9)
            boolean r1 = cn.jiguang.ah.c.b(r9)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = "OFF"
            java.lang.String r4 = "ON"
            r5 = 0
            java.lang.String r6 = "JWakeLocalState"
            r7 = 1
            if (r2 == 0) goto L1a
            if (r1 != 0) goto L39
        L18:
            r5 = 1
            goto L39
        L1a:
            boolean r2 = android.text.TextUtils.equals(r4, r0)
            if (r2 == 0) goto L23
            r2 = 0
        L21:
            r8 = 1
            goto L2e
        L23:
            boolean r2 = android.text.TextUtils.equals(r3, r0)
            if (r2 == 0) goto L2c
            r2 = 0
            r8 = 0
            goto L2e
        L2c:
            r2 = 1
            goto L21
        L2e:
            if (r2 != 0) goto L33
            if (r8 == r1) goto L39
            goto L18
        L33:
            java.lang.String r5 = "local wake state do not changed"
            cn.jiguang.w.a.b(r6, r5)
            r5 = r2
        L39:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "lastCacheWakeState:"
            r2.append(r8)
            r2.append(r0)
            java.lang.String r0 = ",userWakeupEnable:"
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = ",isNeedReport:"
            r2.append(r0)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            cn.jiguang.w.a.b(r6, r0)
            if (r5 == 0) goto L96
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L7c
            r0.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = "status"
            if (r1 == 0) goto L69
            goto L6a
        L69:
            r7 = 2
        L6a:
            r0.put(r2, r7)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = "aals"
            cn.jiguang.ah.d.a(r9, r0, r2)     // Catch: java.lang.Throwable -> L7c
            cn.jiguang.ah.d.a(r9, r0)     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L78
            r3 = r4
        L78:
            cn.jiguang.ah.c.o(r9, r3)     // Catch: java.lang.Throwable -> L7c
            goto L9b
        L7c:
            r9 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "report local wake state failed, error:"
            r0.append(r1)
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            cn.jiguang.w.a.f(r6, r9)
            goto L9b
        L96:
            java.lang.String r9 = "do not need report local wake state"
            cn.jiguang.w.a.b(r6, r9)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ac.c.a(android.content.Context):void");
    }

    public static void a(Context context, long j4, long j5) {
        try {
            if (System.currentTimeMillis() - j5 < j4) {
                cn.jiguang.w.a.b("JWakeLocalState", "not report component status business time, interval: " + j4);
                return;
            }
            HashMap<String, Boolean> b4 = b(context);
            JSONArray jSONArray = new JSONArray();
            JSONObject a4 = a("activity", b4.get("activity").booleanValue());
            if (a4 != null) {
                jSONArray = jSONArray.put(a4);
            }
            JSONObject a5 = a("service", b4.get("service").booleanValue());
            if (a5 != null) {
                jSONArray = jSONArray.put(a5);
            }
            JSONObject a6 = a("provider", b4.get("provider").booleanValue());
            if (a6 != null) {
                jSONArray = jSONArray.put(a6);
            }
            if (jSONArray.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray3 = new JSONArray();
                long currentTimeMillis = System.currentTimeMillis();
                jSONArray3.put(currentTimeMillis / 1000);
                jSONArray3.put((currentTimeMillis / 1000) + 1);
                jSONObject.put("duration", jSONArray3);
                jSONObject.put("statistics", jSONArray);
                jSONObject.put("c_type", "aacs");
                jSONArray2.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("slice_index", 1);
                jSONObject2.put("slice_count", 1);
                jSONObject2.put("data", jSONArray2);
                jSONObject2.put(InAppSlotParams.SLOT_KEY.SEQ, UUID.randomUUID().toString());
                cn.jiguang.ah.d.a(context, jSONObject2, "collect_statistic");
                cn.jiguang.ah.d.a(context, (Object) jSONObject2);
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakeLocalState", "reportWakeComponentsState failed, " + th.getMessage());
        }
    }

    private static HashMap<String, Boolean> b(Context context) {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName(packageName, "cn.jpush.android.service.DActivity");
        Intent intent2 = new Intent();
        intent2.setClassName(packageName, "cn.jpush.android.service.BActivity");
        boolean z3 = false;
        boolean a4 = cn.jiguang.af.a.a(context, packageName, intent, false) | cn.jiguang.af.a.a(context, packageName, intent2, false);
        hashMap.put("activity", Boolean.valueOf(a4));
        PackageManager packageManager = context.getPackageManager();
        Intent intent3 = new Intent();
        intent3.setPackage(packageName);
        intent3.setAction("cn.jpush.android.intent.DaemonService");
        ResolveInfo resolveService = packageManager.resolveService(intent3, 512);
        boolean z4 = resolveService != null && resolveService.serviceInfo.exported;
        hashMap.put("service", Boolean.valueOf(z4));
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(packageName + ".DownloadProvider", 512);
        if (resolveContentProvider != null && resolveContentProvider.exported) {
            z3 = true;
        }
        hashMap.put("provider", Boolean.valueOf(z3));
        cn.jiguang.w.a.b("JWakeLocalState", "check w component status, activity[" + a4 + "]-service[" + z4 + "]-provider[" + z3 + "]");
        return hashMap;
    }
}
