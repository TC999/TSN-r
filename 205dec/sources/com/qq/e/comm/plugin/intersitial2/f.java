package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.g0.v;
import com.qq.e.comm.plugin.util.i0;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements UIADI, com.qq.e.comm.plugin.e0.b, ApkDownloadComplianceInterface, com.qq.e.comm.plugin.e0.a, com.qq.e.comm.plugin.h.f {

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.intersitial2.a f44434c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.intersitial2.h f44435d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.intersitial2.j.b f44436e;

    /* renamed from: f  reason: collision with root package name */
    private final ADListener f44437f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f44438g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f44439h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f44440i;

    /* renamed from: j  reason: collision with root package name */
    private String f44441j;

    /* renamed from: k  reason: collision with root package name */
    private final com.qq.e.comm.plugin.h.e f44442k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f44443l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends com.qq.e.comm.plugin.h.d<Void> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ADListener f44444b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(f fVar, com.qq.e.comm.plugin.h.f fVar2, ADListener aDListener) {
            super(fVar2);
            this.f44444b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            ADListener aDListener = this.f44444b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(304, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends com.qq.e.comm.plugin.h.d<Integer> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ADListener f44445b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f fVar, com.qq.e.comm.plugin.h.f fVar2, ADListener aDListener) {
            super(fVar2);
            this.f44445b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            ADListener aDListener = this.f44445b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(101, num));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.adview.video.a> {
        c(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.adview.video.a aVar) {
            if (f.this.f44437f != null) {
                ADListener aDListener = f.this.f44437f;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(aVar == null ? 5002 : aVar.b());
                aDListener.onADEvent(new ADEvent(207, objArr));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d extends com.qq.e.comm.plugin.h.d<Void> {
        d(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            if (f.this.f44437f != null) {
                f.this.f44437f.onADEvent(new ADEvent(209, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e extends com.qq.e.comm.plugin.h.d<Integer> {
        e(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            if (num == null) {
                num = -1;
            }
            if (f.this.f44437f != null) {
                f.this.f44437f.onADEvent(new ADEvent(210, num));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.intersitial2.f$f  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0850f extends com.qq.e.comm.plugin.h.d<Void> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f44449b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f44450c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0850f(com.qq.e.comm.plugin.h.f fVar, com.qq.e.comm.plugin.n0.c cVar, long j4) {
            super(fVar);
            this.f44449b = cVar;
            this.f44450c = j4;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r5) {
            i0.d(this.f44449b, System.currentTimeMillis() - this.f44450c);
            if (f.this.f44437f != null) {
                f.this.f44437f.onADEvent(new ADEvent(202, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g extends com.qq.e.comm.plugin.h.d<Boolean> {
        g(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Boolean bool) {
            if (f.this.f44437f != null) {
                f.this.f44437f.onADEvent(new ADEvent(202, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class h extends com.qq.e.comm.plugin.h.d<Void> {
        h(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            if (f.this.f44437f != null) {
                f.this.f44437f.onADEvent(new ADEvent(204, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class i extends com.qq.e.comm.plugin.h.d<Void> {
        i(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            if (f.this.f44437f != null) {
                f.this.f44437f.onADEvent(new ADEvent(206, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class j implements s {
        j() {
        }

        @Override // com.qq.e.comm.plugin.intersitial2.f.s
        public void a(boolean z3) {
            f.this.f44439h = z3;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class k implements s {
        k() {
        }

        @Override // com.qq.e.comm.plugin.intersitial2.f.s
        public void a(boolean z3) {
            f.this.f44439h = z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class l extends com.qq.e.comm.plugin.h.d<Void> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ADListener f44457b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(f fVar, com.qq.e.comm.plugin.h.f fVar2, ADListener aDListener) {
            super(fVar2);
            this.f44457b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            ADListener aDListener = this.f44457b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(102, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class m extends com.qq.e.comm.plugin.h.d<Void> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ADListener f44458b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s f44459c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(f fVar, com.qq.e.comm.plugin.h.f fVar2, ADListener aDListener, s sVar) {
            super(fVar2);
            this.f44458b = aDListener;
            this.f44459c = sVar;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r5) {
            ADListener aDListener = this.f44458b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(103, new Object[0]));
            }
            s sVar = this.f44459c;
            if (sVar != null) {
                sVar.a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class n extends com.qq.e.comm.plugin.h.d<Void> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ADListener f44460b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(f fVar, com.qq.e.comm.plugin.h.f fVar2, ADListener aDListener) {
            super(fVar2);
            this.f44460b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            ADListener aDListener = this.f44460b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(105, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class o extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.i.f> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ADListener f44461b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(f fVar, com.qq.e.comm.plugin.h.f fVar2, ADListener aDListener) {
            super(fVar2);
            this.f44461b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.i.f fVar) {
            ADListener aDListener = this.f44461b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(105, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class p extends com.qq.e.comm.plugin.h.d<Void> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ADListener f44462b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(f fVar, com.qq.e.comm.plugin.h.f fVar2, ADListener aDListener) {
            super(fVar2);
            this.f44462b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            ADListener aDListener = this.f44462b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(106, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class q extends com.qq.e.comm.plugin.h.d<Void> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ADListener f44463b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(f fVar, com.qq.e.comm.plugin.h.f fVar2, ADListener aDListener) {
            super(fVar2);
            this.f44463b = aDListener;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            ADListener aDListener = this.f44463b;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(303, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class r extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.rewardvideo.m> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ADListener f44464b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f44465c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.intersitial2.j.b f44466d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(f fVar, com.qq.e.comm.plugin.h.f fVar2, ADListener aDListener, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.intersitial2.j.b bVar) {
            super(fVar2);
            this.f44464b = aDListener;
            this.f44465c = eVar;
            this.f44466d = bVar;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.rewardvideo.m mVar) {
            if (this.f44464b != null) {
                this.f44464b.onADEvent(new ADEvent(104, com.qq.e.comm.plugin.rewardvideo.q.b(com.qq.e.comm.plugin.rewardvideo.q.b(this.f44465c.K0()))));
            }
            com.qq.e.comm.plugin.rewardvideo.q.a(this.f44465c, mVar, this.f44466d.f());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface s {
        void a(boolean z3);
    }

    public f(Activity activity, String str, String str2, String str3, ADListener aDListener) {
        this(activity, str, str2, str3, com.qq.e.comm.plugin.b.l.f42027d, aDListener);
    }

    private boolean r() {
        if (this.f44438g) {
            return this.f44436e.r();
        }
        return this.f44435d.r();
    }

    public boolean b() {
        return this.f44435d.o();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void close() {
        if (this.f44443l) {
            GDTLogger.w("\u5e7f\u544a\u5df2\u5173\u95ed\uff0cclose\u63a5\u53e3\u8c03\u7528\u65e0\u6548\uff0c\u8bf7\u786e\u8ba4\u662f\u5426\u60f3\u8c03\u7528\u7684\u662fUnifiedInterstitialAD#destroy?");
            return;
        }
        this.f44443l = true;
        if (this.f44438g) {
            this.f44436e.close();
        } else {
            this.f44435d.close();
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void destroy() {
        this.f44435d.destroy();
    }

    @Override // com.qq.e.comm.plugin.h.f
    public com.qq.e.comm.plugin.h.e g() {
        return this.f44442k;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getAdPatternType() {
        if (this.f44438g) {
            v d4 = this.f44434c.d();
            if (d4 == null) {
                return 0;
            }
            return TextUtils.isEmpty(d4.L0()) ? 4 : 2;
        }
        return this.f44435d.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        if (this.f44438g) {
            return this.f44436e.getApkInfoUrl();
        }
        return this.f44435d.getApkInfoUrl();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        if (this.f44438g) {
            return this.f44436e.getCompetitionFailureUrls();
        }
        return this.f44435d.getCompetitionFailureUrls();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        if (this.f44438g) {
            return this.f44436e.getCompetitionWinUrls();
        }
        return this.f44435d.getCompetitionWinUrls();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        com.qq.e.comm.plugin.g0.e d4 = this.f44438g ? this.f44436e.d() : this.f44435d.u();
        if (d4 == null) {
            return -1;
        }
        return d4.J();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        com.qq.e.comm.plugin.g0.e d4 = this.f44438g ? this.f44436e.d() : this.f44435d.u();
        if (d4 == null) {
            return null;
        }
        return d4.W0();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        com.qq.e.comm.plugin.g0.e d4 = this.f44438g ? this.f44436e.d() : this.f44435d.u();
        if (d4 != null) {
            return d4.R();
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        com.qq.e.comm.plugin.g0.e d4 = this.f44438g ? this.f44436e.d() : this.f44435d.u();
        if (d4 == null) {
            return -1;
        }
        return d4.h0();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getVideoDuration() {
        if (this.f44438g) {
            v d4 = this.f44436e.d();
            return (d4 == null ? 0 : d4.M0()) * 1000;
        }
        return this.f44435d.getVideoDuration();
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return false;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        if (r()) {
            this.f44439h = false;
        }
        return this.f44439h;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadAd() {
        this.f44438g = false;
        this.f44435d.loadAd();
        this.f44440i = false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadFullScreenAD() {
        this.f44434c.b();
        this.f44438g = true;
        this.f44436e.loadAd(com.qq.e.comm.plugin.d0.a.d().f().a("ilat", com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL.a()));
        this.f44440i = false;
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        com.qq.e.comm.plugin.util.r.b(i4, i5, str, this.f44441j, this.f44438g ? this.f44436e.d() : this.f44435d.u(), this.f44438g ? this.f44436e.m() : this.f44435d.m(), this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        com.qq.e.comm.plugin.util.r.a(i4, this.f44438g ? this.f44436e.d() : this.f44435d.u(), this.f44441j, this.f44438g ? this.f44436e.m() : this.f44435d.m(), this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        com.qq.e.comm.plugin.g0.e d4 = this.f44438g ? this.f44436e.d() : this.f44435d.u();
        if (d4 != null) {
            com.qq.e.comm.plugin.util.r.a(d4.q0(), i4);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        if (this.f44438g) {
            this.f44436e.setDownloadConfirmListener(downloadConfirmListener);
        } else {
            this.f44435d.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f44435d.setLoadAdParams(loadAdParams);
        this.f44436e.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMaxVideoDuration(int i4) {
        this.f44435d.setMaxVideoDuration(i4);
        this.f44436e.setMaxVideoDuration(i4);
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.f44435d.setMediationId(str);
        this.f44436e.setMediationId(str);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMinVideoDuration(int i4) {
        this.f44435d.setMinVideoDuration(i4);
        this.f44436e.setMinVideoDuration(i4);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f44436e.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoOption(VideoOption videoOption) {
        this.f44435d.setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show() {
        this.f44435d.show();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showFullScreenAD(Activity activity) {
        if (activity == null) {
            GDTLogger.e("showFullScreenAD\u9519\u8bef\uff0cActivity\u4e3a\u7a7a");
            return;
        }
        com.qq.e.comm.plugin.b.g gVar = com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN;
        com.qq.e.comm.plugin.n0.c m4 = this.f44436e.m();
        i0.a(m4);
        if (this.f44440i) {
            GDTLogger.e("showFullScreenAD\u9519\u8bef\uff0c\u540c\u4e00\u6761\u5e7f\u544a\u4e0d\u5141\u8bb8\u591a\u6b21\u5c55\u793a\uff0c\u8bf7\u518d\u6b21\u62c9\u53d6\u540e\u5c55\u793a");
            i0.a(m4, 4015);
        } else if (this.f44436e.d() == null) {
            GDTLogger.e("showFullScreenAD\u9519\u8bef\uff0c\u5e7f\u544a\u672a\u52a0\u8f7d");
            i0.a(m4, 4014);
        } else if (this.f44436e.r()) {
            i0.a(m4, 5012);
        } else {
            this.f44440i = true;
            a(activity, this.f44437f, new k(), (com.qq.e.comm.plugin.intersitial2.j.a) this.f44436e);
        }
    }

    public f(Activity activity, String str, String str2, String str3, com.qq.e.comm.plugin.b.l lVar, ADListener aDListener) {
        this.f44442k = new com.qq.e.comm.plugin.h.e();
        this.f44441j = str2;
        this.f44437f = aDListener;
        this.f44434c = new com.qq.e.comm.plugin.intersitial2.a(this, aDListener, str2, new j());
        this.f44435d = new com.qq.e.comm.plugin.intersitial2.h(activity, new ADSize(-1, -2), str, str2, str3, lVar, this.f44434c);
        this.f44436e = new com.qq.e.comm.plugin.intersitial2.j.a(activity, new ADSize(-1, -2), str, str2, str3, lVar, this.f44434c);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show(Activity activity) {
        this.f44435d.show(activity);
    }

    public int a() {
        return this.f44435d.h();
    }

    public void a(Activity activity, ADListener aDListener, s sVar, com.qq.e.comm.plugin.intersitial2.j.a aVar) {
        v u3 = aVar.u();
        a(u3, aDListener, sVar, aVar);
        a(u3, aVar.m());
        aVar.B();
        ((com.qq.e.comm.plugin.d0.b.b) com.qq.e.comm.plugin.d0.b.e.a(u3.l0(), com.qq.e.comm.plugin.d0.b.b.class)).a(this);
        com.qq.e.comm.plugin.fs.e.a.a((Context) activity, (com.qq.e.comm.plugin.g0.e) u3, false);
        i0.a(aVar.m(), System.currentTimeMillis() - aVar.f43794x);
        i0.a(aVar.m(), u3.e1(), !TextUtils.isEmpty(aVar.n()));
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        com.qq.e.comm.plugin.util.r.a(map, this.f44441j, this.f44438g ? this.f44436e.d() : this.f44435d.u(), this.f44438g ? this.f44436e.m() : this.f44435d.m(), this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        com.qq.e.comm.plugin.util.r.a(map, this.f44438g ? this.f44436e.d() : this.f44435d.u(), this.f44441j, this.f44438g ? this.f44436e.m() : this.f44435d.m(), this);
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar, ADListener aDListener, s sVar, com.qq.e.comm.plugin.intersitial2.j.b bVar) {
        FSCallback fSCallback = (FSCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), FSCallback.class);
        fSCallback.A().a(new l(this, this, aDListener));
        fSCallback.E().a(new m(this, this, aDListener, sVar));
        fSCallback.y().a(new n(this, this, aDListener));
        fSCallback.h().a(new o(this, this, aDListener));
        fSCallback.B().a(new p(this, this, aDListener));
        fSCallback.a().a(new q(this, this, aDListener));
        fSCallback.I().a(new r(this, this, aDListener, eVar, bVar));
        fSCallback.onComplainSuccess().a(new a(this, this, aDListener));
        fSCallback.G().a(new b(this, this, aDListener));
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.n0.c cVar) {
        VideoCallback videoCallback = (VideoCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), VideoCallback.class);
        videoCallback.m().a(new c(this));
        videoCallback.D().a(new d(this));
        videoCallback.c().a(new e(this));
        videoCallback.onStart().a(new C0850f(this, cVar, System.currentTimeMillis()));
        videoCallback.onResume().a(new g(this));
        videoCallback.onPause().a(new h(this));
        videoCallback.onComplete().a(new i(this));
    }
}
