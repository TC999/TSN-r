package com.beizi.ad.c;

import com.beizi.ad.c.d;
import com.beizi.ad.c.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdRequest.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdRequest.java */
    /* renamed from: com.beizi.ad.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class C0116a {

        /* renamed from: a  reason: collision with root package name */
        private String f13250a;

        /* renamed from: b  reason: collision with root package name */
        private String f13251b;

        /* renamed from: c  reason: collision with root package name */
        private String f13252c;

        /* renamed from: d  reason: collision with root package name */
        private long f13253d;

        /* renamed from: e  reason: collision with root package name */
        private String f13254e;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: AdRequest.java */
        /* renamed from: com.beizi.ad.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class C0117a {

            /* renamed from: a  reason: collision with root package name */
            private String f13255a;

            /* renamed from: b  reason: collision with root package name */
            private String f13256b;

            /* renamed from: c  reason: collision with root package name */
            private String f13257c;

            /* renamed from: d  reason: collision with root package name */
            private long f13258d;

            /* renamed from: e  reason: collision with root package name */
            private String f13259e;

            public C0117a a(String str) {
                this.f13255a = str;
                return this;
            }

            public C0117a b(String str) {
                this.f13256b = str;
                return this;
            }

            public C0117a c(String str) {
                this.f13257c = str;
                return this;
            }

            public C0116a a() {
                C0116a c0116a = new C0116a();
                c0116a.f13253d = this.f13258d;
                c0116a.f13252c = this.f13257c;
                c0116a.f13254e = this.f13259e;
                c0116a.f13251b = this.f13256b;
                c0116a.f13250a = this.f13255a;
                return c0116a;
            }
        }

        private C0116a() {
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("spaceID", this.f13250a);
                jSONObject.put("spaceParam", this.f13251b);
                jSONObject.put("requestUUID", this.f13252c);
                jSONObject.put("channelReserveTs", this.f13253d);
                jSONObject.put("sdkExtInfo", this.f13254e);
                return jSONObject;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdRequest.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f13260a;

        /* renamed from: b  reason: collision with root package name */
        private e.i f13261b;

        /* renamed from: c  reason: collision with root package name */
        private e.g f13262c;

        /* renamed from: d  reason: collision with root package name */
        private long f13263d;

        /* renamed from: e  reason: collision with root package name */
        private String f13264e;

        /* renamed from: f  reason: collision with root package name */
        private String f13265f;

        /* renamed from: g  reason: collision with root package name */
        private String f13266g;

        /* renamed from: h  reason: collision with root package name */
        private long f13267h;

        /* renamed from: i  reason: collision with root package name */
        private long f13268i;

        /* renamed from: j  reason: collision with root package name */
        private d.a f13269j;

        /* renamed from: k  reason: collision with root package name */
        private d.c f13270k;

        /* renamed from: l  reason: collision with root package name */
        private ArrayList<C0116a> f13271l;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: AdRequest.java */
        /* renamed from: com.beizi.ad.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class C0118a {

            /* renamed from: a  reason: collision with root package name */
            private String f13272a;

            /* renamed from: b  reason: collision with root package name */
            private e.i f13273b;

            /* renamed from: c  reason: collision with root package name */
            private e.g f13274c;

            /* renamed from: d  reason: collision with root package name */
            private long f13275d;

            /* renamed from: e  reason: collision with root package name */
            private String f13276e;

            /* renamed from: f  reason: collision with root package name */
            private String f13277f;

            /* renamed from: g  reason: collision with root package name */
            private String f13278g;

            /* renamed from: h  reason: collision with root package name */
            private long f13279h;

            /* renamed from: i  reason: collision with root package name */
            private long f13280i;

            /* renamed from: j  reason: collision with root package name */
            private d.a f13281j;

            /* renamed from: k  reason: collision with root package name */
            private d.c f13282k;

            /* renamed from: l  reason: collision with root package name */
            private ArrayList<C0116a> f13283l = new ArrayList<>();

            public C0118a a(String str) {
                this.f13272a = str;
                return this;
            }

            public C0118a b(String str) {
                this.f13276e = str;
                return this;
            }

            public C0118a c(String str) {
                this.f13277f = str;
                return this;
            }

            public C0118a d(String str) {
                this.f13278g = str;
                return this;
            }

            public C0118a a(e.i iVar) {
                this.f13273b = iVar;
                return this;
            }

            public C0118a b(long j4) {
                this.f13279h = j4;
                return this;
            }

            public C0118a c(long j4) {
                this.f13280i = j4;
                return this;
            }

            public C0118a a(e.g gVar) {
                this.f13274c = gVar;
                return this;
            }

            public C0118a a(long j4) {
                this.f13275d = j4;
                return this;
            }

            public C0118a a(d.a aVar) {
                this.f13281j = aVar;
                return this;
            }

            public C0118a a(d.c cVar) {
                this.f13282k = cVar;
                return this;
            }

            public b a() {
                b bVar = new b();
                bVar.f13264e = this.f13276e;
                bVar.f13269j = this.f13281j;
                bVar.f13262c = this.f13274c;
                bVar.f13267h = this.f13279h;
                bVar.f13261b = this.f13273b;
                bVar.f13263d = this.f13275d;
                bVar.f13266g = this.f13278g;
                bVar.f13268i = this.f13280i;
                bVar.f13270k = this.f13282k;
                bVar.f13271l = this.f13283l;
                bVar.f13265f = this.f13277f;
                bVar.f13260a = this.f13272a;
                return bVar;
            }

            public void a(C0116a c0116a) {
                this.f13283l.add(c0116a);
            }
        }

        public String toString() {
            return a();
        }

        private b() {
        }

        private String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", this.f13260a);
                jSONObject.put("srcType", this.f13261b);
                jSONObject.put("reqType", this.f13262c);
                jSONObject.put("timeStamp", this.f13263d);
                jSONObject.put("appid", this.f13264e);
                jSONObject.put("appVersion", this.f13265f);
                jSONObject.put("apkName", this.f13266g);
                jSONObject.put("appInstallTime", this.f13267h);
                jSONObject.put("appUpdateTime", this.f13268i);
                d.a aVar = this.f13269j;
                if (aVar != null) {
                    jSONObject.put("devInfo", aVar.a());
                }
                d.c cVar = this.f13270k;
                if (cVar != null) {
                    jSONObject.put("envInfo", cVar.a());
                }
                ArrayList<C0116a> arrayList = this.f13271l;
                if (arrayList != null && arrayList.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i4 = 0; i4 < this.f13271l.size(); i4++) {
                        jSONArray.put(this.f13271l.get(i4).a());
                    }
                    jSONObject.put("adReqInfo", jSONArray);
                }
                return jSONObject.toString();
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }
}
