package com.bxkj.student.run.app.utils;

import androidx.annotation.NonNull;
import com.amap.api.maps.model.LatLng;

/* renamed from: com.bxkj.student.run.app.utils.k */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LatLngPoint implements Comparable<LatLngPoint> {

    /* renamed from: a */
    public int f19649a;

    /* renamed from: b */
    public LatLng f19650b;

    public LatLngPoint(int id, LatLng latLng) {
        this.f19649a = id;
        this.f19650b = latLng;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull LatLngPoint latLngPoint) {
        int i = this.f19649a;
        int i2 = latLngPoint.f19649a;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
