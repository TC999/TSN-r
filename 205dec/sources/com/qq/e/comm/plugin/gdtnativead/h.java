package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.e0.d.a;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class h extends com.qq.e.comm.plugin.e0.d.a<BaseNativeExpressAd> implements NEADI {
    private static String C;
    private ADSize A;
    private Map<BaseNativeExpressAd, b> B;

    /* renamed from: t  reason: collision with root package name */
    private ADListener f43804t;

    /* renamed from: u  reason: collision with root package name */
    private int f43805u;

    /* renamed from: v  reason: collision with root package name */
    private LoadAdParams f43806v;

    /* renamed from: w  reason: collision with root package name */
    private VideoOption f43807w;

    /* renamed from: x  reason: collision with root package name */
    private int f43808x;

    /* renamed from: y  reason: collision with root package name */
    private int f43809y;

    /* renamed from: z  reason: collision with root package name */
    private ServerSideVerificationOptions f43810z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f43811a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f43812b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseNativeExpressAd f43813c;

        a(int i4, long j4, BaseNativeExpressAd baseNativeExpressAd) {
            this.f43811a = i4;
            this.f43812b = j4;
            this.f43813c = baseNativeExpressAd;
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a(ADEvent aDEvent) {
            h.this.a(com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD, this.f43811a, this.f43812b, (long) this.f43813c);
            h.this.f(this.f43813c);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b() {
            h.this.c(this.f43813c, 70542);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c(ADEvent aDEvent) {
            h.this.a(com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD, this.f43811a, this.f43812b, (long) this.f43813c);
            h.this.a((h) this.f43813c, aDEvent);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d() {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d(ADEvent aDEvent) {
            if (h.this.f43804t != null) {
                h.this.f43804t.onADEvent(aDEvent);
            }
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void e() {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b(ADEvent aDEvent) {
            com.qq.e.comm.plugin.e0.d.g.a(aDEvent, h.C, com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD, this.f43813c);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a() {
            com.qq.e.comm.plugin.e0.d.g.a(this.f43813c, 1143007);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c() {
            h.this.d(this.f43813c, 70532);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private a.b f43815a;

        /* renamed from: b  reason: collision with root package name */
        private Queue<ADEvent> f43816b = new LinkedList();

        b(a.b bVar) {
            this.f43815a = bVar;
        }

        Queue<ADEvent> a() {
            return this.f43816b;
        }

        void b() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f43815a != null) {
                int type = aDEvent.getType();
                if (type == 100) {
                    this.f43816b.offer(aDEvent);
                    this.f43815a.a(aDEvent);
                } else if (type == 101) {
                    this.f43815a.c(aDEvent);
                } else if (type == 103) {
                    this.f43815a.c();
                    this.f43815a.d(aDEvent);
                } else if (type != 105) {
                    switch (type) {
                        case 401:
                        case 402:
                        case 403:
                        case 404:
                        case 405:
                        case 406:
                            this.f43815a.b(aDEvent);
                            return;
                        case 407:
                            this.f43815a.a();
                            return;
                        default:
                            this.f43815a.d(aDEvent);
                            return;
                    }
                } else {
                    this.f43815a.b();
                    this.f43815a.d(aDEvent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, ADSize aDSize, String str, String str2, ADListener aDListener) {
        super(context, str2);
        this.f43808x = -1;
        this.f43809y = -1;
        this.B = new HashMap();
        this.f43804t = aDListener;
        this.A = aDSize;
        C = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseNativeExpressAd baseNativeExpressAd, int i4, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public BaseNativeExpressAd b(com.qq.e.comm.plugin.e0.e.d dVar) {
        if (dVar != null) {
            try {
                return c.a(dVar.e(), this.A, this.f42772g, dVar.b(), dVar.p(), dVar.j());
            } catch (Exception unused) {
                a(70552, dVar);
                return null;
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i4) {
        this.f43805u = i4;
        this.f43806v = null;
        l();
    }

    protected void p() {
        ADListener aDListener = this.f43804t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(101, 5004));
        }
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMaxVideoDuration(int i4) {
        this.f43809y = i4;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMinVideoDuration(int i4) {
        this.f43808x = i4;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f43810z = serverSideVerificationOptions;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoOption(VideoOption videoOption) {
        this.f43807w = videoOption;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public void e(BaseNativeExpressAd baseNativeExpressAd) {
        a(com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD);
        if (baseNativeExpressAd != null) {
            baseNativeExpressAd.setECPMLevel(getECPMLevel());
            b bVar = this.B.get(baseNativeExpressAd);
            if (bVar == null || this.f43804t == null) {
                return;
            }
            bVar.b();
            Queue<ADEvent> a4 = bVar.a();
            if (a4 == null || a4.size() <= 0) {
                return;
            }
            for (ADEvent aDEvent : a4) {
                this.f43804t.onADEvent(aDEvent);
            }
            return;
        }
        p();
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i4, LoadAdParams loadAdParams) {
        this.f43805u = i4;
        this.f43806v = loadAdParams;
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: b */
    public String d(BaseNativeExpressAd baseNativeExpressAd) {
        if (b()) {
            return baseNativeExpressAd.getReqId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseNativeExpressAd baseNativeExpressAd, int i4) {
        int i5 = this.f43809y;
        if (i5 >= 0) {
            baseNativeExpressAd.setMaxVideoDuration(i5);
        }
        int i6 = this.f43808x;
        if (i6 >= 0) {
            baseNativeExpressAd.setMinVideoDuration(i6);
        }
        VideoOption videoOption = this.f43807w;
        if (videoOption != null) {
            baseNativeExpressAd.setVideoOption(videoOption);
        }
        ServerSideVerificationOptions serverSideVerificationOptions = this.f43810z;
        if (serverSideVerificationOptions != null) {
            baseNativeExpressAd.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
        b bVar = new b(new a(i4, System.currentTimeMillis(), baseNativeExpressAd));
        baseNativeExpressAd.setAdListener(bVar);
        this.B.put(baseNativeExpressAd, bVar);
        LoadAdParams loadAdParams = this.f43806v;
        if (loadAdParams == null) {
            baseNativeExpressAd.loadAD(this.f43805u);
        } else {
            baseNativeExpressAd.loadAD(this.f43805u, loadAdParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    public int a(BaseNativeExpressAd baseNativeExpressAd) {
        return baseNativeExpressAd.getECPM();
    }
}
