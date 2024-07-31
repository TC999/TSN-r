package com.amap.api.trace;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TraceOverlay {
    public static final int TRACE_STATUS_FAILURE = 3;
    public static final int TRACE_STATUS_FINISH = 2;
    public static final int TRACE_STATUS_PREPARE = 4;
    public static final int TRACE_STATUS_PROCESSING = 1;

    /* renamed from: a */
    private Polyline f7970a;

    /* renamed from: b */
    private PolylineOptions f7971b;

    /* renamed from: c */
    private AMap f7972c;

    /* renamed from: d */
    private List<LatLng> f7973d;

    /* renamed from: e */
    private int f7974e;

    /* renamed from: f */
    private int f7975f;

    /* renamed from: g */
    private int f7976g;

    public TraceOverlay(AMap aMap, List<LatLng> list) {
        this.f7973d = new ArrayList();
        this.f7974e = 4;
        this.f7972c = aMap;
        m51738a();
        this.f7973d = list;
        this.f7971b.addAll(list);
        this.f7970a = aMap.addPolyline(this.f7971b);
    }

    /* renamed from: a */
    private PolylineOptions m51738a() {
        if (this.f7971b == null) {
            PolylineOptions polylineOptions = new PolylineOptions();
            this.f7971b = polylineOptions;
            polylineOptions.setCustomTexture(BitmapDescriptorFactory.fromAsset("tracelinetexture.png"));
            this.f7971b.width(40.0f);
        }
        return this.f7971b;
    }

    public void add(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f7973d.addAll(list);
        m51738a();
        if (this.f7970a == null) {
            this.f7970a = this.f7972c.addPolyline(this.f7971b);
        }
        Polyline polyline = this.f7970a;
        if (polyline != null) {
            polyline.setPoints(this.f7973d);
        }
    }

    public int getDistance() {
        return this.f7975f;
    }

    public int getTraceStatus() {
        return this.f7974e;
    }

    public int getWaitTime() {
        return this.f7976g;
    }

    public void remove() {
        Polyline polyline = this.f7970a;
        if (polyline != null) {
            polyline.remove();
        }
    }

    public void setDistance(int i) {
        this.f7975f = i;
    }

    public void setProperCamera(List<LatLng> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (list == null || list.size() == 0) {
            return;
        }
        for (LatLng latLng : list) {
            builder.include(latLng);
        }
        try {
            this.f7972c.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 20));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTraceStatus(int i) {
        this.f7974e = i;
    }

    public void setWaitTime(int i) {
        this.f7976g = i;
    }

    public void zoopToSpan() {
        setProperCamera(this.f7971b.getPoints());
    }

    public TraceOverlay(AMap aMap) {
        this.f7973d = new ArrayList();
        this.f7974e = 4;
        this.f7972c = aMap;
        m51738a();
    }
}
