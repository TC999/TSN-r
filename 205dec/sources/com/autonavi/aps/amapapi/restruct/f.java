package com.autonavi.aps.amapapi.restruct;

import java.util.Arrays;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HistoryLocation.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public int f11843a = 0;

    /* renamed from: b  reason: collision with root package name */
    public double f11844b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    public double f11845c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    public long f11846d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f11847e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f11848f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f11849g = 63;

    /* renamed from: h  reason: collision with root package name */
    public int f11850h = 0;

    public final String a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("time", this.f11846d);
            jSONObject.put("lon", this.f11845c);
            jSONObject.put("lat", this.f11844b);
            jSONObject.put("radius", this.f11847e);
            jSONObject.put("locationType", this.f11843a);
            jSONObject.put("reType", this.f11849g);
            jSONObject.put("reSubType", this.f11850h);
        } catch (Throwable unused) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f11843a == fVar.f11843a && Double.compare(fVar.f11844b, this.f11844b) == 0 && Double.compare(fVar.f11845c, this.f11845c) == 0 && this.f11846d == fVar.f11846d && this.f11847e == fVar.f11847e && this.f11848f == fVar.f11848f && this.f11849g == fVar.f11849g && this.f11850h == fVar.f11850h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11843a), Double.valueOf(this.f11844b), Double.valueOf(this.f11845c), Long.valueOf(this.f11846d), Integer.valueOf(this.f11847e), Integer.valueOf(this.f11848f), Integer.valueOf(this.f11849g), Integer.valueOf(this.f11850h)});
    }

    public final void a(JSONObject jSONObject) {
        try {
            this.f11844b = jSONObject.optDouble("lat", this.f11844b);
            this.f11845c = jSONObject.optDouble("lon", this.f11845c);
            this.f11843a = jSONObject.optInt("locationType", this.f11843a);
            this.f11849g = jSONObject.optInt("reType", this.f11849g);
            this.f11850h = jSONObject.optInt("reSubType", this.f11850h);
            this.f11847e = jSONObject.optInt("radius", this.f11847e);
            this.f11846d = jSONObject.optLong("time", this.f11846d);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "CoreUtil", "transformLocation");
        }
    }
}
