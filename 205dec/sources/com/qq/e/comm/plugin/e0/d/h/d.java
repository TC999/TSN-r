package com.qq.e.comm.plugin.e0.d.h;

import android.os.SystemClock;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d<T> extends com.qq.e.comm.plugin.e0.d.h.a<T> implements com.qq.e.comm.plugin.e0.d.i.b {

    /* renamed from: d  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.e0.e.d> f42824d;

    /* renamed from: e  reason: collision with root package name */
    private final int f42825e;

    /* renamed from: f  reason: collision with root package name */
    private final int f42826f;

    /* renamed from: g  reason: collision with root package name */
    private String f42827g;

    /* renamed from: h  reason: collision with root package name */
    private long f42828h;

    /* renamed from: i  reason: collision with root package name */
    private com.qq.e.comm.plugin.e0.e.e f42829i;

    /* renamed from: j  reason: collision with root package name */
    private volatile T f42830j;

    /* renamed from: k  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.e0.e.d f42831k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f42832l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f42833m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a("MSDK S2SBiddingAdaptersLoader ", "timeout mIsLoading: " + d.this.f42832l);
            if (d.this.f42832l) {
                d.this.a();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f42833m) {
                d.this.f42833m = false;
                d.this.f42810c.a(false);
                v.a(1145002, (com.qq.e.comm.plugin.n0.c) null);
            }
        }
    }

    public d(List<com.qq.e.comm.plugin.e0.e.d> list, int i4, int i5, String str, c<T> cVar) {
        super(cVar);
        this.f42824d = list;
        this.f42825e = i4;
        this.f42826f = i5;
        this.f42827g = str;
    }

    private void g() {
        this.f42808a.postAtTime(new a(), this.f42809b, SystemClock.uptimeMillis() + this.f42825e);
    }

    public List<com.qq.e.comm.plugin.e0.e.d> c() {
        return this.f42824d;
    }

    public com.qq.e.comm.plugin.e0.e.e d() {
        return this.f42829i;
    }

    public void e() {
        this.f42832l = true;
        List<com.qq.e.comm.plugin.e0.e.d> list = this.f42824d;
        if (list != null && list.size() > 0) {
            this.f42828h = System.currentTimeMillis();
            com.qq.e.comm.plugin.e0.d.i.c.a(this.f42824d, this.f42827g, this);
            g();
            return;
        }
        d1.a("MSDK S2SBiddingAdaptersLoader ", "loadBiddingConfigs: no bidding config");
        a();
    }

    public void f() {
        if (this.f42830j == null) {
            d1.b("MSDK S2SBiddingAdaptersLoader ", "S2S win but S2S_Adapter is null!");
            this.f42810c.a(false);
            return;
        }
        this.f42833m = true;
        this.f42808a.postAtTime(new b(), this.f42809b, SystemClock.uptimeMillis() + this.f42826f);
        c<T> cVar = this.f42810c;
        T t3 = this.f42830j;
        int a4 = this.f42831k.a();
        com.qq.e.comm.plugin.e0.e.e eVar = this.f42829i;
        cVar.a((c<T>) t3, a4, eVar != null ? eVar.f() : "");
    }

    public void a(com.qq.e.comm.plugin.e0.e.b<T> bVar) {
        if (this.f42833m && this.f42830j == bVar.a()) {
            this.f42833m = false;
            int f4 = bVar.f();
            this.f42831k.b(bVar.g());
            this.f42831k.a(bVar.d());
            this.f42831k.a(bVar.e());
            boolean z3 = f4 == 3;
            if (!z3) {
                v.a(1145001, (com.qq.e.comm.plugin.n0.c) null);
            }
            this.f42810c.a(z3);
        }
    }

    @Override // com.qq.e.comm.plugin.e0.d.h.a
    protected void a() {
        d1.a("MSDK S2SBiddingAdaptersLoader ", "finishLoad: " + this.f42832l);
        if (this.f42832l) {
            this.f42832l = false;
            this.f42808a.removeCallbacksAndMessages(this.f42809b);
            this.f42810c.a(this, (d<T>) this.f42830j, this.f42831k);
        }
    }

    @Override // com.qq.e.comm.plugin.e0.d.i.b
    public void a(com.qq.e.comm.plugin.e0.e.e eVar, Map<Integer, com.qq.e.comm.plugin.e0.e.d> map) {
        if (eVar == null) {
            if (this.f42832l) {
                for (com.qq.e.comm.plugin.e0.e.d dVar : this.f42824d) {
                    dVar.c(1);
                }
                a();
                return;
            }
            return;
        }
        this.f42829i = eVar;
        this.f42831k = map.get(Integer.valueOf(eVar.a()));
        if (this.f42831k != null) {
            int c4 = eVar.c();
            if (this.f42832l) {
                this.f42831k.c(3);
            }
            this.f42831k.b(c4);
            this.f42831k.e(-1);
            this.f42831k.a(c4 - 1);
            this.f42831k.b(Integer.valueOf((int) (System.currentTimeMillis() - this.f42828h)));
        }
        JSONArray b4 = eVar.b();
        if (b4 != null && b4.length() > 0) {
            for (int i4 = 0; i4 < b4.length(); i4++) {
                JSONObject optJSONObject = b4.optJSONObject(i4);
                com.qq.e.comm.plugin.e0.e.d dVar2 = map.get(Integer.valueOf(optJSONObject.optInt("adnet_id")));
                if (dVar2 != null) {
                    dVar2.a(Integer.valueOf(optJSONObject.optInt("load_ec")));
                    dVar2.a(optJSONObject.optString("load_em"));
                    dVar2.c(optJSONObject.optInt("load_state"));
                    int optInt = optJSONObject.optInt("ecpm");
                    dVar2.b(optInt);
                    dVar2.e(-1);
                    dVar2.a(optInt - 1);
                }
            }
        }
        this.f42830j = this.f42810c.a(this.f42831k);
        a();
    }
}
