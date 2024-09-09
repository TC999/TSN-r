package com.qq.e.comm.plugin.a0.d;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.b.d;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.q0.s.f;
import com.qq.e.comm.plugin.q0.s.g;
import com.qq.e.comm.plugin.q0.u.j;
import com.qq.e.comm.plugin.rewardvideo.c;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends j {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, b> f41716a = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.a0.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0779a extends c {
        private final String D;
        private final String E;

        public C0779a(a aVar, Context context, String str, String str2, ADListener aDListener, String str3, String str4) {
            super(context, str, str2, "", aDListener);
            this.D = str3;
            this.E = str4;
        }

        @Override // com.qq.e.comm.plugin.rewardvideo.c
        protected boolean b(int i4) {
            d1.a(com.qq.e.comm.plugin.g0.l0.c.f43616o, "enablePreload, H5 \u6fc0\u52b1\u89c6\u9891\u4e0d\u4f7f\u7528\u9884\u52a0\u8f7d\u529f\u80fd");
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qq.e.comm.plugin.rewardvideo.c
        public d c() {
            d c4 = super.c();
            c4.d(1);
            c4.i(this.D);
            c4.j(this.E);
            return c4;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private final com.qq.e.comm.plugin.q0.s.d f41717a;

        /* renamed from: b  reason: collision with root package name */
        private C0779a f41718b;

        /* renamed from: c  reason: collision with root package name */
        private final g f41719c;

        public b(g gVar, com.qq.e.comm.plugin.q0.s.d dVar) {
            this.f41719c = gVar;
            this.f41717a = dVar;
        }

        private void b() {
            this.f41719c.a(new e(this.f41717a, e.a.f45548c, a.this.a("onADClick", 0, null, 0L), 1));
        }

        private void c() {
            this.f41719c.a(new e(this.f41717a, e.a.f45548c, a.this.a("onADClose", 0, null, 0L), 1));
        }

        private void d() {
            this.f41719c.a(new e(this.f41717a, e.a.f45548c, a.this.a("onADExpose", 0, null, 0L), 1));
        }

        private void e() {
            C0779a c0779a = this.f41718b;
            this.f41719c.a(new e(this.f41717a, e.a.f45548c, a.this.a("onADLoad", 0, null, c0779a == null ? 0L : (c0779a.getExpireTimestamp() - SystemClock.elapsedRealtime()) + (System.currentTimeMillis() / 1000)), 1));
        }

        private void f() {
            this.f41719c.a(new e(this.f41717a, e.a.f45548c, a.this.a("onADShow", 0, null, 0L), 1));
        }

        private void g() {
            this.f41719c.a(new e(this.f41717a, e.a.f45548c, a.this.a("onVideoCached", 0, null, 0L), 1));
        }

        private void h() {
            this.f41719c.a(new e(this.f41717a, e.a.f45548c, a.this.a("onVideoComplete", 0, null, 0L), 1));
        }

        public C0779a a() {
            return this.f41718b;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                e();
            } else if (type == 201) {
                g();
            } else if (type != 206) {
                switch (type) {
                    case 102:
                        f();
                        return;
                    case 103:
                        d();
                        return;
                    case 104:
                        String str = (String) aDEvent.getParam(String.class);
                        if (str != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("transId", str);
                            a(hashMap);
                            return;
                        }
                        return;
                    case 105:
                        b();
                        return;
                    case 106:
                        c();
                        return;
                    case 107:
                        Integer num = (Integer) aDEvent.getParam(Integer.class);
                        if (num != null) {
                            a(AdErrorConvertor.formatErrorCode(num.intValue()));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                h();
            }
        }

        public void a(C0779a c0779a) {
            this.f41718b = c0779a;
        }

        private void a(Map<String, Object> map) {
            this.f41719c.a(new e(this.f41717a, e.a.f45548c, a.this.a("onReward", 0, null, 0L), 1));
        }

        private void a(AdError adError) {
            this.f41719c.a(new e(this.f41717a, e.a.f45548c, a.this.a("onError", adError.getErrorCode(), adError.getErrorMsg(), 0L), 1));
        }
    }

    public String a() {
        return "h5RewardVideo";
    }

    @Override // com.qq.e.comm.plugin.q0.u.j
    public f<String> a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        String a4 = dVar.a();
        JSONObject d4 = dVar.d();
        String b4 = dVar.b();
        g c4 = hVar.c();
        if (TextUtils.isEmpty(a4) || TextUtils.isEmpty(b4)) {
            c4.a(new e(dVar, e.a.f45549d, "Params Empty !", 1));
            d1.a(a4 + ": Params Empty !");
            v.a(21072, null, 1);
            return new f<>(null);
        } else if (d4 == null) {
            c4.a(new e(dVar, e.a.f45551f, "Json \u89e3\u6790\u7ed3\u679c\u4e3a\u7a7a !", 1));
            d1.a(a4 + ": Json \u89e3\u6790\u7ed3\u679c\u4e3a\u7a7a !");
            v.a(21072, null, 4);
            return new f<>(null);
        } else {
            String optString = d4.optString("instance_id");
            String optString2 = d4.optString("placement_id");
            String optString3 = d4.optString("ext_url");
            String optString4 = d4.optString("xflow_pos_id");
            com.qq.e.comm.plugin.n0.c c5 = new com.qq.e.comm.plugin.n0.c().a(com.qq.e.comm.plugin.b.g.REWARDVIDEOAD).c(optString2);
            if ("registerRewardVideoAD".equals(a4)) {
                v.a(21012, c5);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    b bVar = new b(c4, dVar);
                    bVar.a(new C0779a(this, com.qq.e.comm.plugin.d0.a.d().a(), com.qq.e.comm.plugin.d0.a.d().b().a(), optString2, bVar, optString3, optString4));
                    if (this.f41716a.size() < com.qq.e.comm.plugin.d0.a.d().f().a("maxRewardVideoAdsPerWebview", 100)) {
                        this.f41716a.put(optString, bVar);
                        c4.a(new e(dVar, e.a.f45548c, a("onRegisterSuccess", 0, null, 0L), 1));
                    } else {
                        c4.a(new e(dVar, e.a.f45548c, a("onError", 4001, "\u4f20\u5165\u7684\u53c2\u6570\u6709\u9519\u8bef", 0L), 1));
                        v.a(21002, c5);
                    }
                    return new f<>(null);
                }
                c4.a(new e(dVar, e.a.f45548c, a("onError", 4001, "\u4f20\u5165\u7684\u53c2\u6570\u6709\u9519\u8bef", 0L), 1));
                v.a(21072, c5, 6);
                return new f<>(null);
            } else if ("loadRewardVideoAD".equals(a4)) {
                v.a(21022, c5);
                if (TextUtils.isEmpty(optString)) {
                    v.a(21072, c5, 2);
                    d1.a("loadRewardVideoAD : instanceID is empty !");
                    return new f<>(null);
                }
                b bVar2 = this.f41716a.get(optString);
                C0779a a5 = bVar2 != null ? bVar2.a() : null;
                if (a5 == null) {
                    c4.a(new e(dVar, e.a.f45548c, a("onError", 4017, "\u5e7f\u544a\u5b9e\u4f8b\u5c1a\u672a\u51c6\u5907\u597d", 0L), 1));
                } else {
                    a5.loadAD();
                }
                return new f<>(null);
            } else if ("showRewardVideoAD".equals(a4)) {
                v.a(21032, c5);
                if (TextUtils.isEmpty(optString)) {
                    v.a(21072, c5, 3);
                    d1.a("showRewardVideoAD : instanceID is empty !");
                    return new f<>(null);
                }
                b bVar3 = this.f41716a.get(optString);
                C0779a a6 = bVar3 != null ? bVar3.a() : null;
                if (a6 == null) {
                    c4.a(new e(dVar, e.a.f45548c, a("onError", 4017, "\u5e7f\u544a\u5b9e\u4f8b\u5c1a\u672a\u51c6\u5907\u597d", 0L), 1));
                } else {
                    a6.showAD();
                }
                return new f<>(null);
            } else {
                v.a(21072, c5, 5);
                return new f<>(1000, "Unsupported action");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, int i4, String str2, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i4);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("data", jSONObject2);
            jSONObject2.put("action", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("message", str2);
            }
            if (j4 > 0) {
                jSONObject2.put("expiredTimestamp", j4);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }
}
