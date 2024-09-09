package com.qq.e.comm.plugin.edgeanalytics;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.s0;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: s  reason: collision with root package name */
    public static final c f42986s = new c();

    /* renamed from: a  reason: collision with root package name */
    private int f42987a;

    /* renamed from: b  reason: collision with root package name */
    private String f42988b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f42989c;

    /* renamed from: d  reason: collision with root package name */
    private long f42990d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<g> f42991e;

    /* renamed from: f  reason: collision with root package name */
    private String f42992f;

    /* renamed from: g  reason: collision with root package name */
    private String f42993g;

    /* renamed from: h  reason: collision with root package name */
    private int f42994h;

    /* renamed from: i  reason: collision with root package name */
    private long f42995i;

    /* renamed from: j  reason: collision with root package name */
    private int f42996j;

    /* renamed from: k  reason: collision with root package name */
    private int f42997k;

    /* renamed from: l  reason: collision with root package name */
    private JSONObject f42998l;

    /* renamed from: m  reason: collision with root package name */
    private JSONObject f42999m;

    /* renamed from: n  reason: collision with root package name */
    private String f43000n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f43001o;

    /* renamed from: p  reason: collision with root package name */
    private int f43002p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f43003q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f43004r;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final c f43005a = new c();

        private b b(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            JSONObject a4 = j0.a(str).a();
            if (this.f43005a.c(a4) && this.f43005a.b(a4)) {
                this.f43005a.f42989c = a4.optJSONObject("p");
                this.f43005a.f42993g = a4.optString("sn");
                if (this.f43005a.f42989c != null) {
                    c cVar = this.f43005a;
                    cVar.f42988b = s0.a(this.f43005a.f42993g + " " + this.f43005a.f42989c);
                } else {
                    c cVar2 = this.f43005a;
                    cVar2.f42988b = cVar2.f42993g;
                }
                this.f43005a.f42998l = a4.optJSONObject(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE);
                if (this.f43005a.f42998l == null) {
                    this.f43005a.f42998l = new JSONObject();
                }
                try {
                    this.f43005a.f42998l.put("ph", this.f43005a.f42988b);
                } catch (JSONException unused) {
                }
                c cVar3 = this.f43005a;
                cVar3.f43000n = "f_" + this.f43005a.f42993g;
                this.f43005a.f43001o = a4.optInt("rse", 0) > 0;
                this.f43005a.f43002p = a4.optInt("pf");
                this.f43005a.f43003q = a4.optInt("phv") > 0;
                this.f43005a.f43004r = a4.optInt("sbc", 0) > 0;
                c cVar4 = this.f43005a;
                cVar4.f42996j = a4.optInt(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT, cVar4.f42996j);
                c cVar5 = this.f43005a;
                cVar5.f42994h = a4.optInt("iv", cVar5.f42994h);
                c cVar6 = this.f43005a;
                cVar6.f42990d = a4.optLong("to", cVar6.f42990d);
                c cVar7 = this.f43005a;
                cVar7.f42992f = a4.optString("rk", cVar7.f42992f);
                c cVar8 = this.f43005a;
                cVar8.f42995i = a4.optLong(LiveConfigKey.STANDARD, cVar8.f42995i);
                return this;
            }
            this.f43005a.f42992f = null;
            return this;
        }

        public b a(com.qq.e.comm.plugin.b.g gVar) {
            this.f43005a.f42987a = gVar.c();
            return this;
        }

        public b c(String str) {
            this.f43005a.f42992f = str;
            return this;
        }

        public b a(int i4, int i5) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 == 4) {
                        i4 = i4 * 60 * 60 * 24;
                    } else if (i5 == 5) {
                        i4 *= -1;
                    }
                    this.f43005a.f42994h = i4;
                    return this;
                }
                i4 *= 60;
            }
            i4 *= 60;
            this.f43005a.f42994h = i4;
            return this;
        }

        public b a(long j4) {
            this.f43005a.f42995i = j4;
            return this;
        }

        public b a(int i4) {
            this.f43005a.f42997k = i4;
            return this;
        }

        public b a(JSONObject jSONObject) {
            this.f43005a.f42999m = jSONObject;
            return this;
        }

        public c a(String str) {
            b(str);
            return this.f43005a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j() {
        return this.f42995i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long k() {
        return this.f42990d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f43003q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return (TextUtils.isEmpty(this.f42992f) || TextUtils.isEmpty(this.f42993g)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f43001o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f43004r;
    }

    private c() {
        this.f42996j = -1;
        this.f43003q = false;
        this.f43004r = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f43002p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.f42992f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return this.f43000n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return this.f42993g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f42994h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g d() {
        WeakReference<g> weakReference = this.f42991e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject c() {
        return this.f42998l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(JSONObject jSONObject) {
        int optInt = jSONObject.optInt(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT, this.f42996j);
        this.f42996j = optInt;
        return optInt == -1 || (optInt & this.f42997k) == 1;
    }

    public c a(g gVar) {
        if (gVar != null) {
            this.f42991e = new WeakReference<>(gVar);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f42997k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("atl");
        if (optJSONArray == null) {
            return true;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            if (optJSONArray.optInt(i4) == this.f42987a) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, JSONObject jSONObject, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("var ");
        sb.append(this.f43000n);
        sb.append("=function(params){");
        sb.append(str);
        sb.append("};");
        if (z3) {
            sb.append(a(jSONObject));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(JSONObject jSONObject) {
        j0 a4 = new j0().a("rk", this.f42992f);
        JSONObject jSONObject2 = this.f42989c;
        if (jSONObject2 != null) {
            a4.a("p", jSONObject2);
        }
        if (jSONObject != null) {
            a4.a("cr", jSONObject);
        }
        int i4 = this.f42987a;
        if (i4 != 0) {
            a4.a("adt", i4);
        }
        JSONObject jSONObject3 = this.f42999m;
        if (jSONObject3 != null) {
            a4.a("ext", jSONObject3);
        }
        return this.f43000n + "(" + a4.a() + ");";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f42988b;
    }
}
