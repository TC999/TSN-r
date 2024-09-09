package com.mbridge.msdk.videocommon.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.videocommon.b.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardSettingManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f40968d;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f40969c = false;

    /* renamed from: e  reason: collision with root package name */
    private CopyOnWriteArrayList<String> f40970e = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, c> f40967b = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public static a f40966a = null;

    private b() {
    }

    public static b a() {
        if (f40968d == null) {
            synchronized (b.class) {
                if (f40968d == null) {
                    f40968d = new b();
                }
            }
        }
        return f40968d;
    }

    private void d(String str, String str2) {
        if (this.f40969c) {
            return;
        }
        this.f40969c = true;
        new com.mbridge.msdk.videocommon.c.a().a(com.mbridge.msdk.foundation.controller.a.f().j(), str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.mbridge.msdk.videocommon.d.a b() {
        /*
            r8 = this;
            com.mbridge.msdk.videocommon.d.a r0 = com.mbridge.msdk.videocommon.d.b.f40966a
            if (r0 != 0) goto La3
            com.mbridge.msdk.foundation.a.a.a r0 = com.mbridge.msdk.foundation.a.a.a.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "reward_"
            r1.append(r2)
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.f()
            java.lang.String r2 = r2.k()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.b(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L8c
            com.mbridge.msdk.videocommon.d.a r0 = com.mbridge.msdk.videocommon.d.a.a(r0)
            java.lang.String r1 = "RewardSettingManager"
            if (r0 == 0) goto L6b
            long r2 = r0.c()
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r0.h()
            long r6 = r6 + r2
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 <= 0) goto L6b
            boolean r2 = com.mbridge.msdk.foundation.tools.x.f39934c
            if (r2 == 0) goto L69
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "app setting nexttime is not ready  [settingNextRequestTime= "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = " currentTime = "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = "]"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.mbridge.msdk.foundation.tools.x.b(r1, r2)
        L69:
            r1 = 0
            goto L71
        L6b:
            java.lang.String r2 = "app setting timeout or not exists"
            com.mbridge.msdk.foundation.tools.x.b(r1, r2)
            r1 = 1
        L71:
            if (r1 != 0) goto L74
            return r0
        L74:
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.f()
            java.lang.String r0 = r0.k()
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.f()
            java.lang.String r1 = r1.l()
            r8.d(r0, r1)
            com.mbridge.msdk.videocommon.d.a r0 = r8.c()
            return r0
        L8c:
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.f()
            java.lang.String r0 = r0.k()
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.f()
            java.lang.String r1 = r1.l()
            r8.d(r0, r1)
            com.mbridge.msdk.videocommon.d.a r0 = r8.c()
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.d.b.b():com.mbridge.msdk.videocommon.d.a");
    }

    public final a c() {
        a aVar = new a();
        HashMap hashMap = new HashMap(5);
        hashMap.put("1", 1000);
        hashMap.put("9", 1000);
        hashMap.put("8", 1000);
        HashMap hashMap2 = new HashMap(3);
        hashMap2.put("1", new d("Virtual Item", 1));
        aVar.a(hashMap);
        aVar.b(hashMap2);
        aVar.a(43200L);
        aVar.b(5400L);
        aVar.c(3600L);
        aVar.d(3600L);
        aVar.e(5L);
        aVar.a(1);
        return aVar;
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f40970e.remove(str);
        } catch (Exception unused) {
        }
    }

    public final void a(String str, String str2, String str3, com.mbridge.msdk.videocommon.c.c cVar) {
        if (!TextUtils.isEmpty(str3) && !this.f40970e.contains(str3)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f40970e.add(str3);
            }
            new com.mbridge.msdk.videocommon.c.a().a(com.mbridge.msdk.foundation.controller.a.f().j(), str, str2, str3, cVar);
            return;
        }
        x.a("test_reward_unit_setting", "unitID: " + str3 + " is requesting");
    }

    public final c a(String str, String str2) {
        c cVar;
        String str3 = "reward_" + str + "_" + str2;
        if (f40967b.containsKey(str3)) {
            boolean z3 = false;
            try {
                cVar = f40967b.get(str3);
                try {
                    z3 = a(cVar);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                cVar = null;
            }
            if (z3) {
                a(str, com.mbridge.msdk.foundation.controller.a.f().l(), str2, null);
            }
            return cVar;
        }
        c c4 = c.c(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
        if (a(c4)) {
            a(str, com.mbridge.msdk.foundation.controller.a.f().l(), str2, null);
            return null;
        }
        f40967b.put(str3, c4);
        return c4;
    }

    public final void b(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a().a(com.mbridge.msdk.foundation.controller.a.f().k(), str, false);
        final String str2 = c.f40974a;
        if (TextUtils.isEmpty(str2) || !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str2))) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            e.a(j4, str2, str, 2, "alert url is exception ,url:" + str2);
            return;
        }
        H5DownLoadManager.getInstance().downloadH5Res(str2, new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.videocommon.d.b.1
            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onFailed(String str3, String str4) {
                e.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, str, 2, str4);
            }

            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onSuccess(String str3) {
                e.a(com.mbridge.msdk.foundation.controller.a.f().j(), str2, str, 1, "");
            }
        });
    }

    public static boolean c(String str) {
        JSONArray optJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (optJSONArray = new JSONObject(str).optJSONArray("unitSetting")) != null) {
                String optString = optJSONArray.optJSONObject(0).optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (optJSONArray.length() > 0) {
                    if (!TextUtils.isEmpty(optString)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final void b(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str, str2);
        f40966a = a.a(str2);
    }

    public final c c(String str, String str2) {
        String str3 = "reward_" + str + "_" + str2;
        if (f40967b.containsKey(str3)) {
            return f40967b.get(str3);
        }
        return c.c(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
    }

    public final c a(String str, String str2, boolean z3) {
        c cVar;
        String str3 = "reward_" + str + "_" + str2;
        if (f40967b.containsKey(str3)) {
            boolean z4 = false;
            try {
                cVar = f40967b.get(str3);
                try {
                    z4 = a(cVar);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                cVar = null;
            }
            if (z4) {
                a(str, com.mbridge.msdk.foundation.controller.a.f().l(), str2, null);
            }
            return cVar;
        }
        c c4 = c.c(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
        if (!a(c4)) {
            f40967b.put(str3, c4);
            return c4;
        } else if (c4 == null) {
            a(str, com.mbridge.msdk.foundation.controller.a.f().l(), str2, null);
            return b(z3);
        } else {
            return c4;
        }
    }

    private static c b(boolean z3) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.mbridge.msdk.videocommon.b.b(1, 15, null));
            cVar.a((List<com.mbridge.msdk.videocommon.b.b>) arrayList);
            cVar.n(1);
            cVar.m(1);
            cVar.o(1);
            cVar.s(1);
            cVar.a(1.0d);
            cVar.b(1.0d);
            cVar.t(2);
            cVar.p(2);
            cVar.q(1);
            cVar.r(1);
            cVar.i(3);
            cVar.j(80);
            cVar.k(100);
            cVar.l(0);
            cVar.h(2);
            cVar.f(-1);
            cVar.x(70);
            cVar.e(2);
            if (z3) {
                cVar.d(5);
            } else {
                cVar.d(-1);
            }
            cVar.c(0);
            cVar.b(0);
            cVar.g(1);
            cVar.u(1);
            cVar.a(0);
            cVar.w(3);
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            arrayList2.add(4);
            arrayList2.add(6);
            cVar.a(arrayList2);
            cVar.y(1);
            cVar.z(1);
            cVar.A(60);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return cVar;
    }

    private final boolean a(c cVar) {
        a b4 = b();
        if (b4 == null || cVar == null) {
            return true;
        }
        long d4 = b4.d();
        long currentTimeMillis = System.currentTimeMillis();
        long x3 = cVar.x() + d4;
        if (x3 > currentTimeMillis) {
            if (x.f39934c) {
                x.b("RewardSettingManager", "unit setting  nexttime is not ready  [settingNextRequestTime= " + x3 + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
            return false;
        }
        return true;
    }

    public final void a(String str, String str2, String str3) {
        String str4 = "reward_" + str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        f40967b.put(str4, c.c(str3));
    }

    public final void a(boolean z3) {
        this.f40969c = z3;
    }
}
