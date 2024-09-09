package com.qq.e.comm.plugin.q;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dysi.IDynamicScriptLifecycle;
import com.qq.e.comm.plugin.dysi.IGDTADM;
import com.qq.e.comm.plugin.dysi.IGDTAdDataHelper;
import com.qq.e.comm.plugin.dysi.IGDTAudioPlayer;
import com.qq.e.comm.plugin.dysi.IGDTBiz;
import com.qq.e.comm.plugin.dysi.IGDTSDK;
import com.qq.e.comm.plugin.dysi.IGDTVideoPlayer;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.k2;
import com.qq.e.comm.plugin.util.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements com.qq.e.comm.plugin.h.f {

    /* renamed from: s  reason: collision with root package name */
    private static final String f45374s = "var GDTEnv={OS:2,Android:2,iOS:1,EngineVersion:15,OSVersion:" + Build.VERSION.SDK_INT + "};var GDTViewNode={VISIBLE:0,INVISIBLE:1,GONE:2};";

    /* renamed from: c  reason: collision with root package name */
    private f f45375c;

    /* renamed from: d  reason: collision with root package name */
    private long f45376d;

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.dynamic.b f45377e;

    /* renamed from: f  reason: collision with root package name */
    private final com.qq.e.comm.plugin.q.a f45378f;

    /* renamed from: g  reason: collision with root package name */
    private final p.h f45379g;

    /* renamed from: j  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f45382j;

    /* renamed from: k  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f45383k;

    /* renamed from: l  reason: collision with root package name */
    private final y f45384l;

    /* renamed from: m  reason: collision with root package name */
    private int f45385m;

    /* renamed from: n  reason: collision with root package name */
    private Map<Integer, Object> f45386n;

    /* renamed from: p  reason: collision with root package name */
    private com.qq.e.comm.plugin.apkmanager.w.a f45388p;

    /* renamed from: q  reason: collision with root package name */
    private IGDTBiz f45389q;

    /* renamed from: i  reason: collision with root package name */
    private final com.qq.e.comm.plugin.h.e f45381i = new com.qq.e.comm.plugin.h.e();

    /* renamed from: o  reason: collision with root package name */
    private boolean f45387o = false;

    /* renamed from: r  reason: collision with root package name */
    private final Runnable f45390r = new d();

    /* renamed from: h  reason: collision with root package name */
    private final Handler f45380h = new Handler(Looper.getMainLooper());

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements p.h {
        a() {
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            e.this.f45378f.onAppForeground();
            return false;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            e.this.f45378f.onAppBackground();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements IGDTSDK {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f45392a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.dl.l.l.b f45393b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ q f45394c;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements com.qq.e.dl.f.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f45396a;

            a(String str) {
                this.f45396a = str;
            }

            @Override // com.qq.e.dl.f.b
            public void a(String str) {
                e.this.b(this.f45396a);
            }
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.q.e$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0873b implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f45398c;

            RunnableC0873b(String str) {
                this.f45398c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.e(this.f45398c);
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class c extends com.qq.e.comm.plugin.h.d<Pair<String, com.qq.e.comm.plugin.g0.e>> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f45400b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f45401c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f45402d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ JSONObject f45403e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(com.qq.e.comm.plugin.h.f fVar, String str, String str2, int i4, JSONObject jSONObject) {
                super(fVar);
                this.f45400b = str;
                this.f45401c = str2;
                this.f45402d = i4;
                this.f45403e = jSONObject;
            }

            @Override // com.qq.e.comm.plugin.h.d
            /* renamed from: a */
            public void b(Pair<String, com.qq.e.comm.plugin.g0.e> pair) {
                if (pair == null) {
                    d1.a("DynamicScript", "onAdLoaded error, pair null");
                    return;
                }
                if (this.f45400b.equals((String) pair.first)) {
                    b.this.a(this.f45401c, this.f45402d, this.f45400b, (com.qq.e.comm.plugin.g0.e) pair.second, this.f45403e);
                } else {
                    d1.a("DynamicScript", "onAdLoaded ignore, inex mismatch");
                }
            }
        }

        b(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.dl.l.l.b bVar, q qVar) {
            this.f45392a = eVar;
            this.f45393b = bVar;
            this.f45394c = qVar;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void bindData(String str) {
            int optInt;
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("extAd");
                int length = optJSONArray == null ? 0 : optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    if (!JSONObject.NULL.equals(optJSONObject)) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("dlInfo");
                        if (!JSONObject.NULL.equals(optJSONObject2) && (optInt = optJSONObject2.optInt("adModel", -1)) >= 0) {
                            optJSONObject2.put("adModel", this.f45392a.a(optInt));
                        }
                    }
                }
                this.f45393b.a(jSONObject);
            } catch (JSONException e4) {
                d1.a("DynamicScript", "bindData error", e4);
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void cancelAnimation(String str) {
            com.qq.e.dl.f.i a4 = this.f45393b.a(str);
            if (a4 != null) {
                a4.cancel();
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void clickAdContinued(String str) {
            this.f45394c.b((JSONObject) null);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void cod(String str) {
            if (new j0(str).a().optInt("codType", 0) == 0) {
                this.f45394c.a(new com.qq.e.dl.l.j.c(1, "adClose"));
            } else {
                this.f45394c.b(new com.qq.e.dl.l.j.c(1, "forceCloseAd"));
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public int findViewByTag(String str) {
            View findViewWithTag;
            if (TextUtils.isEmpty(str) || (findViewWithTag = this.f45393b.getRootView().findViewWithTag(str)) == null || e.this.f45386n == null) {
                return -1;
            }
            int identityHashCode = System.identityHashCode(findViewWithTag);
            e.this.f45386n.put(Integer.valueOf(identityHashCode), findViewWithTag);
            return identityHashCode;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public int getSettingInt(String str) {
            return com.qq.e.comm.plugin.t.c.a(str, this.f45392a.q0(), -1, this.f45392a.p0());
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public String getSettingString(String str) {
            return com.qq.e.comm.plugin.t.c.a(str, this.f45392a.q0(), "-1", this.f45392a.p0());
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void interactionContinued(String str) {
            this.f45394c.b((JSONObject) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void loadAd(java.lang.String r11, java.lang.String r12) {
            /*
                r10 = this;
                java.lang.String r0 = "DynamicScript"
                com.qq.e.comm.plugin.g0.e r1 = r10.f45392a
                java.lang.String r1 = r1.l0()
                java.lang.Class<com.qq.e.comm.plugin.callback.biz.DynamicAdCallback> r2 = com.qq.e.comm.plugin.callback.biz.DynamicAdCallback.class
                com.qq.e.comm.plugin.h.b r1 = com.qq.e.comm.plugin.h.a.b(r1, r2)
                com.qq.e.comm.plugin.callback.biz.DynamicAdCallback r1 = (com.qq.e.comm.plugin.callback.biz.DynamicAdCallback) r1
                r2 = -1
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L23
                r3.<init>(r12)     // Catch: java.lang.Exception -> L23
                java.lang.String r12 = "extAdIndex"
                int r2 = r3.optInt(r12, r2)     // Catch: java.lang.Exception -> L24
                java.lang.String r12 = "sas"
                int r12 = r3.optInt(r12)     // Catch: java.lang.Exception -> L24
                goto L2a
            L23:
                r3 = 0
            L24:
                java.lang.String r12 = "index \u89e3\u6790\u5f02\u5e38"
                com.qq.e.comm.plugin.util.d1.a(r0, r12)
                r12 = 0
            L2a:
                r7 = r2
                r8 = r3
                if (r7 >= 0) goto L34
                java.lang.String r11 = "loadAd index error"
                com.qq.e.comm.plugin.util.d1.a(r0, r11)
                return
            L34:
                int r0 = r7 + 2
                java.lang.String r0 = java.lang.String.valueOf(r0)
                r2 = r12 & 2
                r3 = 2
                if (r2 != r3) goto L50
                com.qq.e.comm.plugin.g0.e r2 = r10.f45392a
                com.qq.e.comm.plugin.g0.e r6 = r2.a(r7)
                if (r6 == 0) goto L50
                r2 = r10
                r3 = r11
                r4 = r7
                r5 = r0
                r7 = r8
                r2.a(r3, r4, r5, r6, r7)
                return
            L50:
                r12 = r12 & 1
                if (r12 != 0) goto L5e
                r6 = 0
                r2 = r10
                r3 = r11
                r4 = r7
                r5 = r0
                r7 = r8
                r2.a(r3, r4, r5, r6, r7)
                return
            L5e:
                com.qq.e.comm.plugin.h.c r12 = r1.t()
                com.qq.e.comm.plugin.q.e$b$c r9 = new com.qq.e.comm.plugin.q.e$b$c
                com.qq.e.comm.plugin.q.e r4 = com.qq.e.comm.plugin.q.e.this
                r2 = r9
                r3 = r10
                r5 = r0
                r6 = r11
                r2.<init>(r4, r5, r6, r7, r8)
                r12.a(r9)
                com.qq.e.comm.plugin.h.c r11 = r1.loadAd()
                r11.b(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.q.e.b.loadAd(java.lang.String, java.lang.String):void");
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void log(String str) {
            e.this.a(str);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void observeDLEngine(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f45394c.a(a(jSONObject.optJSONArray("dlInfo")), a(jSONObject.optJSONArray("animation")));
                if (jSONObject.optInt("GDTAudioPlayer") != 0) {
                    e.this.f45377e.a("GDTAudioPlayer", IGDTAudioPlayer.class, new com.qq.e.comm.plugin.q.d(this.f45394c, e.this.f45382j, e.this.f45384l, e.this.f45377e));
                }
                e.this.f45389q = com.qq.e.comm.plugin.q.b.a(jSONObject.optInt(IGDTBiz.KEY_GDTBIZ), e.this.f45377e, this.f45392a, e.this.f45384l);
                if (jSONObject.optInt(IGDTVideoPlayer.KEY_VIDEO_PLAYER) != 0) {
                    e.this.f45375c = new f(this.f45394c, e.this.f45377e, this.f45392a, e.this.f45384l);
                    e.this.f45377e.a(IGDTVideoPlayer.KEY_VIDEO_PLAYER, IGDTVideoPlayer.class, e.this.f45375c);
                }
                if (jSONObject.optInt("GDTADM") != 0) {
                    e.this.f45377e.a("GDTADM", IGDTADM.class, new com.qq.e.comm.plugin.q.c(this.f45392a, e.this.f45384l));
                }
            } catch (JSONException e4) {
                d1.a("DynamicScript", "observeDLEngine error", e4);
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void rco(String str) {
            com.qq.e.comm.plugin.i.f fVar = new com.qq.e.comm.plugin.i.f(e.this.f45382j);
            JSONObject a4 = new j0(str).a();
            if (a4.optInt("type", 0) == 1) {
                FSCallback fSCallback = (FSCallback) com.qq.e.comm.plugin.h.a.b(e.this.f45382j.l0(), FSCallback.class);
                if (fSCallback == null) {
                    return;
                }
                fVar.f44110g = 4;
                fVar.f44109f = 5;
                fVar.f44106c = 1005;
                fVar.f44116m = true;
                fSCallback.p().b(fVar);
                return;
            }
            if (a4.has("interactiveType")) {
                fVar.f44110g = a4.optInt("interactiveType");
            } else {
                fVar.f44110g = 8;
            }
            if (a4.has("clickArea")) {
                fVar.f44109f = a4.optInt("clickArea");
            }
            if (a4.has("componentId")) {
                fVar.f44106c = a4.optInt("componentId");
            }
            if (a4.has("reportOnly")) {
                fVar.f44116m = a4.optInt("reportOnly", 0) == 1;
            }
            if (a4.has("mdpaIndex")) {
                fVar.f44114k = a4.optInt("mdpaIndex");
            }
            this.f45394c.a(fVar);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void setReducedTime(int i4) {
            com.qq.e.comm.plugin.fs.e.d.a(i4);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void setTimeout(String str, int i4) {
            if (i4 < 0 || TextUtils.isEmpty(str)) {
                return;
            }
            e.this.f45380h.postDelayed(new RunnableC0873b(str), i4);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void showAnimation(String str) {
            if (str != null && str.length() > 12 && str.charAt(0) == '{') {
                JSONObject a4 = new j0(str).a();
                String optString = a4.optString("group", com.qq.e.dl.i.a.f46907o);
                String optString2 = a4.optString("callback");
                r0 = TextUtils.isEmpty(optString2) ? null : new a(optString2);
                str = optString;
            }
            com.qq.e.dl.f.i a5 = this.f45393b.a(str);
            if (a5 != null) {
                a5.a(r0);
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void showAnimationFraction(String str, double d4) {
            com.qq.e.dl.f.i a4 = this.f45393b.a(str);
            if (a4 != null) {
                a4.a((float) d4);
            }
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void tar(int i4) {
            ((FSCallback) com.qq.e.comm.plugin.h.a.b(e.this.f45382j.l0(), FSCallback.class)).x().b(new Pair<>(Integer.valueOf(i4), Long.valueOf(e.this.f45376d)));
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void track(String str) {
            i.b(str, e.this.f45383k);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTSDK
        public void vibrateMobilePhone(String str) {
            k2.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, int i4, String str2, com.qq.e.comm.plugin.g0.e eVar, JSONObject jSONObject) {
            if (eVar != null) {
                eVar.c(3);
                eVar.a(this.f45392a.i0());
                eVar.b(str2);
                this.f45392a.a(i4, eVar);
                q.a(jSONObject, eVar);
            }
            String m4 = eVar != null ? eVar.m() : "\"null\"";
            e eVar2 = e.this;
            eVar2.b(str + "(" + m4 + ", " + jSONObject + ")");
        }

        private List<String> a(JSONArray jSONArray) {
            int length;
            if (jSONArray == null || (length = jSONArray.length()) <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i4 = 0; i4 < length; i4++) {
                arrayList.add(jSONArray.optString(i4));
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements IGDTAdDataHelper {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f45405a;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements com.qq.e.comm.plugin.apkmanager.w.a {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f45407c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f45408d;

            /* compiled from: A */
            /* renamed from: com.qq.e.comm.plugin.q.e$c$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\2450172.dex */
            class RunnableC0874a implements Runnable {

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f45410c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ int f45411d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ int f45412e;

                RunnableC0874a(String str, int i4, int i5) {
                    this.f45410c = str;
                    this.f45411d = i4;
                    this.f45412e = i5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    e.this.a(this.f45410c, this.f45411d, this.f45412e, aVar.f45408d);
                }
            }

            a(String str, String str2) {
                this.f45407c = str;
                this.f45408d = str2;
            }

            @Override // com.qq.e.comm.plugin.apkmanager.w.a
            public void a(String str, int i4, int i5, long j4) {
                if (TextUtils.equals(str, this.f45407c)) {
                    e.this.f45380h.post(new RunnableC0874a(str, i4, i5));
                }
            }
        }

        c(com.qq.e.comm.plugin.g0.e eVar) {
            this.f45405a = eVar;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTAdDataHelper
        public void adsl(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || e.this.f45388p != null) {
                return;
            }
            e.this.a(str, k.e().b(str), -1, str2);
            e.this.f45388p = new a(str, str2);
            k.e().a(str, e.this.f45388p);
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTAdDataHelper
        public String gdm() {
            return com.qq.e.comm.plugin.d0.a.d().c().f42280j;
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTAdDataHelper
        public String gpn() {
            com.qq.e.comm.plugin.g0.e eVar = this.f45405a;
            if (eVar == null || !eVar.X0() || this.f45405a.q() == null) {
                return "";
            }
            String e4 = this.f45405a.q().e();
            return !TextUtils.isEmpty(e4) ? e4 : "";
        }

        @Override // com.qq.e.comm.plugin.dysi.IGDTAdDataHelper
        public void rdsl(String str) {
            if (TextUtils.isEmpty(str) || e.this.f45388p == null) {
                return;
            }
            k.e().b(e.this.f45388p);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (e.this.f45377e != null) {
                    e.this.f45377e.b("GDTSDK.log('ping');");
                }
            } catch (Throwable unused) {
                i.a("GDTSDK.log('ping');", e.this.f45383k);
            }
            e eVar = e.this;
            eVar.a(eVar.f45385m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.q.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0875e implements Runnable {
        RunnableC0875e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b();
        }
    }

    private e(com.qq.e.comm.dynamic.b bVar, q qVar, com.qq.e.dl.l.l.b bVar2, com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        this.f45377e = bVar;
        this.f45382j = eVar;
        this.f45384l = yVar;
        this.f45383k = com.qq.e.comm.plugin.n0.c.a(eVar, yVar);
        a(qVar, bVar2, eVar);
        a(bVar2, eVar, yVar);
        com.qq.e.comm.plugin.q.a a4 = com.qq.e.comm.plugin.q.a.a(this.f45377e, this.f45382j, this.f45384l);
        this.f45378f = a4;
        if (a4 == null) {
            this.f45379g = null;
            return;
        }
        this.f45379g = new a();
        p.b().a(this.f45379g);
        long currentTimeMillis = System.currentTimeMillis();
        this.f45378f.onViewCreate();
        i.b((int) (System.currentTimeMillis() - currentTimeMillis), this.f45383k);
        int a5 = com.qq.e.comm.plugin.d0.a.d().f().a("qpi", 0);
        this.f45385m = a5;
        a(a5);
        e();
    }

    private void a() {
        pro.getVresult(100, 0, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
    }

    private void d(String str) {
        pro.getVresult(101, 0, this, str);
    }

    private void e() {
    }

    private void f() {
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return this.f45387o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object e(String str) {
        com.qq.e.comm.dynamic.b bVar = this.f45377e;
        if (bVar != null) {
            try {
                return bVar.b(str);
            } catch (Throwable th) {
                d1.a("DynamicScript", "safeEvaluate script error", th);
                i.a(str, this.f45383k, th);
                a(th.toString());
                return null;
            }
        }
        return null;
    }

    public IGDTBiz c() {
        return this.f45389q;
    }

    @Override // com.qq.e.comm.plugin.h.f
    public com.qq.e.comm.plugin.h.e g() {
        return this.f45381i;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "typeof(" + str + ")=='undefined' || " + str + "== null";
    }

    public Object b(String str) {
        return e(str);
    }

    public void b() {
        if (this.f45387o) {
            return;
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.f45380h.post(new RunnableC0875e());
            return;
        }
        this.f45387o = true;
        if (this.f45388p != null) {
            k.e().b(this.f45388p);
            this.f45388p = null;
        }
        if (this.f45379g != null) {
            p.b().b(this.f45379g);
        }
        com.qq.e.comm.plugin.q.a aVar = this.f45378f;
        if (aVar != null) {
            aVar.onViewDestroy();
        }
        this.f45380h.removeCallbacksAndMessages(null);
        Map<Integer, Object> map = this.f45386n;
        if (map != null) {
            map.clear();
            this.f45386n = null;
        }
        f();
        this.f45377e.a();
    }

    public static e a(q qVar, com.qq.e.dl.l.l.b bVar, com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        if (TextUtils.isEmpty(bVar.b())) {
            return null;
        }
        com.qq.e.comm.dynamic.b a4 = com.qq.e.comm.dynamic.b.a(1);
        if (a4 == null) {
            i.a(com.qq.e.comm.plugin.n0.c.a(eVar, yVar));
            return null;
        }
        return new e(a4, qVar, bVar, eVar, yVar);
    }

    public IDynamicScriptLifecycle d() {
        return this.f45378f;
    }

    private void a(q qVar, com.qq.e.dl.l.l.b bVar, com.qq.e.comm.plugin.g0.e eVar) {
        this.f45377e.a(AMPSConstants.AMPS_CHANNEL_LOG_TAG_GDT, IGDTSDK.class, new b(eVar, bVar, qVar));
        this.f45377e.a("GDTAdDataHelper", IGDTAdDataHelper.class, new c(eVar));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i4, int i5, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pn", str);
            jSONObject.putOpt("s", Integer.valueOf(i4));
            jSONObject.putOpt("p", Integer.valueOf(i5));
            e(str2 + "(" + jSONObject + ")");
        } catch (JSONException unused) {
            d1.a("DynamicScript", "apk status callback data err");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        Handler handler;
        if (isDestroyed() || (handler = this.f45380h) == null || i4 <= 0) {
            return;
        }
        handler.postDelayed(this.f45390r, i4);
    }

    private void a(com.qq.e.dl.l.l.b bVar, com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        StringBuilder sb = new StringBuilder(f45374s);
        sb.append("var ");
        sb.append("GDTAdInfo");
        sb.append('=');
        sb.append(eVar.m());
        sb.append(';');
        sb.append("var ");
        sb.append("GDTTplInfo");
        sb.append('=');
        sb.append(yVar == null ? "{}" : yVar.n());
        sb.append(';');
        sb.append(bVar.b());
        long currentTimeMillis = System.currentTimeMillis();
        d(sb.toString());
        i.a((int) (System.currentTimeMillis() - currentTimeMillis), this.f45383k);
    }

    public static String a(String str, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("if(typeof(");
        sb.append(str);
        sb.append(")!=='undefined' && ");
        sb.append(str);
        sb.append("!==null)");
        sb.append(str);
        sb.append("(");
        int i4 = 0;
        int length = objArr == null ? 0 : objArr.length;
        while (i4 < length) {
            Object obj = objArr[i4];
            boolean z3 = obj instanceof String;
            if (z3) {
                sb.append('\'');
            }
            sb.append(obj);
            if (z3) {
                sb.append('\'');
            }
            i4++;
            if (i4 != length) {
                sb.append(',');
            }
        }
        sb.append(");");
        return sb.toString();
    }

    public void a(long j4) {
        this.f45376d = j4;
    }
}
