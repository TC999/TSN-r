package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import android.util.Pair;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.plugin.g0.q;
import com.qq.e.comm.plugin.gdtnativead.a;
import com.qq.e.comm.plugin.rewardvideo.e;
import com.qq.e.comm.plugin.u.f;
import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m extends com.qq.e.comm.plugin.gdtnativead.a {

    /* renamed from: p  reason: collision with root package name */
    private static final String f43896p = "m";

    /* renamed from: l  reason: collision with root package name */
    private final boolean f43897l;

    /* renamed from: m  reason: collision with root package name */
    private final com.qq.e.comm.plugin.u.b f43898m;

    /* renamed from: n  reason: collision with root package name */
    private a.b f43899n;

    /* renamed from: o  reason: collision with root package name */
    private c f43900o;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a extends d {
        public a(Context context, int i4, int i5, VideoOption videoOption) {
            super(context, i4, i5, videoOption);
        }

        @Override // com.qq.e.comm.plugin.gdtnativead.m.d
        public void a(q qVar) {
            this.f43901a.add(qVar);
            this.f43902b.add(new com.qq.e.comm.plugin.banner2.b(this.f43903c, qVar, -1));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends d {
        public b(Context context, int i4, int i5, VideoOption videoOption) {
            super(context, i4, i5, videoOption);
        }

        @Override // com.qq.e.comm.plugin.gdtnativead.m.d
        public void a(q qVar) {
            this.f43901a.add(qVar);
            this.f43902b.add(new com.qq.e.comm.plugin.u.e(this.f43903c, qVar, -1));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends d {
        public c(Context context, int i4, int i5, VideoOption videoOption) {
            super(context, i4, i5, videoOption);
        }

        @Override // com.qq.e.comm.plugin.gdtnativead.m.d
        public void a(q qVar) {
            this.f43901a.add(qVar);
            this.f43902b.add(new com.qq.e.comm.plugin.z.a(this.f43903c, qVar, -1));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d implements e.a<q> {

        /* renamed from: a  reason: collision with root package name */
        protected final List<q> f43901a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        protected final List<com.qq.e.comm.plugin.u.a> f43902b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        protected final Context f43903c;

        /* renamed from: d  reason: collision with root package name */
        private final int f43904d;

        /* renamed from: e  reason: collision with root package name */
        private final int f43905e;

        /* renamed from: f  reason: collision with root package name */
        private final VideoOption f43906f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class a extends com.qq.e.comm.plugin.u.a {
            a(d dVar, Context context, q qVar, int i4) {
                super(context, qVar, i4);
            }

            @Override // com.qq.e.comm.plugin.u.a
            protected com.qq.e.comm.plugin.u.f a(Context context, q qVar, VideoOption videoOption, f.a aVar, com.qq.e.comm.plugin.n0.c cVar) {
                return new com.qq.e.comm.plugin.u.k.c(context, qVar, videoOption, aVar, cVar);
            }
        }

        public d(Context context, int i4, int i5, VideoOption videoOption) {
            this.f43903c = context;
            this.f43904d = i4;
            this.f43905e = i5;
            this.f43906f = videoOption;
        }

        @Override // com.qq.e.comm.plugin.rewardvideo.e.a
        /* renamed from: b */
        public q a(String str, String str2, String str3, String str4, com.qq.e.comm.plugin.b.g gVar, JSONObject jSONObject, com.qq.e.comm.plugin.b.l lVar) {
            q qVar = new q(str, str2, str3, str4, gVar, lVar, jSONObject, this.f43904d, this.f43905e, this.f43906f);
            a(qVar);
            return qVar;
        }

        public boolean c() {
            return this.f43902b.isEmpty() || this.f43901a.isEmpty();
        }

        public void a(q qVar) {
            this.f43901a.add(qVar);
            this.f43902b.add(new a(this, this.f43903c, qVar, -1));
        }

        public List<q> b() {
            return Collections.unmodifiableList(this.f43901a);
        }

        public List<com.qq.e.comm.plugin.u.a> a() {
            return Collections.unmodifiableList(this.f43902b);
        }
    }

    public m(boolean z3, com.qq.e.comm.plugin.u.b bVar, Context context, String str, String str2, com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.b.l lVar, ADSize aDSize, boolean z4, com.qq.e.comm.plugin.n0.c cVar) {
        super(context, str, str2, "", gVar, lVar, aDSize, z4, cVar);
        this.f43897l = z3;
        this.f43898m = bVar;
        d1.a(f43896p, "NativeExpressADParserImpl2");
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a
    public void a(JSONObject jSONObject, a.b bVar, boolean z3) {
        this.f43899n = bVar;
        Pair<JSONArray, Pair<Integer, Integer>> a4 = com.qq.e.comm.plugin.util.c.a(jSONObject, this.f43752d, this.f43758j, z3);
        JSONArray jSONArray = (JSONArray) a4.first;
        if (jSONArray != null) {
            int length = jSONArray.length();
            com.qq.e.comm.plugin.l0.e.a(this.f43758j, length);
            List<JSONObject> a5 = com.qq.e.comm.plugin.util.c.a(jSONArray, new com.qq.e.comm.plugin.b.m(this.f43752d, this.f43754f, (com.qq.e.comm.plugin.b.f) null));
            if (a5.size() <= 0) {
                if (a(bVar)) {
                    bVar.a(0, 5004, true);
                }
                com.qq.e.comm.plugin.l0.e.a(5014, this.f43758j, length);
                return;
            }
            if (this.f43754f == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL && a5.size() > 1) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(a5.get(0));
                a5 = arrayList;
            }
            a(a5, this.f43757i);
            return;
        }
        Pair pair = (Pair) a4.second;
        if (pair == null || !a(bVar)) {
            return;
        }
        bVar.a(((Integer) pair.second).intValue(), ((Integer) pair.first).intValue(), false);
    }

    public List<NativeExpressADView> b() {
        return a(this.f43900o);
    }

    public void a(List<JSONObject> list, boolean z3) {
        d dVar;
        Pair<Integer, Integer> a4 = com.qq.e.comm.plugin.util.m.a(this.f43756h, this.f43750b);
        com.qq.e.comm.plugin.b.g gVar = this.f43754f;
        if (gVar == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL) {
            dVar = new c(this.f43750b, ((Integer) a4.first).intValue(), ((Integer) a4.second).intValue(), this.f43898m.a());
        } else if (gVar == com.qq.e.comm.plugin.b.g.UNIFIED_BANNER) {
            dVar = new a(this.f43750b, ((Integer) a4.first).intValue(), ((Integer) a4.second).intValue(), this.f43898m.a());
        } else if (gVar == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
            dVar = new b(this.f43750b, ((Integer) a4.first).intValue(), ((Integer) a4.second).intValue(), this.f43898m.a());
        } else {
            dVar = new d(this.f43750b, ((Integer) a4.first).intValue(), ((Integer) a4.second).intValue(), this.f43898m.a());
        }
        com.qq.e.comm.plugin.rewardvideo.e.a(this.f43751c, this.f43752d, this.f43753e, (String) null, this.f43754f, this.f43755g, list, dVar);
        List<q> b4 = dVar.b();
        if (b4 != null && b4.size() > 0) {
            if (a(b4.get(0), this.f43899n)) {
                return;
            }
            if (this.f43897l) {
                a.b bVar = this.f43899n;
                if (bVar != null) {
                    bVar.a(z3, dVar, null, null, null);
                    return;
                }
                return;
            }
            List<NativeExpressADView> a5 = a(dVar);
            a.b bVar2 = this.f43899n;
            if (bVar2 != null) {
                bVar2.a(z3, dVar, null, a5, null);
                return;
            }
            return;
        }
        a.b bVar3 = this.f43899n;
        if (bVar3 != null) {
            bVar3.a(5004, 5004, false);
        }
    }

    public List<NativeExpressADView> a(d dVar) {
        if (dVar != null && !dVar.c()) {
            List<com.qq.e.comm.plugin.u.a> a4 = dVar.a();
            List<q> b4 = dVar.b();
            ArrayList arrayList = new ArrayList(a4.size());
            for (int i4 = 0; i4 < Math.min(b4.size(), a4.size()); i4++) {
                HashMap<String, Object> a5 = a(b4.get(i4));
                arrayList.add(new n(this.f43749a, a4.get(i4), this.f43750b, this.f43756h, this.f43751c, this.f43752d, this.f43753e, null, a5));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public q a(JSONObject jSONObject) {
        Pair<Integer, Integer> a4 = com.qq.e.comm.plugin.util.m.a(this.f43756h, this.f43750b);
        c cVar = new c(this.f43750b, ((Integer) a4.first).intValue(), ((Integer) a4.second).intValue(), this.f43749a.a());
        this.f43900o = cVar;
        return (q) com.qq.e.comm.plugin.rewardvideo.e.a(this.f43751c, this.f43752d, this.f43753e, (String) null, this.f43754f, this.f43755g, jSONObject, cVar);
    }

    public d a() {
        return this.f43900o;
    }
}
