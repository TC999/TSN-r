package com.qq.e.comm.plugin.g0.l0;

import android.util.Pair;
import com.qq.e.comm.plugin.b.m;
import com.qq.e.comm.plugin.l0.d;
import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f43679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a(com.qq.e.comm.plugin.g0.l0.a aVar);

        void a(com.qq.e.comm.plugin.s.b bVar);
    }

    static {
        String str = c.f43616o;
    }

    public e(String str) {
        this.f43679a = str;
    }

    public void a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, m mVar, b bVar2, com.qq.e.comm.plugin.n0.c cVar) {
        boolean K = dVar.K();
        long currentTimeMillis = System.currentTimeMillis();
        com.qq.e.comm.plugin.g0.l0.b.b(dVar, bVar.a(), 1);
        com.qq.e.comm.plugin.l0.d.a(dVar, bVar, new a(cVar, K, bVar2, dVar, bVar, mVar, currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f43680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f43681b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f43682c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f43683d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.l0.b f43684e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ m f43685f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f43686g;

        a(com.qq.e.comm.plugin.n0.c cVar, boolean z3, b bVar, com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar2, m mVar, long j4) {
            this.f43680a = cVar;
            this.f43681b = z3;
            this.f43682c = bVar;
            this.f43683d = dVar;
            this.f43684e = bVar2;
            this.f43685f = mVar;
            this.f43686g = j4;
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(JSONObject jSONObject) {
            int length;
            Pair<JSONArray, Pair<Integer, Integer>> a4 = com.qq.e.comm.plugin.util.c.a(jSONObject, e.this.f43679a, this.f43680a, this.f43681b);
            JSONArray jSONArray = (JSONArray) a4.first;
            Pair pair = (Pair) a4.second;
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                com.qq.e.comm.plugin.l0.e.a(this.f43680a, length);
                List<JSONObject> a5 = com.qq.e.comm.plugin.util.c.a(jSONArray, this.f43685f, (boolean[]) null, this.f43683d);
                if (a5.isEmpty()) {
                    com.qq.e.comm.plugin.l0.e.a(5014, this.f43680a, length);
                    this.f43682c.a(new com.qq.e.comm.plugin.s.b("ad filtered", 5014));
                    com.qq.e.comm.plugin.g0.l0.b.b(this.f43683d, this.f43684e.a(), 4);
                    return;
                }
                this.f43682c.a(new com.qq.e.comm.plugin.g0.l0.a(new CopyOnWriteArrayList(a5)));
                h b4 = new h(2301003).b(System.currentTimeMillis() - this.f43686g).b(this.f43683d.c());
                b4.a(this.f43680a);
                v.a(b4);
                com.qq.e.comm.plugin.g0.l0.b.b(this.f43683d, this.f43684e.a(), 2);
                return;
            }
            this.f43682c.a(new com.qq.e.comm.plugin.s.b("parse error", ((Integer) pair.first).intValue()));
            com.qq.e.comm.plugin.g0.l0.b.b(this.f43683d, this.f43684e.a(), 3);
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            b bVar2 = this.f43682c;
            if (bVar2 != null) {
                bVar2.a(bVar);
                com.qq.e.comm.plugin.g0.l0.b.b(this.f43683d, this.f43684e.a(), 5);
                return;
            }
            com.qq.e.comm.plugin.g0.l0.b.b(this.f43683d, this.f43684e.a(), 6);
        }
    }
}
