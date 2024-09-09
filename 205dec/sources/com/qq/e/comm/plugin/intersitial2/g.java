package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.x0;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import qa.fg.ck;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g extends com.qq.e.comm.plugin.e0.d.a<BaseInterstitialAd> implements UIADI {
    private static String D;
    private Set<BaseInterstitialAd> A;
    private x0 B;
    private com.qq.e.comm.plugin.b.g C;

    /* renamed from: t  reason: collision with root package name */
    private ADListener f44467t;

    /* renamed from: u  reason: collision with root package name */
    private BaseInterstitialAd f44468u;

    /* renamed from: v  reason: collision with root package name */
    private Activity f44469v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f44470w;

    /* renamed from: x  reason: collision with root package name */
    private VideoOption f44471x;

    /* renamed from: y  reason: collision with root package name */
    private int f44472y;

    /* renamed from: z  reason: collision with root package name */
    private int f44473z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f44474a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f44475b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseInterstitialAd f44476c;

        a(int i4, long j4, BaseInterstitialAd baseInterstitialAd) {
            this.f44474a = i4;
            this.f44475b = j4;
            this.f44476c = baseInterstitialAd;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent == null) {
                return;
            }
            int type = aDEvent.getType();
            if (type == 201) {
                if (g.this.f44468u == this.f44476c) {
                    if (g.this.f44467t != null) {
                        g.this.f44467t.onADEvent(aDEvent);
                        return;
                    }
                    return;
                }
                g.this.A.add(this.f44476c);
                return;
            }
            switch (type) {
                case 100:
                    g gVar = g.this;
                    gVar.a(gVar.C, this.f44474a, this.f44475b, (long) this.f44476c);
                    g.this.f(this.f44476c);
                    return;
                case 101:
                    g gVar2 = g.this;
                    gVar2.a(gVar2.C, this.f44474a, this.f44475b, (long) this.f44476c);
                    g.this.a((g) this.f44476c, aDEvent);
                    return;
                case 102:
                    g.this.f(this.f44476c, 70462);
                    if (g.this.f44467t != null) {
                        g.this.f44467t.onADEvent(aDEvent);
                        return;
                    }
                    return;
                case 103:
                    g.this.d(this.f44476c, 70432);
                    if (g.this.f44467t != null) {
                        g.this.f44467t.onADEvent(aDEvent);
                        return;
                    }
                    return;
                case 104:
                    g.this.e(this.f44476c, 70472);
                    if (g.this.f44467t != null) {
                        g.this.f44467t.onADEvent(aDEvent);
                        return;
                    }
                    return;
                case 105:
                    g.this.c(this.f44476c, 70442);
                    if (g.this.f44467t != null) {
                        g.this.f44467t.onADEvent(aDEvent);
                        return;
                    }
                    return;
                case 106:
                    g.this.B.b();
                    if (g.this.f44467t != null) {
                        g.this.f44467t.onADEvent(aDEvent);
                        return;
                    }
                    return;
                default:
                    switch (type) {
                        case 401:
                        case 402:
                        case 403:
                        case 404:
                        case 405:
                        case 406:
                            com.qq.e.comm.plugin.e0.d.g.a(aDEvent, g.D, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL, this.f44476c);
                            return;
                        case 407:
                            com.qq.e.comm.plugin.e0.d.g.a(this.f44476c, 1143007);
                            return;
                        default:
                            if (g.this.f44467t != null) {
                                g.this.f44467t.onADEvent(aDEvent);
                                return;
                            }
                            return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Activity activity, String str, String str2, ADListener aDListener) {
        super(activity, str2);
        this.f44471x = null;
        this.f44472y = -1;
        this.f44473z = -1;
        this.A = new HashSet();
        this.B = new x0();
        this.f44467t = aDListener;
        this.f44469v = activity;
        D = str2;
    }

    private void p() {
        ADListener aDListener = this.f44467t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(101, 5004));
        }
    }

    private void q() {
        ADListener aDListener = this.f44467t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(100, new Object[0]));
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void close() {
        this.B.b();
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            baseInterstitialAd.close();
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void destroy() {
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            baseInterstitialAd.destory();
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getAdPatternType() {
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            baseInterstitialAd.getAdPatternType();
            return 0;
        }
        return 0;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            return baseInterstitialAd.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            return c((g) baseInterstitialAd);
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getVideoDuration() {
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            return baseInterstitialAd.getVideoDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            return baseInterstitialAd.isValid();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadAd() {
        this.C = com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL;
        l();
        this.f44470w = false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadFullScreenAD() {
        this.C = com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN;
        l();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMaxVideoDuration(int i4) {
        this.f44473z = i4;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMinVideoDuration(int i4) {
        this.f44472y = i4;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            baseInterstitialAd.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoOption(VideoOption videoOption) {
        this.f44471x = videoOption;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show() {
        if (this.f44470w) {
            return;
        }
        this.B.a(this.f44469v);
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            ck.b(baseInterstitialAd, null);
        }
        this.f44470w = true;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showFullScreenAD(Activity activity) {
        this.B.a(activity);
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            ck.a(baseInterstitialAd, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public BaseInterstitialAd b(com.qq.e.comm.plugin.e0.e.d dVar) {
        if (dVar != null) {
            try {
                return b.a(dVar.e(), this.f44469v, dVar.b(), dVar.p(), dVar.j());
            } catch (Exception e4) {
                a(70452, dVar);
                d1.a(" throw exception", e4);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseInterstitialAd baseInterstitialAd, int i4) {
        baseInterstitialAd.setAdListener(new a(i4, System.currentTimeMillis(), baseInterstitialAd));
        int i5 = this.f44472y;
        if (i5 > 0) {
            baseInterstitialAd.setMinVideoDuration(i5);
        }
        int i6 = this.f44473z;
        if (i6 > 0) {
            baseInterstitialAd.setMaxVideoDuration(i6);
        }
        VideoOption videoOption = this.f44471x;
        if (videoOption != null) {
            baseInterstitialAd.setVideoOption(videoOption);
        }
        if (this.C == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            ck.a(baseInterstitialAd);
        } else {
            ck.b(baseInterstitialAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: b */
    public String d(BaseInterstitialAd baseInterstitialAd) {
        if (b()) {
            return baseInterstitialAd.getReqId();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show(Activity activity) {
        if (this.f44470w) {
            return;
        }
        this.B.a(activity);
        BaseInterstitialAd baseInterstitialAd = this.f44468u;
        if (baseInterstitialAd != null) {
            ck.b(baseInterstitialAd, activity);
        }
        this.f44470w = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public void e(BaseInterstitialAd baseInterstitialAd) {
        ADListener aDListener;
        a(this.C);
        this.f44468u = baseInterstitialAd;
        if (baseInterstitialAd != null) {
            q();
            if (!this.A.contains(this.f44468u) || (aDListener = this.f44467t) == null) {
                return;
            }
            aDListener.onADEvent(new ADEvent(201, new Object[0]));
            return;
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseInterstitialAd baseInterstitialAd, int i4, String str) {
        baseInterstitialAd.setPayload(str);
        b(baseInterstitialAd, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    public int a(BaseInterstitialAd baseInterstitialAd) {
        return baseInterstitialAd.getECPM();
    }
}
