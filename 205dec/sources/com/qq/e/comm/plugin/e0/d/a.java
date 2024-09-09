package com.qq.e.comm.plugin.e0.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.api.AdError;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.plugin.m0.a;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.a2;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.s0;
import com.qq.e.comm.plugin.util.t0;
import com.qq.e.mediation.interfaces.IBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a<T> implements com.qq.e.comm.plugin.e0.d.j.d<T> {

    /* renamed from: c  reason: collision with root package name */
    private final d f42768c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.e0.e.a f42769d;

    /* renamed from: f  reason: collision with root package name */
    protected Context f42771f;

    /* renamed from: g  reason: collision with root package name */
    protected Context f42772g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f42773h;

    /* renamed from: i  reason: collision with root package name */
    private String f42774i;

    /* renamed from: j  reason: collision with root package name */
    private com.qq.e.comm.plugin.e0.e.d f42775j;

    /* renamed from: k  reason: collision with root package name */
    private com.qq.e.comm.plugin.e0.e.d f42776k;

    /* renamed from: l  reason: collision with root package name */
    private com.qq.e.comm.plugin.e0.d.j.a<T> f42777l;

    /* renamed from: m  reason: collision with root package name */
    private final String f42778m;

    /* renamed from: n  reason: collision with root package name */
    private long f42779n;

    /* renamed from: o  reason: collision with root package name */
    private final Random f42780o;

    /* renamed from: e  reason: collision with root package name */
    private final List<Integer> f42770e = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private int f42781p = 900;

    /* renamed from: q  reason: collision with root package name */
    private int f42782q = 990;

    /* renamed from: r  reason: collision with root package name */
    protected Handler f42783r = new Handler(Looper.getMainLooper());

    /* renamed from: s  reason: collision with root package name */
    private Map<Integer, Long> f42784s = new HashMap();

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.e0.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0806a implements a.i {
        C0806a() {
        }

        @Override // com.qq.e.comm.plugin.m0.a.i
        public void a() {
            a.this.f42777l.a();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    protected interface b {
        void a();

        void a(ADEvent aDEvent);

        void b();

        void b(ADEvent aDEvent);

        void c();

        void c(ADEvent aDEvent);

        void d();

        void d(ADEvent aDEvent);

        void e();
    }

    public a(Context context, String str) {
        d a4 = d.a(context);
        this.f42768c = a4;
        this.f42769d = a4.a(str);
        this.f42771f = context.getApplicationContext();
        this.f42772g = context;
        this.f42778m = str;
        this.f42780o = new Random();
        j();
        h();
        if (this.f42769d == null) {
            v.a((int) AdError.ERROR_CODE_CACHE_AD_MATERIAL_FAIL, new com.qq.e.comm.plugin.n0.c().c(str));
            d1.b("MSDK BaseMediator ", "Mediator do not get layer config");
        }
    }

    private int b(T t3) {
        if (t3 instanceof com.qq.e.comm.plugin.e0.b) {
            int mediationPrice = ((com.qq.e.comm.plugin.e0.b) t3).getMediationPrice();
            if (mediationPrice <= 0) {
                f.a(mediationPrice, this.f42778m);
            }
            return mediationPrice;
        }
        return a((a<T>) t3);
    }

    private String g() {
        if (this.f42770e.contains(Integer.valueOf(this.f42775j.a()))) {
            com.qq.e.comm.plugin.e0.e.d dVar = this.f42776k;
            if (dVar != null) {
                return String.valueOf(dVar.q());
            }
            d1.a("MSDK BaseMediator bidding config is filled and waterfall isn't finished", new Object[0]);
            return String.valueOf(Math.round(this.f42775j.r()));
        }
        return String.valueOf(this.f42775j.f());
    }

    private void h() {
        String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("meprblrange", "");
        if (TextUtils.isEmpty(b4)) {
            return;
        }
        try {
            String[] split = b4.split(",");
            if (split.length == 2) {
                this.f42781p = Integer.parseInt(split[0]);
                int parseInt = Integer.parseInt(split[1]);
                this.f42782q = parseInt;
                if (this.f42781p >= parseInt || this.f42781p > 1000 || parseInt > 1000) {
                    this.f42781p = 900;
                    this.f42782q = 990;
                }
            }
        } catch (Exception e4) {
            d1.a("MSDK BaseMediator ", "get black list price range error", e4);
        }
        d1.a("MSDK BaseMediator ", "mRandomMinValue: " + this.f42781p + ", mRandomMaxValue:" + this.f42782q);
    }

    private String i() {
        String uuid;
        if (!e1.j()) {
            Pair<String, String> d4 = a2.d();
            if (d4 != null && !TextUtils.isEmpty((CharSequence) d4.first)) {
                uuid = (String) d4.first;
            } else {
                uuid = com.qq.e.comm.plugin.m.b.f44639e.a(this.f42771f);
            }
        } else {
            uuid = UUID.randomUUID().toString();
        }
        return s0.a(uuid + System.currentTimeMillis());
    }

    private void j() {
        String[] split = com.qq.e.comm.plugin.d0.a.d().f().b("retrealtpr", "100").split(",");
        if (split.length > 0) {
            for (String str : split) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        this.f42770e.add(Integer.valueOf(str));
                    }
                } catch (Exception e4) {
                    d1.b("MSDK BaseMediator ", "getUseMpBlackList error " + e4.getMessage());
                }
            }
        }
    }

    private void n() {
        this.f42775j = null;
        this.f42776k = null;
        this.f42774i = null;
        this.f42777l = null;
    }

    protected abstract int a(T t3);

    protected abstract T b(com.qq.e.comm.plugin.e0.e.d dVar);

    protected abstract void b(T t3, int i4);

    protected abstract void b(T t3, int i4, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(T t3, int i4) {
        if (t3 == null) {
            return;
        }
        g.a(t3.hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put("adapter", t3.getClass().getSimpleName());
        a(i4, hashMap);
    }

    protected abstract String d(T t3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(T t3, int i4) {
        if (t3 == null) {
            return;
        }
        this.f42777l.b(true);
        g.a(t3.hashCode(), System.currentTimeMillis() - this.f42779n);
        HashMap hashMap = new HashMap();
        hashMap.put("adapter", t3.getClass().getSimpleName());
        a(i4, hashMap);
    }

    protected abstract void e(T t3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(T t3, int i4) {
        if (t3 == null) {
            return;
        }
        g.b(t3.hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put("adapter", t3.getClass().getSimpleName());
        a(i4, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(T t3) {
        d1.a("MSDK BaseMediator onAdapterLoadSuccess: " + t3, new Object[0]);
        com.qq.e.comm.plugin.e0.e.b<T> bVar = new com.qq.e.comm.plugin.e0.e.b<>();
        bVar.a((com.qq.e.comm.plugin.e0.e.b<T>) t3);
        bVar.b(3);
        bVar.a(b((a<T>) t3));
        bVar.b(d(t3));
        bVar.a(Integer.valueOf((int) (System.currentTimeMillis() - this.f42784s.get(Integer.valueOf(t3.hashCode())).longValue())));
        this.f42777l.a(bVar);
    }

    public String getECPMLevel() {
        com.qq.e.comm.plugin.e0.e.d dVar = this.f42775j;
        if (dVar == null) {
            return null;
        }
        if (dVar.u()) {
            return g();
        }
        return String.valueOf(this.f42775j.q());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k() {
        return this.f42774i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        if (this.f42769d == null) {
            d1.b("MSDK BaseMediator ", "loadAdInternal none layer config");
        } else if (!this.f42773h) {
            this.f42779n = System.currentTimeMillis();
            v.a(1231006, (com.qq.e.comm.plugin.n0.c) null);
            n();
            if (this.f42769d.l()) {
                this.f42777l = new com.qq.e.comm.plugin.e0.d.j.b(this.f42769d, this);
            } else {
                this.f42777l = new com.qq.e.comm.plugin.e0.d.j.c(this.f42769d, this);
            }
            this.f42773h = true;
            d1.a("MSDK BaseMediator loadAdInternal mediation id: " + this.f42769d.e(), new Object[0]);
            this.f42768c.a(false);
            if (e1.j()) {
                com.qq.e.comm.plugin.m0.a.l().a(new C0806a());
            } else {
                this.f42777l.a();
            }
        } else {
            d1.b("MSDK BaseMediator ", "loadAdInternal mediator last loading not finish");
        }
    }

    public void sendLossNotification(int i4, int i5, String str) {
    }

    public void sendLossNotification(Map<String, Object> map) {
    }

    public void sendWinNotification(int i4) {
    }

    public void sendWinNotification(Map<String, Object> map) {
    }

    public void setBidECPM(int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t3, ADEvent aDEvent) {
        String str;
        Integer num;
        d1.a("MSDK BaseMediator onAdapterLoadFailed: " + t3, new Object[0]);
        if (t0.b(t3.toString())) {
            num = (Integer) aDEvent.getParam(0, Integer.class);
            str = "no_reason";
        } else {
            Integer num2 = (Integer) aDEvent.getParam(1, Integer.class);
            str = (String) aDEvent.getParam(2, String.class);
            num = num2;
        }
        com.qq.e.comm.plugin.e0.e.b<T> bVar = new com.qq.e.comm.plugin.e0.e.b<>();
        bVar.a((com.qq.e.comm.plugin.e0.e.b<T>) t3);
        bVar.b(1);
        bVar.a(-1);
        bVar.b((String) null);
        bVar.a(Integer.valueOf((int) (System.currentTimeMillis() - this.f42784s.get(Integer.valueOf(t3.hashCode())).longValue())));
        bVar.b(num);
        bVar.a(str);
        this.f42777l.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<String, Object> c(T t3) {
        if (a()) {
            return ((IBaseAd) t3).getExtraInfo();
        }
        String d4 = d(t3);
        HashMap hashMap = new HashMap();
        if (d4 != null) {
            hashMap.put(ConstantAd.KEY_CACHE_AD, d4);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        return e1.h() >= 441;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(T t3, int i4) {
        if (t3 == null) {
            return;
        }
        g.c(t3.hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put("adapter", t3.getClass().getSimpleName());
        a(i4, hashMap);
    }

    private boolean c() {
        return e1.h() >= 450;
    }

    @Override // com.qq.e.comm.plugin.e0.d.j.d
    public T a(com.qq.e.comm.plugin.e0.e.d dVar) {
        T b4 = b(dVar);
        d1.a("MSDK BaseMediator onCreateAdapter ", new Object[0]);
        if (c()) {
            try {
                dVar.a((IBaseAd) b4);
            } catch (Exception e4) {
                d1.a("MSDK BaseMediator onCreateAdapter: error " + e4.toString(), new Object[0]);
            }
        }
        return b4;
    }

    @Override // com.qq.e.comm.plugin.e0.d.j.d
    public void a(T t3, int i4) {
        b(t3, i4);
    }

    @Override // com.qq.e.comm.plugin.e0.d.j.d
    public void a(T t3, int i4, String str) {
        b(t3, i4, str);
    }

    @Override // com.qq.e.comm.plugin.e0.d.j.d
    public void a(T t3, com.qq.e.comm.plugin.e0.e.d dVar, List<com.qq.e.comm.plugin.e0.e.d> list, com.qq.e.comm.plugin.e0.e.d dVar2) {
        d1.a("MSDK BaseMediator finishLoad adapter: " + t3 + ", config: " + dVar + ", firstLoseConfig: " + dVar2, new Object[0]);
        String i4 = i();
        if (dVar != null) {
            this.f42774i = dVar.o();
            dVar.a(true);
            dVar.d(a(dVar.f()));
            this.f42775j = dVar;
            g.a(t3, dVar, i4, this.f42769d.c());
        }
        if (dVar2 != null) {
            if (dVar != null) {
                g.a(dVar.p(), dVar2.n(), dVar2.p());
            }
            this.f42776k = dVar2;
        }
        a(i4, list);
        e(t3);
        a(list);
        this.f42773h = false;
        this.f42784s.clear();
    }

    private void a(List<com.qq.e.comm.plugin.e0.e.d> list) {
        boolean c4 = c();
        d1.a("MSDK BaseMediator callback3rdPartyAdn: canSend " + c4, new Object[0]);
        if (!c4 || list == null || list.size() == 0) {
            return;
        }
        for (com.qq.e.comm.plugin.e0.e.d dVar : list) {
            if (dVar.u()) {
                IBaseAd c5 = dVar.c();
                if (c5 != null) {
                    if (dVar.v()) {
                        c5.sendWinNotification(dVar.f());
                        c5.setBidECPM(-1);
                    } else {
                        c5.sendLossNotification(-1, -1, "");
                    }
                }
                dVar.a((IBaseAd) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.qq.e.comm.plugin.b.g gVar, int i4, long j4, T t3) {
        this.f42784s.put(Integer.valueOf(t3.hashCode()), Long.valueOf(j4));
        f.a(i4, j4, new com.qq.e.comm.plugin.n0.c().a(gVar).c(this.f42778m));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.qq.e.comm.plugin.b.g gVar) {
        f.a(this.f42779n, new com.qq.e.comm.plugin.n0.c().a(gVar).c(this.f42778m));
    }

    private void a(String str, List<com.qq.e.comm.plugin.e0.e.d> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        g.a(arrayList, str, this.f42769d.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i4, com.qq.e.comm.plugin.e0.e.d dVar) {
        HashMap hashMap = new HashMap();
        if (dVar != null) {
            hashMap.put("config_name", dVar.o());
            hashMap.put("config_class_name", dVar.e());
            hashMap.put("identity", dVar.p());
        }
        a(i4, hashMap);
    }

    private void a(int i4, Map<String, Object> map) {
        com.qq.e.comm.plugin.n0.d dVar = map == null ? new com.qq.e.comm.plugin.n0.d() : new com.qq.e.comm.plugin.n0.d(new JSONObject(map));
        com.qq.e.comm.plugin.e0.e.a aVar = this.f42769d;
        dVar.a("layer_timeout", Integer.valueOf(aVar == null ? 0 : aVar.i()));
        d1.a("MSDK BaseMediator \u57cb\u70b9=" + dVar.toString(), new Object[0]);
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        com.qq.e.comm.plugin.e0.e.a aVar2 = this.f42769d;
        v.a(i4, cVar.c(aVar2 == null ? "" : aVar2.e()), null, null, dVar);
    }

    private int a(int i4) {
        int nextInt = this.f42780o.nextInt(this.f42782q - this.f42781p) + this.f42781p;
        int i5 = (nextInt * i4) / 1000;
        d1.a("MSDK BaseMediator getBiddingPrice finalEcmp: " + i5 + ", factor: " + nextInt + ", rawEcpm: " + i4, new Object[0]);
        return i5;
    }

    private boolean a() {
        return e1.h() >= 464;
    }
}
