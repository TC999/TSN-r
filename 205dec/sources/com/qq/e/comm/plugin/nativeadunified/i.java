package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.l0.d;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.k1;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i implements NUADI, com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a {

    /* renamed from: c  reason: collision with root package name */
    private String f44932c;

    /* renamed from: d  reason: collision with root package name */
    private String f44933d;

    /* renamed from: e  reason: collision with root package name */
    private String f44934e;

    /* renamed from: f  reason: collision with root package name */
    private String f44935f;

    /* renamed from: g  reason: collision with root package name */
    private com.qq.e.comm.plugin.b.l f44936g;

    /* renamed from: h  reason: collision with root package name */
    private String f44937h;

    /* renamed from: i  reason: collision with root package name */
    private ADListener f44938i;

    /* renamed from: j  reason: collision with root package name */
    private List<String> f44939j;

    /* renamed from: k  reason: collision with root package name */
    private String[] f44940k;

    /* renamed from: l  reason: collision with root package name */
    private String[] f44941l;

    /* renamed from: m  reason: collision with root package name */
    private int f44942m;

    /* renamed from: n  reason: collision with root package name */
    private int f44943n;

    /* renamed from: o  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f44944o;

    /* renamed from: p  reason: collision with root package name */
    private Handler f44945p;

    /* renamed from: q  reason: collision with root package name */
    private volatile int f44946q;

    /* renamed from: r  reason: collision with root package name */
    private volatile int f44947r;

    /* renamed from: s  reason: collision with root package name */
    long f44948s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f44949c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LoadAdParams f44950d;

        a(int i4, LoadAdParams loadAdParams) {
            this.f44949c = i4;
            this.f44950d = loadAdParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.b(this.f44949c, this.f44950d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f44952a;

        b(boolean z3) {
            this.f44952a = z3;
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(JSONObject jSONObject) {
            i.this.a(jSONObject, this.f44952a);
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            GDTLogger.e("\u539f\u751f\u5e7f\u544a\u52a0\u8f7d\u5931\u8d25,error=" + bVar.a());
            i.this.a(bVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f44954c;

        c(List list) {
            this.f44954c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f44938i != null) {
                i.this.f44938i.onADEvent(new ADEvent(100, this.f44954c));
                com.qq.e.comm.plugin.n0.c cVar = i.this.f44944o;
                List list = this.f44954c;
                com.qq.e.comm.plugin.l0.e.c(cVar, list != null ? list.size() : 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f44956c;

        d(int i4) {
            this.f44956c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f44938i != null) {
                i.this.f44938i.onADEvent(new ADEvent(101, Integer.valueOf(this.f44956c)));
            }
        }
    }

    static {
        com.qq.e.comm.plugin.dl.i.a().b(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD);
    }

    public i(Context context, String str, String str2, String str3, ADListener aDListener) {
        this(context, str, str2, com.qq.e.comm.plugin.b.l.f42027d, str3, aDListener);
    }

    public com.qq.e.comm.plugin.b.l c() {
        return this.f44936g;
    }

    public String e() {
        return this.f44933d;
    }

    public int g() {
        return this.f44942m;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        return this.f44940k;
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        return this.f44941l;
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return this.f44943n;
    }

    public String h() {
        return this.f44934e;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i4) {
        loadData(i4, null);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setCategories(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f44939j = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                this.f44939j.add(str);
            }
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMaxVideoDuration(int i4) {
        this.f44947r = i4;
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.f44937h = str;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMinVideoDuration(int i4) {
        this.f44946q = i4;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVastClassName(String str) {
    }

    public i(Context context, String str, String str2, com.qq.e.comm.plugin.b.l lVar, String str3, ADListener aDListener) {
        this.f44942m = -1;
        this.f44943n = -1;
        this.f44944o = new com.qq.e.comm.plugin.n0.c();
        this.f44945p = new Handler(Looper.getMainLooper());
        this.f44932c = str;
        this.f44933d = str2;
        this.f44934e = str3;
        this.f44935f = com.qq.e.comm.plugin.util.b.a(str, str2);
        this.f44936g = lVar;
        this.f44938i = aDListener;
        this.f44944o.c(str2);
        this.f44944o.a(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4, LoadAdParams loadAdParams) {
        com.qq.e.comm.plugin.l0.b bVar = new com.qq.e.comm.plugin.l0.b(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD, this.f44933d);
        com.qq.e.comm.plugin.b.d a4 = a(i4, loadAdParams);
        com.qq.e.comm.plugin.l0.d.a(a4, bVar, new b(a4.K()));
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i4, LoadAdParams loadAdParams) {
        if (Build.VERSION.SDK_INT < 16) {
            a(4007);
            return;
        }
        if (i4 < 1) {
            GDTLogger.w("\u539f\u751f\u5e7f\u544a\u8bf7\u6c42\u6570\u91cf\u8303\u56f4\u4e3a[1, 10]\uff0c\u5df2\u5c06\u672c\u6b21\u5e7f\u544a\u8bf7\u6c42\u7684\u5e7f\u544a\u6570\u91cf\u8bbe\u4e3a1", null);
            i4 = 1;
        }
        if (i4 > 10) {
            GDTLogger.w("\u539f\u751f\u5e7f\u544a\u8bf7\u6c42\u6570\u91cf\u8303\u56f4\u4e3a[1, 10]\uff0c\u5df2\u5c06\u672c\u6b21\u5e7f\u544a\u8bf7\u6c42\u7684\u5e7f\u544a\u6570\u91cf\u8bbe\u4e3a10", null);
            i4 = 10;
        }
        d0.f46408d.submit(new a(i4, loadAdParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, boolean z3) {
        JSONObject optJSONObject;
        int optInt = jSONObject.optInt("ret");
        if (optInt != 0) {
            a(optInt);
            com.qq.e.comm.plugin.l0.e.a(this.f44944o, optInt, z3);
            return;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(this.f44933d)) != null) {
            int optInt2 = optJSONObject.optInt("ret");
            if (optInt2 != 0) {
                a(optInt2);
                com.qq.e.comm.plugin.l0.e.a(this.f44944o, optInt2, z3);
                return;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                com.qq.e.comm.plugin.l0.e.a(this.f44944o, optJSONArray.length());
                List<NativeUnifiedADData> arrayList = new ArrayList<>();
                List<JSONObject> a4 = com.qq.e.comm.plugin.util.c.a(optJSONArray, new com.qq.e.comm.plugin.b.m(this.f44933d, com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD, (com.qq.e.comm.plugin.b.f) null));
                int size = a4.size();
                this.f44940k = new String[size];
                this.f44941l = new String[size];
                boolean z4 = false;
                int i4 = 0;
                for (JSONObject jSONObject2 : a4) {
                    f fVar = new f(jSONObject2, this);
                    if (!z4) {
                        this.f44942m = fVar.v();
                        this.f44943n = fVar.getMediationPrice();
                        z4 = true;
                    }
                    this.f44940k[i4] = fVar.t();
                    this.f44941l[i4] = fVar.u();
                    i4++;
                    arrayList.add(fVar);
                }
                int size2 = arrayList.size();
                if (size2 <= 0) {
                    com.qq.e.comm.plugin.l0.e.a(5014, this.f44944o, size);
                    a(5004);
                    return;
                }
                com.qq.e.comm.plugin.l0.e.b(this.f44944o, size2);
                this.f44948s = System.currentTimeMillis();
                a(arrayList);
                return;
            }
            a(5004);
            com.qq.e.comm.plugin.l0.e.a(this.f44944o, 5025, z3);
            return;
        }
        a(5004);
        com.qq.e.comm.plugin.l0.e.a(this.f44944o, 5004, z3);
    }

    public String b() {
        return this.f44932c;
    }

    private void a(List<NativeUnifiedADData> list) {
        this.f44945p.post(new c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        this.f44945p.post(new d(i4));
    }

    public com.qq.e.comm.plugin.b.d a(int i4, LoadAdParams loadAdParams) {
        com.qq.e.comm.plugin.b.d dVar = new com.qq.e.comm.plugin.b.d();
        dVar.f(this.f44933d);
        dVar.g(this.f44934e);
        dVar.a(1);
        dVar.b(i4);
        dVar.a(this.f44936g);
        dVar.e(this.f44937h);
        dVar.c(2);
        dVar.l(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD.d());
        dVar.a(this.f44939j);
        dVar.f(this.f44946q);
        dVar.e(com.qq.e.comm.plugin.o0.d.a(this.f44947r));
        dVar.a(k1.a(this.f44933d));
        dVar.a(com.qq.e.comm.plugin.dl.i.a().a(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD));
        if (loadAdParams != null) {
            dVar.a(loadAdParams.getDevExtra());
        }
        return dVar;
    }

    public String a() {
        return this.f44935f;
    }
}
