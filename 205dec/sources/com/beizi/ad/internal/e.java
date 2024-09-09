package com.beizi.ad.internal;

import android.content.Context;
import com.beizi.ad.R;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.StringUtil;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdParameters.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static HashSet<String> f13770a;

    /* renamed from: c  reason: collision with root package name */
    private String f13772c;

    /* renamed from: j  reason: collision with root package name */
    private String f13779j;

    /* renamed from: n  reason: collision with root package name */
    private WeakReference<Context> f13783n;

    /* renamed from: o  reason: collision with root package name */
    private String f13784o;

    /* renamed from: b  reason: collision with root package name */
    private k f13771b = k.PREFETCH;

    /* renamed from: d  reason: collision with root package name */
    private int f13773d = 3;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13774e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f13775f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f13776g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f13777h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f13778i = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13780k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13781l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13782m = false;

    public e(Context context, String str) {
        this.f13784o = "";
        this.f13783n = new WeakReference<>(context);
        this.f13784o = str;
    }

    public void a(boolean z3) {
        this.f13780k = z3;
    }

    public Context b() {
        if (this.f13783n.get() != null) {
            return this.f13783n.get();
        }
        return null;
    }

    public String c() {
        return this.f13772c;
    }

    public int d() {
        if (this.f13771b == k.BANNER) {
            return this.f13775f;
        }
        return -1;
    }

    public int e() {
        if (this.f13771b == k.BANNER) {
            return this.f13776g;
        }
        return -1;
    }

    public int f() {
        return this.f13777h;
    }

    public int g() {
        return this.f13778i;
    }

    public boolean h() {
        return this.f13774e;
    }

    public k i() {
        return this.f13771b;
    }

    public boolean j() {
        if (StringUtil.isEmpty(h.a().d()) || StringUtil.isEmpty(this.f13772c)) {
            HaoboLog.e(HaoboLog.baseLogTag, HaoboLog.getString(R.string.no_identification));
            return false;
        }
        return true;
    }

    public String k() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = b().getResources().getConfiguration().orientation == 2 ? "h" : "v";
            this.f13779j = str;
            if (!StringUtil.isEmpty(str)) {
                jSONObject.put("mOrientation", this.f13779j);
            }
            if (this.f13775f > 0 && this.f13776g > 0) {
                jSONObject.put("size", this.f13775f + "x" + this.f13776g);
            }
            int g4 = g();
            int f4 = f();
            if (g4 > 0 && f4 > 0) {
                k kVar = this.f13771b;
                k kVar2 = k.INTERSTITIAL;
                if (!kVar.equals(kVar2) && (this.f13775f < 0 || this.f13776g < 0)) {
                    jSONObject.put("max_size", f4 + "x" + g4);
                } else if (this.f13771b.equals(kVar2)) {
                    jSONObject.put("size", f4 + "x" + g4);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e4) {
            String str2 = HaoboLog.jsonLogTag;
            HaoboLog.e(str2, "Failed to encode adUnitParams, err = " + e4.getMessage());
            return "";
        }
    }

    public boolean l() {
        return this.f13782m;
    }

    public String a() {
        return this.f13784o;
    }

    public void c(int i4) {
        this.f13776g = i4;
    }

    public void a(String str) {
        this.f13772c = str;
    }

    public void b(int i4) {
        this.f13775f = i4;
    }

    public void c(boolean z3) {
        this.f13782m = z3;
    }

    public void d(int i4) {
        this.f13777h = i4;
    }

    public void e(int i4) {
        this.f13778i = i4;
    }

    public void a(int i4) {
        this.f13773d = i4;
    }

    public void b(boolean z3) {
        this.f13774e = z3;
    }

    public void a(k kVar) {
        this.f13771b = kVar;
    }
}
