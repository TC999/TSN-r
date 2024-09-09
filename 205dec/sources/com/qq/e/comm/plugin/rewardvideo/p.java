package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.e0.d.a;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import qa.fg.ck;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class p extends com.qq.e.comm.plugin.e0.d.a<BaseRewardAd> implements RVADI {

    /* renamed from: z  reason: collision with root package name */
    private static String f45988z;

    /* renamed from: t  reason: collision with root package name */
    private ADListener f45989t;

    /* renamed from: u  reason: collision with root package name */
    private BaseRewardAd f45990u;

    /* renamed from: v  reason: collision with root package name */
    private Map<BaseRewardAd, b> f45991v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f45992w;

    /* renamed from: x  reason: collision with root package name */
    private LoadAdParams f45993x;

    /* renamed from: y  reason: collision with root package name */
    private ServerSideVerificationOptions f45994y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f45995a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f45996b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseRewardAd f45997c;

        a(int i4, long j4, BaseRewardAd baseRewardAd) {
            this.f45995a = i4;
            this.f45996b = j4;
            this.f45997c = baseRewardAd;
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a(ADEvent aDEvent) {
            p.this.a(com.qq.e.comm.plugin.b.g.REWARDVIDEOAD, this.f45995a, this.f45996b, (long) this.f45997c);
            p.this.f(this.f45997c);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b() {
            p.this.c(this.f45997c, 70242);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c(ADEvent aDEvent) {
            p.this.a(com.qq.e.comm.plugin.b.g.REWARDVIDEOAD, this.f45995a, this.f45996b, (long) this.f45997c);
            p.this.a((p) this.f45997c, aDEvent);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d() {
            p.this.f(this.f45997c, 70262);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void e() {
            p.this.e(this.f45997c, 70272);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b(ADEvent aDEvent) {
            com.qq.e.comm.plugin.e0.d.g.a(aDEvent, p.f45988z, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD, this.f45997c);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d(ADEvent aDEvent) {
            if (p.this.f45989t != null) {
                p.this.f45989t.onADEvent(aDEvent);
            }
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a() {
            com.qq.e.comm.plugin.e0.d.g.a(this.f45997c, 1143007);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c() {
            p.this.d(this.f45997c, 70232);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private a.b f45999a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f46000b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f46001c = false;

        /* renamed from: d  reason: collision with root package name */
        private Queue<ADEvent> f46002d = new LinkedList();

        b(a.b bVar) {
            this.f45999a = bVar;
        }

        Queue<ADEvent> a() {
            return this.f46002d;
        }

        void b() {
            this.f46001c = true;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            a.b bVar;
            a.b bVar2;
            int type = aDEvent.getType();
            if (type == 100) {
                d1.a("RewardVideoADMediator, ad loaded", new Object[0]);
                this.f46002d.offer(aDEvent);
                a.b bVar3 = this.f45999a;
                if (bVar3 != null) {
                    bVar3.a(null);
                }
            } else if (type != 107) {
                switch (type) {
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                        if (this.f45999a != null) {
                            if (aDEvent.getType() == 103) {
                                this.f45999a.c();
                                break;
                            } else if (aDEvent.getType() == 105) {
                                this.f45999a.b();
                                break;
                            } else if (aDEvent.getType() == 104) {
                                this.f45999a.e();
                                break;
                            } else if (aDEvent.getType() == 102) {
                                this.f45999a.d();
                                break;
                            }
                        }
                        break;
                    default:
                        switch (type) {
                            case 401:
                            case 402:
                            case 403:
                            case 404:
                            case 405:
                            case 406:
                                this.f45999a.b(aDEvent);
                                return;
                            case 407:
                                this.f45999a.a();
                                return;
                        }
                }
                if (this.f46001c && (bVar2 = this.f45999a) != null) {
                    bVar2.d(aDEvent);
                }
                this.f46002d.offer(aDEvent);
            } else {
                a.b bVar4 = this.f45999a;
                if (bVar4 != null && !this.f46000b) {
                    this.f46000b = true;
                    bVar4.c(aDEvent);
                }
                if (this.f46001c && (bVar = this.f45999a) != null) {
                    bVar.d(aDEvent);
                }
                this.f46002d.offer(aDEvent);
            }
        }
    }

    public p(Context context, String str, String str2, ADListener aDListener) {
        super(context, str2);
        this.f45991v = new HashMap();
        this.f45992w = true;
        this.f45993x = null;
        this.f45994y = null;
        this.f45989t = aDListener;
        f45988z = str2;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        BaseRewardAd baseRewardAd = this.f45990u;
        if (baseRewardAd != null) {
            return baseRewardAd.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.RVADI
    @Deprecated
    public long getExpireTimestamp() {
        BaseRewardAd baseRewardAd = this.f45990u;
        if (baseRewardAd != null) {
            return baseRewardAd.getExpireTimestamp();
        }
        return 0L;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        BaseRewardAd baseRewardAd = this.f45990u;
        if (baseRewardAd != null) {
            return c((p) baseRewardAd);
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getRewardAdType() {
        BaseRewardAd baseRewardAd = this.f45990u;
        if (baseRewardAd != null) {
            return baseRewardAd.getRewardAdType();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getVideoDuration() {
        BaseRewardAd baseRewardAd = this.f45990u;
        if (baseRewardAd != null) {
            return baseRewardAd.getVideoDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public boolean hasShown() {
        BaseRewardAd baseRewardAd = this.f45990u;
        if (baseRewardAd != null) {
            return baseRewardAd.hasShown();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        BaseRewardAd baseRewardAd = this.f45990u;
        if (baseRewardAd != null) {
            return baseRewardAd.isValid();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void loadAD() {
        l();
    }

    protected void p() {
        ADListener aDListener = this.f45989t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(107, 5004));
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f45993x = loadAdParams;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f45994y = serverSideVerificationOptions;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setVolumeOn(boolean z3) {
        this.f45992w = z3;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD() {
        BaseRewardAd baseRewardAd = this.f45990u;
        if (baseRewardAd != null) {
            ck.a(baseRewardAd, (Activity) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public BaseRewardAd b(com.qq.e.comm.plugin.e0.e.d dVar) {
        if (dVar != null) {
            try {
                return com.qq.e.comm.plugin.rewardvideo.b.a(dVar.e(), this.f42772g, dVar.b(), dVar.p(), dVar.j());
            } catch (Exception e4) {
                a(70252, dVar);
                d1.a(" throw exception", e4);
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD(Activity activity) {
        BaseRewardAd baseRewardAd = this.f45990u;
        if (baseRewardAd != null) {
            ck.a(baseRewardAd, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: b */
    public String d(BaseRewardAd baseRewardAd) {
        if (b()) {
            return baseRewardAd.getReqId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseRewardAd baseRewardAd, int i4) {
        b bVar = new b(new a(i4, System.currentTimeMillis(), baseRewardAd));
        baseRewardAd.setAdListener(bVar);
        baseRewardAd.setVolumeOn(this.f45992w);
        baseRewardAd.setLoadAdParams(this.f45993x);
        baseRewardAd.setServerSideVerificationOptions(this.f45994y);
        this.f45991v.put(baseRewardAd, bVar);
        d1.a(baseRewardAd.getClass().getSimpleName() + " load Ad", new Object[0]);
        ck.a(baseRewardAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public void e(BaseRewardAd baseRewardAd) {
        b bVar;
        d1.a("RewardVideoADMediator, loadAdFinish " + baseRewardAd, new Object[0]);
        a(com.qq.e.comm.plugin.b.g.REWARDVIDEOAD);
        this.f45990u = baseRewardAd;
        if (baseRewardAd != null) {
            if (this.f45989t == null || (bVar = this.f45991v.get(baseRewardAd)) == null) {
                return;
            }
            bVar.b();
            for (ADEvent aDEvent : bVar.a()) {
                d1.a("RewardVideoADMediator, loadAdFinish " + aDEvent.getType(), new Object[0]);
                this.f45989t.onADEvent(aDEvent);
            }
            return;
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseRewardAd baseRewardAd, int i4, String str) {
        baseRewardAd.setPayload(str);
        b(baseRewardAd, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    public int a(BaseRewardAd baseRewardAd) {
        return baseRewardAd.getECPM();
    }
}
