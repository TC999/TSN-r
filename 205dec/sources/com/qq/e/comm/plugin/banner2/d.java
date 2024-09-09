package com.qq.e.comm.plugin.banner2;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.b.l;
import com.qq.e.comm.plugin.dl.i;
import com.qq.e.comm.plugin.l0.d;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d extends com.qq.e.comm.plugin.gdtnativead.g implements com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a {
    private volatile boolean A;
    private boolean B;
    private LoadAdParams C;

    /* renamed from: y  reason: collision with root package name */
    private volatile int f42094y;

    /* renamed from: z  reason: collision with root package name */
    private final Runnable f42095z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.A) {
                d dVar = d.this;
                dVar.loadAd(((com.qq.e.comm.plugin.gdtnativead.g) dVar).f43782l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f42097a;

        b(boolean z3) {
            this.f42097a = z3;
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(JSONObject jSONObject) {
            d.this.a(jSONObject, this.f42097a);
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            d1.a("LoadGDTNativeExpressADFail", bVar);
            d.this.b(bVar.a());
        }
    }

    static {
        i.a().b(com.qq.e.comm.plugin.b.g.UNIFIED_BANNER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener, l lVar) {
        super(context, aDSize, str, str2, lVar, aDListener, str3, com.qq.e.comm.plugin.b.g.UNIFIED_BANNER);
        this.f42094y = 30;
        this.f42095z = new a();
        this.A = true;
        this.C = null;
        this.B = com.qq.e.comm.plugin.d0.a.d().f().a("disbr", str2, 1) == 1;
    }

    private boolean s() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("ubulap", 1) == 1;
    }

    private void v() {
        if (this.f42094y == 0) {
            t();
        } else if (this.A) {
            if (this.f42094y >= 30 && this.f42094y <= 120) {
                p0.a(this.f42095z, this.f42094y * 1000);
            } else {
                p0.a(this.f42095z, PolicyConfig.mServerBusyRetryBaseInternal);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.gdtnativead.g
    public com.qq.e.comm.plugin.b.g c() {
        return com.qq.e.comm.plugin.b.g.UNIFIED_BANNER;
    }

    public void fetchAd() {
        u();
        loadAd(this.f43773c.a());
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        String[] competitionFailureUrls = super.getCompetitionFailureUrls();
        return (competitionFailureUrls == null || competitionFailureUrls.length <= 0) ? new String[0] : new String[]{competitionFailureUrls[0]};
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        String[] competitionWinUrls = super.getCompetitionWinUrls();
        return (competitionWinUrls == null || competitionWinUrls.length <= 0) ? new String[0] : new String[]{competitionWinUrls[0]};
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.g, com.qq.e.comm.pi.NEADI
    public void loadAd(int i4) {
        this.f43782l = i4;
        com.qq.e.comm.plugin.l0.b bVar = new com.qq.e.comm.plugin.l0.b(this.f43773c, this.f43776f);
        com.qq.e.comm.plugin.b.d a4 = a(i4);
        com.qq.e.comm.plugin.l0.d.a(a4, bVar, new b(a4.K()));
        v();
    }

    public void onWindowFocusChanged(boolean z3) {
        if (this.B) {
            if (z3) {
                u();
                v();
                return;
            }
            t();
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.C = loadAdParams;
    }

    public void setRefresh(int i4) {
        this.f42094y = i4;
    }

    public void t() {
        p0.e(this.f42095z);
        this.A = false;
    }

    public void u() {
        p0.e(this.f42095z);
        this.A = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.gdtnativead.g
    public com.qq.e.comm.plugin.b.d a(int i4) {
        com.qq.e.comm.plugin.b.d a4 = super.a(i4);
        a4.a(com.qq.e.comm.plugin.t.b.a(l()));
        LoadAdParams loadAdParams = this.C;
        if (loadAdParams != null) {
            a4.a(loadAdParams.getDevExtra());
            if (s()) {
                a4.c(loadAdParams.getLoginAppId());
                a4.a(loadAdParams.getLoginType());
                a4.d(loadAdParams.getLoginOpenid());
                a4.b(loadAdParams.getExtraInfo());
                d1.a("Banner 2.0: %s", loadAdParams);
            }
        }
        return a4;
    }
}
