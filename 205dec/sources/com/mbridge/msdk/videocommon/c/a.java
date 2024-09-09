package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import org.json.JSONObject;

/* compiled from: RewardSettingController.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40947a = "com.mbridge.msdk.videocommon.c.a";

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d A[Catch: all -> 0x0071, TRY_ENTER, TryCatch #0 {all -> 0x0071, blocks: (B:3:0x0022, B:5:0x0029, B:7:0x0050, B:11:0x005d, B:12:0x0061, B:16:0x006d, B:8:0x0055), top: B:22:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0061 A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:3:0x0022, B:5:0x0029, B:7:0x0050, B:11:0x005d, B:12:0x0061, B:16:0x006d, B:8:0x0055), top: B:22:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.content.Context r5, final java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.same.net.g.d r0 = new com.mbridge.msdk.foundation.same.net.g.d
            r0.<init>()
            java.lang.String r1 = "app_id"
            r0.a(r1, r6)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r7)
            java.lang.String r1 = "sign"
            r0.a(r1, r7)
            com.mbridge.msdk.videocommon.d.b.a()     // Catch: java.lang.Throwable -> L71
            com.mbridge.msdk.videocommon.d.a r7 = com.mbridge.msdk.videocommon.d.b.f40966a     // Catch: java.lang.Throwable -> L71
            if (r7 != 0) goto L55
            com.mbridge.msdk.foundation.a.a.a r7 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r1.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = "reward_"
            r1.append(r2)     // Catch: java.lang.Throwable -> L71
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.f()     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = r2.k()     // Catch: java.lang.Throwable -> L71
            r1.append(r2)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L71
            java.lang.String r7 = r7.b(r1)     // Catch: java.lang.Throwable -> L71
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L71
            if (r1 != 0) goto L55
            com.mbridge.msdk.videocommon.d.a r7 = com.mbridge.msdk.videocommon.d.a.a(r7)     // Catch: java.lang.Throwable -> L71
            goto L57
        L55:
            com.mbridge.msdk.videocommon.d.a r7 = com.mbridge.msdk.videocommon.d.b.f40966a     // Catch: java.lang.Throwable -> L71
        L57:
            java.lang.String r1 = ""
            java.lang.String r2 = "vtag"
            if (r7 != 0) goto L61
            r0.a(r2, r1)     // Catch: java.lang.Throwable -> L71
            goto L7b
        L61:
            java.lang.String r7 = r7.a()     // Catch: java.lang.Throwable -> L71
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L71
            if (r3 == 0) goto L6c
            goto L6d
        L6c:
            r1 = r7
        L6d:
            r0.a(r2, r1)     // Catch: java.lang.Throwable -> L71
            goto L7b
        L71:
            r7 = move-exception
            java.lang.String r1 = com.mbridge.msdk.videocommon.c.a.f40947a
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.x.d(r1, r7)
        L7b:
            com.mbridge.msdk.videocommon.c.a$1 r7 = new com.mbridge.msdk.videocommon.c.a$1
            r7.<init>()
            com.mbridge.msdk.videocommon.c.b r6 = new com.mbridge.msdk.videocommon.c.b
            r6.<init>(r5)
            r5 = 1
            com.mbridge.msdk.foundation.same.net.f.d r1 = com.mbridge.msdk.foundation.same.net.f.d.a()
            java.lang.String r1 = r1.f39581r
            r6.a(r5, r1, r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.c.a.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public final void a(Context context, final String str, String str2, String str3, final c cVar) {
        d dVar = new d();
        dVar.a("app_id", str);
        dVar.a("sign", SameMD5.getMD5(str + str2));
        dVar.a("unit_ids", "[" + str3 + "]");
        try {
            com.mbridge.msdk.videocommon.d.c c4 = com.mbridge.msdk.videocommon.d.b.a().c(str, str3);
            String str4 = "";
            if (c4 == null) {
                dVar.a("vtag", "");
            } else {
                String l4 = c4.l();
                if (!TextUtils.isEmpty(l4)) {
                    str4 = l4;
                }
                dVar.a("vtag", str4);
            }
        } catch (Throwable th) {
            x.d(f40947a, th.getMessage());
        }
        com.mbridge.msdk.foundation.same.net.g.c cVar2 = new com.mbridge.msdk.foundation.same.net.g.c() { // from class: com.mbridge.msdk.videocommon.c.a.2
            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(final JSONObject jSONObject) {
                try {
                    try {
                        com.mbridge.msdk.videocommon.d.b.a().a(this.f39551d);
                    } catch (Throwable th2) {
                        x.d(a.f40947a, th2.getMessage());
                        return;
                    }
                } catch (Exception e4) {
                    x.d(a.f40947a, e4.getMessage());
                }
                if (ac.a(jSONObject)) {
                    if (com.mbridge.msdk.videocommon.d.b.c(jSONObject.toString())) {
                        jSONObject.put("current_time", System.currentTimeMillis());
                        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.videocommon.c.a.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.mbridge.msdk.videocommon.d.b a4 = com.mbridge.msdk.videocommon.d.b.a();
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                a4.a(str, anonymousClass2.f39551d, jSONObject.toString());
                            }
                        };
                        if (com.mbridge.msdk.foundation.controller.b.a().d()) {
                            com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
                        } else {
                            runnable.run();
                        }
                        c cVar3 = cVar;
                        if (cVar3 != null) {
                            cVar3.a("request success");
                        }
                    } else {
                        c cVar4 = cVar;
                        if (cVar4 != null) {
                            cVar4.b("data error");
                        }
                    }
                    a.a(a.this, 1, "");
                    return;
                }
                com.mbridge.msdk.videocommon.d.b a4 = com.mbridge.msdk.videocommon.d.b.a();
                String str5 = str;
                String str6 = this.f39551d;
                String b4 = com.mbridge.msdk.foundation.a.a.a.a().b("reward_" + str5 + "_" + str6);
                if (TextUtils.isEmpty(b4)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(b4);
                jSONObject2.put("current_time", System.currentTimeMillis());
                a4.a(str5, str6, jSONObject2.toString());
            }

            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(String str5) {
                try {
                    com.mbridge.msdk.videocommon.d.b.a().a(this.f39551d);
                } catch (Exception e4) {
                    x.d(a.f40947a, e4.getMessage());
                }
                if (!TextUtils.isEmpty(str5)) {
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.b(str5);
                    }
                } else {
                    c cVar4 = cVar;
                    if (cVar4 != null) {
                        cVar4.b("request error");
                    }
                }
                a.a(a.this, 2, str5);
            }
        };
        cVar2.f39551d = str3;
        new b(context).a(1, com.mbridge.msdk.foundation.same.net.f.d.a().f39581r, dVar, cVar2);
    }

    static /* synthetic */ void a(a aVar, int i4, String str) {
        try {
            new com.mbridge.msdk.foundation.same.report.d(com.mbridge.msdk.foundation.controller.a.f().j()).a(i4, com.mbridge.msdk.foundation.same.net.f.d.a().f39572i, str, com.mbridge.msdk.foundation.same.net.f.d.a().f39571h ? com.mbridge.msdk.foundation.same.net.f.d.a().f39584u : com.mbridge.msdk.foundation.same.net.f.d.a().f39579p);
        } catch (Throwable th) {
            x.d(f40947a, th.getMessage());
        }
    }
}
