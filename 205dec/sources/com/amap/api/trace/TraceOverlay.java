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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TraceOverlay {
    public static final int TRACE_STATUS_FAILURE = 3;
    public static final int TRACE_STATUS_FINISH = 2;
    public static final int TRACE_STATUS_PREPARE = 4;
    public static final int TRACE_STATUS_PROCESSING = 1;

    /* renamed from: a  reason: collision with root package name */
    private Polyline f11664a;

    /* renamed from: b  reason: collision with root package name */
    private PolylineOptions f11665b;

    /* renamed from: c  reason: collision with root package name */
    private AMap f11666c;

    /* renamed from: d  reason: collision with root package name */
    private List<LatLng> f11667d;

    /* renamed from: e  reason: collision with root package name */
    private int f11668e;

    /* renamed from: f  reason: collision with root package name */
    private int f11669f;

    /* renamed from: g  reason: collision with root package name */
    private int f11670g;

    public TraceOverlay(AMap aMap, List<LatLng> list) {
        this.f11667d = new ArrayList();
        this.f11668e = 4;
        this.f11666c = aMap;
        a();
        this.f11667d = list;
        this.f11665b.addAll(list);
        this.f11664a = aMap.addPolyline(this.f11665b);
    }

    private PolylineOptions a() {
        if (this.f11665b == null) {
            PolylineOptions polylineOptions = new PolylineOptions();
            this.f11665b = polylineOptions;
            polylineOptions.setCustomTexture(BitmapDescriptorFactory.fromAsset("tracelinetexture.png"));
            this.f11665b.width(40.0f);
        }
        return this.f11665b;
    }

    public void add(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f11667d.addAll(list);
        a();
        if (this.f11664a == null) {
            this.f11664a = this.f11666c.addPolyline(this.f11665b);
        }
        Polyline polyline = this.f11664a;
        if (polyline != null) {
            polyline.setPoints(this.f11667d);
        }
    }

    public int getDistance() {
        return this.f11669f;
    }

    public int getTraceStatus() {
        return this.f11668e;
    }

    public int getWaitTime() {
        return this.f11670g;
    }

    public void remove() {
        Polyline polyline = this.f11664a;
        if (polyline != null) {
            polyline.remove();
        }
    }

    public void setDistance(int i4) {
        this.f11669f = i4;
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
            this.f11666c.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 20));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTraceStatus(int i4) {
        this.f11668e = i4;
    }

    public void setWaitTime(int i4) {
        this.f11670g = i4;
    }

    public void zoopToSpan() {
        setProperCamera(this.f11665b.getPoints());
    }

    public TraceOverlay(AMap aMap) {
        this.f11667d = new ArrayList();
        this.f11668e = 4;
        this.f11666c = aMap;
        a();
    }
}
