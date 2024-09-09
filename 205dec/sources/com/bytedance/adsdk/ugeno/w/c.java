package com.bytedance.adsdk.ugeno.w;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.sdk.component.p.c.w;
import com.bytedance.sdk.component.p.sr.xv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f26340a;

    /* renamed from: b  reason: collision with root package name */
    private float f26341b;

    /* renamed from: c  reason: collision with root package name */
    private List<a> f26342c;

    /* renamed from: d  reason: collision with root package name */
    private long f26343d;

    /* renamed from: e  reason: collision with root package name */
    private long f26344e;

    /* renamed from: f  reason: collision with root package name */
    private String f26345f;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f26346a;

        /* renamed from: b  reason: collision with root package name */
        private float f26347b;

        /* renamed from: c  reason: collision with root package name */
        private String f26348c;

        /* renamed from: d  reason: collision with root package name */
        private long f26349d;

        /* renamed from: e  reason: collision with root package name */
        private String f26350e;

        /* renamed from: f  reason: collision with root package name */
        private float f26351f;

        /* renamed from: g  reason: collision with root package name */
        private float f26352g;

        /* renamed from: h  reason: collision with root package name */
        private float[] f26353h;

        /* renamed from: i  reason: collision with root package name */
        private String f26354i;

        public static a b(JSONObject jSONObject, com.bytedance.adsdk.ugeno.component.b bVar) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.d(jSONObject.optLong("duration"));
            String optString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", optString)) {
                aVar.c(-1.0f);
            } else {
                try {
                    aVar.c(Float.parseFloat(optString));
                } catch (NumberFormatException unused) {
                    aVar.c(1.0f);
                }
            }
            aVar.e(jSONObject.optString("loopMode"));
            aVar.m(jSONObject.optString("type"));
            if (TextUtils.equals(aVar.getType(), "backgroundColor")) {
                String a4 = n0.d.a(jSONObject.optString("valueTo"), bVar.p());
                int a5 = l0.a.a(jSONObject.optString("valueFrom"));
                int a6 = l0.a.a(a4);
                aVar.k(a5);
                aVar.o(a6);
            } else {
                aVar.k((float) jSONObject.optDouble("valueFrom"));
                aVar.o((float) jSONObject.optDouble("valueTo"));
            }
            aVar.p(jSONObject.optString("interpolator"));
            String a7 = n0.d.a(jSONObject.optString("startDelay"), bVar.p());
            Log.d("TAG", "createAnimationModel: ");
            aVar.l(l0.i.c(a7, 0L));
            JSONArray optJSONArray = jSONObject.optJSONArray("values");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                float[] fArr = new float[optJSONArray.length()];
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    fArr[i4] = (float) optJSONArray.optDouble(i4);
                }
                aVar.f(fArr);
            }
            return aVar;
        }

        public long a() {
            return this.f26346a;
        }

        public void c(float f4) {
            this.f26347b = f4;
        }

        public void d(long j4) {
            this.f26346a = j4;
        }

        public void e(String str) {
            this.f26348c = str;
        }

        public void f(float[] fArr) {
            this.f26353h = fArr;
        }

        public String g() {
            return this.f26354i;
        }

        public String getType() {
            return this.f26350e;
        }

        public float h() {
            return this.f26352g;
        }

        public float[] i() {
            return this.f26353h;
        }

        public long j() {
            return this.f26349d;
        }

        public void k(float f4) {
            this.f26351f = f4;
        }

        public void l(long j4) {
            this.f26349d = j4;
        }

        public void m(String str) {
            this.f26350e = str;
        }

        public float n() {
            return this.f26351f;
        }

        public void o(float f4) {
            this.f26352g = f4;
        }

        public void p(String str) {
            this.f26354i = str;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class b implements com.bytedance.adsdk.ugeno.w.b {

        /* renamed from: a  reason: collision with root package name */
        private com.bytedance.adsdk.ugeno.w.b f26355a;

        /* renamed from: b  reason: collision with root package name */
        private String f26356b;

        /* renamed from: d  reason: collision with root package name */
        private JSONObject f26358d;

        /* renamed from: e  reason: collision with root package name */
        private volatile C0364b f26359e;

        /* renamed from: c  reason: collision with root package name */
        private boolean f26357c = true;

        /* renamed from: f  reason: collision with root package name */
        private boolean f26360f = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class a implements xv {
            a() {
            }

            @Override // com.bytedance.sdk.component.p.sr.xv
            public void c(com.bytedance.sdk.component.p.c.c cVar) {
                b.this.e(cVar);
            }

            @Override // com.bytedance.sdk.component.p.sr.xv
            public void c(w wVar) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.adsdk.ugeno.w.c$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class C0364b implements com.bytedance.sdk.component.p.sr.w {

            /* renamed from: a  reason: collision with root package name */
            private h f26362a;

            /* renamed from: b  reason: collision with root package name */
            private b.InterfaceC0363b f26363b;

            /* renamed from: c  reason: collision with root package name */
            b.a f26364c;

            C0364b() {
            }

            public void b(b.a aVar) {
                this.f26364c = aVar;
            }

            @Override // com.bytedance.sdk.component.p.sr.w
            public void c() {
                b.this.k(this.f26362a, this.f26363b, this.f26364c);
            }

            public void d(b.InterfaceC0363b interfaceC0363b) {
                this.f26363b = interfaceC0363b;
            }

            public void e(h hVar) {
                this.f26362a = hVar;
            }
        }

        public b(com.bytedance.adsdk.ugeno.w.b bVar) {
            this.f26355a = bVar;
        }

        private JSONObject b(com.bytedance.adsdk.ugeno.component.b bVar, h hVar, com.bytedance.sdk.component.p.xv.c cVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (cVar == null) {
                    return jSONObject;
                }
                Map<String, String> xv = cVar.xv();
                String c4 = cVar.c();
                hVar.c(bVar);
                jSONObject.put("type", c4);
                if (xv != null && !xv.isEmpty()) {
                    for (Map.Entry<String, String> entry : xv.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
                return jSONObject;
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(com.bytedance.sdk.component.p.c.c cVar) {
            if (this.f26360f) {
                return;
            }
            C0364b j4 = j();
            j4.e(a(j4.f26362a, cVar));
            cVar.c(j4);
        }

        private C0364b j() {
            if (this.f26359e != null) {
                return this.f26359e;
            }
            synchronized (C0364b.class) {
                if (this.f26359e != null) {
                    return this.f26359e;
                }
                this.f26359e = new C0364b();
                return this.f26359e;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
            com.bytedance.adsdk.ugeno.w.b bVar = this.f26355a;
            if (bVar == null) {
                return;
            }
            bVar.c(hVar, interfaceC0363b, aVar);
        }

        private void m(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
            if (this.f26359e == null) {
                this.f26359e = j();
            }
            this.f26359e.e(hVar);
            this.f26359e.d(interfaceC0363b);
            this.f26359e.b(aVar);
            JSONObject i4 = hVar.i();
            if (i4 == null) {
                return;
            }
            new w.c(i4.optString("type")).w(this.f26358d).c(new a()).c().c();
        }

        protected h a(h hVar, com.bytedance.sdk.component.p.c.c cVar) {
            com.bytedance.sdk.component.p.xv.c cVar2;
            if (hVar == null || cVar == null) {
                return hVar;
            }
            h hVar2 = new h();
            com.bytedance.adsdk.ugeno.component.b a4 = hVar.a();
            if (a4 == null) {
                return hVar;
            }
            hVar2.b(hVar.g());
            com.bytedance.sdk.component.p.xv.c r3 = cVar.r();
            JSONObject b4 = b(a4, hVar2, r3);
            com.bytedance.sdk.component.p.xv.xv c4 = com.bytedance.sdk.component.p.xv.w.INSTANCE.c(cVar.sr());
            List<com.bytedance.sdk.component.p.xv.c> c5 = c4.c(r3, a4.p(), new HashMap());
            hVar2.e(b4);
            if (!c5.isEmpty()) {
                com.bytedance.sdk.component.p.xv.c cVar3 = c5.get(0);
                if (cVar3 == null) {
                    return hVar2;
                }
                h hVar3 = new h();
                hVar3.e(b(a4, hVar3, cVar3));
                hVar3.c(a4);
                hVar2.d(hVar3);
            }
            List<com.bytedance.sdk.component.p.xv.c> w3 = c4.w(r3, a4.p(), new HashMap());
            if (w3.isEmpty() || (cVar2 = w3.get(0)) == null) {
                return hVar2;
            }
            h hVar4 = new h();
            hVar4.e(b(a4, hVar4, cVar2));
            hVar4.c(a4);
            hVar2.h(hVar4);
            return hVar2;
        }

        public void f(String str) {
            this.f26356b = str;
        }

        public void g(JSONObject jSONObject) {
            this.f26358d = jSONObject;
        }

        public void h(boolean z3) {
            this.f26357c = z3;
        }

        public boolean i() {
            String str;
            return this.f26357c && (str = this.f26356b) != null && "3".compareTo(str) <= 0 && this.f26358d != null;
        }

        public void l(boolean z3) {
            this.f26360f = z3;
        }

        @Override // com.bytedance.adsdk.ugeno.w.b
        public void c(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
            if (i()) {
                m(hVar, interfaceC0363b, aVar);
            } else {
                k(hVar, interfaceC0363b, aVar);
            }
        }
    }

    public static c a(String str, com.bytedance.adsdk.ugeno.component.b bVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(new JSONObject(str), bVar);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static c b(JSONObject jSONObject, com.bytedance.adsdk.ugeno.component.b bVar) {
        return c(jSONObject, null, bVar);
    }

    public static c c(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.component.b bVar) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.g(jSONObject.optString("ordering"));
        String optString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", optString)) {
            cVar.e(-1.0f);
        } else {
            try {
                cVar.e(Float.parseFloat(optString));
            } catch (NumberFormatException unused) {
                cVar.e(1.0f);
            }
        }
        cVar.f(jSONObject.optLong("duration", 0L));
        cVar.m(l0.i.c(n0.d.a(jSONObject.optString("startDelay"), bVar.p()), 0L));
        cVar.n(jSONObject.optString("loopMode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("animators");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONObject.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (jSONObject2 != null) {
                    l0.h.c(jSONObject2, optJSONObject);
                }
                arrayList.add(a.b(optJSONObject, bVar));
            }
            cVar.h(arrayList);
        }
        return cVar;
    }

    public String d() {
        return this.f26340a;
    }

    public void e(float f4) {
        this.f26341b = f4;
    }

    public void f(long j4) {
        this.f26343d = j4;
    }

    public void g(String str) {
        this.f26340a = str;
    }

    public void h(List<a> list) {
        this.f26342c = list;
    }

    public String i() {
        return this.f26345f;
    }

    public long j() {
        return this.f26343d;
    }

    public long k() {
        return this.f26344e;
    }

    public float l() {
        return this.f26341b;
    }

    public void m(long j4) {
        this.f26344e = j4;
    }

    public void n(String str) {
        this.f26345f = str;
    }

    public List<a> o() {
        return this.f26342c;
    }
}
