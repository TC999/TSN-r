package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.gdtnativead.a;
import com.qq.e.comm.plugin.gdtnativead.m;
import com.qq.e.comm.plugin.l0.d;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g implements NEADI, com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.u.b, com.qq.e.comm.plugin.e0.a {

    /* renamed from: c  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.b.g f43773c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f43774d;

    /* renamed from: e  reason: collision with root package name */
    private final String f43775e;

    /* renamed from: f  reason: collision with root package name */
    protected final String f43776f;

    /* renamed from: g  reason: collision with root package name */
    protected final String f43777g;

    /* renamed from: h  reason: collision with root package name */
    protected final String f43778h;

    /* renamed from: i  reason: collision with root package name */
    protected final ADSize f43779i;

    /* renamed from: j  reason: collision with root package name */
    protected com.qq.e.comm.plugin.b.l f43780j;

    /* renamed from: k  reason: collision with root package name */
    protected final ADListener f43781k;

    /* renamed from: l  reason: collision with root package name */
    protected int f43782l;

    /* renamed from: m  reason: collision with root package name */
    private VideoOption f43783m;

    /* renamed from: n  reason: collision with root package name */
    private volatile int f43784n;

    /* renamed from: o  reason: collision with root package name */
    private volatile int f43785o;

    /* renamed from: p  reason: collision with root package name */
    private int f43786p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f43787q;

    /* renamed from: r  reason: collision with root package name */
    private int f43788r;

    /* renamed from: s  reason: collision with root package name */
    private String f43789s;

    /* renamed from: t  reason: collision with root package name */
    protected com.qq.e.comm.plugin.gdtnativead.a f43790t;

    /* renamed from: u  reason: collision with root package name */
    private String[] f43791u;

    /* renamed from: v  reason: collision with root package name */
    private String[] f43792v;

    /* renamed from: w  reason: collision with root package name */
    protected com.qq.e.comm.plugin.n0.c f43793w;

    /* renamed from: x  reason: collision with root package name */
    public long f43794x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements c.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f43795a;

        a(g gVar, int i4) {
            this.f43795a = i4;
        }

        @Override // com.qq.e.comm.plugin.t.c.b
        public void a(boolean z3, Integer num, boolean z4, Integer num2) {
            if (z4) {
                v.a(this.f43795a > num2.intValue() ? 1210041 : 1210042, null, Integer.valueOf(this.f43795a), num2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f43796a;

        b(boolean z3) {
            this.f43796a = z3;
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(JSONObject jSONObject) {
            g.this.a(jSONObject, this.f43796a);
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            d1.a("LoadGDTNativeExpressADFail", bVar);
            g.this.b(bVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f43799c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f43800d;

        d(List list, com.qq.e.comm.plugin.g0.e eVar) {
            this.f43799c = list;
            this.f43800d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f43781k.onADEvent(new ADEvent(100, this.f43799c));
            com.qq.e.comm.plugin.n0.c cVar = g.this.f43793w;
            List list = this.f43799c;
            com.qq.e.comm.plugin.l0.e.a(cVar, list != null ? list.size() : 0, this.f43800d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43802c;

        e(int i4) {
            this.f43802c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f43781k.onADEvent(new ADEvent(101, Integer.valueOf(this.f43802c)));
        }
    }

    public g(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener) {
        this(context, aDSize, str, str2, com.qq.e.comm.plugin.b.l.f42027d, str3, aDListener);
    }

    public void c(int i4) {
        this.f43786p = i4;
    }

    public void d(int i4) {
        this.f43788r = i4;
    }

    public void e(int i4) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2302001);
        hVar.b(i4);
        v.a(hVar);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public String getAdNetWorkName() {
        return "";
    }

    public String[] getCompetitionFailureUrls() {
        return this.f43791u;
    }

    public String[] getCompetitionWinUrls() {
        return this.f43792v;
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return this.f43786p;
    }

    public int h() {
        return this.f43788r;
    }

    public String i() {
        return this.f43775e;
    }

    public Context j() {
        return this.f43774d;
    }

    public ADListener k() {
        return this.f43781k;
    }

    public String l() {
        return this.f43776f;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i4) {
        loadAd(i4, null);
    }

    public String n() {
        return this.f43777g;
    }

    public boolean o() {
        return this.f43787q;
    }

    public boolean p() {
        return false;
    }

    public void q() {
        ADListener aDListener = this.f43781k;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(201, new Object[0]));
        }
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMaxVideoDuration(int i4) {
        this.f43784n = i4;
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.f43789s = str;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMinVideoDuration(int i4) {
        this.f43785o = i4;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoOption(VideoOption videoOption) {
        this.f43783m = videoOption;
        if (videoOption != null) {
            com.qq.e.comm.plugin.gdtnativead.d.a(this.f43776f, videoOption);
        }
    }

    public g(Context context, ADSize aDSize, String str, String str2, com.qq.e.comm.plugin.b.l lVar, String str3, ADListener aDListener) {
        this(context, aDSize, str, str2, lVar, aDListener, str3, com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.b.g c() {
        return com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i4, LoadAdParams loadAdParams) {
        e(i4);
        int a4 = com.qq.e.comm.plugin.t.c.a("exrec", this.f43776f, 3, new a(this, i4));
        if (i4 < 1) {
            GDTLogger.w(String.format("\u539f\u751f\u5e7f\u544a\u8bf7\u6c42\u6570\u91cf\u8303\u56f4\u4e3a[1, %s]\uff0c\u5df2\u5c06\u672c\u6b21\u5e7f\u544a\u8bf7\u6c42\u7684\u5e7f\u544a\u6570\u91cf\u8bbe\u4e3a1", Integer.valueOf(a4)), null);
            i4 = 1;
        }
        if (i4 > a4) {
            GDTLogger.w(String.format("\u539f\u751f\u5e7f\u544a\u8bf7\u6c42\u6570\u91cf\u8303\u56f4\u4e3a[1, %s]\uff0c\u5df2\u5c06\u672c\u6b21\u5e7f\u544a\u8bf7\u6c42\u7684\u5e7f\u544a\u6570\u91cf\u8bbe\u4e3a%s", Integer.valueOf(a4), Integer.valueOf(a4)), null);
        } else {
            a4 = i4;
        }
        this.f43782l = a4;
        com.qq.e.comm.plugin.l0.b bVar = new com.qq.e.comm.plugin.l0.b(this.f43773c, this.f43776f);
        com.qq.e.comm.plugin.b.d a5 = a(a4, loadAdParams);
        com.qq.e.comm.plugin.l0.d.a(a5, bVar, new b(a5.K()));
    }

    public g(Context context, ADSize aDSize, String str, String str2, com.qq.e.comm.plugin.b.l lVar, ADListener aDListener, String str3, com.qq.e.comm.plugin.b.g gVar) {
        this.f43786p = -1;
        this.f43788r = -1;
        this.f43793w = new com.qq.e.comm.plugin.n0.c();
        this.f43773c = gVar;
        this.f43774d = context;
        this.f43775e = str;
        this.f43776f = str2;
        this.f43777g = str3;
        this.f43779i = aDSize;
        this.f43781k = aDListener;
        this.f43780j = lVar;
        this.f43778h = com.qq.e.comm.plugin.util.b.a(str, str2);
        this.f43793w.c(str2);
        this.f43793w.a(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(JSONObject jSONObject, boolean z3) {
        Pair<Integer, Object> b4 = b(jSONObject, z3);
        Integer num = (Integer) b4.first;
        Object obj = b4.second;
        JSONObject jSONObject2 = obj instanceof JSONObject ? (JSONObject) obj : null;
        if (num.intValue() == 0 && jSONObject2 != null) {
            if (!a(jSONObject2)) {
                Context context = this.f43774d;
                String str = this.f43775e;
                String str2 = this.f43776f;
                com.qq.e.comm.plugin.b.g gVar = this.f43773c;
                com.qq.e.comm.plugin.b.g gVar2 = com.qq.e.comm.plugin.b.g.UNIFIED_BANNER;
                m mVar = new m(false, this, context, str, str2, gVar == gVar2 ? gVar2 : com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD, this.f43780j, this.f43779i, false, this.f43793w);
                this.f43790t = mVar;
                mVar.a(this);
            } else {
                this.f43790t = new i(this, this.f43774d, this.f43775e, this.f43776f, this.f43777g, this.f43773c, this.f43780j, this.f43779i, false, this.f43793w);
            }
            this.f43790t.a(jSONObject, new c(), z3);
            return;
        }
        b(num.intValue());
    }

    protected Pair<Integer, Object> b(JSONObject jSONObject, boolean z3) {
        int optInt = jSONObject.optInt("ret");
        if (optInt != 0) {
            com.qq.e.comm.plugin.l0.e.a(this.f43793w, optInt, z3);
            return new Pair<>(Integer.valueOf(optInt), Integer.valueOf(optInt));
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            com.qq.e.comm.plugin.l0.e.a(this.f43793w, 5004, z3);
            return new Pair<>(5004, 5004);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.f43776f);
        if (optJSONObject2 == null) {
            com.qq.e.comm.plugin.l0.e.a(this.f43793w, 5004, z3);
            return new Pair<>(5004, 5004);
        }
        int optInt2 = optJSONObject2.optInt("ret");
        if (optInt2 != 0) {
            com.qq.e.comm.plugin.l0.e.a(this.f43793w, optInt2, z3);
            return new Pair<>(Integer.valueOf(optInt2), Integer.valueOf(optInt2));
        }
        return new Pair<>(Integer.valueOf(optInt2), optJSONObject2);
    }

    protected boolean a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("template");
        return optJSONArray != null && optJSONArray.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i4) {
        p0.a((Runnable) new e(i4));
    }

    public String b() {
        return this.f43778h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements a.b {
        c() {
        }

        @Override // com.qq.e.comm.plugin.gdtnativead.a.b
        public void a(boolean z3, m.d dVar, List<com.qq.e.comm.plugin.g0.e> list, List<NativeExpressADView> list2, List<JSONObject> list3) {
            ArrayList arrayList;
            com.qq.e.comm.plugin.g0.e eVar = null;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = dVar != null ? new ArrayList(dVar.b()) : null;
            }
            if (arrayList != null) {
                int size = arrayList.size();
                g.this.f43791u = new String[size];
                g.this.f43792v = new String[size];
                for (int i4 = 0; i4 < size; i4++) {
                    g.this.f43792v[i4] = ((com.qq.e.comm.plugin.g0.e) arrayList.get(i4)).U0();
                    g.this.f43791u[i4] = ((com.qq.e.comm.plugin.g0.e) arrayList.get(i4)).S();
                }
                if (size > 0) {
                    eVar = (com.qq.e.comm.plugin.g0.e) arrayList.get(0);
                    if (g.this.c().f()) {
                        com.qq.e.comm.plugin.t.c.d().a(eVar, "exrec", 3).a();
                    }
                }
            }
            com.qq.e.comm.plugin.l0.e.b(g.this.f43793w, list2 != null ? list2.size() : 0);
            g.this.a(list2, eVar);
        }

        @Override // com.qq.e.comm.plugin.gdtnativead.a.b
        public void a(int i4, int i5, boolean z3) {
            g.this.b(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<NativeExpressADView> list, com.qq.e.comm.plugin.g0.e eVar) {
        new Handler(Looper.getMainLooper()).post(new d(list, eVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.b.d a(int i4) {
        return a(i4, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.b.d a(int i4, LoadAdParams loadAdParams) {
        return a(i4, loadAdParams, false);
    }

    protected com.qq.e.comm.plugin.b.d a(int i4, LoadAdParams loadAdParams, boolean z3) {
        com.qq.e.comm.plugin.b.d dVar = new com.qq.e.comm.plugin.b.d();
        dVar.f(this.f43776f);
        dVar.g(this.f43777g);
        dVar.a(1);
        dVar.b(i4);
        dVar.c(2);
        dVar.l(this.f43773c.d());
        dVar.j(this.f43779i.getWidth());
        dVar.i(this.f43779i.getHeight());
        dVar.f(this.f43785o);
        dVar.e(com.qq.e.comm.plugin.o0.d.a(this.f43784n));
        dVar.a(this.f43780j);
        dVar.e(this.f43789s);
        if (z3) {
            dVar.n(1);
        } else {
            dVar.n(0);
        }
        dVar.a(com.qq.e.comm.plugin.dl.i.a().a(this.f43773c));
        if (loadAdParams != null) {
            dVar.a(loadAdParams.getDevExtra());
        }
        a(dVar);
        return dVar;
    }

    protected void a(com.qq.e.comm.plugin.b.d dVar) {
        if (com.qq.e.comm.plugin.gdtnativead.d.b(this.f43776f)) {
            dVar.a(true);
        }
    }

    @Override // com.qq.e.comm.plugin.u.b
    public final VideoOption a() {
        return this.f43783m;
    }

    public void a(boolean z3) {
        this.f43787q = z3;
    }
}
