package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.callback.biz.DynamicAdCallback;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.fs.e.c;
import com.qq.e.comm.plugin.fs.e.f;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.g0.f0;
import com.qq.e.comm.plugin.g0.l0.c;
import com.qq.e.comm.plugin.g0.l0.f.c;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.rewardvideo.e;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.q1;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements RVADI, com.qq.e.comm.plugin.e0.b, c.b, com.qq.e.comm.plugin.e0.a, com.qq.e.comm.plugin.h.f {
    private static final String B;
    private static final e.a<f0> C;
    private final com.qq.e.comm.plugin.h.e A;

    /* renamed from: c  reason: collision with root package name */
    private final String f45858c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f45859d;

    /* renamed from: e  reason: collision with root package name */
    private final String f45860e;

    /* renamed from: f  reason: collision with root package name */
    private final String f45861f;

    /* renamed from: g  reason: collision with root package name */
    private final String f45862g;

    /* renamed from: h  reason: collision with root package name */
    private final com.qq.e.comm.plugin.b.l f45863h;

    /* renamed from: i  reason: collision with root package name */
    private final com.qq.e.comm.plugin.b.m f45864i;

    /* renamed from: j  reason: collision with root package name */
    private final com.qq.e.comm.plugin.l0.b f45865j;

    /* renamed from: k  reason: collision with root package name */
    private final ADListener f45866k;

    /* renamed from: l  reason: collision with root package name */
    private final int f45867l;

    /* renamed from: m  reason: collision with root package name */
    private final com.qq.e.comm.plugin.rewardvideo.d f45868m;

    /* renamed from: n  reason: collision with root package name */
    private LoadAdParams f45869n;

    /* renamed from: o  reason: collision with root package name */
    private f0 f45870o;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f45871p;

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f45872q;

    /* renamed from: r  reason: collision with root package name */
    private long f45873r;

    /* renamed from: s  reason: collision with root package name */
    private com.qq.e.comm.plugin.rewardvideo.f f45874s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f45875t;

    /* renamed from: u  reason: collision with root package name */
    private ServerSideVerificationOptions f45876u;

    /* renamed from: v  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f45877v;

    /* renamed from: w  reason: collision with root package name */
    private String f45878w;

    /* renamed from: x  reason: collision with root package name */
    private long f45879x;

    /* renamed from: y  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.l0.c<f0> f45880y;

    /* renamed from: z  reason: collision with root package name */
    private final Map<String, Boolean> f45881z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends com.qq.e.comm.plugin.h.d<Void> {
        a(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            c.this.f45866k.onADEvent(new ADEvent(103, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends com.qq.e.comm.plugin.h.d<Void> {
        b(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            c.this.f45866k.onADEvent(new ADEvent(106, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.rewardvideo.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0887c extends com.qq.e.comm.plugin.h.d<Void> {
        C0887c(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            c.this.f45866k.onADEvent(new ADEvent(105, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.rewardvideo.m> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f0 f45885b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(com.qq.e.comm.plugin.h.f fVar, f0 f0Var) {
            super(fVar);
            this.f45885b = f0Var;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.rewardvideo.m mVar) {
            int a4 = mVar.a();
            String b4 = com.qq.e.comm.plugin.rewardvideo.q.b(this.f45885b.K0());
            if (!this.f45885b.c1()) {
                c.this.f45866k.onADEvent(new ADEvent(104, b4));
                d1.a("RewardVideoActivity", "default reward: %s, ", b4);
            } else {
                c.this.f45866k.onADEvent(new ADEvent(104, b4, Integer.valueOf(a4)));
                d1.a("RewardVideoActivity", "multi reward: %s, action\uff1a%s", b4, Integer.valueOf(a4));
            }
            if (c.this.f45870o != null && (a4 == 1 || !this.f45885b.c1() || com.qq.e.comm.plugin.d0.a.d().f().a("sksrsr", c.this.f45860e, 0) == 1)) {
                com.qq.e.comm.plugin.rewardvideo.q.a(c.this.f45870o, mVar, c.this.f45876u);
            }
            v.a(1403021, c.this.f45877v, 1, Integer.valueOf(a4), null);
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
            c.this.f45866k.onADEvent(new ADEvent(107, num));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class f extends com.qq.e.comm.plugin.h.d<Void> {
        f(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            c.this.f45866k.onADEvent(new ADEvent(304, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.adview.video.a> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f0 f45889b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(com.qq.e.comm.plugin.h.f fVar, f0 f0Var) {
            super(fVar);
            this.f45889b = f0Var;
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.adview.video.a aVar) {
            if (Boolean.TRUE.equals(c.this.f45881z.get(this.f45889b.l0()))) {
                return;
            }
            c.this.f45881z.put(this.f45889b.l0(), Boolean.TRUE);
            ADListener aDListener = c.this.f45866k;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aVar == null ? 5002 : aVar.b());
            aDListener.onADEvent(new ADEvent(107, objArr));
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
            c.this.f45866k.onADEvent(new ADEvent(209, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class i extends com.qq.e.comm.plugin.h.d<Integer> {
        i(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            if (num == null) {
                num = -1;
            }
            c.this.f45866k.onADEvent(new ADEvent(210, num));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class j extends com.qq.e.comm.plugin.h.d<Void> {
        j(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            c.this.f45866k.onADEvent(new ADEvent(206, new Object[0]));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class k implements e.a<f0> {
        k() {
        }

        @Override // com.qq.e.comm.plugin.rewardvideo.e.a
        /* renamed from: b */
        public f0 a(String str, String str2, String str3, String str4, com.qq.e.comm.plugin.b.g gVar, JSONObject jSONObject, com.qq.e.comm.plugin.b.l lVar) {
            return new f0(str, str2, str3, str4, jSONObject, lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class l extends com.qq.e.comm.plugin.h.d<String> {
        l(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(String str) {
            c.this.a(str, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class n implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.s.b f45900c;

        n(com.qq.e.comm.plugin.s.b bVar) {
            this.f45900c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a("LoadGDTRewardVideoADFail", this.f45900c);
            c.this.a(this.f45900c.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class o implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f45902c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f45903d;

        o(int i4, com.qq.e.comm.plugin.g0.e eVar) {
            this.f45902c = i4;
            this.f45903d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (c.this.f45866k != null) {
                if (this.f45902c == 5002) {
                    if (this.f45903d != null) {
                        Boolean bool = Boolean.TRUE;
                        Map map = c.this.f45881z;
                        str = this.f45903d.l0();
                        if (bool.equals(map.get(str))) {
                            return;
                        }
                    } else {
                        str = "";
                    }
                    c.this.f45881z.put(str, Boolean.TRUE);
                }
                c.this.f45866k.onADEvent(new ADEvent(107, Integer.valueOf(this.f45902c)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f45866k.onADEvent(new ADEvent(100, new Object[0]));
            com.qq.e.comm.plugin.l0.e.a(c.this.f45877v, 1, c.this.f45870o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class q implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f45906c;

        q(String str) {
            this.f45906c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f45870o == null) {
                return;
            }
            File c4 = !TextUtils.isEmpty(this.f45906c) ? b1.c(this.f45906c) : null;
            String Y = c.this.f45870o.Y();
            File file = TextUtils.isEmpty(Y) ? null : new File(b1.b(), b1.e(Y));
            if ((c4 == null || !c4.exists()) && (file == null || !file.exists())) {
                return;
            }
            c.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class r implements f.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f45908a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f0 f45909b;

        r(String str, f0 f0Var) {
            this.f45908a = str;
            this.f45909b = f0Var;
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(int i4, long j4, long j5) {
            String str = c.B;
            d1.a(str, "downloadVideo onProgress : " + i4);
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(boolean z3) {
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void onCancel() {
            d1.a(c.B, "downloadVideo onCancel");
            c.this.a(this.f45909b, 5002);
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void onStart() {
            String str = c.B;
            d1.a(str, "downloadVideo onStart, url : " + this.f45908a);
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(String str) {
            String str2 = c.B;
            d1.a(str2, "downloadVideo onCompleted, path : " + str);
            c.this.h();
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            String str = c.B;
            d1.a(str, "downloadVideo onFailed, e : " + dVar.b());
            if (c.this.f45872q) {
                return;
            }
            c.this.a(this.f45909b, 5002);
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a() {
            d1.a(c.B, "downloadVideo onDownloadTimeout");
            com.qq.e.comm.plugin.rewardvideo.n.c(c.this.f45877v);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class s implements com.qq.e.comm.plugin.b0.c {
        s() {
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, com.qq.e.comm.plugin.b0.f fVar) {
            if (fVar.a()) {
                return;
            }
            v.a(9130005, c.this.f45877v, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class t extends com.qq.e.comm.plugin.h.d<Void> {
        t(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            c.this.f45866k.onADEvent(new ADEvent(102, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class u implements c.i {

        /* renamed from: h  reason: collision with root package name */
        private static final String f45913h = com.qq.e.comm.plugin.g0.l0.c.f43616o;

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<c> f45914a;

        /* renamed from: b  reason: collision with root package name */
        private final String f45915b;

        /* renamed from: c  reason: collision with root package name */
        private final String f45916c;

        /* renamed from: d  reason: collision with root package name */
        private final String f45917d;

        /* renamed from: e  reason: collision with root package name */
        private final String f45918e;

        /* renamed from: f  reason: collision with root package name */
        private final com.qq.e.comm.plugin.b.l f45919f;

        /* renamed from: g  reason: collision with root package name */
        private final e.a<f0> f45920g;

        public u(c cVar, String str, String str2, String str3, String str4, com.qq.e.comm.plugin.b.l lVar, e.a<f0> aVar) {
            this.f45914a = new WeakReference<>(cVar);
            this.f45915b = str;
            this.f45916c = str2;
            this.f45917d = str3;
            this.f45918e = str4;
            this.f45919f = lVar;
            this.f45920g = aVar;
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.i
        public void a(List<JSONObject> list) {
            int size;
            if (list != null && (size = list.size()) > 0) {
                c cVar = this.f45914a.get();
                if (cVar == null) {
                    d1.a(f45913h, "onPreloaded, rewardVideoADDelegate == null, \u4e0d\u6267\u884c\u9884\u52a0\u8f7d\u89c6\u9891\u903b\u8f91");
                    return;
                }
                for (int i4 = 0; i4 < size; i4++) {
                    f0 a4 = this.f45920g.a(this.f45915b, this.f45916c, this.f45917d, this.f45918e, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD, list.get(i4), this.f45919f);
                    if (!TextUtils.isEmpty(a4.L0())) {
                        cVar.b(a4);
                        d1.a(f45913h, "onPreloaded, \u53ea\u9884\u52a0\u8f7d\u56fe\u7247");
                    }
                }
                return;
            }
            d1.a(f45913h, "onPreloaded, adDataList is null or empty");
        }
    }

    static {
        com.qq.e.comm.plugin.dl.i.a().b(com.qq.e.comm.plugin.b.g.REWARDVIDEOAD);
        B = c.class.getSimpleName();
        C = new k();
    }

    public c(Context context, String str, String str2, String str3, ADListener aDListener) {
        this(context, str, str2, com.qq.e.comm.plugin.b.l.f42027d, str3, aDListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 0, this, str, Integer.valueOf(i4));
    }

    private boolean r() {
        return com.qq.e.comm.plugin.util.c.a(this.f45873r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.b.d c() {
        return (com.qq.e.comm.plugin.b.d) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 0, this);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        f0 f0Var = this.f45870o;
        if (f0Var != null) {
            return f0Var.r();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        String[] strArr = new String[1];
        f0 f0Var = this.f45870o;
        strArr[0] = f0Var == null ? "" : f0Var.S();
        return strArr;
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        String[] strArr = new String[1];
        f0 f0Var = this.f45870o;
        strArr[0] = f0Var == null ? "" : f0Var.U0();
        return strArr;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        f0 f0Var = this.f45870o;
        if (f0Var == null) {
            return -1;
        }
        return f0Var.J();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        f0 f0Var = this.f45870o;
        if (f0Var == null) {
            return null;
        }
        return f0Var.W0();
    }

    @Override // com.qq.e.comm.pi.RVADI
    @Deprecated
    public long getExpireTimestamp() {
        return this.f45873r;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        f0 f0Var = this.f45870o;
        if (f0Var != null) {
            return f0Var.R();
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        f0 f0Var = this.f45870o;
        if (f0Var == null) {
            return -1;
        }
        return f0Var.h0();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getRewardAdType() {
        return this.f45874s == com.qq.e.comm.plugin.rewardvideo.f.PAGE ? 1 : 0;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getVideoDuration() {
        f0 f0Var = this.f45870o;
        if (f0Var == null) {
            return 0;
        }
        return f0Var.M0() * 1000;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public boolean hasShown() {
        return this.f45871p;
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return false;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return (hasShown() || r()) ? false : true;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void loadAD() {
        this.f45868m.b();
        a((String) null, 0);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        com.qq.e.comm.plugin.util.r.b(i4, i5, str, this.f45860e, this.f45870o, this.f45877v, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        com.qq.e.comm.plugin.util.r.a(i4, this.f45870o, this.f45860e, this.f45877v, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        f0 f0Var = this.f45870o;
        if (f0Var != null) {
            com.qq.e.comm.plugin.util.r.a(f0Var.q0(), i4);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        f0 f0Var = this.f45870o;
        if (f0Var != null && downloadConfirmListener != null) {
            String e02 = f0Var.e0();
            d1.a("setDownloadConfirmListener reward video trace id:" + e02 + " listener:" + downloadConfirmListener, new Object[0]);
            com.qq.e.comm.plugin.b.j.b().a(e02, downloadConfirmListener);
            return;
        }
        GDTLogger.e("setDownloadConfirmListener\u8c03\u7528\u9519\u8bef\uff0c\u5e7f\u544a\u6570\u636e\u6216listener\u4e3a\u7a7a");
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f45869n = loadAdParams;
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.f45878w = str;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f45876u = serverSideVerificationOptions;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setVolumeOn(boolean z3) {
        this.f45875t = z3;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD() {
        a(com.qq.e.comm.plugin.d0.a.d().a(), true);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class m implements c.h<f0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f45895a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f45896b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f45897c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicLong f45898d;

        m(boolean z3, String str, com.qq.e.comm.plugin.b.d dVar, AtomicLong atomicLong) {
            this.f45895a = z3;
            this.f45896b = str;
            this.f45897c = dVar;
            this.f45898d = atomicLong;
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.h
        /* renamed from: b */
        public f0 a(JSONObject jSONObject) {
            return (f0) c.C.a(c.this.f45858c, c.this.f45860e, c.this.f45861f, c.this.f45862g, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD, jSONObject, c.this.f45863h);
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.h
        public void a(f0 f0Var) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(f0Var);
            f0 a4 = c.this.a(arrayList);
            if (this.f45895a && c.this.f45870o != null) {
                ((DynamicAdCallback) com.qq.e.comm.plugin.h.a.b(c.this.f45870o.l0(), DynamicAdCallback.class)).t().b(new Pair<>(this.f45896b, a4));
                c.this.f45880y.a((com.qq.e.comm.plugin.g0.l0.c) a4, this.f45897c, c.this.f45865j, c.this.f45864i, (c.f) null, c.this.f45877v);
            } else if (a4 != null) {
                a4.h(this.f45898d.get());
                c.this.a(f0Var, a4.e1());
            }
        }

        @Override // com.qq.e.comm.plugin.g0.l0.c.h
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            if (this.f45895a) {
                if (bVar == null || bVar.a() != 5014 || !c.this.f45868m.a()) {
                    if (c.this.f45870o != null) {
                        ((DynamicAdCallback) com.qq.e.comm.plugin.h.a.b(c.this.f45870o.l0(), DynamicAdCallback.class)).t().b(new Pair<>(this.f45896b, null));
                        return;
                    }
                    return;
                }
                c.this.a(this.f45896b, 1);
            } else if (bVar != null && bVar.a() == 5014) {
                c.this.c(5014);
            } else {
                c.this.a(bVar);
            }
        }
    }

    public c(Context context, String str, String str2, com.qq.e.comm.plugin.b.l lVar, String str3, ADListener aDListener) {
        this.f45869n = null;
        this.f45871p = false;
        this.f45872q = false;
        this.f45874s = com.qq.e.comm.plugin.rewardvideo.f.MEDIA;
        this.f45875t = true;
        this.f45877v = new com.qq.e.comm.plugin.n0.c();
        this.f45881z = new ConcurrentHashMap();
        this.A = new com.qq.e.comm.plugin.h.e();
        this.f45859d = context;
        this.f45860e = str2;
        this.f45861f = str3;
        this.f45877v.c(str2);
        this.f45877v.a(com.qq.e.comm.plugin.b.g.REWARDVIDEOAD);
        this.f45863h = lVar;
        this.f45867l = com.qq.e.comm.plugin.rewardvideo.q.a(str2);
        this.f45866k = aDListener;
        this.f45858c = str;
        this.f45862g = com.qq.e.comm.plugin.util.b.a(str, str2);
        this.f45868m = new com.qq.e.comm.plugin.rewardvideo.d(str2);
        this.f45864i = new com.qq.e.comm.plugin.b.m(str2, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD, (com.qq.e.comm.plugin.b.f) null);
        this.f45865j = new com.qq.e.comm.plugin.l0.b(com.qq.e.comm.plugin.b.g.REWARDVIDEOAD, this.f45860e);
        n();
    }

    private void d(f0 f0Var) {
        ((DynamicAdCallback) com.qq.e.comm.plugin.h.a.b(f0Var.l0(), DynamicAdCallback.class)).loadAd().a(new l(this));
    }

    private boolean e(f0 f0Var) {
        return (f0Var.i0() != null && f0Var.i0().y()) && com.qq.e.comm.plugin.t.c.a("unflp", f0Var.q0(), 0) <= 0;
    }

    private void f(f0 f0Var) {
        FSCallback fSCallback = (FSCallback) com.qq.e.comm.plugin.h.a.b(f0Var.l0(), FSCallback.class);
        fSCallback.A().a(new t(this));
        fSCallback.E().a(new a(this));
        fSCallback.B().a(new b(this));
        fSCallback.y().a(new C0887c(this));
        fSCallback.I().a(new d(this, f0Var));
        fSCallback.G().a(new e(this));
        fSCallback.onComplainSuccess().a(new f(this));
    }

    private void g(f0 f0Var) {
        VideoCallback videoCallback = (VideoCallback) com.qq.e.comm.plugin.h.a.b(f0Var.l0(), VideoCallback.class);
        videoCallback.m().a(new g(this, f0Var));
        videoCallback.D().a(new h(this));
        videoCallback.c().a(new i(this));
        videoCallback.onComplete().a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f45870o == null || this.f45872q) {
            return;
        }
        this.f45872q = true;
        a(this.f45870o.K0(), 10005, (Object) null);
    }

    private boolean i() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("rvaulap", 1) == 1;
    }

    private void j() {
        int e4 = com.qq.e.comm.plugin.rewardvideo.q.e(this.f45870o);
        String L0 = this.f45870o.L0();
        if (e4 < 0 || TextUtils.isEmpty(L0)) {
            return;
        }
        p0.a(new q(L0), e4);
    }

    private int k() {
        return this.f45880y != null ? 3 : 0;
    }

    private void n() {
        int a4 = com.qq.e.comm.plugin.t.c.a("skrvp", com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.b(), this.f45860e, com.qq.e.comm.plugin.t.c.a("skrvpdv", this.f45860e, 6, (b0) null));
        d1.a(com.qq.e.comm.plugin.g0.l0.c.f43616o, "initPreloadSettings, \u7f13\u5b58\u6c60\u5927\u5c0f = %s", Integer.valueOf(a4));
        com.qq.e.comm.plugin.g0.l0.c<f0> a5 = com.qq.e.comm.plugin.g0.l0.c.a(this.f45860e, this.f45877v, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD);
        this.f45880y = a5;
        a5.a(b(a4)).a(a4).b(com.qq.e.comm.plugin.t.c.a("apitp", com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.b(), this.f45860e, 400)).a(new u(this, this.f45858c, this.f45860e, this.f45861f, this.f45862g, this.f45863h, C));
    }

    private void p() {
        f0 f0Var = this.f45870o;
        if (f0Var == null) {
            return;
        }
        boolean e12 = f0Var.e1();
        int i4 = 0;
        if (e12) {
            i4 = 1;
        } else {
            if (System.currentTimeMillis() - this.f45879x > ((long) com.qq.e.comm.plugin.d0.a.d().f().a("skrvltstg", this.f45870o.q0(), 60000))) {
                i4 = 2;
            }
        }
        boolean z3 = !TextUtils.isEmpty(this.f45861f);
        v.a(1020053, this.f45877v, Integer.valueOf(i4), Integer.valueOf(((z3 ? 2 : 1) * 100) + k()), null);
        com.qq.e.comm.plugin.rewardvideo.n.a(this.f45877v, e12, z3);
    }

    public int l() {
        f0 f0Var = this.f45870o;
        if (f0Var == null) {
            return -1;
        }
        return f0Var.r0();
    }

    public boolean o() {
        f0 f0Var = this.f45870o;
        return f0Var != null && f0Var.Y0();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        com.qq.e.comm.plugin.util.r.a(map, this.f45860e, this.f45870o, this.f45877v, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        com.qq.e.comm.plugin.util.r.a(map, this.f45870o, this.f45860e, this.f45877v, this);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD(Activity activity) {
        if (activity == null) {
            GDTLogger.e("\u4f20\u5165\u53c2\u6570\u9519\u8bef\uff1ashowAD\u4f20\u5165\u53c2\u6570activity\u4e3a\u7a7a");
            a(4001);
            return;
        }
        a((Context) activity, false);
    }

    protected boolean b(int i4) {
        return TextUtils.isEmpty(this.f45861f) && i4 > 0 && com.qq.e.comm.plugin.edgeanalytics.e.d(com.qq.e.comm.plugin.b.g.REWARDVIDEOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f0 f0Var) {
        String Y = f0Var.Y();
        com.qq.e.comm.plugin.b0.b a4 = com.qq.e.comm.plugin.b0.b.a();
        s sVar = new s();
        a4.a(Y, sVar, com.qq.e.comm.plugin.util.v2.a.b("vcri") + f0Var.o().d());
    }

    private void b(f0 f0Var, Context context, boolean z3) {
        d1.a(B, "jumpToRewardVideo");
        ((com.qq.e.comm.plugin.d0.b.b) com.qq.e.comm.plugin.d0.b.e.a(f0Var.l0(), com.qq.e.comm.plugin.d0.b.b.class)).a(this);
        f(f0Var);
        d(f0Var);
        g(f0Var);
        com.qq.e.comm.plugin.fs.e.a.a(context, f0Var, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.s.b bVar) {
        p0.a((Runnable) new n(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        a((com.qq.e.comm.plugin.g0.e) null, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        p0.a((Runnable) new o(i4, eVar));
    }

    private boolean c(f0 f0Var) {
        String L0 = f0Var.L0();
        if (!TextUtils.isEmpty(L0)) {
            File c4 = b1.c(L0);
            String a4 = com.qq.e.comm.plugin.p0.e.a().a(L0);
            if (!TextUtils.isEmpty(a4) && com.qq.e.comm.plugin.util.v2.a.a(f0Var.H())) {
                h();
                return false;
            }
            if (c4 != null && c4.exists()) {
                d1.a(B, "cacheVideoResource, traceId \u4e3a %s \u7684\u89c6\u9891\u6587\u4ef6\u5df2\u5b58\u5728", f0Var.K0());
                h();
            } else {
                d1.a(B, "cacheVideoResource, \u5f00\u59cb\u4e0b\u8f7d traceId \u4e3a %s \u7684\u89c6\u9891", f0Var.K0());
                com.qq.e.comm.plugin.fs.e.f.a().a(L0, a4, new r(L0, f0Var), f0Var, true);
            }
            b(f0Var);
        } else {
            h();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f0 a(List<f0> list) {
        Pair a4 = com.qq.e.comm.plugin.rewardvideo.e.a(list, this.f45877v, false);
        int intValue = ((Integer) a4.first).intValue();
        if (intValue != 0) {
            com.qq.e.comm.plugin.l0.e.a(intValue, this.f45877v, list != null ? list.size() : 0);
            return null;
        }
        List list2 = (List) a4.second;
        f0 f0Var = (f0) list2.get(0);
        com.qq.e.comm.plugin.n0.c a5 = com.qq.e.comm.plugin.n0.c.a(f0Var);
        this.f45877v = a5;
        com.qq.e.comm.plugin.l0.e.b(a5, list2.size());
        a(f0Var);
        return f0Var;
    }

    @Override // com.qq.e.comm.plugin.h.f
    public com.qq.e.comm.plugin.h.e g() {
        return this.A;
    }

    private void a(f0 f0Var) {
        com.qq.e.comm.plugin.t.c.d().a(f0Var, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.b(), "skrvp", 6).a(f0Var, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.b(), "apitp", 400).a(f0Var, "rewardVideoServerMaxDuration", 301).a(f0Var, "sksrvmd", 0).a(f0Var, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.b(), "iaraci", 0).a(f0Var, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.b(), "tprwic", 0).a(f0Var, "rewardLoadAdCount", 1).a(f0Var, "rewardVideoLoadRetryTimes", 2).a();
    }

    public void a(f0 f0Var, boolean z3) {
        d1.a("\u6fc0\u52b1\u89c6\u9891\uff0c\u51c6\u5907\u5f85\u663e\u793a\u7684\u5e7f\u544a\u662f\u5426\u7f13\u5b58\u7684\u5e7f\u544a\uff1a" + z3 + "  " + f0Var, new Object[0]);
        if ((TextUtils.isEmpty(f0Var.L0()) && f0Var.i0() == null) || e(f0Var)) {
            this.f45874s = com.qq.e.comm.plugin.rewardvideo.f.PAGE;
        } else {
            this.f45874s = com.qq.e.comm.plugin.rewardvideo.f.MEDIA;
        }
        f0Var.a(this.f45874s);
        this.f45870o = f0Var;
        f0Var.d(System.currentTimeMillis());
        this.f45873r = com.qq.e.comm.plugin.util.c.b(f0Var);
        this.f45871p = false;
        this.f45872q = false;
        this.f45879x = System.currentTimeMillis();
        com.qq.e.comm.plugin.fs.e.c.a().b(this.f45870o.K0(), this);
        if (this.f45874s == com.qq.e.comm.plugin.rewardvideo.f.MEDIA) {
            this.f45870o.c(3);
            this.f45877v.b(3);
        }
        if (this.f45874s == com.qq.e.comm.plugin.rewardvideo.f.PAGE && com.qq.e.comm.plugin.rewardvideo.q.d(this.f45870o.q0())) {
            com.qq.e.comm.plugin.rewardvideo.k.a(this.f45859d, this.f45870o);
        }
        com.qq.e.comm.plugin.gdtnativead.d.a(this.f45870o.q0(), new VideoOption.Builder().setAutoPlayMuted(!this.f45875t).setDetailPageMuted(false).setAutoPlayPolicy(1).build());
        if (c(this.f45870o)) {
            j();
        }
        com.qq.e.comm.plugin.util.r.d(this.f45860e, this);
        p0.a((Runnable) new p());
    }

    public void a(Context context, boolean z3) {
        com.qq.e.comm.plugin.rewardvideo.n.b(this.f45877v);
        int i4 = 0;
        if (this.f45870o != null && this.f45880y != null) {
            com.qq.e.comm.plugin.b.d c4 = c();
            this.f45880y.a((com.qq.e.comm.plugin.g0.l0.c<f0>) this.f45870o, c4, this.f45865j, this.f45864i, (c.f) null, this.f45877v);
            for (int i5 = 0; i5 < this.f45870o.Q(); i5++) {
                this.f45880y.a((com.qq.e.comm.plugin.g0.l0.c<f0>) ((f0) this.f45870o.a(i5)), c4, this.f45865j, this.f45864i, (c.f) null, this.f45877v);
            }
        }
        if (this.f45870o == null) {
            i4 = 4014;
        } else if (this.f45871p) {
            i4 = 4015;
        } else if (r()) {
            i4 = 5012;
        }
        if (i4 != 0) {
            a(i4);
            com.qq.e.comm.plugin.rewardvideo.n.a(this.f45877v, i4);
            return;
        }
        this.f45871p = true;
        com.qq.e.comm.plugin.g0.l0.c<f0> cVar = this.f45880y;
        if (cVar != null) {
            cVar.b(c(), this.f45865j, this.f45864i, this.f45877v);
        }
        if (this.f45874s != com.qq.e.comm.plugin.rewardvideo.f.PAGE) {
            b(this.f45870o, context, z3);
        } else {
            a(this.f45870o, context, z3);
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4) {
        if (this.f45868m.a()) {
            d1.a(B, "reward Ad retry load");
            a((String) null, 1);
            return;
        }
        a(i4);
    }

    private void a(f0 f0Var, Context context, boolean z3) {
        d1.a(B, "jumpToRewardPage");
        Intent intent = new Intent();
        intent.setClassName(context, q1.d());
        intent.putExtra("gdt_activity_delegate_name", com.qq.e.comm.plugin.a.REWARD_PAGE);
        intent.putExtra("appid", f0Var.p());
        intent.putExtra("clickStartTime", System.currentTimeMillis());
        intent.putExtra("objectId", f0Var.l0());
        ((com.qq.e.comm.plugin.d0.b.b) com.qq.e.comm.plugin.d0.b.e.a(f0Var.l0(), com.qq.e.comm.plugin.d0.b.b.class)).a((com.qq.e.comm.plugin.g0.e) f0Var);
        if (z3) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            ((com.qq.e.comm.plugin.d0.b.b) com.qq.e.comm.plugin.d0.b.e.a(f0Var.l0(), com.qq.e.comm.plugin.d0.b.b.class)).a(this);
        } catch (Exception unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.fs.e.c.b
    public void a(String str, int i4, Object obj) {
        f0 f0Var = this.f45870o;
        if (f0Var == null || !str.equals(f0Var.K0())) {
            return;
        }
        switch (i4) {
            case 10000:
                this.f45866k.onADEvent(new ADEvent(100, new Object[0]));
                return;
            case 10001:
                this.f45866k.onADEvent(new ADEvent(102, new Object[0]));
                return;
            case 10002:
                this.f45866k.onADEvent(new ADEvent(103, new Object[0]));
                return;
            case 10003:
                this.f45866k.onADEvent(new ADEvent(105, new Object[0]));
                return;
            case 10004:
                this.f45866k.onADEvent(new ADEvent(106, new Object[0]));
                return;
            case 10005:
                this.f45866k.onADEvent(new ADEvent(201, new Object[0]));
                return;
            default:
                switch (i4) {
                    case 10012:
                        this.f45866k.onADEvent(new ADEvent(206, new Object[0]));
                        return;
                    case 10013:
                    case 10015:
                        this.f45866k.onADEvent(new ADEvent(107, obj));
                        return;
                    case 10014:
                        if (obj instanceof c.C0822c) {
                            c.C0822c c0822c = (c.C0822c) obj;
                            this.f45866k.onADEvent(new ADEvent(104, com.qq.e.comm.plugin.rewardvideo.q.b(c0822c.f43254a)));
                            f0 f0Var2 = this.f45870o;
                            if (f0Var2 != null) {
                                com.qq.e.comm.plugin.rewardvideo.q.a(f0Var2, c0822c.f43255b, this.f45876u);
                                return;
                            }
                            return;
                        }
                        return;
                    case 10016:
                        this.f45866k.onADEvent(new ADEvent(304, new Object[0]));
                        return;
                    default:
                        return;
                }
        }
    }
}
