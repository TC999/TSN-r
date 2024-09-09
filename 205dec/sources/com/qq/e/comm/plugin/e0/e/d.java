package com.qq.e.comm.plugin.e0.e;

import android.text.TextUtils;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.qq.e.mediation.interfaces.IBaseAd;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: w  reason: collision with root package name */
    public static String f42909w;

    /* renamed from: x  reason: collision with root package name */
    public static String f42910x;

    /* renamed from: y  reason: collision with root package name */
    public static String f42911y;

    /* renamed from: a  reason: collision with root package name */
    private int f42912a;

    /* renamed from: b  reason: collision with root package name */
    private String f42913b;

    /* renamed from: c  reason: collision with root package name */
    private String f42914c;

    /* renamed from: d  reason: collision with root package name */
    private String f42915d;

    /* renamed from: e  reason: collision with root package name */
    private String f42916e;

    /* renamed from: f  reason: collision with root package name */
    private String f42917f;

    /* renamed from: g  reason: collision with root package name */
    private int f42918g;

    /* renamed from: h  reason: collision with root package name */
    private int f42919h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f42920i = -1;

    /* renamed from: j  reason: collision with root package name */
    private String f42921j;

    /* renamed from: k  reason: collision with root package name */
    private String f42922k;

    /* renamed from: l  reason: collision with root package name */
    private int f42923l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f42924m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f42925n;

    /* renamed from: o  reason: collision with root package name */
    private int f42926o;

    /* renamed from: p  reason: collision with root package name */
    private int f42927p;

    /* renamed from: q  reason: collision with root package name */
    private WeakReference<IBaseAd> f42928q;

    /* renamed from: r  reason: collision with root package name */
    private int f42929r;

    /* renamed from: s  reason: collision with root package name */
    private int f42930s;

    /* renamed from: t  reason: collision with root package name */
    private Integer f42931t;

    /* renamed from: u  reason: collision with root package name */
    private String f42932u;

    /* renamed from: v  reason: collision with root package name */
    private Integer f42933v;

    public d(JSONObject jSONObject, String str, boolean z3, int i4, int i5) {
        if (jSONObject == null) {
            return;
        }
        this.f42912a = jSONObject.optInt("adnet_id");
        this.f42913b = jSONObject.optString("name");
        this.f42914c = jSONObject.optString("placement_id");
        this.f42915d = jSONObject.optString("app_id");
        this.f42916e = jSONObject.optString("class_name");
        this.f42917f = jSONObject.optString("ext");
        jSONObject.optInt("timeout");
        this.f42918g = jSONObject.optInt(BidResponsed.KEY_PRICE, -1);
        if (TextUtils.isEmpty(f42909w) && this.f42912a == 103) {
            f42909w = this.f42915d;
        }
        if (TextUtils.isEmpty(f42911y) && this.f42912a == 101) {
            f42911y = this.f42915d;
        }
        if (TextUtils.isEmpty(f42910x) && this.f42912a == 102) {
            f42910x = this.f42915d;
        }
        this.f42922k = str;
        this.f42925n = z3;
        this.f42926o = i4;
        this.f42927p = i5;
    }

    public int a() {
        return this.f42912a;
    }

    public String b() {
        return this.f42915d;
    }

    public void c(int i4) {
        this.f42923l = i4;
    }

    public void d(int i4) {
        this.f42920i = i4;
    }

    public String e() {
        return this.f42916e;
    }

    public int f() {
        return this.f42919h;
    }

    public Integer g() {
        return this.f42931t;
    }

    public String h() {
        return this.f42932u;
    }

    public int i() {
        return this.f42926o;
    }

    public String j() {
        return this.f42917f;
    }

    public int k() {
        return this.f42927p;
    }

    public Integer l() {
        return this.f42933v;
    }

    public int m() {
        return this.f42923l;
    }

    public String n() {
        return this.f42922k;
    }

    public String o() {
        return this.f42913b;
    }

    public String p() {
        return this.f42914c;
    }

    public int q() {
        return this.f42918g;
    }

    public int r() {
        return this.f42920i;
    }

    public String s() {
        return this.f42921j;
    }

    public int t() {
        return this.f42929r;
    }

    public String toString() {
        return "name: " + this.f42913b + ", posId: " + this.f42914c + ", price: " + this.f42918g;
    }

    public boolean u() {
        return this.f42925n;
    }

    public boolean v() {
        return this.f42924m;
    }

    public void w() {
        this.f42923l = 0;
        this.f42924m = false;
        this.f42919h = -1;
        this.f42920i = -1;
        this.f42921j = null;
        this.f42928q = null;
        this.f42930s = -1;
        this.f42929r = -1;
        this.f42931t = null;
        this.f42932u = null;
        this.f42933v = null;
    }

    public void a(boolean z3) {
        this.f42924m = z3;
    }

    public void b(int i4) {
        this.f42919h = i4;
    }

    public IBaseAd c() {
        WeakReference<IBaseAd> weakReference = this.f42928q;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int d() {
        return this.f42930s;
    }

    public void e(int i4) {
        this.f42929r = i4;
    }

    public void a(IBaseAd iBaseAd) {
        this.f42928q = new WeakReference<>(iBaseAd);
    }

    public void b(String str) {
        this.f42921j = str;
    }

    public void a(int i4) {
        this.f42930s = i4;
    }

    public void b(Integer num) {
        this.f42933v = num;
    }

    public void a(Integer num) {
        this.f42931t = num;
    }

    public void a(String str) {
        this.f42932u = str;
    }
}
