package com.autonavi.aps.amapapi.restruct;

import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.analytics.pro.UContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.autonavi.aps.amapapi.restruct.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class HistoryLocation {

    /* renamed from: a */
    public int f8166a = 0;

    /* renamed from: b */
    public double f8167b = Utils.DOUBLE_EPSILON;

    /* renamed from: c */
    public double f8168c = Utils.DOUBLE_EPSILON;

    /* renamed from: d */
    public long f8169d = 0;

    /* renamed from: e */
    public int f8170e = 0;

    /* renamed from: f */
    public int f8171f = 0;

    /* renamed from: g */
    public int f8172g = 63;

    /* renamed from: h */
    public int f8173h = 0;

    /* renamed from: a */
    public final String m51526a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put(RtspHeaders.Values.TIME, this.f8169d);
            jSONObject.put("lon", this.f8168c);
            jSONObject.put(UContent.f38072C, this.f8167b);
            jSONObject.put("radius", this.f8170e);
            jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.f8166a);
            jSONObject.put("reType", this.f8172g);
            jSONObject.put("reSubType", this.f8173h);
        } catch (Throwable unused) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && HistoryLocation.class == obj.getClass()) {
            HistoryLocation historyLocation = (HistoryLocation) obj;
            if (this.f8166a == historyLocation.f8166a && Double.compare(historyLocation.f8167b, this.f8167b) == 0 && Double.compare(historyLocation.f8168c, this.f8168c) == 0 && this.f8169d == historyLocation.f8169d && this.f8170e == historyLocation.f8170e && this.f8171f == historyLocation.f8171f && this.f8172g == historyLocation.f8172g && this.f8173h == historyLocation.f8173h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8166a), Double.valueOf(this.f8167b), Double.valueOf(this.f8168c), Long.valueOf(this.f8169d), Integer.valueOf(this.f8170e), Integer.valueOf(this.f8171f), Integer.valueOf(this.f8172g), Integer.valueOf(this.f8173h)});
    }

    /* renamed from: a */
    public final void m51525a(JSONObject jSONObject) {
        try {
            this.f8167b = jSONObject.optDouble(UContent.f38072C, this.f8167b);
            this.f8168c = jSONObject.optDouble("lon", this.f8168c);
            this.f8166a = jSONObject.optInt(MyLocationStyle.LOCATION_TYPE, this.f8166a);
            this.f8172g = jSONObject.optInt("reType", this.f8172g);
            this.f8173h = jSONObject.optInt("reSubType", this.f8173h);
            this.f8170e = jSONObject.optInt("radius", this.f8170e);
            this.f8169d = jSONObject.optLong(RtspHeaders.Values.TIME, this.f8169d);
        } catch (Throwable th) {
            C2428b.m51299a(th, "CoreUtil", "transformLocation");
        }
    }
}
