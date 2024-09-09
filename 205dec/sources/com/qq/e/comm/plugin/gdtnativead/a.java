package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.plugin.gdtnativead.m;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected g f43749a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f43750b;

    /* renamed from: c  reason: collision with root package name */
    protected final String f43751c;

    /* renamed from: d  reason: collision with root package name */
    protected final String f43752d;

    /* renamed from: e  reason: collision with root package name */
    protected final String f43753e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.b.g f43754f;

    /* renamed from: g  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.b.l f43755g;

    /* renamed from: h  reason: collision with root package name */
    protected final ADSize f43756h;

    /* renamed from: i  reason: collision with root package name */
    protected final boolean f43757i;

    /* renamed from: j  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.n0.c f43758j;

    /* renamed from: k  reason: collision with root package name */
    protected final C0838a f43759k = new C0838a(null);

    /* compiled from: A */
    @Deprecated
    /* renamed from: com.qq.e.comm.plugin.gdtnativead.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class C0838a {

        /* renamed from: b  reason: collision with root package name */
        private static final String f43760b = "a$a";

        /* renamed from: a  reason: collision with root package name */
        private g f43761a;

        public C0838a(g gVar) {
            this.f43761a = gVar;
        }

        private AdData b(com.qq.e.comm.plugin.g0.e eVar) {
            if (eVar == null) {
                return null;
            }
            com.qq.e.comm.plugin.b.o oVar = new com.qq.e.comm.plugin.b.o();
            oVar.a("ad_id", eVar.k());
            oVar.a("ad_desc", eVar.F());
            oVar.a("ad_title", eVar.J0());
            oVar.a("ad_ecpm", eVar.J());
            oVar.a("ad_ecpm_level", eVar.W0());
            oVar.a("negative_feedback_url", eVar.j0());
            if (!TextUtils.isEmpty(eVar.L0())) {
                oVar.a("ad_pattern_type", 2);
            }
            oVar.a("ad_video_duration", eVar.M0() * 1000);
            int r02 = eVar.r0();
            oVar.a("ad_rt_priority", r02);
            boolean Y0 = eVar.Y0();
            oVar.a("ad_contract_ad", Y0);
            int h02 = eVar.h0();
            oVar.a("ad_mp", h02);
            g gVar = this.f43761a;
            if (gVar != null) {
                gVar.d(r02);
                this.f43761a.a(Y0);
                this.f43761a.c(h02);
            }
            return new com.qq.e.comm.plugin.b.n(oVar, eVar.R());
        }

        public void a(g gVar) {
            this.f43761a = gVar;
        }

        public HashMap<String, Object> a(com.qq.e.comm.plugin.g0.e eVar) {
            HashMap<String, Object> hashMap = new HashMap<>();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adinfo", b(eVar));
                hashMap.put("adinfo", jSONObject);
                hashMap.put("admodel", eVar);
            } catch (JSONException e4) {
                d1.a(f43760b, "getAdMap", e4);
            }
            return hashMap;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a(int i4, int i5, boolean z3);

        void a(boolean z3, m.d dVar, List<com.qq.e.comm.plugin.g0.e> list, List<NativeExpressADView> list2, List<JSONObject> list3);
    }

    public a(Context context, String str, String str2, String str3, com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.b.l lVar, ADSize aDSize, boolean z3, com.qq.e.comm.plugin.n0.c cVar) {
        this.f43750b = context;
        this.f43751c = str;
        this.f43752d = str2;
        this.f43753e = str3;
        this.f43754f = gVar;
        this.f43755g = lVar;
        this.f43756h = aDSize;
        this.f43757i = z3;
        this.f43758j = cVar;
    }

    public void a(g gVar) {
        this.f43749a = gVar;
        this.f43759k.a(gVar);
    }

    public abstract void a(JSONObject jSONObject, b bVar, boolean z3);

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, Object> a(com.qq.e.comm.plugin.g0.e eVar) {
        return this.f43759k.a(eVar);
    }

    public static com.qq.e.comm.plugin.b.n a(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = (JSONObject) hashMap.get("adinfo");
        Object opt = jSONObject != null ? jSONObject.opt("adinfo") : null;
        if (opt instanceof com.qq.e.comm.plugin.b.n) {
            return (com.qq.e.comm.plugin.b.n) opt;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(b bVar) {
        return (bVar == null || this.f43757i) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(com.qq.e.comm.plugin.g0.e eVar, b bVar) {
        if (this.f43754f == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL && eVar.a1()) {
            if (a(bVar)) {
                GDTLogger.e("\u5e7f\u544a\u6837\u5f0f\u6821\u9a8c\u5931\u8d25\uff1a\u63d2\u5c4f\u534a\u5c4f\u5e7f\u544a\u4f7f\u7528\u4e86\u63d2\u5c4f\u5168\u5c4f\u7684\u5e7f\u544a\u4f4d");
                bVar.a(5010, 5010, false);
            }
            com.qq.e.comm.plugin.l0.e.a(5010, this.f43758j, 1);
            return true;
        }
        return false;
    }
}
