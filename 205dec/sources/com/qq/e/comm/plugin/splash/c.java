package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.e0.d.a;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseSplashAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import qa.fg.ck;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c extends com.qq.e.comm.plugin.e0.d.a<BaseSplashAd> implements NSPVI {
    private static String D;
    private Map<BaseSplashAd, C0890c> A;
    private int B;
    private byte[] C;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup f46031t;

    /* renamed from: u  reason: collision with root package name */
    private View f46032u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f46033v;

    /* renamed from: w  reason: collision with root package name */
    private int f46034w;

    /* renamed from: x  reason: collision with root package name */
    private LoadAdParams f46035x;

    /* renamed from: y  reason: collision with root package name */
    private ADListener f46036y;

    /* renamed from: z  reason: collision with root package name */
    private BaseSplashAd f46037z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f46038a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f46039b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseSplashAd f46040c;

        a(int i4, long j4, BaseSplashAd baseSplashAd) {
            this.f46038a = i4;
            this.f46039b = j4;
            this.f46040c = baseSplashAd;
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a(ADEvent aDEvent) {
            c.this.a(com.qq.e.comm.plugin.b.g.SPLASH, this.f46038a, this.f46039b, (long) this.f46040c);
            c.this.f(this.f46040c);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b() {
            c.this.c(this.f46040c, 70142);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c(ADEvent aDEvent) {
            c.this.a(com.qq.e.comm.plugin.b.g.SPLASH, this.f46038a, this.f46039b, (long) this.f46040c);
            c.this.a((c) this.f46040c, aDEvent);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d() {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d(ADEvent aDEvent) {
            if (c.this.f46036y != null) {
                c.this.f46036y.onADEvent(aDEvent);
            }
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void e() {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b(ADEvent aDEvent) {
            com.qq.e.comm.plugin.e0.d.g.a(aDEvent, c.D, com.qq.e.comm.plugin.b.g.SPLASH, this.f46040c);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a() {
            com.qq.e.comm.plugin.e0.d.g.a(this.f46040c, 1143007);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c() {
            c.this.d(this.f46040c, 70132);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f46036y.onADEvent(new ADEvent(101, 5004));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.splash.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class C0890c implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private a.b f46043a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f46044b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f46045c = false;

        /* renamed from: d  reason: collision with root package name */
        private Queue<ADEvent> f46046d = new LinkedList();

        C0890c(a.b bVar) {
            this.f46043a = bVar;
        }

        Queue<ADEvent> a() {
            return this.f46046d;
        }

        void b() {
            this.f46045c = true;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            a.b bVar;
            d1.a("SplashAdViewMediator type--" + aDEvent.getType(), new Object[0]);
            int type = aDEvent.getType();
            if (type == 100) {
                this.f46046d.offer(aDEvent);
                a.b bVar2 = this.f46043a;
                if (bVar2 != null) {
                    bVar2.a(aDEvent);
                }
            } else if (type == 101) {
                this.f46046d.offer(aDEvent);
                a.b bVar3 = this.f46043a;
                if (bVar3 != null && !this.f46044b) {
                    this.f46044b = true;
                    bVar3.c(aDEvent);
                }
                a.b bVar4 = this.f46043a;
                if (bVar4 == null || !this.f46045c) {
                    return;
                }
                bVar4.d(aDEvent);
            } else if (type != 103) {
                if (type != 105) {
                    switch (type) {
                        case 401:
                        case 402:
                        case 403:
                        case 404:
                        case 405:
                        case 406:
                            this.f46043a.b(aDEvent);
                            return;
                        case 407:
                            this.f46043a.a();
                            return;
                    }
                }
                a.b bVar5 = this.f46043a;
                if (bVar5 != null) {
                    bVar5.b();
                }
                if (this.f46045c && (bVar = this.f46043a) != null) {
                    bVar.d(aDEvent);
                }
                this.f46046d.offer(aDEvent);
            } else {
                this.f46046d.offer(aDEvent);
                a.b bVar6 = this.f46043a;
                if (bVar6 == null || !this.f46045c) {
                    return;
                }
                bVar6.d(aDEvent);
                this.f46043a.c();
            }
        }
    }

    public c(Context context, String str, String str2) {
        super(context, str2);
        this.f46034w = -1;
        this.A = new HashMap();
        D = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseSplashAd baseSplashAd, int i4, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public BaseSplashAd b(com.qq.e.comm.plugin.e0.e.d dVar) {
        if (dVar != null) {
            try {
                return com.qq.e.comm.plugin.splash.a.a(dVar.e(), this.f42772g, dVar.b(), dVar.p(), dVar.j());
            } catch (Exception e4) {
                a(70152, dVar);
                d1.a(" throw exception", e4);
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        l();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        GDTLogger.w("\u6d41\u91cf\u5206\u914d\u4e0d\u652f\u6301fetchAndShowIn\u63a5\u53e3.");
        p();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAdOnly() {
        fetchAdOnly();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        fetchAndShowIn(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        BaseSplashAd baseSplashAd = this.f46037z;
        if (baseSplashAd != null) {
            return baseSplashAd.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        BaseSplashAd baseSplashAd = this.f46037z;
        if (baseSplashAd != null) {
            return c((c) baseSplashAd);
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public Bitmap getZoomOutBitmap() {
        BaseSplashAd baseSplashAd = this.f46037z;
        if (baseSplashAd != null) {
            baseSplashAd.getZoomOutBitmap();
            return null;
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        BaseSplashAd baseSplashAd = this.f46037z;
        if (baseSplashAd != null) {
            return baseSplashAd.isValid();
        }
        return false;
    }

    protected void p() {
        if (this.f46036y != null) {
            this.f42783r.post(new b());
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
        GDTLogger.w("\u6d41\u91cf\u5206\u914d\u4e0d\u652f\u6301preload\u63a5\u53e3");
        p();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        this.f46036y = aDListener;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(int i4) {
        this.B = i4;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i4) {
        this.f46034w = i4;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f46035x = loadAdParams;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        BaseSplashAd baseSplashAd = this.f46037z;
        if (baseSplashAd != null) {
            baseSplashAd.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    @Deprecated
    public void setSkipView(View view) {
        this.f46032u = view;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSupportZoomOut(boolean z3) {
        this.f46033v = z3;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) {
        this.f46031t = viewGroup;
        BaseSplashAd baseSplashAd = this.f46037z;
        if (baseSplashAd != null) {
            ck.a(baseSplashAd, viewGroup);
        } else {
            p();
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showFullScreenAd(ViewGroup viewGroup) {
        showAd(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void zoomOutAnimationFinish() {
        BaseSplashAd baseSplashAd = this.f46037z;
        if (baseSplashAd != null) {
            baseSplashAd.zoomOutAnimationFinish();
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(byte[] bArr) {
        this.C = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: b */
    public String d(BaseSplashAd baseSplashAd) {
        if (b()) {
            return baseSplashAd.getReqId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseSplashAd baseSplashAd, int i4) {
        C0890c c0890c = new C0890c(new a(i4, System.currentTimeMillis(), baseSplashAd));
        baseSplashAd.setADListener(c0890c);
        this.A.put(baseSplashAd, c0890c);
        int i5 = this.f46034w;
        if (i5 > 0) {
            baseSplashAd.setFetchDelay(i5);
        }
        View view = this.f46032u;
        if (view != null) {
            baseSplashAd.setSkipView(view);
        }
        LoadAdParams loadAdParams = this.f46035x;
        if (loadAdParams != null) {
            baseSplashAd.setLoadAdParams(loadAdParams);
        }
        int i6 = this.B;
        if (i6 != 0) {
            baseSplashAd.setDeveloperLogo(i6);
        }
        byte[] bArr = this.C;
        if (bArr != null) {
            baseSplashAd.setDeveloperLogo(bArr);
        }
        baseSplashAd.setSupportZoomOut(this.f46033v);
        ck.a(baseSplashAd);
        d1.a(baseSplashAd.getClass().getSimpleName() + " load Ad", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public void e(BaseSplashAd baseSplashAd) {
        C0890c c0890c;
        a(com.qq.e.comm.plugin.b.g.SPLASH);
        this.f46037z = baseSplashAd;
        if (baseSplashAd != null) {
            if (this.f46036y == null || (c0890c = this.A.get(baseSplashAd)) == null) {
                return;
            }
            c0890c.b();
            for (ADEvent aDEvent : c0890c.a()) {
                this.f46036y.onADEvent(aDEvent);
            }
            return;
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    public int a(BaseSplashAd baseSplashAd) {
        return baseSplashAd.getECPM();
    }
}
