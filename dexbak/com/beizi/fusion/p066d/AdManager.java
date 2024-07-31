package com.beizi.fusion.p066d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p068e.p069a.DevicesIDsHelper;
import com.beizi.fusion.p072g.AdvertisingIdClient;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3145h;
import com.beizi.fusion.p072g.CrashHandler;
import com.beizi.fusion.p072g.OaidUtil;
import com.beizi.fusion.p072g.PersonalizedUtil;
import com.beizi.fusion.p072g.StringUtil;
import com.beizi.fusion.update.HeartScheduler;
import com.stub.StubApp;

/* renamed from: com.beizi.fusion.d.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdManager {

    /* renamed from: a */
    public static String f11052a = null;

    /* renamed from: b */
    public static String f11053b = "";

    /* renamed from: c */
    private static String f11054c = "AdManager";

    /* renamed from: d */
    private static AdManager f11055d;

    /* renamed from: e */
    private static String f11056e;

    /* renamed from: j */
    private static String f11057j;

    /* renamed from: k */
    private static String f11058k;

    /* renamed from: f */
    private Context f11059f;

    /* renamed from: h */
    private HeartScheduler f11061h;

    /* renamed from: i */
    private ObserverAdStatus f11062i;

    /* renamed from: g */
    private boolean f11060g = false;

    /* renamed from: l */
    private boolean f11063l = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m48775h() {
        CrashHandler.m48227a().m48226a(this.f11059f);
        ResponseInfo.getInstance(this.f11059f).init();
        this.f11062i.f10958a.m48970a(1);
        HeartScheduler m48105a = HeartScheduler.m48105a(this.f11059f);
        this.f11061h = m48105a;
        m48105a.m48097b(0);
        if (!PersonalizedUtil.m48442b() || (!BeiZis.isLimitPersonalAds() && (BeiZis.getCustomController() == null || (BeiZis.getCustomController() != null && BeiZis.getCustomController().isCanUseOaid())))) {
            String str = (String) C3137at.m48313b(this.f11059f, "__OAID__", "");
            if (!TextUtils.isEmpty(str) && RequestInfo.getInstance(this.f11059f).getDevInfo() != null) {
                RequestInfo.getInstance(this.f11059f).getDevInfo().setOaid(str);
            }
            m48774i();
            m48773j();
        }
        if (!PersonalizedUtil.m48442b() || (!BeiZis.isLimitPersonalAds() && (BeiZis.getCustomController() == null || (BeiZis.getCustomController() != null && BeiZis.getCustomController().isCanUseGaid())))) {
            C3145h.m48264b().m48263c().execute(new Runnable() { // from class: com.beizi.fusion.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdvertisingIdClient.C3140a m48278a = AdvertisingIdClient.m48278a(AdManager.this.f11059f);
                        String m48277a = m48278a.m48277a();
                        boolean m48276b = m48278a.m48276b();
                        C3137at.m48315a(AdManager.this.f11059f, "__GAID__", (Object) m48277a);
                        C3137at.m48315a(AdManager.this.f11059f, "isLimitTrackGaid", Boolean.valueOf(m48276b));
                        if (!m48276b) {
                            RequestInfo.getInstance(AdManager.this.f11059f).getDevInfo().setGaid(m48277a);
                            String str2 = AdManager.f11054c;
                            C3116af.m48495b(str2, "advertising id is " + m48277a);
                        } else {
                            C3116af.m48495b(AdManager.f11054c, "User has opted not to use the advertising Id");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (this.f11062i.f10958a.m48971a() == 1) {
            this.f11062i.f10958a.m48970a(2);
        } else {
            Log.i("BeiZis", "init status error not kInitStatusBegin");
        }
    }

    /* renamed from: i */
    private void m48774i() {
        try {
            new DevicesIDsHelper(OaidUtil.f11266b).m48571a(this.f11059f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055 A[Catch: all -> 0x00c1, TryCatch #0 {all -> 0x00c1, blocks: (B:3:0x0004, B:5:0x0014, B:8:0x002b, B:16:0x0055, B:18:0x006f, B:20:0x0087, B:22:0x009e, B:24:0x00ad, B:25:0x00b7, B:14:0x004a), top: B:30:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e A[Catch: all -> 0x00c1, TryCatch #0 {all -> 0x00c1, blocks: (B:3:0x0004, B:5:0x0014, B:8:0x002b, B:16:0x0055, B:18:0x006f, B:20:0x0087, B:22:0x009e, B:24:0x00ad, B:25:0x00b7, B:14:0x004a), top: B:30:0x0004 }] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m48773j() {
        /*
            r10 = this;
            java.lang.String r0 = "0"
            java.lang.String r1 = "SM_STATUS"
            android.content.Context r2 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.model.ResponseInfo r2 = com.beizi.fusion.model.ResponseInfo.getInstance(r2)     // Catch: java.lang.Throwable -> Lc1
            java.lang.String r2 = r2.getSmFlag()     // Catch: java.lang.Throwable -> Lc1
            boolean r2 = r0.equals(r2)     // Catch: java.lang.Throwable -> Lc1
            if (r2 == 0) goto Lc5
            android.content.Context r2 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> Lc1
            java.lang.Object r2 = com.beizi.fusion.p072g.C3137at.m48313b(r2, r1, r4)     // Catch: java.lang.Throwable -> Lc1
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> Lc1
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> Lc1
            java.lang.String r4 = "SM_STATUS_EXPIRE_TIME"
            r5 = 3
            r6 = 1
            if (r2 != r6) goto L42
            android.content.Context r2 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.p072g.C3137at.m48315a(r2, r1, r7)     // Catch: java.lang.Throwable -> Lc1
            android.content.Context r2 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc1
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.p072g.C3137at.m48315a(r2, r4, r7)     // Catch: java.lang.Throwable -> Lc1
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
            android.content.Context r2 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.p072g.C3137at.m48315a(r2, r1, r8)     // Catch: java.lang.Throwable -> Lc1
        L53:
            if (r6 != r5) goto L9e
            android.content.Context r2 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            long r5 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lc1
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lc1
            java.lang.Object r2 = com.beizi.fusion.p072g.C3137at.m48313b(r2, r4, r5)     // Catch: java.lang.Throwable -> Lc1
            java.lang.Long r2 = (java.lang.Long) r2     // Catch: java.lang.Throwable -> Lc1
            long r5 = r2.longValue()     // Catch: java.lang.Throwable -> Lc1
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L9d
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc1
            long r7 = r2.longValue()     // Catch: java.lang.Throwable -> Lc1
            long r5 = r5 - r7
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> Lc1
            long r5 = r2.longValue()     // Catch: java.lang.Throwable -> Lc1
            r7 = 864000000(0x337f9800, double:4.26872718E-315)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L9d
            android.content.Context r2 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.p072g.C3137at.m48315a(r2, r1, r3)     // Catch: java.lang.Throwable -> Lc1
            android.content.Context r1 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            long r2 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lc1
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.p072g.C3137at.m48315a(r1, r4, r0)     // Catch: java.lang.Throwable -> Lc1
        L9d:
            return
        L9e:
            android.content.Context r0 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            android.app.Application r0 = (android.app.Application) r0     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.p073sm.p074a.DeviceIdentifier.m48135a(r0)     // Catch: java.lang.Throwable -> Lc1
            android.content.Context r0 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            boolean r0 = com.beizi.fusion.p073sm.p074a.DeviceID.m48149a(r0)     // Catch: java.lang.Throwable -> Lc1
            if (r0 == 0) goto Lb7
            android.content.Context r0 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.d.b$3 r2 = new com.beizi.fusion.d.b$3     // Catch: java.lang.Throwable -> Lc1
            r2.<init>()     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.p073sm.p074a.DeviceID.m48148a(r0, r2)     // Catch: java.lang.Throwable -> Lc1
        Lb7:
            android.content.Context r0 = r10.f11059f     // Catch: java.lang.Throwable -> Lc1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> Lc1
            com.beizi.fusion.p072g.C3137at.m48315a(r0, r1, r2)     // Catch: java.lang.Throwable -> Lc1
            goto Lc5
        Lc1:
            r0 = move-exception
            r0.printStackTrace()
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p066d.AdManager.m48773j():void");
    }

    /* renamed from: c */
    public String m48780c() {
        return f11057j;
    }

    /* renamed from: d */
    public String m48779d() {
        return f11058k;
    }

    /* renamed from: e */
    public Context m48778e() {
        return this.f11059f;
    }

    /* renamed from: f */
    public ObserverAdStatus m48777f() {
        return this.f11062i;
    }

    /* renamed from: a */
    public static AdManager m48786a() {
        if (f11055d == null) {
            synchronized (AdManager.class) {
                if (f11055d == null) {
                    f11055d = new AdManager();
                }
            }
        }
        return f11055d;
    }

    /* renamed from: b */
    public String m48782b() {
        return f11052a;
    }

    /* renamed from: a */
    public AdManager m48783a(String str) {
        f11056e = str;
        return f11055d;
    }

    /* renamed from: a */
    public void m48785a(Context context, String str, String str2, String str3) {
        synchronized (AdManager.class) {
            Log.e("BeiZis", "init start applicationCode：" + str);
            if (context != null) {
                if (!this.f11060g) {
                    String m48312a = StringUtil.m48312a();
                    f11053b = m48312a;
                    EventBean eventBean = new EventBean(m48312a, "", "", "", str, "", "", String.valueOf(System.currentTimeMillis()), "");
                    this.f11062i = new ObserverAdStatus(eventBean);
                    Log.d("BeiZis", "SDK_VERSION_MANAGER:4.90.4.5");
                    this.f11059f = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    f11052a = str;
                    f11057j = str2;
                    f11058k = str3;
                    ObserverAdStatus observerAdStatus = this.f11062i;
                    observerAdStatus.f10958a.addObserver(observerAdStatus);
                    this.f11062i.m48860a().m48980a(eventBean);
                    AppEventId.getInstance(this.f11059f).setAppStart();
                    AppEventId.getInstance(this.f11059f).setAppSdkInit();
                    if (this.f11062i.f10958a.m48971a() == 0) {
                        if (BeiZis.isIsSyncInit()) {
                            m48775h();
                        } else {
                            C3145h.m48264b().m48263c().execute(new Runnable() { // from class: com.beizi.fusion.d.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdManager.this.m48775h();
                                }
                            });
                        }
                        this.f11060g = true;
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
