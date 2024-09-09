package com.bxkj.student.run.app.utils;

import android.util.Log;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: TraceUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class z {

    /* renamed from: d  reason: collision with root package name */
    private TraceLocation f22957d;

    /* renamed from: a  reason: collision with root package name */
    final int f22954a = 20;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f22955b = Boolean.TRUE;

    /* renamed from: c  reason: collision with root package name */
    private TraceLocation f22956c = new TraceLocation();

    /* renamed from: e  reason: collision with root package name */
    private List<TraceLocation> f22958e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private List<TraceLocation> f22959f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private int f22960g = 0;

    public Boolean a(TraceLocation aMapLocation) {
        String str;
        try {
            if (this.f22955b.booleanValue()) {
                this.f22955b = Boolean.FALSE;
                this.f22956c.setLatitude(aMapLocation.getLatitude());
                this.f22956c.setLongitude(aMapLocation.getLongitude());
                this.f22956c.setTime(aMapLocation.getTime());
                String str2 = "\u7b2c\u4e00\u6b21 : ";
                TraceLocation traceLocation = new TraceLocation();
                traceLocation.setLatitude(aMapLocation.getLatitude());
                traceLocation.setLongitude(aMapLocation.getLongitude());
                traceLocation.setTime(aMapLocation.getTime());
                this.f22958e.add(traceLocation);
                this.f22960g++;
                Boolean bool = Boolean.TRUE;
                Log.d("wsh", str2);
                return bool;
            }
            String str3 = "\u975e\u7b2c\u4e00\u6b21 : ";
            if (this.f22957d == null) {
                long time = ((aMapLocation.getTime() - this.f22956c.getTime()) / 1000) * 20;
                float calculateLineDistance = AMapUtils.calculateLineDistance(new LatLng(this.f22956c.getLatitude(), this.f22956c.getLongitude()), new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                String str4 = (str3 + "weight2=null : ") + "distance = " + calculateLineDistance + ",MaxDistance = " + time + " : ";
                if (calculateLineDistance > ((float) time)) {
                    String str5 = str4 + "distance > MaxDistance\u5f53\u524d\u70b9 \u8ddd\u79bb\u5927: \u8bbe\u7f6ew2\u4f4d\u65b0\u7684\u70b9\uff0c\u5e76\u6dfb\u52a0\u5230w2TempList";
                    TraceLocation traceLocation2 = new TraceLocation();
                    this.f22957d = traceLocation2;
                    traceLocation2.setLatitude(aMapLocation.getLatitude());
                    this.f22957d.setLongitude(aMapLocation.getLongitude());
                    this.f22957d.setTime(aMapLocation.getTime());
                    this.f22959f.add(this.f22957d);
                    Boolean bool2 = Boolean.FALSE;
                    Log.d("wsh", str5);
                    return bool2;
                }
                String str6 = str4 + "distance < MaxDistance\u5f53\u524d\u70b9 \u8ddd\u79bb\u5c0f : \u6dfb\u52a0\u5230w1TempList";
                TraceLocation traceLocation3 = new TraceLocation();
                traceLocation3.setLatitude(aMapLocation.getLatitude());
                traceLocation3.setLongitude(aMapLocation.getLongitude());
                traceLocation3.setTime(aMapLocation.getTime());
                this.f22958e.add(traceLocation3);
                this.f22960g++;
                TraceLocation traceLocation4 = this.f22956c;
                traceLocation4.setLatitude((traceLocation4.getLatitude() * 0.2d) + (aMapLocation.getLatitude() * 0.8d));
                TraceLocation traceLocation5 = this.f22956c;
                traceLocation5.setLongitude((traceLocation5.getLongitude() * 0.2d) + (aMapLocation.getLongitude() * 0.8d));
                this.f22956c.setTime(aMapLocation.getTime());
                this.f22956c.setSpeed(aMapLocation.getSpeed());
                if (this.f22960g > 3) {
                    String str7 = str6 + " : \u66f4\u65b0";
                    this.f22958e.clear();
                    Boolean bool3 = Boolean.TRUE;
                    Log.d("wsh", str7);
                    return bool3;
                }
                String str8 = str6 + " w1Count<3: \u4e0d\u66f4\u65b0";
                Boolean bool4 = Boolean.FALSE;
                Log.d("wsh", str8);
                return bool4;
            }
            long time2 = ((aMapLocation.getTime() - this.f22957d.getTime()) / 1000) * 16;
            float calculateLineDistance2 = AMapUtils.calculateLineDistance(new LatLng(this.f22957d.getLatitude(), this.f22957d.getLongitude()), new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            String str9 = (str3 + "weight2 != null : ") + "distance = " + calculateLineDistance2 + ",MaxDistance = " + time2 + " : ";
            if (calculateLineDistance2 > ((float) time2)) {
                String str10 = str9 + "\u5f53\u524d\u70b9 \u8ddd\u79bb\u5927: weight2 \u66f4\u65b0";
                this.f22959f.clear();
                TraceLocation traceLocation6 = new TraceLocation();
                this.f22957d = traceLocation6;
                traceLocation6.setLatitude(aMapLocation.getLatitude());
                this.f22957d.setLongitude(aMapLocation.getLongitude());
                this.f22957d.setTime(aMapLocation.getTime());
                this.f22959f.add(this.f22957d);
                Boolean bool5 = Boolean.FALSE;
                Log.d("wsh", str10);
                return bool5;
            }
            String str11 = str9 + "\u5f53\u524d\u70b9 \u8ddd\u79bb\u5c0f: \u6dfb\u52a0\u5230w2TempList";
            TraceLocation traceLocation7 = new TraceLocation();
            traceLocation7.setLatitude(aMapLocation.getLatitude());
            traceLocation7.setLongitude(aMapLocation.getLongitude());
            traceLocation7.setTime(aMapLocation.getTime());
            this.f22959f.add(traceLocation7);
            TraceLocation traceLocation8 = this.f22957d;
            traceLocation8.setLatitude((traceLocation8.getLatitude() * 0.2d) + (aMapLocation.getLatitude() * 0.8d));
            TraceLocation traceLocation9 = this.f22957d;
            traceLocation9.setLongitude((traceLocation9.getLongitude() * 0.2d) + (aMapLocation.getLongitude() * 0.8d));
            this.f22957d.setTime(aMapLocation.getTime());
            this.f22957d.setSpeed(aMapLocation.getSpeed());
            if (this.f22959f.size() > 4) {
                if (this.f22960g > 4) {
                    str = str11 + "w1Count > 4\u8ba1\u7b97\u589e\u52a0W1";
                } else {
                    str = str11 + "w1Count < 4\u8ba1\u7b97\u4e22\u5f03W1";
                    this.f22958e.clear();
                }
                String str12 = str + "w2TempList.size() > 4 : \u66f4\u65b0\u5230\u504f\u79fb\u70b9";
                this.f22959f.clear();
                this.f22956c = this.f22957d;
                this.f22957d = null;
                Boolean bool6 = Boolean.TRUE;
                Log.d("wsh", str12);
                return bool6;
            }
            String str13 = str11 + "w2TempList.size() < 4\r\n";
            Boolean bool7 = Boolean.FALSE;
            Log.d("wsh", str13);
            return bool7;
        } catch (Throwable th) {
            Log.d("wsh", "");
            throw th;
        }
    }
}
