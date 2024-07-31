package com.autonavi.aps.amapapi.model;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import org.json.JSONObject;

/* renamed from: com.autonavi.aps.amapapi.model.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMapLocationServer extends AMapLocation {

    /* renamed from: d */
    protected String f8074d;

    /* renamed from: e */
    boolean f8075e;

    /* renamed from: f */
    String f8076f;

    /* renamed from: g */
    private String f8077g;

    /* renamed from: h */
    private String f8078h;

    /* renamed from: i */
    private int f8079i;

    /* renamed from: j */
    private String f8080j;

    /* renamed from: k */
    private int f8081k;

    /* renamed from: l */
    private String f8082l;

    /* renamed from: m */
    private JSONObject f8083m;

    /* renamed from: n */
    private String f8084n;

    /* renamed from: o */
    private String f8085o;

    /* renamed from: p */
    private String f8086p;

    public AMapLocationServer(String str) {
        super(str);
        this.f8074d = "";
        this.f8077g = null;
        this.f8078h = "";
        this.f8080j = "";
        this.f8081k = 0;
        this.f8082l = "new";
        this.f8083m = null;
        this.f8084n = "";
        this.f8075e = true;
        this.f8076f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.f8085o = "";
        this.f8086p = null;
    }

    /* renamed from: i */
    private void m51614i(String str) {
        this.f8084n = str;
    }

    /* renamed from: a */
    public final String m51635a() {
        return this.f8077g;
    }

    /* renamed from: b */
    public final String m51630b() {
        return this.f8078h;
    }

    /* renamed from: c */
    public final int m51627c() {
        return this.f8079i;
    }

    /* renamed from: d */
    public final String m51625d() {
        return this.f8080j;
    }

    /* renamed from: e */
    public final String m51623e() {
        return this.f8082l;
    }

    /* renamed from: f */
    public final JSONObject m51621f() {
        return this.f8083m;
    }

    /* renamed from: g */
    public final String m51619g() {
        return this.f8084n;
    }

    /* renamed from: h */
    public final AMapLocationServer m51617h() {
        String m51619g = m51619g();
        if (TextUtils.isEmpty(m51619g)) {
            return null;
        }
        String[] split = m51619g.split(",");
        if (split.length != 3) {
            return null;
        }
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setProvider(getProvider());
        aMapLocationServer.setLongitude(C2432j.m51172c(split[0]));
        aMapLocationServer.setLatitude(C2432j.m51172c(split[1]));
        aMapLocationServer.setAccuracy(C2432j.m51168d(split[2]));
        aMapLocationServer.setCityCode(getCityCode());
        aMapLocationServer.setAdCode(getAdCode());
        aMapLocationServer.setCountry(getCountry());
        aMapLocationServer.setProvince(getProvince());
        aMapLocationServer.setCity(getCity());
        aMapLocationServer.setTime(getTime());
        aMapLocationServer.m51622e(m51623e());
        aMapLocationServer.m51626c(String.valueOf(m51627c()));
        if (C2432j.m51194a(aMapLocationServer)) {
            return aMapLocationServer;
        }
        return null;
    }

    /* renamed from: j */
    public final String m51613j() {
        return this.f8076f;
    }

    /* renamed from: k */
    public final String m51611k() {
        return this.f8086p;
    }

    /* renamed from: l */
    public final int m51610l() {
        return this.f8081k;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int i) {
        try {
            JSONObject json = super.toJson(i);
            if (i == 1) {
                json.put("retype", this.f8080j);
                json.put("cens", this.f8085o);
                json.put("coord", this.f8079i);
                json.put("mcell", this.f8084n);
                json.put("desc", this.f8074d);
                json.put("address", getAddress());
                if (this.f8083m != null && C2432j.m51189a(json, "offpct")) {
                    json.put("offpct", this.f8083m.getString("offpct"));
                }
            } else if (i != 2 && i != 3) {
                return json;
            }
            json.put("type", this.f8082l);
            json.put("isReversegeo", this.f8075e);
            json.put("geoLanguage", this.f8076f);
            return json;
        } catch (Throwable th) {
            C2428b.m51299a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    /* renamed from: j */
    private void m51612j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("\\*");
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = split[i];
            if (!TextUtils.isEmpty(str2)) {
                String[] split2 = str2.split(",");
                setLongitude(C2432j.m51172c(split2[0]));
                setLatitude(C2432j.m51172c(split2[1]));
                setAccuracy(C2432j.m51165e(split2[2]));
                break;
            }
            i++;
        }
        this.f8085o = str;
    }

    /* renamed from: a */
    public final void m51633a(String str) {
        this.f8077g = str;
    }

    /* renamed from: b */
    public final void m51629b(String str) {
        this.f8078h = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m51626c(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L1e
            java.lang.String r0 = "0"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L12
            r2 = 0
            r1.f8079i = r2
            goto L21
        L12:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L1e
            r2 = 1
            r1.f8079i = r2
            goto L21
        L1e:
            r2 = -1
            r1.f8079i = r2
        L21:
            int r2 = r1.f8079i
            if (r2 != 0) goto L2b
            java.lang.String r2 = "WGS84"
            super.setCoordType(r2)
            return
        L2b:
            java.lang.String r2 = "GCJ02"
            super.setCoordType(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.model.AMapLocationServer.m51626c(java.lang.String):void");
    }

    /* renamed from: d */
    public final void m51624d(String str) {
        this.f8080j = str;
    }

    /* renamed from: e */
    public final void m51622e(String str) {
        this.f8082l = str;
    }

    /* renamed from: f */
    public final void m51620f(String str) {
        this.f8076f = str;
    }

    /* renamed from: g */
    public final void m51618g(String str) {
        this.f8074d = str;
    }

    /* renamed from: i */
    public final boolean m51615i() {
        return this.f8075e;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int i) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i);
            jSONObject.put("nb", this.f8086p);
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public final void m51632a(JSONObject jSONObject) {
        this.f8083m = jSONObject;
    }

    /* renamed from: b */
    public final void m51628b(JSONObject jSONObject) {
        try {
            C2428b.m51303a(this, jSONObject);
            m51622e(jSONObject.optString("type", this.f8082l));
            m51624d(jSONObject.optString("retype", this.f8080j));
            m51612j(jSONObject.optString("cens", this.f8085o));
            m51618g(jSONObject.optString("desc", this.f8074d));
            m51626c(jSONObject.optString("coord", String.valueOf(this.f8079i)));
            m51614i(jSONObject.optString("mcell", this.f8084n));
            m51631a(jSONObject.optBoolean("isReversegeo", this.f8075e));
            m51620f(jSONObject.optString("geoLanguage", this.f8076f));
            if (C2432j.m51189a(jSONObject, "poiid")) {
                setBuildingId(jSONObject.optString("poiid"));
            }
            if (C2432j.m51189a(jSONObject, "pid")) {
                setBuildingId(jSONObject.optString("pid"));
            }
            if (C2432j.m51189a(jSONObject, "floor")) {
                setFloor(jSONObject.optString("floor"));
            }
            if (C2432j.m51189a(jSONObject, "flr")) {
                setFloor(jSONObject.optString("flr"));
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AmapLoc", "AmapLoc");
        }
    }

    /* renamed from: a */
    public final void m51631a(boolean z) {
        this.f8075e = z;
    }

    /* renamed from: a */
    public final void m51634a(int i) {
        this.f8081k = i;
    }

    /* renamed from: h */
    public final void m51616h(String str) {
        this.f8086p = str;
    }
}
