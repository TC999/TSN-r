package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.splash.m;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.r;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements NSPVI, com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a, com.qq.e.comm.plugin.splash.r.d<c0>, com.qq.e.comm.plugin.splash.r.f, com.qq.e.comm.plugin.splash.r.h, com.qq.e.comm.plugin.splash.r.c, com.qq.e.comm.plugin.splash.r.b, m.b {

    /* renamed from: o  reason: collision with root package name */
    private static final String f46057o;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f46058p;

    /* renamed from: c  reason: collision with root package name */
    private final h f46059c;

    /* renamed from: d  reason: collision with root package name */
    private final g f46060d;

    /* renamed from: e  reason: collision with root package name */
    private final i f46061e;

    /* renamed from: f  reason: collision with root package name */
    private final q f46062f;

    /* renamed from: g  reason: collision with root package name */
    private final f f46063g;

    /* renamed from: h  reason: collision with root package name */
    private final com.qq.e.comm.plugin.splash.d f46064h;

    /* renamed from: i  reason: collision with root package name */
    private final m f46065i;

    /* renamed from: j  reason: collision with root package name */
    private final l f46066j;

    /* renamed from: k  reason: collision with root package name */
    private c0 f46067k;

    /* renamed from: l  reason: collision with root package name */
    private long f46068l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f46069m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f46070n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0 b4 = e.this.f46059c.b();
            if (e.this.f46059c.f46100l == null || b4 == null) {
                return;
            }
            e.this.f46059c.f46100l.onADEvent(new ADEvent(100, Long.valueOf(e.this.f46059c.f46114z)));
            b4.h(e.this.f46068l);
            b4.d(System.currentTimeMillis());
            n.a(e.this.f46059c, e.this.f46069m, System.currentTimeMillis() - e.this.f46068l, e.f46058p);
            boolean unused = e.f46058p = false;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f46059c.f46100l != null) {
                e.this.f46059c.f46100l.onADEvent(new ADEvent(102, new Object[0]));
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f46059c.f46100l != null) {
                e.this.f46059c.f46100l.onADEvent(new ADEvent(103, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f46059c.f46100l != null) {
                e.this.f46059c.f46100l.onADEvent(new ADEvent(106, new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.splash.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0892e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f46075c;

        RunnableC0892e(int i4) {
            this.f46075c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46059c.f46100l.onADEvent(new ADEvent(101, Integer.valueOf(this.f46075c)));
        }
    }

    static {
        com.qq.e.comm.plugin.dl.i.a().b(com.qq.e.comm.plugin.b.g.SPLASH);
        f46057o = e.class.getSimpleName();
        f46058p = true;
    }

    public e(Context context, String str, String str2, String str3) {
        this(context, str, str2, str3, com.qq.e.comm.plugin.b.l.f42027d);
    }

    private void d(int i4) {
        if (this.f46066j.c()) {
            p0.a(new d(), i4);
            this.f46060d.b(3);
            n.b(this.f46059c);
            t();
        }
    }

    private boolean r() {
        return com.qq.e.comm.plugin.util.c.a(this.f46059c.f46114z);
    }

    private void t() {
        com.qq.e.comm.plugin.e.a.a().b(this.f46059c.f46112x);
        this.f46064h.a();
        this.f46063g.a();
        this.f46062f.a();
        this.f46061e.a();
        this.f46060d.a();
        this.f46065i.a();
        this.f46059c.a();
    }

    private c0 u() {
        if (this.f46067k == null) {
            this.f46067k = this.f46060d.b();
        }
        return this.f46067k;
    }

    private void w() {
        this.f46059c.e();
        this.f46065i.a(this.f46059c, this);
        this.f46060d.a(this.f46059c, this);
        this.f46061e.a(this.f46059c, this);
        this.f46062f.a(this.f46059c, this);
        this.f46063g.a(this.f46059c, this);
    }

    private void y() {
        if (this.f46066j.f()) {
            if (!this.f46070n && this.f46059c.b() != this.f46061e.c()) {
                this.f46059c.a(this.f46061e.c());
            }
            h hVar = this.f46059c;
            hVar.f46114z = com.qq.e.comm.plugin.util.c.b(hVar.b());
            boolean e4 = j.e();
            a aVar = new a();
            r.d(this.f46059c.f46091c, this);
            if (e4) {
                p0.b(aVar);
            } else {
                p0.a((Runnable) aVar);
            }
            h hVar2 = this.f46059c;
            if (hVar2.f46106r) {
                a(hVar2.f46105q, hVar2.f46107s);
            }
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        a(false, false, null);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        a(false, true, viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAdOnly() {
        a(true, false, null);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        a(true, true, viewGroup);
    }

    @Override // com.qq.e.comm.plugin.splash.r.h
    public String g() {
        return this.f46061e.d();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        c0 b4 = this.f46059c.b();
        if (b4 == null) {
            return null;
        }
        return b4.r();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        c0 b4 = this.f46059c.b();
        return b4 == null ? new String[0] : new String[]{b4.S()};
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        c0 b4 = this.f46059c.b();
        return b4 == null ? new String[0] : new String[]{b4.U0()};
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        c0 b4 = this.f46059c.b();
        if (b4 == null) {
            return -1;
        }
        return b4.J();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        c0 b4 = this.f46059c.b();
        return b4 == null ? "" : b4.W0();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        c0 b4 = this.f46059c.b();
        if (b4 != null) {
            return b4.R();
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        c0 b4 = this.f46059c.b();
        if (b4 == null) {
            return -1;
        }
        return b4.h0();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public Bitmap getZoomOutBitmap() {
        GDTLogger.e("\u6ce8\u610f\uff01\u5f00\u5c4fV+\u529f\u80fd\u5df2\u5e9f\u5f03\uff0c\u8c03\u7528\u4e0d\u751f\u6548");
        return null;
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void h() {
        o();
    }

    @Override // com.qq.e.comm.plugin.splash.m.b
    public void i() {
        b(true);
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return !r();
    }

    @Override // com.qq.e.comm.plugin.splash.r.h
    public void j() {
        if (this.f46066j.h()) {
            c0 b4 = this.f46059c.b();
            b4.c(this.f46059c.f46103o);
            com.qq.e.comm.plugin.e.a.a().a(this.f46059c.f46112x, b4);
            this.f46065i.e();
            p0.d(new b());
            n.a(this.f46059c, (Integer) null);
        }
    }

    @Override // com.qq.e.comm.plugin.splash.r.d
    public boolean k() {
        return this.f46066j.m();
    }

    @Override // com.qq.e.comm.plugin.splash.m.b
    public void l() {
        b(false);
    }

    @Override // com.qq.e.comm.plugin.splash.r.h
    public void n() {
        if (this.f46066j.b()) {
            this.f46063g.b();
            p0.d(new c());
            this.f46060d.b(2);
        }
    }

    @Override // com.qq.e.comm.plugin.splash.r.b
    public void o() {
        if (this.f46066j.k()) {
            this.f46065i.c();
            this.f46062f.e();
        }
    }

    @Override // com.qq.e.comm.plugin.splash.r.b
    public void p() {
        if (this.f46066j.k()) {
            this.f46065i.d();
            this.f46062f.i();
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
        g gVar = new g();
        gVar.a(this.f46059c, this);
        gVar.e();
        gVar.a();
    }

    @Override // com.qq.e.comm.plugin.splash.r.h
    public File q() {
        return this.f46061e.b();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        r.b(i4, i5, str, this.f46059c.f46091c, this.f46059c.b(), this.f46059c.c(), this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        r.a(i4, this.f46059c.b(), this.f46059c.f46091c, this.f46059c.c(), this);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        this.f46059c.f46100l = aDListener;
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        c0 b4 = this.f46059c.b();
        if (b4 != null) {
            r.a(b4.q0(), i4);
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(int i4) {
        if (i4 == 0) {
            return;
        }
        this.f46059c.f46101m = i4;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        c0 b4;
        if (downloadConfirmListener != null && (b4 = this.f46059c.b()) != null) {
            String e02 = b4.e0();
            GDTLogger.d("setDownloadConfirmListener splash trace id:" + e02 + " listener:" + downloadConfirmListener);
            com.qq.e.comm.plugin.b.j.b().a(e02, downloadConfirmListener);
            return;
        }
        GDTLogger.e("\u8bbe\u7f6e\u4e0b\u8f7d\u786e\u8ba4\u5f39\u7a97\u9519\u8bef\uff0clistener \u4e3a\u7a7a\u6216\u5e7f\u544a\u672a\u52a0\u8f7d");
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i4) {
        j.a(i4);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f46059c.f46098j = loadAdParams;
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.f46059c.f46097i = str;
        com.qq.e.comm.plugin.j0.b.a().a(str);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f46059c.A = serverSideVerificationOptions;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSkipView(View view) {
        GDTLogger.e("\u6ce8\u610f\uff01\u5f00\u5c4f\u81ea\u5b9a\u4e49\u8df3\u8fc7\u529f\u80fd\u5df2\u5e9f\u5f03\uff0c\u8c03\u7528\u4e0d\u751f\u6548");
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSupportZoomOut(boolean z3) {
        GDTLogger.e("\u6ce8\u610f\uff01\u5f00\u5c4fV+\u529f\u80fd\u5df2\u5e9f\u5f03\uff0c\u8c03\u7528\u4e0d\u751f\u6548");
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) {
        a(false, viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showFullScreenAd(ViewGroup viewGroup) {
        a(true, viewGroup);
    }

    public int v() {
        c0 b4 = this.f46059c.b();
        if (b4 == null) {
            return -1;
        }
        return b4.r0();
    }

    public boolean x() {
        c0 b4 = this.f46059c.b();
        if (b4 == null) {
            return false;
        }
        return b4.Y0();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void zoomOutAnimationFinish() {
        GDTLogger.e("\u6ce8\u610f\uff01\u5f00\u5c4fV+\u529f\u80fd\u5df2\u5e9f\u5f03\uff0c\u8c03\u7528\u4e0d\u751f\u6548");
    }

    public e(Context context, String str, String str2, String str3, com.qq.e.comm.plugin.b.l lVar) {
        this.f46059c = new h(context, str, str2, str3);
        this.f46070n = j.b(str2);
        this.f46069m = !TextUtils.isEmpty(str3);
        this.f46059c.f46099k = lVar;
        this.f46060d = new g();
        this.f46061e = new i();
        this.f46062f = new q();
        this.f46063g = new f();
        this.f46064h = new com.qq.e.comm.plugin.splash.d();
        this.f46065i = new m();
        this.f46066j = new l();
    }

    private void b(boolean z3) {
        String str = f46057o;
        Object[] objArr = new Object[1];
        boolean z4 = false;
        objArr[0] = z3 ? "outer" : "inner";
        d1.a(str, "handleTimeout: %s", objArr);
        if (this.f46066j.o()) {
            return;
        }
        if (this.f46070n) {
            c(z3);
            return;
        }
        if (this.f46059c.b() != null && this.f46061e.b() != null) {
            z4 = true;
        }
        if (z4) {
            if (this.f46066j.n()) {
                d1.a(f46057o, "\u56fe\u7247\u52a0\u8f7d\u5b8c\u6210\uff0c\u9884\u5c55\u793a\u9636\u6bb5\uff0c\u5f3a\u5236\u5c55\u793a\u56fe\u6587");
                this.f46062f.l();
                n.a(this.f46059c, z3, 1);
                return;
            } else if (this.f46066j.m()) {
                d1.a(f46057o, "\u56fe\u7247\u52a0\u8f7d\u5b8c\u6210\uff0c\u52a0\u8f7d\u9636\u6bb5\uff0c\u5c1d\u8bd5\u56de\u8c03\u52a0\u8f7d\u5b8c\u6210");
                y();
                n.a(this.f46059c, z3, 2);
                return;
            }
        }
        if (this.f46066j.m()) {
            c0 u3 = u();
            if (u3 != null) {
                this.f46061e.a(u3);
                n.a(this.f46059c, z3, 3);
                d1.a(f46057o, "\u5f00\u5c4f\u52a0\u8f7d\u9636\u6bb5\uff0c\u6570\u636e\u6216\u8d44\u6e90\u8d85\u65f6\uff0c\u7528\u7f13\u5b58");
                return;
            }
            n.b(this.f46059c, z3, 3);
        } else if (this.f46066j.n()) {
            c0 u4 = u();
            if (u4 != null) {
                u4.c(true);
                this.f46059c.a(u4);
                this.f46061e.a();
                this.f46061e.a(this.f46059c, this);
                this.f46061e.a(true);
                this.f46061e.a(u4);
                n.a(this.f46059c, z3, 4);
                d1.a(f46057o, "\u5f00\u5c4f\u9884\u5c55\u793a\u9636\u6bb5\uff0c\u8fb9\u4e0b\u8fb9\u64ad\u8d85\u65f6\uff0c\u7528\u7f13\u5b58");
                return;
            }
            n.b(this.f46059c, z3, 4);
        }
        if (z3) {
            c(4011);
        }
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void c() {
        p();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        this.f46059c.f46102n = bArr;
    }

    private void c(boolean z3) {
        if (this.f46066j.l() || this.f46066j.n()) {
            return;
        }
        if (this.f46066j.m()) {
            c0 u3 = u();
            if (u3 != null) {
                this.f46059c.a(u3);
                this.f46061e.a(u3);
                n.a(this.f46059c, z3, 5);
                d1.a(f46057o, "\u5f00\u5c4f\u52a0\u8f7d\u9636\u6bb5\uff0c\u8bf7\u6c42\u8d85\u65f6\uff0c\u7528\u7f13\u5b58");
                y();
                return;
            }
            n.b(this.f46059c, z3, 5);
        }
        if (z3) {
            c(4011);
        }
    }

    private void a(boolean z3, boolean z4, ViewGroup viewGroup) {
        if (z4 && viewGroup == null) {
            GDTLogger.e("\u52a0\u8f7d\u5e76\u5c55\u793a\u5bb9\u5668\u4e0d\u80fd\u4e3a\u7a7a");
        } else if (this.f46066j.e()) {
            w();
            if (this.f46066j.g()) {
                this.f46068l = System.currentTimeMillis();
                h hVar = this.f46059c;
                hVar.f46104p = j.a(z4, hVar.f46091c);
                n.a(z4, this.f46059c.c(), this.f46059c.f46104p, this.f46070n);
                h hVar2 = this.f46059c;
                hVar2.f46105q = z3;
                hVar2.f46106r = z4;
                hVar2.f46107s = viewGroup;
                this.f46060d.d();
                this.f46065i.f();
            }
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        r.a(map, this.f46059c.f46091c, this.f46059c.b(), this.f46059c.c(), this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        r.a(map, this.f46059c.b(), this.f46059c.f46091c, this.f46059c.c(), this);
    }

    private void c(int i4) {
        d1.a(f46057o, "fail %s", Integer.valueOf(i4));
        int a4 = this.f46066j.a();
        if (this.f46066j.d()) {
            if (i4 == 4011) {
                n.a(this.f46059c, a4, this.f46070n);
            }
            if (this.f46059c.f46100l != null) {
                p0.d(new RunnableC0892e(i4));
            }
            t();
        }
    }

    @Override // com.qq.e.comm.plugin.splash.r.d
    public void a(c0 c0Var) {
        if (this.f46066j.j()) {
            this.f46059c.a(c0Var);
            v.a(1010410, null, Integer.valueOf(TextUtils.isEmpty(c0Var.L0()) ? 1 : 0));
            this.f46061e.a(c0Var);
            if (this.f46070n) {
                y();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.splash.r.d
    public void a(com.qq.e.comm.plugin.s.b bVar) {
        c(bVar.a());
    }

    @Override // com.qq.e.comm.plugin.splash.r.f
    public void a() {
        if (this.f46070n) {
            return;
        }
        if (this.f46066j.n()) {
            this.f46062f.f();
        }
        y();
    }

    @Override // com.qq.e.comm.plugin.splash.r.f
    public void a(com.qq.e.comm.plugin.p.d dVar) {
        if (this.f46070n) {
            return;
        }
        int a4 = dVar == null ? 0 : dVar.a();
        com.qq.e.comm.plugin.l0.e.d(this.f46059c.c(), a4);
        c(a4);
    }

    private void a(boolean z3, ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.e("\u5c55\u793a\u5e7f\u544a\u5bb9\u5668\u4e0d\u80fd\u4e3a\u7a7a");
        } else if (this.f46059c.b() != null && !this.f46066j.m()) {
            if (!this.f46066j.l()) {
                GDTLogger.e("\u8bf7\u52ff\u91cd\u590d\u8c03\u7528 show \u63a5\u53e3");
            } else if (this.f46066j.i()) {
                n.e(this.f46059c);
                int i4 = 0;
                if (z3 != this.f46059c.f46105q) {
                    i4 = 5024;
                } else if (r()) {
                    i4 = 5012;
                }
                if (i4 != 0) {
                    n.a(this.f46059c, Integer.valueOf(i4));
                    c(i4);
                    return;
                }
                h hVar = this.f46059c;
                hVar.f46107s = viewGroup;
                this.f46064h.b(hVar, this);
                this.f46062f.k();
            }
        } else {
            GDTLogger.e("\u52a0\u8f7d\u5e7f\u544a\u540e\u518d\u8c03\u7528 show \u63a5\u53e3");
        }
    }

    @Override // com.qq.e.comm.plugin.util.c2.b
    public void b() {
        this.f46062f.a(0L);
        d(0);
    }

    @Override // com.qq.e.comm.plugin.splash.r.h
    public void a(com.qq.e.comm.plugin.s.a aVar) {
        n.a(this.f46059c, Integer.valueOf(aVar.f46005c));
        c(aVar.f46005c);
    }

    @Override // com.qq.e.comm.plugin.splash.r.h
    public void a(com.qq.e.comm.plugin.splash.r.a aVar) {
        if (this.f46066j.k() && this.f46064h.a(aVar)) {
            this.f46064h.b(aVar);
        }
    }

    @Override // com.qq.e.comm.plugin.splash.r.b
    public void a(int i4) {
        d(i4);
    }

    @Override // com.qq.e.comm.plugin.util.c2.b
    public void a(long j4) {
        if (this.f46066j.o()) {
            this.f46062f.a(j4);
            ADListener aDListener = this.f46059c.f46100l;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(112, Long.valueOf(j4)));
            }
        }
    }
}
