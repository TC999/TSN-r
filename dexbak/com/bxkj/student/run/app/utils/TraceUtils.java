package com.bxkj.student.run.app.utils;

import android.util.Log;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bxkj.student.run.app.utils.z */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TraceUtils {

    /* renamed from: d */
    private TraceLocation f19727d;

    /* renamed from: a */
    final int f19724a = 20;

    /* renamed from: b */
    private Boolean f19725b = Boolean.TRUE;

    /* renamed from: c */
    private TraceLocation f19726c = new TraceLocation();

    /* renamed from: e */
    private List<TraceLocation> f19728e = new ArrayList();

    /* renamed from: f */
    private List<TraceLocation> f19729f = new ArrayList();

    /* renamed from: g */
    private int f19730g = 0;

    /* renamed from: a */
    public Boolean m39509a(TraceLocation aMapLocation) {
        String str;
        try {
            if (this.f19725b.booleanValue()) {
                this.f19725b = Boolean.FALSE;
                this.f19726c.setLatitude(aMapLocation.getLatitude());
                this.f19726c.setLongitude(aMapLocation.getLongitude());
                this.f19726c.setTime(aMapLocation.getTime());
                String str2 = "第一次 : ";
                TraceLocation traceLocation = new TraceLocation();
                traceLocation.setLatitude(aMapLocation.getLatitude());
                traceLocation.setLongitude(aMapLocation.getLongitude());
                traceLocation.setTime(aMapLocation.getTime());
                this.f19728e.add(traceLocation);
                this.f19730g++;
                Boolean bool = Boolean.TRUE;
                Log.d("wsh", str2);
                return bool;
            }
            String str3 = "非第一次 : ";
            if (this.f19727d == null) {
                long time = ((aMapLocation.getTime() - this.f19726c.getTime()) / 1000) * 20;
                float calculateLineDistance = AMapUtils.calculateLineDistance(new LatLng(this.f19726c.getLatitude(), this.f19726c.getLongitude()), new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                String str4 = (str3 + "weight2=null : ") + "distance = " + calculateLineDistance + ",MaxDistance = " + time + " : ";
                if (calculateLineDistance > ((float) time)) {
                    String str5 = str4 + "distance > MaxDistance当前点 距离大: 设置w2位新的点，并添加到w2TempList";
                    TraceLocation traceLocation2 = new TraceLocation();
                    this.f19727d = traceLocation2;
                    traceLocation2.setLatitude(aMapLocation.getLatitude());
                    this.f19727d.setLongitude(aMapLocation.getLongitude());
                    this.f19727d.setTime(aMapLocation.getTime());
                    this.f19729f.add(this.f19727d);
                    Boolean bool2 = Boolean.FALSE;
                    Log.d("wsh", str5);
                    return bool2;
                }
                String str6 = str4 + "distance < MaxDistance当前点 距离小 : 添加到w1TempList";
                TraceLocation traceLocation3 = new TraceLocation();
                traceLocation3.setLatitude(aMapLocation.getLatitude());
                traceLocation3.setLongitude(aMapLocation.getLongitude());
                traceLocation3.setTime(aMapLocation.getTime());
                this.f19728e.add(traceLocation3);
                this.f19730g++;
                TraceLocation traceLocation4 = this.f19726c;
                traceLocation4.setLatitude((traceLocation4.getLatitude() * 0.2d) + (aMapLocation.getLatitude() * 0.8d));
                TraceLocation traceLocation5 = this.f19726c;
                traceLocation5.setLongitude((traceLocation5.getLongitude() * 0.2d) + (aMapLocation.getLongitude() * 0.8d));
                this.f19726c.setTime(aMapLocation.getTime());
                this.f19726c.setSpeed(aMapLocation.getSpeed());
                if (this.f19730g > 3) {
                    String str7 = str6 + " : 更新";
                    this.f19728e.clear();
                    Boolean bool3 = Boolean.TRUE;
                    Log.d("wsh", str7);
                    return bool3;
                }
                String str8 = str6 + " w1Count<3: 不更新";
                Boolean bool4 = Boolean.FALSE;
                Log.d("wsh", str8);
                return bool4;
            }
            long time2 = ((aMapLocation.getTime() - this.f19727d.getTime()) / 1000) * 16;
            float calculateLineDistance2 = AMapUtils.calculateLineDistance(new LatLng(this.f19727d.getLatitude(), this.f19727d.getLongitude()), new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            String str9 = (str3 + "weight2 != null : ") + "distance = " + calculateLineDistance2 + ",MaxDistance = " + time2 + " : ";
            if (calculateLineDistance2 > ((float) time2)) {
                String str10 = str9 + "当前点 距离大: weight2 更新";
                this.f19729f.clear();
                TraceLocation traceLocation6 = new TraceLocation();
                this.f19727d = traceLocation6;
                traceLocation6.setLatitude(aMapLocation.getLatitude());
                this.f19727d.setLongitude(aMapLocation.getLongitude());
                this.f19727d.setTime(aMapLocation.getTime());
                this.f19729f.add(this.f19727d);
                Boolean bool5 = Boolean.FALSE;
                Log.d("wsh", str10);
                return bool5;
            }
            String str11 = str9 + "当前点 距离小: 添加到w2TempList";
            TraceLocation traceLocation7 = new TraceLocation();
            traceLocation7.setLatitude(aMapLocation.getLatitude());
            traceLocation7.setLongitude(aMapLocation.getLongitude());
            traceLocation7.setTime(aMapLocation.getTime());
            this.f19729f.add(traceLocation7);
            TraceLocation traceLocation8 = this.f19727d;
            traceLocation8.setLatitude((traceLocation8.getLatitude() * 0.2d) + (aMapLocation.getLatitude() * 0.8d));
            TraceLocation traceLocation9 = this.f19727d;
            traceLocation9.setLongitude((traceLocation9.getLongitude() * 0.2d) + (aMapLocation.getLongitude() * 0.8d));
            this.f19727d.setTime(aMapLocation.getTime());
            this.f19727d.setSpeed(aMapLocation.getSpeed());
            if (this.f19729f.size() > 4) {
                if (this.f19730g > 4) {
                    str = str11 + "w1Count > 4计算增加W1";
                } else {
                    str = str11 + "w1Count < 4计算丢弃W1";
                    this.f19728e.clear();
                }
                String str12 = str + "w2TempList.size() > 4 : 更新到偏移点";
                this.f19729f.clear();
                this.f19726c = this.f19727d;
                this.f19727d = null;
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
