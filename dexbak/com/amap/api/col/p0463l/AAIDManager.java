package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.v4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AAIDManager {

    /* renamed from: b */
    private static AAIDManager f5557b;

    /* renamed from: c */
    private static boolean f5558c;

    /* renamed from: d */
    private static boolean f5559d;

    /* renamed from: a */
    private Context f5560a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AAIDManager.java */
    /* renamed from: com.amap.api.col.3l.v4$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1970a extends ThreadTask {
        C1970a() {
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            AAIDManager.this.m53657d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AAIDManager.java */
    /* renamed from: com.amap.api.col.3l.v4$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1971b extends ThreadTask {
        C1971b() {
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            AAIDManager.this.m53655f();
        }
    }

    private AAIDManager(Context context) {
        this.f5560a = context;
    }

    /* renamed from: a */
    public static AAIDManager m53660a(Context context) {
        if (f5557b == null) {
            synchronized (AAIDManager.class) {
                if (f5557b == null) {
                    f5557b = new AAIDManager(context);
                }
            }
        }
        return f5557b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m53657d() {
        try {
            if (f5558c) {
                f5558c = false;
                return;
            }
            f5558c = true;
            AAIDCreateRequest aAIDCreateRequest = new AAIDCreateRequest(this.f5560a);
            new BaseNetManager();
            ResponseEntity m54173d = BaseNetManager.m54173d(aAIDCreateRequest);
            if (m54173d != null) {
                JSONObject jSONObject = new JSONObject(C1925p4.m54197g(AAIDKeyFactorUtil.m53797d(m54173d.f5682a, C1925p4.m54183u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    AAIDCache.m54128m(this.f5560a, aAIDCreateRequest.f5370j);
                    AAIDCache.m54126o(this.f5560a, aAIDCreateRequest.f5371k);
                    AAIDCache.m54124q(this.f5560a, aAIDCreateRequest.f5372p);
                    AAIDCache.m54122s(this.f5560a, aAIDCreateRequest.f5373q);
                    AAIDCache.m54120u(this.f5560a, aAIDCreateRequest.f5374r);
                    AAIDCache.m54118w(this.f5560a, aAIDCreateRequest.f5375s);
                    AAIDCache.m54116y(this.f5560a, aAIDCreateRequest.f5376t);
                    AAIDCache.m54136e(this.f5560a, aAIDCreateRequest.f5378v);
                    AAIDCache.m54142A(this.f5560a, aAIDCreateRequest.f5377u);
                    AAIDCache.m54139b(this.f5560a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        AAIDCache.m54134g(this.f5560a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        AAIDCache.m54130k(this.f5560a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        AAIDCache.m54132i(this.f5560a, optString3);
                    }
                }
            }
            f5558c = false;
        } catch (Throwable unused) {
            f5558c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m53655f() {
        try {
            if (f5559d) {
                f5559d = false;
                return;
            }
            f5559d = true;
            AAIDRemapRequest aAIDRemapRequest = new AAIDRemapRequest(this.f5560a);
            new BaseNetManager();
            ResponseEntity m54173d = BaseNetManager.m54173d(aAIDRemapRequest);
            if (m54173d != null) {
                JSONObject jSONObject = new JSONObject(C1925p4.m54197g(AAIDKeyFactorUtil.m53797d(m54173d.f5682a, C1925p4.m54183u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    AAIDCache.m54128m(this.f5560a, aAIDRemapRequest.f5621j);
                    AAIDCache.m54126o(this.f5560a, aAIDRemapRequest.f5622k);
                    AAIDCache.m54124q(this.f5560a, aAIDRemapRequest.f5623p);
                    AAIDCache.m54122s(this.f5560a, aAIDRemapRequest.f5624q);
                    AAIDCache.m54120u(this.f5560a, aAIDRemapRequest.f5625r);
                    AAIDCache.m54118w(this.f5560a, aAIDRemapRequest.f5626s);
                    AAIDCache.m54116y(this.f5560a, aAIDRemapRequest.f5627t);
                    AAIDCache.m54136e(this.f5560a, aAIDRemapRequest.f5629v);
                    AAIDCache.m54142A(this.f5560a, aAIDRemapRequest.f5628u);
                    AAIDCache.m54139b(this.f5560a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        AAIDCache.m54134g(this.f5560a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        AAIDCache.m54130k(this.f5560a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        AAIDCache.m54132i(this.f5560a, optString3);
                    }
                }
            }
            f5559d = false;
        } catch (Throwable unused) {
            f5559d = false;
        }
    }

    /* renamed from: b */
    public final String m53659b() {
        String str = "";
        try {
            if (AAIDConfig.f5175d) {
                str = AAIDCache.m54135f(this.f5560a);
                long m54133h = AAIDCache.m54133h(this.f5560a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (TextUtils.isEmpty(str)) {
                    ThreadPool.m53398h().m55654b(new C1970a());
                } else if (elapsedRealtime - m54133h > AAIDConfig.f5173b) {
                    ThreadPool.m53398h().m55654b(new C1971b());
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }
}
