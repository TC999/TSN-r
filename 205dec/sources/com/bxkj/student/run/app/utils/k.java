package com.bxkj.student.run.app.utils;

import androidx.annotation.NonNull;
import com.amap.api.maps.model.LatLng;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LatLngPoint.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class k implements Comparable<k> {

    /* renamed from: a  reason: collision with root package name */
    public int f22879a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f22880b;

    public k(int id, LatLng latLng) {
        this.f22879a = id;
        this.f22880b = latLng;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull k latLngPoint) {
        int i4 = this.f22879a;
        int i5 = latLngPoint.f22879a;
        if (i4 < i5) {
            return -1;
        }
        return i4 > i5 ? 1 : 0;
    }
}
