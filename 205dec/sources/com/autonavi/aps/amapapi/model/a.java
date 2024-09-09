package com.autonavi.aps.amapapi.model;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.j;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapLocationServer.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a extends AMapLocation {

    /* renamed from: d  reason: collision with root package name */
    protected String f11751d;

    /* renamed from: e  reason: collision with root package name */
    boolean f11752e;

    /* renamed from: f  reason: collision with root package name */
    String f11753f;

    /* renamed from: g  reason: collision with root package name */
    private String f11754g;

    /* renamed from: h  reason: collision with root package name */
    private String f11755h;

    /* renamed from: i  reason: collision with root package name */
    private int f11756i;

    /* renamed from: j  reason: collision with root package name */
    private String f11757j;

    /* renamed from: k  reason: collision with root package name */
    private int f11758k;

    /* renamed from: l  reason: collision with root package name */
    private String f11759l;

    /* renamed from: m  reason: collision with root package name */
    private JSONObject f11760m;

    /* renamed from: n  reason: collision with root package name */
    private String f11761n;

    /* renamed from: o  reason: collision with root package name */
    private String f11762o;

    /* renamed from: p  reason: collision with root package name */
    private String f11763p;

    public a(String str) {
        super(str);
        this.f11751d = "";
        this.f11754g = null;
        this.f11755h = "";
        this.f11757j = "";
        this.f11758k = 0;
        this.f11759l = "new";
        this.f11760m = null;
        this.f11761n = "";
        this.f11752e = true;
        this.f11753f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.f11762o = "";
        this.f11763p = null;
    }

    private void i(String str) {
        this.f11761n = str;
    }

    public final String a() {
        return this.f11754g;
    }

    public final String b() {
        return this.f11755h;
    }

    public final int c() {
        return this.f11756i;
    }

    public final String d() {
        return this.f11757j;
    }

    public final String e() {
        return this.f11759l;
    }

    public final JSONObject f() {
        return this.f11760m;
    }

    public final String g() {
        return this.f11761n;
    }

    public final a h() {
        String g4 = g();
        if (TextUtils.isEmpty(g4)) {
            return null;
        }
        String[] split = g4.split(",");
        if (split.length != 3) {
            return null;
        }
        a aVar = new a("");
        aVar.setProvider(getProvider());
        aVar.setLongitude(j.c(split[0]));
        aVar.setLatitude(j.c(split[1]));
        aVar.setAccuracy(j.d(split[2]));
        aVar.setCityCode(getCityCode());
        aVar.setAdCode(getAdCode());
        aVar.setCountry(getCountry());
        aVar.setProvince(getProvince());
        aVar.setCity(getCity());
        aVar.setTime(getTime());
        aVar.e(e());
        aVar.c(String.valueOf(c()));
        if (j.a(aVar)) {
            return aVar;
        }
        return null;
    }

    public final String j() {
        return this.f11753f;
    }

    public final String k() {
        return this.f11763p;
    }

    public final int l() {
        return this.f11758k;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int i4) {
        try {
            JSONObject json = super.toJson(i4);
            if (i4 == 1) {
                json.put("retype", this.f11757j);
                json.put("cens", this.f11762o);
                json.put("coord", this.f11756i);
                json.put("mcell", this.f11761n);
                json.put("desc", this.f11751d);
                json.put("address", getAddress());
                if (this.f11760m != null && j.a(json, "offpct")) {
                    json.put("offpct", this.f11760m.getString("offpct"));
                }
            } else if (i4 != 2 && i4 != 3) {
                return json;
            }
            json.put("type", this.f11759l);
            json.put("isReversegeo", this.f11752e);
            json.put("geoLanguage", this.f11753f);
            return json;
        } catch (Throwable th) {
            b.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    private void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("\\*");
        int length = split.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            String str2 = split[i4];
            if (!TextUtils.isEmpty(str2)) {
                String[] split2 = str2.split(",");
                setLongitude(j.c(split2[0]));
                setLatitude(j.c(split2[1]));
                setAccuracy(j.e(split2[2]));
                break;
            }
            i4++;
        }
        this.f11762o = str;
    }

    public final void a(String str) {
        this.f11754g = str;
    }

    public final void b(String str) {
        this.f11755h = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L1e
            java.lang.String r0 = "0"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L12
            r2 = 0
            r1.f11756i = r2
            goto L21
        L12:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L1e
            r2 = 1
            r1.f11756i = r2
            goto L21
        L1e:
            r2 = -1
            r1.f11756i = r2
        L21:
            int r2 = r1.f11756i
            if (r2 != 0) goto L2b
            java.lang.String r2 = "WGS84"
            super.setCoordType(r2)
            return
        L2b:
            java.lang.String r2 = "GCJ02"
            super.setCoordType(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.model.a.c(java.lang.String):void");
    }

    public final void d(String str) {
        this.f11757j = str;
    }

    public final void e(String str) {
        this.f11759l = str;
    }

    public final void f(String str) {
        this.f11753f = str;
    }

    public final void g(String str) {
        this.f11751d = str;
    }

    public final boolean i() {
        return this.f11752e;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int i4) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i4);
            jSONObject.put("nb", this.f11763p);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public final void a(JSONObject jSONObject) {
        this.f11760m = jSONObject;
    }

    public final void b(JSONObject jSONObject) {
        try {
            b.a(this, jSONObject);
            e(jSONObject.optString("type", this.f11759l));
            d(jSONObject.optString("retype", this.f11757j));
            j(jSONObject.optString("cens", this.f11762o));
            g(jSONObject.optString("desc", this.f11751d));
            c(jSONObject.optString("coord", String.valueOf(this.f11756i)));
            i(jSONObject.optString("mcell", this.f11761n));
            a(jSONObject.optBoolean("isReversegeo", this.f11752e));
            f(jSONObject.optString("geoLanguage", this.f11753f));
            if (j.a(jSONObject, "poiid")) {
                setBuildingId(jSONObject.optString("poiid"));
            }
            if (j.a(jSONObject, "pid")) {
                setBuildingId(jSONObject.optString("pid"));
            }
            if (j.a(jSONObject, "floor")) {
                setFloor(jSONObject.optString("floor"));
            }
            if (j.a(jSONObject, "flr")) {
                setFloor(jSONObject.optString("flr"));
            }
        } catch (Throwable th) {
            b.a(th, "AmapLoc", "AmapLoc");
        }
    }

    public final void a(boolean z3) {
        this.f11752e = z3;
    }

    public final void a(int i4) {
        this.f11758k = i4;
    }

    public final void h(String str) {
        this.f11763p = str;
    }
}
