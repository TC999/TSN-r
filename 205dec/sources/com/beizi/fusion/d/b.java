package com.beizi.fusion.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aj;
import com.beizi.fusion.g.ak;
import com.beizi.fusion.g.au;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.b;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f14591a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f14592b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f14593c = "AdManager";

    /* renamed from: d  reason: collision with root package name */
    private static b f14594d;

    /* renamed from: e  reason: collision with root package name */
    private static String f14595e;

    /* renamed from: j  reason: collision with root package name */
    private static String f14596j;

    /* renamed from: k  reason: collision with root package name */
    private static String f14597k;

    /* renamed from: f  reason: collision with root package name */
    private Context f14598f;

    /* renamed from: h  reason: collision with root package name */
    private com.beizi.fusion.update.b f14600h;

    /* renamed from: i  reason: collision with root package name */
    private com.beizi.fusion.b.d f14601i;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14599g = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14602l = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.beizi.fusion.g.r.a().a(this.f14598f);
        ResponseInfo.getInstance(this.f14598f).init();
        this.f14601i.f14492a.a(1);
        com.beizi.fusion.update.b a4 = com.beizi.fusion.update.b.a(this.f14598f);
        this.f14600h = a4;
        a4.b(0);
        if (!ak.b() || (!BeiZis.isLimitPersonalAds() && (BeiZis.getCustomController() == null || (BeiZis.getCustomController() != null && BeiZis.getCustomController().isCanUseOaid())))) {
            String str = (String) au.b(this.f14598f, "__OAID__", "");
            if (!TextUtils.isEmpty(str) && RequestInfo.getInstance(this.f14598f).getDevInfo() != null) {
                RequestInfo.getInstance(this.f14598f).getDevInfo().setOaid(str);
            }
            k();
            j();
        }
        if (!ak.b() || (!BeiZis.isLimitPersonalAds() && (BeiZis.getCustomController() == null || (BeiZis.getCustomController() != null && BeiZis.getCustomController().isCanUseGaid())))) {
            com.beizi.fusion.g.h.b().c().execute(new Runnable() { // from class: com.beizi.fusion.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.a a5 = com.beizi.fusion.g.b.a(b.this.f14598f);
                        String a6 = a5.a();
                        boolean b4 = a5.b();
                        au.a(b.this.f14598f, "__GAID__", (Object) a6);
                        au.a(b.this.f14598f, "isLimitTrackGaid", Boolean.valueOf(b4));
                        if (!b4) {
                            RequestInfo.getInstance(b.this.f14598f).getDevInfo().setGaid(a6);
                            String str2 = b.f14593c;
                            af.b(str2, "advertising id is " + a6);
                        } else {
                            af.b(b.f14593c, "User has opted not to use the advertising Id");
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        }
        if (this.f14601i.f14492a.a() == 1) {
            this.f14601i.f14492a.a(2);
        } else {
            Log.i("BeiZis", "init status error not kInitStatusBegin");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            new com.beizi.fusion.e.a.b(aj.f14805b).a(this.f14598f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055 A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:3:0x0004, B:5:0x0014, B:8:0x002b, B:16:0x0055, B:18:0x006f, B:20:0x0087, B:22:0x009e, B:24:0x00a6, B:25:0x00b0, B:14:0x004a), top: B:30:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:3:0x0004, B:5:0x0014, B:8:0x002b, B:16:0x0055, B:18:0x006f, B:20:0x0087, B:22:0x009e, B:24:0x00a6, B:25:0x00b0, B:14:0x004a), top: B:30:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j() {
        /*
            r10 = this;
            java.lang.String r0 = "0"
            java.lang.String r1 = "SM_STATUS"
            android.content.Context r2 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            com.beizi.fusion.model.ResponseInfo r2 = com.beizi.fusion.model.ResponseInfo.getInstance(r2)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r2 = r2.getSmFlag()     // Catch: java.lang.Throwable -> Lba
            boolean r2 = r0.equals(r2)     // Catch: java.lang.Throwable -> Lba
            if (r2 == 0) goto Lbe
            android.content.Context r2 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> Lba
            java.lang.Object r2 = com.beizi.fusion.g.au.b(r2, r1, r4)     // Catch: java.lang.Throwable -> Lba
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> Lba
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r4 = "SM_STATUS_EXPIRE_TIME"
            r5 = 3
            r6 = 1
            if (r2 != r6) goto L42
            android.content.Context r2 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Lba
            com.beizi.fusion.g.au.a(r2, r1, r7)     // Catch: java.lang.Throwable -> Lba
            android.content.Context r2 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lba
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> Lba
            com.beizi.fusion.g.au.a(r2, r4, r7)     // Catch: java.lang.Throwable -> Lba
            r2 = 3
        L42:
            r7 = 2
            if (r2 == 0) goto L4a
            if (r2 != r7) goto L48
            goto L4a
        L48:
            r6 = r2
            goto L53
        L4a:
            android.content.Context r2 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Lba
            com.beizi.fusion.g.au.a(r2, r1, r8)     // Catch: java.lang.Throwable -> Lba
        L53:
            if (r6 != r5) goto L9e
            android.content.Context r2 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            long r5 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lba
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lba
            java.lang.Object r2 = com.beizi.fusion.g.au.b(r2, r4, r5)     // Catch: java.lang.Throwable -> Lba
            java.lang.Long r2 = (java.lang.Long) r2     // Catch: java.lang.Throwable -> Lba
            long r5 = r2.longValue()     // Catch: java.lang.Throwable -> Lba
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L9d
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lba
            long r7 = r2.longValue()     // Catch: java.lang.Throwable -> Lba
            long r5 = r5 - r7
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lba
            long r5 = r2.longValue()     // Catch: java.lang.Throwable -> Lba
            r7 = 864000000(0x337f9800, double:4.26872718E-315)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L9d
            android.content.Context r2 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> Lba
            com.beizi.fusion.g.au.a(r2, r1, r3)     // Catch: java.lang.Throwable -> Lba
            android.content.Context r1 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            long r2 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lba
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lba
            com.beizi.fusion.g.au.a(r1, r4, r0)     // Catch: java.lang.Throwable -> Lba
        L9d:
            return
        L9e:
            android.content.Context r0 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            boolean r0 = com.beizi.fusion.sm.b.a.a(r0)     // Catch: java.lang.Throwable -> Lba
            if (r0 == 0) goto Lb0
            android.content.Context r0 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            com.beizi.fusion.d.b$3 r2 = new com.beizi.fusion.d.b$3     // Catch: java.lang.Throwable -> Lba
            r2.<init>()     // Catch: java.lang.Throwable -> Lba
            com.beizi.fusion.sm.b.a.a(r0, r2)     // Catch: java.lang.Throwable -> Lba
        Lb0:
            android.content.Context r0 = r10.f14598f     // Catch: java.lang.Throwable -> Lba
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> Lba
            com.beizi.fusion.g.au.a(r0, r1, r2)     // Catch: java.lang.Throwable -> Lba
            goto Lbe
        Lba:
            r0 = move-exception
            r0.printStackTrace()
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.d.b.j():void");
    }

    private void k() {
        try {
            if (Build.BRAND.equalsIgnoreCase("HONOR")) {
                String str = (String) au.b(this.f14598f, "__HONOROAID__", "");
                if (!TextUtils.isEmpty(str) && RequestInfo.getInstance(this.f14598f).getDevInfo() != null) {
                    RequestInfo.getInstance(this.f14598f).getDevInfo().setHonorOaid(str);
                }
                com.beizi.fusion.g.h.b().c().execute(new Runnable() { // from class: com.beizi.fusion.d.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        String a4 = com.beizi.fusion.sm.a.a.a(b.this.f14598f);
                        String str2 = b.f14593c;
                        Log.e(str2, "code honor Oaid:" + a4);
                        if (!TextUtils.isEmpty(a4)) {
                            au.a(b.this.f14598f, "__HONOROAID__", (Object) a4);
                        }
                        if (TextUtils.isEmpty(a4) || RequestInfo.getInstance(b.this.f14598f).getDevInfo() == null) {
                            return;
                        }
                        RequestInfo.getInstance(b.this.f14598f).getDevInfo().setHonorOaid(a4);
                    }
                });
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public String d() {
        return f14597k;
    }

    public Context e() {
        return this.f14598f;
    }

    public com.beizi.fusion.b.d f() {
        return this.f14601i;
    }

    public static b a() {
        if (f14594d == null) {
            synchronized (b.class) {
                if (f14594d == null) {
                    f14594d = new b();
                }
            }
        }
        return f14594d;
    }

    public String b() {
        return f14591a;
    }

    public String c() {
        return f14596j;
    }

    public b a(String str) {
        f14595e = str;
        return f14594d;
    }

    public void a(Context context, String str, String str2, String str3) {
        synchronized (b.class) {
            Log.e("BeiZis", "init start applicationCode\uff1a" + str);
            if (context != null) {
                if (!this.f14599g) {
                    String a4 = av.a();
                    f14592b = a4;
                    com.beizi.fusion.b.b bVar = new com.beizi.fusion.b.b(a4, "", "", "", str, "", "", String.valueOf(System.currentTimeMillis()), "");
                    this.f14601i = new com.beizi.fusion.b.d(bVar);
                    Log.d("BeiZis", "SDK_VERSION_MANAGER:4.90.4.11");
                    this.f14598f = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    f14591a = str;
                    f14596j = str2;
                    f14597k = str3;
                    com.beizi.fusion.b.d dVar = this.f14601i;
                    dVar.f14492a.addObserver(dVar);
                    this.f14601i.a().a(bVar);
                    AppEventId.getInstance(this.f14598f).setAppStart();
                    AppEventId.getInstance(this.f14598f).setAppSdkInit();
                    if (this.f14601i.f14492a.a() == 0) {
                        if (BeiZis.isIsSyncInit()) {
                            h();
                        } else {
                            com.beizi.fusion.g.h.b().c().execute(new Runnable() { // from class: com.beizi.fusion.d.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.h();
                                }
                            });
                        }
                        this.f14599g = true;
                    } else {
                        Log.i("BeiZis", "init status error not kInitStatusUnknown");
                    }
                }
                Log.e("BeiZis", "init end");
            } else {
                throw new IllegalArgumentException("Context cannot be null.");
            }
        }
    }
}
